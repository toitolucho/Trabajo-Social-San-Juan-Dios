package org.quarkbit.trabajosocialsanjuan.formularios.tablemodels;


import java.util.LinkedList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.quarkbit.trabajosocialsanjuan.dao.domain.CategoriaComida;



public class ModeloCategoriaComidas implements TableModel{
	private LinkedList<CategoriaComida> listaCategoriaComida = new LinkedList<CategoriaComida>();


	public LinkedList<CategoriaComida> getListaCategoriaComida() {
		return listaCategoriaComida;
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
		case 2:
			return Integer.class;
	
		
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
			return "Codigo";			
		case 1 :
			return "Categoria";
		case 2 :
			return "Posicion";

		default:
			return "";
		}
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listaCategoriaComida.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return listaCategoriaComida.get(rowIndex).getCodigoCategoria();
		case 1:
			return listaCategoriaComida.get(rowIndex).getNombreCategoria();
		case 2:
			return listaCategoriaComida.get(rowIndex).getOrdenCategoria();

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
		CategoriaComida CategoriaComida = listaCategoriaComida.get(rowIndex);
		switch (columnIndex) {
		case 0:
			CategoriaComida.setCodigoCategoria(( Integer)aValue);
			break;
		case 1:
			CategoriaComida.setNombreCategoria((String)aValue);
			break;
		case 2:
			CategoriaComida.setOrdenCategoria((Integer)aValue);
			break;
		default:
			break;
		}
		//actualiza los listeners
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex, rowIndex));
	}
	public void AnadirCategoriaComida(CategoriaComida CategoriaComidaNuevo)
	{
		if(CategoriaComidaNuevo != null)
			listaCategoriaComida.add(CategoriaComidaNuevo);
		else
			listaCategoriaComida.add(null);
		
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				getColumnCount() -1, getRowCount() -1, 
				TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
		actualizarListeners(eventoNuevo);
	}
	public CategoriaComida eliminarCategoriaComida(int rowIndex)
	{
		CategoriaComida CategoriaComidaEliminado = listaCategoriaComida.remove(rowIndex);
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				rowIndex, rowIndex, TableModelEvent.ALL_COLUMNS, 
				TableModelEvent.DELETE);
		actualizarListeners(eventoNuevo);
		return CategoriaComidaEliminado;
	}
	
	public CategoriaComida obtenerCategoriaComida(int rowIndex)
	{
		if(rowIndex >= 0)
			try {
				return listaCategoriaComida.get(rowIndex);
			} catch (Exception e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				return null;
			}
		else 
			return null;
	}
	public void setCategoriaComida(int rowIndex, CategoriaComida CategoriaComidaNuevo)
	{
		if(rowIndex >= 0)
		{
			listaCategoriaComida.set(rowIndex, CategoriaComidaNuevo);
		}
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex));
	}
	
	public void setListCategoriaComida(List<CategoriaComida> lista)
	{		
		listaCategoriaComida.addAll(lista);
		
	}

}
