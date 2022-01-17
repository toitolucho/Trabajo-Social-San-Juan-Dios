package org.quarkbit.trabajosocialsanjuan.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import org.apache.ibatis.session.SqlSession;
import org.quarkbit.trabajosocialsanjuan.dao.Coneccion;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Consulta;
import org.quarkbit.trabajosocialsanjuan.dao.domain.HistorialClinicoConsultaDetalle;
import org.quarkbit.trabajosocialsanjuan.dao.domain.HistorialClinicoConsultaDetalleExample;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Persona;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PropiedadHistorialClinico;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PropiedadTipo;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.ConsultaMapper;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.HistorialClinicoConsultaDetalleMapper;
import org.quarkbit.trabajosocialsanjuan.formularios.FConsulta;
import org.quarkbit.trabajosocialsanjuan.formularios.FConsultaHCCategoriasDescripcion;
import org.quarkbit.trabajosocialsanjuan.formularios.tablemodels.ModeloPropiedadesHistorialClinico;
import org.quarkbit.trabajosocialsanjuan.utils.FormUtilities;

public class CFConsulta implements ActionListener{
	
	FConsulta formConsulta;
	SqlSession session;
	
	Consulta consultaActual;
	PropiedadHistorialClinico propiedadHCDetalle;
	PropiedadTipo propiedadTipo;	
	ConsultaMapper daoConsulta;
	HistorialClinicoConsultaDetalleMapper daoHistorialClinicoConsultaDetalle;
	ModeloPropiedadesHistorialClinico modeloConsultaDetalle;
	
	
	public String tipoOperacion;
	public Persona ninoActual;
	public int numero_consulta_actual = -1;
	
	public int numeroHistorialClinico;
	public boolean operacionConfirmada = false;
	public CFConsulta(FConsulta formConsulta )
	{
		this.formConsulta = formConsulta;
		modeloConsultaDetalle = new ModeloPropiedadesHistorialClinico();
		tipoOperacion = "I";
		
		session = Coneccion.getSqlSessionFactory().openSession();
		daoConsulta = session.getMapper(ConsultaMapper.class);
		daoHistorialClinicoConsultaDetalle = session.getMapper(HistorialClinicoConsultaDetalleMapper.class);
	}
	

	public void setNinoActual(Persona ninoActual) {
		this.ninoActual = ninoActual;
	}
	public Persona getNinoActual() {
		return ninoActual;
	}
	public void onFormShown()
	{
		formConsulta.getBtnAceptar().addActionListener(this);
		formConsulta.getBtnAgregarPropiedad().addActionListener(this);
		formConsulta.getBtnCancelar().addActionListener(this);
		formConsulta.getBtnEliminarCategoria().addActionListener(this);
		formConsulta.getBtnModificar().addActionListener(this);
		
		if(ninoActual != null)
		{
			formConsulta.lblDatosNino.setText(ninoActual.obtenerNombreCompleto());
			formConsulta.getTxtNroHC().setText(String.valueOf(numeroHistorialClinico));
			
		}
		formConsulta.getDateFechaRegistro().setDate(Calendar.getInstance().getTime());
		formConsulta.getTableCategorias().setModel(modeloConsultaDetalle);
		FormUtilities.centrar(formConsulta);
		
	}
	
	public void cargarDatos(Consulta consultaNueva)
	{
		if(consultaNueva != null)
		{
		
			this.consultaActual = consultaNueva;
//			ninoActual = consultaNueva.getPersona();
			
			formConsulta.getcBoxTipoConsulta().setSelectedItem("");
			formConsulta.getTxtDiagnostico().setText(consultaNueva.getDiagnostico());
			formConsulta.getDateFechaRegistro().setDate(consultaNueva.getFechaConsulta());
			formConsulta.getTxtMotivo().setText(consultaNueva.getMotivo());
			formConsulta.getTxtNroHC().setText(String.valueOf(consultaNueva.getNumeroHistorialClinico()));
			formConsulta.getTxtObservaciones().setText(consultaNueva.getObservaciones());
			formConsulta.getNroConsulta().setText(String.valueOf(consultaActual.getNumeroConsulta()));
			
			tipoOperacion = "E";
			
			
			HistorialClinicoConsultaDetalleExample filtro = new HistorialClinicoConsultaDetalleExample();
			filtro.or().andNumeroHistorialClinicoEqualTo(consultaNueva.getNumeroHistorialClinico()).andNumeroConsultaEqualTo(consultaActual.getNumeroConsulta());
			for (HistorialClinicoConsultaDetalle elemento : daoHistorialClinicoConsultaDetalle.selectByExample(filtro)) {
				PropiedadHistorialClinico nuevo = elemento.getPropiedadHistorialClinico();
				nuevo.setPropiedadTipo(elemento.getPropiedadTipo());
				nuevo.setDescripcion(elemento.getDescripcion());
				
				modeloConsultaDetalle.AnadirPropiedadHistorialClinico(nuevo);
			}
			
			
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		if(event.getActionCommand().compareTo("EliminarCategoria") == 0 )
		{
			if(formConsulta.getTableCategorias().getSelectedRow() < 0)
			{
				JOptionPane.showMessageDialog(formConsulta, "No ha seleccionado ning\u00FAn elemento", "Consulta", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			else
			{
				modeloConsultaDetalle.eliminarPropiedadHistorialClinico(formConsulta.getTableCategorias().getSelectedRow());
			}
			
		}
		if(event.getSource().equals(formConsulta.getBtnAgregarPropiedad()))		
//		if(event.getActionCommand().compareTo("AgregarCategoria") == 0)
		{
			FConsultaHCCategoriasDescripcion formNuevaPropiedad = new FConsultaHCCategoriasDescripcion(null);
			formNuevaPropiedad.setVisible(true);
			if(formNuevaPropiedad.control.operacionCorrecta)
			{
				PropiedadHistorialClinico nuevo = new PropiedadHistorialClinico();
				
				nuevo.setAbreviacion("");
				nuevo.setComposicion("");
				nuevo.setPropiedadTipo(formNuevaPropiedad.control.propiedadTipoSeleccionada);
				nuevo.setNombrePropiedad(formNuevaPropiedad.control.propiedadHistorialClinicoSeleccionado.getNombrePropiedad());
				nuevo.setDescripcion(formNuevaPropiedad.control.descripcion);
				nuevo.setNumeroPropiedad(formNuevaPropiedad.control.propiedadHistorialClinicoSeleccionado.getNumeroPropiedad());
				nuevo.setNumeroPropiedadTipo(formNuevaPropiedad.control.propiedadTipoSeleccionada.getNumeroPropiedadTipo());
				modeloConsultaDetalle.AnadirPropiedadHistorialClinico(nuevo);
			}
			else
				formNuevaPropiedad.dispose();
		}
		
		if(event.getActionCommand().compareTo("Aceptar") == 0)
		{
			if(formConsulta.getDateFechaRegistro().getDate() == null)
			{
				JOptionPane.showMessageDialog(formConsulta, "No ha seleccionado la fecha de Consulta", "Consulta", JOptionPane.ERROR_MESSAGE);
				formConsulta.getDateFechaRegistro().grabFocus();
				return;
			}
			if(formConsulta.getcBoxTipoConsulta().getSelectedIndex() < 0)
			{
				JOptionPane.showMessageDialog(formConsulta, "No ha seleccionado el tipo de Consulta", "Consulta", JOptionPane.ERROR_MESSAGE);
				formConsulta.getcBoxTipoConsulta().grabFocus();
				return;
			}
			if(formConsulta.getTxtMotivo().getText().isEmpty())
			{
				JOptionPane.showMessageDialog(formConsulta, "No llenado el motivo de la consulta", "Consulta", JOptionPane.ERROR_MESSAGE);
				formConsulta.getTxtMotivo().grabFocus();
				return;
			}
			if(formConsulta.getTxtDiagnostico().getText().isEmpty())
			{
				JOptionPane.showMessageDialog(formConsulta, "No llenado el diagn\u00F3stico de la consulta", "Consulta", JOptionPane.ERROR_MESSAGE);
				formConsulta.getTxtDiagnostico().grabFocus();
				return;
			}
			
			if(modeloConsultaDetalle.getRowCount() == 0
					&& JOptionPane.showConfirmDialog(formConsulta, "¿Se encuentra seguro de crear una Consulta sin ninguna categoria de consulta como medicamentos u otros?", "Consulta M\u00E9dica", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION)
			{				
				return;
			}
			
			
			if(tipoOperacion.compareTo("I") == 0)
			{
				consultaActual = new Consulta();
				consultaActual.setCodigoTipoConsulta(String.valueOf(formConsulta.getcBoxTipoConsulta().getSelectedItem().toString().charAt(0)));
				consultaActual.setDiagnostico(formConsulta.getTxtDiagnostico().getText());
				consultaActual.setFechaConsulta(formConsulta.getDateFechaRegistro().getDate());
				consultaActual.setMotivo(formConsulta.getTxtMotivo().getText());
				consultaActual.setNumeroConsulta(-1);
				consultaActual.setNumeroHistorialClinico(numeroHistorialClinico);
				consultaActual.setObservaciones(formConsulta.getTxtObservaciones().getText());
				consultaActual.setPersona(ninoActual);
				
				daoConsulta.insert(consultaActual);
				session.commit();
				
				
				Map<String, Integer> mapa = new HashMap<String, Integer>();
				mapa.put("ultimoId", 0);
				daoConsulta.obtenerUltimoId(mapa); //("myMappedStatement",myParams);
				consultaActual.setNumeroConsulta(mapa.get("ultimoId"));
				formConsulta.getNroConsulta().setText(String.valueOf(mapa.get("ultimoId")));
				numero_consulta_actual = consultaActual.getNumeroConsulta();
				
				for (PropiedadHistorialClinico elemento : modeloConsultaDetalle.getListaPropiedadHistorialClinico()) {
					HistorialClinicoConsultaDetalle consultaDetalle = new HistorialClinicoConsultaDetalle();
					consultaDetalle.setDescripcion(elemento.getDescripcion());
					consultaDetalle.setFechaRegistro(consultaActual.getFechaConsulta());
					consultaDetalle.setNumeroConsulta(consultaActual.getNumeroConsulta());
					consultaDetalle.setNumeroHCConsultaDetalle(-1);
					consultaDetalle.setNumeroHistorialClinico(numeroHistorialClinico);
					consultaDetalle.setNumeroPropiedad(elemento.getNumeroPropiedad());
					consultaDetalle.setNumeroPropiedadTipo(elemento.getPropiedadTipo().getNumeroPropiedadTipo());
					
					daoHistorialClinicoConsultaDetalle.insert(consultaDetalle);
					
				}
				session.commit();
				
				operacionConfirmada = true;
				
			}
			else				
			{				
				consultaActual.setCodigoTipoConsulta(String.valueOf(formConsulta.getcBoxTipoConsulta().getSelectedItem().toString().charAt(0)));
				consultaActual.setDiagnostico(formConsulta.getTxtDiagnostico().getText());
				consultaActual.setFechaConsulta(formConsulta.getDateFechaRegistro().getDate());
				consultaActual.setMotivo(formConsulta.getTxtMotivo().getText());				
				consultaActual.setNumeroHistorialClinico(numeroHistorialClinico);
				consultaActual.setObservaciones(formConsulta.getTxtObservaciones().getText());
				consultaActual.setPersona(ninoActual);
				
				daoConsulta.updateByPrimaryKey(consultaActual);				
				session.commit();
				
				HistorialClinicoConsultaDetalleExample filtro =new HistorialClinicoConsultaDetalleExample();
				filtro.or().andNumeroConsultaEqualTo(consultaActual.getNumeroConsulta());
				daoHistorialClinicoConsultaDetalle.deleteByExample(filtro);
				session.commit();
				
				numero_consulta_actual = consultaActual.getNumeroConsulta();
				
				for (PropiedadHistorialClinico elemento : modeloConsultaDetalle.getListaPropiedadHistorialClinico()) {
					HistorialClinicoConsultaDetalle consultaDetalle = new HistorialClinicoConsultaDetalle();
					consultaDetalle.setDescripcion(elemento.getDescripcion());
					consultaDetalle.setFechaRegistro(consultaActual.getFechaConsulta());
					consultaDetalle.setNumeroConsulta(consultaActual.getNumeroConsulta());
					consultaDetalle.setNumeroHCConsultaDetalle(-1);
					consultaDetalle.setNumeroHistorialClinico(numeroHistorialClinico);
					consultaDetalle.setNumeroPropiedad(elemento.getNumeroPropiedad());
					consultaDetalle.setNumeroPropiedadTipo(elemento.getPropiedadTipo().getNumeroPropiedadTipo());
					
					daoHistorialClinicoConsultaDetalle.insert(consultaDetalle);
					
				}
				session.commit();
				
				operacionConfirmada = true;
			}
			operacionConfirmada = true;
			this.formConsulta.setVisible(false);
		}
		
		if(event.getActionCommand().compareTo("Cancelar") == 0)
		{
			operacionConfirmada =false;
			this.formConsulta.setVisible(false);
			this.formConsulta.dispose();
		}
		if(event.getActionCommand().compareTo("Modificar") == 0)
		{
			if(formConsulta.getTableCategorias().getSelectedRow() >= 0)
			{
				FConsultaHCCategoriasDescripcion formNuevaPropiedad = new FConsultaHCCategoriasDescripcion(null);
				formNuevaPropiedad.control.cargarDatos(modeloConsultaDetalle.obtenerPropiedadHistorialClinico(formConsulta.getTableCategorias().getSelectedRow()));
				formNuevaPropiedad.setVisible(true);
				if(formNuevaPropiedad.control.operacionCorrecta)
				{
					//PropiedadHistorialClinico
					PropiedadHistorialClinico modificado = modeloConsultaDetalle.obtenerPropiedadHistorialClinico(formConsulta.getTableCategorias().getSelectedRow());
					
					modificado.setPropiedadTipo(formNuevaPropiedad.control.propiedadTipoSeleccionada);
					modificado.setNombrePropiedad(formNuevaPropiedad.control.propiedadHistorialClinicoSeleccionado.getNombrePropiedad());
					modificado.setDescripcion(formNuevaPropiedad.control.descripcion);
					modificado.setNumeroPropiedad(formNuevaPropiedad.control.propiedadHistorialClinicoSeleccionado.getNumeroPropiedad());
					modificado.setNumeroPropiedadTipo(formNuevaPropiedad.control.propiedadTipoSeleccionada.getNumeroPropiedadTipo());
					
					
					modeloConsultaDetalle.setPropiedadHistorialClinico(formConsulta.getTableCategorias().getSelectedRow(), modificado);
				}
			}			
			else
			{
				JOptionPane.showMessageDialog(formConsulta, "No ha seleccionado ning\u00FAn elemento", "Consulta", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}


}
