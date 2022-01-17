package org.quarkbit.trabajosocialsanjuan.formularios.tablemodels;


import java.util.LinkedList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.quarkbit.trabajosocialsanjuan.dao.domain.Comida;


public class ModeloComidas implements TableModel{
	private LinkedList<Comida> listaComida = new LinkedList<Comida>();


	public LinkedList<Comida> getListaComida() {
		return listaComida;
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
			return Double.class;
		
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
			return "Ccomida";			
		case 1 :
			return "Categoria";
		case 2 :
			return "Precio U.";
		default:
			return "";
		}
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listaComida.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		
		case 0:
			return listaComida.get(rowIndex).getNombreComida();
		case 1:
			return listaComida.get(rowIndex).getCategoriaComida() != null ? 
					listaComida.get(rowIndex).getCategoriaComida().getNombreCategoria(): "";
		case 2:
			return listaComida.get(rowIndex).getPrecioEstimado();
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
		Comida Comida = listaComida.get(rowIndex);
		switch (columnIndex) {
		case 1:
			Comida.getCategoriaComida().setNombreCategoria(( String)aValue);
			break;
		case 0:
			Comida.setNombreComida((String)aValue);
			break;
		case 2:
			Comida.setPrecioEstimado((Double)aValue);
			break;
		default:
			break;
		}
		//actualiza los listeners
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex, rowIndex));
	}
	public void AnadirComida(Comida ComidaNuevo)
	{
		if(ComidaNuevo != null)
			listaComida.add(ComidaNuevo);
		else
			listaComida.add(null);
		
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				getColumnCount() -1, getRowCount() -1, 
				TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
		actualizarListeners(eventoNuevo);
	}
	public Comida eliminarComida(int rowIndex)
	{
		Comida ComidaEliminado = listaComida.remove(rowIndex);
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				rowIndex, rowIndex, TableModelEvent.ALL_COLUMNS, 
				TableModelEvent.DELETE);
		actualizarListeners(eventoNuevo);
		return ComidaEliminado;
	}
	
	public Comida obtenerComida(int rowIndex)
	{
		if(rowIndex >= 0)
			try {
				return listaComida.get(rowIndex);
			} catch (Exception e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				return null;
			}
		else 
			return null;
	}
	public void setComida(int rowIndex, Comida ComidaNuevo)
	{
		if(rowIndex >= 0)
		{
			listaComida.set(rowIndex, ComidaNuevo);
		}
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex));
	}
	
	public void setListComida(List<Comida> lista)
	{		
		listaComida.addAll(lista);
		
	}

}
