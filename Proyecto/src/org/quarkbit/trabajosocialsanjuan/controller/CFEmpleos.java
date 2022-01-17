package org.quarkbit.trabajosocialsanjuan.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.apache.ibatis.session.SqlSession;
import org.quarkbit.trabajosocialsanjuan.dao.Coneccion;
import org.quarkbit.trabajosocialsanjuan.dao.domain.DocumentoExample;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Empleo;
import org.quarkbit.trabajosocialsanjuan.dao.domain.EmpleoExample;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.EmpleoMapper;
import org.quarkbit.trabajosocialsanjuan.formularios.FEmpleos;
import org.quarkbit.trabajosocialsanjuan.formularios.tablemodels.ModeloEmpleos;
import org.quarkbit.trabajosocialsanjuan.utils.FormUtilities;

public class CFEmpleos implements ActionListener, ListSelectionListener {
	
	FEmpleos formEmpleo;
	SqlSession session;
	EmpleoMapper daoEmpleoMapper;
	ModeloEmpleos modeloEmpleo;
	String tipoOperacion = "";
	Empleo EmpleoActual;
	
	public CFEmpleos(FEmpleos formEmpleo)
	{
		this.formEmpleo = formEmpleo;
		EmpleoActual = new Empleo();
	}
	
	public void onLoad()
	{
		session = Coneccion.getSqlSessionFactory().openSession();
		daoEmpleoMapper = session.getMapper(EmpleoMapper.class);
		modeloEmpleo = new ModeloEmpleos();
		
		formEmpleo.getjTableEmpleo().setModel(modeloEmpleo);
		formEmpleo.getTxtCodigo().setEnabled(false);	
		
		formEmpleo.getBtnAceptar().addActionListener(this);
		formEmpleo.getBtnNuevo().addActionListener(this);
		formEmpleo.getBtnCancelar().addActionListener(this);
		formEmpleo.getBtnModificar().addActionListener(this);
		formEmpleo.getBtnEliminar().addActionListener(this);
		formEmpleo.getBtnCerrar().addActionListener(this);
		
		
		habilitarControles(false);
		habilitarBotones(true, false, false, false, false);
		modeloEmpleo.setListEmpleo(daoEmpleoMapper.selectByExample(null));
		formEmpleo.getjTableEmpleo().getSelectionModel().addListSelectionListener(this);
		formEmpleo.getjTableEmpleo().getColumn("Codigo").setPreferredWidth(5);
		FormUtilities.centrar(formEmpleo);
//		mostrarParaInsercion(null);
	}
	
	public void mostrarParaInsercion(Empleo Empleo)
	{
		if(Empleo != null) //para edicion
		{
			tipoOperacion = "E";
		}
		else
		{
			tipoOperacion = "I";
		}
		
		limpiarControles();
		habilitarControles(true);
		habilitarBotones(false, true, false, false, false);
		formEmpleo.mostrorSoloControles();
	}
	
	public void limpiarControles()
	{
		formEmpleo.getTxtCodigo().setText("");
		formEmpleo.getTxtDescripcion().setText("");
		formEmpleo.getTxtNombre().setText("");
	}
	
	public void habilitarControles(boolean estadHabilitacion)
	{
		formEmpleo.getTxtNombre().setEnabled(estadHabilitacion);
		formEmpleo.getTxtDescripcion().setEnabled(estadHabilitacion);
//		formEmpleo.getjTableEmpleo().setEnabled(estadHabilitacion);
	}
	
	public boolean validarControles()
	{
		if(formEmpleo.getTxtNombre().getText().trim().isEmpty())
		{
			JOptionPane.showMessageDialog(formEmpleo, "A\u00FAn no ha ingresado el nombre del Empleo", "Empleo", JOptionPane.ERROR_MESSAGE);
			formEmpleo.getTxtNombre().grabFocus();
			return false;
		}
		EmpleoExample filtro = new EmpleoExample();
		filtro.or().andNombreEmpleoEqualTo(formEmpleo.getTxtNombre().getText().toUpperCase());
		if(tipoOperacion.compareTo("I") == 0 && daoEmpleoMapper.countByExample(filtro) > 0)
		{
			JOptionPane.showMessageDialog(formEmpleo, "El nombre de la Empleo ya se encuentra registrada", "Categoria Empleo", JOptionPane.ERROR_MESSAGE);
			formEmpleo.getTxtNombre().grabFocus();
			return false;
		}
		return true;
	}
	
	public void habilitarBotones(boolean nuevo, boolean aceptar, boolean cancelar,
			boolean modificar, boolean eliminar)
	{
		formEmpleo.getBtnAceptar().setEnabled(aceptar);
		formEmpleo.getBtnNuevo().setEnabled(nuevo);
		formEmpleo.getBtnCancelar().setEnabled(cancelar);
		formEmpleo.getBtnModificar().setEnabled(modificar);
		formEmpleo.getBtnEliminar().setEnabled(eliminar);
	}
	
	public void cargarDatos(Empleo EmpleoAux)
	{
		if(EmpleoAux != null)
		{
			EmpleoActual = EmpleoAux;
			formEmpleo.getTxtCodigo().setText(EmpleoAux.getCodigoEmpleo().toString());
			formEmpleo.getTxtNombre().setText(EmpleoAux.getNombreEmpleo());
			formEmpleo.getTxtDescripcion().setText(EmpleoAux.getDescripcion());
			habilitarBotones(true, false, true, true, true);
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(formEmpleo.getBtnAceptar().equals(event.getSource()))
		{
			if(validarControles())
			{
				try {
					EmpleoActual = new Empleo();
					EmpleoActual.setCodigoEmpleo(-1);
					EmpleoActual.setNombreEmpleo(formEmpleo.getTxtNombre().getText().toUpperCase());
					EmpleoActual.setDescripcion(formEmpleo.getTxtDescripcion().getText());
					if(tipoOperacion.compareTo("I")==0)
					{
						daoEmpleoMapper.insert(EmpleoActual);
						session.commit();
						
						Map<String, Integer> mapa = new HashMap<String, Integer>();
						mapa.put("ultimoId", 0);
						daoEmpleoMapper.obtenerUltimoId(mapa); //("myMappedStatement",myParams);
						EmpleoActual.setCodigoEmpleo(mapa.get("ultimoId"));
						
//					System.out.println("codigo actual = " + EmpleoActual.getCodigoEmpleo());
						modeloEmpleo.AnadirEmpleo(EmpleoActual);
					}
					else
					{
						modeloEmpleo.setEmpleo(formEmpleo.getjTableEmpleo().getSelectedRow(), EmpleoActual);
						EmpleoActual.setCodigoEmpleo(Integer.parseInt(formEmpleo.getTxtCodigo().getText()));
						daoEmpleoMapper.updateByPrimaryKey(EmpleoActual);
						session.commit();
						
						
					}
					
					if(!formEmpleo.getBtnNuevo().isVisible())
					{
						
						formEmpleo.setVisible(false);
						formEmpleo.dispose();
						return;
					}
					tipoOperacion ="";
					habilitarBotones(true, false, false, true, true);
					habilitarControles(false);
					JOptionPane.showMessageDialog(formEmpleo, "Registro almacenado correctamente", "Empleos", JOptionPane.INFORMATION_MESSAGE);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(formEmpleo, "Ocurri\u00F3 la siguiente excepcion " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}
		if(formEmpleo.getBtnNuevo().equals(event.getSource()))
		{
			habilitarBotones(false, true, true, false, false);
			habilitarControles(true);
			limpiarControles();
			tipoOperacion = "I";
			formEmpleo.getjTableEmpleo().clearSelection();
		}
		if(formEmpleo.getBtnCerrar().equals(event.getSource()))
		{
			formEmpleo.setVisible(false);
			formEmpleo.dispose();
			
		}
		if(formEmpleo.getBtnModificar().equals(event.getSource()))
		{
			habilitarBotones(false, true, true, false, false);
			habilitarControles(true);			
			tipoOperacion = "E";
			
		}
		if(formEmpleo.getBtnEliminar().equals(event.getSource()))
		{
			if(JOptionPane.showConfirmDialog(formEmpleo, "¿Se encuentra seguro de eliminar el registro actual?", "Empleos", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			{
				System.out.println("Elemento a eliminar " + Integer.parseInt(formEmpleo.getTxtCodigo().getText()));
				
				modeloEmpleo.eliminarEmpleo(formEmpleo.getjTableEmpleo().getSelectedRow());
				
				
				daoEmpleoMapper.deleteByPrimaryKey(Integer.parseInt(formEmpleo.getTxtCodigo().getText()));
				
				session.commit();
				
				limpiarControles();
				habilitarBotones(true, false, false, false, false);
				JOptionPane.showMessageDialog(formEmpleo, "Objeto eliminado correctamente", "Empleo", JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
		
		if(formEmpleo.getBtnCancelar().equals(event.getSource()))
		{
			limpiarControles();
			habilitarControles(false);
			habilitarBotones(true, false, false, false, false);
			tipoOperacion = "";
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if(e.getValueIsAdjusting())
			return;
		int indice = ((ListSelectionModel) e.getSource()).getMinSelectionIndex();
		cargarDatos(modeloEmpleo.obtenerEmpleo(indice));
		
	}

}
