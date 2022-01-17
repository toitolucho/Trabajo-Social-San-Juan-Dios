package org.quarkbit.trabajosocialsanjuan.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.apache.ibatis.session.SqlSession;
import org.quarkbit.trabajosocialsanjuan.dao.Coneccion;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Persona;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PersonaExample;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.PersonaMapper;
import org.quarkbit.trabajosocialsanjuan.formularios.FPersonasBuscador;
import org.quarkbit.trabajosocialsanjuan.formularios.tablemodels.ModeloPersonas;
import org.quarkbit.trabajosocialsanjuan.utils.FormUtilities;

public class CFPersonasBuscador extends MouseAdapter implements ActionListener, DocumentListener{

	FPersonasBuscador formBuscador;
	public Persona personaActual;
	SqlSession session;
	PersonaMapper daoPersonaMapper;
	String tipoPersona = "F";


	ModeloPersonas modeloPersonas;
	
	PersonaExample filtro;
	
	public CFPersonasBuscador(FPersonasBuscador formBuscador)
	{
		this.formBuscador = formBuscador;
		
		session = Coneccion.getSqlSessionFactory().openSession();
		daoPersonaMapper = session.getMapper(PersonaMapper.class);
		filtro = new PersonaExample();
		personaActual = new Persona();
		modeloPersonas = new ModeloPersonas();
		
	}
	
	public void onFormShown()
	{
		formBuscador.getTxtTextoBusqueda().grabFocus();
		FormUtilities.centrar(formBuscador);
		formBuscador.getTablePersonas().setModel(modeloPersonas);
		formBuscador.getBtnBuscar().addActionListener(this);
		formBuscador.getCancelButton().addActionListener(this);
		formBuscador.getOkButton().addActionListener(this);
		formBuscador.getTxtTextoBusqueda().addActionListener(this);
		formBuscador.getTablePersonas().addMouseListener(this);
		formBuscador.getTxtTextoBusqueda().getDocument().addDocumentListener(this);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().compareTo("Buscar") == 0)
		{
			if(formBuscador.getTxtTextoBusqueda().getText().isEmpty()
					|| formBuscador.getTxtTextoBusqueda().getText() == null)
			{
				JOptionPane.showMessageDialog(formBuscador, "No ha ingresado ning\u00FAn texto para realizar la busqueda", "Busqueda de personas", JOptionPane.WARNING_MESSAGE);
				return;
			}
			formBuscador.getTxtTextoBusqueda().selectAll();
			formBuscador.getTxtTextoBusqueda().grabFocus();
//			System.out.println(tipoPersona);
			filtro.clear();
			filtro.or().andNombresLike("%" + formBuscador.getTxtTextoBusqueda().getText() + "%").andCodigoTipoPersonaEqualTo(tipoPersona);
			filtro.or().andPaternoLike("%" + formBuscador.getTxtTextoBusqueda().getText() + "%").andCodigoTipoPersonaEqualTo(tipoPersona);
			filtro.or().andMaternoLike("%" + formBuscador.getTxtTextoBusqueda().getText() + "%").andCodigoTipoPersonaEqualTo(tipoPersona);
			
			modeloPersonas.setListPersona(daoPersonaMapper.selectByExample(filtro));
		}
		if(e.getActionCommand().compareTo("Cancel") == 0)
		{
			personaActual = null;
			this.formBuscador.setVisible(false);
			session.close();
		}
		if(e.getActionCommand().compareTo("OK") == 0)
		{
			if(formBuscador.getTablePersonas().getSelectedRow() >= 0)
			{
				personaActual = modeloPersonas.obtenerPersona(formBuscador.getTablePersonas().getSelectedRow());			
				this.formBuscador.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(formBuscador, "No ha seleccionado ning\u00FAn elemento", "Personas", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	@Override
    public void mousePressed(MouseEvent e) {
        if (e.getClickCount() == 2) {
        	personaActual = modeloPersonas.obtenerPersona(formBuscador.getTablePersonas().getSelectedRow());
            this.formBuscador.setVisible(false);
        }
    }
	
	public String getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		actionPerformed(new ActionEvent(formBuscador.getTxtTextoBusqueda(), 25, "Buscar"));
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		if(formBuscador.getTxtTextoBusqueda().getText().isEmpty())
			actionPerformed(new ActionEvent(formBuscador.getTxtTextoBusqueda(), 25, "Buscar"));
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}

}
