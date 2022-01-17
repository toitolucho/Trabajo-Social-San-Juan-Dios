package org.quarkbit.trabajosocialsanjuan.formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.JTextArea;
import javax.swing.JButton;

import org.quarkbit.trabajosocialsanjuan.controller.CFEgresos;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Ingreso;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Partida;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Proveedor;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;

public class FEgresos extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigo;
	private JDateChooser dateFechaIngreso;
	private JTextField txtNroFactura;
	private JTextField txtMontoSalida;
	private JTree tree;
	private JComboBox<Partida> cBoxPartida;
	private JComboBox<Ingreso> cBoxIngreso;
	private JComboBox<Proveedor> cBoxProveedor;
	private JTextArea txtObservaciones;
	private JButton btnNuevo;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnCerrar;
	public CFEgresos control;
	public JLabel lblNombreIngreso;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public FEgresos(JFrame owner) {
		super(owner, true);
		setTitle("Egresos");
		setBounds(100, 100, 649, 411);
		control = new CFEgresos(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		tree = new JTree();
		scrollPane.setViewportView(tree);
		
		JPanel pnlDatos = new JPanel();
		pnlDatos.setPreferredSize(new Dimension(320, 10));
		FlowLayout flowLayout = (FlowLayout) pnlDatos.getLayout();
		flowLayout.setHgap(10);
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(pnlDatos, BorderLayout.EAST);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setPreferredSize(new Dimension(90, 14));
		pnlDatos.add(lblCodigo);
		
		txtCodigo = new JTextField();
		pnlDatos.add(txtCodigo);
		txtCodigo.setColumns(15);
		
		JLabel lblFechaIngreso = new JLabel("Fecha Ingreso:");
		lblFechaIngreso.setPreferredSize(new Dimension(90, 14));
		pnlDatos.add(lblFechaIngreso);
		
		dateFechaIngreso = new JDateChooser();
		dateFechaIngreso.setDateFormatString("dd-MM-yyyy");
		pnlDatos.add(dateFechaIngreso);
		
		JLabel lblPartida = new JLabel("Partida");
		lblPartida.setPreferredSize(new Dimension(90, 14));
		pnlDatos.add(lblPartida);
		
		cBoxPartida = new JComboBox<Partida>();
		cBoxPartida.setPreferredSize(new Dimension(150, 20));
		pnlDatos.add(cBoxPartida);
		
		JLabel lblIngreso = new JLabel("Ingreso");
		lblIngreso.setPreferredSize(new Dimension(90, 14));
		pnlDatos.add(lblIngreso);
		
		cBoxIngreso = new JComboBox<Ingreso>();
		cBoxIngreso.setPreferredSize(new Dimension(150, 20));
		pnlDatos.add(cBoxIngreso);
		
		lblNombreIngreso = new JLabel("");
		lblNombreIngreso.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNombreIngreso.setPreferredSize(new Dimension(250, 14));
		pnlDatos.add(lblNombreIngreso);
		
		JLabel lblProveedor = new JLabel("Proveedor");
		lblProveedor.setPreferredSize(new Dimension(90, 14));
		pnlDatos.add(lblProveedor);
		
		cBoxProveedor = new JComboBox<Proveedor>();
		cBoxProveedor.setPreferredSize(new Dimension(150, 20));
		pnlDatos.add(cBoxProveedor);
		
		JLabel lblNroFactura = new JLabel("Nro Factura");
		lblNroFactura.setPreferredSize(new Dimension(90, 14));
		pnlDatos.add(lblNroFactura);
		
		txtNroFactura = new JTextField();
		txtNroFactura.setColumns(15);
		pnlDatos.add(txtNroFactura);
		
		JLabel lblMonto = new JLabel("Monto");
		lblMonto.setPreferredSize(new Dimension(90, 14));
		pnlDatos.add(lblMonto);
		
		txtMontoSalida = new JTextField();
		txtMontoSalida.setColumns(15);
		pnlDatos.add(txtMontoSalida);
		
		JLabel lblObservaciones = new JLabel("Observaciones");
		lblObservaciones.setPreferredSize(new Dimension(90, 14));
		pnlDatos.add(lblObservaciones);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pnlDatos.add(scrollPane_1);
		
		txtObservaciones = new JTextArea();
		txtObservaciones.setColumns(15);
		txtObservaciones.setRows(3);
//		pnlDatos.add(textArea);
		
		scrollPane_1.setViewportView(txtObservaciones);
		
		JPanel pnlBotones = new JPanel();
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
		
		control.onFormShown();
	}

	public JTextField getTxtCodigo() {
		return txtCodigo;
	}

	public JDateChooser getDateFechaIngreso() {
		return dateFechaIngreso;
	}

	public JTextField getTxtNroFactura() {
		return txtNroFactura;
	}

	public JTextField getTxtMontoSalida() {
		return txtMontoSalida;
	}

	public JTree getTree() {
		return tree;
	}

	public JComboBox<Partida> getcBoxPartida() {
		return cBoxPartida;
	}

	public JComboBox<Ingreso> getcBoxIngreso() {
		return cBoxIngreso;
	}

	public JComboBox<Proveedor> getcBoxProveedor() {
		return cBoxProveedor;
	}

	public JTextArea getTxtObservaciones() {
		return txtObservaciones;
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
	
	

}
