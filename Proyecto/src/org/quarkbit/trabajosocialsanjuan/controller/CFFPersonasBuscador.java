package org.quarkbit.trabajosocialsanjuan.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import org.apache.ibatis.session.SqlSession;
import org.quarkbit.trabajosocialsanjuan.dao.Coneccion;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Persona;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PersonaExample;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.PersonaMapper;
import org.quarkbit.trabajosocialsanjuan.formularios.FPersonasBuscador;
import org.quarkbit.trabajosocialsanjuan.formularios.tablemodels.ModeloPersonas;
import org.quarkbit.trabajosocialsanjuan.utils.FormUtilities;

public class CFFPersonasBuscador extends MouseAdapter implements ActionListener{

	FPersonasBuscador formBuscador;
	public Persona personaActual;
	SqlSession session;
	PersonaMapper daoPersonaMapper;
	String tipoPersona = "F";


	ModeloPersonas modeloPersonas;
	
	PersonaExample filtro;
	
	public CFFPersonasBuscador(FPersonasBuscador formBuscador)
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
		formBuscador.getTxtTextoBusqueda().addActionListener(this);
		formBuscador.getTablePersonas().addMouseListener(this);
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
		if(e.getActionCommand().compareTo("Cancelar") == 0)
		{
			personaActual = null;
			this.formBuscador.setVisible(false);
			session.close();
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

}
