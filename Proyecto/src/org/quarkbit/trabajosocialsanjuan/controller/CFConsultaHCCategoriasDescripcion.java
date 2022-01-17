package org.quarkbit.trabajosocialsanjuan.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import org.apache.ibatis.session.SqlSession;
import org.quarkbit.trabajosocialsanjuan.dao.Coneccion;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PropiedadHistorialClinico;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PropiedadHistorialClinicoExample;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PropiedadTipo;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.PropiedadHistorialClinicoMapper;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.PropiedadTipoMapper;
import org.quarkbit.trabajosocialsanjuan.formularios.FConsultaHCCategoriasDescripcion;
import org.quarkbit.trabajosocialsanjuan.utils.FormUtilities;

public class CFConsultaHCCategoriasDescripcion implements ActionListener {
	
	private FConsultaHCCategoriasDescripcion formConsultaCategorias;
	SqlSession session;
	public PropiedadTipo propiedadTipoSeleccionada;
	public PropiedadHistorialClinico propiedadHistorialClinicoSeleccionado;
	public String descripcion;
	public boolean operacionCorrecta;
	
	PropiedadHistorialClinicoMapper daoPropiedadHistorialClinico;
	PropiedadTipoMapper daoPropiedadTipo;
	
	
	public CFConsultaHCCategoriasDescripcion(FConsultaHCCategoriasDescripcion formConsultaCategorias)
	{
		this.formConsultaCategorias = formConsultaCategorias;
		session = Coneccion.getSqlSessionFactory().openSession();
		daoPropiedadHistorialClinico = session.getMapper(PropiedadHistorialClinicoMapper.class);
		daoPropiedadTipo = session.getMapper(PropiedadTipoMapper.class);
	}
	
	public void onFormShown()
	{
		
		for (PropiedadTipo propiedadTipo : daoPropiedadTipo.selectByExample(null)) {
			formConsultaCategorias.getcBoxCategoria().addItem(propiedadTipo);			
		}
		formConsultaCategorias.getcBoxCategoria().setSelectedIndex(-1);
		
		formConsultaCategorias.getBtnAceptar().addActionListener(this);
		formConsultaCategorias.getBtnCancelar().addActionListener(this);
		formConsultaCategorias.getcBoxCategoria().addActionListener(this);
		
		
		FormUtilities.centrar(formConsultaCategorias);
		
	}
	
	public void cargarDatos(PropiedadHistorialClinico datoCargar)
	{
		if(datoCargar != null)
		{
			formConsultaCategorias.getcBoxCategoria().setSelectedItem(datoCargar.getPropiedadTipo());
			formConsultaCategorias.getcBoxTipoCategoria().setSelectedItem(datoCargar);
			formConsultaCategorias.getTxtDescripcion().setText(datoCargar.getDescripcion());
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		
		if(event.getActionCommand().compareTo("Aceptar") == 0)
		{
			if(formConsultaCategorias.getcBoxCategoria().getSelectedIndex() < 0)
			{
				JOptionPane.showMessageDialog(formConsultaCategorias, "No ha seleccionado ninguna categoria", "Historial m\u00E9dico cl\u00EDnico", JOptionPane.ERROR_MESSAGE);
				formConsultaCategorias.getcBoxCategoria().grabFocus();
				return;
			}
			if(formConsultaCategorias.getcBoxTipoCategoria().getSelectedIndex() < 0)
			{
				JOptionPane.showMessageDialog(formConsultaCategorias, "No ha seleccionado ning\u00FAn Tipo", "Historial m\u00E9dico cl\u00EDnico", JOptionPane.ERROR_MESSAGE);
				formConsultaCategorias.getcBoxTipoCategoria().grabFocus();
				return;
			}
			if(formConsultaCategorias.getTxtDescripcion().getText().isEmpty())
			{
				JOptionPane.showMessageDialog(formConsultaCategorias, "No ha ingresado la descripci\u00F3n", "Historial m\u00E9dico cl\u00EDnico", JOptionPane.ERROR_MESSAGE);
				formConsultaCategorias.getTxtDescripcion().grabFocus();
				return;
			}
			
			propiedadTipoSeleccionada = (PropiedadTipo) formConsultaCategorias.getcBoxCategoria().getSelectedItem();
			propiedadHistorialClinicoSeleccionado = (PropiedadHistorialClinico) formConsultaCategorias.getcBoxTipoCategoria().getSelectedItem();
			descripcion = formConsultaCategorias.getTxtDescripcion().getText();
			this.operacionCorrecta = true;
			this.formConsultaCategorias.setVisible(false);
			
		}
		
		if(event.getSource().equals(formConsultaCategorias.getcBoxCategoria()))
		{
			propiedadTipoSeleccionada = (PropiedadTipo) formConsultaCategorias.getcBoxCategoria().getSelectedItem();
			PropiedadHistorialClinicoExample filtro = new PropiedadHistorialClinicoExample();
			filtro.or().andNumeroPropiedadTipoEqualTo(propiedadTipoSeleccionada.getNumeroPropiedadTipo());
			for (PropiedadHistorialClinico propiedad : daoPropiedadHistorialClinico.selectByExample(filtro)) {
				formConsultaCategorias.getcBoxTipoCategoria().addItem(propiedad);
			}
			formConsultaCategorias.getcBoxTipoCategoria().setSelectedIndex(-1);
		}
		if(event.getActionCommand().compareTo("Cancelar") == 0)
		{
			this.formConsultaCategorias.setVisible(false);
			this.formConsultaCategorias.dispose();
		}
	}

}
