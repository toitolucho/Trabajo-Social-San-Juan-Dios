package org.quarkbit.trabajosocialsanjuan.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.apache.ibatis.session.SqlSession;
import org.quarkbit.trabajosocialsanjuan.dao.Coneccion;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Departamento;
import org.quarkbit.trabajosocialsanjuan.dao.domain.DepartamentoExample;
import org.quarkbit.trabajosocialsanjuan.dao.domain.DocumentoExample;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Lugar;
import org.quarkbit.trabajosocialsanjuan.dao.domain.LugarExample;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Pais;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PaisExample;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Provincia;
import org.quarkbit.trabajosocialsanjuan.dao.domain.ProvinciaExample;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.DepartamentoMapper;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.LugarMapper;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.PaisMapper;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.ProvinciaMapper;
import org.quarkbit.trabajosocialsanjuan.formularios.FGeografico;
import org.quarkbit.trabajosocialsanjuan.formularios.tablemodels.ModeloDepartamentos;
import org.quarkbit.trabajosocialsanjuan.formularios.tablemodels.ModeloLugares;
import org.quarkbit.trabajosocialsanjuan.formularios.tablemodels.ModeloPaises;
import org.quarkbit.trabajosocialsanjuan.formularios.tablemodels.ModeloProvincias;
import org.quarkbit.trabajosocialsanjuan.utils.FormUtilities;


public class CFGeografico implements ActionListener, ChangeListener, ListSelectionListener, DocumentListener{
	FGeografico formGeografico;
	String tipoOperacion = "";
	SqlSession session;
	PaisMapper daoPaisMapper;
	DepartamentoMapper daoDepartamentoMapper;
	ProvinciaMapper daoProvinciaMapper;
	LugarMapper daoLugarMapper;
	ModeloPaises modeloPais;
	ModeloDepartamentos modeloDepartamento;
	ModeloProvincias modeloProvincia;
	ModeloLugares modeloLugar;
	
	Pais paisActual;
	Departamento departamentoActual;
	Provincia provinciaActual;
	Lugar lugarActual;
	
	Map<String, String> mapa = new HashMap<String, String>();
	
	public CFGeografico(FGeografico formGeografico)
	{
		this.formGeografico = formGeografico;
		
		paisActual = new Pais();
		departamentoActual = new Departamento();
		provinciaActual = new Provincia();
		lugarActual = new Lugar();
		
		mapa.put("nombre_tabla", "paises");
		mapa.put("codigo_pais_aux", "0");
		mapa.put("codigo_departamento_aux", "0");
		mapa.put("codigo_provincia_aux", "0");
		mapa.put("codigo_geografico", "0");
				
	}
	
	public void onLoad()
	{
		session = Coneccion.getSqlSessionFactory().openSession();
		daoPaisMapper = session.getMapper(PaisMapper.class);
		daoDepartamentoMapper = session.getMapper(DepartamentoMapper.class);
		daoProvinciaMapper = session.getMapper(ProvinciaMapper.class);
		daoLugarMapper = session.getMapper(LugarMapper.class);
		modeloPais = new ModeloPaises();
		modeloDepartamento = new ModeloDepartamentos();
		modeloProvincia = new ModeloProvincias();
		modeloLugar = new ModeloLugares();
				
		formGeografico.getTableGeografico().setModel(modeloPais);
		formGeografico.getTxtCodigo().setEditable(false);
		formGeografico.getTxtCodigoDep().setEditable(false);
		formGeografico.getTxtCodigoProv().setEditable(false);
		formGeografico.getTxtCodigoLugar().setEditable(false);
		
		
		
		formGeografico.getBtnAceptar().addActionListener(this);
		formGeografico.getBtnCancelar().addActionListener(this);
		formGeografico.getBtnCerrar().addActionListener(this);
		formGeografico.getBtnEliminar().addActionListener(this);
		formGeografico.getBtnModificar().addActionListener(this);
		formGeografico.getBtnNuevo().addActionListener(this);
		formGeografico.getBtnCerrar().addActionListener(this);
		formGeografico.getTxtTextoBusqueda().getDocument().addDocumentListener(this);
		
		FormUtilities.centrar(formGeografico);
		
		habilitarControlesDepartamentos(false);
		habilitarControlesLugares(false);
		habilitarControlesPaises(false);
		habilitarControlesProvincias(false);
		
		habilitarBotones(true, false, false, false, false);
		
		formGeografico.getTabbedPane().addChangeListener(this);
		
		formGeografico.getTxtCodigo().setEditable(false);
		formGeografico.getTxtCodigoDep().setEditable(false);
		formGeografico.getTxtCodigoProv().setEditable(false);
		formGeografico.getTxtCodigoLugar().setEditable(false);
		
		for (Pais paisAux : daoPaisMapper.selectByExample(null)) {
			formGeografico.getcBoxPaisDep().addItem(paisAux);
			formGeografico.getcBoxPaisProv().addItem(paisAux);
			formGeografico.getcBoxPaisLugar().addItem(paisAux);
		}
		formGeografico.getcBoxPaisDep().setSelectedIndex(-1);
		formGeografico.getcBoxPaisProv().setSelectedIndex(-1);
		formGeografico.getcBoxPaisLugar().setSelectedIndex(-1);
		
		
		formGeografico.getcBoxPaisDep().addActionListener(this);
		formGeografico.getcBoxPaisProv().addActionListener(this);
		formGeografico.getcBoxPaisLugar().addActionListener(this);
		formGeografico.getcBoxDepartamentoLugar().addActionListener(this);
		formGeografico.getcBoxDepartamentoProv().addActionListener(this);
		formGeografico.getcBoxProvinciaLugar().addActionListener(this);
		
		this.formGeografico.getTxtTextoBusqueda().setActionCommand("buscar");
		this.formGeografico.getTxtTextoBusqueda().addActionListener(this);
		
		formGeografico.getTableGeografico().setModel(modeloPais);
		formGeografico.getTableGeografico().getSelectionModel().addListSelectionListener(this);
		
		formGeografico.getTableGeografico().getColumnModel().getColumn(0).setPreferredWidth(0);
		formGeografico.getTableGeografico().getColumnModel().getColumn(0).setMinWidth(0);
		formGeografico.getTableGeografico().getColumnModel().getColumn(0).setMaxWidth(0);
		formGeografico.getTableGeografico().getColumnModel().getColumn(0).setWidth(0);
		
	}
	
	
	public void habilitarControlesPaises(boolean estadoHabilitacion)
	{
//		formGeografico.getTxtCodigo().setEditable(estadoHabilitacion);
		formGeografico.getTxtNombrePais().setEditable(estadoHabilitacion);
		formGeografico.getTxtNacionalidad().setEditable(estadoHabilitacion);
	}
	
	public void habilitarControlesDepartamentos(boolean estadoHabilitacion)
	{
//		formGeografico.getTxtCodigoDep().setEditable(estadoHabilitacion);
		formGeografico.getTxtNombreDep().setEditable(estadoHabilitacion);
		formGeografico.getcBoxPaisDep().setEnabled(estadoHabilitacion);
	}
	
	public void habilitarControlesProvincias(boolean estadoHabilitacion)
	{
//		formGeografico.getTxtCodigoProv().setEditable(estadoHabilitacion);
		formGeografico.getTxtNombreProv().setEditable(estadoHabilitacion);
		formGeografico.getcBoxPaisProv().setEnabled(estadoHabilitacion);
		formGeografico.getcBoxDepartamentoProv().setEnabled(estadoHabilitacion);
	}
	
	public void habilitarControlesLugares(boolean estadoHabilitacion)
	{
//		formGeografico.getTxtCodigoLugar().setEditable(estadoHabilitacion);
		formGeografico.getTxtNombreLugar().setEditable(estadoHabilitacion);
		formGeografico.getcBoxPaisLugar().setEnabled(estadoHabilitacion);
		formGeografico.getcBoxDepartamentoLugar().setEnabled(estadoHabilitacion);
		formGeografico.getcBoxProvinciaLugar().setEnabled(estadoHabilitacion);
	}
	
	public void limpiarControlesPaises()
	{
		formGeografico.getTxtCodigo().setText("");
		formGeografico.getTxtNombrePais().setText("");
		formGeografico.getTxtNacionalidad().setText("");
	}
	
	public void limpiarControlesDepartamentos()
	{
		formGeografico.getTxtCodigoDep().setText("");
		formGeografico.getTxtNombreDep().setText("");
		formGeografico.getcBoxPaisDep().setSelectedIndex(-1);
		
	}
	
	
	public void limpiarControlesProvincias()
	{
		formGeografico.getTxtCodigoProv().setText("");
		formGeografico.getTxtNombreProv().setText("");
		formGeografico.getcBoxPaisProv().setSelectedIndex(-1);
		formGeografico.getcBoxDepartamentoProv().setSelectedIndex(-1);
	}
	
	public void limpiarControlesLugares()
	{
		formGeografico.getTxtCodigoLugar().setText("");
		formGeografico.getTxtNombreLugar().setText("");
		formGeografico.getcBoxPaisLugar().setSelectedIndex(-1);
		formGeografico.getcBoxDepartamentoLugar().setSelectedIndex(-1);
		formGeografico.getcBoxProvinciaLugar().setSelectedIndex(-1);
	}
	
	public void habilitarBotones(boolean nuevo, boolean aceptar, boolean cancelar, boolean modificar, boolean eliminar)
	{
		formGeografico.getBtnAceptar().setEnabled(aceptar);
		formGeografico.getBtnNuevo().setEnabled(nuevo);
		formGeografico.getBtnCancelar().setEnabled(cancelar);
		formGeografico.getBtnModificar().setEnabled(modificar);
		formGeografico.getBtnEliminar().setEnabled(eliminar);
	}
	
	public void cargarDatosPaises(Pais paisAux)
	{
		if(paisAux != null)
		{
			formGeografico.getTxtCodigo().setText(paisAux.getCodigoPais());
			formGeografico.getTxtNombrePais().setText(paisAux.getNombrePais());
			formGeografico.getTxtNacionalidad().setText(paisAux.getNacionalidad());
			
			habilitarBotones(true, false, false, true, true);
		}
		else
			habilitarBotones(true, false, false, false, false);
	}
	
	public void cargarDatosDepartamento(Departamento departamentoAux)
	{
		if(departamentoAux != null)
		{
			formGeografico.getTxtCodigoDep().setText(departamentoAux.getCodigoDepartamento());
			formGeografico.getTxtNombreDep().setText(departamentoAux.getNombreDepartamento());
			formGeografico.getcBoxPaisDep().getModel().setSelectedItem(departamentoAux.getPais());
			
			habilitarBotones(true, false, false, true, true);
		}
		else
			habilitarBotones(true, false, false, false, false);
	}
	
	public void cargarDatosProvincia(Provincia provinciaAux)
	{
		if(provinciaAux != null)
		{
			formGeografico.getTxtCodigoProv().setText(provinciaAux.getCodigoProvincia());
			formGeografico.getTxtNombreProv().setText(provinciaAux.getNombreProvincia());
			
			if(provinciaAux.getDepartamento() != null)
			{
				formGeografico.getcBoxPaisProv().getModel().setSelectedItem(provinciaAux.getDepartamento().getPais());
//				System.out.println(provinciaAux.getDepartamento().getPais());
			}
			else
				formGeografico.getcBoxPaisProv().setSelectedIndex(-1);
			
			formGeografico.getcBoxDepartamentoProv().getModel().setSelectedItem(provinciaAux.getDepartamento());
			
			habilitarBotones(true, false, false, true, true);
		}
		else
			habilitarBotones(true, false, false, false, false);
	}
	
	public void cargarDatosLugar(Lugar lugarAux)
	{
		if(lugarAux != null)
		{
			formGeografico.getTxtCodigoLugar().setText(lugarAux.getCodigoLugar());
			formGeografico.getTxtNombreLugar().setText(lugarAux.getNombreLugar());
			
			
			
			
			if(lugarAux.getProvincia() != null)
			{
				
				if(lugarAux.getProvincia().getDepartamento() != null)
				{
					formGeografico.getcBoxPaisLugar().getModel().setSelectedItem(lugarAux.getProvincia().getDepartamento().getPais());
					formGeografico.getcBoxDepartamentoLugar().getModel().setSelectedItem(lugarAux.getProvincia().getDepartamento());
					formGeografico.getcBoxProvinciaLugar().getModel().setSelectedItem(lugarAux.getProvincia());
				}
				else
					formGeografico.getcBoxPaisLugar().setSelectedIndex(-1);
			}
			else
				formGeografico.getcBoxPaisDep().setSelectedIndex(-1);
			
			habilitarBotones(true, false, false, true, true);
		}
		else
			habilitarBotones(true, false, false, false, false);
	}
	
	public void habilitarTabs(boolean paises, boolean departamentos, boolean provincias, boolean lugares)
	{
	
		if(!paises)
			formGeografico.getTabbedPane().remove(formGeografico.getPnlPaises());
		else
			formGeografico.getTabbedPane().addTab("Paises", null, formGeografico.getPnlPaises(), "Paises");

				
		if(!departamentos)
			formGeografico.getTabbedPane().remove(formGeografico.getPnlDepartamentos());
		else			
			formGeografico.getTabbedPane().addTab("Departamentos", null, formGeografico.getPnlDepartamentos(), "Departamentos");
		
		if(!provincias)
			formGeografico.getTabbedPane().remove(formGeografico.getPnlProvincias());
		else
			formGeografico.getTabbedPane().addTab("Provincias", null, formGeografico.getPnlProvincias(), "Provincias");
		
		if(!lugares)
			formGeografico.getTabbedPane().remove(formGeografico.getPnlLugares());
		else
			formGeografico.getTabbedPane().addTab("Lugares", null, formGeografico.getPnlLugares(), "Lugares");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//busqueda de texto
		if(e.getActionCommand().compareTo("buscar") == 0)
		{
			
			String textoBusqueda = formGeografico.getTxtTextoBusqueda().getText().toUpperCase();
			if(textoBusqueda.isEmpty())
			{
				JOptionPane.showMessageDialog(formGeografico, "A\u00FAn no haingresado un texto para buscar", "Geografico", JOptionPane.ERROR_MESSAGE);
				
				return;
			}
			
			
			
			
			formGeografico.getTxtTextoBusqueda().grabFocus();
			formGeografico.getTxtTextoBusqueda().selectAll();
			if(formGeografico.getTabbedPane().getSelectedComponent() != null)
			{
				
				
				if(formGeografico.getTabbedPane().getSelectedComponent().equals(formGeografico.getPnlPaises())){
					PaisExample filtroPaises = new PaisExample();
					filtroPaises.createCriteria().andNombrePaisLike("%"+textoBusqueda +"%");

					filtroPaises.or().andCodigoPaisLike(textoBusqueda);
					filtroPaises.setOrderByClause("nombre_pais ASC");
					List<Pais> listaPaises = daoPaisMapper.selectByExample(filtroPaises);
					modeloPais.setListPais(listaPaises);
				}
				if(formGeografico.getTabbedPane().getSelectedComponent().equals(formGeografico.getPnlDepartamentos())){
					DepartamentoExample filtroDepartamento = new DepartamentoExample();
					filtroDepartamento.createCriteria().andNombreDepartamentoLike("%"+textoBusqueda+"%");
					filtroDepartamento.or().andCodigoDepartamentoLike("%"+textoBusqueda+"%");
					filtroDepartamento.setOrderByClause("nombre_departamento");
					modeloDepartamento.setListDepartamento(daoDepartamentoMapper.selectByExample(filtroDepartamento));
				}
				if(formGeografico.getTabbedPane().getSelectedComponent().equals(formGeografico.getPnlProvincias())){
					ProvinciaExample filtroProvincia = new ProvinciaExample();
					filtroProvincia.createCriteria().andNombreProvinciaLike("%"+textoBusqueda+"%");
					filtroProvincia.or().andCodigoProvinciaLike("%"+textoBusqueda+"%");
					filtroProvincia.setOrderByClause("nombre_Provincia");
					modeloProvincia.setListProvincia(daoProvinciaMapper.selectByExample(filtroProvincia));
				}
				if(formGeografico.getTabbedPane().getSelectedComponent().equals(formGeografico.getPnlLugares())){
					LugarExample filtroLugar = new LugarExample();
					filtroLugar.createCriteria().andNombreLugarLike("%"+textoBusqueda+"%");
					filtroLugar.or().andCodigoLugarLike("%"+textoBusqueda+"%");
//					filtroLugar.setOrderByClause("nombre_Lugar");
//					System.out.println(daoLugarMapper.selectByExample(filtroLugar));
					modeloLugar.setListLugar(daoLugarMapper.selectByExample(filtroLugar));
				}
			}
		}
		
		
		if(tipoOperacion.compareTo("I") == 0 && e.getSource().equals(formGeografico.getcBoxPaisDep()) && formGeografico.getcBoxPaisDep().getSelectedItem() != null)
		{
			mapa.put("nombre_tabla", "departamentos");
			mapa.put("codigo_pais_aux", ((Pais )formGeografico.getcBoxPaisDep().getSelectedItem()).getCodigoPais());
			
			daoPaisMapper.obtenerCodigoGeografico(mapa);
			formGeografico.getTxtCodigoDep().setText(mapa.get("codigo_geografico"));
		}
		
		//--------------------------------------------------------------------------------------
		//provincias
		if(e.getSource().equals(formGeografico.getcBoxPaisProv()) && formGeografico.getcBoxPaisProv().getSelectedItem() != null)
		{
			paisActual.setCodigoPais(((Pais )formGeografico.getcBoxPaisProv().getSelectedItem()).getCodigoPais());
			DepartamentoExample filtro = new DepartamentoExample();
			filtro.createCriteria().andCodigoPaisEqualTo(paisActual.getCodigoPais());
			formGeografico.getcBoxDepartamentoProv().removeAllItems();
			for (Departamento departamentoAux : daoDepartamentoMapper.selectByExample(filtro)) {
				formGeografico.getcBoxDepartamentoProv().addItem(departamentoAux);
			} 

		}
		if(tipoOperacion.compareTo("I") == 0 &&  e.getSource().equals(formGeografico.getcBoxDepartamentoProv()) && formGeografico.getcBoxDepartamentoProv().getSelectedItem() != null)
		{
			mapa.put("nombre_tabla", "provincias");
			mapa.put("codigo_pais_aux", ((Pais )formGeografico.getcBoxPaisProv().getSelectedItem()).getCodigoPais());
			mapa.put("codigo_departamento_aux", ((Departamento )formGeografico.getcBoxDepartamentoProv().getSelectedItem()).getCodigoDepartamento());
			
			daoPaisMapper.obtenerCodigoGeografico(mapa);
			formGeografico.getTxtCodigoProv().setText(mapa.get("codigo_geografico"));
		}
		//--------------------------------------------------------------------------------------
		
		
		
		
		//--------------------------------------------------------------------------------------
		//Lugares
		if(e.getSource().equals(formGeografico.getcBoxPaisLugar()) && formGeografico.getcBoxPaisLugar().getSelectedItem() != null)
		{
			paisActual.setCodigoPais(((Pais )formGeografico.getcBoxPaisLugar().getSelectedItem()).getCodigoPais());
			DepartamentoExample filtro = new DepartamentoExample();
			filtro.createCriteria().andCodigoPaisEqualTo(paisActual.getCodigoPais());
			formGeografico.getcBoxDepartamentoLugar().removeAllItems();
			
			for (Departamento departamentoAux : daoDepartamentoMapper.selectByExample(filtro)) {
				formGeografico.getcBoxDepartamentoLugar().addItem(departamentoAux);
			} 

		}
		if(e.getSource().equals(formGeografico.getcBoxDepartamentoLugar()) && formGeografico.getcBoxDepartamentoLugar().getSelectedItem() != null)
		{
			departamentoActual.setCodigoDepartamento( ((Departamento )formGeografico.getcBoxDepartamentoLugar().getSelectedItem()).getCodigoDepartamento());
			ProvinciaExample filtro = new ProvinciaExample();
			filtro.createCriteria().andCodigoDepartamentoEqualTo( departamentoActual.getCodigoDepartamento()).andCodigoPaisEqualTo(paisActual.getCodigoPais());
			
			formGeografico.getcBoxProvinciaLugar().removeAllItems();
			for (Provincia provinciaAux : daoProvinciaMapper.selectByExample(filtro)) {
				formGeografico.getcBoxProvinciaLugar().addItem(provinciaAux);
			} 

		}
		if(tipoOperacion.compareTo("I") == 0 && e.getSource().equals(formGeografico.getcBoxProvinciaLugar()) && formGeografico.getcBoxProvinciaLugar().getSelectedItem() != null)
		{
			mapa.put("nombre_tabla", "lugares");
			mapa.put("codigo_pais_aux", ((Pais )formGeografico.getcBoxPaisLugar().getSelectedItem()).getCodigoPais());
			mapa.put("codigo_departamento_aux", ((Departamento )formGeografico.getcBoxDepartamentoLugar().getSelectedItem()).getCodigoDepartamento());
			mapa.put("codigo_provincia_aux", ((Provincia )formGeografico.getcBoxProvinciaLugar().getSelectedItem()).getCodigoProvincia());
			
			daoPaisMapper.obtenerCodigoGeografico(mapa);
			formGeografico.getTxtCodigoLugar().setText(mapa.get("codigo_geografico"));
		}
		//--------------------------------------------------------------------------------------
		
		
		if(e.getActionCommand().compareTo("Nuevo") == 0)
		{
			formGeografico.getTableGeografico().setEnabled(false);
			formGeografico.getTxtTextoBusqueda().setEnabled(false);
			tipoOperacion = "I";
			habilitarBotones(false, true, true, false, false);
			if(formGeografico.getTabbedPane().getSelectedComponent().equals(formGeografico.getPnlPaises()))
			{
				habilitarControlesPaises(true);
				limpiarControlesPaises();
				habilitarTabs(true, false, false, false);
				
				
				mapa.put("nombre_tabla", "paises");
				
				
				daoPaisMapper.obtenerCodigoGeografico(mapa);
				formGeografico.getTxtCodigo().setText(mapa.get("codigo_geografico"));
				
//				daoProveedorMapper.obtenerUltimoId(mapa); //("myMappedStatement",myParams);
//				proveedorActual.setCodigoProveedor(mapa.get("ultimoId"));
				
			}
			if(formGeografico.getTabbedPane().getSelectedComponent().equals(formGeografico.getPnlDepartamentos()))
			{
				habilitarControlesDepartamentos(true);
				limpiarControlesDepartamentos();
				habilitarTabs(false, true, false, false);
				
				
				mapa.put("nombre_tabla", "departamentos");
				
				
				daoDepartamentoMapper.obtenerCodigoGeografico(mapa);
				formGeografico.getTxtCodigoDep().setText(mapa.get("codigo_geografico"));
				
			}
			if(formGeografico.getTabbedPane().getSelectedComponent().equals(formGeografico.getPnlProvincias()))
			{
				habilitarControlesProvincias(true);
				limpiarControlesProvincias();
				habilitarTabs(false, false, true, false);
				
			}
			if(formGeografico.getTabbedPane().getSelectedComponent().equals(formGeografico.getPnlLugares()))
			{
				habilitarControlesLugares(true);
				limpiarControlesLugares();
				habilitarTabs(false, false, false, true);
				
			}
		}
		
		if(e.getActionCommand().compareTo("Modificar") == 0)
		{
			formGeografico.getTableGeografico().setEnabled(false);
			formGeografico.getTxtTextoBusqueda().setEnabled(false);
			tipoOperacion = "E";
			
			if(formGeografico.getTabbedPane().getSelectedComponent().equals(formGeografico.getPnlPaises()))
			{
				habilitarControlesPaises(true);				
				habilitarTabs(true, false, false, false);
			}
			if(formGeografico.getTabbedPane().getSelectedComponent().equals(formGeografico.getPnlDepartamentos()))
			{
				habilitarControlesDepartamentos(true);				
				habilitarTabs(false, true, false, false);
			}
			if(formGeografico.getTabbedPane().getSelectedComponent().equals(formGeografico.getPnlProvincias()))
			{
				habilitarControlesProvincias(true);				
				habilitarTabs(false, false, true, false);
			}
			if(formGeografico.getTabbedPane().getSelectedComponent().equals(formGeografico.getPnlLugares()))
			{
				habilitarControlesLugares(true);				
				habilitarTabs(false, false, false, true);
			}
			habilitarBotones(false, true, true, false, false);
		}
		
		if(e.getActionCommand().compareTo("Aceptar") == 0)
		{			
			try {
				if(formGeografico.getTabbedPane().getSelectedComponent().equals(formGeografico.getPnlPaises()))
				{
					PaisExample filtro = new PaisExample();
					filtro.or().andNombrePaisEqualTo(formGeografico.getTxtNombrePais().getText().toUpperCase());
					if(tipoOperacion.compareTo("I") == 0 && daoPaisMapper.countByExample(filtro) > 0)
					{
						JOptionPane.showMessageDialog(formGeografico, "El nombre de la Pais ya se encuentra registrado", "Paises", JOptionPane.ERROR_MESSAGE);
						formGeografico.getTxtNombrePais().grabFocus();
						return;
					}
					
					paisActual = new Pais();
					paisActual.setCodigoPais(formGeografico.getTxtCodigo().getText());
					paisActual.setNombrePais(formGeografico.getTxtNombrePais().getText().toUpperCase());
					paisActual.setNacionalidad(formGeografico.getTxtNacionalidad().getText());
					if(tipoOperacion.compareTo("I")==0)
					{
						daoPaisMapper.insert(paisActual);
						
						formGeografico.getcBoxPaisProv().addItem(paisActual);
						formGeografico.getcBoxPaisDep().addItem(paisActual);
						formGeografico.getcBoxPaisLugar().addItem(paisActual);
					}
					else
					{
						daoPaisMapper.updateByPrimaryKey(paisActual);
					}
					habilitarControlesPaises(false);
					
				}
				if(formGeografico.getTabbedPane().getSelectedComponent().equals(formGeografico.getPnlDepartamentos()))
				{
					departamentoActual = new Departamento();
					departamentoActual.setCodigoDepartamento(formGeografico.getTxtCodigoDep().getText());
					departamentoActual.setNombreDepartamento(formGeografico.getTxtNombreDep().getText());
					departamentoActual.setPais((Pais)formGeografico.getcBoxPaisDep().getSelectedItem());
					departamentoActual.setCodigoPais(departamentoActual.getPais().getCodigoPais());
					
					if(tipoOperacion.compareTo("I") == 0)
					{
						daoDepartamentoMapper.insert(departamentoActual);
					}
					else
					{
						daoDepartamentoMapper.updateByPrimaryKey(departamentoActual);
					}
					
					habilitarControlesDepartamentos(false);
				}
				if(formGeografico.getTabbedPane().getSelectedComponent().equals(formGeografico.getPnlProvincias()))
				{
					provinciaActual = new Provincia();
					provinciaActual.setCodigoProvincia(formGeografico.getTxtCodigoProv().getText());
					provinciaActual.setNombreProvincia(formGeografico.getTxtNombreProv().getText());
//				provinciaActual.setPais((Pais)formGeografico.getcBoxPaisDep().getSelectedItem());
					provinciaActual.setCodigoPais(((Pais)formGeografico.getcBoxPaisProv().getSelectedItem()).getCodigoPais());
//				provinciaActual.setPais((Pais)formGeografico.getcBoxPaisDep().getSelectedItem());
					provinciaActual.setCodigoDepartamento(((Departamento)formGeografico.getcBoxDepartamentoProv().getSelectedItem()).getCodigoDepartamento());
					
					if(tipoOperacion.compareTo("I") == 0)
					{
						daoProvinciaMapper.insert(provinciaActual);
					}
					else
					{
						daoProvinciaMapper.updateByPrimaryKey(provinciaActual);
					}
					habilitarControlesProvincias(false);
				}
				if(formGeografico.getTabbedPane().getSelectedComponent().equals(formGeografico.getPnlLugares()))
				{
					lugarActual = new Lugar();
					lugarActual.setCodigoLugar(formGeografico.getTxtCodigoLugar().getText());
					lugarActual.setNombreLugar(formGeografico.getTxtNombreLugar().getText());
					lugarActual.setCodigoPais(((Pais)formGeografico.getcBoxPaisLugar().getSelectedItem()).getCodigoPais());
					lugarActual.setCodigoDepartamento(((Departamento)formGeografico.getcBoxDepartamentoLugar().getSelectedItem()).getCodigoDepartamento());
					lugarActual.setCodigoProvincia(((Provincia)formGeografico.getcBoxProvinciaLugar().getSelectedItem()).getCodigoProvincia());
					
					if(tipoOperacion.compareTo("I") == 0)
					{
//						System.out.println("insertado "  + lugarActual);
						daoLugarMapper.insert(lugarActual);
					}
					else
					{
						daoLugarMapper.updateByPrimaryKey(lugarActual);
					}
					
					habilitarControlesLugares(false);
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
				JOptionPane.showMessageDialog(formGeografico, "Ocurrio la siguiente excepcion " + e1.toString(), "Geografico", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			session.commit();
			habilitarBotones(true, false, false, true, true);			
			tipoOperacion ="";
			formGeografico.getTableGeografico().setEnabled(true);
			formGeografico.getTxtTextoBusqueda().setEnabled(true);
			habilitarTabs(true, true, true, true);
			JOptionPane.showMessageDialog(formGeografico, "Registro almacenado correctamente", "Geografico", JOptionPane.INFORMATION_MESSAGE);
		}
		
		if(e.getActionCommand().compareTo("Cancelar") == 0)
		{			
			
			if(formGeografico.getTabbedPane().getSelectedComponent().equals(formGeografico.getPnlPaises()))
			{				
				limpiarControlesPaises();
				habilitarControlesPaises(false);
			}
			if(formGeografico.getTabbedPane().getSelectedComponent().equals(formGeografico.getPnlDepartamentos()))
			{
				limpiarControlesDepartamentos();
				habilitarControlesDepartamentos(false);
			}
			if(formGeografico.getTabbedPane().getSelectedComponent().equals(formGeografico.getPnlProvincias()))
			{
				limpiarControlesProvincias();
				habilitarControlesProvincias(false);
			}
			if(formGeografico.getTabbedPane().getSelectedComponent().equals(formGeografico.getPnlLugares()))
			{
				limpiarControlesLugares();
				habilitarControlesLugares(false);
			}
			formGeografico.getTableGeografico().setEnabled(true);
			formGeografico.getTxtTextoBusqueda().setEnabled(true);
			habilitarBotones(true, false, false, false, false);
			tipoOperacion = "";
			habilitarTabs(true, true, true, true);
		}
		
		if(e.getActionCommand().compareTo("Eliminar") == 0)
		{
			if(JOptionPane.showConfirmDialog(formGeografico, "¿Se encuentra seguro de eliminar el registro actual?", "Geografico", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)			
			{
				try {
					if(formGeografico.getTabbedPane().getSelectedComponent().equals(formGeografico.getPnlPaises()))
					{
						Pais paisEliminar = modeloPais.eliminarPais(formGeografico.getTableGeografico().getSelectedRow());
						daoPaisMapper.deleteByPrimaryKey(paisEliminar.getCodigoPais());
						limpiarControlesPaises();
						
					}
					if(formGeografico.getTabbedPane().getSelectedComponent().equals(formGeografico.getPnlDepartamentos()))
					{
						Departamento departamentoEliminar = modeloDepartamento.eliminarDepartamento(formGeografico.getTableGeografico().getSelectedRow());
						daoDepartamentoMapper.deleteByPrimaryKey(departamentoEliminar);
						limpiarControlesDepartamentos();
					}
					if(formGeografico.getTabbedPane().getSelectedComponent().equals(formGeografico.getPnlProvincias()))
					{
						Provincia provinciaEliminar = modeloProvincia.eliminarProvincia(formGeografico.getTableGeografico().getSelectedRow());
						daoProvinciaMapper.deleteByPrimaryKey(provinciaEliminar);
						limpiarControlesProvincias();
					}
					if(formGeografico.getTabbedPane().getSelectedComponent().equals(formGeografico.getPnlLugares()))
					{
						Lugar lugarEliminar = modeloLugar.eliminarLugar(formGeografico.getTableGeografico().getSelectedRow());
						daoLugarMapper.deleteByPrimaryKey(lugarEliminar);
						limpiarControlesLugares();
					}
					session.commit();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
//					e1.printStackTrace();
					JOptionPane.showMessageDialog(formGeografico, "No se puede eliminar el registro actual debido a que se encuentra en uso",  "Geografico", JOptionPane.ERROR_MESSAGE);
					session.clearCache();
//					session.rollback();
					session.commit();
				}
				habilitarBotones(true, false, false, false, false);
			}
			
		}
		
		if(e.getActionCommand().compareTo("Cerrar") == 0)
		{
			this.formGeografico.setVisible(false);
			this.formGeografico.dispose();
		}
	
	
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
//		formGeografico.getTabbedPane().getTitleAt(e.)
//		System.out.println(tipoOperacion);
		
		if(formGeografico.getTabbedPane().getSelectedComponent() != null)
		{
			formGeografico.getTxtTextoBusqueda().setText("");
			modeloPais.setListPais(null);
			modeloDepartamento.setListDepartamento(null);
			modeloProvincia.setListProvincia(null);
			modeloLugar.setListLugar(null);
			
			if(formGeografico.getTabbedPane().getSelectedComponent().equals(formGeografico.getPnlPaises())){
				formGeografico.getTableGeografico().setModel(modeloPais);
			}
			if(formGeografico.getTabbedPane().getSelectedComponent().equals(formGeografico.getPnlDepartamentos())){
				formGeografico.getTableGeografico().setModel(modeloDepartamento);
			}
			if(formGeografico.getTabbedPane().getSelectedComponent().equals(formGeografico.getPnlProvincias())){
				formGeografico.getTableGeografico().setModel(modeloProvincia);
			}
			if(formGeografico.getTabbedPane().getSelectedComponent().equals(formGeografico.getPnlLugares())){
				formGeografico.getTableGeografico().setModel(modeloLugar);
			}
			formGeografico.getTableGeografico().getColumnModel().getColumn(0).setPreferredWidth(0);
			formGeografico.getTableGeografico().getColumnModel().getColumn(0).setMinWidth(0);
			formGeografico.getTableGeografico().getColumnModel().getColumn(0).setMaxWidth(0);
			formGeografico.getTableGeografico().getColumnModel().getColumn(0).setWidth(0);
			
		}
		
	}
	
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if(e.getValueIsAdjusting())
			return;
		int indice = ((ListSelectionModel) e.getSource()).getMinSelectionIndex();
		
		if(formGeografico.getTabbedPane().getSelectedComponent() != null)
		{
			if(formGeografico.getTabbedPane().getSelectedComponent().equals(formGeografico.getPnlPaises())){
//				formGeografico.getTableGeografico().setModel(modeloPais);
				cargarDatosPaises(modeloPais.obtenerPais(indice));
			}
			if(formGeografico.getTabbedPane().getSelectedComponent().equals(formGeografico.getPnlDepartamentos())){
				cargarDatosDepartamento(modeloDepartamento.obtenerDepartamento(indice));
//				System.out.println("Pais : "+modeloDepartamento.obtenerDepartamento(indice).getPais());
			}
			if(formGeografico.getTabbedPane().getSelectedComponent().equals(formGeografico.getPnlProvincias())){
				cargarDatosProvincia(modeloProvincia.obtenerProvincia(indice));
			}
			if(formGeografico.getTabbedPane().getSelectedComponent().equals(formGeografico.getPnlLugares())){
				cargarDatosLugar(modeloLugar.obtenerLugar(indice));
			}
		}
		
//		cargarDatos(modeloProveedor.obtenerProveedor(indice));
	}

	
	public void visualizarPnlGeografico(int indice)
	{
		switch (indice) {
		case 1:
			formGeografico.getTabbedPane().setSelectedComponent(formGeografico.getPnlPaises());
			break;
		case 2:
			formGeografico.getTabbedPane().setSelectedComponent(formGeografico.getPnlDepartamentos());
			break;
		case 3:
			formGeografico.getTabbedPane().setSelectedComponent(formGeografico.getPnlProvincias());
			break;
		case 4:
			formGeografico.getTabbedPane().setSelectedComponent(formGeografico.getPnlLugares());
			break;
		default:
			break;
		}
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		actionPerformed(new ActionEvent(formGeografico.getTxtTextoBusqueda(), 120, "buscar"));
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}
}

