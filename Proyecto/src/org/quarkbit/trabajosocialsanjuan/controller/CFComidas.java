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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


import org.apache.ibatis.session.SqlSession;
import org.quarkbit.trabajosocialsanjuan.dao.Coneccion;
import org.quarkbit.trabajosocialsanjuan.dao.domain.CategoriaComida;
import org.quarkbit.trabajosocialsanjuan.dao.domain.CategoriaComidaExample;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Comida;
import org.quarkbit.trabajosocialsanjuan.dao.domain.ComidaExample;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.CategoriaComidaMapper;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.ComidaMapper;
import org.quarkbit.trabajosocialsanjuan.formularios.FComidas;
import org.quarkbit.trabajosocialsanjuan.formularios.tablemodels.ModeloComidas;
import org.quarkbit.trabajosocialsanjuan.utils.FormUtilities;

public class CFComidas implements ActionListener, ListSelectionListener, KeyListener {
	
	FComidas formComida;
	SqlSession session;
	ComidaMapper daoComidaMapper;
	CategoriaComidaMapper daoCategoriaComidaMapper;
	ModeloComidas modeloComida;
	String tipoOperacion = "";
	Comida comidaActual;
	
	public CFComidas(FComidas formComidasCategorias)
	{
		this.formComida = formComidasCategorias;
		comidaActual = new Comida();
	}
	
	public void onLoad()
	{
		session = Coneccion.getSqlSessionFactory().openSession();
		daoComidaMapper = session.getMapper(ComidaMapper.class);
		daoCategoriaComidaMapper = session.getMapper(CategoriaComidaMapper.class);
		modeloComida = new ModeloComidas();
		
		formComida.getjTableComida().setModel(modeloComida);
		formComida.getTxtCodigo().setEnabled(false);	
		
		formComida.getBtnAceptar().addActionListener(this);
		formComida.getBtnNuevo().addActionListener(this);
		formComida.getBtnCancelar().addActionListener(this);
		formComida.getBtnModificar().addActionListener(this);
		formComida.getBtnEliminar().addActionListener(this);
		formComida.getBtnCerrar().addActionListener(this);
		
		
		
		habilitarControles(false);
		habilitarBotones(true, false, false, false, false);
		modeloComida.setListComida(daoComidaMapper.selectByExample(null));
		formComida.getjTableComida().getSelectionModel().addListSelectionListener(this);
//		formComida.getjTableComida().getColumn("Codigo").setPreferredWidth(5);
		FormUtilities.centrar(formComida);
		for (CategoriaComida categoria : daoCategoriaComidaMapper.selectByExample(null)) {
			formComida.getcBoxCategoriaComida().addItem(categoria);
		}
		formComida.getTxtPrecio().addKeyListener(this);
//		mostrarParaInsercion(null);
	}
	
	public void mostrarParaInsercion(Comida comida)
	{
		if(comida != null) //para edicion
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
//		formComida.mostrorSoloControles();
	}
	
	public void limpiarControles()
	{
		formComida.getTxtCodigo().setText("");
		formComida.getTxtDescripcion().setText("");
		formComida.getTxtNombre().setText("");
		formComida.getTxtPrecio().setText("");
		formComida.getcBoxCategoriaComida().setSelectedIndex(-1);
	}
	
	public void habilitarControles(boolean estadHabilitacion)
	{
		formComida.getTxtNombre().setEnabled(estadHabilitacion);
		formComida.getTxtDescripcion().setEnabled(estadHabilitacion);
		formComida.getTxtPrecio().setEnabled(estadHabilitacion);
		formComida.getcBoxCategoriaComida().setEnabled(estadHabilitacion);
//		formComida.getjTableComida().setEnabled(estadHabilitacion);
	}
	
	public boolean validarControles()
	{
		if(formComida.getTxtNombre().getText().trim().isEmpty())
		{
			JOptionPane.showMessageDialog(formComida, "A\u00FAn no ha ingresado el nombre del Categoria", "Comida", JOptionPane.ERROR_MESSAGE);
			formComida.getTxtNombre().grabFocus();
			return false;
		}
		if(formComida.getTxtPrecio().getText().trim().isEmpty())
		{
			JOptionPane.showMessageDialog(formComida, "A\u00FAn no ha ingresado el precio de la Comida", "Comida", JOptionPane.ERROR_MESSAGE);
			formComida.getTxtPrecio().grabFocus();
			return false;
		}
		if(formComida.getcBoxCategoriaComida().getSelectedIndex() < 0)
		{
			JOptionPane.showMessageDialog(formComida, "A\u00FAn no ha seleccionado la Categoria", "Comida", JOptionPane.ERROR_MESSAGE);
			formComida.getcBoxCategoriaComida().grabFocus();
			return false;
		}
		
		ComidaExample filtro = new ComidaExample();
		filtro.or().andNombreComidaEqualTo(formComida.getTxtNombre().getText().toUpperCase());
		if(tipoOperacion.compareTo("I") == 0 && daoComidaMapper.countByExample(filtro) > 0)
		{
			JOptionPane.showMessageDialog(formComida, "El nombre de la comida ya se encuentra registrada", "Categoria Comida", JOptionPane.ERROR_MESSAGE);
			formComida.getTxtNombre().grabFocus();
			return false;
		}
		return true;
	}
	
	public void habilitarBotones(boolean nuevo, boolean aceptar, boolean cancelar,
			boolean modificar, boolean eliminar)
	{
		formComida.getBtnAceptar().setEnabled(aceptar);
		formComida.getBtnNuevo().setEnabled(nuevo);
		formComida.getBtnCancelar().setEnabled(cancelar);
		formComida.getBtnModificar().setEnabled(modificar);
		formComida.getBtnEliminar().setEnabled(eliminar);
	}
	
	public void cargarDatos(Comida comidaAux)
	{
		if(comidaAux != null)
		{
			comidaActual = comidaAux;
			formComida.getTxtCodigo().setText(comidaAux.getCodigoComida().toString());
			formComida.getTxtNombre().setText(comidaAux.getNombreComida());
			formComida.getTxtDescripcion().setText(comidaAux.getDescripcion());
			formComida.getTxtPrecio().setText(String.valueOf(comidaAux.getPrecioEstimado()));
//			System.out.println(comidaAux.getCategoriaComida());
			formComida.getcBoxCategoriaComida().getModel().setSelectedItem(comidaAux.getCategoriaComida());
//			formComida.getcBoxCategoriaComida().setSelectedItem(comidaAux.getCategoriaComida());
			habilitarBotones(true, false, true, true, true);
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(formComida.getBtnAceptar().equals(event.getSource()))
		{
			if(validarControles())
			{
				try {
					comidaActual = new Comida();
					comidaActual.setCodigoCategoria(-1);
					comidaActual.setNombreComida(formComida.getTxtNombre().getText().toUpperCase());
					comidaActual.setDescripcion(formComida.getTxtDescripcion().getText());
					comidaActual.setPrecioEstimado(Double.valueOf(formComida.getTxtPrecio().getText()));
					comidaActual.setCategoriaComida((CategoriaComida) formComida.getcBoxCategoriaComida().getSelectedItem());
					if(tipoOperacion.compareTo("I")==0)
					{
						daoComidaMapper.insert(comidaActual);
						session.commit();
						
						Map<String, Integer> mapa = new HashMap<String, Integer>();
						mapa.put("ultimoId", 0);
						daoComidaMapper.obtenerUltimoId(mapa); //("myMappedStatement",myParams);
						comidaActual.setCodigoComida(mapa.get("ultimoId"));
						
//					System.out.println("codigo actual = " + mapa.get("ultimoId"));
						modeloComida.AnadirComida(comidaActual);
					}
					else
					{
						modeloComida.setComida(formComida.getjTableComida().getSelectedRow(), comidaActual);
						comidaActual.setCodigoComida((Integer.parseInt(formComida.getTxtCodigo().getText())));
						System.out.println("Modificado " + comidaActual.getCodigoComida());
						daoComidaMapper.updateByPrimaryKey(comidaActual);
						session.commit();
						
						
					}
					
					if(!formComida.getBtnNuevo().isVisible())
					{
						
						formComida.setVisible(false);
						formComida.dispose();
						return;
					}
					tipoOperacion ="";
					habilitarBotones(true, false, false, true, true);
					habilitarControles(false);
					JOptionPane.showMessageDialog(formComida, "Operaci\u00F3n realizada correctamente", "Comidas", JOptionPane.INFORMATION_MESSAGE);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(formComida, "Ocurri\u00F3 la siguiente excepcion " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}
		if(formComida.getBtnNuevo().equals(event.getSource()))
		{
			habilitarBotones(false, true, true, false, false);
			habilitarControles(true);
			limpiarControles();
			tipoOperacion = "I";
			formComida.getjTableComida().clearSelection();
		}
		if(formComida.getBtnCerrar().equals(event.getSource()))
		{
			formComida.setVisible(false);
			formComida.dispose();
			
		}
		if(formComida.getBtnModificar().equals(event.getSource()))
		{
			habilitarBotones(false, true, true, false, false);
			habilitarControles(true);			
			tipoOperacion = "E";
			
		}
		if(formComida.getBtnEliminar().equals(event.getSource()))
		{
			if(JOptionPane.showConfirmDialog(formComida, "¿Se encuentra seguro de eliminar el registro actual?", "Comidas", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			{
				System.out.println("Elemento a eliminar " + Integer.parseInt(formComida.getTxtCodigo().getText()));
				
				try {
					modeloComida.eliminarComida(formComida.getjTableComida().getSelectedRow());
					
					
					daoComidaMapper.deleteByPrimaryKey(Integer.parseInt(formComida.getTxtCodigo().getText()));
					
					session.commit();
					
					limpiarControles();
					JOptionPane.showMessageDialog(formComida, "Objeto eliminado correctamente", "Comida", JOptionPane.INFORMATION_MESSAGE);
					habilitarBotones(true, false, false, false, false);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (HeadlessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(formComida, "Probablemente el registro actual se encuentra en uso en otras transacciones, por lo cual no puede ser eliminado ",  "Comidas", JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
		}
		
		if(formComida.getBtnCancelar().equals(event.getSource()))
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
		cargarDatos(modeloComida.obtenerComida(indice));
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		FormUtilities.keyTyped(e, "decimal", formComida);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
