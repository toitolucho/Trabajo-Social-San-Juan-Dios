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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import org.quarkbit.trabajosocialsanjuan.controller.CFProveedores;
import javax.swing.JComboBox;
import javax.swing.ScrollPaneConstants;

public class FProveedores extends JDialog {

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
	private JTextField txtNombre;
	private JTextArea txtDescripcion;
	private JTable jTableProveedor;
	public CFProveedores control;
	private JLabel lblNit;
	private JTextField txtNIT;
	private JLabel lblEstado;
	private JComboBox<String> cBoxEstado;
	private JScrollPane scrollPane_1;
	private JPanel pnlBusqueda;
	private JPanel panel;
	private JLabel lblTextoBusqueda;
	private JTextField txtTextoBusqueda;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FProveedores frame = new FProveedores();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//	
//	public void habilitarEventos()
//	{
//		control = new CFProveedores(this);
//		btnAceptar.addActionListener(control);
//		btnCancelar.addActionListener(control);
//		btnNuevo.addActionListener(control);
//		btnEliminar.addActionListener(control);
//		btnModificar.addActionListener(control);
//	}

	/**
	 * Create the frame.
	 */
	public FProveedores(JFrame owner) {
		super(owner, true);
		setTitle("Proveedores");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 654, 371);
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
		pnlControles.setPreferredSize(new Dimension(350, 10));
		contentPane.add(pnlControles, BorderLayout.WEST);
		
		JLabel lblCodigo = new JLabel("Codigo :");
		lblCodigo.setPreferredSize(new Dimension(85, 14));
		pnlControles.add(lblCodigo);
		
		txtCodigo = new JTextField();
		pnlControles.add(txtCodigo);
		txtCodigo.setColumns(15);
		
		JLabel lblEmpleo = new JLabel("Proveedor :");
		lblEmpleo.setPreferredSize(new Dimension(85, 14));
		pnlControles.add(lblEmpleo);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(15);
		pnlControles.add(txtNombre);
		
		lblNit = new JLabel("NIT :");
		lblNit.setPreferredSize(new Dimension(85, 14));
		pnlControles.add(lblNit);
		
		txtNIT = new JTextField();
		txtNIT.setColumns(15);
		pnlControles.add(txtNIT);
		
		lblEstado = new JLabel("Estado :");
		lblEstado.setPreferredSize(new Dimension(85, 14));
		pnlControles.add(lblEstado);
		
		cBoxEstado = new JComboBox<String>();
		cBoxEstado.setPreferredSize(new Dimension(140, 20));
		pnlControles.add(cBoxEstado);
		
		JLabel lblDescripcin = new JLabel("Descripcion :");
		lblDescripcin.setPreferredSize(new Dimension(85, 14));
		pnlControles.add(lblDescripcin);
		
		txtDescripcion = new JTextArea();
		txtDescripcion.setColumns(15);
		txtDescripcion.setRows(2);
//		pnlControles.add(txtDescripcion);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setViewportView(txtDescripcion);
		pnlControles.add(scrollPane_1);
		
		pnlBusqueda = new JPanel();
		contentPane.add(pnlBusqueda, BorderLayout.CENTER);
		pnlBusqueda.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		pnlBusqueda.add(scrollPane, BorderLayout.CENTER);
		
		jTableProveedor = new JTable();
		jTableProveedor.setModel(new DefaultTableModel(
			new Object[][] {
				{"123", "Padres"},
			},
			new String[] {
				"Codigo", "Nombre"
			}
		));
		scrollPane.setViewportView(jTableProveedor);
		
		panel = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		pnlBusqueda.add(panel, BorderLayout.NORTH);
		
		lblTextoBusqueda = new JLabel("Texto Busqueda :");
		panel.add(lblTextoBusqueda);
		
		txtTextoBusqueda = new JTextField();
		txtTextoBusqueda.setActionCommand("buscar");
		panel.add(txtTextoBusqueda);
		txtTextoBusqueda.setColumns(12);
		
		control = new CFProveedores(this);
		control.onLoad();
	}

	public JTextField getTxtNIT() {
		return txtNIT;
	}

	public JComboBox<String> getcBoxEstado() {
		return cBoxEstado;
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

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public JTextArea getTxtDescripcion() {
		return txtDescripcion;
	}

	public JTable getjTableProveedor() {
		return jTableProveedor;
	}

	public void mostrorSoloControles()
	{
		this.remove(scrollPane);
		this.setSize(320, 220);
		btnCancelar.setVisible(false);
		btnEliminar.setVisible(false);
		btnModificar.setVisible(false);
		btnNuevo.setVisible(false);
	}

	public JTextField getTxtTextoBusqueda() {
		return txtTextoBusqueda;
	}
	
	
	
}

