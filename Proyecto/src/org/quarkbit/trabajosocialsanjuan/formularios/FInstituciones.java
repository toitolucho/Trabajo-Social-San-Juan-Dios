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

import org.quarkbit.trabajosocialsanjuan.controller.CFInstituciones;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.ScrollPaneConstants;

public class FInstituciones extends JDialog {

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
	private JTable jTableInstitucion;
	public CFInstituciones control;
	private JLabel lblDireccin;
	private JTextField txtDireccion;
	private JLabel lblTelfono;
	private JTextField txtTelefono;
	private JTextArea txtDescripcion;
	private JScrollPane scrollPane_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FInstituciones frame = new FInstituciones(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
//	public void habilitarEventos()
//	{
//		control = new CFInstitucions(this);
//		btnAceptar.addActionListener(control);
//		btnCancelar.addActionListener(control);
//		btnNuevo.addActionListener(control);
//		btnEliminar.addActionListener(control);
//		btnModificar.addActionListener(control);
//	}

	/**
	 * Create the frame.
	 */
	public FInstituciones(JFrame owner) {
		super(owner,true);
		setTitle("Instituciones");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 609, 377);
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
		flowLayout.setHgap(10);
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setVgap(20);
		pnlControles.setPreferredSize(new Dimension(300, 10));
		contentPane.add(pnlControles, BorderLayout.WEST);
		
		JLabel lblCodigo = new JLabel("Codigo :");
		lblCodigo.setPreferredSize(new Dimension(80, 14));
		pnlControles.add(lblCodigo);
		
		txtCodigo = new JTextField();
		pnlControles.add(txtCodigo);
		txtCodigo.setColumns(15);
		
		JLabel lblInstitucion = new JLabel("Institucion :");
		lblInstitucion.setPreferredSize(new Dimension(80, 14));
		pnlControles.add(lblInstitucion);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(15);
		pnlControles.add(txtNombre);
		
		lblDireccin = new JLabel("Direccion :");
		lblDireccin.setPreferredSize(new Dimension(80, 14));
		pnlControles.add(lblDireccin);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(15);
		pnlControles.add(txtDireccion);
		
		lblTelfono = new JLabel("Telefono :");
		lblTelfono.setPreferredSize(new Dimension(80, 14));
		pnlControles.add(lblTelfono);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(15);
		pnlControles.add(txtTelefono);
		
		JLabel lblDescripcin = new JLabel("Descripcion :");
		lblDescripcin.setPreferredSize(new Dimension(80, 14));
		pnlControles.add(lblDescripcin);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pnlControles.add(scrollPane_1);
		
		txtDescripcion = new JTextArea();
		scrollPane_1.setViewportView(txtDescripcion);
		txtDescripcion.setRows(3);
		txtDescripcion.setColumns(15);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		jTableInstitucion = new JTable();
		jTableInstitucion.setModel(new DefaultTableModel(
			new Object[][] {
				{"123", "Padres"},
			},
			new String[] {
				"Codigo", "Nombre"
			}
		));
		scrollPane.setViewportView(jTableInstitucion);
		
		control = new CFInstituciones(this);
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

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public JTextArea getTxtDescripcion() {
		return txtDescripcion;
	}

	public JTable getjTableInstitucion() {
		return jTableInstitucion;
	}
	
	
	

	public JTextField getTxtDireccion() {
		return txtDireccion;
	}

	public JTextField getTxtTelefono() {
		return txtTelefono;
	}

	public void mostrorSoloControles()
	{
		this.remove(scrollPane);
		this.setSize(320, 350);
		btnCancelar.setVisible(false);
		btnEliminar.setVisible(false);
		btnModificar.setVisible(false);
		btnNuevo.setVisible(false);
	}
	
}

