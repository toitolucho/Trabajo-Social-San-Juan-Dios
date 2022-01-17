package org.quarkbit.trabajosocialsanjuan.formularios;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import org.quarkbit.trabajosocialsanjuan.controller.CFInformePsicologico;

import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class FInformePsicologico extends JDialog {
	private JTextArea txtMotivoConsulta;
	private JTextArea txtInstrumentos;
	private JTextArea txtAntecedentes;
	private JTextArea txtAspectosRelevantes;
	private JTextArea txtConductasObservadas;
	private JTextArea txtMotricidadGruesa;
	private JTextArea txtMotrizFino;
	private JTextArea txtAudicionLenguaje;
	private JTextArea txtPersonalSocial;
	private JTextArea txtDiagnostico;
	private JTextArea txtRecomendaciones;
	private JLabel lblEtiquetaInforme;
	private JLabel txtDatosNino;
	private JButton btnNuevo;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnBuscar;
	private JButton btnReporte;
	private JButton btnCerrar;
	public JLabel lblLblnroinforme;
	public CFInformePsicologico control;
	private JDateChooser dateFechaRegistro;
	private JTable tableHistorial;
	private JTextField txtTextobusqueda;
	private JDateChooser dateFechaInicio;
	private JDateChooser dateFechaFin;
	private JButton btnBuscarHistorial;
	private JTabbedPane tabbedPane;

	

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FInformePsicologico dialog = new FInformePsicologico(null);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public FInformePsicologico(JFrame owner) {
		super(owner, true);
		setTitle("Informe Psicologico");
		setBounds(100, 100, 762, 725);
		
		control = new CFInformePsicologico(this);
		
		JPanel pnlINformacion = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnlINformacion.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		pnlINformacion.setPreferredSize(new Dimension(10, 50));
		getContentPane().add(pnlINformacion, BorderLayout.NORTH);
		
		lblEtiquetaInforme = new JLabel("Nro de Informe :");
		pnlINformacion.add(lblEtiquetaInforme);
		
		lblLblnroinforme = new JLabel("1");
		lblLblnroinforme.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnlINformacion.add(lblLblnroinforme);
		
		txtDatosNino = new JLabel("Nombre Completo : ................................................................... Fecha Nac..................................... Edad..............");
		pnlINformacion.add(txtDatosNino);
		
		JPanel pnlBotones = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) pnlBotones.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(pnlBotones, BorderLayout.SOUTH);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setIcon(new ImageIcon(FComidas.class.getResource("/imagenes/BOTONES/Nuevo01.png")));
		pnlBotones.add(btnNuevo);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setIcon(new ImageIcon(FComidas.class.getResource("/imagenes/BOTONES/Aceptar01.png")));
		pnlBotones.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(FComidas.class.getResource("/imagenes/BOTONES/Cancelar01.png")));
		pnlBotones.add(btnCancelar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setIcon(new ImageIcon(FComidas.class.getResource("/imagenes/BOTONES/Actualizar01.png")));
		pnlBotones.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(FComidas.class.getResource("/imagenes/BOTONES/Eliminar01.png")));
		pnlBotones.add(btnEliminar);
		
		btnBuscar = new JButton("Buscar");
		pnlBotones.add(btnBuscar);
		
		btnReporte = new JButton("Reporte");
		pnlBotones.add(btnReporte);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon(FComidas.class.getResource("/imagenes/BOTONES/Cerrar01.png")));
		pnlBotones.add(btnCerrar);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel pnlCentral = new JPanel();
		tabbedPane.addTab("Registro", null, pnlCentral, null);
		FlowLayout flowLayout_2 = (FlowLayout) pnlCentral.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		pnlCentral.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Datos del Informe", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblFechaDeConsulta = new JLabel("Fecha de Consulta: ");
		lblFechaDeConsulta.setPreferredSize(new Dimension(160, 16));
		pnlCentral.add(lblFechaDeConsulta);
		
		dateFechaRegistro = new JDateChooser();
		dateFechaRegistro.setPreferredSize(new Dimension(150, 22));
		dateFechaRegistro.setDateFormatString("dd-MM-yyyy");
		dateFechaRegistro.getCalendarButton().setPreferredSize(new Dimension(30, 17));
		pnlCentral.add(dateFechaRegistro);
		
		JLabel lblNewLabel = new JLabel("                                                                                 ");
		pnlCentral.add(lblNewLabel);
		
		JLabel lblMotivoDeConsulta = new JLabel("Motivo de Consulta: ");
		lblMotivoDeConsulta.setPreferredSize(new Dimension(160, 16));
		pnlCentral.add(lblMotivoDeConsulta);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pnlCentral.add(scrollPane);
		
		txtMotivoConsulta = new JTextArea();
		txtMotivoConsulta.setRows(2);
		scrollPane.setViewportView(txtMotivoConsulta);
		txtMotivoConsulta.setColumns(48);
		
		JLabel lblInstrumentosYFuentes = new JLabel("Instrumentos y Fuentes:");
		lblInstrumentosYFuentes.setPreferredSize(new Dimension(160, 16));
		pnlCentral.add(lblInstrumentosYFuentes);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pnlCentral.add(scrollPane_1);
		
		txtInstrumentos = new JTextArea();
		scrollPane_1.setViewportView(txtInstrumentos);
		txtInstrumentos.setRows(2);
		txtInstrumentos.setColumns(48);
		
		JLabel lblAntecedentesGral = new JLabel("Antecedentes Gral.:");
		lblAntecedentesGral.setPreferredSize(new Dimension(160, 16));
		pnlCentral.add(lblAntecedentesGral);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pnlCentral.add(scrollPane_2);
		
		txtAntecedentes = new JTextArea();
		scrollPane_2.setViewportView(txtAntecedentes);
		txtAntecedentes.setRows(2);
		txtAntecedentes.setColumns(48);
		
		JLabel lblAspectosRelevantes = new JLabel("Aspectos Relevantes: ");
		lblAspectosRelevantes.setPreferredSize(new Dimension(160, 16));
		pnlCentral.add(lblAspectosRelevantes);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pnlCentral.add(scrollPane_3);
		
		txtAspectosRelevantes = new JTextArea();
		scrollPane_3.setViewportView(txtAspectosRelevantes);
		txtAspectosRelevantes.setRows(2);
		txtAspectosRelevantes.setColumns(48);
		
		JLabel lblConductasObservadas = new JLabel("Conductas Observadas: ");
		lblConductasObservadas.setPreferredSize(new Dimension(160, 16));
		pnlCentral.add(lblConductasObservadas);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pnlCentral.add(scrollPane_4);
		
		txtConductasObservadas = new JTextArea();
		scrollPane_4.setViewportView(txtConductasObservadas);
		txtConductasObservadas.setRows(2);
		txtConductasObservadas.setColumns(48);
		
		JLabel lblMotricidadGruesa = new JLabel("Motricidad Gruesa: ");
		lblMotricidadGruesa.setPreferredSize(new Dimension(160, 16));
		pnlCentral.add(lblMotricidadGruesa);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pnlCentral.add(scrollPane_5);
		
		txtMotricidadGruesa = new JTextArea();
		scrollPane_5.setViewportView(txtMotricidadGruesa);
		txtMotricidadGruesa.setRows(1);
		txtMotricidadGruesa.setColumns(48);
		
		JLabel lblMotrizFinoadaptativa = new JLabel("Motriz Fino-Adaptativa: ");
		lblMotrizFinoadaptativa.setPreferredSize(new Dimension(160, 16));
		pnlCentral.add(lblMotrizFinoadaptativa);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pnlCentral.add(scrollPane_6);
		
		txtMotrizFino = new JTextArea();
		scrollPane_6.setViewportView(txtMotrizFino);
		txtMotrizFino.setRows(1);
		txtMotrizFino.setColumns(48);
		
		JLabel lblAudicinLenguaje = new JLabel("Audicion Lenguaje: ");
		lblAudicinLenguaje.setPreferredSize(new Dimension(160, 16));
		pnlCentral.add(lblAudicinLenguaje);
		
		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pnlCentral.add(scrollPane_7);
		
		txtAudicionLenguaje = new JTextArea();
		scrollPane_7.setViewportView(txtAudicionLenguaje);
		txtAudicionLenguaje.setRows(1);
		txtAudicionLenguaje.setColumns(48);
		
		JLabel lblPersonalsocial = new JLabel("Personal-Social: ");
		lblPersonalsocial.setPreferredSize(new Dimension(160, 16));
		pnlCentral.add(lblPersonalsocial);
		
		JScrollPane scrollPane_8 = new JScrollPane();
		scrollPane_8.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pnlCentral.add(scrollPane_8);
		
		txtPersonalSocial = new JTextArea();
		scrollPane_8.setViewportView(txtPersonalSocial);
		txtPersonalSocial.setRows(1);
		txtPersonalSocial.setColumns(48);
		
		JLabel lblDiagnostico = new JLabel("Diagnostico:");
		lblDiagnostico.setPreferredSize(new Dimension(160, 16));
		pnlCentral.add(lblDiagnostico);
		
		JScrollPane scrollPane_9 = new JScrollPane();
		scrollPane_9.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pnlCentral.add(scrollPane_9);
		
		txtDiagnostico = new JTextArea();
		scrollPane_9.setViewportView(txtDiagnostico);
		txtDiagnostico.setRows(1);
		txtDiagnostico.setColumns(48);
		
		JLabel lblRecomendacionesYoSugerencias = new JLabel("Recomendaciones:");
		lblRecomendacionesYoSugerencias.setPreferredSize(new Dimension(160, 16));
		pnlCentral.add(lblRecomendacionesYoSugerencias);
		
		JScrollPane scrollPane_10 = new JScrollPane();
		scrollPane_10.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pnlCentral.add(scrollPane_10);
		
		txtRecomendaciones = new JTextArea();
		scrollPane_10.setViewportView(txtRecomendaciones);
		txtRecomendaciones.setRows(1);
		txtRecomendaciones.setColumns(48);
		
		JPanel pnlHistorialInformes = new JPanel();
		tabbedPane.addTab("Historial Informes", null, pnlHistorialInformes, null);
		pnlHistorialInformes.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlOpcionesBusqueda4 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) pnlOpcionesBusqueda4.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		pnlHistorialInformes.add(pnlOpcionesBusqueda4, BorderLayout.NORTH);
		
		JLabel lblDel = new JLabel("Del");
		pnlOpcionesBusqueda4.add(lblDel);
		
		dateFechaInicio = new JDateChooser();
		pnlOpcionesBusqueda4.add(dateFechaInicio);
		
		JLabel lblAl = new JLabel("al");
		pnlOpcionesBusqueda4.add(lblAl);
		
		dateFechaFin = new JDateChooser();
		pnlOpcionesBusqueda4.add(dateFechaFin);
		
		JLabel lblTextoBusqueda = new JLabel("Texto Busqueda");
		pnlOpcionesBusqueda4.add(lblTextoBusqueda);
		
		txtTextobusqueda = new JTextField();
		pnlOpcionesBusqueda4.add(txtTextobusqueda);
		txtTextobusqueda.setColumns(15);
		
		btnBuscarHistorial = new JButton("Buscar");
		btnBuscarHistorial.setActionCommand("BuscarHistorial");
		pnlOpcionesBusqueda4.add(btnBuscarHistorial);
		
		JScrollPane scrollPane3 = new JScrollPane();
		
		
		tableHistorial = new JTable();
		pnlHistorialInformes.add(scrollPane3, BorderLayout.CENTER);
		scrollPane3.setViewportView(tableHistorial);
		
		control.onLoad();

	}

	public JTextArea getTxtMotivoConsulta() {
		return txtMotivoConsulta;
	}

	public JTextArea getTxtInstrumentos() {
		return txtInstrumentos;
	}

	public JTextArea getTxtAntecedentes() {
		return txtAntecedentes;
	}

	public JTextArea getTxtAspectosRelevantes() {
		return txtAspectosRelevantes;
	}

	public JTextArea getTxtConductasObservadas() {
		return txtConductasObservadas;
	}

	public JTextArea getTxtMotricidadGruesa() {
		return txtMotricidadGruesa;
	}

	public JTextArea getTxtMotrizFino() {
		return txtMotrizFino;
	}

	public JTextArea getTxtAudicionLenguaje() {
		return txtAudicionLenguaje;
	}

	public JTextArea getTxtPersonalSocial() {
		return txtPersonalSocial;
	}

	public JTextArea getTxtDiagnostico() {
		return txtDiagnostico;
	}

	public JTextArea getTxtRecomendaciones() {
		return txtRecomendaciones;
	}

	public JLabel getLblNroInforme() {
		return lblEtiquetaInforme;
	}

	public JLabel getTxtDatosNino() {
		return txtDatosNino;
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

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public JButton getBtnReporte() {
		return btnReporte;
	}

	public JButton getBtnCerrar() {
		return btnCerrar;
	}

	public JLabel getLblEtiquetaInforme() {
		return lblEtiquetaInforme;
	}

	public JLabel getLblLblnroinforme() {
		return lblLblnroinforme;
	}

	public CFInformePsicologico getControl() {
		return control;
	}

	public JDateChooser getDateFechaRegistro() {
		return dateFechaRegistro;
	}

	public JTable getTableHistorial() {
		return tableHistorial;
	}

	public JTextField getTxtTextobusqueda() {
		return txtTextobusqueda;
	}

	public JDateChooser getDateFechaInicio() {
		return dateFechaInicio;
	}

	public JDateChooser getDateFechaFin() {
		return dateFechaFin;
	}

	public JButton getBtnBuscarHistorial() {
		return btnBuscarHistorial;
	}
	
	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}
	
}
