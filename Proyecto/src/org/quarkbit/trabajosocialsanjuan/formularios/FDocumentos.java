package org.quarkbit.trabajosocialsanjuan.formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Window;

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
import javax.swing.ScrollPaneConstants;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import org.quarkbit.trabajosocialsanjuan.controller.CFDocumentos;

public class FDocumentos extends JDialog {

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
	private JTable jTableDocumento;
	public CFDocumentos control;
	private JPanel pnlControles;
	private JScrollPane scrollPane_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FDocumentos frame = new FDocumentos(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
//	public void habilitarEventos()
//	{
//		control = new CFDocumentos(this);
//		btnAceptar.addActionListener(control);
//		btnCancelar.addActionListener(control);
//		btnNuevo.addActionListener(control);
//		btnEliminar.addActionListener(control);
//		btnModificar.addActionListener(control);
//	}

	/**
	 * Create the frame.
	 */
	public FDocumentos(Frame formPadre) {
		
		super(formPadre, true);
		setTitle("Documentos");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 616, 320);
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
		
		pnlControles = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnlControles.getLayout();
		flowLayout.setHgap(15);
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setVgap(15);
		pnlControles.setPreferredSize(new Dimension(320, 10));
		contentPane.add(pnlControles, BorderLayout.WEST);
		
		JLabel lblCodigo = new JLabel("Codigo :");
		lblCodigo.setPreferredSize(new Dimension(85, 14));
		pnlControles.add(lblCodigo);
		
		txtCodigo = new JTextField();
		pnlControles.add(txtCodigo);
		txtCodigo.setColumns(15);
		
		JLabel lblDocumento = new JLabel("Documento :");
		lblDocumento.setPreferredSize(new Dimension(85, 14));
		pnlControles.add(lblDocumento);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(15);
		pnlControles.add(txtNombre);
		
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
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		jTableDocumento = new JTable();
		jTableDocumento.setModel(new DefaultTableModel(
			new Object[][] {
				{"123", "Padres"},
			},
			new String[] {
				"Codigo", "Nombre"
			}
		));
		scrollPane.setViewportView(jTableDocumento);
		
		control = new CFDocumentos(this);
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

	public JTable getjTableDocumento() {
		return jTableDocumento;
	}

	public void mostrorSoloControles(boolean lista)
	{
		if(lista)
		{
			this.remove(pnlControles);
			this.setSize(320, 300);
			btnAceptar.setVisible(false);
		}
		else
		{
			this.remove(scrollPane);
			this.setSize(350, 280);
		}
		btnCancelar.setVisible(false);
		btnEliminar.setVisible(false);
		btnModificar.setVisible(false);
		btnNuevo.setVisible(false);
	}
	
	
}

