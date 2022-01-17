package org.quarkbit.trabajosocialsanjuan.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.apache.ibatis.session.SqlSession;
import org.quarkbit.trabajosocialsanjuan.dao.Coneccion;
import org.quarkbit.trabajosocialsanjuan.dao.domain.InstitucionExample;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Institucion;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.InstitucionMapper;
import org.quarkbit.trabajosocialsanjuan.formularios.FInstituciones;
import org.quarkbit.trabajosocialsanjuan.formularios.tablemodels.ModeloInstituciones;

import org.quarkbit.trabajosocialsanjuan.utils.FormUtilities;

public class CFInstituciones implements ActionListener, ListSelectionListener {
	
	FInstituciones formInstitucion;
	SqlSession session;
	InstitucionMapper daoInstitucionMapper;
	ModeloInstituciones modeloInstitucion;
	String tipoOperacion = "";
	Institucion institucionActual;
	
	public CFInstituciones(FInstituciones formInstitucion)
	{
		this.formInstitucion = formInstitucion;
		institucionActual = new Institucion();
	}
	
	public void onLoad()
	{
		session = Coneccion.getSqlSessionFactory().openSession();
		daoInstitucionMapper = session.getMapper(InstitucionMapper.class);
		modeloInstitucion = new ModeloInstituciones();
		
		formInstitucion.getjTableInstitucion().setModel(modeloInstitucion);
		formInstitucion.getTxtCodigo().setEnabled(false);	
		
		formInstitucion.getBtnAceptar().addActionListener(this);
		formInstitucion.getBtnNuevo().addActionListener(this);
		formInstitucion.getBtnCancelar().addActionListener(this);
		formInstitucion.getBtnModificar().addActionListener(this);
		formInstitucion.getBtnEliminar().addActionListener(this);
		formInstitucion.getBtnCerrar().addActionListener(this);
		
		
		habilitarControles(false);
		habilitarBotones(true, false, false, false, false);
		modeloInstitucion.setListInstitucion(daoInstitucionMapper.selectByExample(null));
		formInstitucion.getjTableInstitucion().getSelectionModel().addListSelectionListener(this);
		formInstitucion.getjTableInstitucion().getColumn("Codigo").setPreferredWidth(5);
		FormUtilities.centrar(formInstitucion);
//		mostrarParaInsercion(null);
	}
	
	public void mostrarParaInsercion(Institucion Institucion)
	{
		if(Institucion != null) //para edicion
		{
			tipoOperacion = "E";
		}
		else
		{
			tipoOperacion = "I";
		}
		
		limpiarControles();
		habilitarControles(true);
		habilitarBotones(false, true, false, false, false);
		formInstitucion.mostrorSoloControles();
	}
	
	public void limpiarControles()
	{
		formInstitucion.getTxtCodigo().setText("");
		formInstitucion.getTxtDescripcion().setText("");
		formInstitucion.getTxtNombre().setText("");
		formInstitucion.getTxtTelefono().setText("");
		formInstitucion.getTxtDireccion().setText("");
	}
	
	public void habilitarControles(boolean estadHabilitacion)
	{
		formInstitucion.getTxtNombre().setEnabled(estadHabilitacion);
		formInstitucion.getTxtDescripcion().setEnabled(estadHabilitacion);
		formInstitucion.getTxtTelefono().setEnabled(estadHabilitacion);
		formInstitucion.getTxtDireccion().setEnabled(estadHabilitacion);
//		formInstitucion.getjTableInstitucion().setEnabled(estadHabilitacion);
	}
	
	public boolean validarControles()
	{
		if(formInstitucion.getTxtNombre().getText().trim().isEmpty())
		{
			JOptionPane.showMessageDialog(formInstitucion, "A\u00FAn no ha ingresado el nombre del Institucion", "Institucion", JOptionPane.ERROR_MESSAGE);
			formInstitucion.getTxtNombre().grabFocus();
			return false;
		}
		InstitucionExample filtro = new InstitucionExample();
		filtro.or().andNombreInstitucionEqualTo(formInstitucion.getTxtNombre().getText().toUpperCase());
		if(tipoOperacion.compareTo("I") == 0 && daoInstitucionMapper.countByExample(filtro) > 0)
		{
			JOptionPane.showMessageDialog(formInstitucion, "El nombre de la Institucion ya se encuentra registrada", "Categoria Institucion", JOptionPane.ERROR_MESSAGE);
			formInstitucion.getTxtNombre().grabFocus();
			return false;
		}
		return true;
	}
	
	public void habilitarBotones(boolean nuevo, boolean aceptar, boolean cancelar,
			boolean modificar, boolean eliminar)
	{
		formInstitucion.getBtnAceptar().setEnabled(aceptar);
		formInstitucion.getBtnNuevo().setEnabled(nuevo);
		formInstitucion.getBtnCancelar().setEnabled(cancelar);
		formInstitucion.getBtnModificar().setEnabled(modificar);
		formInstitucion.getBtnEliminar().setEnabled(eliminar);
	}
	
	public void cargarDatos(Institucion institucionAux)
	{
		if(institucionAux != null)
		{
			institucionActual = institucionAux;
			formInstitucion.getTxtCodigo().setText(institucionAux.getCodigoInstitucion().toString());
			formInstitucion.getTxtNombre().setText(institucionAux.getNombreInstitucion());
			formInstitucion.getTxtDescripcion().setText(institucionAux.getDescripcion());
			formInstitucion.getTxtDireccion().setText(institucionAux.getDireccion());
			formInstitucion.getTxtTelefono().setText(institucionAux.getTelefono());
			habilitarBotones(true, false, true, true, true);
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(formInstitucion.getBtnAceptar().equals(event.getSource()))
		{
			if(validarControles())
			{
				try {
					institucionActual = new Institucion();
					institucionActual.setCodigoInstitucion(-1);
					institucionActual.setNombreInstitucion(formInstitucion.getTxtNombre().getText().toUpperCase());
					institucionActual.setDescripcion(formInstitucion.getTxtDescripcion().getText());
					institucionActual.setDireccion(formInstitucion.getTxtDireccion().getText());
					institucionActual.setTelefono(formInstitucion.getTxtTelefono().getText());
					if(tipoOperacion.compareTo("I")==0)
					{
						daoInstitucionMapper.insert(institucionActual);
						session.commit();
						
						Map<String, Integer> mapa = new HashMap<String, Integer>();
						mapa.put("ultimoId", 0);
						daoInstitucionMapper.obtenerUltimoId(mapa); //("myMappedStatement",myParams);
						institucionActual.setCodigoInstitucion(mapa.get("ultimoId"));
						
//					System.out.println("codigo actual = " + InstitucionActual.getCodigoInstitucion());
						modeloInstitucion.AnadirInstitucion(institucionActual);
					}
					else
					{
						modeloInstitucion.setInstitucion(formInstitucion.getjTableInstitucion().getSelectedRow(), institucionActual);
						institucionActual.setCodigoInstitucion(Integer.parseInt(formInstitucion.getTxtCodigo().getText()));
						daoInstitucionMapper.updateByPrimaryKey(institucionActual);
						session.commit();
						
						
					}
					
					if(!formInstitucion.getBtnNuevo().isVisible())
					{
						
						formInstitucion.setVisible(false);
						formInstitucion.dispose();
						return;
					}
					tipoOperacion ="";
					habilitarBotones(true, false, false, true, true);
					habilitarControles(false);
					JOptionPane.showMessageDialog(formInstitucion, "Se almacen\u00F3 correctamente el registro actual", "Instituciones", JOptionPane.INFORMATION_MESSAGE);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(formInstitucion, "Ocurri\u00F3 la siguiente excepcion " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}
		if(formInstitucion.getBtnNuevo().equals(event.getSource()))
		{
			habilitarBotones(false, true, true, false, false);
			habilitarControles(true);
			limpiarControles();
			tipoOperacion = "I";
			formInstitucion.getjTableInstitucion().clearSelection();
		}
		if(formInstitucion.getBtnCerrar().equals(event.getSource()))
		{
			formInstitucion.setVisible(false);
			formInstitucion.dispose();
			
		}
		if(formInstitucion.getBtnModificar().equals(event.getSource()))
		{
			habilitarBotones(false, true, true, false, false);
			habilitarControles(true);			
			tipoOperacion = "E";
			
		}
		if(formInstitucion.getBtnEliminar().equals(event.getSource()))
		{
			if(JOptionPane.showConfirmDialog(formInstitucion, "¿Se encuentra seguro de eliminar el registro actual?", "Institucions", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			{
				System.out.println("Elemento a eliminar " + Integer.parseInt(formInstitucion.getTxtCodigo().getText()));
				
				modeloInstitucion.eliminarInstitucion(formInstitucion.getjTableInstitucion().getSelectedRow());
				
				
				daoInstitucionMapper.deleteByPrimaryKey(Integer.parseInt(formInstitucion.getTxtCodigo().getText()));
				
				session.commit();
				
				limpiarControles();
				habilitarBotones(true, false, false, false, false);
				JOptionPane.showMessageDialog(formInstitucion, "Objeto eliminado correctamente", "Institucion", JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
		
		if(formInstitucion.getBtnCancelar().equals(event.getSource()))
		{
			limpiarControles();
			habilitarControles(false);
			habilitarBotones(true, false, false, false, false);
			tipoOperacion = "";
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if(e.getValueIsAdjusting())
			return;
		int indice = ((ListSelectionModel) e.getSource()).getMinSelectionIndex();
		cargarDatos(modeloInstitucion.obtenerInstitucion(indice));
		
	}

}
