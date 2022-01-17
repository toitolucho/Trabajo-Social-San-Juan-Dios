package org.quarkbit.trabajosocialsanjuan.formularios;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import datechooser.beans.DateChooserCombo;
import datechooser.model.exeptions.IncompatibleDataExeption;
import datechooser.model.multiple.MultyModelBehavior;
import datechooser.view.WeekDaysStyle;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.KeyEvent;
import javax.swing.border.BevelBorder;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import datechooser.beans.DateChooserPanel;
import java.awt.Panel;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.ListSelectionModel;


import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;

import org.quarkbit.trabajosocialsanjuan.controller.CFAlquilerCampoDeportivo;
import org.quarkbit.trabajosocialsanjuan.utils.componentes.JTableHorario;

import datechooser.model.multiple.PeriodSet;
import java.awt.Cursor;

public class FAlquilerCamposDeportivos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTabbedPane jTabbedPane = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel5 = null;
	private JLabel jLabel6 = null;
	private JLabel jLabel9 = null;
	private JLabel jlblImagen = null;
	private JLabel jLabel3 = null;
	private JPanel jpnlVistaSemanal = null;
	private JPanel jpnlSuperior = null;
	private JLabel jlblSeleccionar = null;
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
	public CFAlquilerCampoDeportivo control = null;
	private JLabel jLabel10 = null;
	private JPopupMenu jPopupMenuHorario = null;
	private JMenuItem jMenuItemAlquilar = null;
	private JMenuItem jMenuItemCancelar = null;
	private JMenuItem jMenuItemAnular = null;
	private JMenuItem jMenuItemDetalle = null;
	/**
	 * This is the xxx default constructor
	 */
	public FAlquilerCamposDeportivos() {
		super();
		control = new CFAlquilerCampoDeportivo(this);
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
			jpnlVistaSemanal.add(getJScrollPane2(), java.awt.BorderLayout.CENTER);
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
			lblDatosSeleccion.setFont(new Font("Dialog", Font.BOLD, 11));
			lblDatosSeleccion.setText("Label");
			jLabel4 = new JLabel();
			jLabel4.setText("Observaciones");
			FlowLayout flowLayout1 = new FlowLayout();
			flowLayout1.setAlignment(FlowLayout.LEFT);
			flowLayout1.setHgap(10);
			jpnlSuperior = new JPanel();
			jpnlSuperior.setPreferredSize(new Dimension(270, 40));
			jpnlSuperior.setLayout(flowLayout1);
			jpnlSuperior.add(getPnlDateChooser(), null);
			jpnlSuperior.add(jLabel4, null);
			jpnlSuperior.add(getJScrollPane1(), null);
			jpnlSuperior.add(lblDatosSeleccion, null);
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
			pnlDateChooser.setLocked(false);			//
			pnlDateChooser.setWeekStyle(WeekDaysStyle.NORMAL);
			pnlDateChooser.setNothingAllowed(false);
			pnlDateChooser.setBehavior(MultyModelBehavior.SELECT_SINGLE);			
			pnlDateChooser.setNavigateFont(new Font("Serif", Font.BOLD, 17));
			pnlDateChooser.addSelectionChangedListener(control);
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
			jScrollPane1.setPreferredSize(new Dimension(250, 155));
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
			jMenuItemAlquilar.setToolTipText("Reservar Campo Deportivo en el Horario seleccionado");
			jMenuItemAlquilar.setActionCommand("reservar");
			jMenuItemAlquilar.setText("Alquilar ");
			jMenuItemAlquilar.setMnemonic(KeyEvent.VK_R);
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
			jMenuItemCancelar.setToolTipText("Cancelar la Reserva del Campo Deportivo en el horario Seleccionado");
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
			jMenuItemAnular.setToolTipText("Anular la Reserva Actual");
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
			jMenuItemDetalle.setToolTipText("Ver Detalle de la Reserva");
			jMenuItemDetalle.setActionCommand("verDetalle");
			jMenuItemDetalle.setText("Ver Detalle");
			jMenuItemDetalle.setMnemonic(KeyEvent.VK_V);
			jMenuItemDetalle.addActionListener(control);
		}
		return jMenuItemDetalle;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
