package org.quarkbit.trabajosocialsanjuan.controller;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import org.apache.ibatis.session.SqlSession;
import org.quarkbit.trabajosocialsanjuan.dao.Coneccion;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Egreso;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Ingreso;
import org.quarkbit.trabajosocialsanjuan.dao.domain.IngresoExample;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Partida;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Proveedor;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.EgresoMapper;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.IngresoMapper;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.PartidaMapper;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.ProveedorMapper;
import org.quarkbit.trabajosocialsanjuan.formularios.FEgresos;
import org.quarkbit.trabajosocialsanjuan.utils.FormUtilities;

public class CFEgresos extends KeyAdapter implements ActionListener, TreeSelectionListener{
	FEgresos formEgresos;
	ProveedorMapper daoProveedor;
	PartidaMapper daoPartida;
	EgresoMapper daoEgreso;
	IngresoMapper daoIngreso;
	SqlSession session;
	
	Egreso egresoActual;
	Partida partidaActual;
	String TipoOperacion;
	DefaultTreeModel modeloPartida;
	int codigoUsuario = 1;
	
	public CFEgresos(FEgresos formEgresos)
	{
		this.formEgresos = formEgresos;
		egresoActual = new Egreso();
		session =  Coneccion.getSqlSessionFactory().openSession();
		
		daoProveedor = session.getMapper(ProveedorMapper.class);
		daoPartida = session.getMapper(PartidaMapper.class);
		daoEgreso = session.getMapper(EgresoMapper.class);
		daoIngreso =session.getMapper(IngresoMapper.class);
		
	}
	
	public void onFormShown()
	{
		formEgresos.getBtnAceptar().addActionListener(this);
		formEgresos.getBtnCancelar().addActionListener(this);
		formEgresos.getBtnCerrar().addActionListener(this);
		formEgresos.getBtnEliminar().addActionListener(this);
		formEgresos.getBtnModificar().addActionListener(this);
		formEgresos.getBtnNuevo().addActionListener(this);
		
		formEgresos.getTxtMontoSalida().addKeyListener(this);
		formEgresos.getTxtNroFactura().addKeyListener(this);
		
		formEgresos.getTxtCodigo().setEditable(false);
		
		
		IngresoExample filtro = new IngresoExample();
		filtro.or().andMontoActualGreaterThan((double) 0);
		for (Ingreso ingreso : daoIngreso.selectByExample(filtro)) {
			formEgresos.getcBoxIngreso().addItem(ingreso);
		}
		for (Proveedor proveedor: daoProveedor.selectByExample(null)) {
			formEgresos.getcBoxProveedor().addItem(proveedor);			
		}
		
		
		Map<String, Partida> values = new HashMap<String, Partida>();
		for (Partida tipo : daoPartida.selectByExample(null)) {
			formEgresos.getcBoxPartida().addItem(tipo);			
		}
		
		for (Partida tipo : daoPartida.selectByExample(null)) {			
			values.put(tipo.getCodigoPartida(), tipo);
		}
		
		// creates a result list
        Collection<Partida> result = new ArrayList<Partida>();

        // for each element in the result list that has a parent, put it into it
        // otherwise it is added to the result list
        for (Partida e : values.values()) {
//        	System.out.println(e);
            if (e.getCodigoPartidaPadre()!= null) {
                values.get(e.getCodigoPartidaPadre()).getPartidas().add(e);
            } else {
                result.add(e);
            }
        }
        
        
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Partidas");
        modeloPartida = new DefaultTreeModel(root);
        
        createTreeNodesForElement(root, result);

        formEgresos.getTree().setModel(modeloPartida);
        
        formEgresos.getTree().setSelectionRow(1);
        formEgresos.getTree().setExpandsSelectedPaths(true);
        formEgresos.getTree().addTreeSelectionListener(this);
		
		limpiarControles();
		habilitarControles(false);
		habilitarBotones(true, false, false, false, false);
		
		formEgresos.getcBoxIngreso().addActionListener(this);
	}
	
	void createTreeNodesForElement(final DefaultMutableTreeNode dmtn, final Collection<Partida> elements) {
        // for each element a tree node is created
        for (Partida child : elements) {
            DefaultMutableTreeNode created = new DefaultMutableTreeNode(child);
            dmtn.add(created);
            createTreeNodesForElement(created, child.getPartidas());
        }
    }
	
	public void limpiarControles()
	{
		formEgresos.getTxtCodigo().setText("");
		formEgresos.getDateFechaIngreso().setDate(null);
		formEgresos.getcBoxPartida().setSelectedIndex(-1);
		formEgresos.getcBoxProveedor().setSelectedIndex(-1);
		formEgresos.getcBoxIngreso().setSelectedIndex(-1);
		formEgresos.getTxtMontoSalida().setText("");
		formEgresos.getTxtNroFactura().setText("");
		formEgresos.getTxtObservaciones().setText("");
		formEgresos.lblNombreIngreso.setText("");
	}
	
	public void habilitarControles(boolean estadoHabilitacion)
	{
		formEgresos.getDateFechaIngreso().setEnabled(estadoHabilitacion);
		formEgresos.getcBoxPartida().setEnabled(estadoHabilitacion);
		formEgresos.getcBoxProveedor().setEnabled(estadoHabilitacion);
		formEgresos.getcBoxIngreso().setEnabled(estadoHabilitacion);
		formEgresos.getTxtMontoSalida().setEditable(estadoHabilitacion);
		formEgresos.getTxtNroFactura().setEditable(estadoHabilitacion);
		formEgresos.getTxtObservaciones().setEditable(estadoHabilitacion);
		
		formEgresos.getTree().setEnabled(estadoHabilitacion);
	}
	
	public void habilitarBotones(boolean nuevo, boolean aceptar, boolean cancelar, boolean eliminar, boolean modificar)
	{
		formEgresos.getBtnAceptar().setEnabled(aceptar);
		formEgresos.getBtnCancelar().setEnabled(cancelar);		
		formEgresos.getBtnEliminar().setEnabled(eliminar);
		formEgresos.getBtnModificar().setEnabled(modificar);
		formEgresos.getBtnNuevo().setEnabled(nuevo);
	}
	
	public boolean validarDatos()
	{
		if(formEgresos.getDateFechaIngreso().getDate() == null)
		{
			JOptionPane.showMessageDialog(formEgresos, "No ha seleccionado la fecha de Egreso", "Egresos", JOptionPane.ERROR_MESSAGE);
			formEgresos.getDateFechaIngreso().grabFocus();
			return false;
		}
		if(formEgresos.getcBoxPartida().getSelectedIndex() < 0)
		{
			JOptionPane.showMessageDialog(formEgresos, "No ha seleccionado a\u00FAn la partida", "Egresos", JOptionPane.ERROR_MESSAGE);
			formEgresos.getcBoxPartida().grabFocus();
			return false;
			
		}
		if(formEgresos.getcBoxIngreso().getSelectedIndex() < 0)
		{
			JOptionPane.showMessageDialog(formEgresos, "No ha seleccionado a\u00FAn el ingreso de donde se realiza la salida", "Egresos", JOptionPane.ERROR_MESSAGE);
			formEgresos.getcBoxIngreso().grabFocus();
			return false;			
		}
		if(formEgresos.getcBoxProveedor().getSelectedIndex() < 0)
		{
			JOptionPane.showMessageDialog(formEgresos, "No ha seleccionado a\u00FAn el proveedor", "Egresos", JOptionPane.ERROR_MESSAGE);
			formEgresos.getcBoxProveedor().grabFocus();
			return false;			
		}
		
		if(formEgresos.getTxtNroFactura().getText().isEmpty())
		{
			JOptionPane.showMessageDialog(formEgresos, "No ha ingresado el Nro de Factura", "Egresos", JOptionPane.ERROR_MESSAGE);
			formEgresos.getTxtNroFactura().grabFocus();
			return false;
		}
		if(formEgresos.getTxtMontoSalida().getText().isEmpty())
		{
			JOptionPane.showMessageDialog(formEgresos, "No ha ingresado el Monto de Salida", "Egresos", JOptionPane.ERROR_MESSAGE);
			formEgresos.getTxtMontoSalida().grabFocus();
			return false;
		}
		
		
		double montoSalida = Double.parseDouble(formEgresos.getTxtMontoSalida().getText());
		if(montoSalida == 0)
		{
			JOptionPane.showMessageDialog(formEgresos, "El Monto de Salida ingresado no puede ser cero", "Egresos", JOptionPane.ERROR_MESSAGE);
			formEgresos.getTxtMontoSalida().grabFocus();
			return false;
		}
		double montoSaldo = ((Ingreso) formEgresos.getcBoxIngreso().getSelectedItem()).getMontoActual();
		if(montoSalida > montoSaldo)
		{
			JOptionPane.showMessageDialog(formEgresos, "El Monto de Salida no puede superar al saldo existente del Ingreso seleccionado", "Egresos", JOptionPane.ERROR_MESSAGE);
			formEgresos.getTxtMontoSalida().grabFocus();
			return false;
		}
		
		return true;
	}
	
	public void mostrarParaInsercion(Egreso egresoAux)
	{
		limpiarControles();
		if(egresoAux != null) //para edicion
		{
			TipoOperacion = "E";
			cargarDatos(egresoAux);
		}
		else
		{
			TipoOperacion = "I";
			
			Map<String, Date> mapa = new HashMap<String, Date>();
			mapa.put("fechaHoraServidor", null);
			daoEgreso.obtenerFechaHoraServidor(mapa); //("myMappedStatement",myParams);
			
			formEgresos.getDateFechaIngreso().setDate(mapa.get( "fechaHoraServidor"));
		}
		formEgresos.getBtnEliminar().setVisible(false);
		formEgresos.getBtnModificar().setVisible(false);
		
		habilitarControles(true);
		habilitarBotones(false, true, false, false, false);
		
	}
	
	public void cargarDatos(Egreso egresoAux) {
		// TODO Auto-generated method stub
		if(egresoAux != null)
		{
			formEgresos.getTxtCodigo().setText(String.valueOf(egresoAux.getCodigoEgreso()));
			formEgresos.getDateFechaIngreso().setDate(egresoAux.getFechaEgreso());
//			formEgresos.getcBoxPartida().getModel().setSelectedItem(egresoAux.getPartida());
			formEgresos.getcBoxPartida().setSelectedItem(egresoAux.getPartida());
//			formEgresos.getcBoxProveedor().getModel().setSelectedItem(egresoAux.getProveedor());
			formEgresos.getcBoxProveedor().setSelectedItem(egresoAux.getProveedor());
//			formEgresos.getcBoxIngreso().getModel().setSelectedItem(egresoAux.getIngreso());
			formEgresos.getcBoxIngreso().setSelectedItem(egresoAux.getIngreso());
			formEgresos.getTxtMontoSalida().setText(String.valueOf(egresoAux.getMontoSalida()));
			formEgresos.getTxtNroFactura().setText(String.valueOf(egresoAux.getNroFactura()));
			formEgresos.getTxtObservaciones().setText(egresoAux.getObservaciones());	
			formEgresos.lblNombreIngreso.setText(egresoAux.getIngreso().getNombreIngreso());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(TipoOperacion != null && TipoOperacion != "" && !TipoOperacion.isEmpty() && e.getSource().equals(formEgresos.getcBoxIngreso()))
		{
			if(formEgresos.getcBoxIngreso().getSelectedIndex() >= 0)
			{
				Ingreso aux = (Ingreso) formEgresos.getcBoxIngreso().getSelectedItem();
				formEgresos.lblNombreIngreso.setText(aux.getNombreIngreso());
			}
		}
		
		if(e.getActionCommand().compareTo("Nuevo") == 0)
		{
			limpiarControles();
			habilitarControles(true);
			TipoOperacion = "I";
			habilitarBotones(false, true, true, false, false);
			
			Map<String, Date> mapa = new HashMap<String, Date>();
			mapa.put("fechaHoraServidor", null);
			daoEgreso.obtenerFechaHoraServidor(mapa); //("myMappedStatement",myParams);
			
			formEgresos.getDateFechaIngreso().setDate(mapa.get( "fechaHoraServidor"));
		}
		
		if(e.getActionCommand().compareTo("Cancelar") == 0)
		{
			limpiarControles();
			habilitarControles(false);
			TipoOperacion = "";
			habilitarBotones(true, false, false, false,false);
		}
		if(e.getActionCommand().compareTo("Cerrar") == 0)
		{
			this.formEgresos.setVisible(false);
		}
		if(e.getActionCommand().compareTo("Aceptar") == 0)			
		{
			if(!validarDatos())
			{
				
				return;
			}
			try {
				egresoActual = new Egreso();
				egresoActual.setFechaEgreso(formEgresos.getDateFechaIngreso().getDate());
				egresoActual.setPartida((Partida) formEgresos.getcBoxPartida().getSelectedItem());
				egresoActual.setCodigoPartida(egresoActual.getPartida().getCodigoPartida());
				egresoActual.setIngreso((Ingreso) formEgresos.getcBoxIngreso().getSelectedItem());
				egresoActual.setCodigoIngreso(egresoActual.getIngreso().getCodigoIngreso());
				egresoActual.setProveedor((Proveedor) formEgresos.getcBoxProveedor().getSelectedItem());
				egresoActual.setCodigo_proveedor(egresoActual.getProveedor().getCodigoProveedor());
				egresoActual.setMontoSalida(Double.parseDouble(formEgresos.getTxtMontoSalida().getText()));
				egresoActual.setNroFactura(Integer.parseInt(formEgresos.getTxtNroFactura().getText()));
				egresoActual.setCodigoUsuario(codigoUsuario);
				egresoActual.setObservaciones(formEgresos.getTxtObservaciones().getText());
				
				if(TipoOperacion.compareTo("I") == 0)
				{
					daoEgreso.insert(egresoActual);
					
				}
				else
				{
					egresoActual.setCodigoEgreso(Integer.parseInt(formEgresos.getTxtCodigo().getText()));
					daoEgreso.updateByPrimaryKey(egresoActual);
				}
				session.commit();
				JOptionPane.showMessageDialog(formEgresos, "Registro almacenado correctamente", "Egresos", JOptionPane.INFORMATION_MESSAGE);
				if(!formEgresos.getBtnEliminar().isVisible())
				{
					this.formEgresos.setVisible(false);
				}
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(formEgresos, "Existe un valor num\u00E9rico escrito incorrectamente", "Error", JOptionPane.ERROR_MESSAGE);
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(formEgresos, "Ocurri\u00F3 la siguiente excepcion " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(formEgresos.getTxtMontoSalida()))
			FormUtilities.keyTyped(e, "decimal", formEgresos);
		else
			FormUtilities.keyTyped(e, "entero", formEgresos);
	}

	
	@Override
	public void valueChanged(TreeSelectionEvent e) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode node = (DefaultMutableTreeNode)
				formEgresos.getTree().getLastSelectedPathComponent();

		/* if nothing is selected */ 
		if (node == null) { partidaActual = null; return;}
		
		/* retrieve the node that was selected */ 
		Partida partidaSeleccionada = (Partida) node.getUserObject();

		formEgresos.getcBoxPartida().getModel().setSelectedItem(partidaSeleccionada);
	}
	
}
