package org.quarkbit.trabajosocialsanjuan.formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.Dimension;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

import org.quarkbit.trabajosocialsanjuan.controller.CFUsuarios;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Institucion;
import javax.swing.DefaultComboBoxModel;

public class FUsuarios extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtCodigo;
	private JTextField txtNombreCompleto;
	private JTextField txtNombreCuenta;
	private JPasswordField txtPassword;
	private JDateChooser dateFechaRegistro;
	private JComboBox<Institucion> cBoxInstitucion;
	private JComboBox<String> cBoxEstado;
	private JButton btnAgregarPersona;
	private JButton btnBuscarPersona;
	private JButton btnNuevo;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnCerrar;
	private CFUsuarios control;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FUsuarios frame = new FUsuarios(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FUsuarios(JFrame owner) {
		super(owner,true);
		setTitle("Gestion de Usuarios");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		control = new CFUsuarios(this);
		
		JPanel pnlDatos = new JPanel();
		pnlDatos.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Datos de Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		FlowLayout flowLayout = (FlowLayout) pnlDatos.getLayout();
		flowLayout.setVgap(8);
		flowLayout.setHgap(10);
		flowLayout.setAlignment(FlowLayout.LEFT);
		pnlDatos.setPreferredSize(new Dimension(415, 10));
		contentPane.add(pnlDatos, BorderLayout.WEST);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setPreferredSize(new Dimension(120, 18));
		pnlDatos.add(lblCodigo);
		
		txtCodigo = new JTextField();
		pnlDatos.add(txtCodigo);
		txtCodigo.setColumns(13);
		
		JLabel lblNombreCompleto = new JLabel("Nombre Completo");
		lblNombreCompleto.setPreferredSize(new Dimension(120, 18));
		pnlDatos.add(lblNombreCompleto);
		
		txtNombreCompleto = new JTextField();
		txtNombreCompleto.setEditable(false);
		txtNombreCompleto.setColumns(13);
		pnlDatos.add(txtNombreCompleto);
		
		btnAgregarPersona = new JButton("+");
		btnAgregarPersona.setActionCommand("AgregarPersona");
		btnAgregarPersona.setMargin(new Insets(2, 5, 2, 5));
		pnlDatos.add(btnAgregarPersona);
		
		btnBuscarPersona = new JButton("...");
		btnBuscarPersona.setActionCommand("BuscarPersona");
		btnBuscarPersona.setMargin(new Insets(2, 2, 2, 2));
		pnlDatos.add(btnBuscarPersona);
		
		JLabel lblFechaRegistro = new JLabel("Fecha Registro");
		lblFechaRegistro.setPreferredSize(new Dimension(120, 18));
		pnlDatos.add(lblFechaRegistro);
		
		dateFechaRegistro = new JDateChooser();
		dateFechaRegistro.setPreferredSize(new Dimension(145, 22));
		pnlDatos.add(dateFechaRegistro);
		
		JLabel lblIstitucin = new JLabel("Istitucion");
		lblIstitucin.setPreferredSize(new Dimension(120, 18));
		pnlDatos.add(lblIstitucin);
		
		cBoxInstitucion = new JComboBox<Institucion>();
		cBoxInstitucion.setPreferredSize(new Dimension(150, 25));
		pnlDatos.add(cBoxInstitucion);
		
		JLabel lblEstado = new JLabel("Tipo");
		lblEstado.setPreferredSize(new Dimension(120, 18));
		pnlDatos.add(lblEstado);
		
		cBoxEstado = new JComboBox<String>();
		cBoxEstado.setModel(new DefaultComboBoxModel<String>(new String[] {"SECRETARIA","PSICOLOGO(A)", "MEDICO(A)", "VISITADORA SOCIAL", "DIRECTOR(A)", "ADMINISTRADOR(A)"}));
		cBoxEstado.setPreferredSize(new Dimension(150, 25));
		pnlDatos.add(cBoxEstado);
		
		JLabel lblNombreCuenta = new JLabel("Nombre Cuenta");
		lblNombreCuenta.setPreferredSize(new Dimension(120, 18));
		pnlDatos.add(lblNombreCuenta);
		
		txtNombreCuenta = new JTextField();
		pnlDatos.add(txtNombreCuenta);
		txtNombreCuenta.setColumns(13);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setPreferredSize(new Dimension(120, 18));
		pnlDatos.add(lblContrasea);
		
		txtPassword = new JPasswordField();
		txtPassword.setColumns(13);
		pnlDatos.add(txtPassword);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
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
		
		control.onFormShown();
	}

	public JTable getTable() {
		return table;
	}

	public JTextField getTxtCodigo() {
		return txtCodigo;
	}

	public JTextField getTxtNombreCompleto() {
		return txtNombreCompleto;
	}

	public JTextField getTxtNombreCuenta() {
		return txtNombreCuenta;
	}

	public JPasswordField getTxtPassword() {
		return txtPassword;
	}

	public JDateChooser getDateFechaRegistro() {
		return dateFechaRegistro;
	}

	public JComboBox<Institucion> getcBoxInstitucion() {
		return cBoxInstitucion;
	}

	public JComboBox<String> getcBoxEstado() {
		return cBoxEstado;
	}

	public JButton getBtnAgregarPersona() {
		return btnAgregarPersona;
	}

	public JButton getBtnBuscarPersona() {
		return btnBuscarPersona;
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
