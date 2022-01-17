package org.quarkbit.trabajosocialsanjuan.formularios;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.BoxLayout;

import org.quarkbit.trabajosocialsanjuan.controller.CFHistorialClinico;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;

public class FHistorialClinico extends JDialog {
	private JLabel lblNombreCompleto;
	private JTextField txtNroHC;
	private JTextField txtGrupoSanguineo;
	private JTable tableVacunas;
	private JTable tableAlergias;
	private JTable tableMedicamentos;
	private JTable tableEnfermedadesCronicas;
	private JTable tableIncidentes;
	private JTable tableVitaminas;
	private JTable tableLaboratorios;
	private JDateChooser dateFechaRegistro;
	private JButton btnNuevo;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnBuscar;
	private JButton btnCerrar;
	private JLabel lblFechaNacimiento;
	private JLabel lblEdad;
	private JPanel pnlHC;
	private JPanel pnlVacunas;
	private JPanel pnlAlergias;
	private JPanel pnlMedicamentos;
	private JPanel pnlLaboratorios;
	private JPanel pnlEnfermedadesCro;
	private JPanel pnlIncidentes;
	private JPanel pnlVitaminas;
	private JButton btnConsulta;
	private JButton btnReporte;
	public CFHistorialClinico control;
	private JPanel pnlConsultas;
	private JTable tableConsultas;
	private JScrollPane scrollPane_6;
	private JTabbedPane tabbedPaneHC;
	public JFrame owner;
	private JPanel panel;
	private JLabel lblDe;
	private JDateChooser dateFechaInicio;
	private JLabel lblAl;
	private JDateChooser dateFechaFin;
	private JLabel lblTextoBusqueda;
	private JTextField txtTextoBusqueda;
	private JButton btnBuscarConsulta;
	private JPopupMenu popupMenu;
	private JMenuItem mntmModificar;
	private JMenuItem mntmEliminar;
	private JMenuItem mntmReporte;
	public FHistorialClinico(JFrame owner) {
		super(owner, true);
		this.owner = owner;
		setTitle("Historial Clinico");
		control = new CFHistorialClinico(this);
		JPanel pnlBotones = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnlBotones.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(pnlBotones, BorderLayout.SOUTH);
		setSize(805,400);
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
		
		btnReporte = new JButton("Reporte");
		pnlBotones.add(btnReporte);
		
		btnConsulta = new JButton("Consulta");
		pnlBotones.add(btnConsulta);
		
		btnBuscar = new JButton("Buscar");
		pnlBotones.add(btnBuscar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon(FComidas.class.getResource("/imagenes/BOTONES/Cerrar01.png")));
		pnlBotones.add(btnCerrar);
		
		JPanel pnlDatosNino = new JPanel();
		getContentPane().add(pnlDatosNino, BorderLayout.NORTH);
		GridBagLayout gbl_pnlDatosNino = new GridBagLayout();
		gbl_pnlDatosNino.columnWidths = new int[]{147, 316, 0};
		gbl_pnlDatosNino.rowHeights = new int[]{16, 16, 16, 0};
		gbl_pnlDatosNino.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlDatosNino.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlDatosNino.setLayout(gbl_pnlDatosNino);
		
		JLabel lblNombreNio = new JLabel("Nombre Ni\u00F1o :");
		GridBagConstraints gbc_lblNombreNio = new GridBagConstraints();
		gbc_lblNombreNio.anchor = GridBagConstraints.WEST;
		gbc_lblNombreNio.fill = GridBagConstraints.VERTICAL;
		gbc_lblNombreNio.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreNio.gridx = 0;
		gbc_lblNombreNio.gridy = 0;
		pnlDatosNino.add(lblNombreNio, gbc_lblNombreNio);
		
		lblNombreCompleto = new JLabel("Rosmeri Lopez Rueda");
		lblNombreCompleto.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		GridBagConstraints gbc_lblNombreCompleto = new GridBagConstraints();
		gbc_lblNombreCompleto.fill = GridBagConstraints.BOTH;
		gbc_lblNombreCompleto.insets = new Insets(0, 0, 5, 0);
		gbc_lblNombreCompleto.gridx = 1;
		gbc_lblNombreCompleto.gridy = 0;
		pnlDatosNino.add(lblNombreCompleto, gbc_lblNombreCompleto);
		
		JLabel lblEtiquetaFechaDeNacimiento = new JLabel("Fecha de Nacimiento :");
		GridBagConstraints gbc_lblEtiquetaFechaDeNacimiento = new GridBagConstraints();
		gbc_lblEtiquetaFechaDeNacimiento.anchor = GridBagConstraints.WEST;
		gbc_lblEtiquetaFechaDeNacimiento.fill = GridBagConstraints.VERTICAL;
		gbc_lblEtiquetaFechaDeNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblEtiquetaFechaDeNacimiento.gridx = 0;
		gbc_lblEtiquetaFechaDeNacimiento.gridy = 1;
		pnlDatosNino.add(lblEtiquetaFechaDeNacimiento, gbc_lblEtiquetaFechaDeNacimiento);
		
		lblFechaNacimiento = new JLabel("18/12/1990");
		lblFechaNacimiento.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		GridBagConstraints gbc_lblFechaNacimiento = new GridBagConstraints();
		gbc_lblFechaNacimiento.fill = GridBagConstraints.BOTH;
		gbc_lblFechaNacimiento.insets = new Insets(0, 0, 5, 0);
		gbc_lblFechaNacimiento.gridx = 1;
		gbc_lblFechaNacimiento.gridy = 1;
		pnlDatosNino.add(lblFechaNacimiento, gbc_lblFechaNacimiento);
		
		JLabel lblEtiquetaEdad = new JLabel("Edad:");
		GridBagConstraints gbc_lblEtiquetaEdad = new GridBagConstraints();
		gbc_lblEtiquetaEdad.anchor = GridBagConstraints.WEST;
		gbc_lblEtiquetaEdad.fill = GridBagConstraints.VERTICAL;
		gbc_lblEtiquetaEdad.insets = new Insets(0, 0, 0, 5);
		gbc_lblEtiquetaEdad.gridx = 0;
		gbc_lblEtiquetaEdad.gridy = 2;
		pnlDatosNino.add(lblEtiquetaEdad, gbc_lblEtiquetaEdad);
		
		lblEdad = new JLabel("23");
		lblEdad.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		GridBagConstraints gbc_lblEdad = new GridBagConstraints();
		gbc_lblEdad.fill = GridBagConstraints.BOTH;
		gbc_lblEdad.gridx = 1;
		gbc_lblEdad.gridy = 2;
		pnlDatosNino.add(lblEdad, gbc_lblEdad);
		
		tabbedPaneHC = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPaneHC, BorderLayout.CENTER);
		
		pnlHC = new JPanel();
		FlowLayout fl_pnlHC = (FlowLayout) pnlHC.getLayout();
		fl_pnlHC.setVgap(14);
		fl_pnlHC.setHgap(10);
		fl_pnlHC.setAlignment(FlowLayout.LEFT);
		tabbedPaneHC.addTab("Historial Clinico", null, pnlHC, null);
		
		JLabel lblNroDeHistorial = new JLabel("Nro de Historial Clinico");
		lblNroDeHistorial.setPreferredSize(new Dimension(150, 16));
		pnlHC.add(lblNroDeHistorial);
		
		txtNroHC = new JTextField();
		txtNroHC.setEditable(false);
		pnlHC.add(txtNroHC);
		txtNroHC.setColumns(15);
		
		JLabel label = new JLabel("");
		label.setPreferredSize(new Dimension(300, 16));
		pnlHC.add(label);
		
		JLabel lblNewLabel = new JLabel("Grupo Sanguineo");
		lblNewLabel.setPreferredSize(new Dimension(150, 16));
		pnlHC.add(lblNewLabel);
		
		txtGrupoSanguineo = new JTextField();
		txtGrupoSanguineo.setColumns(15);
		pnlHC.add(txtGrupoSanguineo);
		
		JLabel label_1 = new JLabel("");
		label_1.setPreferredSize(new Dimension(300, 16));
		pnlHC.add(label_1);
		
		JLabel lblFechaDeRegistro = new JLabel("Fecha de Registro");
		lblFechaDeRegistro.setPreferredSize(new Dimension(150, 16));
		pnlHC.add(lblFechaDeRegistro);
		
		dateFechaRegistro = new JDateChooser();
		dateFechaRegistro.setDateFormatString("dd-MM-yyyy");
		dateFechaRegistro.setPreferredSize(new Dimension(150, 22));
		pnlHC.add(dateFechaRegistro);
		
		pnlVacunas = new JPanel();
		tabbedPaneHC.addTab("Vacunas", null, pnlVacunas, null);
		pnlVacunas.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pnlVacunas.add(scrollPane);
		
		tableVacunas = new JTable();
		scrollPane.setViewportView(tableVacunas);
		
		pnlAlergias = new JPanel();
		tabbedPaneHC.addTab("Alergias", null, pnlAlergias, null);
		pnlAlergias.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pnlAlergias.add(scrollPane_1);
		
		tableAlergias = new JTable();
		scrollPane_1.setViewportView(tableAlergias);
		
		pnlMedicamentos = new JPanel();
		tabbedPaneHC.addTab("Medicamentos", null, pnlMedicamentos, null);
		pnlMedicamentos.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_5 = new JScrollPane();
		pnlMedicamentos.add(scrollPane_5);
		
		tableMedicamentos = new JTable();
		scrollPane_5.setViewportView(tableMedicamentos);
		
		pnlLaboratorios = new JPanel();
		tabbedPaneHC.addTab("Laboratorios", null, pnlLaboratorios, null);
		pnlLaboratorios.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_7 = new JScrollPane();
		pnlLaboratorios.add(scrollPane_7);
		
		tableLaboratorios = new JTable();
		scrollPane_7.setViewportView(tableLaboratorios);
		
		pnlEnfermedadesCro = new JPanel();
		tabbedPaneHC.addTab("Enf. Cronicas", null, pnlEnfermedadesCro, null);
		pnlEnfermedadesCro.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		pnlEnfermedadesCro.add(scrollPane_2);
		
		tableEnfermedadesCronicas = new JTable();
		scrollPane_2.setViewportView(tableEnfermedadesCronicas);
		
		pnlIncidentes = new JPanel();
		tabbedPaneHC.addTab("Incidentes", null, pnlIncidentes, null);
		pnlIncidentes.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_3 = new JScrollPane();
		pnlIncidentes.add(scrollPane_3);
		
		tableIncidentes = new JTable();
		scrollPane_3.setViewportView(tableIncidentes);
		
		pnlVitaminas = new JPanel();
		tabbedPaneHC.addTab("Vitaminas", null, pnlVitaminas, null);
		pnlVitaminas.setLayout(new BoxLayout(pnlVitaminas, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane_4 = new JScrollPane();
		pnlVitaminas.add(scrollPane_4);
		
		tableVitaminas = new JTable();
		scrollPane_4.setViewportView(tableVitaminas);
		
		pnlConsultas = new JPanel();
		tabbedPaneHC.addTab("Consultas", null, pnlConsultas, null);
		pnlConsultas.setLayout(new BorderLayout(0, 0));
		
		scrollPane_6 = new JScrollPane();
		scrollPane_6.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pnlConsultas.add(scrollPane_6, BorderLayout.CENTER);
		
		
		
		tableConsultas = new JTable();
		scrollPane_6.setViewportView(tableConsultas);
		
		popupMenu = new JPopupMenu();
		addPopup(tableConsultas, popupMenu);
		
		mntmModificar = new JMenuItem("Modificar");
		mntmModificar.setActionCommand("ModificarConsulta");
		popupMenu.add(mntmModificar);
		
		mntmEliminar = new JMenuItem("Eliminar");
		mntmEliminar.setActionCommand("EliminarConsulta");
		popupMenu.add(mntmEliminar);
		
		mntmReporte = new JMenuItem("Reporte");
		mntmReporte.setActionCommand("ReporteConsulta");
		popupMenu.add(mntmReporte);
		
		
		
		panel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		pnlConsultas.add(panel, BorderLayout.NORTH);
		
		lblDe = new JLabel("De");
		panel.add(lblDe);
		
		dateFechaInicio = new JDateChooser();
		dateFechaInicio.setDateFormatString("dd-MM-yyyy");
		panel.add(dateFechaInicio);
		
		lblAl = new JLabel("al");
		panel.add(lblAl);
		
		dateFechaFin = new JDateChooser();
		dateFechaFin.setDateFormatString("dd-MM-yyyy");
		panel.add(dateFechaFin);
		
		lblTextoBusqueda = new JLabel("Texto Busqueda");
		panel.add(lblTextoBusqueda);
		
		txtTextoBusqueda = new JTextField();
		txtTextoBusqueda.setActionCommand("BuscarConsulta");
		panel.add(txtTextoBusqueda);
		txtTextoBusqueda.setColumns(13);
		
		btnBuscarConsulta = new JButton("Buscar");
		btnBuscarConsulta.setActionCommand("BuscarConsulta");
		panel.add(btnBuscarConsulta);
		
		control.onFormShown();
	}
	public JLabel getLblNombreCompleto() {
		return lblNombreCompleto;
	}
	public JTextField getTxtNroHC() {
		return txtNroHC;
	}
	public JTextField getTxtGrupoSanguineo() {
		return txtGrupoSanguineo;
	}
	public JTable getTableVacunas() {
		return tableVacunas;
	}
	public JTable getTableAlergias() {
		return tableAlergias;
	}
	public JTable getTableMedicamentos() {
		return tableMedicamentos;
	}
	public JTable getTableEnfermedadesCronicas() {
		return tableEnfermedadesCronicas;
	}
	public JTable getTableIncidentes() {
		return tableIncidentes;
	}
	public JTable getTableVitaminas() {
		return tableVitaminas;
	}
	public JTable getTableLaboratorios() {
		return tableLaboratorios;
	}
	public JDateChooser getDateFechaRegistro() {
		return dateFechaRegistro;
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
	public JButton getBtnBuscar() {
		return btnBuscar;
	}
	public JButton getBtnCerrar() {
		return btnCerrar;
	}
	public JLabel getLblFechaNacimiento() {
		return lblFechaNacimiento;
	}
	public JLabel getLblEdad() {
		return lblEdad;
	}
	public JPanel getPnlHC() {
		return pnlHC;
	}
	public JPanel getPnlVacunas() {
		return pnlVacunas;
	}
	public JPanel getPnlAlergias() {
		return pnlAlergias;
	}
	public JPanel getPnlMedicamentos() {
		return pnlMedicamentos;
	}
	public JPanel getPnlLaboratorios() {
		return pnlLaboratorios;
	}
	public JPanel getPnlEnfermedadesCro() {
		return pnlEnfermedadesCro;
	}
	public JPanel getPnlIncidentes() {
		return pnlIncidentes;
	}
	public JPanel getPnlVitaminas() {
		return pnlVitaminas;
	}
	public JButton getBtnConsulta() {
		return btnConsulta;
	}
	public JButton getBtnReporte() {
		return btnReporte;
	}
	public JPanel getPnlConsultas() {
		return pnlConsultas;
	}
	public JTable getTableConsultas() {
		return tableConsultas;
	}
	public JTabbedPane getTabbedPaneHC() {
		return tabbedPaneHC;
	}
	public JDateChooser getDateFechaInicio() {
		return dateFechaInicio;
	}
	public JDateChooser getDateFechaFin() {
		return dateFechaFin;
	}
	public JTextField getTxtTextoBusqueda() {
		return txtTextoBusqueda;
	}
	public JButton getBtnBuscarConsulta() {
		return btnBuscarConsulta;
	}
	
	
	

	public JPopupMenu getPopupMenu() {
		return popupMenu;
	}
	public JMenuItem getMntmModificar() {
		return mntmModificar;
	}
	public JMenuItem getMntmEliminar() {
		return mntmEliminar;
	}
	public JMenuItem getMntmReporte() {
		return mntmReporte;
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
