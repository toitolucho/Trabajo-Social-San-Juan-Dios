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
import org.quarkbit.trabajosocialsanjuan.dao.domain.PropiedadTipoExample;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PropiedadTipo;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.PropiedadTipoMapper;
import org.quarkbit.trabajosocialsanjuan.formularios.FIngresosTipos;
import org.quarkbit.trabajosocialsanjuan.formularios.FPropiedadesTipos;
import org.quarkbit.trabajosocialsanjuan.formularios.tablemodels.ModeloIngresosTipos;
import org.quarkbit.trabajosocialsanjuan.formularios.tablemodels.ModeloPropiedadesTipos;
import org.quarkbit.trabajosocialsanjuan.utils.FormUtilities;

public class CFPropiedadesTipos implements ActionListener, ListSelectionListener {
	
	FPropiedadesTipos formPropiedadTipo;
	SqlSession session;
	PropiedadTipoMapper daoPropiedadTipoMapper;
	ModeloPropiedadesTipos modeloPropiedadTipo;
	String tipoOperacion = "";
	PropiedadTipo PropiedadTipoActual;
	
	public CFPropiedadesTipos(FPropiedadesTipos formPropiedadTipo)
	{
		this.formPropiedadTipo = formPropiedadTipo;
		PropiedadTipoActual = new PropiedadTipo();
	}
	
	public void onLoad()
	{
		session = Coneccion.getSqlSessionFactory().openSession();
		daoPropiedadTipoMapper = session.getMapper(PropiedadTipoMapper.class);
		modeloPropiedadTipo = new ModeloPropiedadesTipos();
		
		formPropiedadTipo.getjTablePropiedadTipo().setModel(modeloPropiedadTipo);
		formPropiedadTipo.getTxtCodigo().setEnabled(false);	
		
		formPropiedadTipo.getBtnAceptar().addActionListener(this);
		formPropiedadTipo.getBtnNuevo().addActionListener(this);
		formPropiedadTipo.getBtnCancelar().addActionListener(this);
		formPropiedadTipo.getBtnModificar().addActionListener(this);
		formPropiedadTipo.getBtnEliminar().addActionListener(this);
		formPropiedadTipo.getBtnCerrar().addActionListener(this);
		
		
		habilitarControles(false);
		habilitarBotones(true, false, false, false, false);
		
		modeloPropiedadTipo.setListPropiedadTipo(daoPropiedadTipoMapper.selectByExample(null));
		formPropiedadTipo.getjTablePropiedadTipo().getSelectionModel().addListSelectionListener(this);
		formPropiedadTipo.getjTablePropiedadTipo().getColumn("Codigo").setPreferredWidth(5);
		FormUtilities.centrar(formPropiedadTipo);
//		mostrarParaInsercion(null);
	}
	
	public void mostrarParaInsercion(PropiedadTipo PropiedadTipo)
	{
		if(PropiedadTipo != null) //para edicion
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
		formPropiedadTipo.mostrorSoloControles();
	}
	
	public void limpiarControles()
	{
		formPropiedadTipo.getTxtCodigo().setText("");
		formPropiedadTipo.getTxtDescripcion().setText("");
		formPropiedadTipo.getTxtNombre().setText("");
	}
	
	public void habilitarControles(boolean estadHabilitacion)
	{
		formPropiedadTipo.getTxtNombre().setEnabled(estadHabilitacion);
		formPropiedadTipo.getTxtDescripcion().setEnabled(estadHabilitacion);
//		formPropiedadTipo.getjTablePropiedadTipo().setEnabled(estadHabilitacion);
	}
	
	public boolean validarControles()
	{
		if(formPropiedadTipo.getTxtNombre().getText().trim().isEmpty())
		{
			JOptionPane.showMessageDialog(formPropiedadTipo, "A\u00FAn no ha ingresado el nombre del tipo de fuente de ingreso", "PropiedadTipo", JOptionPane.ERROR_MESSAGE);
			formPropiedadTipo.getTxtNombre().grabFocus();
			return false;
		}
		
		PropiedadTipoExample filtro = new PropiedadTipoExample();
		filtro.or().andNombrePropiedadTipoEqualTo(formPropiedadTipo.getTxtNombre().getText().toUpperCase());
		if(tipoOperacion.compareTo("I") == 0 && daoPropiedadTipoMapper.countByExample(filtro) > 0)
		{
			JOptionPane.showMessageDialog(formPropiedadTipo, "El tipo de Consulta ya se encuentra registrado", "Tipos Propiedades Consulta", JOptionPane.ERROR_MESSAGE);
			formPropiedadTipo.getTxtNombre().grabFocus();
			return false;
		}
		return true;
	}
	
	public void habilitarBotones(boolean nuevo, boolean aceptar, boolean cancelar,
			boolean modificar, boolean eliminar)
	{
		formPropiedadTipo.getBtnAceptar().setEnabled(aceptar);
		formPropiedadTipo.getBtnNuevo().setEnabled(nuevo);
		formPropiedadTipo.getBtnCancelar().setEnabled(cancelar);
		formPropiedadTipo.getBtnModificar().setEnabled(modificar);
		formPropiedadTipo.getBtnEliminar().setEnabled(eliminar);
	}
	
	public void cargarDatos(PropiedadTipo PropiedadTipoAux)
	{
		if(PropiedadTipoAux != null)
		{
			PropiedadTipoActual = PropiedadTipoAux;
			formPropiedadTipo.getTxtCodigo().setText(PropiedadTipoAux.getNumeroPropiedadTipo().toString());
			formPropiedadTipo.getTxtNombre().setText(PropiedadTipoAux.getNombrePropiedadTipo());
			formPropiedadTipo.getTxtDescripcion().setText(PropiedadTipoAux.getDescripcion());
			habilitarBotones(true, false, true, true, true);
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(formPropiedadTipo.getBtnAceptar().equals(event.getSource()))
		{
			if(validarControles())
			{
				try {
					PropiedadTipoActual = new PropiedadTipo();
					PropiedadTipoActual.setNumeroPropiedadTipo(-1);
					PropiedadTipoActual.setNombrePropiedadTipo(formPropiedadTipo.getTxtNombre().getText().toUpperCase());
					PropiedadTipoActual.setDescripcion(formPropiedadTipo.getTxtDescripcion().getText());
					if(tipoOperacion.compareTo("I")==0)
					{
						daoPropiedadTipoMapper.insert(PropiedadTipoActual);
						session.commit();
						
						Map<String, Integer> mapa = new HashMap<String, Integer>();
						mapa.put("ultimoId", 0);
						daoPropiedadTipoMapper.obtenerUltimoId(mapa); //("myMappedStatement",myParams);
						PropiedadTipoActual.setNumeroPropiedadTipo(mapa.get("ultimoId"));
						
//					System.out.println("codigo actual = " + PropiedadTipoActual.getCodigoPropiedadTipo());
						modeloPropiedadTipo.AnadirPropiedadTipo(PropiedadTipoActual);
					}
					else
					{
						modeloPropiedadTipo.setPropiedadTipo(formPropiedadTipo.getjTablePropiedadTipo().getSelectedRow(), PropiedadTipoActual);
						PropiedadTipoActual.setNumeroPropiedadTipo(Integer.parseInt(formPropiedadTipo.getTxtCodigo().getText()));
						daoPropiedadTipoMapper.updateByPrimaryKey(PropiedadTipoActual);
						session.commit();
						
						
					}
					
					if(!formPropiedadTipo.getBtnNuevo().isVisible())
					{
						
						formPropiedadTipo.setVisible(false);
						formPropiedadTipo.dispose();
						return;
					}
					tipoOperacion ="";
					habilitarBotones(true, false, false, true, true);
					habilitarControles(false);
					JOptionPane.showMessageDialog(formPropiedadTipo, "Se almacen\u00F3 correctamente el registro actual", "Tipos de Ingresos", JOptionPane.INFORMATION_MESSAGE);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(formPropiedadTipo, "Ocurri\u00F3 la siguiente excepcion " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}
		if(formPropiedadTipo.getBtnNuevo().equals(event.getSource()))
		{
			habilitarBotones(false, true, true, false, false);
			habilitarControles(true);
			limpiarControles();
			tipoOperacion = "I";
			formPropiedadTipo.getjTablePropiedadTipo().clearSelection();
		}
		if(formPropiedadTipo.getBtnCerrar().equals(event.getSource()))
		{
			formPropiedadTipo.setVisible(false);
			formPropiedadTipo.dispose();
			
		}
		if(formPropiedadTipo.getBtnModificar().equals(event.getSource()))
		{
			habilitarBotones(false, true, true, false, false);
			habilitarControles(true);			
			tipoOperacion = "E";
			
		}
		if(formPropiedadTipo.getBtnEliminar().equals(event.getSource()))
		{
			if(JOptionPane.showConfirmDialog(formPropiedadTipo, "¿Se encuentra seguro de eliminar el registro actual?", "IngresosTipos", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			{
				System.out.println("Elemento a eliminar " + Integer.parseInt(formPropiedadTipo.getTxtCodigo().getText()));
				
				modeloPropiedadTipo.eliminarPropiedadTipo(formPropiedadTipo.getjTablePropiedadTipo().getSelectedRow());
				
				
				daoPropiedadTipoMapper.deleteByPrimaryKey(Integer.parseInt(formPropiedadTipo.getTxtCodigo().getText()));
				
				session.commit();
				
				limpiarControles();
				habilitarBotones(true, false, false, false, false);
				JOptionPane.showMessageDialog(formPropiedadTipo, "Objeto eliminado correctamente", "PropiedadTipo", JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
		
		if(formPropiedadTipo.getBtnCancelar().equals(event.getSource()))
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
		cargarDatos(modeloPropiedadTipo.obtenerPropiedadTipo(indice));
		
	}

}
