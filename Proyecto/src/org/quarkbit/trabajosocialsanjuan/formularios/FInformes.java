package org.quarkbit.trabajosocialsanjuan.formularios;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
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
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import org.quarkbit.trabajosocialsanjuan.controller.CFInformes;

import com.toedter.calendar.JDateChooser;

public class FInformes extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtA;
	private JTextField txtVia;
	private JTextField txtDe01;
	private JTextField txtDe02;
	private JTextField txtDe03;
	private JTextField txtReferencia;
	private JTextField txtReferenciaCaso;
	private JTextField txtSituacHabitacional;
	private JTextField txtIntMedioFamiliar;
	private JTextField txtDesarrolloEmocional;
	private JTextArea txtRefCaso;
	private JButton btnAgregarA;
	private JButton btnBuscarA;
	private JButton btnAgregarVia;
	private JButton btnBuscarVia;
	private JButton btnAgregarDe01;
	private JButton btnBuscarDe01;
	private JButton btnAgregarDe02;
	private JButton btnBuscarDe02;
	private JButton btnAgregarDe03;
	private JButton btnBuscarDe03;
	private JComboBox<String> cBoxTipo;
	private JDateChooser dateFechaRegistro;
	private JTextArea txtDiagnostico;
	private JTextArea txtSugerencia;
	private JButton btnNuevo;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnCerrar;
	private JButton btnReporte;
	private JDateChooser dateFechaInicio;
	private JDateChooser dateFechaFin;
	private JButton btnTextoRefCaso;
	private JButton btnTextoSitHabit;
	private JButton btnTextoIntMedioFam;
	private JButton btnTextoDesEmocional;
	private JTextArea txtHistSocial;
	private JTextArea txtSitActual;
	private JTextArea txtFuenteInform;
	private JTextArea txtFuenteInformacion;
	private JTextArea txtSituacionActual;
	private JTextArea txtDescripcionCaso;
	private JTextArea txtDocAdjuntos;
	public CFInformes control;
	private JTabbedPane tabbedPane;
	private JPanel pnlDatosNinos;
	private JPanel pnlPSSegConvivencia;
	private JPanel pnlPSSeguimiento;
	private JPanel pnlInfSocial;
	private JPanel pnlInfSocialSeguim;
	private JPanel pnlFichaSocial;
	private JButton btnBuscar;
	private JLabel lblDatosNino;
	private JTable table;
	private JPanel pnlSuperior;
	private JLabel lblNroDeInforme;
	public JLabel lblNroInforme;
	private JLabel lblDiagnosticoPsicosocial;
	private JScrollPane scrollPane_1;
	private JTextArea txtDiagnosticoPsicosocial;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FInformes dialog = new FInformes(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FInformes(JFrame owner) {
		super(owner, true);
		setTitle("Informes");
		setBounds(100, 100, 756, 726);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Datos Generales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		control = new CFInformes(this);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel pnlDatosGenerales = new JPanel();
			FlowLayout fl_pnlDatosGenerales = (FlowLayout) pnlDatosGenerales.getLayout();
			fl_pnlDatosGenerales.setVgap(1);
			fl_pnlDatosGenerales.setHgap(10);
			fl_pnlDatosGenerales.setAlignment(FlowLayout.LEFT);
			pnlDatosGenerales.setPreferredSize(new Dimension(200, 245));
			contentPanel.add(pnlDatosGenerales, BorderLayout.NORTH);
			{
				JLabel lblA = new JLabel("A:");
				pnlDatosGenerales.add(lblA);
				lblA.setPreferredSize(new Dimension(130, 16));
			}
			{
				txtA = new JTextField();
				pnlDatosGenerales.add(txtA);
				txtA.setColumns(30);
			}
			{
				btnAgregarA = new JButton("+");
				btnAgregarA.setActionCommand("agregarA");
				pnlDatosGenerales.add(btnAgregarA);
				btnAgregarA.setMargin(new Insets(2, 5, 2, 5));
			}
			{
				btnBuscarA = new JButton("...");
				btnBuscarA.setActionCommand("buscarA");
				pnlDatosGenerales.add(btnBuscarA);
				btnBuscarA.setMargin(new Insets(2, 5, 2, 5));
			}
			{
				JLabel lblVia = new JLabel("VIA:");
				pnlDatosGenerales.add(lblVia);
				lblVia.setPreferredSize(new Dimension(130, 16));
			}
			{
				txtVia = new JTextField();
				pnlDatosGenerales.add(txtVia);
				txtVia.setColumns(30);
			}
			{
				btnAgregarVia = new JButton("+");
				btnAgregarVia.setActionCommand("agregarVia");
				pnlDatosGenerales.add(btnAgregarVia);
				btnAgregarVia.setMargin(new Insets(2, 5, 2, 5));
			}
			{
				btnBuscarVia = new JButton("...");
				btnBuscarVia.setActionCommand("buscarVia");
				pnlDatosGenerales.add(btnBuscarVia);
				btnBuscarVia.setMargin(new Insets(2, 5, 2, 5));
			}
			{
				JLabel lblDe = new JLabel("DE:");
				pnlDatosGenerales.add(lblDe);
				lblDe.setPreferredSize(new Dimension(130, 16));
			}
			{
				txtDe01 = new JTextField();
				pnlDatosGenerales.add(txtDe01);
				txtDe01.setColumns(30);
			}
			{
				btnAgregarDe01 = new JButton("+");
				btnAgregarDe01.setActionCommand("agregarDe01");
				pnlDatosGenerales.add(btnAgregarDe01);
				btnAgregarDe01.setMargin(new Insets(2, 5, 2, 5));
			}
			{
				btnBuscarDe01 = new JButton("...");
				btnBuscarDe01.setActionCommand("buscarDe01");
				pnlDatosGenerales.add(btnBuscarDe01);
				btnBuscarDe01.setMargin(new Insets(2, 5, 2, 5));
			}
			{
				JLabel label = new JLabel("  ");
				pnlDatosGenerales.add(label);
				label.setPreferredSize(new Dimension(130, 16));
			}
			{
				txtDe02 = new JTextField();
				pnlDatosGenerales.add(txtDe02);
				txtDe02.setColumns(30);
			}
			{
				btnAgregarDe02 = new JButton("+");
				btnAgregarDe02.setActionCommand("agregarDe02");
				pnlDatosGenerales.add(btnAgregarDe02);
				btnAgregarDe02.setMargin(new Insets(2, 5, 2, 5));
			}
			{
				btnBuscarDe02 = new JButton("...");
				btnBuscarDe02.setActionCommand("buscarDe02");
				pnlDatosGenerales.add(btnBuscarDe02);
				btnBuscarDe02.setMargin(new Insets(2, 5, 2, 5));
			}
			{
				JLabel label = new JLabel("  ");
				pnlDatosGenerales.add(label);
				label.setPreferredSize(new Dimension(130, 16));
			}
			{
				txtDe03 = new JTextField();
				pnlDatosGenerales.add(txtDe03);
				txtDe03.setColumns(30);
			}
			{
				btnAgregarDe03 = new JButton("+");
				btnAgregarDe03.setActionCommand("agregarDe03");
				pnlDatosGenerales.add(btnAgregarDe03);
				btnAgregarDe03.setMargin(new Insets(2, 5, 2, 5));
			}
			{
				btnBuscarDe03 = new JButton("...");
				btnBuscarDe03.setActionCommand("buscarDe03");
				pnlDatosGenerales.add(btnBuscarDe03);
				btnBuscarDe03.setMargin(new Insets(2, 5, 2, 5));
			}
			{
				JLabel lblRef = new JLabel("REF.:");
				pnlDatosGenerales.add(lblRef);
				lblRef.setPreferredSize(new Dimension(130, 16));
			}
			{
				txtReferencia = new JTextField();
				pnlDatosGenerales.add(txtReferencia);
				txtReferencia.setColumns(36);
			}
			{
				lblNewLabel = new JLabel("");
				lblNewLabel.setPreferredSize(new Dimension(100, 14));
				pnlDatosGenerales.add(lblNewLabel);
			}
			{
				JLabel lblFecha = new JLabel("FECHA:");
				pnlDatosGenerales.add(lblFecha);
				lblFecha.setPreferredSize(new Dimension(130, 16));
			}
			{
				dateFechaRegistro = new JDateChooser();
				dateFechaRegistro.setDateFormatString("dd-MM-yyyy");
				pnlDatosGenerales.add(dateFechaRegistro);
			}
			{
				JLabel lblTipo = new JLabel("TIPO:");
				lblTipo.setPreferredSize(new Dimension(35, 16));
				pnlDatosGenerales.add(lblTipo);
			}
			{
				cBoxTipo = new JComboBox<String>();
				cBoxTipo.setModel(new DefaultComboBoxModel<String>(new String[] {"PSICOSOCIAL DE SEGUIMIENTO DE CONVIVENCIA", "PSICOSOCIAL DE SEGUIMIENTO", "INFORME SOCIAL", "INFORME SOCIAL DE SEGUIMIENTO", "FICHA SOCIAL"}));
				pnlDatosGenerales.add(cBoxTipo);
			}
		}
		{
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			contentPanel.add(tabbedPane, BorderLayout.CENTER);
			{
				pnlDatosNinos = new JPanel();
				pnlDatosNinos.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				tabbedPane.addTab("Datos Ni\u00F1o", null, pnlDatosNinos, null);
				pnlDatosNinos.setLayout(new BorderLayout(0, 0));
				{
					lblDatosNino = new JLabel("Nombre Completo : ................................................................... Fecha Nac..................................... Edad..............");
					pnlDatosNinos.add(lblDatosNino, BorderLayout.NORTH);
				}
				{
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setViewportBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "GRUPO FAMILIAR", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					pnlDatosNinos.add(scrollPane,  BorderLayout.CENTER);
					{
						table = new JTable();
						scrollPane.setViewportView(table);
					}
				}
			}
			{
				pnlPSSegConvivencia = new JPanel();
				FlowLayout fl_pnlPSSegConvivencia = (FlowLayout) pnlPSSegConvivencia.getLayout();
				fl_pnlPSSegConvivencia.setVgap(1);
				fl_pnlPSSegConvivencia.setHgap(10);
				fl_pnlPSSegConvivencia.setAlignment(FlowLayout.LEFT);
				tabbedPane.addTab("PS . SEG. DE CONVIVENCIA", null, pnlPSSegConvivencia, null);
				{
					JPanel pnlFechaSeguimiento = new JPanel();
					pnlFechaSeguimiento.setPreferredSize(new Dimension(600, 60));
					FlowLayout flowLayout = (FlowLayout) pnlFechaSeguimiento.getLayout();
					flowLayout.setHgap(15);
					pnlFechaSeguimiento.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Fechas de Seguimiento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					pnlPSSegConvivencia.add(pnlFechaSeguimiento);
					{
						JLabel lblFechaInicio = new JLabel("Fecha Inicio");
						pnlFechaSeguimiento.add(lblFechaInicio);
					}
					{
						dateFechaInicio = new JDateChooser();
						dateFechaInicio.setDateFormatString("dd-MM-yyyy");
						pnlFechaSeguimiento.add(dateFechaInicio);
					}
					{
						JLabel lblFechaFin = new JLabel("Fecha Fin");
						pnlFechaSeguimiento.add(lblFechaFin);
					}
					{
						dateFechaFin = new JDateChooser();
						dateFechaFin.setDateFormatString("dd-MM-yyyy");
						pnlFechaSeguimiento.add(dateFechaFin);
					}
				}
				{
					JLabel lblReferenciaDelCaso = new JLabel("Referencia del Caso.:");
					lblReferenciaDelCaso.setPreferredSize(new Dimension(145, 16));
					pnlPSSegConvivencia.add(lblReferenciaDelCaso);
				}
				{
					txtReferenciaCaso = new JTextField();
					txtReferenciaCaso.setColumns(40);
					pnlPSSegConvivencia.add(txtReferenciaCaso);
				}
				{
					btnTextoRefCaso = new JButton("...");
					btnTextoRefCaso.setActionCommand("TextoRefCaso");
					btnTextoRefCaso.setMargin(new Insets(2, 5, 2, 5));
					pnlPSSegConvivencia.add(btnTextoRefCaso);
				}
				{
					JLabel lblSitHabitacional = new JLabel("Sit. Habitacional");
					lblSitHabitacional.setPreferredSize(new Dimension(145, 16));
					pnlPSSegConvivencia.add(lblSitHabitacional);
				}
				{
					txtSituacHabitacional = new JTextField();
					txtSituacHabitacional.setColumns(40);
					pnlPSSegConvivencia.add(txtSituacHabitacional);
				}
				{
					btnTextoSitHabit = new JButton("...");
					btnTextoSitHabit.setActionCommand("TextoSitHabit");
					btnTextoSitHabit.setMargin(new Insets(2, 5, 2, 5));
					pnlPSSegConvivencia.add(btnTextoSitHabit);
				}
				{
					JLabel lblIntEnEl = new JLabel("Int. en el medio familiar");
					lblIntEnEl.setPreferredSize(new Dimension(145, 16));
					pnlPSSegConvivencia.add(lblIntEnEl);
				}
				{
					txtIntMedioFamiliar = new JTextField();
					txtIntMedioFamiliar.setColumns(40);
					pnlPSSegConvivencia.add(txtIntMedioFamiliar);
				}
				{
					btnTextoIntMedioFam = new JButton("...");
					btnTextoIntMedioFam.setActionCommand("TextoIntMedioFam");
					btnTextoIntMedioFam.setMargin(new Insets(2, 5, 2, 5));
					pnlPSSegConvivencia.add(btnTextoIntMedioFam);
				}
				{
					JLabel lblDesarrolloEfemocional = new JLabel("Desarrollo Ef.Emocional");
					lblDesarrolloEfemocional.setPreferredSize(new Dimension(145, 16));
					pnlPSSegConvivencia.add(lblDesarrolloEfemocional);
				}
				{
					txtDesarrolloEmocional = new JTextField();
					txtDesarrolloEmocional.setColumns(40);
					pnlPSSegConvivencia.add(txtDesarrolloEmocional);
				}
				{
					btnTextoDesEmocional = new JButton("...");
					btnTextoDesEmocional.setActionCommand("TextoDesEmocional");
					btnTextoDesEmocional.setMargin(new Insets(2, 5, 2, 5));
					pnlPSSegConvivencia.add(btnTextoDesEmocional);
				}
			}
			{
				pnlPSSeguimiento = new JPanel();
				FlowLayout fl_pnlPSSeguimiento = (FlowLayout) pnlPSSeguimiento.getLayout();
				fl_pnlPSSeguimiento.setAlignment(FlowLayout.LEFT);
				fl_pnlPSSeguimiento.setVgap(20);
				fl_pnlPSSeguimiento.setHgap(20);
				tabbedPane.addTab("PS. SEGUIMIENTO", null, pnlPSSeguimiento, null);
				{
					JLabel label = new JLabel("Referencia del Caso.:");
					label.setPreferredSize(new Dimension(145, 16));
					pnlPSSeguimiento.add(label);
				}
				
				{
					txtRefCaso = new JTextArea();
					txtRefCaso.setRows(1);					
					txtRefCaso.setColumns(35);
					
				}
				
				{
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					scrollPane.setViewportView(txtRefCaso);
					pnlPSSeguimiento.add(scrollPane);
				}
				{
					lblDiagnosticoPsicosocial = new JLabel("Diagnostico Psicosocial.:");
					lblDiagnosticoPsicosocial.setPreferredSize(new Dimension(145, 16));
					pnlPSSeguimiento.add(lblDiagnosticoPsicosocial);
				}
				
				{
					txtDiagnosticoPsicosocial = new JTextArea();
					txtDiagnosticoPsicosocial.setRows(1);
					txtDiagnosticoPsicosocial.setColumns(35);

				}
				{
					scrollPane_1 = new JScrollPane();
					scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					scrollPane_1.setViewportView(txtDiagnosticoPsicosocial);
					pnlPSSeguimiento.add(scrollPane_1);
				}
			}
			{
				pnlInfSocial = new JPanel();
				FlowLayout fl_pnlInfSocial = (FlowLayout) pnlInfSocial.getLayout();
				fl_pnlInfSocial.setAlignment(FlowLayout.LEFT);
				fl_pnlInfSocial.setVgap(15);
				tabbedPane.addTab("INF. SOCIAL", null, pnlInfSocial, null);
				{
					JLabel lblHistoriaSocial = new JLabel("Historia Social :");
					lblHistoriaSocial.setPreferredSize(new Dimension(130, 16));
					pnlInfSocial.add(lblHistoriaSocial);
				}
				{
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
					scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					pnlInfSocial.add(scrollPane);
					{
						txtHistSocial = new JTextArea();
						txtHistSocial.setRows(1);
						txtHistSocial.setColumns(40);
						scrollPane.setViewportView(txtHistSocial);
					}
				}
				{
					JLabel lblSituacinActual = new JLabel("Situacion Actual");
					lblSituacinActual.setPreferredSize(new Dimension(130, 16));
					pnlInfSocial.add(lblSituacinActual);
				}
				{
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
					scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					pnlInfSocial.add(scrollPane);
					{
						txtSitActual = new JTextArea();
						txtSitActual.setRows(1);
						txtSitActual.setColumns(40);
						scrollPane.setViewportView(txtSitActual);
					}
				}
				{
					JLabel lblFuenteDeInformacin = new JLabel("Fuente de Informacion");
					lblFuenteDeInformacin.setPreferredSize(new Dimension(130, 16));
					pnlInfSocial.add(lblFuenteDeInformacin);
				}
				{
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
					scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					pnlInfSocial.add(scrollPane);
					{
						txtFuenteInform = new JTextArea();
						txtFuenteInform.setRows(1);
						txtFuenteInform.setColumns(40);
						scrollPane.setViewportView(txtFuenteInform);
					}
				}
			}
			{
				pnlInfSocialSeguim = new JPanel();
				FlowLayout fl_pnlInfSocialSeguim = (FlowLayout) pnlInfSocialSeguim.getLayout();
				fl_pnlInfSocialSeguim.setAlignment(FlowLayout.LEFT);
				fl_pnlInfSocialSeguim.setVgap(15);
				tabbedPane.addTab("INFORME SOC. DE SEG.", null, pnlInfSocialSeguim, null);
				{
					JLabel lblFuenteDeInf = new JLabel("Fuente de Inf.");
					lblFuenteDeInf.setPreferredSize(new Dimension(100, 16));
					pnlInfSocialSeguim.add(lblFuenteDeInf);
				}
				{
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
					scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					pnlInfSocialSeguim.add(scrollPane);
					{
						txtFuenteInformacion = new JTextArea();
						txtFuenteInformacion.setRows(1);
						txtFuenteInformacion.setColumns(42);
						scrollPane.setViewportView(txtFuenteInformacion);
					}
				}
				{
					JLabel lblSituacinActual_1 = new JLabel("Situacion Actual");
					lblSituacinActual_1.setPreferredSize(new Dimension(100, 16));
					pnlInfSocialSeguim.add(lblSituacinActual_1);
				}
				{
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
					scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					pnlInfSocialSeguim.add(scrollPane);
					{
						txtSituacionActual = new JTextArea();
						txtSituacionActual.setRows(1);
						txtSituacionActual.setColumns(42);
						scrollPane.setViewportView(txtSituacionActual);
					}
				}
			}
			{
				pnlFichaSocial = new JPanel();
				FlowLayout fl_pnlFichaSocial = (FlowLayout) pnlFichaSocial.getLayout();
				fl_pnlFichaSocial.setAlignment(FlowLayout.LEFT);
				fl_pnlFichaSocial.setVgap(15);
				tabbedPane.addTab("FICHA SOCIAL", null, pnlFichaSocial, null);
				{
					JLabel lblDescDelCaso = new JLabel("Desc. del Caso ");
					lblDescDelCaso.setPreferredSize(new Dimension(95, 16));
					pnlFichaSocial.add(lblDescDelCaso);
				}
				{
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
					scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					pnlFichaSocial.add(scrollPane);
					{
						txtDescripcionCaso = new JTextArea();
						txtDescripcionCaso.setRows(1);
						txtDescripcionCaso.setColumns(42);
						scrollPane.setViewportView(txtDescripcionCaso);
					}
				}
				{
					JLabel lblDocAdjuntos = new JLabel("Doc. Adjuntos");
					lblDocAdjuntos.setPreferredSize(new Dimension(95, 16));
					pnlFichaSocial.add(lblDocAdjuntos);
				}
				{
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
					scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					pnlFichaSocial.add(scrollPane);
					{
						txtDocAdjuntos = new JTextArea();
						txtDocAdjuntos.setRows(1);
						txtDocAdjuntos.setColumns(42);
						scrollPane.setViewportView(txtDocAdjuntos);
					}
				}
			}
		}
		{
			JPanel pnlResumen = new JPanel();
			pnlResumen.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "Resumen", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlResumen.setPreferredSize(new Dimension(10, 105));
			FlowLayout flowLayout = (FlowLayout) pnlResumen.getLayout();
			flowLayout.setHgap(10);
			flowLayout.setAlignment(FlowLayout.LEFT);
			contentPanel.add(pnlResumen, BorderLayout.SOUTH);
			{
				JLabel lblDiagnostico = new JLabel("DIAGNOSTICO :");
				lblDiagnostico.setPreferredSize(new Dimension(95, 16));
				pnlResumen.add(lblDiagnostico);
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				pnlResumen.add(scrollPane);
				{
					txtDiagnostico = new JTextArea();
					txtDiagnostico.setRows(1);
					txtDiagnostico.setColumns(45);
					scrollPane.setViewportView(txtDiagnostico);
				}
			}
			{
				JLabel lblSugerencia = new JLabel("SUGERENCIA:");
				lblSugerencia.setPreferredSize(new Dimension(95, 16));
				pnlResumen.add(lblSugerencia);
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				pnlResumen.add(scrollPane);
				{
					txtSugerencia = new JTextArea();
					txtSugerencia.setRows(1);
					txtSugerencia.setColumns(45);
					scrollPane.setViewportView(txtSugerencia);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnNuevo = new JButton("Nuevo");
				btnNuevo.setIcon(new ImageIcon(FComidas.class.getResource("/imagenes/BOTONES/Nuevo01.png")));
				buttonPane.add(btnNuevo);
			}
			{
				btnAceptar = new JButton("Aceptar");
				btnAceptar.setIcon(new ImageIcon(FComidas.class.getResource("/imagenes/BOTONES/Aceptar01.png")));
				buttonPane.add(btnAceptar);
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.setIcon(new ImageIcon(FComidas.class.getResource("/imagenes/BOTONES/Cancelar01.png")));
				buttonPane.add(btnCancelar);
			}
			{
				btnModificar = new JButton("Modificar");
				btnModificar.setIcon(new ImageIcon(FComidas.class.getResource("/imagenes/BOTONES/Actualizar01.png")));
				buttonPane.add(btnModificar);
			}
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.setIcon(new ImageIcon(FComidas.class.getResource("/imagenes/BOTONES/Eliminar01.png")));
				buttonPane.add(btnEliminar);
			}
			{
				btnCerrar = new JButton("Cerrar");
				btnCerrar.setIcon(new ImageIcon(FComidas.class.getResource("/imagenes/BOTONES/Cerrar01.png")));
				buttonPane.add(btnCerrar);
			}
			{
				btnBuscar = new JButton("Buscar");
				buttonPane.add(btnBuscar);
			}
			{
				btnReporte = new JButton("Reporte");
				buttonPane.add(btnReporte);
			}
			{
				pnlSuperior = new JPanel();
				FlowLayout flowLayout = (FlowLayout) pnlSuperior.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				getContentPane().add(pnlSuperior, BorderLayout.NORTH);
				{
					lblNroDeInforme = new JLabel("Nro de Informe :");
					pnlSuperior.add(lblNroDeInforme);
				}
				{
					lblNroInforme = new JLabel("1");
					pnlSuperior.add(lblNroInforme);
				}
			}
			
			control.onFormShown();
		}
	}

	public JTextField getTxtA() {
		return txtA;
	}

	public JTextField getTxtVia() {
		return txtVia;
	}

	public JTextField getTxtDe01() {
		return txtDe01;
	}

	public JTextField getTxtDe02() {
		return txtDe02;
	}

	public JTextField getTxtDe03() {
		return txtDe03;
	}

	public JTextField getTxtReferencia() {
		return txtReferencia;
	}

	public JTextField getTxtReferenciaCaso() {
		return txtReferenciaCaso;
	}

	public JTextField getTxtSituacHabitacional() {
		return txtSituacHabitacional;
	}

	public JTextField getTxtIntMedioFamiliar() {
		return txtIntMedioFamiliar;
	}

	public JTextField getTxtDesarrolloEmocional() {
		return txtDesarrolloEmocional;
	}

	public JTextArea getTxtRefCaso() {
		return txtRefCaso;
	}

	public JButton getBtnAgregarA() {
		return btnAgregarA;
	}

	public JButton getBtnBuscarA() {
		return btnBuscarA;
	}

	public JButton getBtnAgregarVia() {
		return btnAgregarVia;
	}

	public JButton getBtnBuscarVia() {
		return btnBuscarVia;
	}

	public JButton getBtnAgregarDe01() {
		return btnAgregarDe01;
	}

	public JButton getBtnBuscarDe01() {
		return btnBuscarDe01;
	}

	public JButton getBtnAgregarDe02() {
		return btnAgregarDe02;
	}

	public JButton getBtnBuscarDe02() {
		return btnBuscarDe02;
	}

	public JButton getBtnAgregarDe03() {
		return btnAgregarDe03;
	}

	public JButton getBtnBuscarDe03() {
		return btnBuscarDe03;
	}

	public JComboBox<String> getcBoxTipo() {
		return cBoxTipo;
	}

	public JDateChooser getDateFechaRegistro() {
		return dateFechaRegistro;
	}

	public JTextArea getTxtDiagnostico() {
		return txtDiagnostico;
	}

	public JTextArea getTxtSugerencia() {
		return txtSugerencia;
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

	public JButton getBtnReporte() {
		return btnReporte;
	}

	public JDateChooser getDateFechaInicio() {
		return dateFechaInicio;
	}

	public JDateChooser getDateFechaFin() {
		return dateFechaFin;
	}

	public JButton getBtnTextoRefCaso() {
		return btnTextoRefCaso;
	}

	public JButton getBtnTextoSitHabit() {
		return btnTextoSitHabit;
	}

	public JButton getBtnTextoIntMedioFam() {
		return btnTextoIntMedioFam;
	}

	public JButton getBtnTextoDesEmocional() {
		return btnTextoDesEmocional;
	}

	public JTextArea getTxtHistSocial() {
		return txtHistSocial;
	}

	public JTextArea getTxtSitActual() {
		return txtSitActual;
	}

	public JTextArea getTxtFuenteInform() {
		return txtFuenteInform;
	}

	public JTextArea getTxtFuenteInformacion() {
		return txtFuenteInformacion;
	}

	public JTextArea getTxtSituacionActual() {
		return txtSituacionActual;
	}

	public JTextArea getTxtDescripcionCaso() {
		return txtDescripcionCaso;
	}

	public JTextArea getTxtDocAdjuntos() {
		return txtDocAdjuntos;
	}

	public CFInformes getControl() {
		return control;
	}

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public JPanel getPnlDatosNinos() {
		return pnlDatosNinos;
	}

	public JPanel getPnlPSSegConvivencia() {
		return pnlPSSegConvivencia;
	}

	public JPanel getPnlPSSeguimiento() {
		return pnlPSSeguimiento;
	}

	public JPanel getPnlInfSocial() {
		return pnlInfSocial;
	}

	public JPanel getPnlInfSocialSeguim() {
		return pnlInfSocialSeguim;
	}

	public JPanel getPnlFichaSocial() {
		return pnlFichaSocial;
	}

	public JPanel getContentPanel() {
		return contentPanel;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public JLabel getLblDatosNino() {
		return lblDatosNino;
	}

	public JTable getTable() {
		return table;
	}

	public JLabel getLblNroDeInforme() {
		return lblNroDeInforme;
	}

	public JLabel getLblNroInforme() {
		return lblNroInforme;
	}

	public JLabel getLblDiagnosticoPsicosocial() {
		return lblDiagnosticoPsicosocial;
	}

	public JTextArea getTxtDiagnosticoPsicosocial() {
		return txtDiagnosticoPsicosocial;
	}
	
	

}
