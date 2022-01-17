package org.quarkbit.trabajosocialsanjuan.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.html.FormView;

import org.apache.ibatis.jdbc.RuntimeSqlException;
import org.apache.ibatis.session.SqlSession;
import org.quarkbit.trabajosocialsanjuan.dao.Coneccion;
import org.quarkbit.trabajosocialsanjuan.dao.domain.CategoriaComida;
import org.quarkbit.trabajosocialsanjuan.dao.domain.CategoriaComidaExample;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.CategoriaComidaMapper;
import org.quarkbit.trabajosocialsanjuan.formularios.FCategoriasComidas;
import org.quarkbit.trabajosocialsanjuan.formularios.tablemodels.ModeloCategoriaComidas;
import org.quarkbit.trabajosocialsanjuan.utils.FormUtilities;
import org.quarkbit.trabajosocialsanjuan.utils.HoraTiempo;

public class CFCategoriasComidas implements ActionListener, ListSelectionListener {
	
	FCategoriasComidas formCategoriaComida;
	SqlSession session;
	CategoriaComidaMapper daoCategoriaComidaMapper;
	ModeloCategoriaComidas modeloCategoriaComida;
	String tipoOperacion = "";
	CategoriaComida categoriaComidaActual;
	
	private final HoraTiempo horaInicioHorario = new HoraTiempo(7, 0);// Hora a la que puede iniciar el horario 
	private final HoraTiempo horaFinHorario = new HoraTiempo(20, 0); // hora en la que debe culminar cualquier actividad
	private final int tiempoSeparacionLapsos = 60; // se encuentra en minutos
	
	public CFCategoriasComidas(FCategoriasComidas formComidasCategorias)
	{
		this.formCategoriaComida = formComidasCategorias;
		categoriaComidaActual = new CategoriaComida();
	}
	
	public void onLoad()
	{
		session = Coneccion.getSqlSessionFactory().openSession();
		daoCategoriaComidaMapper = session.getMapper(CategoriaComidaMapper.class);
		modeloCategoriaComida = new ModeloCategoriaComidas();
		
		formCategoriaComida.getjTableCategoriaComida().setModel(modeloCategoriaComida);
		formCategoriaComida.getTxtCodigo().setEnabled(false);	
		
		formCategoriaComida.getBtnAceptar().addActionListener(this);
		formCategoriaComida.getBtnNuevo().addActionListener(this);
		formCategoriaComida.getBtnCancelar().addActionListener(this);
		formCategoriaComida.getBtnModificar().addActionListener(this);
		formCategoriaComida.getBtnEliminar().addActionListener(this);
		formCategoriaComida.getBtnCerrar().addActionListener(this);
		
		formCategoriaComida.getcBoxEstado().addItem("HABILITADO");
		formCategoriaComida.getcBoxEstado().addItem("DESHABILITADO");
		
		habilitarControles(false);
		habilitarBotones(true, false, false, false, false);
		modeloCategoriaComida.setListCategoriaComida(daoCategoriaComidaMapper.selectByExample(null));
		formCategoriaComida.getjTableCategoriaComida().getSelectionModel().addListSelectionListener(this);
		formCategoriaComida.getjTableCategoriaComida().getColumn("Codigo").setPreferredWidth(5);
		FormUtilities.centrar(formCategoriaComida);
		
		cargarComboBoxHorarioInicio();
		
//		mostrarParaInsercion(null);
	}
	
	public void cargarComboBoxHorarioInicio(){
		int divisionHora = 60/tiempoSeparacionLapsos;		
		HoraTiempo tiempoInicio = new HoraTiempo(horaInicioHorario);
		int tiempoTotal = Math.abs(horaInicioHorario.diferenciaTiempoMinutos(horaFinHorario));
		int horas = 0;
		System.out.println(tiempoTotal);
		formCategoriaComida.getcBoxHoraInicio().removeAllItems();
		int totalHoras = ((tiempoTotal/60) * divisionHora );
		for (horas = 0; horas < totalHoras;  horas++) {
			formCategoriaComida.getcBoxHoraInicio()
					.addItem(tiempoInicio);
			

			try {
				tiempoInicio = (HoraTiempo) tiempoInicio.clone();
				tiempoInicio.addMinuts(tiempoSeparacionLapsos);
				formCategoriaComida.getcBoxHoraFin().addItem((HoraTiempo)tiempoInicio.clone());
			
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		formCategoriaComida.getcBoxHoraInicio().setSelectedIndex(-1);
		formCategoriaComida.getcBoxHoraFin().setSelectedIndex(-1);

			
	}
	
	public void mostrarParaInsercion(CategoriaComida categoriaComidaAux)
	{
		limpiarControles();
		if(categoriaComidaAux != null) //para edicion
		{
			tipoOperacion = "E";
			cargarDatos(categoriaComidaAux);
		}
		else
		{
			tipoOperacion = "I";
		}
		
		
		habilitarControles(true);
		habilitarBotones(false, true, false, false, false);
		formCategoriaComida.mostrorSoloControles();
		formCategoriaComida.getcBoxEstado().setSelectedItem("HABILITADO");
	}
	
	public void limpiarControles()
	{
		formCategoriaComida.getTxtCodigo().setText("");
		formCategoriaComida.getTxtDescripcion().setText("");
		formCategoriaComida.getTxtNombre().setText("");
		formCategoriaComida.getSliderOrden().setValue(0);
		formCategoriaComida.getcBoxEstado().setSelectedIndex(-1);
		formCategoriaComida.getcBoxHoraFin().setSelectedIndex(-1);
		formCategoriaComida.getcBoxHoraInicio().setSelectedIndex(-1);
	}
	
	public void habilitarControles(boolean estadHabilitacion)
	{
		formCategoriaComida.getTxtNombre().setEnabled(estadHabilitacion);
		formCategoriaComida.getTxtDescripcion().setEnabled(estadHabilitacion);
		formCategoriaComida.getSliderOrden().setEnabled(estadHabilitacion);
		formCategoriaComida.getcBoxEstado().setEnabled(estadHabilitacion);
		formCategoriaComida.getcBoxHoraFin().setEnabled(estadHabilitacion);
		formCategoriaComida.getcBoxHoraInicio().setEnabled(estadHabilitacion);
//		formCategoriaComida.getjTableCategoriaComida().setEnabled(estadHabilitacion);
		
	}
	
	public boolean validarControles()
	{
		if(formCategoriaComida.getTxtNombre().getText().trim().isEmpty())
		{
			JOptionPane.showMessageDialog(formCategoriaComida, "A\u00FAn no ha ingresado el nombre del Categoria", "Categoria Comida", JOptionPane.ERROR_MESSAGE);
			formCategoriaComida.getTxtNombre().grabFocus();
			return false;
		}
		if(formCategoriaComida.getSliderOrden().getValue() == 0)
		{
			JOptionPane.showMessageDialog(formCategoriaComida, "A\u00FAn no ha ingresado el Orden de posicion de la categoria", "Categoria Comida", JOptionPane.ERROR_MESSAGE);
			formCategoriaComida.getSliderOrden().grabFocus();
			return false;
		}
		if(formCategoriaComida.getcBoxEstado().getSelectedIndex() < 0)
		{
			JOptionPane.showMessageDialog(formCategoriaComida, "A\u00FAn no ha seleccionado el Estado", "Categoria Comida", JOptionPane.ERROR_MESSAGE);
			formCategoriaComida.getcBoxEstado().grabFocus();
			return false;
		}
		
		if(formCategoriaComida.getcBoxHoraInicio().getSelectedIndex() < 0)
		{
			JOptionPane.showMessageDialog(formCategoriaComida, "A\u00FAn no ha seleccionado la hora de inicio", "Categoria Comida", JOptionPane.ERROR_MESSAGE);
			formCategoriaComida.getcBoxHoraInicio().grabFocus();
			return false;
		}
		if(formCategoriaComida.getcBoxHoraFin().getSelectedIndex() < 0)
		{
			JOptionPane.showMessageDialog(formCategoriaComida, "A\u00FAn no ha seleccionado la hora de culminacion", "Categoria Comida", JOptionPane.ERROR_MESSAGE);
			formCategoriaComida.getcBoxHoraFin().grabFocus();
			return false;
		}
		
		if( ((HoraTiempo)formCategoriaComida.getcBoxHoraInicio().getSelectedItem()).compareTo(((HoraTiempo)formCategoriaComida.getcBoxHoraFin().getSelectedItem())) >= 0  )
		{
			JOptionPane.showMessageDialog(formCategoriaComida, "La hora de inicio no puede ser SUPERIOR O IGUAL a la hora de culminacion", "Categoria Comida", JOptionPane.ERROR_MESSAGE);
			formCategoriaComida.getcBoxHoraInicio().grabFocus();
			return false;
		}
		
		CategoriaComidaExample filtro = new CategoriaComidaExample();
		filtro.or().andNombreCategoriaEqualTo(formCategoriaComida.getTxtNombre().getText().toUpperCase());
		if(tipoOperacion.compareTo("I") == 0 && daoCategoriaComidaMapper.countByExample(filtro) > 0)
		{
			JOptionPane.showMessageDialog(formCategoriaComida, "El nombre de la Categoria ya se encuentra registrada", "Categoria Comida", JOptionPane.ERROR_MESSAGE);
			formCategoriaComida.getTxtNombre().grabFocus();
			return false;
		}
		
		filtro.clear();
		filtro.or().andOrdenCategoriaEqualTo(formCategoriaComida.getSliderOrden().getValue());
		if(tipoOperacion.compareTo("I") == 0 && daoCategoriaComidaMapper.countByExample(filtro) > 0)
		{
			JOptionPane.showMessageDialog(formCategoriaComida, "El orden de la Categoria ya se encuentra registrada", "Categoria Comida", JOptionPane.ERROR_MESSAGE);
			formCategoriaComida.getSliderOrden().grabFocus();
			return false;
		}
		
		return true;
	}
	
	public void habilitarBotones(boolean nuevo, boolean aceptar, boolean cancelar,
			boolean modificar, boolean eliminar)
	{
		formCategoriaComida.getBtnAceptar().setEnabled(aceptar);
		formCategoriaComida.getBtnNuevo().setEnabled(nuevo);
		formCategoriaComida.getBtnCancelar().setEnabled(cancelar);
		formCategoriaComida.getBtnModificar().setEnabled(modificar);
		formCategoriaComida.getBtnEliminar().setEnabled(eliminar);
	}
	
	public void cargarDatos(CategoriaComida categoriaComidaAux)
	{
		if(categoriaComidaAux != null)
		{
			categoriaComidaActual = categoriaComidaAux;
			formCategoriaComida.getTxtCodigo().setText(categoriaComidaAux.getCodigoCategoria().toString());
			formCategoriaComida.getTxtNombre().setText(categoriaComidaAux.getNombreCategoria());
			formCategoriaComida.getTxtDescripcion().setText(categoriaComidaAux.getDescripcion());
			formCategoriaComida.getSliderOrden().setValue(categoriaComidaAux.getOrdenCategoria());
			formCategoriaComida.getcBoxEstado().setSelectedItem(categoriaComidaAux.getEstado());
			if(categoriaComidaAux.getHoraInicio() != null)
				formCategoriaComida.getcBoxHoraInicio().setSelectedItem(HoraTiempo.toHoraTiempo(categoriaComidaAux.getHoraInicio()));
			else
				formCategoriaComida.getcBoxHoraInicio().setSelectedIndex(-1);
			if(categoriaComidaAux.getHoraFin() != null)			
				formCategoriaComida.getcBoxHoraFin().setSelectedItem(HoraTiempo.toHoraTiempo(categoriaComidaAux.getHoraFin()));
			else
				formCategoriaComida.getcBoxHoraFin().setSelectedIndex(-1);
			habilitarBotones(true, false, true, true, true);
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(formCategoriaComida.getBtnAceptar().equals(event.getSource()))
		{
			if(validarControles())
			{
				try {
					categoriaComidaActual = new CategoriaComida();
					categoriaComidaActual.setCodigoCategoria(-1);
					categoriaComidaActual.setNombreCategoria(formCategoriaComida.getTxtNombre().getText().toUpperCase());
					categoriaComidaActual.setDescripcion(formCategoriaComida.getTxtDescripcion().getText());
					categoriaComidaActual.setOrdenCategoria(formCategoriaComida.getSliderOrden().getValue());
					categoriaComidaActual.setEstadoCategoria(formCategoriaComida.getcBoxEstado().getSelectedItem().toString().compareTo("HABILITADO") == 0 ? "A" : "B");
					categoriaComidaActual.setHoraInicio(((HoraTiempo)formCategoriaComida.getcBoxHoraInicio().getSelectedItem()).toDate());
					categoriaComidaActual.setHoraFin(((HoraTiempo)formCategoriaComida.getcBoxHoraFin().getSelectedItem()).toDate());
					if(tipoOperacion.compareTo("I")==0)
					{
						daoCategoriaComidaMapper.insert(categoriaComidaActual);
						session.commit();
						
						Map<String, Integer> mapa = new HashMap<String, Integer>();
						mapa.put("ultimoId", 0);
						daoCategoriaComidaMapper.obtenerUltimoId(mapa); //("myMappedStatement",myParams);
						categoriaComidaActual.setCodigoCategoria(mapa.get("ultimoId"));
						
//					System.out.println("codigo actual = " + CategoriaComidaActual.getCodigoCategoriaComida());
						modeloCategoriaComida.AnadirCategoriaComida(categoriaComidaActual);
					}
					else
					{
						modeloCategoriaComida.setCategoriaComida(formCategoriaComida.getjTableCategoriaComida().getSelectedRow(), categoriaComidaActual);
						categoriaComidaActual.setCodigoCategoria(Integer.parseInt(formCategoriaComida.getTxtCodigo().getText()));
						daoCategoriaComidaMapper.updateByPrimaryKey(categoriaComidaActual);
						session.commit();
						
						
					}
					
					if(!formCategoriaComida.getBtnNuevo().isVisible())
					{
						
						formCategoriaComida.setVisible(false);
						formCategoriaComida.dispose();
						return;
					}
					tipoOperacion ="";
					habilitarBotones(true, false, false, true, true);
					habilitarControles(false);
					JOptionPane.showMessageDialog(formCategoriaComida, "Operaci\u00F3n realizada correctamente con el registro actual", "Informes", JOptionPane.INFORMATION_MESSAGE);
				}
				catch (org.apache.ibatis.exceptions.PersistenceException   e) {
//				catch (org.postgresql.util.PSQLException   e) {
					System.out.println("Error " + e.getMessage());
					
//					JOptionPane.showMessageDialog(formCategoriaComida, "Ocurri\u00F3 la siguiente excepcion " +  e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					if (e.getCause() == null) {
//				        throw e; // not what you're interested in, throw it back
				        System.out.println(e);
				    }
				    Exception nested = (Exception) e.getCause().getCause();
				    if (nested instanceof SQLIntegrityConstraintViolationException) {
				      SQLIntegrityConstraintViolationException constraintViolation = (SQLIntegrityConstraintViolationException)nested;
				      String message = constraintViolation.getMessage();
				      String sqlState = constraintViolation.getSQLState();
				      int errorCode = constraintViolation.getErrorCode();
				      
				      JOptionPane.showMessageDialog(formCategoriaComida, "Ocurri\u00F3 la siguiente excepcion " + message, "Error", JOptionPane.ERROR_MESSAGE);
				      // create validation message or whatever
				    } else {
//				        throw e; // not what you're interested in, throw it back
				    	System.out.println(e);
				    }
				}
				catch (Exception e) {
				// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(formCategoriaComida, "Ocurri\u00F3 la siguiente excepcion " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
					System.out.println(e);
				}
			}
			
		}
		if(formCategoriaComida.getBtnNuevo().equals(event.getSource()))
		{
			habilitarBotones(false, true, true, false, false);
			habilitarControles(true);
			limpiarControles();
			tipoOperacion = "I";
			formCategoriaComida.getcBoxEstado().setSelectedItem("HABILITADO");
			formCategoriaComida.getjTableCategoriaComida().clearSelection();
		}
		if(formCategoriaComida.getBtnCerrar().equals(event.getSource()))
		{
			formCategoriaComida.setVisible(false);
			formCategoriaComida.dispose();
			
		}
		if(formCategoriaComida.getBtnModificar().equals(event.getSource()))
		{
			habilitarBotones(false, true, true, false, false);
			habilitarControles(true);			
			tipoOperacion = "E";
			
		}
		if(formCategoriaComida.getBtnEliminar().equals(event.getSource()))
		{
			if(JOptionPane.showConfirmDialog(formCategoriaComida, "¿Se encuentra seguro de eliminar el registro actual?", "CategoriaComidas", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			{
				System.out.println("Elemento a eliminar " + Integer.parseInt(formCategoriaComida.getTxtCodigo().getText()));
				
				modeloCategoriaComida.eliminarCategoriaComida(formCategoriaComida.getjTableCategoriaComida().getSelectedRow());
				
				
				daoCategoriaComidaMapper.deleteByPrimaryKey(Integer.parseInt(formCategoriaComida.getTxtCodigo().getText()));
				
				session.commit();
				
				limpiarControles();
				JOptionPane.showMessageDialog(formCategoriaComida, "Objeto eliminado correctamente", "CategoriaComida", JOptionPane.INFORMATION_MESSAGE);
				habilitarBotones(true, false, false, false, false);
			}
			
		}
		
		if(formCategoriaComida.getBtnCancelar().equals(event.getSource()))
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
		cargarDatos(modeloCategoriaComida.obtenerCategoriaComida(indice));
		
	}

}
