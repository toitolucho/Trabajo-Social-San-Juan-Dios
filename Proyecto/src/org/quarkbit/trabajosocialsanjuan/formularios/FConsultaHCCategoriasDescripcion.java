package org.quarkbit.trabajosocialsanjuan.formularios;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.ScrollPaneConstants;

import org.quarkbit.trabajosocialsanjuan.controller.CFConsultaHCCategoriasDescripcion;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PropiedadHistorialClinico;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PropiedadTipo;

public class FConsultaHCCategoriasDescripcion extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JTextArea txtDescripcion;
	private JComboBox<PropiedadTipo> cBoxCategoria;
	private JComboBox<PropiedadHistorialClinico> cBoxTipoCategoria;
	public CFConsultaHCCategoriasDescripcion control;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			FConsultaHCCategoriasDescripcion dialog = new FConsultaHCCategoriasDescripcion();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public FConsultaHCCategoriasDescripcion(JFrame owner) {
		super(owner, true);
		setTitle("Descripcion Categorias");
		control = new CFConsultaHCCategoriasDescripcion(this);
		setBounds(100, 100, 366, 239);
		getContentPane().setLayout(new BorderLayout());
		FlowLayout fl_contentPanel = new FlowLayout();
		fl_contentPanel.setVgap(8);
		fl_contentPanel.setHgap(10);
		fl_contentPanel.setAlignment(FlowLayout.LEFT);
		contentPanel.setLayout(fl_contentPanel);
		contentPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "Seleccione una categoria y describala", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblCategoria = new JLabel("Categoria");
			lblCategoria.setPreferredSize(new Dimension(60, 14));
			contentPanel.add(lblCategoria);
		}
		{
			cBoxCategoria = new JComboBox<PropiedadTipo>();
			cBoxCategoria.setPreferredSize(new Dimension(200, 20));
			contentPanel.add(cBoxCategoria);
		}
		{
			JLabel lblTipo = new JLabel("Tipo");
			lblTipo.setPreferredSize(new Dimension(60, 14));
			contentPanel.add(lblTipo);
		}
		{
			cBoxTipoCategoria = new JComboBox<PropiedadHistorialClinico>();
			cBoxTipoCategoria.setPreferredSize(new Dimension(200, 20));
			contentPanel.add(cBoxTipoCategoria);
		}
		{
			JLabel lblDescripcin = new JLabel("Descripcion");
			lblDescripcin.setPreferredSize(new Dimension(60, 14));
			contentPanel.add(lblDescripcin);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			contentPanel.add(scrollPane);
			{
				txtDescripcion = new JTextArea();
				txtDescripcion.setColumns(15);
				txtDescripcion.setRows(3);
				scrollPane.setViewportView(txtDescripcion);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnAceptar = new JButton("Aceptar");
				btnAceptar.setIcon(new ImageIcon(FComidas.class.getResource("/imagenes/BOTONES/Aceptar01.png")));
				btnAceptar.setActionCommand("Aceptar");
				buttonPane.add(btnAceptar);
				getRootPane().setDefaultButton(btnAceptar);
			}
			{
				btnCancelar = new JButton("Cancel");
				btnCancelar.setActionCommand("Cancelar");
				buttonPane.add(btnCancelar);
			}
		}
		control.onFormShown();
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	public JTextArea getTxtDescripcion() {
		return txtDescripcion;
	}

	public void setTxtDescripcion(JTextArea txtDescripci\u00F3n) {
		this.txtDescripcion = txtDescripci\u00F3n;
	}

	public JComboBox<PropiedadTipo> getcBoxCategoria() {
		return cBoxCategoria;
	}

	public void setcBoxCategoria(JComboBox<PropiedadTipo> cBoxCategoria) {
		this.cBoxCategoria = cBoxCategoria;
	}

	public JPanel getContentPanel() {
		return contentPanel;
	}

	public JComboBox<PropiedadHistorialClinico> getcBoxTipoCategoria() {
		return cBoxTipoCategoria;
	}

	
	
}
