package org.quarkbit.trabajosocialsanjuan.formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;

import org.quarkbit.trabajosocialsanjuan.controller.CFAdministradorMovimientos;

import com.toedter.calendar.JDateChooser;
import java.awt.Dimension;

public class FAdministradorMovimientos extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableIngresos;
	private JTable tableEgresos;
	private JDateChooser dateFechaInicio;
	private JDateChooser dateFechaFin;
	private JLabel lblTotalEgresos;
	private JButton btnNuevo;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnReporte;
	private JLabel lblTotalIngresos;
	private CFAdministradorMovimientos control;
	private JTabbedPane tabbedPane;
	private JPanel pnlIngresos;
	private JPanel pnlEgresos;
	private JButton btnActualizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FAdministradorMovimientos frame = new FAdministradorMovimientos(null);
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
	public FAdministradorMovimientos(JFrame owner) {
		super(owner,true);
		setTitle("Administrador de Movimientos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 555, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		control = new CFAdministradorMovimientos(this);
		
		JPanel pnlFiltroIngresos = new JPanel();
		contentPane.add(pnlFiltroIngresos, BorderLayout.NORTH);
		
		JLabel lblDel = new JLabel("Del");
		pnlFiltroIngresos.add(lblDel);
		
		dateFechaInicio = new JDateChooser();
		dateFechaInicio.setPreferredSize(new Dimension(140, 30));
		pnlFiltroIngresos.add(dateFechaInicio);
		
		JLabel lblAl = new JLabel("al");
		pnlFiltroIngresos.add(lblAl);
		
		dateFechaFin = new JDateChooser();
		dateFechaFin.setPreferredSize(new Dimension(140, 30));
		pnlFiltroIngresos.add(dateFechaFin);
		
		btnActualizar = new JButton("Actualizar");
		pnlFiltroIngresos.add(btnActualizar);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		pnlIngresos = new JPanel();
		tabbedPane.addTab("Ingresos", null, pnlIngresos, null);
		pnlIngresos.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlResumenIngresos = new JPanel();
		pnlIngresos.add(pnlResumenIngresos, BorderLayout.SOUTH);
		
		lblTotalIngresos = new JLabel("Total Ingresosaeio\u00FA\u00F1 :");
		pnlResumenIngresos.add(lblTotalIngresos);
		
		JScrollPane scrollPane = new JScrollPane();
		pnlIngresos.add(scrollPane, BorderLayout.CENTER);
		
		tableIngresos = new JTable();
		scrollPane.setViewportView(tableIngresos);
		
		pnlEgresos = new JPanel();
		tabbedPane.addTab("Egresos", null, pnlEgresos, null);
		pnlEgresos.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		pnlEgresos.add(panel_2, BorderLayout.SOUTH);
		
		lblTotalEgresos = new JLabel("Total Egresos :");
		panel_2.add(lblTotalEgresos);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		pnlEgresos.add(scrollPane_1);
		
		tableEgresos = new JTable();
		scrollPane_1.setViewportView(tableEgresos);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setIcon(new ImageIcon(FComidas.class.getResource("/imagenes/BOTONES/Nuevo01.png")));
		panel.add(btnNuevo);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setIcon(new ImageIcon(FComidas.class.getResource("/imagenes/BOTONES/Actualizar01.png")));
		panel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(FComidas.class.getResource("/imagenes/BOTONES/Eliminar01.png")));
		panel.add(btnEliminar);
		
		btnReporte = new JButton("Reporte");
		panel.add(btnReporte);
		
		control.onFormShown();
	}

	public JTable getTableIngresos() {
		return tableIngresos;
	}

	public JTable getTableEgresos() {
		return tableEgresos;
	}

	public JDateChooser getDateFechaInicio() {
		return dateFechaInicio;
	}

	public JDateChooser getDateFechaFin() {
		return dateFechaFin;
	}

	public JLabel getLblTotalEgresos() {
		return lblTotalEgresos;
	}

	public JButton getBtnNuevo() {
		return btnNuevo;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public JButton getBtnReporte() {
		return btnReporte;
	}

	public JLabel getLblTotalIngresos() {
		return lblTotalIngresos;
	}

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public JPanel getPnlIngresos() {
		return pnlIngresos;
	}

	public JPanel getPnlEgresos() {
		return pnlEgresos;
	}

	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	

}
