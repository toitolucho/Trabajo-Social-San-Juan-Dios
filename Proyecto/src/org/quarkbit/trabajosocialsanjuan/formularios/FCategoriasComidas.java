package org.quarkbit.trabajosocialsanjuan.formularios;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.quarkbit.trabajosocialsanjuan.controller.CFCategoriasComidas;
import org.quarkbit.trabajosocialsanjuan.utils.HoraTiempo;

public class FCategoriasComidas extends JDialog {

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
	private JTable jTableCategoriaComida;
	public CFCategoriasComidas control;
	private JLabel lblOrden;
	private JLabel lblEstado;
	private JComboBox<String> cBoxEstado;
	private JSlider sliderOrden;
	private JComboBox<HoraTiempo> cBoxHoraInicio;
	private JLabel lblHoraIni;
	private JLabel lblHoraFin;
	private JComboBox<HoraTiempo> cBoxHoraFin;
	private JScrollPane scrollPane_1;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FCategoriasComidas frame = new FCategoriasComidas();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
//	public void habilitarEventos()
//	{
//		control = new CFCategoriaComidas(this);
//		btnAceptar.addActionListener(control);
//		btnCancelar.addActionListener(control);
//		btnNuevo.addActionListener(control);
//		btnEliminar.addActionListener(control);
//		btnModificar.addActionListener(control);
//	}

	/**
	 * Create the frame.
	 */
	public FCategoriasComidas(JFrame owner) {
		super(owner, true);
		setTitle("Categoria de Comidas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 687, 418);
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
		pnlControles.setPreferredSize(new Dimension(310, 70));
		contentPane.add(pnlControles, BorderLayout.WEST);
		
		JLabel lblCodigo = new JLabel("Codigo :");
		lblCodigo.setPreferredSize(new Dimension(80, 14));
		pnlControles.add(lblCodigo);
		
		txtCodigo = new JTextField();
		pnlControles.add(txtCodigo);
		txtCodigo.setColumns(16);
		
		JLabel lblCategoriaComida = new JLabel("Categoria :");
		lblCategoriaComida.setPreferredSize(new Dimension(80, 14));
		pnlControles.add(lblCategoriaComida);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(16);
		pnlControles.add(txtNombre);
		
		lblOrden = new JLabel("Orden :");
		lblOrden.setPreferredSize(new Dimension(80, 14));
		pnlControles.add(lblOrden);
		
		sliderOrden = new JSlider();
		sliderOrden.setPaintLabels(true);
		sliderOrden.setMajorTickSpacing(2);
		sliderOrden.setValue(0);
		sliderOrden.setMaximum(20);
		sliderOrden.setPreferredSize(new Dimension(170, 40));
		pnlControles.add(sliderOrden);
		
		lblEstado = new JLabel("Estado :");
		lblEstado.setPreferredSize(new Dimension(80, 14));
		pnlControles.add(lblEstado);
		
		cBoxEstado = new JComboBox<String>();
		cBoxEstado.setPreferredSize(new Dimension(165, 22));
		pnlControles.add(cBoxEstado);
		
		lblHoraIni = new JLabel("Hora Ini. :");
		lblHoraIni.setPreferredSize(new Dimension(80, 14));
		pnlControles.add(lblHoraIni);
		
		cBoxHoraInicio = new JComboBox<HoraTiempo>();
		cBoxHoraInicio.setPreferredSize(new Dimension(165, 22));
		pnlControles.add(cBoxHoraInicio);
		
		lblHoraFin = new JLabel("Hora Fin :");
		lblHoraFin.setPreferredSize(new Dimension(80, 14));
		pnlControles.add(lblHoraFin);
		
		cBoxHoraFin = new JComboBox<HoraTiempo>();
		cBoxHoraFin.setPreferredSize(new Dimension(165, 22));
		pnlControles.add(cBoxHoraFin);
		
		JLabel lblDescripcin = new JLabel("Descripcion :");
		lblDescripcin.setPreferredSize(new Dimension(80, 14));
		pnlControles.add(lblDescripcin);
		
		txtDescripcion = new JTextArea();
		txtDescripcion.setColumns(15);
		txtDescripcion.setRows(2);
			
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setViewportView(txtDescripcion);
		pnlControles.add(scrollPane_1);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		jTableCategoriaComida = new JTable();
		jTableCategoriaComida.setModel(new DefaultTableModel(
			new Object[][] {
				{"123", "Padres"},
			},
			new String[] {
				"Codigo", "Nombre"
			}
		));
		scrollPane.setViewportView(jTableCategoriaComida);
		
		control = new CFCategoriasComidas(this);
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

	public JTable getjTableCategoriaComida() {
		return jTableCategoriaComida;
	}

	public void mostrorSoloControles()
	{
		this.remove(scrollPane);
		this.setSize(320, 380);
		btnCancelar.setVisible(false);
		btnEliminar.setVisible(false);
		btnModificar.setVisible(false);
		btnNuevo.setVisible(false);
	}

	public JComboBox<String> getcBoxEstado() {
		return cBoxEstado;
	}

	public JSlider getSliderOrden() {
		return sliderOrden;
	}

	public JComboBox<HoraTiempo> getcBoxHoraInicio() {
		return cBoxHoraInicio;
	}

	public JComboBox<HoraTiempo> getcBoxHoraFin() {
		return cBoxHoraFin;
	}
	
	
	
}

