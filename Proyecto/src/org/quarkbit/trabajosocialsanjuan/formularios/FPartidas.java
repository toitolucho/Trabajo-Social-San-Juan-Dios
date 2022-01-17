package org.quarkbit.trabajosocialsanjuan.formularios;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;

import org.quarkbit.trabajosocialsanjuan.controller.CFPartidas;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Partida;

public class FPartidas extends JDialog {

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
	private JTree jTreePartida;
	public CFPartidas control;
	private JLabel lblEstado;
	private JComboBox<Partida> cBoxPartidaPadre;
	private JLabel lblPrecio;
	private JTextField txtNombre;
	private JTextArea txtDescripcion;
	private JPopupMenu popupMenu;
	private JMenuItem mntmnuevo;
	private JMenuItem mntmModificar;
	private JMenuItem mntmEliminar;
	private JMenuItem mntmSalida;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FPartidas frame = new FPartidas();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
//	public void habilitarEventos()
//	{
//		control = new CFPartidas(this);
//		btnAceptar.addActionListener(control);
//		btnCancelar.addActionListener(control);
//		btnNuevo.addActionListener(control);
//		btnEliminar.addActionListener(control);
//		btnModificar.addActionListener(control);
//	}

	/**
	 * Create the frame.
	 */
	public FPartidas(JFrame owner) {
		super(owner, true);
		setTitle("Partidas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 605, 360);
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
		flowLayout.setVgap(15);
		pnlControles.setPreferredSize(new Dimension(320, 60));
		contentPane.add(pnlControles, BorderLayout.WEST);
		
		JLabel lblCodigo = new JLabel("Codigo :");
		lblCodigo.setPreferredSize(new Dimension(90, 14));
		pnlControles.add(lblCodigo);
		
		txtCodigo = new JTextField();
		pnlControles.add(txtCodigo);
		txtCodigo.setColumns(15);
		
		lblPrecio = new JLabel("Partida :");
		lblPrecio.setPreferredSize(new Dimension(90, 14));
		pnlControles.add(lblPrecio);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(15);
		pnlControles.add(txtNombre);
		
		lblEstado = new JLabel("Partida Padre :");
		lblEstado.setPreferredSize(new Dimension(90, 14));
		pnlControles.add(lblEstado);
		
		cBoxPartidaPadre = new JComboBox<Partida>();
		cBoxPartidaPadre.setPreferredSize(new Dimension(170, 22));
		pnlControles.add(cBoxPartidaPadre);
		
		JLabel lblDescripcin = new JLabel("Detalle :");
		lblDescripcin.setPreferredSize(new Dimension(90, 14));
		pnlControles.add(lblDescripcin);
		
		txtDescripcion = new JTextArea();
		txtDescripcion.setTabSize(5);
		txtDescripcion.setRows(3);
		txtDescripcion.setColumns(15);
		pnlControles.add(txtDescripcion);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		jTreePartida = new JTree();
		
		scrollPane.setViewportView(jTreePartida);
		
		popupMenu = new JPopupMenu();
//		addPopup(jTreePartida, popupMenu);
		
		mntmnuevo = new JMenuItem("Nuevo");
		mntmnuevo.setActionCommand("Nuevo");
		popupMenu.add(mntmnuevo);
		
		mntmModificar = new JMenuItem("Modificar");
		mntmModificar.setActionCommand("Modificar");
		popupMenu.add(mntmModificar);
		
		mntmEliminar = new JMenuItem("Eliminar");
		mntmEliminar.setActionCommand("Eliminar");
		popupMenu.add(mntmEliminar);
		
		
		popupMenu.addSeparator();
		
		mntmSalida = new JMenuItem("Nuevo Egreso");
		popupMenu.add(mntmSalida);
		
		
		control = new CFPartidas(this);
		control.onLoad();
	}

	public JPopupMenu getPopupMenu() {
		return popupMenu;
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

	

	public void mostrorSoloControles()
	{
		this.remove(scrollPane);
		this.setSize(350, 340);
		btnCancelar.setVisible(false);
		btnEliminar.setVisible(false);
		btnModificar.setVisible(false);
		btnNuevo.setVisible(false);
	}

	

	public JComboBox<Partida> getcBoxPartidaPadre() {
		return cBoxPartidaPadre;
	}

	public JTextField getTxtMonto() {
		return txtNombre;
	}

	public JTree getjTreePartida() {
		return jTreePartida;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}
	
	public JMenuItem getMntmnuevo() {
		return mntmnuevo;
	}

	public JMenuItem getMntmModificar() {
		return mntmModificar;
	}

	public JMenuItem getMntmEliminar() {
		return mntmEliminar;
	}

	public JMenuItem getMntmSalida() {
		return mntmSalida;
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}

