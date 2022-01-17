package org.quarkbit.trabajosocialsanjuan.formularios;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;


import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

import org.apache.ibatis.session.SqlSession;
import org.quarkbit.trabajosocialsanjuan.dao.Coneccion;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Empleo;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Persona;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.EmpleoMapper;
import org.quarkbit.trabajosocialsanjuan.utils.FormUtilities;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class PnlPersonas extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtDIPersonal;
	private JTextField txtNombres;
	private JTextField txtAppPaterno;
	private JTextField txtMaterno;
	private JTextField txtCelular;
	private JTextField txtTelefono;
	private JComboBox<Empleo> cBoxEmpleo;
	private JComboBox<String> cBoxGradoInstruccion;
	private JComboBox<String> cBoxSexo;
	private JComboBox<String> cBoxEstadoCivil;
	private JButton btnAgregarEmpleo;
	private JTextArea txtDomicilio;
	private JTextArea txtObservaciones;
	SqlSession session;
	EmpleoMapper daoEmpleoMapper;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JLabel lblEmpleo;
	private JLabel lblEstadoCivil;
	private JLabel lblGradoInstruccin;

	/**
	 * Create the panel.
	 */
	public PnlPersonas() {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Datos Personales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setVgap(15);
		flowLayout.setHgap(15);
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		session = Coneccion.getSqlSessionFactory().openSession();
		daoEmpleoMapper = session.getMapper(EmpleoMapper.class);
		
		JLabel lblIdentPersonal = new JLabel("Ident. Personal");
		lblIdentPersonal.setPreferredSize(new Dimension(130, 16));
		add(lblIdentPersonal);
		
		txtDIPersonal = new JTextField();
		add(txtDIPersonal);
		txtDIPersonal.setColumns(19);
		
		JLabel lblNombres = new JLabel("Nombres :");
		lblNombres.setPreferredSize(new Dimension(130, 16));
		add(lblNombres);
		
		txtNombres = new JTextField();
		txtNombres.setColumns(19);
		add(txtNombres);
		
		JLabel lblApPaterno = new JLabel("Ap. Paterno :");
		lblApPaterno.setPreferredSize(new Dimension(130, 16));
		add(lblApPaterno);
		
		txtAppPaterno = new JTextField();
		txtAppPaterno.setColumns(19);
		add(txtAppPaterno);
		
		JLabel lblApMaterno = new JLabel("Ap. Materno :");
		lblApMaterno.setPreferredSize(new Dimension(130, 16));
		add(lblApMaterno);
		
		txtMaterno = new JTextField();
		txtMaterno.setColumns(19);
		add(txtMaterno);
		
		lblEmpleo = new JLabel("Empleo :");
		lblEmpleo.setPreferredSize(new Dimension(130, 16));
		add(lblEmpleo);
		
		cBoxEmpleo = new JComboBox<Empleo>();
		cBoxEmpleo.setPreferredSize(new Dimension(215, 22));
		add(cBoxEmpleo);
		
		btnAgregarEmpleo = new JButton("+");
		btnAgregarEmpleo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FEmpleos form = new FEmpleos(null);
				form.setVisible(true);
				
				cBoxEmpleo.removeAllItems();
				session.commit();
				for (Empleo empleito : daoEmpleoMapper.selectByExample(null)) {
					cBoxEmpleo.addItem(empleito);
				}
				cBoxEmpleo.setSelectedIndex(cBoxEmpleo.getItemCount() -1);
			}
		});
		btnAgregarEmpleo.setMargin(new Insets(0, 2, 0, 2));
		btnAgregarEmpleo.setActionCommand("agregarEmpleo");
		btnAgregarEmpleo.setPreferredSize(new Dimension(28, 28));
		add(btnAgregarEmpleo);
		
		lblGradoInstruccin = new JLabel("Grado Instruccion :");
		lblGradoInstruccin.setPreferredSize(new Dimension(130, 16));
		add(lblGradoInstruccin);
		
		cBoxGradoInstruccion = new JComboBox<String>();
		cBoxGradoInstruccion.setModel(new DefaultComboBoxModel(new String[] {"NINGUNO", "ANALFABETO", "PRIMARIO", "SECUNDARIO", "UNIVERSITARIO", "TECNICO SUPERIOR", "SUPERIOR"}));
		cBoxGradoInstruccion.setPreferredSize(new Dimension(215, 22));
		cBoxGradoInstruccion.setSelectedIndex(-1);
		add(cBoxGradoInstruccion);
		
		JLabel lblSexo = new JLabel("Sexo :");
		lblSexo.setPreferredSize(new Dimension(130, 16));
		add(lblSexo);
		
		cBoxSexo = new JComboBox<String>();
		cBoxSexo.setModel(new DefaultComboBoxModel(new String[] {"MASCULINO", "FEMENINO"}));
		cBoxSexo.setPreferredSize(new Dimension(215, 22));
		cBoxSexo.setSelectedIndex(-1);
		add(cBoxSexo);
		
		lblEstadoCivil = new JLabel("Estado Civil :");
		lblEstadoCivil.setPreferredSize(new Dimension(130, 16));
		add(lblEstadoCivil);
		
		cBoxEstadoCivil = new JComboBox<String>();
		cBoxEstadoCivil.setModel(new DefaultComboBoxModel(new String[] {"SOLTERO(A)", "CASADO(A)", "DIVORCIADO(A)", "VIUDO(A)"}));
		cBoxEstadoCivil.setPreferredSize(new Dimension(215, 22));
		cBoxEstadoCivil.setSelectedIndex(-1);
		add(cBoxEstadoCivil);
		
		JLabel lblCelular = new JLabel("Celular :");
		lblCelular.setPreferredSize(new Dimension(130, 16));
		add(lblCelular);
		
		txtCelular = new JTextField();
		txtCelular.setColumns(19);
		txtCelular.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				FormUtilities.keyTyped(e, "entero", null);
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		add(txtCelular);
		
		JLabel lblTelfono = new JLabel("Telefono :");
		lblTelfono.setPreferredSize(new Dimension(130, 16));
		
		add(lblTelfono);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(19);
		txtTelefono.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				FormUtilities.keyTyped(e, "entero", null);
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		add(txtTelefono);
		
		JLabel lblDomicilio = new JLabel("Domicilio :");
		lblDomicilio.setPreferredSize(new Dimension(130, 16));
		add(lblDomicilio);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane);
		
		txtDomicilio = new JTextArea();
		scrollPane.setViewportView(txtDomicilio);
		txtDomicilio.setRows(3);
		txtDomicilio.setColumns(19);
		
		JLabel lblObservaciones = new JLabel("Observaciones :");
		lblObservaciones.setPreferredSize(new Dimension(130, 16));
		add(lblObservaciones);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane_1);
		
		txtObservaciones = new JTextArea();
		scrollPane_1.setViewportView(txtObservaciones);
		txtObservaciones.setRows(3);
		txtObservaciones.setColumns(19);
		
		cBoxEmpleo.removeAllItems();
		for (Empleo empleito : daoEmpleoMapper.selectByExample(null)) {
			cBoxEmpleo.addItem(empleito);
		}
		cBoxEmpleo.setSelectedIndex(-1);

	}
	
	public String validarCampos()
	{
		String mensajesErrores = null;
		JComponent componente = null;
		
		if(txtNombres.getText().isEmpty())
		{
			mensajesErrores += "No puede dejar en blanco el Nombre de la Persona\n";
			if(componente == null)
			{
				txtNombres.grabFocus();
				componente = txtNombres;
			}
			
		}
		if(txtAppPaterno.getText().isEmpty())
		{
			mensajesErrores += "No puede dejar en blanco el apellido paterno de la Persona\n";
			if(componente == null)
			{
				txtAppPaterno.grabFocus();
				componente = txtAppPaterno;
			}
		}
		if(cBoxSexo.getSelectedIndex() ==-1)
		{
			mensajesErrores += "A\u00FAn no ha seleccionado el sexo de la Persona\n";
			if(componente == null)
			{
				cBoxSexo.grabFocus();
				componente = cBoxSexo;
			}
		}
		
		if(cBoxGradoInstruccion.getSelectedIndex() ==-1)
		{
			mensajesErrores += "A\u00FAn no ha seleccionado el grado de instruccion de la Persona\n";
			if(componente == null)
			{
				cBoxGradoInstruccion.grabFocus();
				componente = cBoxGradoInstruccion;
			}
		}
		if(cBoxEstadoCivil.getSelectedIndex() ==-1)
		{
			mensajesErrores += "A\u00FAn no ha seleccionado el estado civil de la Persona\n";
			if(componente == null)
			{
				cBoxEstadoCivil.grabFocus();
				componente = cBoxEstadoCivil;
			}
		}
		return mensajesErrores;
	}
	
	public void habilitarControles(boolean estadoHabilitacion)
	{
		txtAppPaterno.setEditable(estadoHabilitacion);
		txtCelular.setEditable(estadoHabilitacion);
		txtDIPersonal.setEditable(estadoHabilitacion);
		txtMaterno.setEditable(estadoHabilitacion);
		txtNombres.setEditable(estadoHabilitacion);
		txtTelefono.setEditable(estadoHabilitacion);
		txtDomicilio.setEditable(estadoHabilitacion);
		txtObservaciones.setEditable(estadoHabilitacion);
		
		
		cBoxEmpleo.setEnabled(estadoHabilitacion);
		cBoxEstadoCivil.setEnabled(estadoHabilitacion);
		cBoxGradoInstruccion.setEnabled(estadoHabilitacion);
		cBoxSexo.setEnabled(estadoHabilitacion);
		
		btnAgregarEmpleo.setEnabled(estadoHabilitacion);
	}
	
	public void limpiarControles()
	{
		txtAppPaterno.setText("");
		txtCelular.setText("");
		txtDIPersonal.setText("");
		txtMaterno.setText("");
		txtNombres.setText("");
		txtTelefono.setText("");
		txtDomicilio.setText("");
		txtObservaciones.setText("");
		
		
		cBoxEmpleo.setSelectedIndex(-1);
		cBoxEstadoCivil.setSelectedIndex(-1);
		cBoxGradoInstruccion.setSelectedIndex(-1);
		cBoxSexo.setSelectedIndex(-1);
		
		
	}
	
	public void cargarDatosPersona(Persona persona)
	{
		if(persona!= null)
		{
			txtAppPaterno.setText(persona.getPaterno());
			txtCelular.setText(persona.getCelular());
			txtDIPersonal.setText(persona.getDiPersona());
			txtMaterno.setText(persona.getMaterno());
			txtNombres.setText(persona.getNombres());
			txtTelefono.setText(persona.getTelefono());
			txtDomicilio.setText(persona.getDomicilio());
			txtObservaciones.setText(persona.getObservaciones());			
			
			cBoxEmpleo.getModel().setSelectedItem(persona.getEmpleo());
			cBoxEstadoCivil.setSelectedItem(persona.getEstCivil());
			cBoxGradoInstruccion.setSelectedItem(persona.getInstruccion());
			cBoxSexo.setSelectedItem(persona.getSexo().compareTo("F")== 0 ? "FEMENINO" : "MASCULINO");
		}
	}
	
	public Persona obtenerPersona()
	{
		Persona personaNueva = new Persona();
		personaNueva.setDiPersona(txtDIPersonal.getText());
		personaNueva.setNombres(txtNombres.getText());
		personaNueva.setPaterno(txtAppPaterno.getText());
		personaNueva.setMaterno(txtMaterno.getText());
		personaNueva.setCelular(txtCelular.getText());
		personaNueva.setTelefono(txtTelefono.getText());
		personaNueva.setDomicilio(txtDomicilio.getText());
		personaNueva.setObservaciones(txtObservaciones.getText());
		
		if(cBoxEmpleo.getSelectedIndex() >= 0)
		{
			personaNueva.setEmpleo((Empleo)cBoxEmpleo.getSelectedItem());
			personaNueva.setCodigoEmpleo(personaNueva.getEmpleo().getCodigoEmpleo());
		}
			
		personaNueva.setEstCivil(cBoxEstadoCivil.getSelectedItem().toString());
		personaNueva.setInstruccion(cBoxGradoInstruccion.getSelectedItem().toString());
		personaNueva.setSexo(cBoxSexo.getSelectedItem().toString().compareTo("FEMENINO") == 0 ? "F" : "M");
		return personaNueva;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JTextField getTxtDIPersonal() {
		return txtDIPersonal;
	}

	public JTextField getTxtNombres() {
		return txtNombres;
	}

	public JTextField getTxtAppPaterno() {
		return txtAppPaterno;
	}

	public JTextField getTxtMaterno() {
		return txtMaterno;
	}

	public JTextField getTxtCelular() {
		return txtCelular;
	}

	public JTextField getTxtTelefono() {
		return txtTelefono;
	}

	public JComboBox<Empleo> getcBoxEmpleo() {
		return cBoxEmpleo;
	}

	public JComboBox<String> getcBoxGradoInstruccion() {
		return cBoxGradoInstruccion;
	}

	public JComboBox<String> getcBoxSexo() {
		return cBoxSexo;
	}

	public JComboBox<String> getcBoxEstadoCivil() {
		return cBoxEstadoCivil;
	}

	public JButton getBtnAgregarEmpleo() {
		return btnAgregarEmpleo;
	}

	public JTextArea getTxtDomicilio() {
		return txtDomicilio;
	}

	public JTextArea getTxtObservaciones() {
		return txtObservaciones;
	}

	public void habilitarSoloParaNinos()
	{
		cBoxEmpleo.setVisible(false);
		cBoxGradoInstruccion.setVisible(false);
		cBoxEstadoCivil.setVisible(false);
		btnAgregarEmpleo.setVisible(false);
		lblEmpleo.setVisible(false);
		lblEstadoCivil.setVisible(false);
		lblGradoInstruccin.setVisible(false);
	}
}
