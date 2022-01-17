package org.quarkbit.trabajosocialsanjuan.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import org.apache.ibatis.session.SqlSession;
import org.quarkbit.trabajosocialsanjuan.dao.domain.IngresoTipo;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Institucion;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PersonaKardex;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PersonaKardexExample;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Usuario;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.IngresoTipoMapper;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.InstitucionMapper;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.PersonaKardexMapper;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.UsuarioMapper;
import org.quarkbit.trabajosocialsanjuan.formularios.FAdministradorMovimientos;
import org.quarkbit.trabajosocialsanjuan.formularios.FAdministradorMenusComidas;
import org.quarkbit.trabajosocialsanjuan.formularios.FCategoriasComidas;
import org.quarkbit.trabajosocialsanjuan.formularios.FComidas;
import org.quarkbit.trabajosocialsanjuan.formularios.FContrasenia;
import org.quarkbit.trabajosocialsanjuan.formularios.FDocumentos;
import org.quarkbit.trabajosocialsanjuan.formularios.FEgresos;
import org.quarkbit.trabajosocialsanjuan.formularios.FEmpleos;
import org.quarkbit.trabajosocialsanjuan.formularios.FFamiliar;
import org.quarkbit.trabajosocialsanjuan.formularios.FFechasRango;
import org.quarkbit.trabajosocialsanjuan.formularios.FGeografico;
import org.quarkbit.trabajosocialsanjuan.formularios.FHistorialClinico;
import org.quarkbit.trabajosocialsanjuan.formularios.FInformePsicologico;
import org.quarkbit.trabajosocialsanjuan.formularios.FInformes;
import org.quarkbit.trabajosocialsanjuan.formularios.FIngresos;
import org.quarkbit.trabajosocialsanjuan.formularios.FIngresosTipos;
import org.quarkbit.trabajosocialsanjuan.formularios.FInstituciones;
import org.quarkbit.trabajosocialsanjuan.formularios.FPartidas;
import org.quarkbit.trabajosocialsanjuan.formularios.FPersonasBuscador;
import org.quarkbit.trabajosocialsanjuan.formularios.FPersonasKardex;
import org.quarkbit.trabajosocialsanjuan.formularios.FPrincipal;
import org.quarkbit.trabajosocialsanjuan.formularios.FPropiedadesHistorialClinico;
import org.quarkbit.trabajosocialsanjuan.formularios.FProveedores;
import org.quarkbit.trabajosocialsanjuan.formularios.FUsuarios;
import org.quarkbit.trabajosocialsanjuan.utils.FormUtilities;
import org.quarkbit.trabajosocialsanjuan.utils.GeneraReport;

public class CFPrincipal implements ActionListener {

	Date fechaHoraServidor;
	SqlSession session;
	FPrincipal formPrincipal;
	Usuario usuarioActual;
	InstitucionMapper daoInstitucion;
	UsuarioMapper daoUsuarioMapper;
	Institucion institucionActual;
	String rutaLocal;
	private int codigoInstitucionActual = 1;
	
	public CFPrincipal(FPrincipal formPrincipal)
	{
		this.formPrincipal = formPrincipal;
		rutaLocal = FormUtilities.obtenerRutaLocal();
		
	}
	

	public void onFormShown()
	{
		
		daoInstitucion = session.getMapper(InstitucionMapper.class);
		daoUsuarioMapper = session.getMapper(UsuarioMapper.class);
		institucionActual = daoInstitucion.selectByPrimaryKey(codigoInstitucionActual);
		formPrincipal.getLblSistema().setText(institucionActual.getNombreInstitucion());
		formPrincipal.getLblUsuario().setText(usuarioActual.getNombreUsuario());
		
		//'S','M','V','A'
		//'S':Secretaria,'M':Medico,'V':Trabajadora Social,'A':Administrador, 'D':Directora del Hogar,'P':'Psicologa'
		if(usuarioActual.getCodigoTipo().compareTo("S") == 0)
		{
			
		}
		if(usuarioActual.getCodigoTipo().compareTo("M") == 0)//MEDICO, A HISTORIAL CLINICO
		{
			formPrincipal.mnArchivo.setVisible(false);
			formPrincipal.mnInformes.setVisible(false);
			formPrincipal.mnKardex.setVisible(true);
			formPrincipal.mnMovimientos.setVisible(false);
			formPrincipal.mnPlanificacin.setVisible(false);
		}
		if(usuarioActual.getCodigoTipo().compareTo("V") == 0)//VISITADORA HA INFOMRES
		{
			formPrincipal.mnArchivo.setVisible(false);
			formPrincipal.mnInformes.setVisible(false);
			formPrincipal.mnKardex.setVisible(true);
			formPrincipal.mnMovimientos.setVisible(false);
			formPrincipal.mnPlanificacin.setVisible(false);
			formPrincipal.btnAdmIngEg.setVisible(false);
			formPrincipal.btnConfiguracin.setVisible(false);
		}
		if(usuarioActual.getCodigoTipo().compareTo("D") == 0)
		{
			
		}
		if(usuarioActual.getCodigoTipo().compareTo("P") == 0)
		{
			formPrincipal.mnArchivo.setVisible(false);
			formPrincipal.mnInformes.setVisible(true);
			formPrincipal.mnKardex.setVisible(false);
			formPrincipal.mnMovimientos.setVisible(false);
			formPrincipal.mnPlanificacin.setVisible(false);
			formPrincipal.btnAdmIngEg.setVisible(false);
			formPrincipal.btnConfiguracin.setVisible(false);
			formPrincipal.btnKardex.setVisible(false);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().compareTo("Empleos") == 0)
		{
			FEmpleos formEmpleos = new FEmpleos(formPrincipal);
			formEmpleos.setVisible(true);
		}
		if(e.getActionCommand().compareTo("TiposIngresos") == 0)
		{
			FIngresosTipos formEmpleos = new FIngresosTipos(formPrincipal);
			formEmpleos.setVisible(true);
		}
		if(e.getActionCommand().compareTo("Proveedores") == 0)
		{
			FProveedores formEmpleos = new FProveedores(formPrincipal);
			formEmpleos.setVisible(true);
		}
		if(e.getActionCommand().compareTo("Instituciones") == 0)
		{
			FInstituciones formEmpleos = new FInstituciones(formPrincipal);
			formEmpleos.setVisible(true);
		}
		if(e.getActionCommand().compareTo("Partidas") == 0)
		{
			FPartidas formEmpleos = new FPartidas(formPrincipal);
			formEmpleos.setVisible(true);
		}
		

		if(e.getActionCommand().compareTo("Configuracion") == 0)
		{
			FGeografico formEmpleos = new FGeografico(formPrincipal);
			formEmpleos.setVisible(true);
		}
		if(e.getActionCommand().compareTo("Paises") == 0)
		{
			FGeografico formGeografico = new FGeografico(formPrincipal);
			formGeografico.getControl().visualizarPnlGeografico(1);
			formGeografico.setVisible(true);
		}
		if(e.getActionCommand().compareTo("Departamentos") == 0)
		{
			FGeografico formGeografico = new FGeografico(formPrincipal);
			formGeografico.getControl().visualizarPnlGeografico(2);
			formGeografico.setVisible(true);
		}
		if(e.getActionCommand().compareTo("Provincias") == 0)
		{
			FGeografico formGeografico = new FGeografico(formPrincipal);
			formGeografico.getControl().visualizarPnlGeografico(3);
			formGeografico.setVisible(true);
		}
		if(e.getActionCommand().compareTo("Lugares") == 0)
		{
			FGeografico formGeografico = new FGeografico(formPrincipal);
			formGeografico.getControl().visualizarPnlGeografico(4);
			formGeografico.setVisible(true);
		}
		if(e.getActionCommand().compareTo("Usuarios") == 0)
		{
			FUsuarios formusuario = new FUsuarios(formPrincipal);			
			FormUtilities.centrar(formusuario);
			formusuario.setVisible(true);
			
		}
		
		//cambiarContrasenia
		if(e.getActionCommand().compareTo("cambiarContrasenia") == 0)
		{
			FContrasenia formContrasenia = new FContrasenia(formPrincipal);
			formContrasenia.getJtxtLogin().setText(formPrincipal.getLblUsuario().getText());
			formContrasenia.getJtxtLogin().grabFocus();
			formContrasenia.getJtxtLogin().selectAll();
			FormUtilities.centrar(formContrasenia);
			formContrasenia.setVisible(true);
//			System.out.println(usuarioActual.getCodigoUsuario() + ", confirmado " + formContrasenia.getControl().confirmado);
			if(formContrasenia.getControl().confirmado)
			{
				
				usuarioActual.setContrasenia(formContrasenia.getControl().password);
				daoUsuarioMapper.updateByPrimaryKey(usuarioActual);
				session.commit();
				
				JOptionPane.showMessageDialog(formContrasenia, "Contrasenia cambiada correctamente", "Usuarios", JOptionPane.INFORMATION_MESSAGE);
			}
			
//			formContrasenia.dispose();
			
		}
		
		
		if(e.getActionCommand().compareTo("Salir") == 0)
		{
			session.close();
			System.exit(0);
		}
		if(e.getActionCommand().compareTo("Registro") == 0)
		{
			FPersonasKardex formEmpleos = new FPersonasKardex(formPrincipal);
			formEmpleos.setVisible(true);
		}
		if(e.getActionCommand().compareTo("Usuarios") == 0)
		{
			
		}
		if(e.getActionCommand().compareTo("Busqueda") == 0)
		{
			FPersonasKardex formEmpleos = new FPersonasKardex(formPrincipal);
			formEmpleos.getTabbedPane().setSelectedIndex(4);
			formEmpleos.setVisible(true);
		}
		if(e.getActionCommand().compareTo("Documentos") == 0)
		{
			FDocumentos formdocumentos = new FDocumentos(formPrincipal);
			formdocumentos.setVisible(true);
		}
		if(e.getActionCommand().compareTo("Familiares") == 0)
		{
			FFamiliar formFamiliares =new FFamiliar(formPrincipal);
			formFamiliares.setVisible(true);
		}
		if(e.getActionCommand().compareTo("AdministradorIE") == 0)
		{
			FAdministradorMovimientos formMovimientos = new FAdministradorMovimientos(formPrincipal);
			formMovimientos.setVisible(true);
		}
		if(e.getActionCommand().compareTo("Ingresos") == 0)
		{
			FIngresos formIngresos = new FIngresos(formPrincipal);
			formIngresos.setVisible(true);
		}
		
		if(e.getActionCommand().compareTo("Tipos Ingresos") == 0)
		{
			FIngresosTipos formingresos = new FIngresosTipos(formPrincipal);
			formingresos.setVisible(true);
		}
		
		if(e.getActionCommand().compareTo("Salidas") == 0)
		{
			FEgresos formEgresos = new FEgresos(formPrincipal);
			formEgresos.setVisible(true);
		}
		if(e.getActionCommand().compareTo("Categorias") == 0)
		{
			FCategoriasComidas formCategoriasComidas = new FCategoriasComidas(formPrincipal);
			formCategoriasComidas.setVisible(true);
		}
		if(e.getActionCommand().compareTo("Comidas") == 0)
		{
			FComidas formCategoriasComidas = new FComidas(formPrincipal);
			formCategoriasComidas.setVisible(true);
		}
		
		if(e.getActionCommand().compareTo("Menus") == 0)
		{
			FAdministradorMenusComidas form = new FAdministradorMenusComidas();
			FormUtilities.centrar(form);
			form.setVisible(true);
		}
		
		if(e.getActionCommand().compareTo("General") == 0)
		{
			FInformes form = new FInformes(formPrincipal);
			FormUtilities.centrar(form);
			form.setVisible(true);
		}
		
		if(e.getActionCommand().compareTo("Psicolgico") == 0)
		{
			FInformePsicologico form = new FInformePsicologico(formPrincipal);
			FormUtilities.centrar(form);
			form.setVisible(true);
		}
		
		/////////////
		if(e.getActionCommand().compareTo("RegistroHC") == 0)
		{
//			FHistorialClinico form = new FHistorialClinico(null);
			FHistorialClinico form = new FHistorialClinico(formPrincipal);
			FormUtilities.centrar(form);
			form.setVisible(true);
//			FPropiedadesHistorialClinico formPropiedades = new FPropiedadesHistorialClinico(formPrincipal);
//			formPropiedades.setVisible(true);
//			FormUtilities.centrar(formPropiedades);
//			formPropiedades.dispose();
		}
		if(e.getActionCommand().compareTo("Categorias Consulta") == 0)
		{
			FPropiedadesHistorialClinico formPropiedades = new FPropiedadesHistorialClinico(formPrincipal);
			formPropiedades.setVisible(true);
			FormUtilities.centrar(formPropiedades);
			formPropiedades.dispose();
		}
		///////////////
		
		if(e.getActionCommand().compareTo("listadoUsuarios") == 0)
		{
			String path = rutaLocal + "org/quarkbit/trabajosocialsanjuan/reportes/";
			GeneraReport gr = new GeneraReport();			
			gr.loadReportJasper(path + "obtener_reporte_usuarios01.jasper");
			gr.setParameters("codigo_persona_aux",null);
			gr.setParameters("codigo_empleo_aux",null);
			gr.setParameters("codigo_tipo_aux", null);
			gr.fillReport(session.getConnection());			
			gr.previewReport();
		}
		
		//obtener_reporte_usuarios02
		if(e.getActionCommand().compareTo("informeUsuarioIndividual") == 0)
		{
			FPersonasBuscador formBuscador = new FPersonasBuscador(formPrincipal);
			formBuscador.control.setTipoPersona("U");
			formBuscador.lblMensaje.setText("Seleccione el Usuario");
			formBuscador.setVisible(true);
			
			String path = rutaLocal + "org/quarkbit/trabajosocialsanjuan/reportes/";
			GeneraReport gr = new GeneraReport();			
			gr.loadReportJasper(path + "obtener_reporte_usuarios02.jasper");
			if(formBuscador.control.personaActual != null)
				gr.setParameters("codigo_persona_aux",formBuscador.control.personaActual.getCodigoPersona());
			else
			{
				gr.setParameters("codigo_persona_aux",null);
				return;
			}
			gr.setParameters("codigo_empleo_aux",null);
			gr.setParameters("codigo_tipo_aux", null);
			gr.fillReport(session.getConnection());			
			gr.previewReport();
		}
		
		if(e.getActionCommand().compareTo("cuentasUsuario") == 0)
		{
			String path = rutaLocal + "org/quarkbit/trabajosocialsanjuan/reportes/";
			GeneraReport gr = new GeneraReport();			
			gr.loadReportJasper(path + "obtener_reporte_usuarios03a.jasper");
			gr.setParameters("codigo_persona_aux",null);
			gr.setParameters("codigo_empleo_aux",null);
			gr.setParameters("codigo_tipo_aux", null);
			gr.fillReport(session.getConnection());			
			gr.previewReport();
		}
		
		if(e.getActionCommand().compareTo("Informe General") == 0)
		{
			FPersonasBuscador formBuscador = new FPersonasBuscador(formPrincipal);
			formBuscador.control.setTipoPersona("N");
			formBuscador.lblMensaje.setText("Seleccione el niño del cual desea ver su kardex");
			formBuscador.setVisible(true);
			
			if(formBuscador.control.personaActual == null)
			{
				JOptionPane.showMessageDialog(formPrincipal, "No ha seleccionado ningun nino", "Kardex Infantil", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			PersonaKardexMapper personaDao = session.getMapper(PersonaKardexMapper.class);
			PersonaKardexExample filtro = new PersonaKardexExample();
			System.out.println(formBuscador.control.personaActual.getCodigoPersona());
			filtro.or().andCodigoPersonaEqualTo(formBuscador.control.personaActual.getCodigoPersona());			
			PersonaKardex personaKardex = personaDao.selectByExample(filtro).get(0);
			
			String path = rutaLocal + "org/quarkbit/trabajosocialsanjuan/reportes/";
			GeneraReport gr = new GeneraReport();			
			gr.loadReportJasper(path + "obtener_ficha_kardex2.jasper");			
			gr.setParameters("codigo_kardex_aux",personaKardex.getCodigoKardex());		
			gr.setParameters("SUBREPORT_DIR", path);
			gr.fillReport(session.getConnection());			
			gr.previewReport();
		}
		
		if(e.getActionCommand().compareTo("ReporteDocumentos") == 0)
		{
			FPersonasBuscador formBuscador = new FPersonasBuscador(formPrincipal);
			formBuscador.control.setTipoPersona("N");
			formBuscador.lblMensaje.setText("Seleccione el niño del cual desea ver sus documentos");
			formBuscador.setVisible(true);
			
			if(formBuscador.control.personaActual == null || 
					formBuscador.control.personaActual.getNombres() == "")
			{
				JOptionPane.showMessageDialog(formPrincipal, "No ha seleccionado ningun nino", "Kardex Infantil", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			PersonaKardexMapper personaDao = session.getMapper(PersonaKardexMapper.class);
			PersonaKardexExample filtro = new PersonaKardexExample();			
			filtro.or().andCodigoPersonaEqualTo(formBuscador.control.personaActual.getCodigoPersona());			
			PersonaKardex personaKardex = personaDao.selectByExample(filtro).get(0);
			
			
			String path = rutaLocal + "org/quarkbit/trabajosocialsanjuan/reportes/";
			GeneraReport gr = new GeneraReport();			
			gr.loadReportJasper(path + "obtener_ficha_kardex02.jasper");			
			gr.setParameters("codigo_kardex_aux",personaKardex.getCodigoKardex());
			gr.setParameters("SUBREPORT_DIR", path);
			gr.fillReport(session.getConnection());			
			gr.previewReport();
		}
		
		if(e.getActionCommand().compareTo("ReporteFamiliares") == 0)
		{
			FPersonasBuscador formBuscador = new FPersonasBuscador(formPrincipal);
			formBuscador.control.setTipoPersona("N");
			formBuscador.lblMensaje.setText("Seleccione el niño del cual desea ver sus familiares");
			formBuscador.setVisible(true);
			
			if(formBuscador.control.personaActual == null)
			{
				JOptionPane.showMessageDialog(formPrincipal, "No ha seleccionado ningun nino", "Kardex Infantil", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			PersonaKardexMapper personaDao = session.getMapper(PersonaKardexMapper.class);
			PersonaKardexExample filtro = new PersonaKardexExample();
			filtro.or().andCodigoPersonaEqualTo(formBuscador.control.personaActual.getCodigoPersona());
			PersonaKardex personaKardex = personaDao.selectByExample(filtro).get(0);
			
			String path = rutaLocal + "org/quarkbit/trabajosocialsanjuan/reportes/";
			GeneraReport gr = new GeneraReport();			
			gr.loadReportJasper(path + "obtener_ficha_kardex03.jasper");			
			gr.setParameters("codigo_kardex_aux",personaKardex.getCodigoKardex());
			gr.setParameters("SUBREPORT_DIR", path);
			gr.fillReport(session.getConnection());			
			gr.previewReport();
		}
		
		if(e.getActionCommand().compareTo("ReporteIngresos") == 0)
		{
			FFechasRango formFechas = new FFechasRango(formPrincipal);
			FormUtilities.centrar(formFechas);
			formFechas.visualizarFiltro(false);
			formFechas.setVisible(true);
			if(formFechas.getDateFechaFin().getDate() == null || formFechas.getDateFechaInicio().getDate() == null)
			{
				JOptionPane.showMessageDialog(formPrincipal, "No ha seleccionado un periodo de tiempo", "Ingresos", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			String path = rutaLocal + "org/quarkbit/trabajosocialsanjuan/reportes/";
			GeneraReport gr = new GeneraReport();			
			gr.loadReportJasper(path + "obtener_reporte_ingresos01.jasper");
			gr.setParameters("codigo_usuario_aux",null);
			gr.setParameters("codigo_ingreso_tipo_aux",null);
			gr.setParameters("fecha_inicio", formFechas.getDateFechaInicio().getDate());
			gr.setParameters("fecha_fin", formFechas.getDateFechaFin().getDate());
			gr.fillReport(session.getConnection());	
			
			gr.previewReport();
		}
		
		
		if(e.getActionCommand().compareTo("Egresos por Partida") == 0)
		{
			FFechasRango formFechas = new FFechasRango(formPrincipal);
			FormUtilities.centrar(formFechas);
			formFechas.visualizarFiltro(false);
			formFechas.setVisible(true);
			if(formFechas.getDateFechaFin().getDate() == null || formFechas.getDateFechaInicio().getDate() == null)
			{
				JOptionPane.showMessageDialog(formPrincipal, "No ha seleccionado un periodo de tiempo", "Ingresos", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			String path = rutaLocal + "org/quarkbit/trabajosocialsanjuan/reportes/";
			GeneraReport gr = new GeneraReport();			
			gr.loadReportJasper(path + "obtener_reporte_egresos01.jasper");
			gr.setParameters("codigo_usuario_aux",null);
			gr.setParameters("codigo_proveedor_aux",null);
			gr.setParameters("codigo_partida_aux", null);
			gr.setParameters("fecha_inicio", formFechas.getDateFechaInicio().getDate());
			gr.setParameters("fecha_fin", formFechas.getDateFechaFin().getDate());
			gr.fillReport(session.getConnection());			
			gr.previewReport();
		}
		
		if(e.getActionCommand().compareTo("Egresos por Proveedor") == 0)
		{
			FFechasRango formFechas = new FFechasRango(formPrincipal);
			FormUtilities.centrar(formFechas);
			formFechas.visualizarFiltro(false);
			formFechas.setVisible(true);
			if(formFechas.getDateFechaFin().getDate() == null || formFechas.getDateFechaInicio().getDate() == null)
			{
				JOptionPane.showMessageDialog(formPrincipal, "No ha seleccionado un periodo de tiempo", "Ingresos", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			String path = rutaLocal + "org/quarkbit/trabajosocialsanjuan/reportes/";
			GeneraReport gr = new GeneraReport();			
			gr.loadReportJasper(path + "obtener_reporte_egresos02.jasper");
			gr.setParameters("codigo_usuario_aux",null);
			gr.setParameters("codigo_proveedor_aux",null);
			gr.setParameters("codigo_partida_aux", null);
			gr.setParameters("fecha_inicio", formFechas.getDateFechaInicio().getDate());
			gr.setParameters("fecha_fin", formFechas.getDateFechaFin().getDate());
			gr.fillReport(session.getConnection());			
			gr.previewReport();
		}
		
		if(e.getActionCommand().compareTo("Ingresos y Egresos") == 0)
		{
			FFechasRango formFechas = new FFechasRango(formPrincipal);
			FormUtilities.centrar(formFechas);
			formFechas.visualizarFiltro(false);
			formFechas.setVisible(true);
			if(formFechas.getDateFechaFin().getDate() == null || formFechas.getDateFechaInicio().getDate() == null)
			{
				JOptionPane.showMessageDialog(formPrincipal, "No ha seleccionado un periodo de tiempo", "Ingresos", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			String path = rutaLocal + "org/quarkbit/trabajosocialsanjuan/reportes/";
			GeneraReport gr = new GeneraReport();			
			gr.loadReportJasper(path + "obtener_reporte_egresos_ingresos01.jasper");
			gr.setParameters("codigo_ingreso_aux",null);
			gr.setParameters("codigo_ingreso_tipo_aux",null);
			gr.setParameters("codigo_proveedor_aux", null);
			gr.setParameters("codigo_partida_aux", null);
			gr.setParameters("fecha_inicio", formFechas.getDateFechaInicio().getDate());
			gr.setParameters("fecha_fin", formFechas.getDateFechaFin().getDate());
			gr.fillReport(session.getConnection());			
			gr.previewReport();
		}
		
		if(e.getActionCommand().compareTo("Donaciones por Fuente de Ingreso") == 0)
		{
			FFechasRango formFechas = new FFechasRango(formPrincipal);
			FormUtilities.centrar(formFechas);
			formFechas.visualizarFiltro(true);
			IngresoTipoMapper daoFuentesIngreso = session.getMapper(IngresoTipoMapper.class);
			for (IngresoTipo fuente : daoFuentesIngreso.selectByExample(null)) {
				formFechas.getcBoxFiltro().addItem(fuente);
			}
			formFechas.setVisible(true);
			if(formFechas.getDateFechaFin().getDate() == null || formFechas.getDateFechaInicio().getDate() == null)
			{
				JOptionPane.showMessageDialog(formPrincipal, "No ha seleccionado un periodo de tiempo", "Ingresos", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			String path = rutaLocal + "org/quarkbit/trabajosocialsanjuan/reportes/";
			GeneraReport gr = new GeneraReport();			
			gr.loadReportJasper(path + "obtener_reporte_egresos_ingresos02.jasper");
			gr.setParameters("codigo_ingreso_aux",null);
			if(formFechas.getcBoxFiltro().getSelectedIndex() < 0)
			{
				gr.setParameters("codigo_ingreso_tipo_aux",null);
			}
			else
			{
				gr.setParameters("codigo_ingreso_tipo_aux", ((IngresoTipo)formFechas.getcBoxFiltro().getSelectedItem()).getCodigoIngresoTipo());
			}
			
			gr.setParameters("codigo_proveedor_aux", null);
			gr.setParameters("codigo_partida_aux", null);
			gr.setParameters("fecha_inicio", formFechas.getDateFechaInicio().getDate());
			gr.setParameters("fecha_fin", formFechas.getDateFechaFin().getDate());
			gr.fillReport(session.getConnection());			
			gr.previewReport();
		}
		
		
		
		if(e.getActionCommand().compareTo("ReporteProveedores") == 0)
		{
			String path = rutaLocal + "org/quarkbit/trabajosocialsanjuan/reportes/";
			GeneraReport gr = new GeneraReport();			
			gr.loadReportJasper(path + "obtener_reporte_proveedores01.jasper");
			gr.setParameters("codigo_proveedor_aux",null);			
			gr.fillReport(session.getConnection());			
			gr.previewReport();
		}
		
		if(e.getActionCommand().compareTo("Fuentes de Ingreso") == 0)
		{
			String path = rutaLocal + "org/quarkbit/trabajosocialsanjuan/reportes/";
			GeneraReport gr = new GeneraReport();			
			gr.loadReportJasper(path + "obtener_reporte_ingresos_tipos01.jasper");
			gr.setParameters("codigo_ingreso_tipo_aux",null);			
			gr.fillReport(session.getConnection());			
			gr.previewReport();
		}
		
		if(e.getActionCommand().compareTo("ReportePartidas") == 0)
		{
			String path = rutaLocal + "org/quarkbit/trabajosocialsanjuan/reportes/";
			GeneraReport gr = new GeneraReport();			
			gr.loadReportJasper(path + "obtener_reporte_partidas01.jasper");
			gr.setParameters("codigo_partida_aux",null);			
			gr.fillReport(session.getConnection());			
			gr.previewReport();
		}
		
		if(e.getActionCommand().compareTo("ReporteCategoriaComida") == 0)
		{
			String path = rutaLocal + "org/quarkbit/trabajosocialsanjuan/reportes/";
			GeneraReport gr = new GeneraReport();			
			gr.loadReportJasper(path + "obtener_reporte_categorias_comidas01.jasper");
			gr.setParameters("codigo_categoria_aux",null);			
			gr.fillReport(session.getConnection());			
			gr.previewReport();
		}
		
		if(e.getActionCommand().compareTo("ReporteComidas") == 0)
		{
			String path = rutaLocal + "org/quarkbit/trabajosocialsanjuan/reportes/";
			GeneraReport gr = new GeneraReport();			
			gr.loadReportJasper(path + "obtener_reporte_categorias_comidas02.jasper");
			gr.setParameters("codigo_categoria_aux",null);			
			gr.fillReport(session.getConnection());			
			gr.previewReport();
		}
		
		if(e.getActionCommand().compareTo("ReporteMenuSemanal") == 0)
		{
			FFechasRango formFechas = new FFechasRango(formPrincipal);
			FormUtilities.centrar(formFechas);
			formFechas.visualizarFiltro(false);
			formFechas.setVisible(true);
			if(formFechas.getDateFechaFin().getDate() == null || formFechas.getDateFechaInicio().getDate() == null)
			{
				JOptionPane.showMessageDialog(formPrincipal, "No ha seleccionado un periodo de tiempo", "Ingresos", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			String path = rutaLocal + "org/quarkbit/trabajosocialsanjuan/reportes/";
			GeneraReport gr = new GeneraReport();			
			gr.loadReportJasper(path + "generar_menu_semanal.jasper");			
			gr.setParameters("Fecha_Inicio", formFechas.getDateFechaInicio().getDate());
			gr.setParameters("Fecha_Fin", formFechas.getDateFechaFin().getDate());
			gr.setParameters("Institucion", "HOGAR TATA JUAN DE DIOS");
			gr.fillReport(session.getConnection());			
			gr.previewReport();
		}
		
		
		if(e.getActionCommand().compareTo("ReporteCantidadNinos") == 0)
		{
			FFechasRango formFechas = new FFechasRango(formPrincipal);
			FormUtilities.centrar(formFechas);
			formFechas.visualizarFiltro(false);
			formFechas.setVisible(true);
			if(formFechas.getDateFechaFin().getDate() == null || formFechas.getDateFechaInicio().getDate() == null)
			{
				JOptionPane.showMessageDialog(formPrincipal, "No ha seleccionado un periodo de tiempo", "Ingresos", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			String path = rutaLocal + "org/quarkbit/trabajosocialsanjuan/reportes/";
			GeneraReport gr = new GeneraReport();			
			gr.loadReportJasper(path + "obtener_reporte_estadistico_ninos01.jasper");			
			gr.setParameters("edad_aux", null);
			gr.setParameters("fecha_inicio", formFechas.getDateFechaInicio().getDate());
			gr.setParameters("fecha_fin", formFechas.getDateFechaFin().getDate());
			gr.fillReport(session.getConnection());			
			gr.previewReport();
	
		}
		
		if(e.getActionCommand().compareTo("ReporteDonacionesRecibidas") == 0)
		{
			FFechasRango formFechas = new FFechasRango(formPrincipal);
			FormUtilities.centrar(formFechas);
			formFechas.visualizarFiltro(false);
			formFechas.setVisible(true);
			if(formFechas.getDateFechaFin().getDate() == null || formFechas.getDateFechaInicio().getDate() == null)
			{
				JOptionPane.showMessageDialog(formPrincipal, "No ha seleccionado un periodo de tiempo", "Ingresos", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			String path = rutaLocal + "org/quarkbit/trabajosocialsanjuan/reportes/";
			GeneraReport gr = new GeneraReport();			
			gr.loadReportJasper(path + "obtener_reporte_ingresos02.jasper");			
			gr.setParameters("codigo_usuario_aux", null);
			gr.setParameters("codigo_ingreso_tipo_aux", null);
			gr.setParameters("fecha_inicio", formFechas.getDateFechaInicio().getDate());
			gr.setParameters("fecha_fin", formFechas.getDateFechaFin().getDate());
			gr.fillReport(session.getConnection());			
			gr.previewReport();
	
		}
		
		
		if(e.getActionCommand().compareTo("NinosEdadSexo") == 0)
		{			
			String path = rutaLocal + "org/quarkbit/trabajosocialsanjuan/reportes/";
			GeneraReport gr = new GeneraReport();			
			gr.loadReportJasper(path + "listadoTablaCruzadaEdadSexo.jasper");		
			gr.fillReport(session.getConnection());			
			gr.previewReport();
	
		}
	}


	public Date getFechaHoraServidor() {
		return fechaHoraServidor;
	}


	public void setFechaHoraServidor(Date fechaHoraServidor) {
		this.fechaHoraServidor = fechaHoraServidor;
	}


	public SqlSession getSession() {
		return session;
	}


	public void setSession(SqlSession session) {
		this.session = session;
	}


	public Usuario getUsuarioActual() {
		return usuarioActual;
	}


	public void setUsuarioActual(Usuario usuarioActual) {
		this.usuarioActual = usuarioActual;
	}
	
	

}

