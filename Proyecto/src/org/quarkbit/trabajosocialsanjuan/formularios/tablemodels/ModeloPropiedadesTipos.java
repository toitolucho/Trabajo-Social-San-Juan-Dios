package org.quarkbit.trabajosocialsanjuan.formularios.tablemodels;


import java.util.LinkedList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.quarkbit.trabajosocialsanjuan.dao.domain.PropiedadTipo;;


public class ModeloPropiedadesTipos implements TableModel{
	private LinkedList<PropiedadTipo> listaPropiedadTipo = new LinkedList<PropiedadTipo>();


	public LinkedList<PropiedadTipo> getListaPropiedadTipo() {
		return listaPropiedadTipo;
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
			return String.class;			
		case 1 :
			return String.class;
		case 2:
			return Integer.class;
		
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
			return "Fuentes de Ingreso";

		default:
			return "";
		}
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listaPropiedadTipo.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return listaPropiedadTipo.get(rowIndex).getNumeroPropiedadTipo();
		case 1:
			return listaPropiedadTipo.get(rowIndex).getNombrePropiedadTipo();
		

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
		PropiedadTipo PropiedadTipo = listaPropiedadTipo.get(rowIndex);
		switch (columnIndex) {
		case 0:
			PropiedadTipo.setNumeroPropiedadTipo(( Integer)aValue);
			break;
		case 1:
			PropiedadTipo.setNombrePropiedadTipo((String)aValue);
			break;
		
		default:
			break;
		}
		//actualiza los listeners
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex, rowIndex));
	}
	public void AnadirPropiedadTipo(PropiedadTipo PropiedadTipoNuevo)
	{
		if(PropiedadTipoNuevo != null)
			listaPropiedadTipo.add(PropiedadTipoNuevo);
		else
			listaPropiedadTipo.add(null);
		
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				getColumnCount() -1, getRowCount() -1, 
				TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
		actualizarListeners(eventoNuevo);
	}
	public PropiedadTipo eliminarPropiedadTipo(int rowIndex)
	{
		PropiedadTipo PropiedadTipoEliminado = listaPropiedadTipo.remove(rowIndex);
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				rowIndex, rowIndex, TableModelEvent.ALL_COLUMNS, 
				TableModelEvent.DELETE);
		actualizarListeners(eventoNuevo);
		return PropiedadTipoEliminado;
	}
	
	public PropiedadTipo obtenerPropiedadTipo(int rowIndex)
	{
		if(rowIndex >= 0)
			try {
				return listaPropiedadTipo.get(rowIndex);
			} catch (Exception e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				return null;
			}
		else 
			return null;
	}
	public void setPropiedadTipo(int rowIndex, PropiedadTipo PropiedadTipoNuevo)
	{
		if(rowIndex >= 0)
		{
			listaPropiedadTipo.set(rowIndex, PropiedadTipoNuevo);
		}
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex));
	}
	
	public void setListPropiedadTipo(List<PropiedadTipo> lista)
	{	
		listaPropiedadTipo.clear();
		listaPropiedadTipo.addAll(lista);
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				0, getRowCount(), TableModelEvent.ALL_COLUMNS, 
				TableModelEvent.INSERT);
		actualizarListeners(eventoNuevo);
	}

}
