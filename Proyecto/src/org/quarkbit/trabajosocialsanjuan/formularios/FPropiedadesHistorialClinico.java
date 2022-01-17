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


import org.quarkbit.trabajosocialsanjuan.controller.CFPropiedadesHistorialClinico;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PropiedadTipo;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class FPropiedadesHistorialClinico extends JDialog {

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
	private JTable jTablePropiedadHistorialClinico;
	public CFPropiedadesHistorialClinico control;
	private JLabel lblEstado;
	private JComboBox<PropiedadTipo> cBoxPropiedadTipo;
	private JLabel lblPrecio;
	private JTextField txtAbreviacion;
	private JTextArea txtDescripcion;
	private JScrollPane scrollPane_1;
	private JLabel lblComposicin;
	private JTextArea txtComposicion;
	private JScrollPane scrollPane_2;
	private JPanel panel;
	private JPanel pnlBusqueda;
	private JLabel lblTipo;
	private JComboBox<PropiedadTipo> cBoxTipoBusqueda;
	private JTextField txtBusqueda;
	private JButton btnBuscar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FPropiedadesHistorialClinico frame = new FPropiedadesHistorialClinico(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
//	
//	public void habilitarEventos()
//	{
//		control = new CFComidas(this);
//		btnAceptar.addActionListener(control);
//		btnCancelar.addActionListener(control);
//		btnNuevo.addActionListener(control);
//		btnEliminar.addActionListener(control);
//		btnModificar.addActionListener(control);
//	}

	/**
	 * Create the frame.
	 */
	public FPropiedadesHistorialClinico(JFrame owner) {
		super(owner,true);
		setTitle("Categorias de Consultas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 828, 444);
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
		flowLayout.setVgap(15);
		pnlControles.setPreferredSize(new Dimension(385, 60));
		contentPane.add(pnlControles, BorderLayout.WEST);
		
		JLabel lblCodigo = new JLabel("Codigo :");
		lblCodigo.setPreferredSize(new Dimension(100, 14));
		pnlControles.add(lblCodigo);
		
		txtCodigo = new JTextField();
		pnlControles.add(txtCodigo);
		txtCodigo.setColumns(15);
		
		JLabel lblComida = new JLabel("Categoria :");
		lblComida.setPreferredSize(new Dimension(100, 14));
		pnlControles.add(lblComida);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(15);
		pnlControles.add(txtNombre);
		
		lblPrecio = new JLabel("Abreviacion :");
		lblPrecio.setPreferredSize(new Dimension(100, 14));
		pnlControles.add(lblPrecio);
		
		txtAbreviacion = new JTextField();
		txtAbreviacion.setColumns(15);
		pnlControles.add(txtAbreviacion);
		
		lblEstado = new JLabel("Tipo Propiedad :");
		lblEstado.setPreferredSize(new Dimension(100, 14));
		pnlControles.add(lblEstado);
		
		cBoxPropiedadTipo = new JComboBox<PropiedadTipo>();
		cBoxPropiedadTipo.setPreferredSize(new Dimension(165, 22));
		pnlControles.add(cBoxPropiedadTipo);
		
		lblComposicin = new JLabel("Composicion :");
		lblComposicin.setPreferredSize(new Dimension(100, 14));
		pnlControles.add(lblComposicin);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pnlControles.add(scrollPane_2);
		
		txtComposicion = new JTextArea();
		scrollPane_2.setViewportView(txtComposicion);
		txtComposicion.setRows(3);
		txtComposicion.setColumns(15);
		
		JLabel lblDescripcin = new JLabel("Descripcion :");
		lblDescripcin.setPreferredSize(new Dimension(100, 14));
		pnlControles.add(lblDescripcin);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pnlControles.add(scrollPane_1);
		
		txtDescripcion = new JTextArea();
		scrollPane_1.setViewportView(txtDescripcion);
		txtDescripcion.setRows(3);
		txtDescripcion.setColumns(15);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		jTablePropiedadHistorialClinico = new JTable();
		jTablePropiedadHistorialClinico.setModel(new DefaultTableModel(
			new Object[][] {
				{"123", "Padres"},
			},
			new String[] {
				"Codigo", "Nombre"
			}
		));
		scrollPane.setViewportView(jTablePropiedadHistorialClinico);
		
		pnlBusqueda = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) pnlBusqueda.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel.add(pnlBusqueda, BorderLayout.NORTH);
		
		lblTipo = new JLabel("Tipo");
		pnlBusqueda.add(lblTipo);
		
		cBoxTipoBusqueda = new JComboBox();
		pnlBusqueda.add(cBoxTipoBusqueda);
		
		txtBusqueda = new JTextField();
		pnlBusqueda.add(txtBusqueda);
		txtBusqueda.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		pnlBusqueda.add(btnBuscar);
		
		control = new CFPropiedadesHistorialClinico(this);
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

	public JTable getjTablePropiedadHistorialClinico() {
		return jTablePropiedadHistorialClinico;
	}

	public void mostrorSoloControles()
	{
		this.remove(scrollPane);
		this.setSize(350, 340);
		btnCancelar.setVisible(false);
		btnEliminar.setVisible(false);
		btnModificar.setVisible(false);
		btnNuevo.setVisible(false);
	}

	

	public JComboBox<PropiedadTipo> getcBoxPropiedadTipo() {
		return cBoxPropiedadTipo;
	}

	public JTextField getTxtAbreviacion() {
		return txtAbreviacion;
	}

	public JTextArea getTxtComposicion() {
		return txtComposicion;
	}

	public JLabel getLblEstado() {
		return lblEstado;
	}

	public JLabel getLblPrecio() {
		return lblPrecio;
	}

	public JLabel getLblComposicin() {
		return lblComposicin;
	}

	public JLabel getLblTipo() {
		return lblTipo;
	}

	public JComboBox<PropiedadTipo> getcBoxTipoBusqueda() {
		return cBoxTipoBusqueda;
	}

	public JTextField getTxtBusqueda() {
		return txtBusqueda;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	

	
}

