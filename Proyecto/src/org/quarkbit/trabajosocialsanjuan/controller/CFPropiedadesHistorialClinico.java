package org.quarkbit.trabajosocialsanjuan.controller;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


import org.apache.ibatis.session.SqlSession;
import org.quarkbit.trabajosocialsanjuan.dao.Coneccion;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PropiedadHistorialClinico;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PropiedadHistorialClinicoExample;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PropiedadTipo;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.PropiedadHistorialClinicoMapper;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.PropiedadTipoMapper;
import org.quarkbit.trabajosocialsanjuan.formularios.FPropiedadesHistorialClinico;
import org.quarkbit.trabajosocialsanjuan.formularios.tablemodels.ModeloPropiedadesHistorialClinico;

import org.quarkbit.trabajosocialsanjuan.utils.FormUtilities;

public class CFPropiedadesHistorialClinico implements ActionListener, ListSelectionListener, KeyListener, DocumentListener {
	
	FPropiedadesHistorialClinico formPropiedadesHC;
	SqlSession session;
	PropiedadHistorialClinicoMapper daoPropiedadHistorialClinicoMapper;
	
	PropiedadTipoMapper daoPropiedadTipoMapper;
	ModeloPropiedadesHistorialClinico modeloPropiedadHistorialClinico;
	String tipoOperacion = "";
	PropiedadHistorialClinico propiedadHistorialClinicoActual;
	PropiedadHistorialClinicoExample filtroPropiedad;
	/**
	 * @wbp.parser.entryPoint
	 */
	public CFPropiedadesHistorialClinico(FPropiedadesHistorialClinico formPropiedadHistorialClinicosCategorias)
	{
		this.formPropiedadesHC = formPropiedadHistorialClinicosCategorias;
		propiedadHistorialClinicoActual = new PropiedadHistorialClinico();
		filtroPropiedad = new PropiedadHistorialClinicoExample();
	}
	
	public void onLoad()
	{
		session = Coneccion.getSqlSessionFactory().openSession();
		daoPropiedadHistorialClinicoMapper = session.getMapper(PropiedadHistorialClinicoMapper.class);
		daoPropiedadTipoMapper = session.getMapper(PropiedadTipoMapper.class);
		modeloPropiedadHistorialClinico = new ModeloPropiedadesHistorialClinico();
		
		formPropiedadesHC.getjTablePropiedadHistorialClinico().setModel(modeloPropiedadHistorialClinico);
		formPropiedadesHC.getTxtCodigo().setEnabled(false);	
		
		formPropiedadesHC.getBtnAceptar().addActionListener(this);
		formPropiedadesHC.getBtnNuevo().addActionListener(this);
		formPropiedadesHC.getBtnCancelar().addActionListener(this);
		formPropiedadesHC.getBtnModificar().addActionListener(this);
		formPropiedadesHC.getBtnEliminar().addActionListener(this);
		formPropiedadesHC.getBtnCerrar().addActionListener(this);
		formPropiedadesHC.getBtnBuscar().addActionListener(this);
		formPropiedadesHC.getTxtBusqueda().addActionListener(this);
		
		
		habilitarControles(false);
		habilitarBotones(true, false, false, false, false);
		modeloPropiedadHistorialClinico.setListPropiedadHistorialClinico(daoPropiedadHistorialClinicoMapper.selectByExample(null));
		formPropiedadesHC.getjTablePropiedadHistorialClinico().getSelectionModel().addListSelectionListener(this);
//		formPropiedadHistorialClinico.getjTablePropiedadHistorialClinico().getColumn("Codigo").setPreferredWidth(5);
		FormUtilities.centrar(formPropiedadesHC);
		for (PropiedadTipo propiedad : daoPropiedadTipoMapper.selectByExample(null)) {
			formPropiedadesHC.getcBoxPropiedadTipo().addItem(propiedad);
			formPropiedadesHC.getcBoxTipoBusqueda().addItem(propiedad);
		}
		formPropiedadesHC.getcBoxTipoBusqueda().setSelectedIndex(-1);
		formPropiedadesHC.getcBoxTipoBusqueda().addActionListener(this);
		formPropiedadesHC.getTxtBusqueda().setActionCommand("Buscar");
		formPropiedadesHC.getTxtBusqueda().getDocument().addDocumentListener(this);
	}
	
	public void mostrarParaInsercion(PropiedadHistorialClinico PropiedadHistorialClinico)
	{
		if(PropiedadHistorialClinico != null) //para edicion
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
//		formPropiedadHistorialClinico.mostrorSoloControles();
	}
	
	public void limpiarControles()
	{
		formPropiedadesHC.getTxtCodigo().setText("");
		formPropiedadesHC.getTxtDescripcion().setText("");
		formPropiedadesHC.getTxtComposicion().setText("");
		formPropiedadesHC.getTxtNombre().setText("");
		formPropiedadesHC.getTxtAbreviacion() .setText("");
		formPropiedadesHC.getcBoxPropiedadTipo().setSelectedIndex(-1);
	}
	
	public void habilitarControles(boolean estadHabilitacion)
	{
		formPropiedadesHC.getTxtNombre().setEnabled(estadHabilitacion);
		formPropiedadesHC.getTxtDescripcion().setEnabled(estadHabilitacion);
		formPropiedadesHC.getTxtComposicion().setEnabled(estadHabilitacion);
		formPropiedadesHC.getTxtAbreviacion() .setEnabled(estadHabilitacion);
		formPropiedadesHC.getcBoxPropiedadTipo().setEnabled(estadHabilitacion);
//		formPropiedadHistorialClinico.getjTablePropiedadHistorialClinico().setEnabled(estadHabilitacion);
		
		formPropiedadesHC.getcBoxTipoBusqueda().setEnabled(!estadHabilitacion);
		formPropiedadesHC.getTxtBusqueda().setEnabled(!estadHabilitacion);
		formPropiedadesHC.getBtnBuscar().setEnabled(!estadHabilitacion);
	}
	
	public boolean validarControles()
	{
		if(formPropiedadesHC.getTxtNombre().getText().trim().isEmpty())
		{
			JOptionPane.showMessageDialog(formPropiedadesHC, "A\u00FAn no ha ingresado el nombre del Categoria", "PropiedadHistorialClinico", JOptionPane.ERROR_MESSAGE);
			formPropiedadesHC.getTxtNombre().grabFocus();
			return false;
		}
//		if(formPropiedadesHC.getTxtPrecio().getText().trim().isEmpty())
//		{
//			JOptionPane.showMessageDialog(formPropiedadesHC, "A\u00FAn no ha ingresado el precio de la PropiedadHistorialClinico", "PropiedadHistorialClinico", JOptionPane.ERROR_MESSAGE);
//			formPropiedadesHC.getTxtPrecio().grabFocus();
//			return false;
//		}
		if(formPropiedadesHC.getcBoxPropiedadTipo().getSelectedIndex() < 0)
		{
			JOptionPane.showMessageDialog(formPropiedadesHC, "A\u00FAn no ha seleccionado la Categoria", "PropiedadHistorialClinico", JOptionPane.ERROR_MESSAGE);
			formPropiedadesHC.getcBoxPropiedadTipo().grabFocus();
			return false;
		}
		
		PropiedadHistorialClinicoExample filtro = new PropiedadHistorialClinicoExample();
		filtro.or().andNombrePropiedadEqualTo(formPropiedadesHC.getTxtNombre().getText().toUpperCase());
		if(tipoOperacion.compareTo("I") == 0 && daoPropiedadHistorialClinicoMapper.countByExample(filtro) > 0)
		{
			JOptionPane.showMessageDialog(formPropiedadesHC, "El nombre de la PropiedadHistorialClinico ya se encuentra registrada", "Categoria PropiedadHistorialClinico", JOptionPane.ERROR_MESSAGE);
			formPropiedadesHC.getTxtNombre().grabFocus();
			return false;
		}
		return true;
	}
	
	public void habilitarBotones(boolean nuevo, boolean aceptar, boolean cancelar,
			boolean modificar, boolean eliminar)
	{
		formPropiedadesHC.getBtnAceptar().setEnabled(aceptar);
		formPropiedadesHC.getBtnNuevo().setEnabled(nuevo);
		formPropiedadesHC.getBtnCancelar().setEnabled(cancelar);
		formPropiedadesHC.getBtnModificar().setEnabled(modificar);
		formPropiedadesHC.getBtnEliminar().setEnabled(eliminar);
	}
	
	public void cargarDatos(PropiedadHistorialClinico propiedadHistorialClinicoAux)
	{
		if(propiedadHistorialClinicoAux != null)
		{
			propiedadHistorialClinicoActual = propiedadHistorialClinicoAux;
			formPropiedadesHC.getTxtCodigo().setText(propiedadHistorialClinicoAux.getNumeroPropiedad() .toString());
			formPropiedadesHC.getTxtNombre().setText(propiedadHistorialClinicoAux.getNombrePropiedad());
			formPropiedadesHC.getTxtDescripcion().setText(propiedadHistorialClinicoAux.getDescripcion());
			formPropiedadesHC.getTxtComposicion().setText(propiedadHistorialClinicoAux.getComposicion());
			formPropiedadesHC.getTxtAbreviacion().setText(propiedadHistorialClinicoAux.getAbreviacion());
//			formPropiedadesHC.getTxtPrecio().setText(String.valueOf(PropiedadHistorialClinicoAux.getPrecioEstimado()));
//			System.out.println(PropiedadHistorialClinicoAux.getPropiedadTipo());
			formPropiedadesHC.getcBoxPropiedadTipo().getModel().setSelectedItem(propiedadHistorialClinicoAux.getPropiedadTipo());
//			formPropiedadHistorialClinico.getcBoxPropiedadTipo().setSelectedItem(PropiedadHistorialClinicoAux.getPropiedadTipo());
			habilitarBotones(true, false, true, true, true);
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getActionCommand().compareTo("Buscar") == 0)
		{
			filtroPropiedad.clear();
			
			if(formPropiedadesHC.getcBoxTipoBusqueda().getSelectedIndex() >= 0)
			{
				filtroPropiedad.or().andNombrePropiedadLike("%" + formPropiedadesHC.getTxtBusqueda().getText().toUpperCase() + "%").andNumeroPropiedadTipoEqualTo(
						((PropiedadTipo) formPropiedadesHC.getcBoxTipoBusqueda().getSelectedItem()).getNumeroPropiedadTipo() );
			}
			else
				filtroPropiedad.or().andNombrePropiedadLike("%" + formPropiedadesHC.getTxtBusqueda().getText().toUpperCase() + "%");
			
			modeloPropiedadHistorialClinico.setListPropiedadHistorialClinico(daoPropiedadHistorialClinicoMapper.selectByExample(filtroPropiedad));
		}
		if(formPropiedadesHC.getcBoxTipoBusqueda().equals(event.getSource()))
		{
			filtroPropiedad.clear();
			filtroPropiedad.or().andNumeroPropiedadTipoEqualTo( ((PropiedadTipo) formPropiedadesHC.getcBoxTipoBusqueda().getSelectedItem()).getNumeroPropiedadTipo() );
			modeloPropiedadHistorialClinico.setListPropiedadHistorialClinico(daoPropiedadHistorialClinicoMapper.selectByExample(filtroPropiedad));
			
			
		}
		if(formPropiedadesHC.getBtnAceptar().equals(event.getSource()))
		{
			if(validarControles())
			{
				try {
					propiedadHistorialClinicoActual = new PropiedadHistorialClinico();
					propiedadHistorialClinicoActual.setNumeroPropiedad(-1);
					propiedadHistorialClinicoActual.setNombrePropiedad(formPropiedadesHC.getTxtNombre().getText().toUpperCase());
					propiedadHistorialClinicoActual.setDescripcion(formPropiedadesHC.getTxtDescripcion().getText());
					propiedadHistorialClinicoActual.setComposicion(formPropiedadesHC.getTxtComposicion().getText());
					propiedadHistorialClinicoActual.setAbreviacion(formPropiedadesHC.getTxtAbreviacion().getText());
					propiedadHistorialClinicoActual.setPropiedadTipo((PropiedadTipo) formPropiedadesHC.getcBoxPropiedadTipo().getSelectedItem());
					propiedadHistorialClinicoActual.setNumeroPropiedadTipo(propiedadHistorialClinicoActual.getPropiedadTipo().getNumeroPropiedadTipo());
					
					if(tipoOperacion.compareTo("I")==0)
					{
						daoPropiedadHistorialClinicoMapper.insert(propiedadHistorialClinicoActual);
						session.commit();
						
						Map<String, Integer> mapa = new HashMap<String, Integer>();
						mapa.put("ultimoId", 0);
						daoPropiedadHistorialClinicoMapper.obtenerUltimoId(mapa); //("myMappedStatement",myParams);
						propiedadHistorialClinicoActual.setNumeroPropiedad(mapa.get("ultimoId"));
						
//					System.out.println("codigo actual = " + mapa.get("ultimoId"));
						modeloPropiedadHistorialClinico.AnadirPropiedadHistorialClinico(propiedadHistorialClinicoActual);
					}
					else
					{
						modeloPropiedadHistorialClinico.setPropiedadHistorialClinico(formPropiedadesHC.getjTablePropiedadHistorialClinico().getSelectedRow(), propiedadHistorialClinicoActual);
						propiedadHistorialClinicoActual.setNumeroPropiedad((Integer.parseInt(formPropiedadesHC.getTxtCodigo().getText())));
//						System.out.println("Modificado " + PropiedadHistorialClinicoActual.getCodigoPropiedadHistorialClinico());
						daoPropiedadHistorialClinicoMapper.updateByPrimaryKey(propiedadHistorialClinicoActual);
						session.commit();
						
						
					}
					
					if(!formPropiedadesHC.getBtnNuevo().isVisible())
					{
						
						formPropiedadesHC.setVisible(false);
						formPropiedadesHC.dispose();
						return;
					}
					tipoOperacion ="";
					habilitarBotones(true, false, false, true, true);
					habilitarControles(false);
					JOptionPane.showMessageDialog(formPropiedadesHC, "Operaci\u00F3n realizada correctamente", "PropiedadHistorialClinicos", JOptionPane.INFORMATION_MESSAGE);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(formPropiedadesHC, "Ocurri\u00F3 la siguiente excepcion " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}
		if(formPropiedadesHC.getBtnNuevo().equals(event.getSource()))
		{
			habilitarBotones(false, true, true, false, false);
			habilitarControles(true);
			limpiarControles();
			tipoOperacion = "I";
			formPropiedadesHC.getjTablePropiedadHistorialClinico().clearSelection();
		}
		if(formPropiedadesHC.getBtnCerrar().equals(event.getSource()))
		{
			formPropiedadesHC.setVisible(false);
			formPropiedadesHC.dispose();
			
		}
		if(formPropiedadesHC.getBtnModificar().equals(event.getSource()))
		{
			habilitarBotones(false, true, true, false, false);
			habilitarControles(true);			
			tipoOperacion = "E";
			
		}
		if(formPropiedadesHC.getBtnEliminar().equals(event.getSource()))
		{
			if(JOptionPane.showConfirmDialog(formPropiedadesHC, "¿Se encuentra seguro de eliminar el registro actual?", "PropiedadHistorialClinicos", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			{
				System.out.println("Elemento a eliminar " + Integer.parseInt(formPropiedadesHC.getTxtCodigo().getText()));
				
				try {
					modeloPropiedadHistorialClinico.eliminarPropiedadHistorialClinico(formPropiedadesHC.getjTablePropiedadHistorialClinico().getSelectedRow());
					
					
					daoPropiedadHistorialClinicoMapper.deleteByPrimaryKey(Integer.parseInt(formPropiedadesHC.getTxtCodigo().getText()));
					
					session.commit();
					
					limpiarControles();
					JOptionPane.showMessageDialog(formPropiedadesHC, "Objeto eliminado correctamente", "PropiedadHistorialClinico", JOptionPane.INFORMATION_MESSAGE);
					habilitarBotones(true, false, false, false, false);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (HeadlessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(formPropiedadesHC, "Probablemente el registro actual se encuentra en uso en otras transacciones, por lo cual no puede ser eliminado ",  "PropiedadHistorialClinicos", JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
		}
		
		if(formPropiedadesHC.getBtnCancelar().equals(event.getSource()))
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
		cargarDatos(modeloPropiedadHistorialClinico.obtenerPropiedadHistorialClinico(indice));
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		FormUtilities.keyTyped(e, "decimal", formPropiedadesHC);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		actionPerformed(new ActionEvent(formPropiedadesHC.getTxtBusqueda(), 25, "Buscar"));
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		if(formPropiedadesHC.getTxtBusqueda().getText().isEmpty())
			actionPerformed(new ActionEvent(formPropiedadesHC.getTxtBusqueda(), 25, "Buscar"));
	}

}
