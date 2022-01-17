package org.quarkbit.trabajosocialsanjuan.formularios.tablemodels;


import java.util.LinkedList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.quarkbit.trabajosocialsanjuan.dao.domain.Proveedor;


public class ModeloProveedores implements TableModel{
	private LinkedList<Proveedor> listaProveedor = new LinkedList<Proveedor>();


	public LinkedList<Proveedor> getListaProveedor() {
		return listaProveedor;
	}

	private LinkedList<TableModelListener> listeners = new LinkedList<TableModelListener>();
	@Override
	public void addTableModelListener(TableModelListener evento) {
		listeners.add(evento);
	}
	


	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return Integer.class;			
		case 1 :
			return String.class;
		
		default:
			return Object.class;
		}
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return "Codigo";			
		case 1 :
			return "Proveedor";

		default:
			return "";
		}
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listaProveedor.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return listaProveedor.get(rowIndex).getCodigoProveedor();
		case 1:
			return listaProveedor.get(rowIndex).getNombreProveedor();
		

		default:
			return null;
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		listeners.remove(l);
	}
	private void actualizarListeners(TableModelEvent evento)
	{		
		for(int i = 0; i< listeners.size(); i++)
		{
			listeners.get(i).tableChanged(evento);			
		}
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Proveedor Proveedor = listaProveedor.get(rowIndex);
		switch (columnIndex) {
		case 0:
			Proveedor.setCodigoProveedor(( Integer)aValue);
			break;
		case 1:
			Proveedor.setNombreProveedor((String)aValue);
			break;
		
		default:
			break;
		}
		//actualiza los listeners
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex, rowIndex));
	}
	public void AnadirProveedor(Proveedor ProveedorNuevo)
	{
		if(ProveedorNuevo != null)
			listaProveedor.add(ProveedorNuevo);
		else
			listaProveedor.add(null);
		
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				getColumnCount() -1, getRowCount() -1, 
				TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
		actualizarListeners(eventoNuevo);
	}
	public Proveedor eliminarProveedor(int rowIndex)
	{
		Proveedor ProveedorEliminado = listaProveedor.remove(rowIndex);
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				rowIndex, rowIndex, TableModelEvent.ALL_COLUMNS, 
				TableModelEvent.DELETE);
		actualizarListeners(eventoNuevo);
		return ProveedorEliminado;
	}
	
	public Proveedor obtenerProveedor(int rowIndex)
	{
		if(rowIndex >= 0)
			return listaProveedor.get(rowIndex);
		else 
			return null;
	}
	public void setProveedor(int rowIndex, Proveedor ProveedorNuevo)
	{
		if(rowIndex >= 0)
		{
			listaProveedor.set(rowIndex, ProveedorNuevo);
		}
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex));
	}
	
	public void setListProveedor(List<Proveedor> lista)
	{	
		listaProveedor.clear();
		listaProveedor.addAll(lista);	
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				0, getRowCount(), TableModelEvent.ALL_COLUMNS, 
				TableModelEvent.INSERT);
		actualizarListeners(eventoNuevo);
	}
}