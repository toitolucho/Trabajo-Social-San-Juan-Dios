package org.quarkbit.trabajosocialsanjuan.formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.JToggleButton;

import org.quarkbit.trabajosocialsanjuan.controller.CFPrincipal;
import org.quarkbit.trabajosocialsanjuan.utils.componentes.ToolButton;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FPrincipal extends JFrame {

	private JPanel contentPane;
	public CFPrincipal control;
	private JLabel lblSistema;
	private JLabel lblUsuario;
	public JMenu mnArchivo;
	public JMenu mnKardex;
	public JMenu mnMovimientos;
	public JMenu mnPlanificacin;
	public JMenu mnInformes;
	public JButton btnConfiguracin;
	public JButton btnKardex;
	public JButton btnAdmIngEg;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FPrincipal frame = new FPrincipal();
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
	public FPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 378);
		
		setTitle("Sistema TATA JUAN DE DIOS");
		
		control = new CFPrincipal(this);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenu mnAdministracion = new JMenu("Administracion");
		mnArchivo.add(mnAdministracion);
		
		JMenuItem mntmEmpleos = new JMenuItem("Empleos");
		mntmEmpleos.addActionListener(control);			
		mnAdministracion.add(mntmEmpleos);
		
		JMenuItem mntmTiposIngresos = new JMenuItem("Fuentes de Ingreso");
		mntmTiposIngresos.setActionCommand("TiposIngresos");
		mntmTiposIngresos.addActionListener(control);
		mnAdministracion.add(mntmTiposIngresos);
		
		JMenuItem mntmProveedores = new JMenuItem("Proveedores");
		mntmProveedores.addActionListener(control);
		mnAdministracion.add(mntmProveedores);
		
		JMenuItem mntmInstituciones = new JMenuItem("Instituciones");
		mntmInstituciones.addActionListener(control);
		mnAdministracion.add(mntmInstituciones);
		
		JMenuItem mntmPartidas = new JMenuItem("Partidas");
		mntmPartidas.addActionListener(control);
		mnAdministracion.add(mntmPartidas);
		
		JMenu mnGeogrfico = new JMenu("Geografico");
		mnArchivo.add(mnGeogrfico);
		
		JMenuItem mntmConfiguracin = new JMenuItem("Configuracion");
		mntmConfiguracin.addActionListener(control);
		mnGeogrfico.add(mntmConfiguracin);
		
		JMenuItem mntmPaises = new JMenuItem("Paises");
		mntmPaises.addActionListener(control);
		mnGeogrfico.add(mntmPaises);
		
		JMenuItem mntmDepartamentos = new JMenuItem("Departamentos");
		mntmDepartamentos.addActionListener(control);
		mnGeogrfico.add(mntmDepartamentos);
		
		JMenuItem mntmProvincias = new JMenuItem("Provincias");
		mntmProvincias.addActionListener(control);
		mnGeogrfico.add(mntmProvincias);
		
		JMenuItem mntmLugares = new JMenuItem("Lugares");
		mntmLugares.addActionListener(control);
		mnGeogrfico.add(mntmLugares);
		
		mnArchivo.addSeparator();
		
		JMenuItem mntmUsuarios = new JMenuItem("Usuarios");
		mntmUsuarios.addActionListener(control);
		mnArchivo.add(mntmUsuarios);
		
		JMenuItem mntmContrasenia = new JMenuItem("Cambiar Contrasenia");
		mntmContrasenia.setActionCommand("cambiarContrasenia");
		mntmContrasenia.addActionListener(control);
		mnArchivo.add(mntmContrasenia);
		
		mnArchivo.addSeparator();
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(control);
		mnArchivo.add(mntmSalir);
		
		mnKardex = new JMenu("Kardex");		
		menuBar.add(mnKardex);
		
		JMenuItem mntmRegistro = new JMenuItem("Registro");
		mntmRegistro.addActionListener(control);
		mnKardex.add(mntmRegistro);
		
		JMenuItem mntmBusqueda = new JMenuItem("Busqueda");
		mntmBusqueda.addActionListener(control);
		mnKardex.add(mntmBusqueda);
		
		JMenuItem mntmDocumentos = new JMenuItem("Documentos");
		mntmDocumentos.addActionListener(control);
		mnKardex.add(mntmDocumentos);
		
		JMenuItem mntmFamiliares = new JMenuItem("Familiares");
		mntmFamiliares.addActionListener(control);
		mnKardex.add(mntmFamiliares);
		
		mnMovimientos = new JMenu("Movimientos");
		menuBar.add(mnMovimientos);
		
		JMenuItem mntmAdministrador = new JMenuItem("Administrador");
		mntmAdministrador.setActionCommand("AdministradorIE");
		mntmAdministrador.addActionListener(control);
		mnMovimientos.add(mntmAdministrador);
		
		JMenuItem mntmIngresos = new JMenuItem("Ingresos");
		mntmIngresos.addActionListener(control);
		mnMovimientos.add(mntmIngresos);
		
		JMenuItem mntmTiposIngresos_1 = new JMenuItem("Fuentes de Ingresos");
		mntmTiposIngresos_1.setActionCommand("TiposIngresos");
		mntmTiposIngresos_1.addActionListener(control);
		mnMovimientos.add(mntmTiposIngresos_1);
		
		JMenuItem mntmSalidas = new JMenuItem("Salidas");
		mntmSalidas.addActionListener(control);
		mnMovimientos.add(mntmSalidas);
		
		mnPlanificacin = new JMenu("Planificacion");
		menuBar.add(mnPlanificacin);
		
		JMenuItem mntmCategorias = new JMenuItem("Categorias");
		mntmCategorias.addActionListener(control);
		mnPlanificacin.add(mntmCategorias);
		
		JMenuItem mntmComidas = new JMenuItem("Comidas");
		mntmComidas.addActionListener(control);
		mnPlanificacin.add(mntmComidas);
		
		JMenuItem mntmMenus = new JMenuItem("Menus");
		mntmMenus.addActionListener(control);
		mnPlanificacin.add(mntmMenus);
		
		mnInformes = new JMenu("Informes");
		menuBar.add(mnInformes);
		
		JMenuItem mntmGeneral = new JMenuItem("General");
		mntmGeneral.addActionListener(control);
		mnInformes.add(mntmGeneral);
		
		JMenuItem mntmPsicolgico = new JMenuItem("Psicologico");
		mntmPsicolgico.setActionCommand("Psicolgico");
		mntmPsicolgico.addActionListener(control);
//		mntmPsicolgico.setVisible(false);
		mnInformes.add(mntmPsicolgico);
		
		JMenu mnHistorialClnico = new JMenu("Historial Clinico");
		menuBar.add(mnHistorialClnico);
		
		JMenuItem mntmRegistro_1 = new JMenuItem("Registro");
		mntmRegistro_1.setActionCommand("RegistroHC");
		mntmRegistro_1.addActionListener(control);
		mnHistorialClnico.add(mntmRegistro_1);
		
		JMenuItem mntmCategoriasConsulta = new JMenuItem("Categorias Consulta");
		mntmCategoriasConsulta.addActionListener(control);
		mnHistorialClnico.add(mntmCategoriasConsulta);
		
		JMenu mnReportes = new JMenu("Reportes");
		menuBar.add(mnReportes);
		
		JMenu mnUsuarios = new JMenu("Usuarios");
		mnReportes.add(mnUsuarios);
		
		JMenuItem mntmListadoGeneral = new JMenuItem("Listado General");
		mntmListadoGeneral.setActionCommand("listadoUsuarios");
		mntmListadoGeneral.addActionListener(control);		
		mnUsuarios.add(mntmListadoGeneral);
		
		JMenuItem mntmCuentas = new JMenuItem("Cuentas");
		mntmCuentas.setActionCommand("cuentasUsuario");
		mntmCuentas.addActionListener(control);
		mnUsuarios.add(mntmCuentas);
		
		JMenuItem mntmIndividual = new JMenuItem("Individual");
		mntmIndividual.setActionCommand("informeUsuarioIndividual");
		mntmIndividual.addActionListener(control);
		mnUsuarios.add(mntmIndividual);
		
		JMenu mnKardex_1 = new JMenu("Kardex");
		mnReportes.add(mnKardex_1);
		
		JMenuItem mntmInformeGeneral = new JMenuItem("Informe General");
		mntmInformeGeneral.addActionListener(control);
		mnKardex_1.add(mntmInformeGeneral);
		
		JMenuItem mntmDocumentos_1 = new JMenuItem("Documentos");
		mntmDocumentos_1.addActionListener(control);
		mntmDocumentos_1.setActionCommand("ReporteDocumentos");
		mnKardex_1.add(mntmDocumentos_1);
		
		JMenuItem mntmFamiliares_1 = new JMenuItem("Familiares");
		mntmFamiliares_1.addActionListener(control);
		mntmFamiliares_1.setActionCommand("ReporteFamiliares");
		mnKardex_1.add(mntmFamiliares_1);
		
		JMenu mnIngresosYGastos = new JMenu("Ingresos y Gastos");		
		mnReportes.add(mnIngresosYGastos);
		
		JMenuItem mntmIngresos_1 = new JMenuItem("Ingresos");
		mntmIngresos_1.addActionListener(control);
		mntmIngresos_1.setActionCommand("ReporteIngresos");
		mnIngresosYGastos.add(mntmIngresos_1);
		
		JMenuItem mntmEgresosPorPartida = new JMenuItem("Egresos por Partida");
		mntmEgresosPorPartida.addActionListener(control);
		mnIngresosYGastos.add(mntmEgresosPorPartida);
		
		JMenuItem mntmEgresosPorProveedor = new JMenuItem("Egresos por Proveedor");
		mntmEgresosPorProveedor.addActionListener(control);
		mnIngresosYGastos.add(mntmEgresosPorProveedor);
		
		JMenuItem mntmIngresosYEgresos = new JMenuItem("Ingresos y Egresos");
		mntmIngresosYEgresos.addActionListener(control);
		mnIngresosYGastos.add(mntmIngresosYEgresos);
		
		JMenuItem mntmIngresosYEgresos_1 = new JMenuItem("Donaciones por Fuente de Ingreso");
		mntmIngresosYEgresos_1.addActionListener(control);
		mnIngresosYGastos.add(mntmIngresosYEgresos_1);
		
		JMenuItem mntmProveedores_1 = new JMenuItem("Proveedores");
		mntmProveedores_1.addActionListener(control);
		mntmProveedores_1.setActionCommand("ReporteProveedores");
		mnReportes.add(mntmProveedores_1);
		
		JMenuItem mntmFuentesDeIngreso = new JMenuItem("Fuentes de Ingreso");
		mntmFuentesDeIngreso.addActionListener(control);
		mnReportes.add(mntmFuentesDeIngreso);
		
		JMenuItem mntmPartidas_1 = new JMenuItem("Partidas");
		mntmPartidas_1.addActionListener(control);
		mntmPartidas_1.setActionCommand("ReportePartidas");
		mnReportes.add(mntmPartidas_1);
		
		JMenu mnPlanificacin_1 = new JMenu("Planificacion");
		mnReportes.add(mnPlanificacin_1);
		
		JMenuItem mntmCategorasDeComida = new JMenuItem("Categorias de Comida");
		mntmCategorasDeComida.addActionListener(control);
		mntmCategorasDeComida.setActionCommand("ReporteCategoriaComida");
		mnPlanificacin_1.add(mntmCategorasDeComida);
		
		JMenuItem mntmComidas_1 = new JMenuItem("Comidas");
		mntmComidas_1.addActionListener(control);
		mntmComidas_1.setActionCommand("ReporteComidas");
		mnPlanificacin_1.add(mntmComidas_1);
		
		JMenuItem mntmMenSemanal = new JMenuItem("Men\u00FA Semanal");
		mntmMenSemanal.setActionCommand("ReporteMenuSemanal");
		mntmMenSemanal.addActionListener(control);
		mnPlanificacin_1.add(mntmMenSemanal);
		
		JMenu mnEstadsticos = new JMenu("Estadisticos");
		mnReportes.add(mnEstadsticos);
		
		JMenuItem mntmCantidadNios = new JMenuItem("Cantidad Ni\u00F1os");
		mntmCantidadNios.addActionListener(control);
		mntmCantidadNios.setActionCommand("ReporteCantidadNinos");
		mnEstadsticos.add(mntmCantidadNios);
		
		JMenuItem mntmDonacionesRecibidas = new JMenuItem("Donaciones Recibidas");
		mntmDonacionesRecibidas.addActionListener(control);
		mntmDonacionesRecibidas.setActionCommand("ReporteDonacionesRecibidas");
		mnEstadsticos.add(mntmDonacionesRecibidas);
		
		JMenuItem mntmNiosPorEdad = new JMenuItem("Ni\u00F1os Por Edad y Sexo");
		mntmNiosPorEdad.addActionListener(control);
		mntmNiosPorEdad.setActionCommand("NinosEdadSexo");
		mnEstadsticos.add(mntmNiosPorEdad);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlStatusBar = new JPanel();
		pnlStatusBar.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		FlowLayout flowLayout = (FlowLayout) pnlStatusBar.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(pnlStatusBar, BorderLayout.SOUTH);
		
		JLabel lblInstitucin = new JLabel("Institucion :");
		pnlStatusBar.add(lblInstitucin);
		
		lblSistema = new JLabel("Tata San Juan de Dios");
		lblSistema.setFont(new Font("Tahoma", Font.BOLD, 13));
		pnlStatusBar.add(lblSistema);
		
		JLabel lblUsuario_1 = new JLabel("Usuario");
		pnlStatusBar.add(lblUsuario_1);
		
		lblUsuario = new JLabel("Usuario :");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		pnlStatusBar.add(lblUsuario);
		
		JLabel lblImagen = new JLabel("");
		contentPane.add(lblImagen, BorderLayout.CENTER);
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		btnConfiguracin = new JButton("Configuracion");
		btnConfiguracin.setIcon(new ImageIcon(FPrincipal.class.getResource("/imagenes/BOTONES/Herramientas.png")));
		btnConfiguracin.addActionListener(control);
		toolBar.add(btnConfiguracin);
		
		toolBar.addSeparator();
		btnKardex = new JButton("Kardex");
		btnKardex.setActionCommand("Registro");
		btnKardex.setIcon(new ImageIcon(FPrincipal.class.getResource("/imagenes/BOTONES/EMPLEADOS.png")));
		btnKardex.addActionListener(control);
		toolBar.add(btnKardex);
		
		btnAdmIngEg = new JButton("Adm. Ing. Eg.");
		btnAdmIngEg.setActionCommand("AdministradorIE");
		btnAdmIngEg.setIcon(new ImageIcon(FPrincipal.class.getResource("/imagenes/BOTONES/CHEQUE.png")));
		btnAdmIngEg.addActionListener(control);
		toolBar.add(btnAdmIngEg);
		
//		control.onFormShown();
	}

	public JLabel getLblSistema() {
		return lblSistema;
	}

	public JLabel getLblUsuario() {
		return lblUsuario;
	}

	
	
	
}
