package org.quarkbit.trabajosocialsanjuan.formularios.tablemodels;


import java.util.LinkedList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.quarkbit.trabajosocialsanjuan.dao.domain.IngresoTipo;;


public class ModeloIngresosTipos implements TableModel{
	private LinkedList<IngresoTipo> listaIngresoTipo = new LinkedList<IngresoTipo>();


	public LinkedList<IngresoTipo> getListaIngresoTipo() {
		return listaIngresoTipo;
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
		return listaIngresoTipo.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return listaIngresoTipo.get(rowIndex).getCodigoIngresoTipo();
		case 1:
			return listaIngresoTipo.get(rowIndex).getNombreIngresoTipo();
		

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
		IngresoTipo IngresoTipo = listaIngresoTipo.get(rowIndex);
		switch (columnIndex) {
		case 0:
			IngresoTipo.setCodigoIngresoTipo(( Integer)aValue);
			break;
		case 1:
			IngresoTipo.setNombreIngresoTipo((String)aValue);
			break;
		
		default:
			break;
		}
		//actualiza los listeners
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex, rowIndex));
	}
	public void AnadirIngresoTipo(IngresoTipo IngresoTipoNuevo)
	{
		if(IngresoTipoNuevo != null)
			listaIngresoTipo.add(IngresoTipoNuevo);
		else
			listaIngresoTipo.add(null);
		
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				getColumnCount() -1, getRowCount() -1, 
				TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
		actualizarListeners(eventoNuevo);
	}
	public IngresoTipo eliminarIngresoTipo(int rowIndex)
	{
		IngresoTipo IngresoTipoEliminado = listaIngresoTipo.remove(rowIndex);
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				rowIndex, rowIndex, TableModelEvent.ALL_COLUMNS, 
				TableModelEvent.DELETE);
		actualizarListeners(eventoNuevo);
		return IngresoTipoEliminado;
	}
	
	public IngresoTipo obtenerIngresoTipo(int rowIndex)
	{
		if(rowIndex >= 0)
			try {
				return listaIngresoTipo.get(rowIndex);
			} catch (Exception e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				return null;
			}
		else 
			return null;
	}
	public void setIngresoTipo(int rowIndex, IngresoTipo IngresoTipoNuevo)
	{
		if(rowIndex >= 0)
		{
			listaIngresoTipo.set(rowIndex, IngresoTipoNuevo);
		}
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex));
	}
	
	public void setListIngresoTipo(List<IngresoTipo> lista)
	{		
		listaIngresoTipo.addAll(lista);
		
	}

}
