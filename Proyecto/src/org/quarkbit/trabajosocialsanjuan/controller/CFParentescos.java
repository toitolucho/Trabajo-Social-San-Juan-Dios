package org.quarkbit.trabajosocialsanjuan.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.html.FormView;

import org.apache.ibatis.session.SqlSession;
import org.quarkbit.trabajosocialsanjuan.dao.Coneccion;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Parentesco;
import org.quarkbit.trabajosocialsanjuan.dao.domain.ParentescoExample;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.ParentescoMapper;
import org.quarkbit.trabajosocialsanjuan.formularios.FParentescos;
import org.quarkbit.trabajosocialsanjuan.formularios.tablemodels.ModeloParentesco;
import org.quarkbit.trabajosocialsanjuan.utils.FormUtilities;

public class CFParentescos implements ActionListener, ListSelectionListener {
	
	FParentescos formParentesco;
	SqlSession session;
	ParentescoMapper daoParentescoMapper;
	ModeloParentesco modeloParentesco;
	String tipoOperacion = "";
	Parentesco parentescoActual;
	private int codigoUsuario = 1;
	private int codigoInstitucion = 1;
	
	public CFParentescos(FParentescos formParentesco)
	{
		this.formParentesco = formParentesco;
		parentescoActual = new Parentesco();
	}
	
	public void onLoad()
	{
		session = Coneccion.getSqlSessionFactory().openSession();
		daoParentescoMapper = session.getMapper(ParentescoMapper.class);
		modeloParentesco = new ModeloParentesco();
		
		formParentesco.getjTableParentesco().setModel(modeloParentesco);
		formParentesco.getTxtCodigo().setEnabled(false);	
		
		formParentesco.getBtnAceptar().addActionListener(this);
		formParentesco.getBtnNuevo().addActionListener(this);
		formParentesco.getBtnCancelar().addActionListener(this);
		formParentesco.getBtnModificar().addActionListener(this);
		formParentesco.getBtnEliminar().addActionListener(this);
		formParentesco.getBtnCerrar().addActionListener(this);
		
		
		habilitarControles(false);
		habilitarBotones(true, false, false, false, false);
		modeloParentesco.setListParentesco(daoParentescoMapper.selectByExample(null));
		formParentesco.getjTableParentesco().getSelectionModel().addListSelectionListener(this);
		formParentesco.getjTableParentesco().getColumn("Codigo").setPreferredWidth(5);
		FormUtilities.centrar(formParentesco);
//		mostrarParaInsercion(null);
	}
	
	public void mostrarParaInsercion(Parentesco parentesco)
	{
		if(parentesco != null) //para edicion
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
		formParentesco.mostrorSoloControles();
	}
	
	public void limpiarControles()
	{
		formParentesco.getTxtCodigo().setText("");
		formParentesco.getTxtDescripcion().setText("");
		formParentesco.getTxtNombre().setText("");
	}
	
	public void habilitarControles(boolean estadHabilitacion)
	{
		formParentesco.getTxtNombre().setEnabled(estadHabilitacion);
		formParentesco.getTxtDescripcion().setEnabled(estadHabilitacion);
//		formParentesco.getjTableParentesco().setEnabled(estadHabilitacion);
	}
	
	public boolean validarControles()
	{
		if(formParentesco.getTxtNombre().getText().trim().isEmpty())
		{
			JOptionPane.showMessageDialog(formParentesco, "A\u00FAn no ha ingresado el nombre del Parentesco", "Parentesco", JOptionPane.ERROR_MESSAGE);
			formParentesco.getTxtNombre().grabFocus();
			return false;
		}
		ParentescoExample filtro = new ParentescoExample();
		filtro.or().andNombreParentescoEqualTo(formParentesco.getTxtNombre().getText().toUpperCase());
		if(tipoOperacion.compareTo("I") == 0 && daoParentescoMapper.countByExample(filtro) > 0)
		{
			JOptionPane.showMessageDialog(formParentesco, "El nombre del Parentesco ya se encuentra registrado", "Parentesco", JOptionPane.ERROR_MESSAGE);
			formParentesco.getTxtNombre().grabFocus();
			return false;
		}
		return true;
	}
	
	public void habilitarBotones(boolean nuevo, boolean aceptar, boolean cancelar,
			boolean modificar, boolean eliminar)
	{
		formParentesco.getBtnAceptar().setEnabled(aceptar);
		formParentesco.getBtnNuevo().setEnabled(nuevo);
		formParentesco.getBtnCancelar().setEnabled(cancelar);
		formParentesco.getBtnModificar().setEnabled(modificar);
		formParentesco.getBtnEliminar().setEnabled(eliminar);
	}
	
	public void cargarDatos(Parentesco parentescoAux)
	{
		if(parentescoAux != null)
		{
			parentescoActual = parentescoAux;
			formParentesco.getTxtCodigo().setText(parentescoAux.getCodigoParentesco().toString());
			formParentesco.getTxtNombre().setText(parentescoAux.getNombreParentesco());
			formParentesco.getTxtDescripcion().setText(parentescoAux.getDescripcion());
			habilitarBotones(true, false, true, true, true);
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(formParentesco.getBtnAceptar().equals(event.getSource()))
		{
			if(validarControles())
			{
				try {
					parentescoActual = new Parentesco();
					parentescoActual.setCodigoParentesco(-1);
					parentescoActual.setNombreParentesco(formParentesco.getTxtNombre().getText().toUpperCase());
					parentescoActual.setDescripcion(formParentesco.getTxtDescripcion().getText());
					if(tipoOperacion.compareTo("I")==0)
					{
						daoParentescoMapper.insert(parentescoActual);
						session.commit();
						
						Map<String, Integer> mapa = new HashMap<String, Integer>();
						mapa.put("ultimoId", 0);
						daoParentescoMapper.obtenerUltimoId(mapa); //("myMappedStatement",myParams);
						parentescoActual.setCodigoParentesco(mapa.get("ultimoId"));
						
//					System.out.println("codigo actual = " + parentescoActual.getCodigoParentesco());
						modeloParentesco.AnadirParentesco(parentescoActual);
					}
					else
					{
						modeloParentesco.setParentesco(formParentesco.getjTableParentesco().getSelectedRow(), parentescoActual);
						parentescoActual.setCodigoParentesco(Integer.parseInt(formParentesco.getTxtCodigo().getText()));
						daoParentescoMapper.updateByPrimaryKey(parentescoActual);
						session.commit();
						
						
					}
					
					if(!formParentesco.getBtnNuevo().isVisible())
					{
						
						formParentesco.setVisible(false);
						formParentesco.dispose();
						return;
					}
					tipoOperacion ="";
					habilitarBotones(true, false, false, true, true);
					habilitarControles(false);
					JOptionPane.showMessageDialog(formParentesco, "Se almacen\u00F3 correctamente el registro actual", "Parentescos", JOptionPane.INFORMATION_MESSAGE);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(formParentesco, "Ocurri\u00F3 la siguiente excepcion " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}
		if(formParentesco.getBtnNuevo().equals(event.getSource()))
		{
			habilitarBotones(false, true, true, false, false);
			habilitarControles(true);
			limpiarControles();
			tipoOperacion = "I";
			formParentesco.getjTableParentesco().clearSelection();
		}
		if(formParentesco.getBtnCerrar().equals(event.getSource()))
		{
			formParentesco.setVisible(false);
			formParentesco.dispose();
			
		}
		if(formParentesco.getBtnModificar().equals(event.getSource()))
		{
			habilitarBotones(false, true, true, false, false);
			habilitarControles(true);			
			tipoOperacion = "E";
			
		}
		if(formParentesco.getBtnEliminar().equals(event.getSource()))
		{
			if(JOptionPane.showConfirmDialog(formParentesco, "¿Se encuentra seguro de eliminar el registro actual?", "Parentescos", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			{
				System.out.println("Elemento a eliminar " + Integer.parseInt(formParentesco.getTxtCodigo().getText()));
				
				modeloParentesco.eliminarParentesco(formParentesco.getjTableParentesco().getSelectedRow());
				
				
				daoParentescoMapper.deleteByPrimaryKey(Integer.parseInt(formParentesco.getTxtCodigo().getText()));
				
				session.commit();
				
				limpiarControles();
				habilitarBotones(true, false, false, false, false);
				JOptionPane.showMessageDialog(formParentesco, "Objeto eliminado correctamente", "Parentesco", JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
		
		if(formParentesco.getBtnCancelar().equals(event.getSource()))
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
		cargarDatos(modeloParentesco.obtenerParentesco(indice));
		
	}

	public int getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public int getCodigoInstitucion() {
		return codigoInstitucion;
	}

	public void setCodigoInstitucion(int codigoInstitucion) {
		this.codigoInstitucion = codigoInstitucion;
	}

}
