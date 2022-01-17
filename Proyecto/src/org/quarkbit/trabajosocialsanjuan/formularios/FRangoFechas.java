package org.quarkbit.trabajosocialsanjuan.formularios;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Frame;
import java.awt.BorderLayout;
import javax.swing.JDialog;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;

import com.toedter.calendar.JDateChooser;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.BevelBorder;

import org.quarkbit.trabajosocialsanjuan.controller.CFRangoFechas;

public class FRangoFechas extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel jnlGroupBox = null;
	private JPanel jpnlBotones = null;
	private JButton jbtnAceptar = null;
	private JButton jbtnCancelar = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JDateChooser jcalendarComboFechaInicio = null;
	private JDateChooser jcalendarComboFechaFin = null;
	public CFRangoFechas control;

	/**
	 * @param owner
	 */
	public FRangoFechas(Frame owner) {
		super(owner, true);
		control = new CFRangoFechas(this);
		initialize();
	}
	

//	public FRangoFechas(JInternalFrame owner)
//	{
//		super(JOptionPane.getFrameForComponent(owner), true);
//		control = new CFRangoFechas(this);
//		initialize();
//	}
	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(299, 177);
		this.setTitle("Seleccion de Rango de Fechas");
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			BorderLayout borderLayout = new BorderLayout();
			borderLayout.setHgap(5);
			borderLayout.setVgap(5);
			jContentPane = new JPanel();
			jContentPane.setLayout(borderLayout);
			jContentPane.add(getJnlGroupBox(), BorderLayout.CENTER);
			jContentPane.add(getJpnlBotones(), BorderLayout.SOUTH);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jnlGroupBox	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJnlGroupBox() {
		if (jnlGroupBox == null) {
			FlowLayout flowLayout1 = new FlowLayout();
			flowLayout1.setVgap(10);
			jLabel1 = new JLabel();
			jLabel1.setText("Fecha Fin :");
			jLabel1.setPreferredSize(new Dimension(73, 16));
			jLabel = new JLabel();
			jLabel.setText("Fecha Inicio :");
			jnlGroupBox = new JPanel();
			jnlGroupBox.setBorder(BorderFactory.createTitledBorder(null, "Seleccione la Fecha de Inicio y Fin", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jnlGroupBox.setLayout(flowLayout1);
			jnlGroupBox.add(jLabel, null);
			jnlGroupBox.add(getJcalendarComboFechaInicio(), null);
			jnlGroupBox.add(jLabel1, null);
			jnlGroupBox.add(getJcalendarComboFechaFin(), null);
		}
		return jnlGroupBox;
	}

	/**
	 * This method initializes jpnlBotones	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpnlBotones() {
		if (jpnlBotones == null) {
			FlowLayout flowLayout = new FlowLayout();
			flowLayout.setHgap(10);
			flowLayout.setAlignment(FlowLayout.RIGHT);
			jpnlBotones = new JPanel();
			jpnlBotones.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
			jpnlBotones.setLayout(flowLayout);
			jpnlBotones.setPreferredSize(new Dimension(0, 40));
			jpnlBotones.add(getJbtnAceptar(), null);
			jpnlBotones.add(getJbtnCancelar(), null);
		}
		return jpnlBotones;
	}

	/**
	 * This method initializes jbtnAceptar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbtnAceptar() {
		if (jbtnAceptar == null) {
			jbtnAceptar = new JButton();
			jbtnAceptar.setActionCommand("aceptar");
			jbtnAceptar.addActionListener(control);
			jbtnAceptar.setText("Aceptar");
		}
		return jbtnAceptar;
	}

	/**
	 * This method initializes jbtnCancelar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbtnCancelar() {
		if (jbtnCancelar == null) {
			jbtnCancelar = new JButton();
			jbtnCancelar.setActionCommand("cancelar");
			jbtnCancelar.addActionListener(control);
			jbtnCancelar.setText("Cancelar");
		}
		return jbtnCancelar;
	}

	/**
	 * This method initializes jcalendarComboFechaInicio	
	 * 	
	 * @return org.jdesktop.swingx.JXDatePicker	
	 */
	public JDateChooser getJcalendarComboFechaInicio() {
		if (jcalendarComboFechaInicio == null) {
			jcalendarComboFechaInicio = new JDateChooser();
			jcalendarComboFechaInicio.setPreferredSize(new Dimension(150, 20));
		}
		return jcalendarComboFechaInicio;
	}

	/**
	 * This method initializes jcalendarComboFechaFin	
	 * 	
	 * @return org.jdesktop.swingx.JXDatePicker	
	 */
	public JDateChooser getJcalendarComboFechaFin() {
		if (jcalendarComboFechaFin == null) {
			jcalendarComboFechaFin = new JDateChooser();
			jcalendarComboFechaFin.setPreferredSize(new Dimension(150, 20));
		}
		return jcalendarComboFechaFin;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
