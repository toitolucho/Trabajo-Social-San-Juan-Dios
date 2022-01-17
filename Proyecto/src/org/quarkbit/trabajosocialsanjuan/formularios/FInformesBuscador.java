package org.quarkbit.trabajosocialsanjuan.formularios;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.DefaultComboBoxModel;

import org.quarkbit.trabajosocialsanjuan.controller.CFInformesBuscador;

import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class FInformesBuscador extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField txtTextoBusqueda;
	private JComboBox<String> cBoxFiltro;
	private JButton btnSeleccionarPersona;
	private JDateChooser dateFechaInicio;
	private JDateChooser dateFechaFin;
	private JButton btnBuscar;
	private JButton okButton;
	private JButton cancelButton;
	public CFInformesBuscador control;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FInformesBuscador dialog = new FInformesBuscador(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FInformesBuscador(JFrame owner) {
		super(owner, true);
		setBounds(100, 100, 878, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			scrollPane = new JScrollPane();
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			contentPanel.add(scrollPane, BorderLayout.CENTER);
		}
		{
			table = new JTable();
			scrollPane.setViewportView(table);
		}
		control = new CFInformesBuscador(this);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JPanel pnlOpcionesBusqueda = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnlOpcionesBusqueda.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			getContentPane().add(pnlOpcionesBusqueda, BorderLayout.NORTH);
			{
				JLabel lblFiltro = new JLabel("Filtro:");
				pnlOpcionesBusqueda.add(lblFiltro);
			}
			{
				cBoxFiltro = new JComboBox<String>();
				cBoxFiltro.setModel(new DefaultComboBoxModel<String>(new String[] {"REMITENTE", "VIA ", "DIRIGIDO A", "NI\u00D1O"}));
				pnlOpcionesBusqueda.add(cBoxFiltro);
			}
			{
				btnSeleccionarPersona = new JButton("...");
				btnSeleccionarPersona.setActionCommand("buscarPersona");
				btnSeleccionarPersona.setMargin(new Insets(2, 5, 2, 5));
				pnlOpcionesBusqueda.add(btnSeleccionarPersona);
			}
			{
				JLabel lblTextoBusqueda = new JLabel("Texto Busqueda :");
				pnlOpcionesBusqueda.add(lblTextoBusqueda);
			}
			{
				txtTextoBusqueda = new JTextField();
				pnlOpcionesBusqueda.add(txtTextoBusqueda);
				txtTextoBusqueda.setColumns(15);
			}
			{
				JLabel lblEntre = new JLabel("Entre");
				pnlOpcionesBusqueda.add(lblEntre);
			}
			{
				dateFechaInicio = new JDateChooser();
				pnlOpcionesBusqueda.add(dateFechaInicio);
			}
			{
				JLabel lblY = new JLabel("y");
				pnlOpcionesBusqueda.add(lblY);
			}
			{
				dateFechaFin = new JDateChooser();
				pnlOpcionesBusqueda.add(dateFechaFin);
			}
			{
				btnBuscar = new JButton("Buscar");
				pnlOpcionesBusqueda.add(btnBuscar);
			}
		}
		control.onFormShown();
	}

	public JTable getTable() {
		return table;
	}

	public JTextField getTxtTextoBusqueda() {
		return txtTextoBusqueda;
	}

	public JComboBox<String> getcBoxFiltro() {
		return cBoxFiltro;
	}

	public JButton getBtnSeleccionarPersona() {
		return btnSeleccionarPersona;
	}

	public JDateChooser getDateFechaInicio() {
		return dateFechaInicio;
	}

	public JDateChooser getDateFechaFin() {
		return dateFechaFin;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public JButton getOkButton() {
		return okButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	
}
