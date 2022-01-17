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
import org.quarkbit.trabajosocialsanjuan.dao.domain.IngresoTipoExample;
import org.quarkbit.trabajosocialsanjuan.dao.domain.IngresoTipo;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.IngresoTipoMapper;
import org.quarkbit.trabajosocialsanjuan.formularios.FIngresosTipos;
import org.quarkbit.trabajosocialsanjuan.formularios.tablemodels.ModeloIngresosTipos;
import org.quarkbit.trabajosocialsanjuan.utils.FormUtilities;

public class CFIngresosTipos implements ActionListener, ListSelectionListener {
	
	FIngresosTipos formIngresoTipo;
	SqlSession session;
	IngresoTipoMapper daoIngresoTipoMapper;
	ModeloIngresosTipos modeloIngresoTipo;
	String tipoOperacion = "";
	IngresoTipo IngresoTipoActual;
	
	public CFIngresosTipos(FIngresosTipos formIngresoTipo)
	{
		this.formIngresoTipo = formIngresoTipo;
		IngresoTipoActual = new IngresoTipo();
	}
	
	public void onLoad()
	{
		session = Coneccion.getSqlSessionFactory().openSession();
		daoIngresoTipoMapper = session.getMapper(IngresoTipoMapper.class);
		modeloIngresoTipo = new ModeloIngresosTipos();
		
		formIngresoTipo.getjTableIngresoTipo().setModel(modeloIngresoTipo);
		formIngresoTipo.getTxtCodigo().setEnabled(false);	
		
		formIngresoTipo.getBtnAceptar().addActionListener(this);
		formIngresoTipo.getBtnNuevo().addActionListener(this);
		formIngresoTipo.getBtnCancelar().addActionListener(this);
		formIngresoTipo.getBtnModificar().addActionListener(this);
		formIngresoTipo.getBtnEliminar().addActionListener(this);
		formIngresoTipo.getBtnCerrar().addActionListener(this);
		
		
		habilitarControles(false);
		habilitarBotones(true, false, false, false, false);
		modeloIngresoTipo.setListIngresoTipo(daoIngresoTipoMapper.selectByExample(null));
		formIngresoTipo.getjTableIngresoTipo().getSelectionModel().addListSelectionListener(this);
		formIngresoTipo.getjTableIngresoTipo().getColumn("Codigo").setPreferredWidth(5);
		FormUtilities.centrar(formIngresoTipo);
//		mostrarParaInsercion(null);
	}
	
	public void mostrarParaInsercion(IngresoTipo IngresoTipo)
	{
		if(IngresoTipo != null) //para edicion
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
		formIngresoTipo.mostrorSoloControles();
	}
	
	public void limpiarControles()
	{
		formIngresoTipo.getTxtCodigo().setText("");
		formIngresoTipo.getTxtDescripcion().setText("");
		formIngresoTipo.getTxtNombre().setText("");
	}
	
	public void habilitarControles(boolean estadHabilitacion)
	{
		formIngresoTipo.getTxtNombre().setEnabled(estadHabilitacion);
		formIngresoTipo.getTxtDescripcion().setEnabled(estadHabilitacion);
//		formIngresoTipo.getjTableIngresoTipo().setEnabled(estadHabilitacion);
	}
	
	public boolean validarControles()
	{
		if(formIngresoTipo.getTxtNombre().getText().trim().isEmpty())
		{
			JOptionPane.showMessageDialog(formIngresoTipo, "A\u00FAn no ha ingresado el nombre del tipo de fuente de ingreso", "IngresoTipo", JOptionPane.ERROR_MESSAGE);
			formIngresoTipo.getTxtNombre().grabFocus();
			return false;
		}
		
		IngresoTipoExample filtro = new IngresoTipoExample();
		filtro.or().andNombreIngresoTipoEqualTo(formIngresoTipo.getTxtNombre().getText().toUpperCase());
		if(tipoOperacion.compareTo("I") == 0 && daoIngresoTipoMapper.countByExample(filtro) > 0)
		{
			JOptionPane.showMessageDialog(formIngresoTipo, "La fuente de ingreso ya se encuentra registrada", "Categoria IngresoTipo", JOptionPane.ERROR_MESSAGE);
			formIngresoTipo.getTxtNombre().grabFocus();
			return false;
		}
		return true;
	}
	
	public void habilitarBotones(boolean nuevo, boolean aceptar, boolean cancelar,
			boolean modificar, boolean eliminar)
	{
		formIngresoTipo.getBtnAceptar().setEnabled(aceptar);
		formIngresoTipo.getBtnNuevo().setEnabled(nuevo);
		formIngresoTipo.getBtnCancelar().setEnabled(cancelar);
		formIngresoTipo.getBtnModificar().setEnabled(modificar);
		formIngresoTipo.getBtnEliminar().setEnabled(eliminar);
	}
	
	public void cargarDatos(IngresoTipo IngresoTipoAux)
	{
		if(IngresoTipoAux != null)
		{
			IngresoTipoActual = IngresoTipoAux;
			formIngresoTipo.getTxtCodigo().setText(IngresoTipoAux.getCodigoIngresoTipo().toString());
			formIngresoTipo.getTxtNombre().setText(IngresoTipoAux.getNombreIngresoTipo());
			formIngresoTipo.getTxtDescripcion().setText(IngresoTipoAux.getDescripcion());
			habilitarBotones(true, false, true, true, true);
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(formIngresoTipo.getBtnAceptar().equals(event.getSource()))
		{
			if(validarControles())
			{
				try {
					IngresoTipoActual = new IngresoTipo();
					IngresoTipoActual.setCodigoIngresoTipo(-1);
					IngresoTipoActual.setNombreIngresoTipo(formIngresoTipo.getTxtNombre().getText().toUpperCase());
					IngresoTipoActual.setDescripcion(formIngresoTipo.getTxtDescripcion().getText());
					if(tipoOperacion.compareTo("I")==0)
					{
						daoIngresoTipoMapper.insert(IngresoTipoActual);
						session.commit();
						
						Map<String, Integer> mapa = new HashMap<String, Integer>();
						mapa.put("ultimoId", 0);
						daoIngresoTipoMapper.obtenerUltimoId(mapa); //("myMappedStatement",myParams);
						IngresoTipoActual.setCodigoIngresoTipo(mapa.get("ultimoId"));
						
//					System.out.println("codigo actual = " + IngresoTipoActual.getCodigoIngresoTipo());
						modeloIngresoTipo.AnadirIngresoTipo(IngresoTipoActual);
					}
					else
					{
						modeloIngresoTipo.setIngresoTipo(formIngresoTipo.getjTableIngresoTipo().getSelectedRow(), IngresoTipoActual);
						IngresoTipoActual.setCodigoIngresoTipo(Integer.parseInt(formIngresoTipo.getTxtCodigo().getText()));
						daoIngresoTipoMapper.updateByPrimaryKey(IngresoTipoActual);
						session.commit();
						
						
					}
					
					if(!formIngresoTipo.getBtnNuevo().isVisible())
					{
						
						formIngresoTipo.setVisible(false);
						formIngresoTipo.dispose();
						return;
					}
					tipoOperacion ="";
					habilitarBotones(true, false, false, true, true);
					habilitarControles(false);
					JOptionPane.showMessageDialog(formIngresoTipo, "Se almacen\u00F3 correctamente el registro actual", "Tipos de Ingresos", JOptionPane.INFORMATION_MESSAGE);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(formIngresoTipo, "Ocurri\u00F3 la siguiente excepcion " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}
		if(formIngresoTipo.getBtnNuevo().equals(event.getSource()))
		{
			habilitarBotones(false, true, true, false, false);
			habilitarControles(true);
			limpiarControles();
			tipoOperacion = "I";
			formIngresoTipo.getjTableIngresoTipo().clearSelection();
		}
		if(formIngresoTipo.getBtnCerrar().equals(event.getSource()))
		{
			formIngresoTipo.setVisible(false);
			formIngresoTipo.dispose();
			
		}
		if(formIngresoTipo.getBtnModificar().equals(event.getSource()))
		{
			habilitarBotones(false, true, true, false, false);
			habilitarControles(true);			
			tipoOperacion = "E";
			
		}
		if(formIngresoTipo.getBtnEliminar().equals(event.getSource()))
		{
			if(JOptionPane.showConfirmDialog(formIngresoTipo, "¿Se encuentra seguro de eliminar el registro actual?", "IngresosTipos", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			{
				System.out.println("Elemento a eliminar " + Integer.parseInt(formIngresoTipo.getTxtCodigo().getText()));
				
				modeloIngresoTipo.eliminarIngresoTipo(formIngresoTipo.getjTableIngresoTipo().getSelectedRow());
				
				
				daoIngresoTipoMapper.deleteByPrimaryKey(Integer.parseInt(formIngresoTipo.getTxtCodigo().getText()));
				
				session.commit();
				
				limpiarControles();
				habilitarBotones(true, false, false, false, false);
				JOptionPane.showMessageDialog(formIngresoTipo, "Objeto eliminado correctamente", "IngresoTipo", JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
		
		if(formIngresoTipo.getBtnCancelar().equals(event.getSource()))
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
		cargarDatos(modeloIngresoTipo.obtenerIngresoTipo(indice));
		
	}

}
