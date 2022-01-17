package org.quarkbit.trabajosocialsanjuan.controller;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.apache.ibatis.session.SqlSession;
import org.apache.tools.ant.taskdefs.rmic.KaffeRmic;
import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.quarkbit.trabajosocialsanjuan.dao.Coneccion;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Departamento;
import org.quarkbit.trabajosocialsanjuan.dao.domain.DepartamentoExample;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Documento;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Empleo;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Institucion;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Lugar;
import org.quarkbit.trabajosocialsanjuan.dao.domain.LugarExample;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Pais;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Parentesco;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Persona;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PersonaDatosNacimiento;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PersonaExample;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PersonaKardex;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PersonaKardexDocumento;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PersonaKardexDocumentoExample;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PersonaKardexExample;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PersonaKardexFamiliar;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PersonaKardexFamiliarExample;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PersonaKardexFamiliarKey;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Provincia;
import org.quarkbit.trabajosocialsanjuan.dao.domain.ProvinciaExample;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.DepartamentoMapper;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.EmpleoMapper;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.InstitucionMapper;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.LugarMapper;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.PaisMapper;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.ParentescoMapper;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.PersonaDatosNacimientoMapper;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.PersonaKardexDocumentoMapper;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.PersonaKardexFamiliarMapper;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.PersonaKardexMapper;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.PersonaMapper;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.ProvinciaMapper;
import org.quarkbit.trabajosocialsanjuan.formularios.FDocumentos;
import org.quarkbit.trabajosocialsanjuan.formularios.FFamiliar;
import org.quarkbit.trabajosocialsanjuan.formularios.FInstituciones;
import org.quarkbit.trabajosocialsanjuan.formularios.FPersonasBuscador;
import org.quarkbit.trabajosocialsanjuan.formularios.FPersonasKardex;
import org.quarkbit.trabajosocialsanjuan.formularios.tablemodels.ModeloDocumentos;
import org.quarkbit.trabajosocialsanjuan.formularios.tablemodels.ModeloFamiliares;
import org.quarkbit.trabajosocialsanjuan.formularios.tablemodels.ModeloPersonas;
import org.quarkbit.trabajosocialsanjuan.utils.FormUtilities;
import org.quarkbit.trabajosocialsanjuan.utils.GeneraReport;

public class CFPersonasKardex extends KeyAdapter implements ActionListener, ListSelectionListener, PropertyChangeListener, MouseListener, DocumentListener{

	FPersonasKardex formPersonasKardex;
	String tipoOperacion ="";
	ModeloDocumentos modeloDocumento;
	ModeloFamiliares modeloFamiliares;
	ModeloPersonas modeloPersona;
	
	PersonaMapper daoPersonaMapper;
	PersonaKardexMapper daoPersonaKardexMapper;
	PersonaDatosNacimientoMapper daoPersonaDatosNacimiento;
	PersonaKardexDocumentoMapper daoPersonaKardexDocumento;
	PersonaKardexFamiliarMapper daoPersonaKardexFamiliar;
	EmpleoMapper daoEmpleo;
	InstitucionMapper daoInstitucion;
	PaisMapper daoPais;
	DepartamentoMapper daoDempartamento;
	ProvinciaMapper daoProvincia;
	LugarMapper daoLugar;
	ParentescoMapper daoParentesco;
	SqlSession session;
	
	Pais paisActual;
	Departamento departamentoActual;
	Provincia provinciaActual;
	Lugar lugarActual;
	
	Persona personaActual;
	PersonaKardex personaKardexActual;
	PersonaDatosNacimiento personaDatosNacActual;
	
	private int codigoUsuario =1;	
	private int codigoInstitucion=1;
	
	private DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	private String rutaLocal;
	
	public CFPersonasKardex(FPersonasKardex formPersonasKardex)
	{
		this.formPersonasKardex = formPersonasKardex;
		modeloDocumento = new ModeloDocumentos();
		modeloFamiliares = new ModeloFamiliares();
		modeloPersona = new ModeloPersonas();
		session = Coneccion.getSqlSessionFactory().openSession();
		
		daoPersonaMapper = session.getMapper(PersonaMapper.class);
		daoPersonaDatosNacimiento = session.getMapper(PersonaDatosNacimientoMapper.class);
		daoPersonaKardexMapper = session.getMapper(PersonaKardexMapper.class);
		daoPersonaKardexDocumento = session.getMapper(PersonaKardexDocumentoMapper.class);
		daoPersonaKardexFamiliar = session.getMapper(PersonaKardexFamiliarMapper.class);
		daoEmpleo = session.getMapper(EmpleoMapper.class);
		daoInstitucion = session.getMapper(InstitucionMapper.class);
		daoPais = session.getMapper(PaisMapper.class);
		daoDempartamento = session.getMapper(DepartamentoMapper.class);
		daoProvincia = session.getMapper(ProvinciaMapper.class);
		daoLugar = session.getMapper(LugarMapper.class);
		daoParentesco = session.getMapper(ParentescoMapper.class);
		
		paisActual = new Pais();
		departamentoActual = new Departamento();
		provinciaActual = new Provincia();
		lugarActual = new Lugar();
		personaDatosNacActual = new PersonaDatosNacimiento();
		personaKardexActual = new PersonaKardex();
		personaActual = new Persona();
		
		rutaLocal = FormUtilities.obtenerRutaLocal();
		
	}
	
	public void habilitarControlesKardex(boolean estadoHabilitacion)
	{
		formPersonasKardex.getTxtNroKardex().setEditable(estadoHabilitacion);
		formPersonasKardex.getTxtNombreKardex().setEditable(estadoHabilitacion);
		formPersonasKardex.getDateFechaIngreso().setEnabled(estadoHabilitacion);
		formPersonasKardex.getcBoxInstitucion().setEnabled(estadoHabilitacion);
		formPersonasKardex.getcBoxTrabajadoraSocial().setEnabled(estadoHabilitacion);
		formPersonasKardex.getBtnAgregarInst().setEnabled(estadoHabilitacion);
		formPersonasKardex.getBtnAgregarTrabSocial().setEnabled(estadoHabilitacion);
		formPersonasKardex.getTxtMotivoEgreso().setEditable(estadoHabilitacion);
		formPersonasKardex.getTxtMotivoIngreso().setEditable(estadoHabilitacion);
		formPersonasKardex.getBtnBuscarPersonaEgreso().setEnabled(estadoHabilitacion);
		formPersonasKardex.getBtnBuscarPersonaIngreso().setEnabled(estadoHabilitacion);
		formPersonasKardex.getBtnAgregarPersonaIngreso().setEnabled(estadoHabilitacion);
		formPersonasKardex.getBtnAgregarPersonaEgreso().setEnabled(estadoHabilitacion);
	}
	
	public void habilitarControlesDatosNacimiento(boolean estadoHabilitacion)
	{
		formPersonasKardex.getDateFechaNac().setEnabled(estadoHabilitacion);
//		formPersonasKardex.getTxtEdad().setEditable(estadoHabilitacion);
		formPersonasKardex.getcBoxPais().setEnabled(estadoHabilitacion);
		formPersonasKardex.getcBoxDepartamento().setEnabled(estadoHabilitacion);
		formPersonasKardex.getcBoxProvincia().setEnabled(estadoHabilitacion);
		formPersonasKardex.getcBoxLugar().setEnabled(estadoHabilitacion);
	}
	
	
	public void limpiarControlesKardex()
	{
		formPersonasKardex.getTxtNroKardex().setText("");
		formPersonasKardex.getTxtNombreKardex().setText("");
		formPersonasKardex.getDateFechaIngreso().setDate(null);
		formPersonasKardex.getcBoxInstitucion().setSelectedIndex(-1);
		formPersonasKardex.getcBoxTrabajadoraSocial().setSelectedIndex(-1);
		formPersonasKardex.getTxtMotivoEgreso().setText("");
		formPersonasKardex.getTxtMotivoIngreso().setText("");
		formPersonasKardex.getTxtPersonaEgreso().setText("");
		formPersonasKardex.getTxtPresonaIngreso().setText("");
	}
	
	public boolean validarDatosKardex()
	{
		if(formPersonasKardex.getTxtNroKardex().getText().isEmpty())
		{
			JOptionPane.showMessageDialog(formPersonasKardex, "No puede dejar en blanco el Nro de kardex en blanco", "Kardex", JOptionPane.WARNING_MESSAGE);
			formPersonasKardex.getTabbedPane().setSelectedComponent(formPersonasKardex.getPnlKardex());
			formPersonasKardex.getTxtNroKardex().grabFocus();
			return false;
		}
		
		if(formPersonasKardex.getTxtNombreKardex().getText().isEmpty())
		{
			JOptionPane.showMessageDialog(formPersonasKardex, "No puede dejar en blanco el nombre del kardex en blanco", "Kardex", JOptionPane.WARNING_MESSAGE);
			formPersonasKardex.getTabbedPane().setSelectedComponent(formPersonasKardex.getPnlKardex());
			formPersonasKardex.getTxtNombreKardex().grabFocus();
			return false;
		}
		
		if(formPersonasKardex.getDateFechaIngreso().getDate() == null)
		{
			JOptionPane.showMessageDialog(formPersonasKardex, "Debe ingresar la Fecha de Ingreso", "Kardex", JOptionPane.WARNING_MESSAGE);
			formPersonasKardex.getTabbedPane().setSelectedComponent(formPersonasKardex.getPnlKardex());
			formPersonasKardex.getDateFechaIngreso().grabFocus();
			return false;
		}
		
		if(formPersonasKardex.getcBoxInstitucion().getSelectedIndex() == -1)
		{
			JOptionPane.showMessageDialog(formPersonasKardex, "Debe seleccionar la Institucion", "Kardex", JOptionPane.WARNING_MESSAGE);
			formPersonasKardex.getTabbedPane().setSelectedComponent(formPersonasKardex.getPnlKardex());
			formPersonasKardex.getcBoxInstitucion().grabFocus();
			return false;
		}
		return true;
	}
	
	public boolean validarDatosNacimiento()
	{
		if(formPersonasKardex.getDateFechaNac().getDate() == null
				&& formPersonasKardex.getTxtEdad().getText().isEmpty())
		{
			JOptionPane.showMessageDialog(formPersonasKardex, "Debe ingresar la Edad o la Fecha de Nacimiento", "Kardex", JOptionPane.WARNING_MESSAGE);
			formPersonasKardex.getTabbedPane().setSelectedComponent(formPersonasKardex.getPnlDatosNacimiento());
			formPersonasKardex.getDateFechaNac().grabFocus();
			return false;
		}
		if(formPersonasKardex.getcBoxPais().getSelectedIndex() < 0)
		{
			JOptionPane.showMessageDialog(formPersonasKardex, "No ha seleccionado el Pais de procedencia", "Kardex", JOptionPane.WARNING_MESSAGE);
			formPersonasKardex.getTabbedPane().setSelectedComponent(formPersonasKardex.getPnlDatosNacimiento());
			formPersonasKardex.getcBoxPais().grabFocus();
			return false;
		}
		if(formPersonasKardex.getcBoxDepartamento().getSelectedIndex() < 0)
		{
			JOptionPane.showMessageDialog(formPersonasKardex, "No ha seleccionado el departamento de procedencia", "Kardex", JOptionPane.WARNING_MESSAGE);
			formPersonasKardex.getTabbedPane().setSelectedComponent(formPersonasKardex.getPnlDatosNacimiento());
			formPersonasKardex.getcBoxDepartamento().grabFocus();
			return false;
		}
		if(formPersonasKardex.getcBoxProvincia().getSelectedIndex() < 0)
		{
			JOptionPane.showMessageDialog(formPersonasKardex, "No ha seleccionado la provincia de procedencia", "Kardex", JOptionPane.WARNING_MESSAGE);
			formPersonasKardex.getTabbedPane().setSelectedComponent(formPersonasKardex.getPnlDatosNacimiento());
			formPersonasKardex.getcBoxProvincia().grabFocus();
			return false;
		}
		if(formPersonasKardex.getcBoxLugar().getSelectedIndex() < 0)
		{
			JOptionPane.showMessageDialog(formPersonasKardex, "No ha seleccionado el lugar de procedencia", "Kardex", JOptionPane.WARNING_MESSAGE);
			formPersonasKardex.getTabbedPane().setSelectedComponent(formPersonasKardex.getPnlDatosNacimiento());
			formPersonasKardex.getcBoxLugar().grabFocus();
			return false;
		}
		return true;
	}
	
	public void limpiarControlesDatosNacimiento()
	{
		formPersonasKardex.getDateFechaNac().setDate(null);
		formPersonasKardex.getTxtEdad().setText("");
		formPersonasKardex.getcBoxPais().setSelectedIndex(-1);
		formPersonasKardex.getcBoxDepartamento().setSelectedIndex(-1);
		formPersonasKardex.getcBoxProvincia().setSelectedIndex(-1);
		formPersonasKardex.getcBoxLugar().setSelectedIndex(-1);
	}
	
	public void habilitarBotones(boolean nuevo, boolean cancelar, boolean aceptar, boolean eliminar, boolean modificar, boolean reporte)
	{
		formPersonasKardex.getBtnNuevo().setEnabled(nuevo);
		formPersonasKardex.getBtnCancelar().setEnabled(cancelar);
		formPersonasKardex.getBtnAceptar().setEnabled(aceptar);
		formPersonasKardex.getBtnEliminar().setEnabled(eliminar);
		formPersonasKardex.getBtnModificar().setEnabled(modificar);
		formPersonasKardex.getBtnReporte().setEnabled(reporte);
		
		//agregar para los reportes
	}
	
	public void onFormShown() {	
		
		formPersonasKardex.getTxtEdad().setEditable(false);
		formPersonasKardex.getPnlPersonales().habilitarControles(false);
		habilitarControlesDatosNacimiento(false);
		habilitarControlesKardex(false);
		habilitarBotones(true, false, false, false, false, false);
		
		formPersonasKardex.getBtnNuevoDoc().setEnabled(false);
		formPersonasKardex.getBtnEliminarDoc().setEnabled(false);
		formPersonasKardex.getBtnModificarDoc().setEnabled(false);
		formPersonasKardex.getBtnNuevoFamiliar().setEnabled(false);
		formPersonasKardex.getBtnEliminarFamiliar().setEnabled(false);
		formPersonasKardex.getBtnModificarFamiliar().setEnabled(false);
		
		formPersonasKardex.getTableDocumentos().setModel(modeloDocumento);
		formPersonasKardex.getTableFamiliares().setModel(modeloFamiliares);
		formPersonasKardex.getTablePersonas().setModel(modeloPersona);
		formPersonasKardex.getTablePersonas().getSelectionModel().addListSelectionListener(this);
		
//		for (Empleo empleo : daoEmpleo.selectByExample(null)) {
//			formPersonasKardex.getPnlPersonales().getcBoxEmpleo().addItem(empleo);
//		}
		formPersonasKardex.getPnlPersonales().getcBoxEmpleo().setSelectedIndex(-1);
		
		for (Institucion institucion : daoInstitucion.selectByExample(null)) {
			formPersonasKardex.getcBoxInstitucion().addItem(institucion);
		}
		formPersonasKardex.getcBoxInstitucion().setSelectedIndex(-1);
		
		for (Pais paises : daoPais.selectByExample(null)) {
			formPersonasKardex.getcBoxPais().addItem(paises);			
		}
		formPersonasKardex.getcBoxPais().setSelectedIndex(-1);
		
		formPersonasKardex.getBtnNuevo().addActionListener(this);
		formPersonasKardex.getBtnCancelar().addActionListener(this);
		formPersonasKardex.getBtnAceptar().addActionListener(this);
		formPersonasKardex.getBtnEliminar().addActionListener(this);
		formPersonasKardex.getBtnModificar().addActionListener(this);
		formPersonasKardex.getBtnAgregarInst().addActionListener(this);
		formPersonasKardex.getBtnAgregarTrabSocial().addActionListener(this);
		formPersonasKardex.getBtnBuscarPersonaEgreso().addActionListener(this);
		formPersonasKardex.getBtnBuscarPersonaIngreso().addActionListener(this);
		formPersonasKardex.getBtnNuevoDoc().addActionListener(this);
		formPersonasKardex.getBtnEliminarDoc().addActionListener(this);
		formPersonasKardex.getBtnModificarDoc().addActionListener(this);
		formPersonasKardex.getBtnNuevoFamiliar().addActionListener(this);
		formPersonasKardex.getBtnEliminarFamiliar().addActionListener(this);
		formPersonasKardex.getBtnModificarFamiliar().addActionListener(this);
		formPersonasKardex.getBtnCerrar().addActionListener(this);
		formPersonasKardex.getBtnReporte().addActionListener(this);
		formPersonasKardex.getBtnBuscar().addActionListener(this);
		formPersonasKardex.getTxtBusqueda().addActionListener(this);
		formPersonasKardex.getcBoxPais().addActionListener(this);
		formPersonasKardex.getcBoxDepartamento().addActionListener(this);
		formPersonasKardex.getcBoxProvincia().addActionListener(this);
		formPersonasKardex.getDateFechaNac().getDateEditor().addPropertyChangeListener(this);
		formPersonasKardex.getBtnAgregarPersonaIngreso().addActionListener(this);
		formPersonasKardex.getBtnAgregarPersonaEgreso().addActionListener(this);
		formPersonasKardex.getTxtEdad().addKeyListener(this);
		formPersonasKardex.getTxtNroKardex().addKeyListener(this);
		
		formPersonasKardex.getPnlPersonales().getTxtDIPersonal().addKeyListener(this);
		formPersonasKardex.getPnlPersonales().getTxtCelular() .addKeyListener(this);
		formPersonasKardex.getPnlPersonales().getTxtTelefono().addKeyListener(this);
		formPersonasKardex.getTablePersonas().addMouseListener(this);
		
		FormUtilities.centrar(formPersonasKardex);
		
		//2/
		PersonaExample filtroTrab = new PersonaExample();
		filtroTrab.or().andCodigoEmpleoEqualTo(2);
		for (Persona trabajadora : daoPersonaMapper.selectByExample(filtroTrab)) {
			formPersonasKardex.getcBoxTrabajadoraSocial().addItem(trabajadora);
		}
		
		formPersonasKardex.getTxtBusqueda().getDocument().addDocumentListener(this);
		
		formPersonasKardex.getPnlPersonales().habilitarSoloParaNinos();
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		if(e.getSource().equals(formPersonasKardex.getDateFechaNac().getCalendarButton())){
//			System.out.println("Fecha cambiada"  + formPersonasKardex.getDateFechaNac().getDate());
//		}
		
		if(e.getActionCommand().compareTo("Buscar")==0)
		{
			if(formPersonasKardex.getTxtBusqueda().getText().isEmpty())
			{
				JOptionPane.showMessageDialog(formPersonasKardex, "A\u00FAn no ha ingresado un texto", "Kardex", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			PersonaExample personaAux = new PersonaExample();
			personaAux.or().andNombresLike("%"+ formPersonasKardex.getTxtBusqueda().getText() + "%").andCodigoTipoPersonaEqualTo("N");
			personaAux.or().andPaternoLike("%"+ formPersonasKardex.getTxtBusqueda().getText() + "%").andCodigoTipoPersonaEqualTo("N");
			personaAux.or().andMaternoLike("%"+ formPersonasKardex.getTxtBusqueda().getText() + "%").andCodigoTipoPersonaEqualTo("N");
//			personaAux.createCriteria().andCodigoTipoPersonaEqualTo("N");
			
			modeloPersona.setListPersona(daoPersonaMapper.selectByExample(personaAux));
			
//			formPersonasKardex.getTxtBusqueda().grabFocus();
//			formPersonasKardex.getTxtBusqueda().selectAll();
			
		}
	
		
		if(e.getSource().equals(formPersonasKardex.getBtnNuevoDoc()))
		{
			FDocumentos formDocumentos =new FDocumentos(null);
			formDocumentos.control.mostrarParaInsercionListado(null, false);
			formDocumentos.setVisible(true);
			if(formDocumentos.control.documentoActual != null && formDocumentos.control.documentoActual.getNombreDocumento()!= null
					&& !modeloDocumento.existe(formDocumentos.control.documentoActual))
			{
				
				modeloDocumento.AnadirDocumento(formDocumentos.control.documentoActual);
				formPersonasKardex.getTabbedPane().setSelectedComponent(formPersonasKardex.getPnlDoc_Familiares());
			}
			else
			{
				JOptionPane.showMessageDialog(formPersonasKardex, "No ha ingresado ning\u00FAn elemento o el Elemento seleccionado ya se encuentra en la lista", "Kardex de Personas", JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if(e.getSource().equals(formPersonasKardex.getBtnModificarDoc()))
		{
			FDocumentos formDocumentos =new FDocumentos(null);
			formDocumentos.control.mostrarParaInsercionListado(null, true);
			formDocumentos.setVisible(true);
			if(formDocumentos.control.documentoActual != null 
					&& !modeloDocumento.existe(formDocumentos.control.documentoActual))
			{
				
				modeloDocumento.AnadirDocumento(formDocumentos.control.documentoActual);
				formPersonasKardex.getTabbedPane().setSelectedComponent(formPersonasKardex.getPnlDoc_Familiares());
			}
			else
			{
				JOptionPane.showMessageDialog(formPersonasKardex, "No ha seleccionado ning\u00FAn elemento o el Elemento seleccionado ya se encuentra en la lista", "Kardex de Personas", JOptionPane.WARNING_MESSAGE);
			}
		}
		
		
		if(e.getSource().equals(formPersonasKardex.getBtnNuevoFamiliar()))
		{
			FFamiliar formfamiliares =new FFamiliar(null);
//			formfamiliares.control.mostrarParaInsercionListado(null, true);
			formfamiliares.setVisible(true);
			if(formfamiliares.personaActual != null && !formfamiliares.personaActual.getNombres().isEmpty()
					&& !modeloFamiliares.existe(formfamiliares.personaKardexFamiliar))
			{
//				System.out.println("ingresa");
				formfamiliares.personaKardexFamiliar.setFechaRegistro(Calendar.getInstance().getTime());
				formfamiliares.personaKardexFamiliar.setObservaciones(formfamiliares.getPnlPersonas().getTxtObservaciones().getText());
				modeloFamiliares.AnadirPersonaKardexFamiliar( formfamiliares.personaKardexFamiliar);
				formPersonasKardex.getTabbedPane().setSelectedComponent(formPersonasKardex.getPnlDoc_Familiares());
			}
			else
			{
				JOptionPane.showMessageDialog(formPersonasKardex, "No ha seleccionado ning\u00FAn elemento o el Elemento seleccionado ya se encuentra en la lista", "Kardex de Personas", JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if(e.getSource().equals(formPersonasKardex.getBtnModificarFamiliar()))
		{
			FPersonasBuscador formfamiliares =new FPersonasBuscador(null);
//			formfamiliares.control.mostrarParaInsercionListado(null, true);
			formfamiliares.setVisible(true);
			if(formfamiliares.control.personaActual != null)
			{
				PersonaKardexFamiliar aux = new PersonaKardexFamiliar();
				aux.setPersona(formfamiliares.control.personaActual);
				
				Parentesco parentescoSelecionado = (Parentesco) JOptionPane.showInputDialog(formPersonasKardex, "Seleccione el Parentesco de la Persona", "Kardex", JOptionPane.INFORMATION_MESSAGE, null, daoParentesco.selectByExample(null).toArray(), null);
				if(!modeloFamiliares.existe(aux) && parentescoSelecionado != null)
				{
					aux.setParentesco(parentescoSelecionado);
					aux.setFechaRegistro(Calendar.getInstance().getTime());
					modeloFamiliares.AnadirPersonaKardexFamiliar( aux);
					formPersonasKardex.getTabbedPane().setSelectedComponent(formPersonasKardex.getPnlDoc_Familiares());
				}
				else
				{
					JOptionPane.showMessageDialog(formPersonasKardex, "No ha seleccionado ning\u00FAn Parentesco o el Elemento seleccionado ya se encuentra en la lista", "Kardex de Personas", JOptionPane.WARNING_MESSAGE);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(formPersonasKardex, "No ha seleccionado ning\u00FAn elemento o el Elemento seleccionado ya se encuentra en la lista", "Kardex de Personas", JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if(e.getSource().equals(formPersonasKardex.getBtnEliminarDoc()))
		{
			if(formPersonasKardex.getTableDocumentos().getSelectedRow() >= 0)
			{
				if(JOptionPane.showConfirmDialog(formPersonasKardex, "¿Se encuentra seguro de Eliminar el registro actual?", "Kardex de Personas", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
					modeloDocumento.eliminarDocumento(formPersonasKardex.getTableDocumentos().getSelectedRow());
			}
			else
			{
				JOptionPane.showMessageDialog(formPersonasKardex, "No ha seleccionado ning\u00FAn elemento", "Kardex de Personas", JOptionPane.WARNING_MESSAGE);
			}
//			if(JOptionPane.showConfirmDialog(formPersonasKardex, "¿Se encuentra seguro de Eliminar el registro actual?", "Kardex de Personas", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION 
//					&& formPersonasKardex.getTableDocumentos().getSelectedRow() >= 0)
//			{
//				modeloDocumento.eliminarDocumento(formPersonasKardex.getTableDocumentos().getSelectedRow());
//			}
//			else
//			{
//				JOptionPane.showMessageDialog(formPersonasKardex, "No ha seleccionado ning\u00FAn elemento", "Kardex de Personas", JOptionPane.WARNING_MESSAGE);
//			}
		}
		
		if(e.getSource().equals(formPersonasKardex.getBtnEliminarFamiliar()))
		{
			if(formPersonasKardex.getTableFamiliares().getSelectedRow() >= 0)
			{
				if(JOptionPane.showConfirmDialog(formPersonasKardex, "¿Se encuentra seguro de Eliminar el registro actual?", "Kardex de Personas", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
					modeloFamiliares.eliminarPersonaKardexFamiliar(formPersonasKardex.getTableFamiliares().getSelectedRow());
			}
			else
			{
				JOptionPane.showMessageDialog(formPersonasKardex, "No ha seleccionado ning\u00FAn elemento", "Kardex de Personas", JOptionPane.WARNING_MESSAGE);			
			}
//			if(JOptionPane.showConfirmDialog(formPersonasKardex, "¿Se encuentra seguro de Eliminar el registro actual?", "Kardex de Personas", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION 
//					&& formPersonasKardex.getTableFamiliares().getSelectedRow() >= 0)
//			{
//				modeloFamiliares.eliminarPersonaKardexFamiliar(formPersonasKardex.getTableFamiliares().getSelectedRow());
//			}
//			else
//			{
//				JOptionPane.showMessageDialog(formPersonasKardex, "No ha seleccionado ning\u00FAn elemento", "Kardex de Personas", JOptionPane.WARNING_MESSAGE);
//			}
		}
		
		if(e.getSource().equals(formPersonasKardex.getBtnAgregarInst()))
		{
			FInstituciones formInstituciones = new FInstituciones(null);
			formInstituciones.setVisible(true);
			if(formInstituciones.control.institucionActual != null)
			{
				formPersonasKardex.getcBoxInstitucion().addItem(formInstituciones.control.institucionActual);
				formPersonasKardex.getcBoxInstitucion().setSelectedItem(formInstituciones.control.institucionActual);
			}
		}
		
		if(e.getSource().equals(formPersonasKardex.getBtnBuscarPersonaEgreso()))
		{
			FPersonasBuscador formBuscador = new FPersonasBuscador(null);
			formBuscador.setVisible(true);
			if(formBuscador.control.personaActual != null)
			{
				formPersonasKardex.getTxtPersonaEgreso().setText(formBuscador.control.personaActual.obtenerNombreCompleto());
				formPersonasKardex.getTxtPersonaEgreso().setToolTipText(String.valueOf(formBuscador.control.personaActual.getCodigoPersona()));
			}
			else
			{
				formPersonasKardex.getTxtPersonaEgreso().setText("");
				formPersonasKardex.getTxtPersonaEgreso().setToolTipText("");
			}
		}
		
		if(e.getSource().equals(formPersonasKardex.getBtnBuscarPersonaIngreso()))
		{
			FPersonasBuscador formBuscador = new FPersonasBuscador(null);
			formBuscador.setVisible(true);
			if(formBuscador.control.personaActual != null
					&& formBuscador.control.personaActual.obtenerNombreCompleto() != null)
			{
				formPersonasKardex.getTxtPresonaIngreso().setText(formBuscador.control.personaActual.obtenerNombreCompleto());
				formPersonasKardex.getTxtPresonaIngreso().setToolTipText(String.valueOf(formBuscador.control.personaActual.getCodigoPersona()));
			}
			else
			{
				formPersonasKardex.getTxtPresonaIngreso().setText("");
				formPersonasKardex.getTxtPresonaIngreso().setToolTipText("");
			}
		}
		
		if(e.getSource().equals(formPersonasKardex.getBtnAgregarPersonaEgreso()))
		{
			FFamiliar formFamiliar = new FFamiliar(null);
			formFamiliar.HabilitarRegistroPersonas();
			formFamiliar.setVisible(true);
			if(formFamiliar.personaActual != null
					&& formFamiliar.personaActual.obtenerNombreCompleto()!= null)
			{
				formPersonasKardex.getTxtPersonaEgreso().setText(formFamiliar.personaActual.obtenerNombreCompleto());
				formPersonasKardex.getTxtPersonaEgreso().setToolTipText(String.valueOf(formFamiliar.personaActual.getCodigoPersona()));
			}
			
			else
			{
				formPersonasKardex.getTxtPersonaEgreso().setText("");
				formPersonasKardex.getTxtPersonaEgreso().setToolTipText("");
			}
		}
		if(e.getSource().equals(formPersonasKardex.getBtnAgregarPersonaIngreso()))
		{
			FFamiliar formFamiliar = new FFamiliar(null);
			formFamiliar.HabilitarRegistroPersonas();
			formFamiliar.setVisible(true);
			if(formFamiliar.personaActual != null)
			{
				formPersonasKardex.getTxtPresonaIngreso().setText(formFamiliar.personaActual.obtenerNombreCompleto());
				formPersonasKardex.getTxtPresonaIngreso().setToolTipText(String.valueOf(formFamiliar.personaActual.getCodigoPersona()));
			}
			
			else
			{
				formPersonasKardex.getTxtPresonaIngreso().setText("");
				formPersonasKardex.getTxtPresonaIngreso().setToolTipText("");
			}
		}
		
		if(e.getActionCommand().compareTo("Cancelar") == 0)
		{
			formPersonasKardex.getPnlPersonales().limpiarControles();
			formPersonasKardex.getPnlPersonales().habilitarControles(false);
			habilitarControlesDatosNacimiento(false);
			habilitarControlesKardex(false);
			limpiarControlesDatosNacimiento();
			limpiarControlesKardex();
			tipoOperacion = "";
			formPersonasKardex.getTabbedPane().setSelectedComponent(formPersonasKardex.getPnlPersonales());
			formPersonasKardex.getTxtBusqueda().setEditable(true);
			formPersonasKardex.getBtnBuscar().setEnabled(true);
			habilitarBotones(true, false, false, false, false, false);
			modeloDocumento.clear();
			
			formPersonasKardex.getBtnNuevoDoc().setEnabled(false);
			formPersonasKardex.getBtnNuevoFamiliar().setEnabled(false);
			formPersonasKardex.getBtnModificarDoc().setEnabled(false);
			formPersonasKardex.getBtnModificarFamiliar().setEnabled(false);
			formPersonasKardex.getBtnEliminarDoc().setEnabled(false);
			formPersonasKardex.getBtnEliminarFamiliar().setEnabled(false);
		}
		if(e.getActionCommand().compareTo("Nuevo") == 0)
		{
			formPersonasKardex.getPnlPersonales().limpiarControles();
			formPersonasKardex.getPnlPersonales().habilitarControles(true);
			habilitarControlesDatosNacimiento(true);
			habilitarControlesKardex(true);
			limpiarControlesDatosNacimiento();
			limpiarControlesKardex();
			tipoOperacion = "I";
			formPersonasKardex.getTabbedPane().setSelectedComponent(formPersonasKardex.getPnlPersonales());
			formPersonasKardex.getPnlPersonales().getTxtDIPersonal(). grabFocus();
			
			formPersonasKardex.getTxtBusqueda().setEditable(false);
			formPersonasKardex.getBtnBuscar().setEnabled(false);
			
			habilitarBotones(false, true, true, false, false, false);
			

			personaDatosNacActual = new PersonaDatosNacimiento();
			personaKardexActual = new PersonaKardex();
			personaActual = new Persona();
			
			
			formPersonasKardex.getBtnNuevoDoc().setEnabled(true);
			formPersonasKardex.getBtnNuevoFamiliar().setEnabled(true);
			formPersonasKardex.getBtnModificarDoc().setEnabled(true);
			formPersonasKardex.getBtnModificarFamiliar().setEnabled(true);
			formPersonasKardex.getBtnEliminarDoc().setEnabled(true);
			formPersonasKardex.getBtnEliminarFamiliar().setEnabled(true);
			
			
			formPersonasKardex.getPnlPersonales().getcBoxEstadoCivil().setSelectedItem("SOLTERO(A)");
			formPersonasKardex.getPnlPersonales().getcBoxGradoInstruccion().setSelectedIndex(0);
		}
		
		if(e.getActionCommand().compareTo("Eliminar") == 0)
		{
			if(JOptionPane.showConfirmDialog(formPersonasKardex, "¿Se encuentra seguro de eliminar el registro actual?. Tome en cuenta que se eliminar\u00E1n todas sus dependencias.", "Kardex de Personas", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION
					&& personaActual != null)
			{
				Savepoint savePointA = null;
				
				try {
					
					savePointA = session.getConnection().setSavepoint();
					
					daoPersonaMapper.deleteByPrimaryKey(personaActual.getCodigoPersona());
					limpiarControlesKardex();
					limpiarControlesDatosNacimiento();
					formPersonasKardex.getPnlPersonales().limpiarControles();
					habilitarBotones(true, false, false, false, false, false);
					personaActual = null;
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println(e1);
//					e1.printStackTrace();
					JOptionPane.showMessageDialog(formPersonasKardex, "No se puede eliminar el registro ya que debe estar siendo utilizado en otra actividad o proceso",  "Kardex de Personas", JOptionPane.ERROR_MESSAGE);
					try {
						session.getConnection().rollback(savePointA);
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}
				
			}
		}
		if(e.getActionCommand().compareTo("Modificar") == 0)
		{
			habilitarBotones(false, true, true, false, false, false);
			habilitarControlesDatosNacimiento(true);
			habilitarControlesKardex(true);
			formPersonasKardex.getPnlPersonales().habilitarControles(true);
			formPersonasKardex.getTxtBusqueda().setEditable(false);
			formPersonasKardex.getBtnBuscar().setEnabled(false);
			tipoOperacion = "E";
			
			formPersonasKardex.getBtnNuevoDoc().setEnabled(true);
			formPersonasKardex.getBtnNuevoFamiliar().setEnabled(true);
			formPersonasKardex.getBtnModificarDoc().setEnabled(true);
			formPersonasKardex.getBtnModificarFamiliar().setEnabled(true);
			formPersonasKardex.getBtnEliminarDoc().setEnabled(true);
			formPersonasKardex.getBtnEliminarFamiliar().setEnabled(true);
		}
		if(e.getActionCommand().compareTo("Aceptar") == 0)
		{
			String datosValidacion = formPersonasKardex.getPnlPersonales().validarCampos();
			if(datosValidacion != null && !datosValidacion.isEmpty())
			{
				JOptionPane.showMessageDialog(formPersonasKardex, datosValidacion, "Datos Personales", JOptionPane.ERROR_MESSAGE);
				formPersonasKardex.getTabbedPane().setSelectedComponent(formPersonasKardex.getPnlPersonales());
				return;
			}
			if(validarDatosKardex() && validarDatosNacimiento())
			{
				try {
					personaActual = formPersonasKardex.getPnlPersonales().obtenerPersona();
					personaActual.setCodigoTipoPersona("N");
					
					personaDatosNacActual.setFechaNacimiento(formPersonasKardex.getDateFechaNac().getDate());
					personaDatosNacActual.setEdad(Integer.parseInt(formPersonasKardex.getTxtEdad().getText()));
					if(formPersonasKardex.getcBoxPais().getSelectedIndex()!= -1)
					{
						personaDatosNacActual.setCodigoPaisn(((Pais)formPersonasKardex.getcBoxPais().getSelectedItem()).getCodigoPais() );						
					}
					else
						personaDatosNacActual.setCodigoPaisn(null);
					
					if(formPersonasKardex.getcBoxDepartamento().getSelectedIndex()!= -1)
						personaDatosNacActual.setCodigoDepartamenton(((Departamento)formPersonasKardex.getcBoxDepartamento().getSelectedItem()).getCodigoDepartamento());
					else
						personaDatosNacActual.setCodigoDepartamenton(null);
					
					if(formPersonasKardex.getcBoxProvincia().getSelectedIndex()!= -1)
						personaDatosNacActual.setCodigoProvincian(((Provincia)formPersonasKardex.getcBoxProvincia().getSelectedItem()).getCodigoProvincia());
					else
						personaDatosNacActual.setCodigoProvincian(null);
					
					if(formPersonasKardex.getcBoxLugar().getSelectedIndex()!= -1)
						personaDatosNacActual.setCodigoLugarn(((Lugar)formPersonasKardex.getcBoxLugar().getSelectedItem()).getCodigoLugar());
					else
						personaDatosNacActual.setCodigoLugarn(null);
					
					personaKardexActual.setNumeroKardex(Integer.parseInt(formPersonasKardex.getTxtNroKardex().getText()));
					personaKardexActual.setNombreKardex(formPersonasKardex.getTxtNombreKardex().getText().trim());
					personaKardexActual.setFechaIngreso(formPersonasKardex.getDateFechaIngreso().getDate());
					personaKardexActual.setCentro(formPersonasKardex.getcBoxInstitucion().getSelectedItem().toString());
					personaKardexActual.setCodigoInstitucion(((Institucion) formPersonasKardex.getcBoxInstitucion().getSelectedItem()).getCodigoInstitucion());
					personaKardexActual.setMotivoEgreso(formPersonasKardex.getTxtMotivoEgreso().getText().trim());
					personaKardexActual.setMotivoIngreso(formPersonasKardex.getTxtMotivoIngreso().getText().trim());
					personaKardexActual.setCodigoUsuario(codigoUsuario);
					
//				System.out.println("Persona Ingreso " + formPersonasKardex.getTxtPresonaIngreso().getToolTipText());
					if(formPersonasKardex.getTxtPresonaIngreso().getToolTipText() != null
							&& formPersonasKardex.getTxtPresonaIngreso().getToolTipText().compareTo("null")!=0)
						personaKardexActual.setCodigoPersona(Integer.parseInt(formPersonasKardex.getTxtPresonaIngreso().getToolTipText()));
//				
//					System.out.println("Persona Egreso " + formPersonasKardex.getTxtPersonaEgreso().getToolTipText());						
					if(formPersonasKardex.getTxtPersonaEgreso().getToolTipText() != null
							&& formPersonasKardex.getTxtPersonaEgreso().getToolTipText().compareTo("null")!=0)
						personaKardexActual.setCodigoPersonaEgreso(Integer.parseInt(formPersonasKardex.getTxtPersonaEgreso().getToolTipText()));
					
					
					if(formPersonasKardex.getcBoxTrabajadoraSocial().getSelectedIndex() != -1)
						personaKardexActual.setCodigoPersonaTrabSocial(((Persona)formPersonasKardex.getcBoxTrabajadoraSocial().getSelectedItem() ).getCodigoPersona() );
					personaKardexActual.setCodigoEstado("A");
					
					if(tipoOperacion.compareTo("I") == 0)
					{
						daoPersonaMapper.insert(personaActual);
						session.commit();
						
						Map<String, Integer> mapa = new HashMap<String, Integer>();
						mapa.put("ultimoId", 0);
						daoPersonaMapper.obtenerUltimoId(mapa); //("myMappedStatement",myParams);
						personaActual.setCodigoPersona( mapa.get("ultimoId"));
						
						personaDatosNacActual.setCodigoPersona(personaActual.getCodigoPersona());
						personaKardexActual.setCodigoPersona(personaActual.getCodigoPersona());
						
						daoPersonaDatosNacimiento.insert(personaDatosNacActual);
						daoPersonaKardexMapper.insert(personaKardexActual);
						session.commit();
						
						daoPersonaKardexMapper.obtenerUltimoId(mapa);
						personaKardexActual.setCodigoKardex(mapa.get("ultimoId"));
												
						for (Documento docNuevo : modeloDocumento.getListaDocumento()) {
							PersonaKardexDocumento record = new PersonaKardexDocumento();
							record.setCodigoDocumento(docNuevo.getCodigoDocumento());
							record.setCodigoKardex(personaKardexActual.getCodigoKardex());
							record.setTramitoTrabSocial("N");
							daoPersonaKardexDocumento.insert(record);
						}
						
						for (PersonaKardexFamiliar familiar : modeloFamiliares.getListaPersonaKardexFamiliar()) {
							familiar.setCodigoKardex(personaKardexActual.getCodigoKardex());
							familiar.setCodigoParentesco(familiar.getParentesco().getCodigoParentesco());
							familiar.setCodigoPersona(personaActual.getCodigoPersona());
							familiar.setObservaciones("Ninguna");
							daoPersonaKardexFamiliar.insert(familiar);
							
						}
						session.commit();
					}
					else
					{
						personaActual.setCodigoPersona(personaKardexActual.getCodigoPersona());						
						daoPersonaMapper.updateByPrimaryKey(personaActual);
						daoPersonaDatosNacimiento.updateByPrimaryKey(personaDatosNacActual);
						daoPersonaKardexMapper.updateByPrimaryKey(personaKardexActual);
						
						PersonaKardexDocumentoExample filtroDocumento = new PersonaKardexDocumentoExample();
						filtroDocumento.or().andCodigoKardexEqualTo(personaKardexActual.getCodigoKardex());
						daoPersonaKardexDocumento.deleteByExample(filtroDocumento);		
						session.commit();
						for (Documento docNuevo : modeloDocumento.getListaDocumento()) {							
							
							PersonaKardexDocumento record = new PersonaKardexDocumento();
							record.setCodigoDocumento(docNuevo.getCodigoDocumento());
							record.setCodigoKardex(personaKardexActual.getCodigoKardex());
							record.setTramitoTrabSocial("N");
							daoPersonaKardexDocumento.insert(record);
						}
						
						
						PersonaKardexFamiliarExample filtroFamiliar = new  PersonaKardexFamiliarExample();
						filtroFamiliar.or().andCodigoKardexEqualTo(personaKardexActual.getCodigoKardex());
						session.commit();
						daoPersonaKardexFamiliar.deleteByExample(filtroFamiliar);
						for (PersonaKardexFamiliar familiar : modeloFamiliares.getListaPersonaKardexFamiliar()) {
							familiar.setCodigoKardex(personaKardexActual.getCodigoKardex());
							familiar.setCodigoParentesco(familiar.getParentesco().getCodigoParentesco());
							familiar.setCodigoPersona(personaActual.getCodigoPersona());
							familiar.setObservaciones("Ninguna");
							daoPersonaKardexFamiliar.insert(familiar);
							
						}
						session.commit();
						
						
					}
					tipoOperacion = "";
					formPersonasKardex.getTabbedPane().setSelectedComponent(formPersonasKardex.getPnlPersonales());
					formPersonasKardex.getTxtBusqueda().setEditable(true);
					formPersonasKardex.getBtnBuscar().setEnabled(true);
					habilitarBotones(true, false, false, true, true, true);				
					formPersonasKardex.getPnlPersonales().habilitarControles(false);
					habilitarControlesDatosNacimiento(false);
					habilitarControlesKardex(false);
					JOptionPane.showMessageDialog(formPersonasKardex, "Registro almacenado correctamente", "Kardex Personal", JOptionPane.INFORMATION_MESSAGE);
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(formPersonasKardex, "Ocurri\u00F3 la siguiente excepcion " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(formPersonasKardex, "Ocurri\u00F3 la siguiente excepcion " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
		if(e.getActionCommand().compareTo("Cerrar") == 0)
		{
			formPersonasKardex.setVisible(false);
			formPersonasKardex.dispose();
		}
		
		if(e.getActionCommand().compareTo("Reporte") == 0)
		{
			String path = rutaLocal + "org/quarkbit/trabajosocialsanjuan/reportes/";
//			path = path.replace("/", "\\\\");
			System.out.println(path);
			
			GeneraReport gr = new GeneraReport();			
			gr.loadReportJasper(path + "obtener_ficha_kardex2.jasper");
			gr.setParameters("codigo_kardex_aux",personaKardexActual.getCodigoKardex());			
			gr.setParameters("SUBREPORT_DIR", path);
			gr.fillReport(session.getConnection());			
			gr.previewReportModal();
		}
		
		
		
		if(e.getSource().equals(formPersonasKardex.getcBoxPais()) && formPersonasKardex.getcBoxPais().getSelectedItem() != null)
		{
			paisActual.setCodigoPais(((Pais )formPersonasKardex.getcBoxPais().getSelectedItem()).getCodigoPais());
			DepartamentoExample filtro = new DepartamentoExample();
			filtro.createCriteria().andCodigoPaisEqualTo(paisActual.getCodigoPais());
			formPersonasKardex.getcBoxDepartamento().removeAllItems();
			
			for (Departamento departamentoAux : daoDempartamento.selectByExample(filtro)) {
				formPersonasKardex.getcBoxDepartamento().addItem(departamentoAux);
			} 

		}
		if(e.getSource().equals(formPersonasKardex.getcBoxDepartamento()) && formPersonasKardex.getcBoxDepartamento().getSelectedItem() != null)
		{
			departamentoActual.setCodigoDepartamento( ((Departamento )formPersonasKardex.getcBoxDepartamento().getSelectedItem()).getCodigoDepartamento());
			ProvinciaExample filtro = new ProvinciaExample();
			filtro.createCriteria().andCodigoDepartamentoEqualTo( departamentoActual.getCodigoDepartamento()).andCodigoPaisEqualTo(paisActual.getCodigoPais());
			
			formPersonasKardex.getcBoxProvincia().removeAllItems();
			for (Provincia provinciaAux : daoProvincia.selectByExample(filtro)) {
				formPersonasKardex.getcBoxProvincia().addItem(provinciaAux);
			} 

		}
		if(e.getSource().equals(formPersonasKardex.getcBoxProvincia()) && formPersonasKardex.getcBoxProvincia().getSelectedItem() != null)
		{
			provinciaActual.setCodigoProvincia( ((Provincia )formPersonasKardex.getcBoxProvincia().getSelectedItem()).getCodigoProvincia());
			LugarExample filtro = new LugarExample();
			filtro.createCriteria().andCodigoProvinciaEqualTo( provinciaActual.getCodigoProvincia()).andCodigoDepartamentoEqualTo(departamentoActual.getCodigoDepartamento()).andCodigoPaisEqualTo(paisActual.getCodigoPais());
			
			formPersonasKardex.getcBoxLugar().removeAllItems();
			for (Lugar lugarAux : daoLugar.selectByExample(filtro)) {
				formPersonasKardex.getcBoxLugar().addItem(lugarAux);
			} 
		}
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if(e.getValueIsAdjusting())
			return;
		int indice = ((ListSelectionModel) e.getSource()).getMinSelectionIndex();
//		System.out.println("indice = " + indice);
		cargarDatosPersona(modeloPersona.obtenerPersona(indice)); 
	}
	
	private void cargarDatosPersona(Persona personaDatos) {
		// TODO Auto-generated method stub
		if(personaDatos != null)
		{
			System.out.println(personaDatos.getCodigoPersona());
			formPersonasKardex.getPnlPersonales().cargarDatosPersona(personaDatos);
			PersonaKardexExample filtro = new PersonaKardexExample();
			filtro.or().andCodigoPersonaEqualTo(personaDatos.getCodigoPersona());
			personaActual = personaDatos;
			if(daoPersonaKardexMapper.selectByExample(filtro).size() > 0)
			{
				personaKardexActual = daoPersonaKardexMapper.selectByExample(filtro).get(0);
				
				formPersonasKardex.getTxtNroKardex().setText(String.valueOf(personaKardexActual.getNumeroKardex()));
				formPersonasKardex.getTxtNombreKardex().setText(personaKardexActual.getNombreKardex());
				formPersonasKardex.getDateFechaIngreso().setDate(personaKardexActual.getFechaIngreso());
				formPersonasKardex.getcBoxInstitucion().setSelectedItem(personaKardexActual.getInstitucion());
				formPersonasKardex.getcBoxTrabajadoraSocial().setSelectedItem(personaKardexActual.getTrabajadoraSosial());
				formPersonasKardex.getTxtMotivoEgreso().setText(personaKardexActual.getMotivoEgreso());
				formPersonasKardex.getTxtMotivoIngreso().setText(personaKardexActual.getMotivoIngreso());
				if(personaKardexActual.getPersonaEgreso()!= null)
					formPersonasKardex.getTxtPersonaEgreso().setText(personaKardexActual.getPersonaEgreso().obtenerNombreCompleto());
				else
					formPersonasKardex.getTxtPersonaEgreso().setText("");
				if(personaKardexActual.getPersonaIngreso() != null)
					formPersonasKardex.getTxtPresonaIngreso().setText(personaKardexActual.getPersonaIngreso().obtenerNombreCompleto());
				else
					formPersonasKardex.getTxtPresonaIngreso().setText("");
				
				formPersonasKardex.lblPresentacion.setText("Cod. Kardex: " + String.valueOf(personaKardexActual.getCodigoKardex())   +"   | Cod. Personal: " + String.valueOf(personaKardexActual.getCodigoPersona())   +"    | F. Reg.: " 
				+ (personaKardexActual.getFechaRegistro() != null ?  df.format(personaKardexActual.getFechaRegistro()) : ""));
			}
			personaDatosNacActual = daoPersonaDatosNacimiento.selectByPrimaryKey(personaDatos.getCodigoPersona());
			if(personaDatosNacActual != null)
			{
				formPersonasKardex.getDateFechaNac().setDate(personaDatosNacActual.getFechaNacimiento());
				formPersonasKardex.getTxtEdad().setText(String.valueOf(personaDatosNacActual.getEdad()));
				

				if(personaDatosNacActual.getCodigoPaisn() != null)
				{					
					formPersonasKardex.getcBoxPais().setSelectedItem(personaDatosNacActual.getPais());
				}
				else
				{
					formPersonasKardex.getcBoxPais().setSelectedIndex(-1);
				}
				if(personaDatosNacActual.getCodigoDepartamenton() != null)
				{
					formPersonasKardex.getcBoxDepartamento().setSelectedItem(personaDatosNacActual.getDepartamento());
				}
				else
				{
					formPersonasKardex.getcBoxDepartamento().setSelectedIndex(-1);
				}
				if(personaDatosNacActual.getCodigoProvincian() != null)
				{
					formPersonasKardex.getcBoxProvincia().setSelectedItem(personaDatosNacActual.getProvincia());
				}
				else
				{
					formPersonasKardex.getcBoxProvincia().setSelectedIndex(-1);
				}
				if(personaDatosNacActual.getCodigoLugarn() != null)
				{
					formPersonasKardex.getcBoxLugar().setSelectedItem(personaDatosNacActual.getLugar());
				}
				else
				{
					formPersonasKardex.getcBoxLugar().setSelectedIndex(-1);
				}
//				else
//				{
//					formPersonasKardex.getcBoxPais().setSelectedIndex(-1);
//					formPersonasKardex.getcBoxDepartamento().setSelectedIndex(-1);
//					formPersonasKardex.getcBoxProvincia().setSelectedIndex(-1);
//					formPersonasKardex.getcBoxLugar().setSelectedIndex(-1);
//				}
				
				
			}
			
			PersonaKardexDocumentoExample filtro2 = new PersonaKardexDocumentoExample();
			filtro2.or().andCodigoKardexEqualTo(personaKardexActual.getCodigoKardex());
			modeloDocumento.clear();
			for (PersonaKardexDocumento kardexDocumento : daoPersonaKardexDocumento.selectByExample(filtro2)) {
				
				modeloDocumento.AnadirDocumento(kardexDocumento.getDocumento());
			}
			
			PersonaKardexFamiliarExample filtro3 = new PersonaKardexFamiliarExample();
			filtro3.or().andCodigoKardexEqualTo(personaKardexActual.getCodigoKardex());
			modeloFamiliares.setListPersonaKardexFamiliar(daoPersonaKardexFamiliar.selectByExample(filtro3));
			
			habilitarBotones(true, false, false, true, true, true);
		}
		
		
	}

	public int getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public int getCodigoInstitucion() {
		return codigoInstitucion;
	}

	public void setCodigoInstitucion(int codigoInstitucion) {
		this.codigoInstitucion = codigoInstitucion;
	}


	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		if ("date".equals(evt.getPropertyName())) {
//            System.out.println(evt.getPropertyName()
//                + ": " + (Date) evt.getNewValue());
            
            Date date = formPersonasKardex.getDateFechaNac().getDate(); // your date
            if(date != null && !tipoOperacion.isEmpty())
            {
	            Calendar cal = Calendar.getInstance();
	            cal.setTime(date);
	            int year = cal.get(Calendar.YEAR);
	            int month = cal.get(Calendar.MONTH);
	            int day = cal.get(Calendar.DAY_OF_MONTH);
	            
	            LocalDate birthdate = new LocalDate  (year, month, day);
	            LocalDate now = new LocalDate();
	            Years age = Years.yearsBetween(birthdate, now);
	            
	            formPersonasKardex.getTxtEdad().setText(String.valueOf(age.getYears()));
            }
        }
	}
	
	@Override
	public void keyTyped(KeyEvent e)
	{
		if(e.getSource().equals(formPersonasKardex.getTxtEdad())
				|| e.getSource().equals(formPersonasKardex.getTxtNroKardex()))
		{
			FormUtilities.keyTyped(e, "entero", formPersonasKardex);
		}
		else
			FormUtilities.keyTyped(e, "entero", formPersonasKardex);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getClickCount() == 2)
        {
        	formPersonasKardex.getTabbedPane().setSelectedIndex(0);
        }
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		actionPerformed(new ActionEvent(formPersonasKardex.getTxtBusqueda(), 25, "Buscar"));
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
//		if(formPersonasKardex.getTxtBusqueda().getText().isEmpty())
			actionPerformed(new ActionEvent(formPersonasKardex.getTxtBusqueda(), 25, "Buscar"));
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}
}
