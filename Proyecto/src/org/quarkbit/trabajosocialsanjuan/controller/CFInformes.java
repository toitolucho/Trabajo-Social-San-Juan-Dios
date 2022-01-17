package org.quarkbit.trabajosocialsanjuan.controller;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.ibatis.session.SqlSession;
import org.quarkbit.trabajosocialsanjuan.dao.Coneccion;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Informe;
import org.quarkbit.trabajosocialsanjuan.dao.domain.InformeDetalle;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Persona;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PersonaDatosNacimiento;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PersonaDatosNacimientoExample;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PersonaKardex;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PersonaKardexExample;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PersonaKardexFamiliar;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PersonaKardexFamiliarExample;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PersonaKardexFamiliarKey;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.InformeDetalleMapper;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.InformeMapper;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.PersonaDatosNacimientoMapper;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.PersonaKardexFamiliarMapper;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.PersonaKardexMapper;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.PersonaMapper;
import org.quarkbit.trabajosocialsanjuan.formularios.FFamiliar;
import org.quarkbit.trabajosocialsanjuan.formularios.FInformes;
import org.quarkbit.trabajosocialsanjuan.formularios.FInformesBuscador;
import org.quarkbit.trabajosocialsanjuan.formularios.FPersonasBuscador;
import org.quarkbit.trabajosocialsanjuan.formularios.tablemodels.ModeloFamiliares;
import org.quarkbit.trabajosocialsanjuan.utils.FormUtilities;
import org.quarkbit.trabajosocialsanjuan.utils.GeneraReport;

public class CFInformes implements ActionListener {
	FInformes formInformes;
	
	SqlSession session;
	InformeDetalleMapper daoInformeDetalleMapper;
	InformeMapper daoInformeMapper;
	PersonaMapper daoPersonaMapper;
	PersonaKardexFamiliarMapper daoPersonaKardexFamiliarMapper;
	PersonaKardexMapper daoPersonaKardexMapper;
	PersonaDatosNacimientoMapper daoPersonaDatosNacimientoMapper;
	String tipoOperacion;
	String rutaLocal;
	Informe informeActual;
	InformeDetalle informeDetalleActual;
	Persona ninoActual;
	PersonaKardex ninoKardexActual;
	PersonaDatosNacimiento ninoDatosNacimiento;
	ModeloFamiliares modeloFamiliar;
	
	private int codigoPersonaA;
	private int codigoPersonaVia;
	private int codigoPersonaDe01;
	private int codigoPersonaDe02;
	private int codigoPersonaDe03;
	
	private Persona personaA;
	private Persona personaVia;
	private Persona personaDe01;
	private Persona personaDe02;
	private Persona personaDe03;
	
	Map<String, Integer> mapa;
	public CFInformes(FInformes form)
	{
		this.formInformes = form;
		session = Coneccion.getSqlSessionFactory().openSession();
		
		daoInformeMapper = session.getMapper(InformeMapper.class);
		daoInformeDetalleMapper = session.getMapper(InformeDetalleMapper.class);
		daoPersonaMapper = session.getMapper(PersonaMapper.class);
		daoPersonaKardexFamiliarMapper = session.getMapper(PersonaKardexFamiliarMapper.class);
		daoPersonaKardexMapper = session.getMapper(PersonaKardexMapper.class);
		daoPersonaDatosNacimientoMapper = session.getMapper(PersonaDatosNacimientoMapper.class);
		tipoOperacion = "";
		modeloFamiliar = new ModeloFamiliares();
		
		mapa = new HashMap<String, Integer>();
		mapa.put("ultimoId", 0);
		rutaLocal = FormUtilities.obtenerRutaLocal();
	}
	
	public void habilitarControles(boolean estadoHabilitacion)
	{
//		formInformes.getTxtA().setEnabled(estadoHabilitacion);
//		formInformes.getTxtVia().setEnabled(estadoHabilitacion);
//		formInformes.getTxtDe01().setEnabled(estadoHabilitacion);
//		formInformes.getTxtDe02().setEnabled(estadoHabilitacion);
//		formInformes.getTxtDe03().setEnabled(estadoHabilitacion);
		formInformes.getTxtReferencia().setEnabled(estadoHabilitacion);
		formInformes.getDateFechaRegistro().setEnabled(estadoHabilitacion);
		formInformes.getcBoxTipo().setEnabled(estadoHabilitacion);
		formInformes.getBtnAgregarA().setEnabled(estadoHabilitacion);
		formInformes.getBtnAgregarVia().setEnabled(estadoHabilitacion);
		formInformes.getBtnAgregarDe01().setEnabled(estadoHabilitacion);
		formInformes.getBtnAgregarDe02().setEnabled(estadoHabilitacion);
		formInformes.getBtnAgregarDe03().setEnabled(estadoHabilitacion);
		formInformes.getBtnBuscarA().setEnabled(estadoHabilitacion);
		formInformes.getBtnBuscarVia().setEnabled(estadoHabilitacion);
		formInformes.getBtnBuscarDe01().setEnabled(estadoHabilitacion);
		formInformes.getBtnBuscarDe02().setEnabled(estadoHabilitacion);
		formInformes.getBtnBuscarDe03().setEnabled(estadoHabilitacion);
		
		formInformes.getTxtDiagnostico().setEnabled(estadoHabilitacion);
		formInformes.getTxtSugerencia().setEnabled(estadoHabilitacion);
		
		habilitarPestaniaA(estadoHabilitacion);
		habilitarPestaniaB(estadoHabilitacion);
		habilitarPestaniaC(estadoHabilitacion);
		habilitarPestaniaD(estadoHabilitacion);
		habilitarPestaniaE(estadoHabilitacion);
	
	}
	
	public void limpiarControles()
	{
		formInformes.getTxtA().setText("");
		formInformes.getTxtVia().setText("");
		formInformes.getTxtDe01().setText("");
		formInformes.getTxtDe02().setText("");
		formInformes.getTxtDe03().setText("");
		formInformes.getTxtReferencia().setText("");
		formInformes.getDateFechaRegistro().setDate(null);
		formInformes.getcBoxTipo().setSelectedIndex(-1);		
		formInformes.getTxtDiagnostico().setText("");
		formInformes.getTxtSugerencia().setText("");
		formInformes.getLblDatosNino().setText("");
		modeloFamiliar.clear();
		
		limpiarPestaniaA();
		limpiarPestaniaB();
		limpiarPestaniaC();
		limpiarPestaniaD();
		limpiarPestaniaE();
	
	}
	
	public void cargarDatosInforme(Informe informeAux, InformeDetalle informeDetalleAux)
	{
		ninoActual = informeAux.getNino();
		ninoKardexActual = informeAux.getPersonaKardex();
		if(informeAux != null)
		{
			informeActual = informeAux;
			formInformes.lblNroInforme.setText(String.valueOf(informeAux.getCodigoInforme()));
			if(informeAux.getPersonaA() != null )
			{
				formInformes.getTxtA().setText(informeAux.getPersonaA().obtenerNombreCompleto());
				personaA = informeAux.getPersonaA();
			}
			else
			{
				formInformes.getTxtA().setText("");
				codigoPersonaA = -1;
			}
			
			if(informeAux.getPersonaVia() != null )
			{
				formInformes.getTxtVia().setText(informeAux.getPersonaVia().obtenerNombreCompleto());
				personaVia = informeAux.getPersonaVia();
			}
			else
			{
				formInformes.getTxtVia().setText("");
				codigoPersonaVia = -1;
			}
			
			if(informeAux.getPersonaDe1() != null )
			{
				formInformes.getTxtDe01().setText(informeAux.getPersonaDe1().obtenerNombreCompleto());
				personaDe01 = informeAux.getPersonaDe1();
			}
			else
			{
				formInformes.getTxtDe01().setText("");
				codigoPersonaDe01 = -1;
			}
			
			if(informeAux.getPersonaDe2() != null )
			{
				formInformes.getTxtDe02().setText(informeAux.getPersonaDe2().obtenerNombreCompleto());
				personaDe02 = informeAux.getPersonaDe2();
				
			}
			else
			{
				formInformes.getTxtDe02().setText("");
				codigoPersonaDe02 = -1;
			}
			
			if(informeAux.getPersonaDe3() != null )
			{
				formInformes.getTxtDe03().setText(informeAux.getPersonaDe3().obtenerNombreCompleto());
				personaDe03 = informeAux.getPersonaDe3();
			}
			else
			{
				formInformes.getTxtDe03().setText("");
				codigoPersonaDe03 = -1;
			}
			
			formInformes.getTxtReferencia().setText(informeAux.getReferencia());
			formInformes.getDateFechaRegistro().setDate(informeAux.getFechaEnvio());
			formInformes.getcBoxTipo().setSelectedItem(informeAux.getTipo());		
			formInformes.getTxtDiagnostico().setText(informeAux.getDiagnostico());
			formInformes.getTxtSugerencia().setText(informeAux.getSugerencias());	
			
			
			PersonaKardexFamiliarExample filtro2 = new PersonaKardexFamiliarExample();			
			filtro2.or().andCodigoKardexEqualTo(ninoKardexActual.getCodigoKardex());
			modeloFamiliar.setListPersonaKardexFamiliar(  daoPersonaKardexFamiliarMapper.selectByExample(filtro2 ));
			
			ninoDatosNacimiento =  daoPersonaDatosNacimientoMapper.selectByPrimaryKey(ninoActual.getCodigoPersona());			
			formInformes.getLblDatosNino().setText("Nombre Completo : "+ ninoActual.obtenerNombreCompleto() + "   Fecha Nac :"+ ninoDatosNacimiento.getFechaNacimiento() + "   Edad :" + ninoDatosNacimiento.getEdad());
			
			if(informeDetalleAux != null)
			{
				informeDetalleActual = informeDetalleAux;
				switch (informeAux.getCodigoTipoInforme()) {
				case "A":
					cargarDatosPestaniaA(informeDetalleAux);
					break;
				case "B":
					cargarDatosPestaniaB(informeDetalleAux);
				case "C":
					cargarDatosPestaniaC(informeDetalleAux);
				case "D":
					cargarDatosPestaniaD(informeDetalleAux);
				case "E":
					cargarDatosPestaniaE(informeDetalleAux);			
				default:
					break;
				}
			}
			
			habilitarBotones(true, false, false, true, true, true, true);
		}
		
	}
	
	
	
	public void habilitarPestaniaA(boolean estadoHabilitacion)
	{
		formInformes.getDateFechaInicio().setEnabled(estadoHabilitacion);
		formInformes.getDateFechaFin().setEnabled(estadoHabilitacion);
		formInformes.getTxtReferenciaCaso().setEnabled(estadoHabilitacion);
		formInformes.getTxtSituacHabitacional().setEnabled(estadoHabilitacion);
		formInformes.getTxtIntMedioFamiliar().setEnabled(estadoHabilitacion);
		formInformes.getTxtDesarrolloEmocional().setEnabled(estadoHabilitacion);
		formInformes.getBtnTextoDesEmocional().setEnabled(estadoHabilitacion);
		formInformes.getBtnTextoIntMedioFam().setEnabled(estadoHabilitacion);
		formInformes.getBtnTextoRefCaso().setEnabled(estadoHabilitacion);
		formInformes.getBtnTextoSitHabit().setEnabled(estadoHabilitacion);
		
	}
	public void limpiarPestaniaA()
	{
		formInformes.getDateFechaInicio().setDate(null);
		formInformes.getDateFechaFin().setDate(null);
		formInformes.getTxtReferenciaCaso().setText("");
		formInformes.getTxtSituacHabitacional().setText("");
		formInformes.getTxtIntMedioFamiliar().setText("");
		formInformes.getTxtDesarrolloEmocional().setText("");		
	}
	public void cargarDatosPestaniaA(InformeDetalle informeDetalleAux)
	{
		formInformes.getDateFechaInicio().setDate(informeDetalleAux.getFechaInicio());
		formInformes.getDateFechaFin().setDate(informeDetalleAux.getFechaFin());
		formInformes.getTxtReferenciaCaso().setText(informeDetalleAux.getReferenciaCaso());
		formInformes.getTxtSituacHabitacional().setText(informeDetalleAux.getSituacionHabitacional());
		formInformes.getTxtIntMedioFamiliar().setText(informeDetalleAux.getIntegracionFamiliar());
		formInformes.getTxtDesarrolloEmocional().setText(informeDetalleAux.getDesarrolloAfectivo());		
	}
	public boolean validarPestaniaA()
	{
		if(formInformes.getDateFechaInicio() == null)
		{
			JOptionPane.showMessageDialog(formInformes, "A\u00FAn no ha seleccionado la fecha de inicio", "Informes", JOptionPane.ERROR_MESSAGE);
			formInformes.getDateFechaInicio().grabFocus();
			return false;
		}
		if(formInformes.getDateFechaFin() == null)
		{
			JOptionPane.showMessageDialog(formInformes, "A\u00FAn no ha seleccionado la fecha final", "Informes", JOptionPane.ERROR_MESSAGE);
			formInformes.getDateFechaFin().grabFocus();
			return false;
		}
		if(formInformes.getTxtReferenciaCaso().getText().isEmpty())
		{
			JOptionPane.showMessageDialog(formInformes, "A\u00FAn no ha ingresado la Referencia del Caso", "Informes", JOptionPane.ERROR_MESSAGE);
			formInformes.getTxtReferenciaCaso().grabFocus();
			return false;
		}
		if(formInformes.getTxtSituacHabitacional().getText().isEmpty())
		{
			JOptionPane.showMessageDialog(formInformes, "A\u00FAn no ha ingresado la Situacion habitacional", "Informes", JOptionPane.ERROR_MESSAGE);
			formInformes.getTxtSituacHabitacional().grabFocus();
			return false;
		}		
		if(formInformes.getTxtIntMedioFamiliar().getText().isEmpty())
		{
			JOptionPane.showMessageDialog(formInformes, "A\u00FAn no ha ingresado el medio Familiar", "Informes", JOptionPane.ERROR_MESSAGE);
			formInformes.getTxtIntMedioFamiliar().grabFocus();
			return false;
		}
		if(formInformes.getTxtDesarrolloEmocional().getText().isEmpty())
		{
			JOptionPane.showMessageDialog(formInformes, "A\u00FAn no ha ingresado el desarrollo emocional", "Informes", JOptionPane.ERROR_MESSAGE);
			formInformes.getTxtDesarrolloEmocional().grabFocus();
			return false;
		}
		
		return true;
	}
	
	


	public void habilitarPestaniaB(boolean estadoHabilitacion)
	{		
		formInformes.getTxtRefCaso().setEnabled(estadoHabilitacion);	
		formInformes.getTxtDiagnosticoPsicosocial().setEnabled(estadoHabilitacion);
	}
	public void limpiarPestaniaB()
	{		
		formInformes.getTxtRefCaso().setText("");
		formInformes.getTxtDiagnosticoPsicosocial().setText("");
	}
	public void cargarDatosPestaniaB(InformeDetalle informeDetalleAux)
	{		
		formInformes.getTxtRefCaso().setText(informeDetalleAux.getReferenciaCaso());
		formInformes.getTxtDiagnosticoPsicosocial().setText(informeDetalleAux.getSituacionHabitacional());
	}
	public boolean validarPestaniaB()
	{
		if(formInformes.getTxtRefCaso().getText().isEmpty())
		{
			JOptionPane.showMessageDialog(formInformes, "A\u00FAn no ha ingresado la referencia del caso", "Informes", JOptionPane.ERROR_MESSAGE);
			formInformes.getTxtRefCaso().grabFocus();
			return false;
		}
		if(formInformes.getTxtDiagnosticoPsicosocial().getText().isEmpty())
		{
			JOptionPane.showMessageDialog(formInformes, "A\u00FAn no ha ingresado el diagnostico psicosocial", "Informes", JOptionPane.ERROR_MESSAGE);
			formInformes.getTxtDiagnosticoPsicosocial().grabFocus();
			return false;
		}
		return true;
	}
	
	
	public void habilitarPestaniaC(boolean estadoHabilitacion)
	{		
		formInformes.getTxtHistSocial().setEnabled(estadoHabilitacion);
		formInformes.getTxtSitActual().setEnabled(estadoHabilitacion);
		formInformes.getTxtFuenteInform().setEnabled(estadoHabilitacion);		
	}
	public void limpiarPestaniaC()
	{		
		formInformes.getTxtHistSocial().setText("");
		formInformes.getTxtSitActual().setText("");
		formInformes.getTxtFuenteInform().setText("");		
	}
	public void cargarDatosPestaniaC(InformeDetalle informeDetalleAux)
	{		
		formInformes.getTxtHistSocial().setText(informeDetalleAux.getHistoriaSocial());
		formInformes.getTxtSitActual().setText(informeDetalleAux.getSituacionActual());
		formInformes.getTxtFuenteInform().setText(informeDetalleAux.getFuentesInformacion());		
	}
	public boolean validarPestaniaC()
	{
		if(formInformes.getTxtHistSocial().getText().isEmpty())
		{
			JOptionPane.showMessageDialog(formInformes, "A\u00FAn no ha ingresado la historia social del caso", "Informes", JOptionPane.ERROR_MESSAGE);
			formInformes.getTxtHistSocial().grabFocus();
			return false;
		}
		if(formInformes.getTxtSitActual().getText().isEmpty())
		{
			JOptionPane.showMessageDialog(formInformes, "A\u00FAn no ha ingresado la situacion actual del caso", "Informes", JOptionPane.ERROR_MESSAGE);
			formInformes.getTxtSitActual().grabFocus();
			return false;
		}
		if(formInformes.getTxtFuenteInform().getText().isEmpty())
		{
			JOptionPane.showMessageDialog(formInformes, "A\u00FAn no ha ingresado la fuente de informacion del caso", "Informes", JOptionPane.ERROR_MESSAGE);
			formInformes.getTxtFuenteInform().grabFocus();
			return false;
		}
		return true;
	}
	
	
	
	public void habilitarPestaniaD(boolean estadoHabilitacion)
	{
		formInformes.getTxtFuenteInformacion().setEnabled(estadoHabilitacion);
		formInformes.getTxtSituacionActual().setEnabled(estadoHabilitacion);
		
	}
	public void limpiarPestaniaD()
	{
		formInformes.getTxtFuenteInformacion().setText("");
		formInformes.getTxtSituacionActual().setText("");
		
	}
	public void cargarDatosPestaniaD(InformeDetalle informeDetalleAux)
	{		
		formInformes.getTxtFuenteInformacion().setText(informeDetalleAux.getFuentesInformacion());
		formInformes.getTxtSituacionActual().setText(informeDetalleAux.getSituacionActual());		
	}
	public boolean validarPestaniaD()
	{
		if(formInformes.getTxtFuenteInformacion().getText().isEmpty())
		{
			JOptionPane.showMessageDialog(formInformes, "A\u00FAn no ha ingresado la fuente de informacion del caso", "Informes", JOptionPane.ERROR_MESSAGE);
			formInformes.getTxtFuenteInformacion().grabFocus();
			return false;
		}
		if(formInformes.getTxtSituacionActual().getText().isEmpty())
		{
			JOptionPane.showMessageDialog(formInformes, "A\u00FAn no ha ingresado la situacion actual del caso", "Informes", JOptionPane.ERROR_MESSAGE);
			formInformes.getTxtSituacionActual().grabFocus();
			return false;
		}
		
		return true;
	}
	
	
	
	public void habilitarPestaniaE(boolean estadoHabilitacion)
	{
		formInformes.getTxtDescripcionCaso().setEnabled(estadoHabilitacion);
		formInformes.getTxtDocAdjuntos().setEnabled(estadoHabilitacion);		
	}
	public void limpiarPestaniaE()
	{
		formInformes.getTxtDescripcionCaso().setText("");
		formInformes.getTxtDocAdjuntos().setText("");		
	}
	public void cargarDatosPestaniaE(InformeDetalle informeDetalleAux)
	{		
		formInformes.getTxtDescripcionCaso().setText(informeDetalleAux.getDescripcionCaso());
		formInformes.getTxtDocAdjuntos().setText(informeDetalleAux.getDocumentosAdjuntos());		
	}
	public boolean validarPestaniaE()
	{
		if(formInformes.getTxtDescripcionCaso().getText().isEmpty())
		{
			JOptionPane.showMessageDialog(formInformes, "A\u00FAn no ha ingresado la descripcion del caso", "Informes", JOptionPane.ERROR_MESSAGE);
			formInformes.getTxtDescripcionCaso().grabFocus();
			return false;
		}
		if(formInformes.getTxtDocAdjuntos().getText().isEmpty())
		{
			JOptionPane.showMessageDialog(formInformes, "A\u00FAn no ha ingresado los documentos adjuntos del caso", "Informes", JOptionPane.ERROR_MESSAGE);
			formInformes.getTxtDocAdjuntos().grabFocus();
			return false;
		}
		
		return true;
	}
	
	
	
	public void habilitarBotones(boolean nuevo, boolean aceptar, boolean cancelar, boolean modificar, boolean eliminar, boolean buscar, boolean reporte)
	{
		formInformes.getBtnNuevo().setEnabled(nuevo);
		formInformes.getBtnAceptar().setEnabled(aceptar);
		formInformes.getBtnCancelar().setEnabled(cancelar);
		formInformes.getBtnModificar().setEnabled(modificar);
		formInformes.getBtnEliminar().setEnabled(eliminar);
		formInformes.getBtnBuscar().setEnabled(buscar);
	}
	
	public boolean validarDatos()
	{
		
		
		if(formInformes.getTxtA().getText().isEmpty())
		{
			JOptionPane.showMessageDialog(formInformes, "A\u00FAn no ha seleccionado a quien va dirigido el informe", "Informes", JOptionPane.ERROR_MESSAGE);
			formInformes.getTxtA().grabFocus();
			return false;
		}
		if(formInformes.getTxtVia().getText().isEmpty())
		{
			JOptionPane.showMessageDialog(formInformes, "A\u00FAn no ha seleccionado via quien va dirigido el informe", "Informes", JOptionPane.ERROR_MESSAGE);
			formInformes.getTxtVia().grabFocus();
			return false;
		}
		if(formInformes.getTxtDe01().getText().isEmpty())
		{
			JOptionPane.showMessageDialog(formInformes, "A\u00FAn no ha seleccionado quien o quienes envian el informe", "Informes", JOptionPane.ERROR_MESSAGE);
			formInformes.getTxtDe01().grabFocus();
			return false;
		}
		if(formInformes.getTxtReferencia().getText().isEmpty())
		{
			JOptionPane.showMessageDialog(formInformes, "A\u00FAn no ha ingresado la referencia del informe", "Informes", JOptionPane.ERROR_MESSAGE);
			formInformes.getTxtReferencia().grabFocus();
			return false;
		}
		if(formInformes.getcBoxTipo().getSelectedIndex() < 0)
		{
			JOptionPane.showMessageDialog(formInformes, "A\u00FAn ha seleccionado el tipo de informe", "Informes", JOptionPane.ERROR_MESSAGE);
			formInformes.getcBoxTipo().grabFocus();
			return false;
		}
		if(formInformes.getTxtDiagnostico().getText().isEmpty())
		{
			JOptionPane.showMessageDialog(formInformes, "A\u00FAn no ha ingresado el diagnostico del informe", "Informes", JOptionPane.ERROR_MESSAGE);
			formInformes.getTxtDiagnostico().grabFocus();
			return false;
		}
		if(formInformes.getTxtSugerencia().getText().isEmpty())
		{
			JOptionPane.showMessageDialog(formInformes, "A\u00FAn no ha ingresado la sugerencia del informe", "Informes", JOptionPane.ERROR_MESSAGE);
			formInformes.getTxtSugerencia().grabFocus();
			return false;
		}
		return true;
	}
	
	public void onFormShown()
	{
		formInformes.getTxtA().setEnabled(false);
		formInformes.getTxtVia().setEnabled(false);
		formInformes.getTxtDe01().setEnabled(false);
		formInformes.getTxtDe02().setEnabled(false);
		formInformes.getTxtDe03().setEnabled(false);
		
		limpiarControles();
		habilitarControles(false);
		habilitarBotones(true, false, false, false, false, true, false);
		
		formInformes.getBtnAceptar().addActionListener(this);
		formInformes.getBtnAgregarA().addActionListener(this);
		formInformes.getBtnAgregarDe01().addActionListener(this);
		formInformes.getBtnAgregarDe02().addActionListener(this);
		formInformes.getBtnAgregarDe03().addActionListener(this);
		formInformes.getBtnAgregarVia().addActionListener(this);
		formInformes.getBtnBuscar().addActionListener(this);
		formInformes.getBtnBuscarA().addActionListener(this);
		formInformes.getBtnBuscarDe01().addActionListener(this);
		formInformes.getBtnBuscarDe02().addActionListener(this);
		formInformes.getBtnBuscarDe03().addActionListener(this);
		formInformes.getBtnBuscarVia().addActionListener(this);
		formInformes.getBtnCancelar().addActionListener(this);
		formInformes.getBtnCerrar().addActionListener(this);
		formInformes.getBtnEliminar().addActionListener(this);
		formInformes.getBtnModificar().addActionListener(this);
		formInformes.getBtnNuevo().addActionListener(this);
		formInformes.getBtnReporte().addActionListener(this);
		formInformes.getBtnTextoDesEmocional().addActionListener(this);
		formInformes.getBtnTextoIntMedioFam().addActionListener(this);
		formInformes.getBtnTextoRefCaso().addActionListener(this);
		formInformes.getBtnTextoSitHabit().addActionListener(this);
		formInformes.getcBoxTipo().addActionListener(this);
		
		
		formInformes.getTable().setModel(modeloFamiliar);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// TODO Auto-generated method stub
		if(!tipoOperacion.isEmpty() && e.getSource().equals(formInformes.getcBoxTipo()))
		{
			switch (formInformes.getcBoxTipo().getSelectedIndex()) {
			case 0:
				formInformes.getTabbedPane().setSelectedIndex(1);
				habilitarPestaniaA(true);
				habilitarPestaniaB(false);
				habilitarPestaniaC(false);
				habilitarPestaniaD(false);
				habilitarPestaniaE(false);
				break;
			case 1:
				formInformes.getTabbedPane().setSelectedIndex(2);
				habilitarPestaniaA(false);
				habilitarPestaniaB(true);
				habilitarPestaniaC(false);
				habilitarPestaniaD(false);
				habilitarPestaniaE(false);
				break;
			case 2:
				formInformes.getTabbedPane().setSelectedIndex(3);
				habilitarPestaniaA(false);
				habilitarPestaniaB(false);
				habilitarPestaniaC(true);
				habilitarPestaniaD(false);
				habilitarPestaniaE(false);
				break;
			case 3:
				formInformes.getTabbedPane().setSelectedIndex(4);
				habilitarPestaniaA(false);
				habilitarPestaniaB(false);
				habilitarPestaniaC(false);
				habilitarPestaniaD(true);
				habilitarPestaniaE(false);
				break;
			case 4:
				formInformes.getTabbedPane().setSelectedIndex(5);
				habilitarPestaniaA(false);
				habilitarPestaniaB(false);
				habilitarPestaniaC(false);
				habilitarPestaniaD(false);
				habilitarPestaniaE(true);
				break;
			default:
				break;
			}
		}
		if(e.getActionCommand().compareTo("Aceptar") == 0)
		{
			
			if(validarDatos())
			{
				
				try {
					informeActual.setCodigoInstitucion(1);
					informeActual.setCodigoKardex(ninoKardexActual.getCodigoKardex());
					informeActual.setCodigoPersonaDirigido(personaA.getCodigoPersona());
					informeActual.setCodigoPersonaVia(personaVia.getCodigoPersona());
					informeActual.setCodigoPersonaDe1(personaDe01.getCodigoPersona());
					if(codigoPersonaDe02 != -1)
						informeActual.setCodigoPersonaDe2(personaDe02.getCodigoPersona());
					if(codigoPersonaDe03 != -1)
						informeActual.setCodigoPersonaDe3(personaDe03.getCodigoPersona());
					
					informeActual.setReferencia(formInformes.getTxtReferencia().getText());
					informeActual.setFechaEnvio(formInformes.getDateFechaRegistro().getDate());
					informeActual.setTipo(formInformes.getcBoxTipo().getSelectedItem().toString());
					informeActual.setDiagnostico(formInformes.getTxtDiagnostico().getText());
					informeActual.setSugerencias(formInformes.getTxtSugerencia().getText());
					
									
					
					informeDetalleActual = new InformeDetalle();
					System.out.println("Indices actual " + formInformes.getcBoxTipo().getSelectedIndex());
					switch (formInformes.getcBoxTipo().getSelectedIndex()) {
					case 0:
						if(validarPestaniaA())
						{					
							informeDetalleActual.setFechaInicio(formInformes.getDateFechaInicio().getDate());
							informeDetalleActual.setFechaFin(formInformes.getDateFechaFin().getDate());
							informeDetalleActual.setReferenciaCaso(formInformes.getTxtReferenciaCaso().getText());
							informeDetalleActual.setSituacionHabitacional(formInformes.getTxtSituacHabitacional().getText());
							informeDetalleActual.setIntegracionFamiliar(formInformes.getTxtIntMedioFamiliar().getText());
							informeDetalleActual.setDesarrolloAfectivo(formInformes.getTxtDesarrolloEmocional().getText());
						}
						break;
					case 1:
						if(validarPestaniaB())
						{	
							informeDetalleActual.setReferenciaCaso(formInformes.getTxtRefCaso().getText());
							informeDetalleActual.setSituacionHabitacional( formInformes.getTxtDiagnosticoPsicosocial().getText());
							
						}
						break;
					case 2:
						if(validarPestaniaC())
						{
							informeDetalleActual.setHistoriaSocial(formInformes.getTxtHistSocial().getText());
							informeDetalleActual.setSituacionActual(formInformes.getTxtSitActual().getText());
							informeDetalleActual.setFuentesInformacion(formInformes.getTxtFuenteInform().getText());
						}
						break;
					case 3:
						if(validarPestaniaD())
						{
							informeDetalleActual.setFuentesInformacion(formInformes.getTxtFuenteInformacion().getText());
							informeDetalleActual.setSituacionActual(formInformes.getTxtSituacionActual().getText());
						}
						break;
					case 4:
						if(validarPestaniaE())
						{
							informeDetalleActual.setDescripcionCaso(formInformes.getTxtDescripcionCaso().getText());
							informeDetalleActual.setDocumentosAdjuntos(formInformes.getTxtDocAdjuntos().getText());
						}
						break;
					default:
						break;
					}
					
					if(tipoOperacion.compareTo("I") == 0)
					{
						daoInformeMapper.insert(informeActual);
						session.commit();
						
						daoInformeMapper.obtenerUltimoId(mapa);
						informeActual.setCodigoInforme(mapa.get("ultimoId"));
						
						informeDetalleActual.setCodigoInforme(informeActual.getCodigoInforme());
						daoInformeDetalleMapper.insert(informeDetalleActual);
						session.commit();
					}
					else
					{
						informeActual.setCodigoInforme(Integer.parseInt(formInformes.lblNroInforme.getText()));
						informeDetalleActual.setCodigoInforme(informeActual.getCodigoInforme());
						daoInformeMapper.updateByPrimaryKey(informeActual);
						daoInformeDetalleMapper.updateByPrimaryKey(informeDetalleActual);
						
						session.commit();
					}
					
					JOptionPane.showMessageDialog(formInformes, "Registro guardado correctamente", "Informes", JOptionPane.INFORMATION_MESSAGE);
					habilitarBotones(true, false, false, true, true, true, true);
					habilitarControles(false);
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(formInformes, "Ocurri\u00F3 la siguiente excepcion " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
		}
		
		if(e.getActionCommand().compareTo("Nuevo") == 0)
		{
			FPersonasBuscador formBuscador = new FPersonasBuscador(null);
			formBuscador.control.setTipoPersona("N");
			formBuscador.setVisible(true);
			if(formBuscador.control.personaActual.getNombres() == null)
			{
				JOptionPane.showMessageDialog(formInformes, "No ha seleccionado ning\u00FAn niños, se cancelara la operacion actual", "Informes", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			limpiarControles();
			habilitarControles(true);
			tipoOperacion = "I";
			habilitarBotones(false, true, true, false, false, false, false);
			
			this.ninoActual = formBuscador.control.personaActual;
			
			
			ninoDatosNacimiento =  daoPersonaDatosNacimientoMapper.selectByPrimaryKey(ninoActual.getCodigoPersona());
			
			formInformes.getLblDatosNino().setText("Nombre Completo : "+ ninoActual.obtenerNombreCompleto() + "   Fecha Nac :"+ ninoDatosNacimiento.getFechaNacimiento() + "   Edad :" + ninoDatosNacimiento.getEdad());
			
			formInformes.getTabbedPane().setSelectedComponent(formInformes.getPnlDatosNinos());
			
			PersonaKardexExample filtro = new PersonaKardexExample();
			filtro.or().andCodigoPersonaEqualTo(ninoActual.getCodigoPersona());
			ninoKardexActual = daoPersonaKardexMapper.selectByExample(filtro).get(0);
			
			
			PersonaKardexFamiliarExample filtro2 = new PersonaKardexFamiliarExample();
			
			filtro2.or().andCodigoKardexEqualTo(ninoKardexActual.getCodigoKardex());
			modeloFamiliar.setListPersonaKardexFamiliar(  daoPersonaKardexFamiliarMapper.selectByExample(filtro2 ));
			informeActual = new Informe();
			informeActual.setCodigoKardex(ninoKardexActual.getCodigoKardex());
			
			codigoPersonaA = codigoPersonaDe01 = codigoPersonaDe02 = codigoPersonaDe03 = codigoPersonaVia = -1;
			
			
		}
		
		if(e.getActionCommand().compareTo("Modificar") == 0)
		{
			
			habilitarControles(true);
			tipoOperacion = "I";
			habilitarBotones(false, true, true, false, false, false, false);
			
			tipoOperacion = "E";
			formInformes.getTabbedPane().setSelectedComponent(formInformes.getPnlDatosNinos());
			
		}
		
		if(e.getActionCommand().compareTo("Cancelar") == 0)
		{
			limpiarControles();
			habilitarControles(false);
			habilitarBotones(true, false, false, false, false, true, false);
			tipoOperacion ="";
		}
		
		if(e.getActionCommand().compareTo("Eliminar") == 0)
		{
			if(informeActual != null
					&& JOptionPane.showConfirmDialog(formInformes, "¿Se encuentra seguro de eliminar el registro actual?", "Informes", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			{
				try {
					daoInformeDetalleMapper.deleteByPrimaryKey(informeActual.getCodigoInforme());				
					daoInformeMapper.deleteByPrimaryKey(informeActual.getCodigoInforme());
					session.commit();
					limpiarControles();
					tipoOperacion = "";
					habilitarBotones(true, false, false, false, false, true, false);
					informeActual = null;
					JOptionPane.showMessageDialog(formInformes, "Registro eliminado Correctamente", "Informe", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(formInformes, "No se pudo eliminar el registro actual seguramente se encuentra en uso",  "Informes", JOptionPane.ERROR_MESSAGE);
					System.out.println(e1.getMessage());
					session.clearCache();


				}
			}
			
		}
		
		if(e.getActionCommand().compareTo("Reporte") == 0)
		{
			if(informeActual != null && informeActual.getCodigoTipoInforme() != null)
			{
				String path = rutaLocal + "org/quarkbit/trabajosocialsanjuan/reportes/";
				GeneraReport gr = new GeneraReport();			
				
//				gr.setParameters("Fecha_Inicio",formAlquilerCampoDeportivo.getPnlDateChooser().getSelectedPeriodSet().getFirstDate().getTime());
//				gr.setParameters("Fecha_Fin",formAlquilerCampoDeportivo.getPnlDateChooser().getSelectedPeriodSet().getFirstPeriod().getEndDate().getTime());
				
				
				
				switch (informeActual.getCodigoTipoInforme()) {
				case "A":
					gr.loadReportJasper(path + "listar_informe_reporte_A.jasper");
					break;
				case "B":
					gr.loadReportJasper(path + "listar_informe_reporte_B.jasper");
					break;
				case "C":
					gr.loadReportJasper(path + "listar_informe_reporte_C.jasper");
					break;
				case "D":
					gr.loadReportJasper(path + "listar_informe_reporte_D.jasper");
					break;
				case "E":
					gr.loadReportJasper(path + "listar_informe_reporte_E.jasper");
					break;

				default:
					break;
				}
				gr.setParameters("codigo_informe_aux", informeActual.getCodigoInforme());
				gr.setParameters("SUBREPORT_DIR", path);
				gr.fillReport(session.getConnection());			
				gr.previewReportModal();
			}
			else
			{
				JOptionPane.showMessageDialog(formInformes, "No se encuentra seleccionado ning\u00FAn elemento para mostrar", "Informes", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		if(e.getActionCommand().compareTo("buscarA") == 0)
		{
			FPersonasBuscador formBuscador = new FPersonasBuscador(null);
			formBuscador.control.setTipoPersona("R");
			formBuscador.setVisible(true);
			if(formBuscador.control.personaActual.getNombres() == null)
			{
				JOptionPane.showMessageDialog(formInformes, "No ha seleccionado ning\u00FAn funcionario", "Informes", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			else
			{
				formInformes.getTxtA().setText(formBuscador.control.personaActual.obtenerNombreCompleto());
				codigoPersonaA = formBuscador.control.personaActual.getCodigoPersona();
				personaA = formBuscador.control.personaActual;
			}
		}
		if(e.getActionCommand().compareTo("buscarVia") == 0)
		{
			FPersonasBuscador formBuscador = new FPersonasBuscador(null);
			formBuscador.control.setTipoPersona("R");
			formBuscador.setVisible(true);
			if(formBuscador.control.personaActual.getNombres() == null)
			{
				JOptionPane.showMessageDialog(formInformes, "No ha seleccionado ning\u00FAn funcionario", "Informes", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			else
			{
				formInformes.getTxtVia().setText(formBuscador.control.personaActual.obtenerNombreCompleto());
				codigoPersonaVia = formBuscador.control.personaActual.getCodigoPersona();
				personaVia = formBuscador.control.personaActual;
			}
		}
		if(e.getActionCommand().compareTo("buscarDe01") == 0)
		{
			FPersonasBuscador formBuscador = new FPersonasBuscador(null);
			formBuscador.control.setTipoPersona("R");
			formBuscador.setVisible(true);
			if(formBuscador.control.personaActual.getNombres() == null)
			{
				JOptionPane.showMessageDialog(formInformes, "No ha seleccionado ning\u00FAn personal remitente", "Informes", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			else
			{
				formInformes.getTxtDe01().setText(formBuscador.control.personaActual.obtenerNombreCompleto());
				codigoPersonaDe01 = formBuscador.control.personaActual.getCodigoPersona();
				personaDe01 = formBuscador.control.personaActual;
			}
		}
		
		if(e.getActionCommand().compareTo("buscarDe02") == 0)
		{
			FPersonasBuscador formBuscador = new FPersonasBuscador(null);
			formBuscador.control.setTipoPersona("R");
			formBuscador.setVisible(true);
			if(formBuscador.control.personaActual.getNombres() == null)
			{
				JOptionPane.showMessageDialog(formInformes, "No ha seleccionado ning\u00FAn personal remitente", "Informes", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			else
			{
				formInformes.getTxtDe02().setText(formBuscador.control.personaActual.obtenerNombreCompleto());
				codigoPersonaDe02 = formBuscador.control.personaActual.getCodigoPersona();
				personaDe02 = formBuscador.control.personaActual;
			}
		}
		if(e.getActionCommand().compareTo("buscarDe03") == 0)
		{
			FPersonasBuscador formBuscador = new FPersonasBuscador(null);
			formBuscador.control.setTipoPersona("R");
			formBuscador.setVisible(true);
			if(formBuscador.control.personaActual.getNombres() == null)
			{
				JOptionPane.showMessageDialog(formInformes, "No ha seleccionado ning\u00FAn personal remitente", "Informes", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			else
			{
				formInformes.getTxtDe03().setText(formBuscador.control.personaActual.obtenerNombreCompleto());
				codigoPersonaDe03 = formBuscador.control.personaActual.getCodigoPersona();
				personaDe03 = formBuscador.control.personaActual;
			}
		}
		
		if(e.getActionCommand().compareTo("agregarA") == 0)
		{
			FFamiliar formfamiliares =new FFamiliar(null);
			formfamiliares.HabilitarRegistroPersonas();
			formfamiliares.setVisible(true);
			if(formfamiliares.personaActual != null && !formfamiliares.personaActual.getNombres().isEmpty())
			{					
				formInformes.getTxtA().setText(formfamiliares.personaActual.obtenerNombreCompleto());
				codigoPersonaA = -1;
				personaA = formfamiliares.personaActual;
				
				personaA.setCodigoTipoPersona("R");
				daoPersonaMapper.insert(personaA);
				session.commit();
				
				daoPersonaMapper.obtenerUltimoId(mapa);
				personaA.setCodigoPersona(mapa.get("ultimoId"));
				codigoPersonaA = mapa.get("ultimoId");
			}
			else
			{
				JOptionPane.showMessageDialog(formfamiliares, "No ha seleccionado ning\u00FAn funcionario", "Kardex de Personas", JOptionPane.WARNING_MESSAGE);
			}
			
		}
		
		if(e.getActionCommand().compareTo("agregarVia") == 0)
		{
			FFamiliar formfamiliares =new FFamiliar(null);
			formfamiliares.HabilitarRegistroPersonas();
			formfamiliares.setVisible(true);
			if(formfamiliares.personaActual != null && !formfamiliares.personaActual.getNombres().isEmpty())
			{	
				formInformes.getTxtVia().setText(formfamiliares.personaActual.obtenerNombreCompleto());
				codigoPersonaVia = -1;
				personaVia = formfamiliares.personaActual;
				personaVia.setCodigoTipoPersona("R");
				daoPersonaMapper.insert(personaVia);
				session.commit();
				
				daoPersonaMapper.obtenerUltimoId(mapa);
				personaVia.setCodigoPersona(mapa.get("ultimoId"));
				codigoPersonaVia = mapa.get("ultimoId");
			}
			else
			{
				JOptionPane.showMessageDialog(formfamiliares, "No ha seleccionado ning\u00FAn funcionario", "Kardex de Personas", JOptionPane.WARNING_MESSAGE);
			}
			
		}
		
		if(e.getActionCommand().compareTo("agregarDe01") == 0)
		{
			FFamiliar formfamiliares =new FFamiliar(null);
			formfamiliares.HabilitarRegistroPersonas();
			formfamiliares.setVisible(true);
			if(formfamiliares.personaActual != null && !formfamiliares.personaActual.getNombres().isEmpty())
			{	
				formInformes.getTxtDe01().setText(formfamiliares.personaActual.obtenerNombreCompleto());
				codigoPersonaDe01 = -1;
				personaDe01 = formfamiliares.personaActual;
				personaDe01.setCodigoTipoPersona("R");
				daoPersonaMapper.insert(personaDe01);
				session.commit();
				
				daoPersonaMapper.obtenerUltimoId(mapa);
				personaDe01.setCodigoPersona(mapa.get("ultimoId"));
				codigoPersonaDe01 = mapa.get("ultimoId");
			}
			else
			{
				JOptionPane.showMessageDialog(formfamiliares, "No ha seleccionado ning\u00FAn remitente", "Kardex de Personas", JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if(e.getActionCommand().compareTo("agregarDe02") == 0)
		{
			FFamiliar formfamiliares =new FFamiliar(null);
			formfamiliares.HabilitarRegistroPersonas();
			formfamiliares.setVisible(true);
			if(formfamiliares.personaActual != null && !formfamiliares.personaActual.getNombres().isEmpty())
			{	
				formInformes.getTxtDe02().setText(formfamiliares.personaActual.obtenerNombreCompleto());
				codigoPersonaDe02 = -1;
				personaDe02 = formfamiliares.personaActual;
				personaDe02.setCodigoTipoPersona("R");
				daoPersonaMapper.insert(personaDe02);
				session.commit();
				
				daoPersonaMapper.obtenerUltimoId(mapa);
				personaDe02.setCodigoPersona(mapa.get("ultimoId"));
				codigoPersonaDe02 = mapa.get("ultimoId");
			}
			else
			{
				JOptionPane.showMessageDialog(formfamiliares, "No ha seleccionado ning\u00FAn remitente", "Kardex de Personas", JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if(e.getActionCommand().compareTo("agregarDe03") == 0)
		{
			FFamiliar formfamiliares =new FFamiliar(null);
			formfamiliares.HabilitarRegistroPersonas();
			formfamiliares.setVisible(true);
			if(formfamiliares.personaActual != null && !formfamiliares.personaActual.getNombres().isEmpty())
			{	
				formInformes.getTxtDe03().setText(formfamiliares.personaActual.obtenerNombreCompleto());
				codigoPersonaDe03 = -1;
				personaDe03 = formfamiliares.personaActual;
				personaDe03.setCodigoTipoPersona("R");
				daoPersonaMapper.insert(personaDe03);
				session.commit();
				
				daoPersonaMapper.obtenerUltimoId(mapa);
				personaDe03.setCodigoPersona(mapa.get("ultimoId"));
				codigoPersonaDe03 = mapa.get("ultimoId");
			}
			else
			{
				JOptionPane.showMessageDialog(formfamiliares, "No ha seleccionado ning\u00FAn remitente", "Kardex de Personas", JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if(e.getActionCommand().compareTo("Buscar") == 0)
		{
			FInformesBuscador formBuscador = new FInformesBuscador(null);
			formBuscador.setVisible(true);
			if(formBuscador.control.informeActual != null)
			{
				cargarDatosInforme(formBuscador.control.informeActual, daoInformeDetalleMapper.selectByPrimaryKey(formBuscador.control.informeActual.getCodigoInforme()));
			}
			
		}
		if(e.getActionCommand().compareTo("Cerrar") == 0)
		{
			this.formInformes.setVisible(false);
			this.formInformes.dispose();
			
		}
	}

}
