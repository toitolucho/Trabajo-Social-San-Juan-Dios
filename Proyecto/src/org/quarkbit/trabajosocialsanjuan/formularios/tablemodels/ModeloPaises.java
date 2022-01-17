package org.quarkbit.trabajosocialsanjuan.formularios.tablemodels;


import java.util.LinkedList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.quarkbit.trabajosocialsanjuan.dao.domain.Pais;


public class ModeloPaises implements TableModel{
	private LinkedList<Pais> listaPais = new LinkedList<Pais>();


	public LinkedList<Pais> getListaPais() {
		return listaPais;
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
		case 2 :
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
			return "Codigo";			
		case 1 :
			return "Pais";
		case 2 :
			return "Nacionalidad";

		default:
			return "";
		}
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listaPais.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return listaPais.get(rowIndex).getCodigoPais();
		case 1:
			return listaPais.get(rowIndex).getNombrePais();
		case 2:
			return listaPais.get(rowIndex).getNacionalidad();

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
		Pais Pais = listaPais.get(rowIndex);
		switch (columnIndex) {
		case 0:
			Pais.setCodigoPais(( String)aValue);
			break;
		case 1:
			Pais.setNombrePais((String)aValue);
			break;
		case 2:
			Pais.setNacionalidad((String)aValue);
			break;
		
		default:
			break;
		}
		//actualiza los listeners
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex, rowIndex));
	}
	public void AnadirPais(Pais PaisNuevo)
	{
		if(PaisNuevo != null)
			listaPais.add(PaisNuevo);
		else
			listaPais.add(null);
		
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				getColumnCount() -1, getRowCount() -1, 
				TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
		actualizarListeners(eventoNuevo);
	}
	public Pais eliminarPais(int rowIndex)
	{
		Pais PaisEliminado = listaPais.remove(rowIndex);
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				rowIndex, rowIndex, TableModelEvent.ALL_COLUMNS, 
				TableModelEvent.DELETE);
		actualizarListeners(eventoNuevo);
		return PaisEliminado;
	}
	
	public Pais obtenerPais(int rowIndex)
	{
		if(rowIndex >= 0)
			try {
				return listaPais.get(rowIndex);
			} catch (Exception e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				return null;
			}
		else 
			return null;
	}
	public void setPais(int rowIndex, Pais PaisNuevo)
	{
		if(rowIndex >= 0)
		{
			listaPais.set(rowIndex, PaisNuevo);
		}
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex));
	}
	
	public void setListPais(List<Pais> lista)
	{		
		listaPais.clear();
		if(lista != null)
			listaPais.addAll(lista);
		actualizarListeners(new TableModelEvent(this, 0, getRowCount(), TableModelEvent.ALL_COLUMNS, 
				TableModelEvent.INSERT));
	}
	
	

}
