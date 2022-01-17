package org.quarkbit.trabajosocialsanjuan.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.apache.ibatis.session.SqlSession;
import org.quarkbit.trabajosocialsanjuan.dao.Coneccion;
import org.quarkbit.trabajosocialsanjuan.dao.domain.ConsultaExample;
import org.quarkbit.trabajosocialsanjuan.dao.domain.HistorialClinico;
import org.quarkbit.trabajosocialsanjuan.dao.domain.HistorialClinicoConsultaDetalleExample;
import org.quarkbit.trabajosocialsanjuan.dao.domain.HistorialClinicoExample;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Persona;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PersonaDatosNacimiento;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.ConsultaMapper;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.HistorialClinicoConsultaDetalleMapper;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.HistorialClinicoMapper;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.PersonaDatosNacimientoMapper;
import org.quarkbit.trabajosocialsanjuan.formularios.FConsulta;
import org.quarkbit.trabajosocialsanjuan.formularios.FHistorialClinico;
import org.quarkbit.trabajosocialsanjuan.formularios.FPersonasBuscador;
import org.quarkbit.trabajosocialsanjuan.formularios.tablemodels.ModeloConsultas;
import org.quarkbit.trabajosocialsanjuan.formularios.tablemodels.ModeloHCConsultasDetalle;
import org.quarkbit.trabajosocialsanjuan.utils.FormUtilities;
import org.quarkbit.trabajosocialsanjuan.utils.GeneraReport;

public class CFHistorialClinico implements ActionListener, DocumentListener {
	
	FHistorialClinico formHistorialClinico;
	private String tipoOperacion ="";
	HistorialClinico historialClinicoActual;	
	Persona personaActual;
	PersonaDatosNacimiento ninoDatosNacimiento;
	SqlSession session;
	HistorialClinicoMapper daoHistorialClinicoMapper;
	HistorialClinicoConsultaDetalleMapper daoHistorialClinicoConsultaDetalleMapper;
	PersonaDatosNacimientoMapper daoPersonaDatosNacimientoMapper;
	ConsultaMapper daoConsultaMapper;
	ConsultaExample filtroConsulta;
	
	ModeloHCConsultasDetalle modeloHCDetalleAlergias, modeloHCDetalleEnfermadesCronicas, modeloHCDetalleIncidentes,
			modeloHCDetalleLaboratorios, modeloHCDetalleMedicamentos, modeloHCDetalleVacunas, modeloHCDetalleVitaminas;
	
	ModeloConsultas modeloConsulta;
	
	
	private DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	public CFHistorialClinico(FHistorialClinico formHC)
	{
		this.formHistorialClinico = formHC;
		modeloHCDetalleAlergias = new ModeloHCConsultasDetalle();
		modeloHCDetalleEnfermadesCronicas = new ModeloHCConsultasDetalle();
		modeloHCDetalleIncidentes = new ModeloHCConsultasDetalle();
		modeloHCDetalleLaboratorios = new ModeloHCConsultasDetalle();
		modeloHCDetalleMedicamentos = new ModeloHCConsultasDetalle();
		modeloHCDetalleVacunas = new ModeloHCConsultasDetalle();
		modeloHCDetalleVitaminas = new ModeloHCConsultasDetalle();
		modeloConsulta = new ModeloConsultas();
		
		session = Coneccion.getSqlSessionFactory().openSession();
		daoHistorialClinicoMapper =  session.getMapper(HistorialClinicoMapper.class);
		daoHistorialClinicoConsultaDetalleMapper =  session.getMapper(HistorialClinicoConsultaDetalleMapper.class);
		daoPersonaDatosNacimientoMapper = session.getMapper(PersonaDatosNacimientoMapper.class);
		daoConsultaMapper = session.getMapper(ConsultaMapper.class);
		filtroConsulta = new ConsultaExample();
	}
	
	public void onFormShown()
	{
		habilitarComponentes(false);
		habilitarBotones(true, false, false, false, false, true, false, false);
		limpiarComponentes();
		formHistorialClinico.getTableAlergias().setModel(modeloHCDetalleAlergias);
		formHistorialClinico.getTableEnfermedadesCronicas().setModel(modeloHCDetalleEnfermadesCronicas);
		formHistorialClinico.getTableIncidentes().setModel(modeloHCDetalleIncidentes);
		formHistorialClinico.getTableLaboratorios().setModel(modeloHCDetalleLaboratorios);
		formHistorialClinico.getTableMedicamentos().setModel(modeloHCDetalleMedicamentos);
		formHistorialClinico.getTableVacunas().setModel(modeloHCDetalleVacunas);
		formHistorialClinico.getTableVitaminas().setModel(modeloHCDetalleVitaminas);
		formHistorialClinico.getTableConsultas().setModel(modeloConsulta);
		
		formHistorialClinico.getBtnAceptar().addActionListener(this);
		formHistorialClinico.getBtnBuscar().addActionListener(this);
		formHistorialClinico.getBtnCancelar().addActionListener(this);
		formHistorialClinico.getBtnCerrar().addActionListener(this);
		formHistorialClinico.getBtnConsulta().addActionListener(this);
		formHistorialClinico.getBtnEliminar().addActionListener(this);
		formHistorialClinico.getBtnModificar().addActionListener(this);
		formHistorialClinico.getBtnNuevo().addActionListener(this);
		formHistorialClinico.getBtnReporte().addActionListener(this);
		formHistorialClinico.getMntmModificar().addActionListener(this);
		formHistorialClinico.getMntmEliminar().addActionListener(this);
		formHistorialClinico.getMntmReporte().addActionListener(this);
		formHistorialClinico.getTxtTextoBusqueda().addActionListener(this);
		formHistorialClinico.getBtnBuscarConsulta().addActionListener(this);

		
		formHistorialClinico.getTableConsultas().getColumnModel().getColumn(0).setPreferredWidth(0);
		formHistorialClinico.getTableConsultas().getColumnModel().getColumn(0).setMinWidth(0);
		formHistorialClinico.getTableConsultas().getColumnModel().getColumn(0).setMaxWidth(0);
		formHistorialClinico.getTableConsultas().getColumnModel().getColumn(0).setWidth(0);
		
		formHistorialClinico.getTableConsultas().getColumnModel().getColumn(1).setPreferredWidth(0);
		formHistorialClinico.getTableConsultas().getColumnModel().getColumn(1).setMinWidth(0);
		formHistorialClinico.getTableConsultas().getColumnModel().getColumn(1).setMaxWidth(0);
		formHistorialClinico.getTableConsultas().getColumnModel().getColumn(1).setWidth(0);
		formHistorialClinico.getTxtTextoBusqueda().getDocument().addDocumentListener(this);
		
		FormUtilities.centrar(formHistorialClinico);
	}
	
	public void cargarDatos(HistorialClinico hcNuevo)
	{
		if(hcNuevo != null)
		{
			formHistorialClinico.getTxtGrupoSanguineo().setText(hcNuevo.getGrupoSanguinio());
			formHistorialClinico.getTxtNroHC().setText(String.valueOf(hcNuevo.getNumeroHistorialClinico()));
			formHistorialClinico.getDateFechaRegistro().setDate(hcNuevo.getFecha_registro());
			
			if(personaActual != null)
			{
				ninoDatosNacimiento =  daoPersonaDatosNacimientoMapper.selectByPrimaryKey(personaActual.getCodigoPersona());
				
				formHistorialClinico.getLblNombreCompleto().setText(personaActual.obtenerNombreCompleto());
				formHistorialClinico.getLblFechaNacimiento().setText(df.format(ninoDatosNacimiento.getFechaNacimiento()));
				formHistorialClinico.getLblEdad().setText(String.valueOf(ninoDatosNacimiento.getEdad()));
			}
			
			//VACUNAS
			HistorialClinicoConsultaDetalleExample filtro = new HistorialClinicoConsultaDetalleExample();
			filtro.or().andNumeroHistorialClinicoEqualTo(hcNuevo.getNumeroHistorialClinico()).andNumeroPropiedadTipoEqualTo(1);			
			modeloHCDetalleVacunas.setListHistorialClinicoConsultaDetalle(daoHistorialClinicoConsultaDetalleMapper.selectByExample(filtro));
			
			//ALERGIAS
			filtro.clear();
			filtro.or().andNumeroHistorialClinicoEqualTo(hcNuevo.getNumeroHistorialClinico()).andNumeroPropiedadTipoEqualTo(2);
			modeloHCDetalleAlergias.setListHistorialClinicoConsultaDetalle(daoHistorialClinicoConsultaDetalleMapper.selectByExample(filtro));
			
//			MEDICAMENTOS
			filtro.clear();
			filtro.or().andNumeroHistorialClinicoEqualTo(hcNuevo.getNumeroHistorialClinico()).andNumeroPropiedadTipoEqualTo(3);
			modeloHCDetalleMedicamentos.setListHistorialClinicoConsultaDetalle(daoHistorialClinicoConsultaDetalleMapper.selectByExample(filtro));
			
			//LABORATORIOS
			filtro.clear();
			filtro.or().andNumeroHistorialClinicoEqualTo(hcNuevo.getNumeroHistorialClinico()).andNumeroPropiedadTipoEqualTo(4);
			modeloHCDetalleLaboratorios.setListHistorialClinicoConsultaDetalle(daoHistorialClinicoConsultaDetalleMapper.selectByExample(filtro));
			
			//INCIDENTES O ENFERMEDADES
			filtro.clear();
			filtro.or().andNumeroHistorialClinicoEqualTo(hcNuevo.getNumeroHistorialClinico()).andNumeroPropiedadTipoEqualTo(5);
			modeloHCDetalleIncidentes.setListHistorialClinicoConsultaDetalle(daoHistorialClinicoConsultaDetalleMapper.selectByExample(filtro));
			
			//ENFERMEDADES CR\u00F3NICAS
			filtro.clear();
			filtro.or().andNumeroHistorialClinicoEqualTo(hcNuevo.getNumeroHistorialClinico()).andNumeroPropiedadTipoEqualTo(6);
			modeloHCDetalleEnfermadesCronicas.setListHistorialClinicoConsultaDetalle(daoHistorialClinicoConsultaDetalleMapper.selectByExample(filtro));
		
			//VITAMINAS Y MINERALES
			filtro.clear();
			filtro.or().andNumeroHistorialClinicoEqualTo(hcNuevo.getNumeroHistorialClinico()).andNumeroPropiedadTipoEqualTo(7);
			modeloHCDetalleVitaminas.setListHistorialClinicoConsultaDetalle(daoHistorialClinicoConsultaDetalleMapper.selectByExample(filtro));
//			System.out.println("HC = " + hcNuevo.getNumeroHistorialClinico() + "TAMANIO = " +daoHistorialClinicoConsultaDetalleMapper.selectByExample(filtro).size());
			habilitarBotones(true, false, false, true, true, true, true, true);
			
			//Cargamos las Consultas Hechas
			ConsultaExample filtroConsulta = new ConsultaExample();
			filtroConsulta.or().andNumeroHistorialClinicoEqualTo(hcNuevo.getNumeroHistorialClinico());
			modeloConsulta.setListConsulta(daoConsultaMapper.selectByExample(filtroConsulta));
		}
	}
	
	public void habilitarBotones(boolean nuevo, boolean aceptar, boolean cancelar, boolean eliminar, boolean modificar,
			boolean buscar, boolean reporte, boolean consulta)
	{
		formHistorialClinico.getBtnNuevo().setEnabled(nuevo);
		formHistorialClinico.getBtnAceptar().setEnabled(aceptar);
		formHistorialClinico.getBtnCancelar().setEnabled(cancelar);
		formHistorialClinico.getBtnEliminar().setEnabled(eliminar);
		formHistorialClinico.getBtnModificar().setEnabled(modificar);
		formHistorialClinico.getBtnBuscar().setEnabled(buscar);
		formHistorialClinico.getBtnReporte().setEnabled(reporte);
		formHistorialClinico.getBtnConsulta().setEnabled(consulta);
	}
	
	public void habilitarComponentes(boolean estadoHabilitacion)
	{
		formHistorialClinico.getTxtGrupoSanguineo().setEditable(estadoHabilitacion);
		formHistorialClinico.getDateFechaRegistro().setEnabled(estadoHabilitacion);
		
		formHistorialClinico.getTableAlergias().setEnabled(estadoHabilitacion);
		formHistorialClinico.getTableEnfermedadesCronicas().setEnabled(estadoHabilitacion);
		formHistorialClinico.getTableIncidentes().setEnabled(estadoHabilitacion);
		formHistorialClinico.getTableLaboratorios().setEnabled(estadoHabilitacion);
		formHistorialClinico.getTableMedicamentos().setEnabled(estadoHabilitacion);
		formHistorialClinico.getTableVacunas().setEnabled(estadoHabilitacion);
		formHistorialClinico.getTableVitaminas().setEnabled(estadoHabilitacion);
		
		formHistorialClinico.getDateFechaFin().setEnabled(!estadoHabilitacion);
		formHistorialClinico.getDateFechaInicio().setEnabled(!estadoHabilitacion);
		formHistorialClinico.getTxtTextoBusqueda().setEnabled(!estadoHabilitacion);
		formHistorialClinico.getBtnBuscarConsulta().setEnabled(!estadoHabilitacion);
		
		
	}
	
	public void limpiarComponentes()
	{
		formHistorialClinico.getTxtGrupoSanguineo().setText("");
		formHistorialClinico.getDateFechaRegistro().setDate(null);
		formHistorialClinico.getTxtNroHC().setText("");
		
		modeloHCDetalleAlergias.limpiar();
		modeloHCDetalleEnfermadesCronicas.limpiar();
		modeloHCDetalleIncidentes.limpiar();
		modeloHCDetalleLaboratorios.limpiar();
		modeloHCDetalleMedicamentos.limpiar();
		modeloHCDetalleVacunas.limpiar();
		modeloHCDetalleVitaminas.limpiar();
		modeloConsulta.limpiar();
		
		formHistorialClinico.getLblEdad().setText("");
		formHistorialClinico.getLblFechaNacimiento().setText("");
		formHistorialClinico.getLblNombreCompleto().setText("");
	}
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		// TODO Auto-generated method stub
		if(formHistorialClinico.getBtnCerrar().equals(evento.getSource()))
		{
			this.formHistorialClinico.setVisible(false);
			this.formHistorialClinico.dispose();
		}
		if(evento.getActionCommand().compareTo("ReporteConsulta") == 0)
		{
			if(formHistorialClinico.getTableConsultas().getSelectedRow() >= 0)
			{
				String path = FormUtilities.obtenerRutaLocal() + "org/quarkbit/trabajosocialsanjuan/reportes/";
				GeneraReport gr = new GeneraReport();			
				gr.loadReportJasper(path + "obtener_historial_consulta_detalle.jasper");
				gr.setParameters("numero_hc_aux",this.historialClinicoActual.getNumeroHistorialClinico());			
				gr.setParameters("numero_consulta_aux",modeloConsulta.obtenerConsulta(formHistorialClinico.getTableConsultas().getSelectedRow()).getNumeroConsulta());
				gr.setParameters("SUBREPORT_DIR", path);
				gr.fillReport(session.getConnection());			
				gr.previewReportModal();
			}
			else
			{
				JOptionPane.showMessageDialog(formHistorialClinico, "No ha seleccionado ningún elemento", "Historial clínico", JOptionPane.ERROR_MESSAGE);
			}
				
			
		}
		if(evento.getActionCommand().compareTo("ModificarConsulta") == 0)
		{
			if(formHistorialClinico.getTableConsultas().getSelectedRow() >= 0)
			{
				FConsulta formConsulta = new FConsulta(null);
				formConsulta.control.ninoActual = personaActual;
				formConsulta.control.numeroHistorialClinico = historialClinicoActual.getNumeroHistorialClinico();
				formConsulta.control.onFormShown();
				formConsulta.control.cargarDatos(modeloConsulta.obtenerConsulta(formHistorialClinico.getTableConsultas().getSelectedRow()));			
				formConsulta.setVisible(true);
				if(formConsulta.control.operacionConfirmada)
				{
					cargarDatos(historialClinicoActual);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(formHistorialClinico, "No ha seleccionado ningún elemento", "Historial clínico", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if(evento.getActionCommand().compareTo("EliminarConsulta") == 0)
		{
			if(formHistorialClinico.getTableConsultas().getSelectedRow() >= 0)
			{
				if(JOptionPane.showConfirmDialog(formHistorialClinico, "¿Se encuentra seguro de eliminar la consulta seleccionada?", "Historial Clínico", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
				{
					HistorialClinicoConsultaDetalleExample filtro = new HistorialClinicoConsultaDetalleExample();
					filtro.or().andNumeroConsultaEqualTo(modeloConsulta.obtenerConsulta(formHistorialClinico.getTableConsultas().getSelectedRow()).getNumeroConsulta());
					daoHistorialClinicoConsultaDetalleMapper.deleteByExample(filtro);
					session.commit();
					daoConsultaMapper.deleteByPrimaryKey(modeloConsulta.obtenerConsulta(formHistorialClinico.getTableConsultas().getSelectedRow()).getNumeroConsulta());
					modeloConsulta.eliminarConsulta(formHistorialClinico.getTableConsultas().getSelectedRow());
					session.commit();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(formHistorialClinico, "No ha seleccionado ningún elemento", "Historial clínico", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if(evento.getActionCommand().compareTo("BuscarConsulta") == 0)
		{
			if(historialClinicoActual == null)
			{
				JOptionPane.showMessageDialog(formHistorialClinico, "No ha seleccionado ningun Kardex", "Historial Clínico", JOptionPane.ERROR_MESSAGE);
				return;
			}
			filtroConsulta.clear();
			if(formHistorialClinico.getDateFechaInicio().getDate() != null
					&& formHistorialClinico.getDateFechaFin().getDate() != null && !formHistorialClinico.getTxtTextoBusqueda().getText().isEmpty())
			{
				
				filtroConsulta.or().andFechaConsultaBetween(formHistorialClinico.getDateFechaInicio().getDate(),  formHistorialClinico.getDateFechaFin().getDate()).andNumeroHistorialClinicoEqualTo(historialClinicoActual.getNumeroHistorialClinico()).andMotivoLike("%" + formHistorialClinico.getTxtTextoBusqueda().getText().toUpperCase() + "%");
				filtroConsulta.or().andFechaConsultaBetween(formHistorialClinico.getDateFechaInicio().getDate(),  formHistorialClinico.getDateFechaFin().getDate()).andNumeroHistorialClinicoEqualTo(historialClinicoActual.getNumeroHistorialClinico()).andDiagnosticoLike("%" + formHistorialClinico.getTxtTextoBusqueda().getText().toUpperCase() + "%");
				filtroConsulta.or().andFechaConsultaBetween(formHistorialClinico.getDateFechaInicio().getDate(),  formHistorialClinico.getDateFechaFin().getDate()).andNumeroHistorialClinicoEqualTo(historialClinicoActual.getNumeroHistorialClinico()).andObservacionesLike("%" + formHistorialClinico.getTxtTextoBusqueda().getText().toUpperCase() + "%");
				
			}
			else if(formHistorialClinico.getDateFechaInicio().getDate() != null
					&& formHistorialClinico.getDateFechaFin().getDate() != null && formHistorialClinico.getTxtTextoBusqueda().getText().isEmpty())
			{
				filtroConsulta.or().andFechaConsultaBetween(formHistorialClinico.getDateFechaInicio().getDate(),  formHistorialClinico.getDateFechaFin().getDate()).andNumeroHistorialClinicoEqualTo(historialClinicoActual.getNumeroHistorialClinico());
			}
			
			else if(!formHistorialClinico.getTxtTextoBusqueda().getText().isEmpty() && (formHistorialClinico.getDateFechaInicio().getDate()==null || formHistorialClinico.getDateFechaFin().getDate() == null))				
			{
				filtroConsulta.or().andMotivoLike("%" + formHistorialClinico.getTxtTextoBusqueda().getText().toUpperCase() + "%").andNumeroHistorialClinicoEqualTo(historialClinicoActual.getNumeroHistorialClinico());
				filtroConsulta.or().andDiagnosticoLike("%" + formHistorialClinico.getTxtTextoBusqueda().getText().toUpperCase()+ "%").andNumeroHistorialClinicoEqualTo(historialClinicoActual.getNumeroHistorialClinico());
				filtroConsulta.or().andObservacionesLike("%" + formHistorialClinico.getTxtTextoBusqueda().getText().toUpperCase() + "%").andNumeroHistorialClinicoEqualTo(historialClinicoActual.getNumeroHistorialClinico());
			}
			else
			{
				JOptionPane.showMessageDialog(formHistorialClinico, "No ha ingresado datos para realizar la busqueda", "Historial clínico", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			modeloConsulta.setListConsulta(daoConsultaMapper.selectByExample(filtroConsulta));
			
		}
		
		if(evento.getActionCommand().compareTo("Nuevo") == 0)
		{
			FPersonasBuscador formBuscador = new FPersonasBuscador(null);
			formBuscador.control.setTipoPersona("N");			
			formBuscador.setVisible(true);
			formBuscador.lblMensaje.setText("Seleccione el Nino");
			if(formBuscador.control.personaActual == null  || formBuscador.control.personaActual.getNombres() == null)
			{
				JOptionPane.showMessageDialog(formHistorialClinico, "No ha seleccionado ning\u00FAn niños, se cancelara la operacion actual", "Informes", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			this.personaActual = formBuscador.control.personaActual;
			HistorialClinicoExample filtro = new HistorialClinicoExample();
			filtro.or().andIdPersonaEqualTo(personaActual.getCodigoPersona());
//			try {
//				historialClinicoActual = daoHistorialClinicoMapper.selectByExample(filtro).get(0);
//			} catch (Exception e) {
//				
//			}
			if(daoHistorialClinicoMapper.selectByExample(filtro).size() > 0)
			{
				JOptionPane.showMessageDialog(formHistorialClinico, "La persona que ha seleccionado ya cuenta con un historial cl\u00EDnico", "Historial Cl\u00EDnico", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			
			
			limpiarComponentes();
			habilitarComponentes(true);
			tipoOperacion = "I";
			habilitarBotones(false, true, true, false, false, false, false, false); 
			
			
			ninoDatosNacimiento =  daoPersonaDatosNacimientoMapper.selectByPrimaryKey(personaActual.getCodigoPersona());
			formHistorialClinico.getLblNombreCompleto().setText(personaActual.obtenerNombreCompleto());
			if(ninoDatosNacimiento != null)
			{				
				formHistorialClinico.getLblFechaNacimiento().setText(df.format(ninoDatosNacimiento.getFechaNacimiento()));
				formHistorialClinico.getLblEdad().setText(String.valueOf(ninoDatosNacimiento.getEdad()));
			}
			formHistorialClinico.getDateFechaRegistro().setDate(Calendar.getInstance().getTime());
			JOptionPane.showMessageDialog(formHistorialClinico, "Se creará un nuevo Historial clinico para " + personaActual.obtenerNombreCompleto(), "Historial Clínico", JOptionPane.INFORMATION_MESSAGE);
		}
		
		
		
		if(evento.getActionCommand().compareTo("Aceptar") == 0)
		{
			if(validarDatos())
			{
				try {
					if(tipoOperacion.compareTo("I") == 0)
					{
						historialClinicoActual = new HistorialClinico();
						historialClinicoActual.setFecha_registro(formHistorialClinico.getDateFechaRegistro().getDate());
						historialClinicoActual.setGrupoSanguinio(formHistorialClinico.getTxtGrupoSanguineo().getText());
						historialClinicoActual.setIdPersona(personaActual.getCodigoPersona());
						historialClinicoActual.setNumeroHistorialClinico(-1);
						historialClinicoActual.setPersona(personaActual);
						
						daoHistorialClinicoMapper.insert(historialClinicoActual);
						
						
						
						Map<String, Integer> mapa = new HashMap<String, Integer>();
						mapa.put("ultimoId", 0);
						daoHistorialClinicoMapper.obtenerUltimoId(mapa);					
						historialClinicoActual.setNumeroHistorialClinico(mapa.get("ultimoId"));
						
						formHistorialClinico.getTxtNroHC().setText(String.valueOf(historialClinicoActual.getNumeroHistorialClinico()));
					}
					else
					{
						historialClinicoActual.setNumeroHistorialClinico(Integer.parseInt(formHistorialClinico.getTxtNroHC().getText()));
						historialClinicoActual.setFecha_registro(formHistorialClinico.getDateFechaRegistro().getDate());
						historialClinicoActual.setGrupoSanguinio(formHistorialClinico.getTxtGrupoSanguineo().getText());
						historialClinicoActual.setIdPersona(personaActual.getCodigoPersona());
						
						daoHistorialClinicoMapper.updateByPrimaryKey(historialClinicoActual);
						
					}
					session.commit();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(formHistorialClinico, "Ocurrio un inconveniente, el historial clinico, probablemente ya este registrado", "Historial Cl\u00EDnico", JOptionPane.ERROR_MESSAGE);
					session.clearCache();
					
					return;
				}	
				JOptionPane.showMessageDialog(formHistorialClinico, "Operaci\u00F3n realizada correctamente", "Historial Cl\u00EDnico", JOptionPane.INFORMATION_MESSAGE);
				
				habilitarBotones(true, false, false, true, true, true, true, true);
				habilitarComponentes(false);
				tipoOperacion = "";
			}
		}
		if(evento.getActionCommand().compareTo("Cancelar") == 0)
		{
			tipoOperacion = "";
			limpiarComponentes();
			habilitarBotones(true, false, false, false, false, true, false, false);
			habilitarComponentes(false);
		}
		
		if(evento.getActionCommand().compareTo("Modificar") == 0)
		{
			tipoOperacion = "E";			
			habilitarBotones(false, true, true, false, false, false, false, false);
			habilitarComponentes(true);
		}
		if(evento.getActionCommand().compareTo("Eliminar") == 0)
		{
			if(JOptionPane.showConfirmDialog(formHistorialClinico, "¿Se encuentra seguro de eliminar el registro actual?", "Historial cl\u00EDnico", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			{
				try {
					daoHistorialClinicoMapper.deleteByPrimaryKey(Integer.parseInt(formHistorialClinico.getTxtNroHC().getText()));
					limpiarComponentes();
					habilitarBotones(true, false, false, false, false, true, false, false);
					session.commit();
					
					JOptionPane.showMessageDialog(formHistorialClinico, "Elemento elimiando correctamente", "Historial Clinico", JOptionPane.INFORMATION_MESSAGE);
//				} catch (org.apache.ibatis.exceptions.PersistenceException ex) {
//					// TODO Auto-generated catch block
//					ex.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(formHistorialClinico, "No se puede borrar el historial clínico debido a que tiene dependencias", "Historial Cl\u00EDnico", JOptionPane.ERROR_MESSAGE);
					session.clearCache();
//					session.close();
//					session = Coneccion.getSqlSessionFactory().openSession();
				}
			}
		}
		if(evento.getActionCommand().compareTo("Reporte") == 0)
		{
			String path = FormUtilities.obtenerRutaLocal() + "org/quarkbit/trabajosocialsanjuan/reportes/";
//			path = path.replace("/", "\\\\");
//			System.out.println(path);
			
			GeneraReport gr = new GeneraReport();			
			gr.loadReportJasper(path + "obtener_historial_clinico_kardex.jasper");
			gr.setParameters("numero_hc_aux",this.historialClinicoActual.getNumeroHistorialClinico());			
			gr.setParameters("SUBREPORT_DIR", path);
			gr.fillReport(session.getConnection());			
//			gr.previewReport(true);
			gr.previewReportModal();
		}
		if(evento.getActionCommand().compareTo("Consulta") == 0)
		{
			FConsulta formConsulta = new FConsulta(null);
			formConsulta.control.ninoActual = personaActual;
			formConsulta.control.numeroHistorialClinico = historialClinicoActual.getNumeroHistorialClinico();
			formConsulta.control.onFormShown();
			if(this.formHistorialClinico.getTabbedPaneHC().getSelectedComponent().equals(formHistorialClinico.getPnlConsultas())
					&& this.formHistorialClinico.getTableConsultas().getSelectedRow()>= 0
					&& JOptionPane.showConfirmDialog(formHistorialClinico, "¿Desea modificar la consulta Actual(SI) o crear uno nuevo?", "Historial Cl\u00EDnico", JOptionPane.YES_NO_OPTION
							) == JOptionPane.YES_OPTION)				
			{
				formConsulta.control.cargarDatos(modeloConsulta.obtenerConsulta(formHistorialClinico.getTableConsultas().getSelectedRow()));
				
			}
			
			
			formConsulta.setVisible(true);
			if(formConsulta.control.operacionConfirmada)
			{
//				String path = FormUtilities.obtenerRutaLocal() + "org/quarkbit/trabajosocialsanjuan/reportes/";
//				GeneraReport gr = new GeneraReport();			
//				gr.loadReportJasper(path + "obtener_historial_consulta_detalle.jasper");
//				gr.setParameters("numero_hc_aux",this.historialClinicoActual.getNumeroHistorialClinico());			
//				gr.setParameters("numero_consulta_aux",formConsulta.control.numero_consulta_actual);
//				gr.setParameters("SUBREPORT_DIR", path);
//				gr.fillReport(session.getConnection());			
//				gr.previewReportModal();
				session.commit();
				System.out.println("operación confirmada");
				cargarDatos(historialClinicoActual);
			}
		}
		if(evento.getActionCommand().compareTo("Buscar") == 0)
		{
			FPersonasBuscador formBuscador = new FPersonasBuscador(null);
			formBuscador.control.setTipoPersona("N");			
			formBuscador.setVisible(true);
			formBuscador.lblMensaje.setText("Seleccione el Nino");
			if(formBuscador.control.personaActual == null  || formBuscador.control.personaActual.getNombres() == null)
			{
				JOptionPane.showMessageDialog(formHistorialClinico, "No ha seleccionado ning\u00FAn niños, se cancelara la operacion actual", "Informes", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			personaActual = formBuscador.control.personaActual;
			HistorialClinicoExample filtro = new HistorialClinicoExample();
			filtro.or().andIdPersonaEqualTo(personaActual.getCodigoPersona());
			try {
				historialClinicoActual = daoHistorialClinicoMapper.selectByExample(filtro).get(0);
				cargarDatos(historialClinicoActual);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				if(JOptionPane.showConfirmDialog(formHistorialClinico, "La persona que ha seleccionado no cuenta con un Historial Cl\u00EDnico ¿Desea crear uno?", "Historial Cl\u00EDnico", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
				{
					limpiarComponentes();
					habilitarComponentes(true);
					tipoOperacion = "I";
					habilitarBotones(false, true, true, false, false, false, false, false); 
					
					this.personaActual = formBuscador.control.personaActual;
					ninoDatosNacimiento =  daoPersonaDatosNacimientoMapper.selectByPrimaryKey(personaActual.getCodigoPersona());
					
					formHistorialClinico.getLblNombreCompleto().setText(personaActual.obtenerNombreCompleto());
					formHistorialClinico.getLblFechaNacimiento().setText(df.format(ninoDatosNacimiento.getFechaNacimiento()));
					formHistorialClinico.getLblEdad().setText(String.valueOf(ninoDatosNacimiento.getEdad()));
					formHistorialClinico.getDateFechaRegistro().setDate(Calendar.getInstance().getTime());
				}
				else
				{
					personaActual = null;
				}
					
				
			}
			
		}
	}
	
	public boolean validarDatos()
	{
		if(formHistorialClinico.getDateFechaRegistro().getDate() == null)
		{
			JOptionPane.showMessageDialog(formHistorialClinico, "No ha ingresado la fecha", "Historial cl\u00EDnico", JOptionPane.INFORMATION_MESSAGE);
			formHistorialClinico.getDateFechaRegistro().grabFocus();
			return false;
		}
		if(formHistorialClinico.getTxtGrupoSanguineo().getText().isEmpty())
		{
			JOptionPane.showMessageDialog(formHistorialClinico, "No ha ingresado el grupo sanguineo", "Historial cl\u00EDnico", JOptionPane.INFORMATION_MESSAGE);
			formHistorialClinico.getTxtGrupoSanguineo().grabFocus();
			return false;
		}
		return true;
	}

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		actionPerformed(new ActionEvent(formHistorialClinico.getTxtTextoBusqueda(), 25, "BuscarConsulta"));
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		if(formHistorialClinico.getTxtTextoBusqueda().getText().isEmpty())
			actionPerformed(new ActionEvent(formHistorialClinico.getTxtTextoBusqueda(), 25, "BuscarConsulta"));
	}

}
