package org.quarkbit.trabajosocialsanjuan.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import org.apache.ibatis.session.SqlSession;
import org.quarkbit.trabajosocialsanjuan.dao.Coneccion;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Informe;
import org.quarkbit.trabajosocialsanjuan.dao.domain.InformeExample;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.InformeMapper;
import org.quarkbit.trabajosocialsanjuan.formularios.FInformesBuscador;
import org.quarkbit.trabajosocialsanjuan.formularios.FPersonasBuscador;
import org.quarkbit.trabajosocialsanjuan.formularios.tablemodels.ModeloInformes;
import org.quarkbit.trabajosocialsanjuan.utils.FormUtilities;

public class CFInformesBuscador extends MouseAdapter implements ActionListener {
	FInformesBuscador formBuscador;
	private int codigo_Personas_aux;
	SqlSession session;
	Informe informeActual;
	InformeMapper daoInformeMapper;
	ModeloInformes modeloInforme;
	
	public CFInformesBuscador (FInformesBuscador formBuscador)
	{
		this.formBuscador = formBuscador;
		session = Coneccion.getSqlSessionFactory().openSession();
		daoInformeMapper = session.getMapper(InformeMapper.class);
		modeloInforme = new ModeloInformes();
	}
	
	public void onFormShown()
	{
		formBuscador.getBtnBuscar().addActionListener(this);
		formBuscador.getBtnSeleccionarPersona().addActionListener(this);
		formBuscador.getCancelButton().addActionListener(this);
		formBuscador.getOkButton().addActionListener(this);
		
		formBuscador.getTable().setModel(modeloInforme);
		formBuscador.getTable().addMouseListener(this);
		formBuscador.getcBoxFiltro().setSelectedIndex(-1);
		FormUtilities.centrar(formBuscador);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().compareTo("buscarPersona") == 0)
		{
			FPersonasBuscador formPersonasBuscador= new FPersonasBuscador(null);
			if(formBuscador.getcBoxFiltro().getSelectedIndex() == 0 )
				codigo_Personas_aux = -1;
			else if(formBuscador.getcBoxFiltro().getSelectedIndex() < 3 )
				formPersonasBuscador.control.setTipoPersona("R");
			else
				formPersonasBuscador.control.setTipoPersona("N");
			formPersonasBuscador.setVisible(true);
			
			if(formPersonasBuscador.control.personaActual.getNombres() != null)
			{
				codigo_Personas_aux = formPersonasBuscador.control.personaActual.getCodigoPersona();
				formBuscador.getTxtTextoBusqueda().setText(formPersonasBuscador.control.personaActual.obtenerNombreCompleto());
			}
		}
		
		if(e.getActionCommand().compareTo("Buscar") == 0)
		{
			if(formBuscador.getDateFechaInicio().getDate() == null ||
					formBuscador.getDateFechaFin().getDate() == null)
			{
				JOptionPane.showMessageDialog(formBuscador, "No ha seleccionado un rango o periodo de tiempo", "Informes", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			InformeExample filtro = new InformeExample();
			if(formBuscador.getcBoxFiltro().getSelectedIndex() ==0)
				filtro.or().andCodigoPersonaDirigidoEqualTo(codigo_Personas_aux);
			if(formBuscador.getcBoxFiltro().getSelectedIndex() ==1)
				filtro.or().andCodigoPersonaViaEqualTo(codigo_Personas_aux);
			if(formBuscador.getcBoxFiltro().getSelectedIndex() ==2)
			{
				filtro.or().andCodigoPersonaDe1EqualTo(codigo_Personas_aux);
				filtro.or().andCodigoPersonaDe2EqualTo(codigo_Personas_aux);
				filtro.or().andCodigoPersonaDe3EqualTo(codigo_Personas_aux);
			}
			filtro.or().andFechaEnvioBetween(formBuscador.getDateFechaInicio().getDate(), formBuscador.getDateFechaFin().getDate());
			
			
			modeloInforme.setListInforme(daoInformeMapper.selectByExample(filtro));
		}
		if(e.getActionCommand().compareTo("Cancel") == 0)
		{
			this.formBuscador.setVisible(false);
		}
		if(e.getActionCommand().compareTo("OK") == 0)
		{
			if(formBuscador.getTable().getSelectedRow() >= 0)
			{
				informeActual = modeloInforme.obtenerInforme(formBuscador.getTable().getSelectedRow());
				this.formBuscador.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(formBuscador, "No ha seleccionado ning\u00FAn elemento", "Busqueda", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
	}
	
	@Override
    public void mousePressed(MouseEvent e) {
        if (e.getClickCount() == 2) {
        	
        	informeActual = modeloInforme.obtenerInforme(formBuscador.getTable().getSelectedRow());
            this.formBuscador.setVisible(false);
        }
    }
	
}
