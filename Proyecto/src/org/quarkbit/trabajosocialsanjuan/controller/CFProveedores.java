package org.quarkbit.trabajosocialsanjuan.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.apache.ibatis.session.SqlSession;
import org.quarkbit.trabajosocialsanjuan.dao.Coneccion;
import org.quarkbit.trabajosocialsanjuan.dao.domain.ProveedorExample;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Proveedor;
import org.quarkbit.trabajosocialsanjuan.dao.domain.ProveedorExample;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.ProveedorMapper;
import org.quarkbit.trabajosocialsanjuan.formularios.FProveedores;
import org.quarkbit.trabajosocialsanjuan.formularios.tablemodels.ModeloProveedores;
import org.quarkbit.trabajosocialsanjuan.utils.FormUtilities;

public class CFProveedores extends KeyAdapter implements ActionListener, ListSelectionListener, DocumentListener {
	
	FProveedores formProveedor;
	SqlSession session;
	ProveedorMapper daoProveedorMapper;
	ModeloProveedores modeloProveedor;
	String tipoOperacion = "";
	Proveedor proveedorActual;
	ProveedorExample filtro;
	
	public CFProveedores(FProveedores formProveedor)
	{
		this.formProveedor = formProveedor;
		proveedorActual = new Proveedor();
		filtro = new ProveedorExample();
	}
	
	public void onLoad()
	{
		session = Coneccion.getSqlSessionFactory().openSession();
		daoProveedorMapper = session.getMapper(ProveedorMapper.class);
		modeloProveedor = new ModeloProveedores();
		
		formProveedor.getjTableProveedor().setModel(modeloProveedor);
		formProveedor.getTxtCodigo().setEnabled(false);	
		
		formProveedor.getBtnAceptar().addActionListener(this);
		formProveedor.getBtnNuevo().addActionListener(this);
		formProveedor.getBtnCancelar().addActionListener(this);
		formProveedor.getBtnModificar().addActionListener(this);
		formProveedor.getBtnEliminar().addActionListener(this);
		formProveedor.getBtnCerrar().addActionListener(this);
		
		
		habilitarControles(false);
		habilitarBotones(true, false, false, false, false);
		modeloProveedor.setListProveedor(daoProveedorMapper.selectByExample(null));
		formProveedor.getjTableProveedor().getSelectionModel().addListSelectionListener(this);
		formProveedor.getjTableProveedor().getColumn("Codigo").setPreferredWidth(5);
		FormUtilities.centrar(formProveedor);
		
		formProveedor.getcBoxEstado().addItem("HABILITADO");
		formProveedor.getcBoxEstado().addItem("DESHABILITADO");
		
		formProveedor.getTxtNIT().addKeyListener(this);
		formProveedor.getTxtTextoBusqueda().addActionListener(this);
		formProveedor.getTxtTextoBusqueda().getDocument().addDocumentListener(this);
//		mostrarParaInsercion(null);
	}
	
	public void mostrarParaInsercion(Proveedor Proveedor)
	{
		if(Proveedor != null) //para edicion
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
		formProveedor.mostrorSoloControles();
	}
	
	public void limpiarControles()
	{
		formProveedor.getTxtCodigo().setText("");
		formProveedor.getTxtDescripcion().setText("");
		formProveedor.getTxtNombre().setText("");
		formProveedor.getTxtNIT().setText("");
		formProveedor.getcBoxEstado().setSelectedIndex(-1);
	}
	
	public void habilitarControles(boolean estadHabilitacion)
	{
		formProveedor.getTxtNombre().setEnabled(estadHabilitacion);
		formProveedor.getTxtDescripcion().setEnabled(estadHabilitacion);
		formProveedor.getTxtNIT().setEnabled(estadHabilitacion);
		formProveedor.getcBoxEstado().setEnabled(estadHabilitacion);

	}
	
	public boolean validarControles()
	{
		if(formProveedor.getTxtNombre().getText().trim().isEmpty())
		{
			JOptionPane.showMessageDialog(formProveedor, "A\u00FAn no ha ingresado el nombre del Proveedor", "Proveedor", JOptionPane.ERROR_MESSAGE);
			formProveedor.getTxtNombre().grabFocus();
			return false;
		}
		ProveedorExample filtro = new ProveedorExample();
		filtro.or().andNombreProveedorEqualTo(formProveedor.getTxtNombre().getText().toUpperCase());
		if(tipoOperacion.compareTo("I") == 0 && daoProveedorMapper.countByExample(filtro) > 0)
		{
			JOptionPane.showMessageDialog(formProveedor, "El nombre del Proveedor ya se encuentra registrado", "Proveedor", JOptionPane.ERROR_MESSAGE);
			formProveedor.getTxtNombre().grabFocus();
			return false;
		}
		return true;
	}
	
	public void habilitarBotones(boolean nuevo, boolean aceptar, boolean cancelar,
			boolean modificar, boolean eliminar)
	{
		formProveedor.getBtnAceptar().setEnabled(aceptar);
		formProveedor.getBtnNuevo().setEnabled(nuevo);
		formProveedor.getBtnCancelar().setEnabled(cancelar);
		formProveedor.getBtnModificar().setEnabled(modificar);
		formProveedor.getBtnEliminar().setEnabled(eliminar);
	}
	
	public void cargarDatos(Proveedor ProveedorAux)
	{
		if(ProveedorAux != null)
		{
			proveedorActual = ProveedorAux;
			formProveedor.getTxtCodigo().setText(ProveedorAux.getCodigoProveedor().toString());
			formProveedor.getTxtNombre().setText(ProveedorAux.getNombreProveedor());
			formProveedor.getTxtDescripcion().setText(ProveedorAux.getDescripcion());
			formProveedor.getTxtNIT().setText(ProveedorAux.getNitProveedor());
			formProveedor.getcBoxEstado().setSelectedItem(ProveedorAux.getEstado());
			habilitarBotones(true, false, true, true, true);
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getActionCommand().compareTo("buscar") == 0)
		{
			if(!formProveedor.getTxtTextoBusqueda().getText().isEmpty())
			{
				filtro.clear();
				filtro.or().andNombreProveedorLike("%"+formProveedor.getTxtTextoBusqueda().getText().toUpperCase()+"%");
				modeloProveedor.setListProveedor(daoProveedorMapper.selectByExample(filtro));				
			}
			else
			{
				modeloProveedor.setListProveedor(daoProveedorMapper.selectByExample(null));
			}
			formProveedor.getTxtTextoBusqueda().grabFocus();
			formProveedor.getTxtTextoBusqueda().selectAll();
			
		}
		
		if(formProveedor.getBtnAceptar().equals(event.getSource()))
		{
			if(validarControles())
			{
				try {
					proveedorActual = new Proveedor();
					proveedorActual.setCodigoProveedor(-1);
					proveedorActual.setNombreProveedor(formProveedor.getTxtNombre().getText().toUpperCase());
					proveedorActual.setDescripcion(formProveedor.getTxtDescripcion().getText());
					proveedorActual.setNitProveedor(formProveedor.getTxtNIT().getText());
					proveedorActual.setEstadoProveedor(formProveedor.getcBoxEstado().getSelectedItem().toString().compareTo("HABILITADO") == 0 ? "A" : "B");
					if(tipoOperacion.compareTo("I")==0)
					{
						daoProveedorMapper.insert(proveedorActual);
						session.commit();
						
						Map<String, Integer> mapa = new HashMap<String, Integer>();
						mapa.put("ultimoId", 0);
						daoProveedorMapper.obtenerUltimoId(mapa); //("myMappedStatement",myParams);
						proveedorActual.setCodigoProveedor(mapa.get("ultimoId"));
						
//					System.out.println("codigo actual = " + ProveedorActual.getCodigoProveedor());
						modeloProveedor.AnadirProveedor(proveedorActual);
					}
					else
					{
						modeloProveedor.setProveedor(formProveedor.getjTableProveedor().getSelectedRow(), proveedorActual);
						proveedorActual.setCodigoProveedor(Integer.parseInt(formProveedor.getTxtCodigo().getText()));
						daoProveedorMapper.updateByPrimaryKey(proveedorActual);
						session.commit();
						
						
					}
					
					if(!formProveedor.getBtnNuevo().isVisible())
					{
						
						formProveedor.setVisible(false);
						formProveedor.dispose();
						return;
					}
					tipoOperacion ="";
					habilitarBotones(true, false, false, true, true);
					habilitarControles(false);
					JOptionPane.showMessageDialog(formProveedor, "Se almacen\u00F3 correctamente el registro actual", "Proveedores", JOptionPane.INFORMATION_MESSAGE);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(formProveedor, "Ocurri\u00F3 la siguiente excepcion " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}
		if(formProveedor.getBtnNuevo().equals(event.getSource()))
		{
			habilitarBotones(false, true, true, false, false);
			habilitarControles(true);
			limpiarControles();
			tipoOperacion = "I";
			formProveedor.getcBoxEstado().setSelectedItem("HABILITADO");
			formProveedor.getcBoxEstado().setEnabled(false);
			formProveedor.getTxtNombre().grabFocus();
			formProveedor.getjTableProveedor().clearSelection();
		}
		if(formProveedor.getBtnCerrar().equals(event.getSource()))
		{
			formProveedor.setVisible(false);
			formProveedor.dispose();
			
		}
		if(formProveedor.getBtnModificar().equals(event.getSource()))
		{
			habilitarBotones(false, true, true, false, false);
			habilitarControles(true);			
			tipoOperacion = "E";
			
		}
		if(formProveedor.getBtnEliminar().equals(event.getSource()))
		{
			if(JOptionPane.showConfirmDialog(formProveedor, "¿Se encuentra seguro de eliminar el registro actual?", "Proveedores", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			{
				System.out.println("Elemento a eliminar " + Integer.parseInt(formProveedor.getTxtCodigo().getText()));
				
				modeloProveedor.eliminarProveedor(formProveedor.getjTableProveedor().getSelectedRow());
				
				
				daoProveedorMapper.deleteByPrimaryKey(Integer.parseInt(formProveedor.getTxtCodigo().getText()));
				
				session.commit();
				
				limpiarControles();
				JOptionPane.showMessageDialog(formProveedor, "Objeto eliminado correctamente", "Proveedor", JOptionPane.INFORMATION_MESSAGE);
				habilitarBotones(true, false, false, false, false);
			}
			
		}
		
		if(formProveedor.getBtnCancelar().equals(event.getSource()))
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
		cargarDatos(modeloProveedor.obtenerProveedor(indice));
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		FormUtilities.keyTyped(e, "entero", formProveedor);
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub		
		actionPerformed(new ActionEvent(formProveedor.getTxtTextoBusqueda(), 25, "buscar"));
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		if(formProveedor.getTxtTextoBusqueda().getText().isEmpty())
			actionPerformed(new ActionEvent(formProveedor.getTxtTextoBusqueda(), 25, "buscar"));
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}
