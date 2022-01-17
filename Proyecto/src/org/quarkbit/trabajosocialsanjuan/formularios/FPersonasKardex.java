package org.quarkbit.trabajosocialsanjuan.formularios;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import org.quarkbit.trabajosocialsanjuan.controller.CFPersonasKardex;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Departamento;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Institucion;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Lugar;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Pais;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Persona;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Provincia;

import com.toedter.calendar.JDateChooser;
import javax.swing.ScrollPaneConstants;

public class FPersonasKardex extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNroKardex;
	private JTextField txtPresonaIngreso;
	private JTextField txtPersonaEgreso;
	private JTextField txtNombreKardex;
	private JTextField txtEdad;
	private JTable tableDocumentos;
	private JTable tableFamiliares;
	private JTable tablePersonas;
	private JTextField txtBusqueda;
	private JDateChooser dateFechaIngreso;
	private JComboBox<Institucion> cBoxInstitucion;
	private JButton btnAgregarInst;
	private JTextArea txtMotivoIngreso;
	private JButton btnBuscarPersonaIngreso;
	private JTextArea txtMotivoEgreso;
	private JButton btnBuscarPersonaEgreso;
	private JButton btnAgregarTrabSocial;
	private JDateChooser dateFechaNac;
	private JComboBox<Pais> cBoxPais;
	private JComboBox<Departamento> cBoxDepartamento;
	private JComboBox<Provincia> cBoxProvincia;
	private JComboBox<Lugar> cBoxLugar;
	private JButton btnNuevoDoc;
	private JButton btnModificarDoc;
	private JButton btnEliminarDoc;
	private JButton btnNuevoFamiliar;
	private JButton btnModificarFamiliar;
	private JButton btnEliminarFamiliar;
	private CFPersonasKardex control;
	private PnlPersonas pnlPersonales;
	private JPanel pnlKardex;
	private JPanel pnlDatosNacimiento;
	private JPanel pnlDoc_Familiares;
	private JPanel pnlBusqueda;
	private JComboBox<Persona> cBoxTrabajadoraSocial;
	private JButton btnNuevo;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnCerrar;
	private JButton btnBuscar;
	private JTabbedPane tabbedPane;
	private JButton btnAgregarPersonaIngreso;
	private JButton btnAgregarPersonaEgreso;
	public JLabel lblPresentacion;
	private JButton btnReporte;
	private JScrollPane scrollPane_3;
	private JScrollPane scrollPane_4;
	private JScrollPane scrollPane_5;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FPersonasKardex frame = new FPersonasKardex();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public FPersonasKardex(JFrame owner) {
		super(owner,true);
		setResizable(false);
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setTitle("Kardex Personal");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 601, 647);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		control = new CFPersonasKardex(this);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		
		
		pnlPersonales = new PnlPersonas();
		pnlPersonales.getcBoxEstadoCivil().setPreferredSize(new Dimension(240, 22));
		pnlPersonales.getcBoxSexo().setPreferredSize(new Dimension(240, 22));
		pnlPersonales.getcBoxGradoInstruccion().setPreferredSize(new Dimension(240, 22));
		pnlPersonales.getcBoxEmpleo().setPreferredSize(new Dimension(240, 22));
		pnlPersonales.getTxtTelefono().setColumns(22);
		pnlPersonales.getTxtCelular().setColumns(22);
		pnlPersonales.getTxtMaterno().setColumns(22);
		pnlPersonales.getTxtAppPaterno().setColumns(22);
		pnlPersonales.getTxtNombres().setColumns(22);
		pnlPersonales.getTxtDIPersonal().setColumns(22);
		FlowLayout flowLayout_2 = (FlowLayout) pnlPersonales.getLayout();
		flowLayout_2.setVgap(5);
		flowLayout_2.setHgap(25);
		pnlPersonales.getTxtObservaciones().setPreferredSize(new Dimension(256, 58));
		pnlPersonales.getTxtDomicilio().setPreferredSize(new Dimension(256, 58));
		pnlPersonales.setPreferredSize(new Dimension(300, 112));
		tabbedPane.addTab("Personales", null, pnlPersonales, null);
		tabbedPane.setEnabledAt(0, true);
		
		pnlKardex = new JPanel();
		FlowLayout fl_pnlKardex = (FlowLayout) pnlKardex.getLayout();
		fl_pnlKardex.setHgap(8);
		fl_pnlKardex.setVgap(8);
		fl_pnlKardex.setAlignment(FlowLayout.LEFT);
		tabbedPane.addTab("Kardex", null, pnlKardex, null);
		
		JLabel lblNumeroKardex = new JLabel("Numero Kardex :");
		lblNumeroKardex.setPreferredSize(new Dimension(200, 16));
		pnlKardex.add(lblNumeroKardex);
		
		txtNroKardex = new JTextField();
		pnlKardex.add(txtNroKardex);
		txtNroKardex.setColumns(20);
		
		JLabel lblNombreKardex = new JLabel("Nombre Kardex :");
		lblNombreKardex.setPreferredSize(new Dimension(200, 16));
		pnlKardex.add(lblNombreKardex);
		
		txtNombreKardex = new JTextField();
		txtNombreKardex.setColumns(20);
		pnlKardex.add(txtNombreKardex);
		
		JLabel lblFechaDeIngreso = new JLabel("Fecha de Ingreso :");
		lblFechaDeIngreso.setPreferredSize(new Dimension(200, 16));
		pnlKardex.add(lblFechaDeIngreso);
		
		dateFechaIngreso = new JDateChooser();
		dateFechaIngreso.setPreferredSize(new Dimension(200, 22));
		dateFechaIngreso.setDateFormatString("dd-MM-yyyy");
		pnlKardex.add(dateFechaIngreso);
		
		JLabel lblInstitucionCentro = new JLabel("Institucion ( Centro) :");
		lblInstitucionCentro.setPreferredSize(new Dimension(200, 16));
		pnlKardex.add(lblInstitucionCentro);
		
		cBoxInstitucion = new JComboBox<Institucion>();
		cBoxInstitucion.setPreferredSize(new Dimension(225, 22));
		pnlKardex.add(cBoxInstitucion);
		
		btnAgregarInst = new JButton("+");
		btnAgregarInst.setToolTipText("Agregar una Nueva Institucion");
		btnAgregarInst.setPreferredSize(new Dimension(28, 28));
		btnAgregarInst.setMargin(new Insets(0, 2, 0, 2));
		btnAgregarInst.setActionCommand("agregarEmpleo");
		pnlKardex.add(btnAgregarInst);
		
		JLabel lblMotivoIngreso = new JLabel("Motivo Ingreso :");
		lblMotivoIngreso.setPreferredSize(new Dimension(200, 16));
		pnlKardex.add(lblMotivoIngreso);
		
		scrollPane_4 = new JScrollPane();
		scrollPane_4.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pnlKardex.add(scrollPane_4);
		
		txtMotivoIngreso = new JTextArea();
		scrollPane_4.setViewportView(txtMotivoIngreso);
		txtMotivoIngreso.setColumns(20);
		txtMotivoIngreso.setRows(4);
		
		JLabel lblPersonaQueRefiere = new JLabel("Persona que refiere caso Ingreso :");
		lblPersonaQueRefiere.setPreferredSize(new Dimension(200, 16));
		pnlKardex.add(lblPersonaQueRefiere);
		
		txtPresonaIngreso = new JTextField();
		txtPresonaIngreso.setEditable(false);
		txtPresonaIngreso.setColumns(17);
		pnlKardex.add(txtPresonaIngreso);
		
		btnAgregarPersonaIngreso = new JButton("+");
		btnAgregarPersonaIngreso.setToolTipText("Agregar una Nueva Persona");
		btnAgregarPersonaIngreso.setPreferredSize(new Dimension(28, 28));
		btnAgregarPersonaIngreso.setMargin(new Insets(0, 0, 0, 0));
		btnAgregarPersonaIngreso.setActionCommand("agregarEmpleo");
		pnlKardex.add(btnAgregarPersonaIngreso);
		
		btnBuscarPersonaIngreso = new JButton("...");
		btnBuscarPersonaIngreso.setToolTipText("Buscar una persona ya Registrada");
		btnBuscarPersonaIngreso.setPreferredSize(new Dimension(28, 28));
		btnBuscarPersonaIngreso.setMargin(new Insets(0, 0, 0, 0));
		btnBuscarPersonaIngreso.setActionCommand("agregarEmpleo");
		pnlKardex.add(btnBuscarPersonaIngreso);
		
		JLabel lblMotivoEgreso = new JLabel("Motivo Egreso :");
		lblMotivoEgreso.setPreferredSize(new Dimension(200, 16));
		pnlKardex.add(lblMotivoEgreso);
		
		scrollPane_5 = new JScrollPane();
		scrollPane_5.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pnlKardex.add(scrollPane_5);
		
		txtMotivoEgreso = new JTextArea();
		scrollPane_5.setViewportView(txtMotivoEgreso);
		txtMotivoEgreso.setAlignmentX(Component.RIGHT_ALIGNMENT);
		txtMotivoEgreso.setRows(4);
		txtMotivoEgreso.setColumns(20);
		
		JLabel lblPersonaQueRefiere_1 = new JLabel("Persona que refiere caso Egreso :");
		lblPersonaQueRefiere_1.setPreferredSize(new Dimension(200, 16));
		pnlKardex.add(lblPersonaQueRefiere_1);
		
		txtPersonaEgreso = new JTextField();
		txtPersonaEgreso.setEditable(false);
		txtPersonaEgreso.setColumns(17);
		pnlKardex.add(txtPersonaEgreso);
		
		btnAgregarPersonaEgreso = new JButton("+");
		btnAgregarPersonaEgreso.setToolTipText("Agregar una Nueva Persona");
		btnAgregarPersonaEgreso.setPreferredSize(new Dimension(28, 28));
		btnAgregarPersonaEgreso.setMargin(new Insets(0, 0, 0, 0));
		btnAgregarPersonaEgreso.setActionCommand("agregarEmpleo");
		pnlKardex.add(btnAgregarPersonaEgreso);
		
		btnBuscarPersonaEgreso = new JButton("...");
		btnBuscarPersonaEgreso.setToolTipText("Buscar una persona ya Registrada");
		btnBuscarPersonaEgreso.setPreferredSize(new Dimension(28, 28));
		btnBuscarPersonaEgreso.setMargin(new Insets(0, 0, 0, 0));
		btnBuscarPersonaEgreso.setActionCommand("agregarEmpleo");
		pnlKardex.add(btnBuscarPersonaEgreso);
		
		JLabel lblTrabajadoraSocial = new JLabel("Trabajadora Social :");
		lblTrabajadoraSocial.setPreferredSize(new Dimension(200, 16));
		pnlKardex.add(lblTrabajadoraSocial);
		
		cBoxTrabajadoraSocial = new JComboBox<Persona>();
		cBoxTrabajadoraSocial.setPreferredSize(new Dimension(225, 22));
		pnlKardex.add(cBoxTrabajadoraSocial);
		
		btnAgregarTrabSocial = new JButton("+");
		btnAgregarTrabSocial.setToolTipText("Agregar nueva Trabajadora Social");
		btnAgregarTrabSocial.setVisible(false);
		btnAgregarTrabSocial.setPreferredSize(new Dimension(28, 28));
		btnAgregarTrabSocial.setMargin(new Insets(0, 2, 0, 2));
		btnAgregarTrabSocial.setActionCommand("agregarEmpleo");
		pnlKardex.add(btnAgregarTrabSocial);
		
		pnlDatosNacimiento = new JPanel();
		FlowLayout fl_pnlDatosNacimiento = (FlowLayout) pnlDatosNacimiento.getLayout();
		fl_pnlDatosNacimiento.setVgap(15);
		fl_pnlDatosNacimiento.setAlignment(FlowLayout.LEFT);
		fl_pnlDatosNacimiento.setHgap(30);
		tabbedPane.addTab("Datos Nacimiento", null, pnlDatosNacimiento, null);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento :");
		lblFechaDeNacimiento.setPreferredSize(new Dimension(170, 16));
		pnlDatosNacimiento.add(lblFechaDeNacimiento);
		
		dateFechaNac = new JDateChooser();
		dateFechaNac.setPreferredSize(new Dimension(250, 22));
		dateFechaNac.setDateFormatString("dd-MM-yyyy");
		dateFechaNac.getCalendarButton().setPreferredSize(new Dimension(50, 17));
		pnlDatosNacimiento.add(dateFechaNac);
		
		JLabel lblEdad = new JLabel("Edad :");
		lblEdad.setPreferredSize(new Dimension(170, 16));
		pnlDatosNacimiento.add(lblEdad);
		
		txtEdad = new JTextField();
		pnlDatosNacimiento.add(txtEdad);
		txtEdad.setColumns(22);
		
		JLabel lblPas = new JLabel("Pais :");
		lblPas.setPreferredSize(new Dimension(170, 16));
		pnlDatosNacimiento.add(lblPas);
		
		cBoxPais = new JComboBox<Pais>();
		cBoxPais.setPreferredSize(new Dimension(200, 22));
		pnlDatosNacimiento.add(cBoxPais);
		
		JLabel lblDepartamento = new JLabel("Departamento :");
		lblDepartamento.setPreferredSize(new Dimension(170, 16));
		pnlDatosNacimiento.add(lblDepartamento);
		
		cBoxDepartamento = new JComboBox<Departamento>();
		cBoxDepartamento.setPreferredSize(new Dimension(200, 22));
		pnlDatosNacimiento.add(cBoxDepartamento);
		
		JLabel lblProvincia = new JLabel("Provincia :");
		lblProvincia.setPreferredSize(new Dimension(170, 16));
		pnlDatosNacimiento.add(lblProvincia);
		
		cBoxProvincia = new JComboBox<Provincia>();
		cBoxProvincia.setPreferredSize(new Dimension(200, 22));
		pnlDatosNacimiento.add(cBoxProvincia);
		
		JLabel lblLugar = new JLabel("Lugar :");
		lblLugar.setPreferredSize(new Dimension(170, 16));
		pnlDatosNacimiento.add(lblLugar);
		
		cBoxLugar = new JComboBox<Lugar>();
		cBoxLugar.setPreferredSize(new Dimension(200, 22));
		pnlDatosNacimiento.add(cBoxLugar);
		
		pnlDoc_Familiares = new JPanel();
		tabbedPane.addTab("Documentos - Familiares", null, pnlDoc_Familiares, null);
		pnlDoc_Familiares.setLayout(new GridLayout(0, 1, 5, 5));
		
		JPanel pnlDocumentos = new JPanel();
		pnlDocumentos.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "Lista de Documentos ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDoc_Familiares.add(pnlDocumentos);
		pnlDocumentos.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		pnlDocumentos.add(scrollPane);
		
		tableDocumentos = new JTable();
		scrollPane.setViewportView(tableDocumentos);
		
		JPanel pnlBotonesDoc = new JPanel();
		FlowLayout fl_pnlBotonesDoc = (FlowLayout) pnlBotonesDoc.getLayout();
		fl_pnlBotonesDoc.setAlignment(FlowLayout.RIGHT);
		pnlDocumentos.add(pnlBotonesDoc, BorderLayout.SOUTH);
		
		btnNuevoDoc = new JButton("Agregar Nuevo");
		pnlBotonesDoc.add(btnNuevoDoc);
		
		btnModificarDoc = new JButton("Buscar Documento");
		pnlBotonesDoc.add(btnModificarDoc);
		
		btnEliminarDoc = new JButton("Eliminar");
		btnEliminarDoc.setActionCommand("EliminarDocumento");
		pnlBotonesDoc.add(btnEliminarDoc);
		
		JPanel pnlFamiliares = new JPanel();
		pnlFamiliares.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "Lista de Familiares", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDoc_Familiares.add(pnlFamiliares);
		pnlFamiliares.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		pnlFamiliares.add(scrollPane_1, BorderLayout.CENTER);
		
		tableFamiliares = new JTable();
		scrollPane_1.setViewportView(tableFamiliares);
		
		JPanel pnlBotonesDocumentos = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) pnlBotonesDocumentos.getLayout();
		flowLayout_3.setAlignment(FlowLayout.RIGHT);
		pnlFamiliares.add(pnlBotonesDocumentos, BorderLayout.SOUTH);
		
		btnNuevoFamiliar = new JButton("Agregar Nuevo");
		pnlBotonesDocumentos.add(btnNuevoFamiliar);
		
		btnModificarFamiliar = new JButton("Buscar Familiar");
		pnlBotonesDocumentos.add(btnModificarFamiliar);
		
		btnEliminarFamiliar = new JButton("Eliminar");
		btnEliminarFamiliar.setActionCommand("EliminarFamiliar");
		pnlBotonesDocumentos.add(btnEliminarFamiliar);
		
		pnlBusqueda = new JPanel();
		tabbedPane.addTab("Busqueda", null, pnlBusqueda, null);
		pnlBusqueda.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlTopBusqueda = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) pnlTopBusqueda.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		pnlBusqueda.add(pnlTopBusqueda, BorderLayout.NORTH);
		
		JLabel lblTextoDeBusqueda = new JLabel("Texto de Busqueda");
		pnlTopBusqueda.add(lblTextoDeBusqueda);
		
		txtBusqueda = new JTextField();
		txtBusqueda.setActionCommand("Buscar");
		pnlTopBusqueda.add(txtBusqueda);
		txtBusqueda.setColumns(20);
		
		btnBuscar = new JButton("Buscar");
		pnlTopBusqueda.add(btnBuscar);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		pnlBusqueda.add(scrollPane_2, BorderLayout.CENTER);
		
		tablePersonas = new JTable();
		scrollPane_2.setColumnHeaderView(tablePersonas);
		
		JPanel pnlInferior = new JPanel();
		contentPane.add(pnlInferior, BorderLayout.SOUTH);
		pnlInferior.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();		
		pnlInferior.add(panel, BorderLayout.CENTER);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setMargin(new Insets(2, 1, 2, 1));
//		btnNuevo.setIcon(new ImageIcon(FComidas.class.getResource("/imagenes/BOTONES/Nuevo01.png")));
		panel.add(btnNuevo);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setMargin(new Insets(2, 1, 2, 1));
//		btnAceptar.setIcon(new ImageIcon(FComidas.class.getResource("/imagenes/BOTONES/Aceptar01.png")));
		panel.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setMargin(new Insets(2, 1, 2, 1));
//		btnCancelar.setIcon(new ImageIcon(FComidas.class.getResource("/imagenes/BOTONES/Cancelar01.png")));
		panel.add(btnCancelar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setMargin(new Insets(2, 1, 2, 1));
//		btnModificar.setIcon(new ImageIcon(FComidas.class.getResource("/imagenes/BOTONES/Actualizar01.png")));
		panel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setMargin(new Insets(2, 1, 2, 1));
//		btnEliminar.setIcon(new ImageIcon(FComidas.class.getResource("/imagenes/BOTONES/Eliminar01.png")));
		panel.add(btnEliminar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setMargin(new Insets(2, 1, 2, 1));
//		btnCerrar.setIcon(new ImageIcon(FComidas.class.getResource("/imagenes/BOTONES/Cerrar01.png")));
		panel.add(btnCerrar);
		
		btnReporte = new JButton("Reporte");
		panel.add(btnReporte);
		
		JPanel pnlDatosPresentacion = new JPanel();
		pnlDatosPresentacion.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		FlowLayout flowLayout_1 = (FlowLayout) pnlDatosPresentacion.getLayout();
		flowLayout_1.setVgap(0);
		flowLayout_1.setHgap(0);
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		pnlInferior.add(pnlDatosPresentacion, BorderLayout.SOUTH);
		
		lblPresentacion = new JLabel("Codigo Kardex : 25   Codigo Personal : 35   Fecha Registro : 18/12/2000");
		lblPresentacion.setFont(new Font("Arial Black", Font.BOLD, 12));
		pnlDatosPresentacion.add(lblPresentacion);
		
		control.onFormShown();
	}

	public JTextField getTxtNroKardex() {
		return txtNroKardex;
	}

	public JTextField getTxtPresonaIngreso() {
		return txtPresonaIngreso;
	}

	public JTextField getTxtPersonaEgreso() {
		return txtPersonaEgreso;
	}

	public JTextField getTxtNombreKardex() {
		return txtNombreKardex;
	}

	public JTextField getTxtEdad() {
		return txtEdad;
	}

	public JTable getTableDocumentos() {
		return tableDocumentos;
	}

	public JTable getTableFamiliares() {
		return tableFamiliares;
	}

	public JTable getTablePersonas() {
		return tablePersonas;
	}

	public JTextField getTxtBusqueda() {
		return txtBusqueda;
	}

	public JDateChooser getDateFechaIngreso() {
		return dateFechaIngreso;
	}

	public JComboBox<Institucion> getcBoxInstitucion() {
		return cBoxInstitucion;
	}

	public JButton getBtnAgregarInst() {
		return btnAgregarInst;
	}

	public JTextArea getTxtMotivoIngreso() {
		return txtMotivoIngreso;
	}

	public JButton getBtnBuscarPersonaIngreso() {
		return btnBuscarPersonaIngreso;
	}

	public JTextArea getTxtMotivoEgreso() {
		return txtMotivoEgreso;
	}

	public JButton getBtnBuscarPersonaEgreso() {
		return btnBuscarPersonaEgreso;
	}

	public JButton getBtnAgregarTrabSocial() {
		return btnAgregarTrabSocial;
	}

	public JDateChooser getDateFechaNac() {
		return dateFechaNac;
	}

	public JComboBox<Pais> getcBoxPais() {
		return cBoxPais;
	}

	public JComboBox<Departamento> getcBoxDepartamento() {
		return cBoxDepartamento;
	}

	public JComboBox<Provincia> getcBoxProvincia() {
		return cBoxProvincia;
	}

	public JComboBox<Lugar> getcBoxLugar() {
		return cBoxLugar;
	}

	public JButton getBtnNuevoDoc() {
		return btnNuevoDoc;
	}

	public JButton getBtnModificarDoc() {
		return btnModificarDoc;
	}

	public JButton getBtnEliminarDoc() {
		return btnEliminarDoc;
	}

	public JButton getBtnNuevoFamiliar() {
		return btnNuevoFamiliar;
	}

	public JButton getBtnModificarFamiliar() {
		return btnModificarFamiliar;
	}

	public JButton getBtnEliminarFamiliar() {
		return btnEliminarFamiliar;
	}

	public PnlPersonas getPnlPersonales() {
		return pnlPersonales;
	}

	public JPanel getPnlKardex() {
		return pnlKardex;
	}

	public JPanel getPnlDatosNacimiento() {
		return pnlDatosNacimiento;
	}

	public JPanel getPnlDoc_Familiares() {
		return pnlDoc_Familiares;
	}

	public JPanel getPnlBusqueda() {
		return pnlBusqueda;
	}

	public JComboBox<Persona> getcBoxTrabajadoraSocial() {
		return cBoxTrabajadoraSocial;
	}

	public JButton getBtnNuevo() {
		return btnNuevo;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public JButton getBtnCerrar() {
		return btnCerrar;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public JButton getBtnAgregarPersonaIngreso() {
		return btnAgregarPersonaIngreso;
	}

	public JButton getBtnAgregarPersonaEgreso() {
		return btnAgregarPersonaEgreso;
	}

	public JLabel getLblPresentacion() {
		return lblPresentacion;
	}

	public JButton getBtnReporte() {
		return btnReporte;
	}
	
	
	

}
