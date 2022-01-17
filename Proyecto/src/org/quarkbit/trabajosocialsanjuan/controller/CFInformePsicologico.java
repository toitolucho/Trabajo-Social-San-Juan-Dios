package org.quarkbit.trabajosocialsanjuan.controller;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


import org.apache.ibatis.session.SqlSession;
import org.quarkbit.trabajosocialsanjuan.dao.Coneccion;

import org.quarkbit.trabajosocialsanjuan.dao.domain.HistorialClinicoExample;
import org.quarkbit.trabajosocialsanjuan.dao.domain.InformePsicologico;
import org.quarkbit.trabajosocialsanjuan.dao.domain.InformePsicologicoExample;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Persona;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PersonaDatosNacimiento;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PersonaKardex;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PersonaKardexExample;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.InformePsicologicoMapper;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.PersonaDatosNacimientoMapper;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.PersonaKardexMapper;
import org.quarkbit.trabajosocialsanjuan.formularios.FInformePsicologico;
import org.quarkbit.trabajosocialsanjuan.formularios.FPersonasBuscador;
import org.quarkbit.trabajosocialsanjuan.formularios.tablemodels.ModeloInformesPsicologico;
import org.quarkbit.trabajosocialsanjuan.utils.FormUtilities;
import org.quarkbit.trabajosocialsanjuan.utils.GeneraReport;

public class CFInformePsicologico extends MouseAdapter implements ListSelectionListener, ActionListener{
	
	FInformePsicologico formInformePsicologico;
	SqlSession session;
	InformePsicologicoMapper daoInformePsicologicoMapper;	
	InformePsicologicoExample filtroInforme;
	String tipoOperacion = "";
	InformePsicologico informePsicologicoActual;
	private Persona ninoActual;
	PersonaDatosNacimientoMapper daoPersonaDatosNacimientoMapper; 
	PersonaKardexMapper daoPersonaKardexMapper;
	private PersonaDatosNacimiento ninoDatosNacimiento;
	private PersonaKardex ninoKardexActual;
	private ModeloInformesPsicologico modeloInformePsicologico;
	
	public CFInformePsicologico(FInformePsicologico formInformePsicologicosCategorias)
	{
		this.formInformePsicologico = formInformePsicologicosCategorias;
		informePsicologicoActual = new InformePsicologico();
		modeloInformePsicologico = new ModeloInformesPsicologico();
		filtroInforme = new InformePsicologicoExample();
	}
	
	public void onLoad()
	{
		session = Coneccion.getSqlSessionFactory().openSession();
		daoInformePsicologicoMapper = session.getMapper(InformePsicologicoMapper.class);
		daoPersonaDatosNacimientoMapper = session.getMapper(PersonaDatosNacimientoMapper.class);
		daoPersonaKardexMapper = session.getMapper(PersonaKardexMapper.class);
		
		formInformePsicologico.getBtnAceptar().addActionListener(this);
		formInformePsicologico.getBtnNuevo().addActionListener(this);
		formInformePsicologico.getBtnCancelar().addActionListener(this);
		formInformePsicologico.getBtnModificar().addActionListener(this);
		formInformePsicologico.getBtnEliminar().addActionListener(this);
		formInformePsicologico.getBtnCerrar().addActionListener(this);
		formInformePsicologico.getBtnReporte().addActionListener(this);
		formInformePsicologico.getBtnBuscar().addActionListener(this);
		formInformePsicologico.getTxtTextobusqueda().addActionListener(this);
		formInformePsicologico.getBtnBuscarHistorial().addActionListener(this);
		
		formInformePsicologico.getTableHistorial().getSelectionModel().addListSelectionListener(this);
		formInformePsicologico.getTableHistorial().setModel(modeloInformePsicologico);
		formInformePsicologico.getTableHistorial().addMouseListener(this);
		
		habilitarControles(false);
		habilitarBotones(true, false, false, false, false, true, false);
		
//		formInformePsicologico.getjTableInformePsicologico().getColumn("Codigo").setPreferredWidth(5);
		FormUtilities.centrar(formInformePsicologico);
		
//		mostrarParaInsercion(null);
	}
	
	public void mostrarParaInsercion(InformePsicologico InformePsicologico)
	{
		if(InformePsicologico != null) //para edicion
		{
			tipoOperacion = "E";
		}
		else
		{
			tipoOperacion = "I";
		}
		
		limpiarControles();
		habilitarControles(true);
		habilitarBotones(false, true, false, false, false, true, false);
//		formInformePsicologico.mostrorSoloControles();
	}
	
	public void limpiarControles()
	{
		formInformePsicologico.getTxtAntecedentes().setText("");
		formInformePsicologico.getTxtAspectosRelevantes().setText("");
		formInformePsicologico.getTxtAudicionLenguaje().setText("");
		formInformePsicologico.getTxtConductasObservadas().setText("");
//		formInformePsicologico.getTxtDatosNino().setText("");		
		formInformePsicologico.getTxtDiagnostico().setText("");
		formInformePsicologico.getTxtInstrumentos().setText("");
		formInformePsicologico.getTxtMotivoConsulta().setText("");
		formInformePsicologico.getTxtMotricidadGruesa().setText("");
		formInformePsicologico.getTxtMotrizFino().setText("");
		formInformePsicologico.getTxtPersonalSocial().setText("");
		formInformePsicologico.getTxtRecomendaciones().setText("");
		formInformePsicologico.getDateFechaRegistro().setDate(null);
	}
	
	public void habilitarControles(boolean estadHabilitacion)
	{
		
		formInformePsicologico.getTxtAntecedentes().setEditable(estadHabilitacion);
		formInformePsicologico.getTxtAspectosRelevantes().setEditable(estadHabilitacion);
		formInformePsicologico.getTxtAudicionLenguaje().setEditable(estadHabilitacion);
		formInformePsicologico.getTxtConductasObservadas().setEditable(estadHabilitacion);			
		formInformePsicologico.getTxtDiagnostico().setEditable(estadHabilitacion);
		formInformePsicologico.getTxtInstrumentos().setEditable(estadHabilitacion);
		formInformePsicologico.getTxtMotivoConsulta().setEditable(estadHabilitacion);
		formInformePsicologico.getTxtMotricidadGruesa().setEditable(estadHabilitacion);
		formInformePsicologico.getTxtMotrizFino().setEditable(estadHabilitacion);
		formInformePsicologico.getTxtPersonalSocial().setEditable(estadHabilitacion);
		formInformePsicologico.getTxtRecomendaciones().setEditable(estadHabilitacion);
		formInformePsicologico.getDateFechaRegistro().setEnabled(estadHabilitacion);
		
		formInformePsicologico.getDateFechaFin().setEnabled(!estadHabilitacion);
		formInformePsicologico.getDateFechaInicio().setEnabled(!estadHabilitacion);
		formInformePsicologico.getTxtTextobusqueda().setEnabled(!estadHabilitacion);
		formInformePsicologico.getBtnBuscarHistorial().setEnabled(!estadHabilitacion);

	}
	
	public boolean validarControles()
	{
		if(formInformePsicologico.getDateFechaRegistro().getDate() == null)
		{
			JOptionPane.showMessageDialog(formInformePsicologico, "A\u00FAn no ha ingresado la fecha de Consulta", "InformePsicologico", JOptionPane.ERROR_MESSAGE);
			formInformePsicologico.getDateFechaRegistro().grabFocus();
			return false;
		}
		
		if(formInformePsicologico.getTxtMotivoConsulta().getText().trim().isEmpty())
		{
			JOptionPane.showMessageDialog(formInformePsicologico, "A\u00FAn no ha ingresado el motivo de la Consulta", "InformePsicologico", JOptionPane.ERROR_MESSAGE);
			formInformePsicologico.getTxtMotivoConsulta().grabFocus();
			return false;
		}
		if(formInformePsicologico.getTxtInstrumentos().getText().trim().isEmpty())
		{
			JOptionPane.showMessageDialog(formInformePsicologico, "A\u00FAn no ha ingresado los instrumentos del informe", "InformePsicologico", JOptionPane.ERROR_MESSAGE);
			formInformePsicologico.getTxtInstrumentos().grabFocus();
			return false;
		}
		if(formInformePsicologico.getTxtAntecedentes().getText().trim().isEmpty())
		{
			JOptionPane.showMessageDialog(formInformePsicologico, "A\u00FAn no ha ingresado los antecedentes", "InformePsicologico", JOptionPane.ERROR_MESSAGE);
			formInformePsicologico.getTxtAntecedentes().grabFocus();
			return false;
		}
		if(formInformePsicologico.getTxtAspectosRelevantes().getText().trim().isEmpty())
		{
			JOptionPane.showMessageDialog(formInformePsicologico, "A\u00FAn no ha ingresado los aspectos relevantes", "InformePsicologico", JOptionPane.ERROR_MESSAGE);
			formInformePsicologico.getTxtAspectosRelevantes().grabFocus();
			return false;
		}
		if(formInformePsicologico.getTxtConductasObservadas().getText().trim().isEmpty())
		{
			JOptionPane.showMessageDialog(formInformePsicologico, "A\u00FAn no ha ingresado las conductas observadas", "InformePsicologico", JOptionPane.ERROR_MESSAGE);
			formInformePsicologico.getTxtConductasObservadas().grabFocus();
			return false;
		}
		if(formInformePsicologico.getTxtDiagnostico().getText().trim().isEmpty())
		{
			JOptionPane.showMessageDialog(formInformePsicologico, "A\u00FAn no ha ingresado el diagnostico", "InformePsicologico", JOptionPane.ERROR_MESSAGE);
			formInformePsicologico.getTxtDiagnostico().grabFocus();
			return false;
		}
		if(formInformePsicologico.getTxtRecomendaciones().getText().trim().isEmpty())
		{
			JOptionPane.showMessageDialog(formInformePsicologico, "A\u00FAn no ha ingresado las recomendaciones", "InformePsicologico", JOptionPane.ERROR_MESSAGE);
			formInformePsicologico.getTxtRecomendaciones().grabFocus();
			return false;
		}
		return true;
	}
	
	public void habilitarBotones(boolean nuevo, boolean aceptar, boolean cancelar,
			boolean modificar, boolean eliminar, boolean buscar, boolean reporte)
	{
		formInformePsicologico.getBtnAceptar().setEnabled(aceptar);
		formInformePsicologico.getBtnNuevo().setEnabled(nuevo);
		formInformePsicologico.getBtnCancelar().setEnabled(cancelar);
		formInformePsicologico.getBtnModificar().setEnabled(modificar);
		formInformePsicologico.getBtnEliminar().setEnabled(eliminar);
		formInformePsicologico.getBtnBuscar().setEnabled(buscar);
		formInformePsicologico.getBtnReporte().setEnabled(eliminar);
	}
	
	public void cargarDatos(InformePsicologico informePsicologicoAux)
	{
		if(informePsicologicoAux != null)
		{
			informePsicologicoActual = informePsicologicoAux;
			
			formInformePsicologico.lblLblnroinforme.setText(String.valueOf(informePsicologicoAux.getCodigoInformePsicologico()));
			
//			formInformePsicologico.getTxtDatosNino().setText("");		
			formInformePsicologico.getDateFechaRegistro().setDate(informePsicologicoAux.getFechaEvaluacion());
			formInformePsicologico.getTxtAntecedentes().setText(informePsicologicoAux.getAntecedentes());
			formInformePsicologico.getTxtAspectosRelevantes().setText(informePsicologicoAux.getAspectosRelevantes());
			formInformePsicologico.getTxtAudicionLenguaje().setText(informePsicologicoAux.getRespuestaAudicionLenguaje());
			formInformePsicologico.getTxtConductasObservadas().setText(informePsicologicoAux.getConductasObservadas());			
			formInformePsicologico.getTxtDiagnostico().setText(informePsicologicoAux.getDiagnostico());
			formInformePsicologico.getTxtInstrumentos().setText(informePsicologicoAux.getInstrumentos());
			formInformePsicologico.getTxtMotivoConsulta().setText(informePsicologicoAux.getMotivoConsulta());
			formInformePsicologico.getTxtMotricidadGruesa().setText(informePsicologicoAux.getRespuestaMotricidadGruesa());
			formInformePsicologico.getTxtMotrizFino().setText(informePsicologicoAux.getRespuestaMotricidadFino());
			formInformePsicologico.getTxtPersonalSocial().setText(informePsicologicoAux.getRespuestaPersonalSocial());
			formInformePsicologico.getTxtRecomendaciones().setText(informePsicologicoAux.getRecomendaciones());
			
			
			habilitarBotones(true, false, true, true, true, true, true);
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {

		if(formInformePsicologico.getBtnAceptar().equals(event.getSource()))
		{
			if(validarControles())
			{
				try {
					informePsicologicoActual = new InformePsicologico();
					informePsicologicoActual.setCodigoInformePsicologico(-1);
					informePsicologicoActual.setFechaEvaluacion(formInformePsicologico.getDateFechaRegistro().getDate());
					informePsicologicoActual.setCodigoKardex(ninoKardexActual.getCodigoKardex());
					informePsicologicoActual.setAntecedentes(formInformePsicologico.getTxtAntecedentes().getText());
					informePsicologicoActual.setAspectosRelevantes(formInformePsicologico.getTxtAspectosRelevantes().getText());
					informePsicologicoActual.setRespuestaAudicionLenguaje(formInformePsicologico.getTxtAudicionLenguaje().getText());
					informePsicologicoActual.setConductasObservadas(formInformePsicologico.getTxtConductasObservadas().getText());
					informePsicologicoActual.setDiagnostico(formInformePsicologico.getTxtDiagnostico().getText());
					informePsicologicoActual.setInstrumentos(formInformePsicologico.getTxtInstrumentos().getText());
					informePsicologicoActual.setMotivoConsulta(formInformePsicologico.getTxtMotivoConsulta().getText());
					informePsicologicoActual.setRespuestaMotricidadGruesa(formInformePsicologico.getTxtMotricidadGruesa().getText());
					informePsicologicoActual.setRespuestaMotricidadFino(formInformePsicologico.getTxtMotrizFino().getText());
					informePsicologicoActual.setRespuestaPersonalSocial(formInformePsicologico.getTxtPersonalSocial().getText());
					informePsicologicoActual.setRecomendaciones(formInformePsicologico.getTxtRecomendaciones().getText());
					
					if(tipoOperacion.compareTo("I")==0)
					{
						daoInformePsicologicoMapper.insert(informePsicologicoActual);
						session.commit();
						
						Map<String, Integer> mapa = new HashMap<String, Integer>();
						mapa.put("ultimoId", 0);
						daoInformePsicologicoMapper.obtenerUltimoId(mapa); //("myMappedStatement",myParams);
						informePsicologicoActual.setCodigoInformePsicologico(mapa.get("ultimoId"));

					}
					else
					{
//						modeloInformePsicologico.setInformePsicologico(formInformePsicologico.getjTableInformePsicologico().getSelectedRow(), informePsicologicoActual);
						informePsicologicoActual.setCodigoInformePsicologico((Integer.parseInt(formInformePsicologico.lblLblnroinforme.getText())));
						System.out.println("Modificado " + informePsicologicoActual.getCodigoInformePsicologico());
						daoInformePsicologicoMapper.updateByPrimaryKey(informePsicologicoActual);
						session.commit();
						
						
					}
					
					if(!formInformePsicologico.getBtnNuevo().isVisible())
					{
						
						formInformePsicologico.setVisible(false);
						formInformePsicologico.dispose();
						return;
					}
					tipoOperacion ="";
					habilitarBotones(true, false, false, true, true, true, true);
					habilitarControles(false);
					
					filtroInforme.clear();
					filtroInforme.or().andCodigoKardexEqualTo(ninoKardexActual.getCodigoKardex());
					modeloInformePsicologico.setListInformePsicologico(daoInformePsicologicoMapper.selectByExample(filtroInforme));
					
					JOptionPane.showMessageDialog(formInformePsicologico, "Operaci\u00F3n realizada correctamente", "InformePsicologicos", JOptionPane.INFORMATION_MESSAGE);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(formInformePsicologico, "Ocurri\u00F3 la siguiente excepcion " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}
		if(formInformePsicologico.getBtnNuevo().equals(event.getSource()))
		{
			
			if(ninoActual == null)
			{
				FPersonasBuscador formBuscador = new FPersonasBuscador(null);
				formBuscador.control.setTipoPersona("N");
				formBuscador.setVisible(true);
				if(formBuscador.control.personaActual == null || formBuscador.control.personaActual.getNombres() == null)
				{
					JOptionPane.showMessageDialog(formInformePsicologico, "No ha seleccionado ning\u00FAn niños, se cancelara la operacion actual", "Informes", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				
				this.ninoActual = formBuscador.control.personaActual;

				
				ninoDatosNacimiento =  daoPersonaDatosNacimientoMapper.selectByPrimaryKey(ninoActual.getCodigoPersona());
				
				formInformePsicologico.getTxtDatosNino().setText("Nombre Completo : "+ ninoActual.obtenerNombreCompleto() + "   Fecha Nac :"+ FormUtilities.formatearDate(ninoDatosNacimiento.getFechaNacimiento()) + "   Edad :" + ninoDatosNacimiento.getEdad());
				
				PersonaKardexExample filtro = new PersonaKardexExample();
				filtro.or().andCodigoPersonaEqualTo(ninoActual.getCodigoPersona());
				ninoKardexActual = daoPersonaKardexMapper.selectByExample(filtro).get(0);
				
				filtroInforme.clear();
				filtroInforme.or().andCodigoKardexEqualTo(ninoKardexActual.getCodigoKardex());
				modeloInformePsicologico.setListInformePsicologico(daoInformePsicologicoMapper.selectByExample(filtroInforme));
			}
			
				
			limpiarControles();
			habilitarBotones(false, true, true, false, false, false, false);
			habilitarControles(true);			
			tipoOperacion = "I";
			
			formInformePsicologico.getDateFechaRegistro().setDate(Calendar.getInstance().getTime());
			formInformePsicologico.getTableHistorial().clearSelection();
		}
		if(formInformePsicologico.getBtnCerrar().equals(event.getSource()))
		{
			formInformePsicologico.setVisible(false);
			formInformePsicologico.dispose();
			
		}
		if(formInformePsicologico.getBtnModificar().equals(event.getSource()))
		{
			habilitarBotones(false, true, true, false, false, false, false);
			habilitarControles(true);			
			tipoOperacion = "E";
			
		}
		if(formInformePsicologico.getBtnEliminar().equals(event.getSource()))
		{
			if(JOptionPane.showConfirmDialog(formInformePsicologico, "¿Se encuentra seguro de eliminar el registro actual?", "InformePsicologicos", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			{
				try {
					System.out.println("Elemento a eliminar " + Integer.parseInt(formInformePsicologico.lblLblnroinforme.getText()));
					
//				modeloInformePsicologico.eliminarInformePsicologico(formInformePsicologico.getjTableInformePsicologico().getSelectedRow());
					
					
					daoInformePsicologicoMapper.deleteByPrimaryKey(Integer.parseInt(formInformePsicologico.lblLblnroinforme.getText()));
					
					session.commit();
					
					limpiarControles();
					JOptionPane.showMessageDialog(formInformePsicologico, "Objeto eliminado correctamente", "InformePsicologico", JOptionPane.INFORMATION_MESSAGE);
					habilitarBotones(true, false, false, false, false,true, false);
					
					filtroInforme.clear();
					filtroInforme.or().andCodigoKardexEqualTo(ninoKardexActual.getCodigoKardex());
					modeloInformePsicologico.setListInformePsicologico(daoInformePsicologicoMapper.selectByExample(filtroInforme));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(formInformePsicologico, "El Informe no puede ser eliminado debido a que tiene dependencias", "Informe", JOptionPane.ERROR_MESSAGE);
				} 
			}
			
		}
		
		if(formInformePsicologico.getBtnCancelar().equals(event.getSource()))
		{
			limpiarControles();
			habilitarControles(false);
			habilitarBotones(true, false, false, false, false, true, false);
			tipoOperacion = "";
			formInformePsicologico.getTableHistorial().clearSelection();
//			ninoActual = null;
//			modeloInformePsicologico.limpiar();
		}
		
		if(formInformePsicologico.getBtnReporte().equals(event.getSource()))
		{
			String path = FormUtilities.obtenerRutaLocal() + "org/quarkbit/trabajosocialsanjuan/reportes/";
			GeneraReport gr = new GeneraReport();			
			gr.loadReportJasper(path + "listar_informe_psicologico_reporte.jasper");			
			gr.setParameters("codigo_informe_psico_aux", informePsicologicoActual.getCodigoInformePsicologico());
			gr.fillReport(session.getConnection());			
			gr.previewReportModal();
		}
		
		if(formInformePsicologico.getBtnBuscarHistorial().equals(event.getSource()))
		{
			if(ninoKardexActual != null)
			{
				filtroInforme.clear();
//				filtroInforme.or().andCodigoKardexEqualTo(ninoKardexActual.getCodigoKardex());
				if(formInformePsicologico.getDateFechaInicio().getDate() != null
						&& formInformePsicologico.getDateFechaFin().getDate() != null)
				{
					filtroInforme.or().andFechaEvaluacionBetween(formInformePsicologico.getDateFechaInicio().getDate(), formInformePsicologico.getDateFechaFin().getDate()).
						andCodigoKardexEqualTo(ninoKardexActual.getCodigoKardex());
				}
				if(!formInformePsicologico.getTxtTextobusqueda().getText().trim().isEmpty())
				{
					filtroInforme.or().andMotivoConsultaLike("%" + formInformePsicologico.getTxtTextobusqueda().getText().toUpperCase() +"%").
						andCodigoKardexEqualTo(ninoKardexActual.getCodigoKardex());
					filtroInforme.or().andAntecedentesLike("%" + formInformePsicologico.getTxtTextobusqueda().getText().toUpperCase() +"%").
						andCodigoKardexEqualTo(ninoKardexActual.getCodigoKardex());
				}
				
				
				modeloInformePsicologico.setListInformePsicologico(daoInformePsicologicoMapper.selectByExample(filtroInforme));
			}
			else
			{
				JOptionPane.showMessageDialog(formInformePsicologico, "No ha seleccionado ningún niño", "Informes", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if(formInformePsicologico.getBtnBuscar().equals(event.getSource()))
		{
			FPersonasBuscador formBuscador = new FPersonasBuscador(null);
			formBuscador.control.setTipoPersona("N");			
			formBuscador.setVisible(true);
			formBuscador.lblMensaje.setText("Seleccione el Nino");
			if(formBuscador.control.personaActual == null  || formBuscador.control.personaActual.getNombres() == null)
			{
				JOptionPane.showMessageDialog(formInformePsicologico, "No ha seleccionado ning\u00FAn niño, se cancelara la operacion actual", "Informes", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			this.ninoActual = formBuscador.control.personaActual;
			
			ninoDatosNacimiento =  daoPersonaDatosNacimientoMapper.selectByPrimaryKey(ninoActual.getCodigoPersona());
			
			formInformePsicologico.getTxtDatosNino().setText("Nombre Completo : "+ ninoActual.obtenerNombreCompleto() + "   Fecha Nac :"+ FormUtilities.formatearDate(ninoDatosNacimiento.getFechaNacimiento()) + "   Edad :" + ninoDatosNacimiento.getEdad());
			
			PersonaKardexExample filtro = new PersonaKardexExample();
			filtro.or().andCodigoPersonaEqualTo(ninoActual.getCodigoPersona());
			ninoKardexActual = daoPersonaKardexMapper.selectByExample(filtro).get(0);
			
			filtroInforme.clear();
			filtroInforme.or().andCodigoKardexEqualTo(ninoKardexActual.getCodigoKardex());
			modeloInformePsicologico.setListInformePsicologico(daoInformePsicologicoMapper.selectByExample(filtroInforme));
			if(modeloInformePsicologico.getRowCount() == 0)
			{
				JOptionPane.showMessageDialog(formInformePsicologico, "El niño actual no cuenta con ningún informe", "Informes", JOptionPane.INFORMATION_MESSAGE);
			}
			
			
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if(e.getValueIsAdjusting())
			return;
		int indice = ((ListSelectionModel) e.getSource()).getMinSelectionIndex();
		cargarDatos(modeloInformePsicologico.obtenerInformePsicologico(indice));
	}
	
	@Override
    public void mousePressed(MouseEvent e) {
        if (e.getClickCount() == 2) {
        	formInformePsicologico.getTabbedPane().setSelectedIndex(0);
        }
    }

//	@Override
//	public void valueChanged(ListSelectionEvent e) {
//		// TODO Auto-generated method stub
//		if(e.getValueIsAdjusting())
//			return;
//		int indice = ((ListSelectionModel) e.getSource()).getMinSelectionIndex();
////		System.out.println("indice = " + indice);
//		cargarDatos(modeloInformePsicologico.obtenerInformePsicologico(indice));
//		
//	}

}
