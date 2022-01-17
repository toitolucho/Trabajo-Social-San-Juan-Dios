package org.quarkbit.trabajosocialsanjuan.formularios.tablemodels;


import java.util.LinkedList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.quarkbit.trabajosocialsanjuan.dao.domain.Partida;


public class ModeloPartidas implements TableModel{
	private LinkedList<Partida> listaPartida = new LinkedList<Partida>();


	public LinkedList<Partida> getListaPartida() {
		return listaPartida;
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
			return "Partida";

		default:
			return "";
		}
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listaPartida.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return listaPartida.get(rowIndex).getCodigoPartida();
		case 1:
			return listaPartida.get(rowIndex).getNombrePartida();
		

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
		Partida Partida = listaPartida.get(rowIndex);
		switch (columnIndex) {
		case 0:
			Partida.setCodigoPartida(( String)aValue);
			break;
		case 1:
			Partida.setNombrePartida((String)aValue);
			break;
		
		default:
			break;
		}
		//actualiza los listeners
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex, rowIndex));
	}
	public void AnadirPartida(Partida PartidaNuevo)
	{
		if(PartidaNuevo != null)
			listaPartida.add(PartidaNuevo);
		else
			listaPartida.add(null);
		
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				getColumnCount() -1, getRowCount() -1, 
				TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
		actualizarListeners(eventoNuevo);
	}
	public Partida eliminarPartida(int rowIndex)
	{
		Partida PartidaEliminado = listaPartida.remove(rowIndex);
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				rowIndex, rowIndex, TableModelEvent.ALL_COLUMNS, 
				TableModelEvent.DELETE);
		actualizarListeners(eventoNuevo);
		return PartidaEliminado;
	}
	
	public Partida obtenerPartida(int rowIndex)
	{
		if(rowIndex >= 0)
			return listaPartida.get(rowIndex);
		else 
			return null;
	}
	public void setPartida(int rowIndex, Partida PartidaNuevo)
	{
		if(rowIndex >= 0)
		{
			listaPartida.set(rowIndex, PartidaNuevo);
		}
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex));
	}
	
	public void setListPartida(List<Partida> lista)
	{		
		listaPartida.addAll(lista);
		
	}

}
