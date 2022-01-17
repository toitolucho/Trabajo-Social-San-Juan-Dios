package org.quarkbit.trabajosocialsanjuan.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


import org.apache.ibatis.session.SqlSession;
import org.quarkbit.trabajosocialsanjuan.dao.Coneccion;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Ingreso;
import org.quarkbit.trabajosocialsanjuan.dao.domain.IngresoTipo;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.IngresoMapper;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.IngresoTipoMapper;
import org.quarkbit.trabajosocialsanjuan.formularios.FIngresos;
import org.quarkbit.trabajosocialsanjuan.formularios.tablemodels.ModeloIngresos;
import org.quarkbit.trabajosocialsanjuan.utils.FormUtilities;

public class CFIngresos implements ActionListener, ListSelectionListener, KeyListener {
	
	FIngresos formIngreso;
	SqlSession session;
	IngresoMapper daoIngresoMapper;
	IngresoTipoMapper daoIngresoTipoMapper;
	ModeloIngresos modeloIngreso;
	String tipoOperacion = "";
	Ingreso ingresoActual;
	int codigoUsuario = 1;
	
	public CFIngresos(FIngresos formIngresosCategorias)
	{
		this.formIngreso = formIngresosCategorias;
		ingresoActual = new Ingreso();
	}
	
	public void onLoad()
	{
		session = Coneccion.getSqlSessionFactory().openSession();
		daoIngresoMapper = session.getMapper(IngresoMapper.class);
		daoIngresoTipoMapper = session.getMapper(IngresoTipoMapper.class);
		modeloIngreso = new ModeloIngresos();
		
		formIngreso.getjTableIngreso().setModel(modeloIngreso);
		formIngreso.getTxtCodigo().setEnabled(false);	
		
		formIngreso.getBtnAceptar().addActionListener(this);
		formIngreso.getBtnNuevo().addActionListener(this);
		formIngreso.getBtnCancelar().addActionListener(this);
		formIngreso.getBtnModificar().addActionListener(this);
		formIngreso.getBtnEliminar().addActionListener(this);
		formIngreso.getBtnCerrar().addActionListener(this);
		formIngreso.getTxtMonto().addKeyListener(this);
		
		
		habilitarControles(false);
		habilitarBotones(true, false, false, false, false);
		modeloIngreso.setListIngreso(daoIngresoMapper.selectByExample(null));
		formIngreso.getjTableIngreso().getSelectionModel().addListSelectionListener(this);
//		formIngreso.getjTableIngreso().getColumn("Codigo").setPreferredWidth(5);
		FormUtilities.centrar(formIngreso);
		for (IngresoTipo tipo : daoIngresoTipoMapper.selectByExample(null)) {
			formIngreso.getcBoxIngresoTipo().addItem(tipo);
		}
		
		formIngreso.getTxtSaldo().setEditable(false);
//		mostrarParaInsercion(null);
	}
	
	public void mostrarParaInsercion(Ingreso ing4reso)
	{
		limpiarControles();
		if(ing4reso != null) //para edicion
		{
			tipoOperacion = "E";
			cargarDatos(ing4reso);
		}
		else
		{
			tipoOperacion = "I";
			
			Map<String, Date> mapa = new HashMap<String, Date>();
			mapa.put("fechaHoraServidor", null);
			daoIngresoMapper.obtenerFechaHoraServidor(mapa); //("myMappedStatement",myParams);
			
			formIngreso.getDateFechaRegistro().setDate(mapa.get( "fechaHoraServidor"));
		}
		
		
		habilitarControles(true);
		habilitarBotones(false, true, false, false, false);
		formIngreso.mostrorSoloControles();
	}
	
	public void limpiarControles()
	{
		formIngreso.getTxtCodigo().setText("");
		formIngreso.getTxtDescripcion().setText("");
		formIngreso.getTxtNombre().setText("");
		formIngreso.getDateFechaRegistro().setDate(null);
		formIngreso.getTxtMonto().setText("");
		formIngreso.getTxtSaldo().setText("");
		formIngreso.getcBoxIngresoTipo().setSelectedIndex(-1);
	}
	
	public void habilitarControles(boolean estadHabilitacion)
	{
		formIngreso.getDateFechaRegistro().setEnabled(estadHabilitacion);
		formIngreso.getTxtDescripcion().setEnabled(estadHabilitacion);
		formIngreso.getTxtMonto().setEnabled(estadHabilitacion);
		formIngreso.getTxtNombre().setEnabled(estadHabilitacion);
//		formIngreso.getTxtSaldo().setEnabled(estadHabilitacion);
		formIngreso.getcBoxIngresoTipo().setEnabled(estadHabilitacion);
//		formIngreso.getjTableIngreso().setEnabled(estadHabilitacion);
	}
	
	public boolean validarControles()
	{
		if(formIngreso.getTxtNombre().getText().trim().isEmpty())
		{
			JOptionPane.showMessageDialog(formIngreso, "A\u00FAn no ha ingresado el nombre del Ingreso", "Ingreso", JOptionPane.ERROR_MESSAGE);
			formIngreso.getTxtNombre().grabFocus();
			return false;
		}
		if(formIngreso.getDateFechaRegistro().getDate() == null)
		{
			JOptionPane.showMessageDialog(formIngreso, "A\u00FAn no ha ingresado la fecha de Registro", "Ingreso", JOptionPane.ERROR_MESSAGE);
			formIngreso.getDateFechaRegistro().grabFocus();
			return false;
		}
		if(formIngreso.getTxtMonto().getText().trim().isEmpty())
		{
			JOptionPane.showMessageDialog(formIngreso, "A\u00FAn no ha ingresado el Monto de Ingreso", "Ingreso", JOptionPane.ERROR_MESSAGE);
			formIngreso.getTxtMonto().grabFocus();
			return false;
		}
		if(formIngreso.getcBoxIngresoTipo().getSelectedIndex() < 0)
		{
			JOptionPane.showMessageDialog(formIngreso, "A\u00FAn no ha seleccionado el Tipo", "Ingreso", JOptionPane.ERROR_MESSAGE);
			formIngreso.getcBoxIngresoTipo().grabFocus();
			return false;
		}
		return true;
	}
	
	public void habilitarBotones(boolean nuevo, boolean aceptar, boolean cancelar,
			boolean modificar, boolean eliminar)
	{
		formIngreso.getBtnAceptar().setEnabled(aceptar);
		formIngreso.getBtnNuevo().setEnabled(nuevo);
		formIngreso.getBtnCancelar().setEnabled(cancelar);
		formIngreso.getBtnModificar().setEnabled(modificar);
		formIngreso.getBtnEliminar().setEnabled(eliminar);
	}
	
	public void cargarDatos(Ingreso ingresoAux)
	{
		if(ingresoAux != null)
		{
			ingresoActual = ingresoAux;
			formIngreso.getTxtCodigo().setText(ingresoAux.getCodigoIngreso().toString());
			formIngreso.getDateFechaRegistro().setDate(ingresoAux.getFechaIngreso());
			formIngreso.getTxtDescripcion().setText(ingresoAux.getDetalleIngreso());
			formIngreso.getTxtMonto().setText(String.valueOf(ingresoAux.getMontoIngreso()));
			formIngreso.getTxtSaldo().setText(String.valueOf(ingresoAux.getMontoActual()));
			formIngreso.getTxtNombre().setText(ingresoAux.getNombreIngreso());
//			System.out.println(IngresoAux.getCategoriaIngreso());
//			formIngreso.getcBoxIngresoTipo().getModel().setSelectedItem(ingresoAux.getIngresoTipo());
			formIngreso.getcBoxIngresoTipo().setSelectedItem(ingresoAux.getIngresoTipo());
//			formIngreso.getcBoxCategoriaIngreso().setSelectedItem(IngresoAux.getCategoriaIngreso());
			habilitarBotones(true, false, true, true, true);
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
//		if(formIngreso.getTxtMonto().equals(event))
//		{
//			formIngreso.getTxtSaldo().setText(formIngreso.getTxtMonto().getText());
//		}
		// TODO Auto-generated method stub
		if(formIngreso.getBtnAceptar().equals(event.getSource()))
		{
			if(validarControles())
			{
				try {
					ingresoActual = new Ingreso();
					ingresoActual.setCodigoIngreso(-1);
					ingresoActual.setFechaIngreso(formIngreso.getDateFechaRegistro().getDate());
					ingresoActual.setDetalleIngreso(formIngreso.getTxtDescripcion().getText());
					ingresoActual.setMontoIngreso(Double.valueOf(formIngreso.getTxtMonto().getText()));
					ingresoActual.setMontoActual(Double.valueOf(formIngreso.getTxtSaldo().getText()));
					ingresoActual.setNombreIngreso(formIngreso.getTxtNombre().getText());
					ingresoActual.setCodigoUsuario(codigoUsuario);
					
					ingresoActual.setIngresoTipo((IngresoTipo) formIngreso.getcBoxIngresoTipo().getSelectedItem());
					if(tipoOperacion.compareTo("I")==0)
					{
						daoIngresoMapper.insert(ingresoActual);
						session.commit();
						
						Map<String, Integer> mapa = new HashMap<String, Integer>();
						mapa.put("ultimoId", 0);
						daoIngresoMapper.obtenerUltimoId(mapa); //("myMappedStatement",myParams);
						ingresoActual.setCodigoIngreso(mapa.get("ultimoId"));
						
//					System.out.println("codigo actual = " + mapa.get("ultimoId"));
						modeloIngreso.AnadirIngreso(ingresoActual);
					}
					else
					{
						modeloIngreso.setIngreso(formIngreso.getjTableIngreso().getSelectedRow(), ingresoActual);
						ingresoActual.setCodigoIngreso((Integer.parseInt(formIngreso.getTxtCodigo().getText())));
//					System.out.println(ingresoActual.getCodigoIngreso());
						daoIngresoMapper.updateByPrimaryKey(ingresoActual);
						session.commit();
						
						
					}
					
					if(!formIngreso.getBtnNuevo().isVisible())
					{
						
						formIngreso.setVisible(false);
						formIngreso.dispose();
						return;
					}
					tipoOperacion ="";
					habilitarBotones(true, false, false, true, true);
					habilitarControles(false);
					JOptionPane.showMessageDialog(formIngreso, "Registro almacenado correctamente", "Ingresos", JOptionPane.INFORMATION_MESSAGE);
					formIngreso.getjTableIngreso().clearSelection();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
					JOptionPane.showMessageDialog(formIngreso, "Ocurri\u00F3 la siguiente excepcion: Seguramente ya existe un registro con el mismo nombres ", "Error", JOptionPane.ERROR_MESSAGE);
					session.clearCache();
					session.commit();
				}
			}
			
		}
		if(formIngreso.getBtnNuevo().equals(event.getSource()))
		{
			habilitarBotones(false, true, true, false, false);
			habilitarControles(true);
			limpiarControles();
			tipoOperacion = "I";
			formIngreso.getjTableIngreso().clearSelection();
		}
		if(formIngreso.getBtnCerrar().equals(event.getSource()))
		{
			formIngreso.setVisible(false);
			formIngreso.dispose();
			
		}
		if(formIngreso.getBtnModificar().equals(event.getSource()))
		{
			habilitarBotones(false, true, true, false, false);
			habilitarControles(true);			
			tipoOperacion = "E";
			
		}
		if(formIngreso.getBtnEliminar().equals(event.getSource()))
		{
			if(JOptionPane.showConfirmDialog(formIngreso, "¿Se encuentra seguro de eliminar el registro actual?", "Ingresos", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			{
				System.out.println("Elemento a eliminar " + Integer.parseInt(formIngreso.getTxtCodigo().getText()));
				
				modeloIngreso.eliminarIngreso(formIngreso.getjTableIngreso().getSelectedRow());
				
				
				daoIngresoMapper.deleteByPrimaryKey(Integer.parseInt(formIngreso.getTxtCodigo().getText()));
				
				session.commit();
				
				limpiarControles();
				JOptionPane.showMessageDialog(formIngreso, "Objeto eliminado correctamente", "Ingreso", JOptionPane.INFORMATION_MESSAGE);
				habilitarBotones(true, false, false, false, false);
			}
			
		}
		
		if(formIngreso.getBtnCancelar().equals(event.getSource()))
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
//		System.out.println("indice = " + indice);
		cargarDatos(modeloIngreso.obtenerIngreso(indice));
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		FormUtilities.keyTyped(e, "decimal", formIngreso);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		formIngreso.getTxtSaldo().setText(formIngreso.getTxtMonto().getText());
	}

}
