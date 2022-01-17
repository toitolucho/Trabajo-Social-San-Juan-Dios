package org.quarkbit.trabajosocialsanjuan.formularios;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.DefaultComboBoxModel;
import java.awt.Insets;

public class FIngresosBuscador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField txtTextoBusqueda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FIngresosBuscador dialog = new FIngresosBuscador();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FIngresosBuscador() {
		setBounds(100, 100, 878, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			table = new JTable();
			contentPanel.add(table);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
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
				JComboBox cBoxFiltro = new JComboBox();
				cBoxFiltro.setModel(new DefaultComboBoxModel(new String[] {"REMITENTE", "VIA ", "DIRIGIDO A", "NI\u00D1O"}));
				pnlOpcionesBusqueda.add(cBoxFiltro);
			}
			{
				JButton btnSeleccionarPersona = new JButton("...");
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
				txtTextoBusqueda.setColumns(20);
			}
			{
				JLabel lblEntre = new JLabel("Entre");
				pnlOpcionesBusqueda.add(lblEntre);
			}
			{
				JDateChooser dateFechaInicio = new JDateChooser();
				pnlOpcionesBusqueda.add(dateFechaInicio);
			}
			{
				JLabel lblY = new JLabel("y");
				pnlOpcionesBusqueda.add(lblY);
			}
			{
				JDateChooser dateFechaFin = new JDateChooser();
				pnlOpcionesBusqueda.add(dateFechaFin);
			}
			{
				JButton btnBuscar = new JButton("Buscar");
				pnlOpcionesBusqueda.add(btnBuscar);
			}
		}
	}

}
