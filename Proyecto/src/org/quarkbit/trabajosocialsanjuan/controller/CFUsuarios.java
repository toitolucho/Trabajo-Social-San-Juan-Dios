package org.quarkbit.trabajosocialsanjuan.controller;

import java.awt.HeadlessException;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.apache.ibatis.session.SqlSession;
import org.quarkbit.trabajosocialsanjuan.dao.Coneccion;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Usuario;
import org.quarkbit.trabajosocialsanjuan.dao.domain.UsuarioExample;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Institucion;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Parentesco;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Persona;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PersonaKardexFamiliar;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Usuario;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.InstitucionMapper;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.PersonaMapper;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.UsuarioMapper;
import org.quarkbit.trabajosocialsanjuan.formularios.FFamiliar;
import org.quarkbit.trabajosocialsanjuan.formularios.FPersonasBuscador;
import org.quarkbit.trabajosocialsanjuan.formularios.FUsuarios;
import org.quarkbit.trabajosocialsanjuan.formularios.tablemodels.ModeloUsuarios;
import org.quarkbit.trabajosocialsanjuan.utils.FormUtilities;

public class CFUsuarios implements ActionListener, ListSelectionListener{

	FUsuarios formUsuarios;
	String tipoOperacion = "";
	Usuario usuarioActual = null;
	Persona personaActual = null;
	private SqlSession session;
	UsuarioMapper daoUsuarioMapper;
	PersonaMapper daoPersonaMapper;
	ModeloUsuarios modeloUsuario;
	InstitucionMapper daoInstitucionMapper;
	private boolean personaNueva;
	
	public CFUsuarios (FUsuarios formUsuarios)
	{
		this.formUsuarios = formUsuarios;
		session = Coneccion.getSqlSessionFactory().openSession();
		
		daoUsuarioMapper = session.getMapper(UsuarioMapper.class);
		daoPersonaMapper = session.getMapper(PersonaMapper.class);
		daoInstitucionMapper = session.getMapper(InstitucionMapper.class);
		modeloUsuario = new ModeloUsuarios();
	}
	
	public void limpiarControles()
	{
		formUsuarios.getTxtCodigo().setText("");
		formUsuarios.getTxtNombreCompleto().setText("");
		formUsuarios.getTxtNombreCuenta().setText("");
		formUsuarios.getTxtPassword().setText("");
		
		formUsuarios.getcBoxEstado().setSelectedIndex(-1);
		formUsuarios.getcBoxInstitucion().setSelectedIndex(-1);
		
		formUsuarios.getDateFechaRegistro().setDate(null);
	}
	
	public void habilitarControles(boolean estadoHabilitacion)
	{
//		formUsuarios.getTxtCodigo().setText("");
//		formUsuarios.getTxtNombreCompleto().setEditable(estadoHabilitacion);
		formUsuarios.getTxtNombreCuenta().setEditable(estadoHabilitacion);
		formUsuarios.getTxtPassword().setEditable(estadoHabilitacion);
		
		formUsuarios.getcBoxEstado().setEnabled(estadoHabilitacion);
		formUsuarios.getcBoxInstitucion().setEnabled(estadoHabilitacion);
		
		formUsuarios.getDateFechaRegistro().setEnabled(estadoHabilitacion);
		formUsuarios.getBtnAgregarPersona().setEnabled(estadoHabilitacion);
		formUsuarios.getBtnBuscarPersona().setEnabled(estadoHabilitacion);
	}
	
	public void mostrarParaInsercionListado(Usuario Usuario, boolean lista)
	{
		if(Usuario != null) //para edicion
		{
			tipoOperacion = "E";
		}
		else
		{
			tipoOperacion = "I";
		}
		personaNueva = false;
		limpiarControles();
		habilitarControles(true);
		habilitarBotones(false, true, false, false, false);
//		formUsuario.mostrorSoloControles(lista);
		FormUtilities.centrar(formUsuarios);
	}
	
	public boolean validarControles()
	{
		if(formUsuarios.getTxtNombreCompleto().getText().isEmpty())
		{
			JOptionPane.showMessageDialog(formUsuarios, "A\u00FAn no ha seleccionado la persona", "Usuarios", JOptionPane.ERROR_MESSAGE);
			formUsuarios.getTxtNombreCompleto().grabFocus();
			return false;
		}
		
		if(formUsuarios.getDateFechaRegistro().getDate() == null)
		{
			JOptionPane.showMessageDialog(formUsuarios, "A\u00FAn no ha seleccionado la fecha de registro", "Usuarios", JOptionPane.ERROR_MESSAGE);
			formUsuarios.getDateFechaRegistro().grabFocus();
			return false;
		}
		
		if(formUsuarios.getcBoxInstitucion().getSelectedIndex() < 0)
		{
			JOptionPane.showMessageDialog(formUsuarios, "A\u00FAn no ha seleccionado la institucion", "Usuarios", JOptionPane.ERROR_MESSAGE);
			formUsuarios.getcBoxInstitucion().grabFocus();
			return false;
		}
		
		if(formUsuarios.getcBoxEstado().getSelectedIndex() < 0)
		{
			JOptionPane.showMessageDialog(formUsuarios, "A\u00FAn no ha seleccionado el estado del Usuario", "Usuarios", JOptionPane.ERROR_MESSAGE);
			formUsuarios.getcBoxEstado().grabFocus();
			return false;
		}
		
		if(formUsuarios.getTxtNombreCuenta().getText().trim().isEmpty())
		{
			JOptionPane.showMessageDialog(formUsuarios, "A\u00FAn no ha ingresado el nombre del usuario", "Usuario", JOptionPane.ERROR_MESSAGE);
			formUsuarios.getTxtNombreCuenta().grabFocus();
			return false;
		}
		
		if(formUsuarios.getTxtPassword().getText().trim().isEmpty())
		{
			JOptionPane.showMessageDialog(formUsuarios, "A\u00FAn no ha ingresado la contrasenia", "Usuario", JOptionPane.ERROR_MESSAGE);
			formUsuarios.getTxtPassword().grabFocus();
			return false;
		}
		
		
		UsuarioExample filtro = new UsuarioExample();
		filtro.or().andNombreUsuarioEqualTo(formUsuarios.getTxtNombreCuenta().getText().toUpperCase());
		if(tipoOperacion.compareTo("I") == 0 && daoUsuarioMapper.countByExample(filtro) > 0)
		{
			JOptionPane.showMessageDialog(formUsuarios, "El nombre de la cuenta de Usuario ya se encuentra registrada", "Categoria Usuario", JOptionPane.ERROR_MESSAGE);
			formUsuarios.getTxtNombreCuenta().grabFocus();
			return false;
		}
		return true;
	}
	
	public void habilitarBotones(boolean nuevo, boolean aceptar, boolean cancelar,
			boolean modificar, boolean eliminar)
	{
		formUsuarios.getBtnAceptar().setEnabled(aceptar);
		formUsuarios.getBtnNuevo().setEnabled(nuevo);
		formUsuarios.getBtnCancelar().setEnabled(cancelar);
		formUsuarios.getBtnModificar().setEnabled(modificar);
		formUsuarios.getBtnEliminar().setEnabled(eliminar);
	}
	
	public void cargarDatos(Usuario usuarioAux)
	{
		if(usuarioAux != null)
		{
			this.usuarioActual = usuarioAux;
			
			
			formUsuarios.getTxtCodigo().setText(String.valueOf(usuarioAux.getCodigoUsuario()));
			if(usuarioAux.getPersona() != null)
			{
				formUsuarios.getTxtNombreCompleto().setText(usuarioAux.getPersona().obtenerNombreCompleto());
				personaActual = usuarioAux.getPersona();
				personaActual.setCodigoPersona(usuarioAux.getCodigoPersona());
			}
			else
				formUsuarios.getTxtNombreCompleto().setText("");
			
			formUsuarios.getTxtNombreCuenta().setText(usuarioAux.getNombreUsuario());
			formUsuarios.getTxtPassword().setText(usuarioAux.getContrasenia());
			
			formUsuarios.getcBoxEstado().setSelectedItem(usuarioAux.getTipo());
			if(usuarioAux.getInstitucion() != null)
				formUsuarios.getcBoxInstitucion().getModel().setSelectedItem(usuarioAux.getInstitucion());
			else
				formUsuarios.getcBoxInstitucion().setSelectedIndex(-1);
			
			formUsuarios.getDateFechaRegistro().setDate(usuarioAux.getFechaRegistro());
			
			System.out.println("codigo persona " + personaActual.getCodigoPersona());
			habilitarBotones(true, false, true, true, true);
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().compareTo("Nuevo")== 0)
		{
			limpiarControles();
			habilitarControles(true);
			habilitarBotones(false, true, true, false, false);
			tipoOperacion = "I";
			personaNueva = false;
		}
		if(e.getActionCommand().compareTo("Cancelar")== 0)
		{
			limpiarControles();
			habilitarControles(false);
			habilitarBotones(true, false, false, false, false);
			tipoOperacion = "";
			personaNueva = false;
		}
		if(e.getActionCommand().compareTo("Modificar")== 0)
		{
			habilitarControles(true);
			habilitarBotones(false, true, true, false, false);
			tipoOperacion = "E";
		}
		
		if(e.getActionCommand().compareTo("Eliminar")== 0)
		{
			if(JOptionPane.showConfirmDialog(formUsuarios, "¿Se encuentra seguro de eliminar el registro actual?", "Usuarios", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			{
				try {
					System.out.println("Elemento a eliminar " + Integer.parseInt(formUsuarios.getTxtCodigo().getText()));
					
					modeloUsuario.eliminarUsuario(formUsuarios.getTable().getSelectedRow());
					
					
					daoUsuarioMapper.deleteByPrimaryKey(Integer.parseInt(formUsuarios.getTxtCodigo().getText()));
					
					session.commit();
					
					limpiarControles();
					JOptionPane.showMessageDialog(formUsuarios, "Objeto eliminado correctamente", "Usuario", JOptionPane.INFORMATION_MESSAGE);
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(formUsuarios, "No se puede eliminar el registro, probablemente el usuario es participe de otras transacciones", "Usuario", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
		if(e.getActionCommand().compareTo("AgregarPersona")== 0)
		{
			FFamiliar formfamiliares =new FFamiliar(null);
//			formfamiliares.control.mostrarParaInsercionListado(null, true);
			formfamiliares.HabilitarRegistroPersonas();
			formfamiliares.setVisible(true);
			if(formfamiliares.personaActual != null && !formfamiliares.personaActual.getNombres().isEmpty())
			{	
				formfamiliares.personaKardexFamiliar.setFechaRegistro(Calendar.getInstance().getTime());
				formfamiliares.personaKardexFamiliar.setObservaciones(formfamiliares.getPnlPersonas().getTxtObservaciones().getText());
				personaActual = formfamiliares.personaActual;
				formUsuarios.getTxtNombreCompleto().setText(personaActual.obtenerNombreCompleto());
				personaNueva = true;
			}
			else
			{
				JOptionPane.showMessageDialog(formfamiliares, "No ha seleccionado ning\u00FAn elemento o el Elemento seleccionado ya se encuentra en la lista", "Kardex de Personas", JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if(e.getActionCommand().compareTo("BuscarPersona")== 0)
		{
			JOptionPane.showMessageDialog(formUsuarios, "Seleccione una persona con la cual se vincular\u00E1 el usuario actual ingresado el nombre de la persona en la cajita de Texto", "Usuarios", JOptionPane.INFORMATION_MESSAGE);
			FPersonasBuscador formfamiliares =new FPersonasBuscador(null);
			formfamiliares.control.setTipoPersona("U");
//			formfamiliares.control.mostrarParaInsercionListado(null, true);
			formfamiliares.setVisible(true);
			if(formfamiliares.control.personaActual != null && formfamiliares.control.personaActual.obtenerNombreCompleto().compareTo("null") != 0)
			{
				personaActual = formfamiliares.control.personaActual;
				formUsuarios.getTxtNombreCompleto().setText(personaActual.obtenerNombreCompleto());
				personaNueva = false;
			}
			else
			{
				JOptionPane.showMessageDialog(formUsuarios, "No ha seleccionado ning\u00FAn elemento o el Elemento seleccionado ya se encuentra en la lista", "Kardex de Personas", JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if(e.getActionCommand().compareTo("Cerrar")== 0)
		{
			this.formUsuarios.setVisible(false);
		}
		
		if(e.getActionCommand().compareTo("Aceptar")== 0)
		{
			if(validarControles())
			{
				try {
					usuarioActual = new Usuario();
					usuarioActual.setCodigoInstitucion(((Institucion)formUsuarios.getcBoxInstitucion().getSelectedItem()).getCodigoInstitucion());
					usuarioActual.setFechaRegistro(formUsuarios.getDateFechaRegistro().getDate());
					usuarioActual.setNombreUsuario(formUsuarios.getTxtNombreCuenta().getText());
					usuarioActual.setContrasenia(formUsuarios.getTxtPassword().getText());
					usuarioActual.setTipo( formUsuarios.getcBoxEstado().getSelectedItem().toString());
					usuarioActual.setCodigoPersona(personaActual.getCodigoPersona());
					
					
					if(tipoOperacion.compareTo("I") == 0)
					{
						personaActual.setCodigoTipoPersona("U");
						Map<String, Integer> mapa;
						if(personaNueva)
						{
							daoPersonaMapper.insert(personaActual);
							session.commit();
							mapa = new HashMap<String, Integer>();
							mapa.put("ultimoId", 0);
							daoPersonaMapper.obtenerUltimoId(mapa); //("myMappedStatement",myParams);
							personaActual.setCodigoPersona( mapa.get("ultimoId"));						
							
						}
						
						
						usuarioActual.setCodigoPersona(personaActual.getCodigoPersona());
						usuarioActual.setPersona(personaActual);
						
						daoUsuarioMapper.insert(usuarioActual);
						
						
						session.commit();
						
						mapa = new HashMap<String, Integer>();
						mapa.put("ultimoId", 0);
						daoUsuarioMapper.obtenerUltimoId(mapa); //("myMappedStatement",myParams);
						usuarioActual.setCodigoUsuario(mapa.get("ultimoId"));
						
						modeloUsuario.AnadirUsuario(usuarioActual);
					}
					else
					{
						System.out.println("codigo persona " + personaActual.getCodigoPersona());
						usuarioActual.setCodigoPersona(personaActual.getCodigoPersona());
						usuarioActual.setPersona(personaActual);						
						modeloUsuario.setUsuario(formUsuarios.getTable().getSelectedRow(), usuarioActual);
						usuarioActual.setCodigoUsuario(Integer.parseInt(formUsuarios.getTxtCodigo().getText()));
//						
						daoUsuarioMapper.updateByPrimaryKey(usuarioActual);
						session.commit();
					}
					
					habilitarControles(false);
					habilitarBotones(true, false, false, true, true);
					JOptionPane.showMessageDialog(formUsuarios, "Registro almacenado correctamenteo", "Usuarios", JOptionPane.INFORMATION_MESSAGE);
					
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(formUsuarios, "Ocurri\u00F3 la siguiente excepcion " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
			
		}
	}
	
	public void onFormShown()
	{
		formUsuarios.getTable().setModel(modeloUsuario);
		
		modeloUsuario.setListUsuario(daoUsuarioMapper.selectByExample(null));
		formUsuarios.getTable().getSelectionModel().addListSelectionListener(this);
		for (Institucion inst : daoInstitucionMapper.selectByExample(null)) {
			formUsuarios.getcBoxInstitucion().addItem(inst);
		}
		
		
		limpiarControles();
		habilitarControles(false);
		habilitarBotones(true, false, false, false, false);
		formUsuarios.getTxtCodigo().setEditable(false);
		
		formUsuarios.getBtnAceptar().addActionListener(this);
		formUsuarios.getBtnAgregarPersona().addActionListener(this);
		formUsuarios.getBtnBuscarPersona().addActionListener(this);
		formUsuarios.getBtnCancelar().addActionListener(this);
		formUsuarios.getBtnCerrar().addActionListener(this);
		formUsuarios.getBtnEliminar().addActionListener(this);
		formUsuarios.getBtnModificar().addActionListener(this);
		formUsuarios.getBtnNuevo().addActionListener(this);
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if(e.getValueIsAdjusting())
			return;
		int indice = ((ListSelectionModel) e.getSource()).getMinSelectionIndex();
		cargarDatos(modeloUsuario.obtenerUsuario(indice));
	}

}
