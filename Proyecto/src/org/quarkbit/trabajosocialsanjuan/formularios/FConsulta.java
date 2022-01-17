package org.quarkbit.trabajosocialsanjuan.formularios;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Dimension;
import com.toedter.calendar.JDateChooser;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.DefaultComboBoxModel;

import org.quarkbit.trabajosocialsanjuan.controller.CFConsulta;

public class FConsulta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNroHC;
	private JTextField NroConsulta;
	private JTable tableCategorias;
	private JButton btnAgregarPropiedad;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JTextArea txtDiagnostico;
	private JTextArea txtObservaciones;
	private JTextArea txtMotivo;
	private JDateChooser dateFechaRegistro;
	private JComboBox<String> cBoxTipoConsulta;
	private JButton btnEliminarCategoria;
	public JLabel lblDatosNino;
	public CFConsulta control;
	private JButton btnModificar;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			FConsulta dialog = new FConsulta(null);
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public FConsulta(JFrame owner) {
		super(owner, true);
		control = new CFConsulta(this);
		setTitle("Consulta");
		setBounds(100, 100, 585, 491);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setViewportBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Listado de Categorias adicionales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(scrollPane);
			{
				tableCategorias = new JTable();
				scrollPane.setViewportView(tableCategorias);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnModificar = new JButton("Modificar");
				btnModificar.setIcon(new ImageIcon(FComidas.class.getResource("/imagenes/BOTONES/Actualizar01.png")));
				buttonPane.add(btnModificar);
			}
			{
				btnEliminarCategoria = new JButton("Eliminar Categoria");
				btnEliminarCategoria.setActionCommand("EliminarCategoria");
				buttonPane.add(btnEliminarCategoria);
			}
			{
				btnAgregarPropiedad = new JButton("Agregar Categoria");
				btnAgregarPropiedad.setActionCommand("AgregarCategoria");
				buttonPane.add(btnAgregarPropiedad);
			}
			{
				btnAceptar = new JButton("Aceptar");
				btnAceptar.setIcon(new ImageIcon(FComidas.class.getResource("/imagenes/BOTONES/Aceptar01.png")));
				btnAceptar.setActionCommand("Aceptar");
				buttonPane.add(btnAceptar);
//				getRootPane().setDefaultButton(btnAceptar);
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.setIcon(new ImageIcon(FComidas.class.getResource("/imagenes/BOTONES/Cancelar01.png")));
				btnCancelar.setActionCommand("Cancelar");
				buttonPane.add(btnCancelar);
			}
		}
		{
			JPanel pnlDatos = new JPanel();
			pnlDatos.setPreferredSize(new Dimension(10, 250));
			FlowLayout flowLayout = (FlowLayout) pnlDatos.getLayout();
			flowLayout.setHgap(10);
			flowLayout.setAlignment(FlowLayout.LEFT);
			getContentPane().add(pnlDatos, BorderLayout.NORTH);
			{
				lblDatosNino = new JLabel("Rosmeri Lopez Rueda");
				lblDatosNino.setPreferredSize(new Dimension(500, 16));
				lblDatosNino.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
				pnlDatos.add(lblDatosNino);
			}
			{
				JLabel lblNHistorialClnico = new JLabel("N\u00BA Historial Clinico");
				lblNHistorialClnico.setPreferredSize(new Dimension(120, 19));
				pnlDatos.add(lblNHistorialClnico);
			}
			{
				txtNroHC = new JTextField();
				txtNroHC.setEditable(false);
				pnlDatos.add(txtNroHC);
				txtNroHC.setColumns(10);
			}
			{
				JLabel lblNDeConsulta = new JLabel("N\u00BA de Consulta");
				lblNDeConsulta.setPreferredSize(new Dimension(120, 19));
				pnlDatos.add(lblNDeConsulta);
			}
			{
				NroConsulta = new JTextField();
				NroConsulta.setEditable(false);
				NroConsulta.setColumns(10);
				pnlDatos.add(NroConsulta);
			}
			{
				JLabel lblFechaRegistro = new JLabel("Fecha Registro :");
				lblFechaRegistro.setPreferredSize(new Dimension(120, 19));
				pnlDatos.add(lblFechaRegistro);
			}
			{
				dateFechaRegistro = new JDateChooser();
				dateFechaRegistro.setPreferredSize(new Dimension(115, 22));
				pnlDatos.add(dateFechaRegistro);
			}
			{
				JLabel lblTipoConsulta = new JLabel("Tipo Consulta :");
				lblTipoConsulta.setPreferredSize(new Dimension(120, 19));
				pnlDatos.add(lblTipoConsulta);
			}
			{
				cBoxTipoConsulta = new JComboBox<String>();
				cBoxTipoConsulta.setModel(new DefaultComboBoxModel<String>(new String[] {"Normal", "Particular", "Transferencia"}));
				cBoxTipoConsulta.setPreferredSize(new Dimension(150, 22));
				pnlDatos.add(cBoxTipoConsulta);
			}
			{
				JLabel lblMotivo = new JLabel("Motivo :");
				lblMotivo.setPreferredSize(new Dimension(120, 19));
				pnlDatos.add(lblMotivo);
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				pnlDatos.add(scrollPane);
				{
					txtMotivo = new JTextArea();
					scrollPane.setViewportView(txtMotivo);
					txtMotivo.setColumns(32);
					txtMotivo.setRows(2);
				}
			}
			{
				JLabel lblDiagnstico = new JLabel("Diagnostico :");
				lblDiagnstico.setPreferredSize(new Dimension(120, 19));
				pnlDatos.add(lblDiagnstico);
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				pnlDatos.add(scrollPane);
				{
					txtDiagnostico = new JTextArea();
					scrollPane.setViewportView(txtDiagnostico);
					txtDiagnostico.setRows(2);
					txtDiagnostico.setColumns(32);
				}
			}
			{
				JLabel lblObservaciones = new JLabel("Observaciones :");
				lblObservaciones.setPreferredSize(new Dimension(120, 19));
				pnlDatos.add(lblObservaciones);
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				pnlDatos.add(scrollPane);
				{
					txtObservaciones = new JTextArea();
					scrollPane.setViewportView(txtObservaciones);
					txtObservaciones.setRows(2);
					txtObservaciones.setColumns(32);
				}
			}
		}
//		control.onFormShown();
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public JTextField getTxtNroHC() {
		return txtNroHC;
	}

	public JTextField getNroConsulta() {
		return NroConsulta;
	}


	public JButton getBtnAgregarPropiedad() {
		return btnAgregarPropiedad;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JTextArea getTxtDiagnostico() {
		return txtDiagnostico;
	}

	public JTextArea getTxtObservaciones() {
		return txtObservaciones;
	}

	public JTextArea getTxtMotivo() {
		return txtMotivo;
	}

	public JDateChooser getDateFechaRegistro() {
		return dateFechaRegistro;
	}

	public JComboBox<String> getcBoxTipoConsulta() {
		return cBoxTipoConsulta;
	}

	public JTable getTableCategorias() {
		return tableCategorias;
	}


	public JButton getBtnEliminarCategoria() {
		return btnEliminarCategoria;
	}

	
	
	

}
