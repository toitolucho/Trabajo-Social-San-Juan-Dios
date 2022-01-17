package org.quarkbit.trabajosocialsanjuan.formularios.tablemodels;


import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.quarkbit.trabajosocialsanjuan.dao.domain.MenuComida;


public class ModeloMenusComidas implements TableModel{
	private LinkedList<MenuComida> listaMenuComida = new LinkedList<MenuComida>();


	public LinkedList<MenuComida> getListaMenuComida() {
		return listaMenuComida;
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
			return Date.class;
		case 2:
			return Date.class;
		case 3 :
			return Double.class;
		
		default:
			return Object.class;
		}
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return "Nombre";			
		case 1 :
			return "Inicia";
		case 2 :
			return "Termina";
		case 4 :
			return "Monto";

		default:
			return "";
		}
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listaMenuComida.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return listaMenuComida.get(rowIndex).getNombreMenu();
		case 1:
			return listaMenuComida.get(rowIndex).getFechaInicio();
		case 2:
			return listaMenuComida.get(rowIndex).getFechaFin();
		case 3:
			return listaMenuComida.get(rowIndex).getMontoTotal();
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
		MenuComida MenuComida = listaMenuComida.get(rowIndex);
		switch (columnIndex) {
		case 0:
			MenuComida.setNombreMenu(( String)aValue);
			break;
		case 1:
			MenuComida.setFechaInicio((Date)aValue);
		case 2:
			MenuComida.setFechaFin((Date)aValue);
		case 3:
			MenuComida.setMontoTotal((Double)aValue);
			break;
		
		default:
			break;
		}
		//actualiza los listeners
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex, rowIndex));
	}
	public void AnadirMenuComida(MenuComida MenuComidaNuevo)
	{
		if(MenuComidaNuevo != null)
			listaMenuComida.add(MenuComidaNuevo);
		else
			listaMenuComida.add(null);
		
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				getColumnCount() -1, getRowCount() -1, 
				TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
		actualizarListeners(eventoNuevo);
	}
	public MenuComida eliminarMenuComida(int rowIndex)
	{
		MenuComida MenuComidaEliminado = listaMenuComida.remove(rowIndex);
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				rowIndex, rowIndex, TableModelEvent.ALL_COLUMNS, 
				TableModelEvent.DELETE);
		actualizarListeners(eventoNuevo);
		return MenuComidaEliminado;
	}
	
	public MenuComida obtenerMenuComida(int rowIndex)
	{
		if(rowIndex >= 0)
			return listaMenuComida.get(rowIndex);
		else 
			return null;
	}
	public void setMenuComida(int rowIndex, MenuComida MenuComidaNuevo)
	{
		if(rowIndex >= 0)
		{
			listaMenuComida.set(rowIndex, MenuComidaNuevo);
		}
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex));
	}
	
	public void setListMenuComida(List<MenuComida> lista)
	{		
		listaMenuComida.addAll(lista);
		
	}

}
