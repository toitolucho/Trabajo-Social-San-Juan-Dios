package org.quarkbit.trabajosocialsanjuan.formularios;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import org.apache.ibatis.session.SqlSession;
import org.quarkbit.trabajosocialsanjuan.dao.Coneccion;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Empleo;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Parentesco;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Persona;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PersonaKardexFamiliar;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.EmpleoMapper;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.ParentescoMapper;
import org.quarkbit.trabajosocialsanjuan.utils.FormUtilities;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FFamiliar extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JComboBox<Parentesco> cBoxParentesco;
	
	ParentescoMapper daoParentesco;
	EmpleoMapper daoEmpleo;
	public Parentesco parentescoActual;
	public Persona personaActual;
	public PersonaKardexFamiliar personaKardexFamiliar;
	SqlSession session;
	PnlPersonas pnlPersonas ;
	private JPanel pnlParentesco;
	private boolean esParaPersonas = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FFamiliar dialog = new FFamiliar(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FFamiliar( final JFrame owner) {
		super(owner, true);
		setTitle("Registro de Familiares");
		setBounds(100, 100, 478, 703);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		session = Coneccion.getSqlSessionFactory().openSession();
		daoParentesco = session.getMapper(ParentescoMapper.class);
		daoEmpleo = session.getMapper(EmpleoMapper.class);
		
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			
			pnlPersonas = new PnlPersonas();
			getContentPane().add(pnlPersonas, BorderLayout.CENTER);
			
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String datosValidacion = pnlPersonas.validarCampos();
						System.out.println(datosValidacion);
						if(datosValidacion != null && !datosValidacion.isEmpty())
						{
							JOptionPane.showMessageDialog(owner, datosValidacion, "Familiares", JOptionPane.ERROR_MESSAGE);
							return;
						}
						if(!esParaPersonas && cBoxParentesco.getSelectedIndex() < 0)
						{
							JOptionPane.showMessageDialog(owner, "No ha seleccionado el Parentesco", "Familaires", JOptionPane.ERROR_MESSAGE);
							cBoxParentesco.grabFocus();
							return;
						}
						
						parentescoActual = (Parentesco)cBoxParentesco.getSelectedItem();
						personaActual = pnlPersonas.obtenerPersona();
						
						personaKardexFamiliar = new PersonaKardexFamiliar();
						personaKardexFamiliar.setPersona(personaActual);
						personaKardexFamiliar.setParentesco(parentescoActual);
						setVisible(false);
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						FFamiliar.this.setVisible(false);
					}
				});
				buttonPane.add(cancelButton);
			}
		}
		{
			pnlParentesco = new JPanel();
			FlowLayout fl_pnlParentesco = (FlowLayout) pnlParentesco.getLayout();
			fl_pnlParentesco.setHgap(20);
			fl_pnlParentesco.setAlignment(FlowLayout.LEFT);
			getContentPane().add(pnlParentesco, BorderLayout.NORTH);
			{
				JLabel lblParentesco = new JLabel("Parentesco");
				lblParentesco.setPreferredSize(new Dimension(125, 16));
				pnlParentesco.add(lblParentesco);
			}
			{
				cBoxParentesco = new JComboBox<Parentesco>();
				cBoxParentesco.setPreferredSize(new Dimension(215, 22));
				for (Parentesco parentesco : daoParentesco.selectByExample(null)) {
					cBoxParentesco.addItem(parentesco);
				}
				pnlParentesco.add(cBoxParentesco);
				
				
//				for (Empleo empleo : daoEmpleo.selectByExample(null)) {
//					pnlPersonas.getcBoxEmpleo().addItem(empleo);
//				}
				pnlPersonas.getcBoxEmpleo().setSelectedIndex(-1);
			}
		}
		
		FormUtilities.centrar(this);
		session.close();
	}

	public void HabilitarRegistroPersonas()
	{
		getContentPane().remove(pnlParentesco);
		esParaPersonas = true;
	}

	public JComboBox<Parentesco> getcBoxParentesco() {
		return cBoxParentesco;
	}

	public void setcBoxParentesco(JComboBox<Parentesco> cBoxParentesco) {
		this.cBoxParentesco = cBoxParentesco;
	}

	public PnlPersonas getPnlPersonas() {
		return pnlPersonas;
	}

	public void setPnlPersonas(PnlPersonas pnlPersonas) {
		this.pnlPersonas = pnlPersonas;
	}

	public JPanel getPnlParentesco() {
		return pnlParentesco;
	}

	public void setPnlParentesco(JPanel pnlParentesco) {
		this.pnlParentesco = pnlParentesco;
	}

	public boolean isEsParaPersonas() {
		return esParaPersonas;
	}

	public void setEsParaPersonas(boolean esParaPersonas) {
		this.esParaPersonas = esParaPersonas;
	}
	
	

}
