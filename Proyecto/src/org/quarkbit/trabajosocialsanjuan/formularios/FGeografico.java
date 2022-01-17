package org.quarkbit.trabajosocialsanjuan.formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Dimension;
import javax.swing.JComboBox;

import javax.swing.JTable;

import org.quarkbit.trabajosocialsanjuan.controller.CFGeografico;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Departamento;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Pais;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Provincia;


public class FGeografico extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTextoBusqueda;
	private JTextField txtCodigo;
	private JTextField txtNombrePais;
	private JTextField txtNacionalidad;
	private JTextField txtCodigoDep;
	private JTextField txtNombreDep;
	private JTextField txtCodigoProv;
	private JTextField txtNombreProv;
	private JTextField txtCodigoLugar;
	private JTextField txtNombreLugar;
	private JTable tableGeografico;
	private JButton btnNuevo;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnCerrar;
	private JComboBox<Pais> cBoxPaisDep;
	private JComboBox<Pais> cBoxPaisProv;
	private JComboBox<Departamento> cBoxDepartamentoProv;
	private JComboBox<Pais> cBoxPaisLugar;
	private JComboBox<Departamento> cBoxDepartamentoLugar;
	private JComboBox<Provincia> cBoxProvinciaLugar;
	private CFGeografico control;
	private JTabbedPane tabbedPane;
	private JPanel pnlPaises;
	private JPanel pnlDepartamentos;
	private JPanel pnlProvincias;
	private JPanel pnlLugares;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FGeografico frame = new FGeografico();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public FGeografico(JFrame owner) {
		super(owner, true);
		setTitle("Configuracion Lugares Geograficos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 857, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		control = new CFGeografico(this);
		
		JPanel pnlBotones = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnlBotones.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(pnlBotones, BorderLayout.SOUTH);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setIcon(new ImageIcon(FComidas.class.getResource("/imagenes/BOTONES/Nuevo01.png")));
		btnNuevo.setMnemonic('N');
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
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.WEST);
		tabbedPane.setPreferredSize(new Dimension(400, 5));
		
		pnlPaises = new JPanel();
		FlowLayout fl_pnlPaises = (FlowLayout) pnlPaises.getLayout();
		fl_pnlPaises.setVgap(15);
		tabbedPane.addTab("Paises", null, pnlPaises, "Paises");
		
		JLabel lblCodigo = new JLabel("Codigo :");
		lblCodigo.setVisible(false);
		lblCodigo.setPreferredSize(new Dimension(140, 16));
		pnlPaises.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setVisible(false);
		pnlPaises.add(txtCodigo);
		txtCodigo.setColumns(18);
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setPreferredSize(new Dimension(140, 16));
		pnlPaises.add(lblNombre);
		
		txtNombrePais = new JTextField();
		txtNombrePais.setColumns(18);
		pnlPaises.add(txtNombrePais);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad :");
		lblNacionalidad.setPreferredSize(new Dimension(140, 16));
		pnlPaises.add(lblNacionalidad);
		
		txtNacionalidad = new JTextField();
		txtNacionalidad.setColumns(18);
		pnlPaises.add(txtNacionalidad);
		
		pnlDepartamentos = new JPanel();
		FlowLayout fl_pnlDepartamentos = (FlowLayout) pnlDepartamentos.getLayout();
		fl_pnlDepartamentos.setHgap(10);
		fl_pnlDepartamentos.setAlignment(FlowLayout.LEFT);
		fl_pnlDepartamentos.setVgap(15);
		tabbedPane.addTab("Departamentos", null, pnlDepartamentos, null);
		
		JLabel label = new JLabel("Codigo :");
		label.setVisible(false);
		label.setPreferredSize(new Dimension(140, 16));
		pnlDepartamentos.add(label);
		
		txtCodigoDep = new JTextField();
		txtCodigoDep.setVisible(false);
		txtCodigoDep.setColumns(18);
		pnlDepartamentos.add(txtCodigoDep);
		
		JLabel lblPais = new JLabel("Pais :");
		lblPais.setPreferredSize(new Dimension(140, 16));
		pnlDepartamentos.add(lblPais);
		
		cBoxPaisDep = new JComboBox<Pais>();
		cBoxPaisDep.setPreferredSize(new Dimension(200, 22));
		pnlDepartamentos.add(cBoxPaisDep);
		
		JLabel lblDepartamento = new JLabel("Departamento :");
		lblDepartamento.setPreferredSize(new Dimension(140, 16));
		pnlDepartamentos.add(lblDepartamento);
		
		txtNombreDep = new JTextField();
		txtNombreDep.setColumns(18);
		pnlDepartamentos.add(txtNombreDep);
		
		pnlProvincias = new JPanel();
		FlowLayout fl_pnlProvincias = (FlowLayout) pnlProvincias.getLayout();
		fl_pnlProvincias.setAlignment(FlowLayout.LEFT);
		fl_pnlProvincias.setVgap(20);
		tabbedPane.addTab("Provincias", null, pnlProvincias, null);
		
		JLabel label_1 = new JLabel("Codigo :");
		label_1.setVisible(false);
		label_1.setPreferredSize(new Dimension(140, 16));
		pnlProvincias.add(label_1);
		
		txtCodigoProv = new JTextField();
		txtCodigoProv.setVisible(false);
		txtCodigoProv.setColumns(18);
		pnlProvincias.add(txtCodigoProv);
		
		JLabel label_2 = new JLabel("Pais :");
		label_2.setPreferredSize(new Dimension(140, 16));
		pnlProvincias.add(label_2);
		
		cBoxPaisProv = new JComboBox<Pais>();
		cBoxPaisProv.setPreferredSize(new Dimension(200, 22));
		pnlProvincias.add(cBoxPaisProv);
		
		JLabel label_3 = new JLabel("Departamento :");
		label_3.setPreferredSize(new Dimension(140, 16));
		pnlProvincias.add(label_3);
		
		cBoxDepartamentoProv = new JComboBox<Departamento>();
		cBoxDepartamentoProv.setPreferredSize(new Dimension(200, 22));
		pnlProvincias.add(cBoxDepartamentoProv);
		
		JLabel lblProvincia = new JLabel("Provincia :");
		lblProvincia.setPreferredSize(new Dimension(140, 16));
		pnlProvincias.add(lblProvincia);
		
		txtNombreProv = new JTextField();
		txtNombreProv.setColumns(18);
		pnlProvincias.add(txtNombreProv);
		
		pnlLugares = new JPanel();
		FlowLayout fl_pnlLugares = (FlowLayout) pnlLugares.getLayout();
		fl_pnlLugares.setAlignment(FlowLayout.LEFT);
		fl_pnlLugares.setVgap(15);
		tabbedPane.addTab("Lugares", null, pnlLugares, null);
		
		JLabel label_4 = new JLabel("Codigo :");
		label_4.setVisible(false);
		label_4.setPreferredSize(new Dimension(140, 16));
		pnlLugares.add(label_4);
		
		txtCodigoLugar = new JTextField();
		txtCodigoLugar.setVisible(false);
		txtCodigoLugar.setColumns(18);
		pnlLugares.add(txtCodigoLugar);
		
		JLabel label_5 = new JLabel("Pais :");
		label_5.setPreferredSize(new Dimension(140, 16));
		pnlLugares.add(label_5);
		
		cBoxPaisLugar = new JComboBox<Pais>();
		cBoxPaisLugar.setPreferredSize(new Dimension(200, 22));
		pnlLugares.add(cBoxPaisLugar);
		
		JLabel label_6 = new JLabel("Departamento :");
		label_6.setPreferredSize(new Dimension(140, 16));
		pnlLugares.add(label_6);
		
		cBoxDepartamentoLugar = new JComboBox<Departamento>();
		cBoxDepartamentoLugar.setPreferredSize(new Dimension(200, 22));
		pnlLugares.add(cBoxDepartamentoLugar);
		
		JLabel label_7 = new JLabel("Provincia :");
		label_7.setPreferredSize(new Dimension(140, 16));
		pnlLugares.add(label_7);
		
		cBoxProvinciaLugar = new JComboBox<Provincia>();
		cBoxProvinciaLugar.setPreferredSize(new Dimension(200, 22));
		pnlLugares.add(cBoxProvinciaLugar);
		
		JLabel lblLugar = new JLabel("Lugar:");
		lblLugar.setPreferredSize(new Dimension(140, 16));
		pnlLugares.add(lblLugar);
		
		txtNombreLugar = new JTextField();
		txtNombreLugar.setColumns(18);
		pnlLugares.add(txtNombreLugar);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		tableGeografico = new JTable();
		
		scrollPane.setViewportView(tableGeografico);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setHgap(10);
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblTextoBusqueda = new JLabel("Texto Busqueda :");
		panel_1.add(lblTextoBusqueda);
		
		txtTextoBusqueda = new JTextField();
		panel_1.add(txtTextoBusqueda);
		txtTextoBusqueda.setColumns(15);
		
		control.onLoad();
	}

	public JTextField getTxtTextoBusqueda() {
		return txtTextoBusqueda;
	}

	public JTextField getTxtCodigo() {
		return txtCodigo;
	}

	public JTextField getTxtNombrePais() {
		return txtNombrePais;
	}

	public JTextField getTxtNacionalidad() {
		return txtNacionalidad;
	}

	public JTextField getTxtCodigoDep() {
		return txtCodigoDep;
	}

	public JTextField getTxtNombreDep() {
		return txtNombreDep;
	}

	public JTextField getTxtCodigoProv() {
		return txtCodigoProv;
	}

	public JTextField getTxtNombreProv() {
		return txtNombreProv;
	}

	public JTextField getTxtCodigoLugar() {
		return txtCodigoLugar;
	}

	public JTextField getTxtNombreLugar() {
		return txtNombreLugar;
	}

	public JTable getTableGeografico() {
		return tableGeografico;
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

	public JComboBox<Pais> getcBoxPaisDep() {
		return cBoxPaisDep;
	}

	public JComboBox<Pais> getcBoxPaisProv() {
		return cBoxPaisProv;
	}

	public JComboBox<Departamento> getcBoxDepartamentoProv() {
		return cBoxDepartamentoProv;
	}

	public JComboBox<Pais> getcBoxPaisLugar() {
		return cBoxPaisLugar;
	}

	public JComboBox<Departamento> getcBoxDepartamentoLugar() {
		return cBoxDepartamentoLugar;
	}

	public JComboBox<Provincia> getcBoxProvinciaLugar() {
		return cBoxProvinciaLugar;
	}

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public JPanel getPnlPaises() {
		return pnlPaises;
	}

	public JPanel getPnlDepartamentos() {
		return pnlDepartamentos;
	}

	public JPanel getPnlProvincias() {
		return pnlProvincias;
	}

	public JPanel getPnlLugares() {
		return pnlLugares;
	}

	public CFGeografico getControl() {
		return control;
	}

	
}
