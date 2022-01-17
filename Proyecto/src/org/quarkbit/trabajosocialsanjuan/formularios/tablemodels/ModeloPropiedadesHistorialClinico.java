package org.quarkbit.trabajosocialsanjuan.formularios.tablemodels;


import java.util.LinkedList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.quarkbit.trabajosocialsanjuan.dao.domain.PropiedadHistorialClinico;;


public class ModeloPropiedadesHistorialClinico implements TableModel{
	private LinkedList<PropiedadHistorialClinico> listaPropiedadHistorialClinico = new LinkedList<PropiedadHistorialClinico>();


	public LinkedList<PropiedadHistorialClinico> getListaPropiedadHistorialClinico() {
		return listaPropiedadHistorialClinico;
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
			return String.class;
		
		default:
			return Object.class;
		}
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return "Tipo";			
		case 1 :
			return "Propiedad";
		case 2 :
			return "Descripcion";
		default:
			return "";
		}
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listaPropiedadHistorialClinico.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return listaPropiedadHistorialClinico.get(rowIndex).getPropiedadTipo() != null ?
					listaPropiedadHistorialClinico.get(rowIndex).getPropiedadTipo().getNombrePropiedadTipo() : "";
		case 1:
			return listaPropiedadHistorialClinico.get(rowIndex).getNombrePropiedad();
		case 2:
			return listaPropiedadHistorialClinico.get(rowIndex).getDescripcion();
		

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
//		PropiedadHistorialClinico PropiedadHistorialClinico = listaPropiedadHistorialClinico.get(rowIndex);
		switch (columnIndex) {
		case 0:
//			PropiedadHistorialClinico.setNumeroPropiedadHistorialClinico(( Integer)aValue);
			break;
		case 1:
//			PropiedadHistorialClinico.setNombrePropiedadHistorialClinico((String)aValue);
			break;
		
		default:
			break;
		}
		//actualiza los listeners
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex, rowIndex));
	}
	public void AnadirPropiedadHistorialClinico(PropiedadHistorialClinico PropiedadHistorialClinicoNuevo)
	{
		if(PropiedadHistorialClinicoNuevo != null)
			listaPropiedadHistorialClinico.add(PropiedadHistorialClinicoNuevo);
		else
			listaPropiedadHistorialClinico.add(null);
		
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				getColumnCount() -1, getRowCount() -1, 
				TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
		actualizarListeners(eventoNuevo);
	}
	public PropiedadHistorialClinico eliminarPropiedadHistorialClinico(int rowIndex)
	{
		PropiedadHistorialClinico PropiedadHistorialClinicoEliminado = listaPropiedadHistorialClinico.remove(rowIndex);
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				rowIndex, rowIndex, TableModelEvent.ALL_COLUMNS, 
				TableModelEvent.DELETE);
		actualizarListeners(eventoNuevo);
		return PropiedadHistorialClinicoEliminado;
	}
	
	public PropiedadHistorialClinico obtenerPropiedadHistorialClinico(int rowIndex)
	{
		if(rowIndex >= 0)
			try {
				return listaPropiedadHistorialClinico.get(rowIndex);
			} catch (Exception e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				return null;
			}
		else 
			return null;
	}
	public void setPropiedadHistorialClinico(int rowIndex, PropiedadHistorialClinico PropiedadHistorialClinicoNuevo)
	{
		if(rowIndex >= 0)
		{
			listaPropiedadHistorialClinico.set(rowIndex, PropiedadHistorialClinicoNuevo);
		}
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex));
	}
	
	public void setListPropiedadHistorialClinico(List<PropiedadHistorialClinico> lista)
	{
		listaPropiedadHistorialClinico.clear();
		listaPropiedadHistorialClinico.addAll(lista);
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				0, getRowCount(), TableModelEvent.ALL_COLUMNS, 
				TableModelEvent.INSERT);
		actualizarListeners(eventoNuevo);
	}

}
