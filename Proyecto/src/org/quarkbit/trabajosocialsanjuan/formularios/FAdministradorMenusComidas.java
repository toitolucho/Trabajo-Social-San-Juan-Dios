package org.quarkbit.trabajosocialsanjuan.formularios;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import org.quarkbit.trabajosocialsanjuan.controller.CFAdministradorMenusComidas;
import org.quarkbit.trabajosocialsanjuan.utils.componentes.JTableHorario;

import datechooser.beans.DateChooserPanel;
import datechooser.model.multiple.MultyModelBehavior;
import datechooser.view.WeekDaysStyle;
import javax.swing.JButton;

public class FAdministradorMenusComidas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTabbedPane jTabbedPane = null;

	private JPanel jpnlVistaSemanal = null;
	private JPanel jpnlSuperior = null;

	private DateChooserPanel pnlDateChooser = null;
	private JLabel jLabel4 = null;
	private JScrollPane jScrollPane1 = null;
	private JTextArea jTextAreaObservacionesHorario = null;
	private Label label = null;
	public Label lblColorReservado = null;
	private Label label1 = null;
	public Label lblColorAlquilado = null;
	private Label label3 = null;
	public Label lblColorPasado = null;
	public Label lblDatosSeleccion = null;
	private JScrollPane jScrollPane2 = null;
	private JTableHorario jTableHorariosCampos = null;
	public CFAdministradorMenusComidas control = null;
	private JLabel jLabel10 = null;
	private JPopupMenu jPopupMenuHorario = null;
	private JMenuItem jMenuItemAlquilar = null;
	private JMenuItem jMenuItemCancelar = null;
	private JMenuItem jMenuItemAnular = null;
	private JMenuItem jMenuItemDetalle = null;
	private JPanel pnlBotones;
	private JButton btnReporte;
	private JButton btnCerrar;
	private JLabel lblResumenDiario;
	private JPanel panel;
	private Label lblResumenSemanal;
	private Label lblResumenSemanalTotal;
	/**
	 * This is the xxx default constructor
	 */
	public FAdministradorMenusComidas() {
		super();
		control = new CFAdministradorMenusComidas(this);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(954, 600);
		this.setTitle("Creacion de Menus para Comidas");
		this.setContentPane(getJContentPane());
//		this.setIconifiable(true);
//		this.setClosable(true);
	}

	/**
	 * This method initializes jContentPane	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	public JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJTabbedPane(), java.awt.BorderLayout.CENTER);
			jContentPane.add(getPnlBotones(), BorderLayout.SOUTH);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jTabbedPane	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	public JTabbedPane getJTabbedPane() {
		if (jTabbedPane == null) {
			jTabbedPane = new JTabbedPane();
			jTabbedPane.addTab("Vista Semanal", null, getJpnlVistaSemanal(), "Vista de Horarios Reservados Semanalmente ");
		}
		return jTabbedPane;
	}

	/**
	 * This method initializes jpnlVistaSemanal	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	public JPanel getJpnlVistaSemanal() {
		if (jpnlVistaSemanal == null) {
			jpnlVistaSemanal = new JPanel();
			jpnlVistaSemanal.setLayout(new BorderLayout());
			jpnlVistaSemanal.add(getJpnlSuperior(), java.awt.BorderLayout.WEST);
			jpnlVistaSemanal.add(getPanel(), BorderLayout.CENTER);
		}
		return jpnlVistaSemanal;
	}

	/**
	 * This method initializes jpnlSuperior	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	public JPanel getJpnlSuperior() {
		if (jpnlSuperior == null) {
			lblDatosSeleccion = new Label();
			lblDatosSeleccion.setPreferredSize(new Dimension(290, 20));
			lblDatosSeleccion.setFont(new Font("Dialog", Font.BOLD, 12));
			lblDatosSeleccion.setText("             ");
			jLabel4 = new JLabel();
			jLabel4.setText("Observaciones");
			FlowLayout flowLayout1 = new FlowLayout();
			flowLayout1.setAlignment(FlowLayout.LEFT);
			flowLayout1.setHgap(10);
			jpnlSuperior = new JPanel();
			jpnlSuperior.setPreferredSize(new Dimension(350, 40));
			jpnlSuperior.setLayout(flowLayout1);
			jpnlSuperior.add(getPnlDateChooser(), null);
			jpnlSuperior.add(jLabel4, null);
			jpnlSuperior.add(getJScrollPane1(), null);
			jpnlSuperior.add(lblDatosSeleccion, null);
			jpnlSuperior.add(getLblResumenSemanal());
			jpnlSuperior.add(getLblResumenSemanalTotal());
		}
		return jpnlSuperior;
	}

	/**
	 * This method initializes pnlDateChooser	
	 * 	
	 * @return datechooser.beans.DateChooserPanel	
	 */
	public DateChooserPanel getPnlDateChooser() {
		if (pnlDateChooser == null) {
			pnlDateChooser = new DateChooserPanel();
//			pnlDateChooser.setPreferredSize(new Dimension(280, 180));
			pnlDateChooser.setLocked(false);			//
			pnlDateChooser.setWeekStyle(WeekDaysStyle.NORMAL);
			pnlDateChooser.setNothingAllowed(false);
			pnlDateChooser.setBehavior(MultyModelBehavior.SELECT_SINGLE);			
			pnlDateChooser.setNavigateFont(new Font("Serif", Font.BOLD, 17));
			pnlDateChooser.addSelectionChangedListener(control);
			pnlDateChooser.setPreferredSize(new Dimension(330, 180));
		}
		return pnlDateChooser;
	}

	/**
	 * This method initializes jScrollPane1	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	public JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setPreferredSize(new Dimension(280, 155));
			jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			jScrollPane1.setViewportView(getJTextAreaObservacionesHorario());
		}
		return jScrollPane1;
	}

	/**
	 * This method initializes jTextAreaObservacionesHorario	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	public JTextArea getJTextAreaObservacionesHorario() {
		if (jTextAreaObservacionesHorario == null) {
			jTextAreaObservacionesHorario = new JTextArea();
			jTextAreaObservacionesHorario.setSize(new Dimension(200, 16));
			jTextAreaObservacionesHorario.setPreferredSize(new Dimension(100, 16));
		}
		return jTextAreaObservacionesHorario;
	}

	/**
	 * This method initializes jScrollPane2	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	public JScrollPane getJScrollPane2() {
		if (jScrollPane2 == null) {
			jScrollPane2 = new JScrollPane();
			jScrollPane2.setViewportView(getJTableHorariosCampos());
		}
		return jScrollPane2;
	}

	/**
	 * This method initializes jTableHorariosCampos	
	 * 	
	 * @return view.componentes.JTableHorario	
	 */
	public JTableHorario getJTableHorariosCampos() {
		if (jTableHorariosCampos == null) {
			jTableHorariosCampos = new JTableHorario();
			jTableHorariosCampos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			jTableHorariosCampos.setRowSelectionAllowed(false);
			jTableHorariosCampos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			jTableHorariosCampos.setCellSelectionEnabled(true);
		}
		return jTableHorariosCampos;
	}

	/**
	 * @param jTableHorariosCampos the jTableHorariosCampos to set
	 */
	public void setjTableHorariosCampos(JTableHorario jTableHorariosCampos) {
		this.jTableHorariosCampos = jTableHorariosCampos;
	}

	/**
	 * This method initializes jPopupMenuHorario	
	 * 	
	 * @return javax.swing.JPopupMenu	
	 */
	public JPopupMenu getJPopupMenuHorario() {
		if (jPopupMenuHorario == null) {
			jPopupMenuHorario = new JPopupMenu();
			jPopupMenuHorario.add(getJMenuItemAlquilar());
			jPopupMenuHorario.add(getJMenuItemCancelar());
			jPopupMenuHorario.add(getJMenuItemAnular());
			jPopupMenuHorario.add(getJMenuItemDetalle());
		}
		return jPopupMenuHorario;
	}

	/**
	 * This method initializes jMenuItemAlquilar	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	public JMenuItem getJMenuItemAlquilar() {
		if (jMenuItemAlquilar == null) {
			jMenuItemAlquilar = new JMenuItem();
			jMenuItemAlquilar.setToolTipText("Ingresar el men\u00FA de un nuevo Alimento");
			jMenuItemAlquilar.setActionCommand("reservar");
			jMenuItemAlquilar.setText("Nueva comida");
			jMenuItemAlquilar.setMnemonic(KeyEvent.VK_N);
			jMenuItemAlquilar.addActionListener(control);
		}
		return jMenuItemAlquilar;
	}

	/**
	 * This method initializes jMenuItemCancelar	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	public JMenuItem getJMenuItemCancelar() {
		if (jMenuItemCancelar == null) {
			jMenuItemCancelar = new JMenuItem();
			jMenuItemCancelar.setToolTipText("Cancelar el registro de un nuevo alimento");
			jMenuItemCancelar.setActionCommand("cancelarMenu");
			jMenuItemCancelar.setText("Cancelar");
			jMenuItemCancelar.setMnemonic(KeyEvent.VK_C);
			jMenuItemCancelar.addActionListener(control);
		}
		return jMenuItemCancelar;
	}

	/**
	 * This method initializes jMenuItemAnular	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	public JMenuItem getJMenuItemAnular() {
		if (jMenuItemAnular == null) {
			jMenuItemAnular = new JMenuItem();
			jMenuItemAnular.setToolTipText("Anular el registro de comida actual");
			jMenuItemAnular.setActionCommand("anularMenu");
			jMenuItemAnular.setText("Anular");
			jMenuItemAnular.setMnemonic(KeyEvent.VK_A);
			jMenuItemAnular.addActionListener(control);
		}
		return jMenuItemAnular;
	}

	/**
	 * This method initializes jMenuItemDetalle	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	public JMenuItem getJMenuItemDetalle() {
		if (jMenuItemDetalle == null) {
			jMenuItemDetalle = new JMenuItem();
			jMenuItemDetalle.setToolTipText("Ver Detalle de la comida");
			jMenuItemDetalle.setActionCommand("verDetalle");
			jMenuItemDetalle.setText("Ver Detalle");
			jMenuItemDetalle.setMnemonic(KeyEvent.VK_V);
			jMenuItemDetalle.addActionListener(control);
		}
		return jMenuItemDetalle;
	}

	private JPanel getPnlBotones() {
		if (pnlBotones == null) {
			pnlBotones = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnlBotones.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			pnlBotones.add(getBtnReporte());
			pnlBotones.add(getBtnCerrar());
		}
		return pnlBotones;
	}
	public JButton getBtnReporte() {
		if (btnReporte == null) {
			btnReporte = new JButton("Reporte");
			btnReporte.setActionCommand("Reporte");
			btnReporte.addActionListener(control);
		}
		return btnReporte;
	}
	public JButton getBtnCerrar() {
		if (btnCerrar == null) {
			btnCerrar = new JButton("Cerrar");
			btnCerrar.setIcon(new ImageIcon(FComidas.class.getResource("/imagenes/BOTONES/Cerrar01.png")));
			btnCerrar.addActionListener(control);
		}
		return btnCerrar;
	}
	public JLabel getLblResumenDiario() {
		if (lblResumenDiario == null) {
			lblResumenDiario = new JLabel("New label");
		}
		return lblResumenDiario;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getLblResumenDiario(), BorderLayout.SOUTH);
			panel.add(getJScrollPane2(), BorderLayout.CENTER);
		}
		return panel;
	}
	public Label getLblResumenSemanal() {
		if (lblResumenSemanal == null) {
			lblResumenSemanal = new Label();
			lblResumenSemanal.setText("Label");
			lblResumenSemanal.setPreferredSize(new Dimension(290, 20));
			lblResumenSemanal.setFont(new Font("Dialog", Font.BOLD, 12));
		}
		return lblResumenSemanal;
	}
	public Label getLblResumenSemanalTotal() {
		if (lblResumenSemanalTotal == null) {
			lblResumenSemanalTotal = new Label();
			lblResumenSemanalTotal.setText("Label");
			lblResumenSemanalTotal.setPreferredSize(new Dimension(290, 20));
			lblResumenSemanalTotal.setFont(new Font("Dialog", Font.BOLD, 12));
		}
		return lblResumenSemanalTotal;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
