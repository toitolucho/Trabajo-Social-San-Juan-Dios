package org.quarkbit.trabajosocialsanjuan.formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import org.quarkbit.trabajosocialsanjuan.controller.CFIngresos;
import org.quarkbit.trabajosocialsanjuan.dao.domain.IngresoTipo;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.demo.JCalendarDemo;
import com.toedter.components.JSpinField;


import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class FIngresos extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JButton btnNuevo;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnCerrar;
	private JTextField txtCodigo;
	private JDateChooser dateFechaRegistro;
	private JTable jTableIngreso;
	public CFIngresos control;
	private JLabel lblEstado;
	private JComboBox<IngresoTipo> cBoxIngresoTipo;
	private JLabel lblPrecio;
	private JTextField txtMonto;
	private JTextArea txtDescripcion;
	private JLabel lblSaldo;
	private JTextField txtSaldo;
	private JScrollPane scrollPane_1;
	private JLabel lblNombre;
	private JTextField txtNombre;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FIngresos frame = new FIngresos();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
//	public void habilitarEventos()
//	{
//		control = new CFIngresos(this);
//		btnAceptar.addActionListener(control);
//		btnCancelar.addActionListener(control);
//		btnNuevo.addActionListener(control);
//		btnEliminar.addActionListener(control);
//		btnModificar.addActionListener(control);
//	}

	/**
	 * Create the frame.
	 */
	public FIngresos(JFrame owner) {
		super(owner,true);
		setTitle("Ingresos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 710, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlBotones = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) pnlBotones.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		contentPane.add(pnlBotones, BorderLayout.SOUTH);
		
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
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon(FComidas.class.getResource("/imagenes/BOTONES/Cerrar01.png")));
		pnlBotones.add(btnCerrar);
		
		JPanel pnlControles = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnlControles.getLayout();
		flowLayout.setHgap(15);
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setVgap(15);
		pnlControles.setPreferredSize(new Dimension(320, 60));
		contentPane.add(pnlControles, BorderLayout.WEST);
		
		JLabel lblCodigo = new JLabel("Codigo :");
		lblCodigo.setPreferredSize(new Dimension(80, 14));
		pnlControles.add(lblCodigo);
		
		txtCodigo = new JTextField();
		pnlControles.add(txtCodigo);
		txtCodigo.setColumns(15);
		
		lblNombre = new JLabel("Nombre :");
		lblNombre.setPreferredSize(new Dimension(80, 14));
		pnlControles.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(18);
		pnlControles.add(txtNombre);
		
		JLabel lblIngreso = new JLabel("Fecha Ing. :");
		lblIngreso.setPreferredSize(new Dimension(80, 14));
		pnlControles.add(lblIngreso);
		
		dateFechaRegistro = new JDateChooser();
		dateFechaRegistro.setPreferredSize(new Dimension(170, 22));
		
		pnlControles.add(dateFechaRegistro);
		
		lblPrecio = new JLabel("Monto :");
		lblPrecio.setPreferredSize(new Dimension(80, 14));
		pnlControles.add(lblPrecio);
		
		txtMonto = new JTextField();
		txtMonto.setColumns(15);
		pnlControles.add(txtMonto);
		
		lblSaldo = new JLabel("Saldo :");
		lblSaldo.setPreferredSize(new Dimension(80, 14));
		pnlControles.add(lblSaldo);
		
		txtSaldo = new JTextField();
		txtSaldo.setColumns(15);
		pnlControles.add(txtSaldo);
		
		lblEstado = new JLabel("Tipo :");
		lblEstado.setPreferredSize(new Dimension(80, 14));
		pnlControles.add(lblEstado);
		
		cBoxIngresoTipo = new JComboBox<IngresoTipo>();
		cBoxIngresoTipo.setPreferredSize(new Dimension(170, 22));
		pnlControles.add(cBoxIngresoTipo);
		
		JLabel lblDescripcin = new JLabel("Detalle :");
		lblDescripcin.setPreferredSize(new Dimension(80, 14));
		pnlControles.add(lblDescripcin);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pnlControles.add(scrollPane_1);
		
		txtDescripcion = new JTextArea();
		scrollPane_1.setViewportView(txtDescripcion);
		txtDescripcion.setTabSize(5);
		txtDescripcion.setRows(3);
		txtDescripcion.setColumns(15);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		jTableIngreso = new JTable();
		jTableIngreso.setModel(new DefaultTableModel(
			new Object[][] {
				{"123", "Padres"},
			},
			new String[] {
				"Codigo", "Nombre"
			}
		));
		scrollPane.setViewportView(jTableIngreso);
		
		control = new CFIngresos(this);
		control.onLoad();
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
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

	public JTextField getTxtCodigo() {
		return txtCodigo;
	}



	public JTextArea getTxtDescripcion() {
		return txtDescripcion;
	}

	public JTable getjTableIngreso() {
		return jTableIngreso;
	}

	public void mostrorSoloControles()
	{
		this.remove(scrollPane);
		this.setSize(350, 380);
		btnCancelar.setVisible(false);
		btnEliminar.setVisible(false);
		btnModificar.setVisible(false);
		btnNuevo.setVisible(false);
	}

	public JComboBox<IngresoTipo> getcBoxIngresoTipo() {
		return cBoxIngresoTipo;
	}

	public JTextField getTxtMonto() {
		return txtMonto;
	}

	public JTextField getTxtSaldo() {
		return txtSaldo;
	}

	public JDateChooser getDateFechaRegistro() {
		return dateFechaRegistro;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	

	
}

