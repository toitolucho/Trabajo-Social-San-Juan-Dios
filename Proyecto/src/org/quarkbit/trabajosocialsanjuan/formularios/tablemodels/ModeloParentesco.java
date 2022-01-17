package org.quarkbit.trabajosocialsanjuan.formularios.tablemodels;


import java.util.LinkedList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.quarkbit.trabajosocialsanjuan.dao.domain.Parentesco;


public class ModeloParentesco implements TableModel{
	private LinkedList<Parentesco> listaParentesco = new LinkedList<Parentesco>();


	public LinkedList<Parentesco> getListaParentesco() {
		return listaParentesco;
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
		case 3 :
			return String.class;
		case 4 :
			return Float.class;
		case 5 :
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
			return "Parentesco";

		default:
			return "";
		}
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listaParentesco.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return listaParentesco.get(rowIndex).getCodigoParentesco();
		case 1:
			return listaParentesco.get(rowIndex).getNombreParentesco();
		

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
		Parentesco Parentesco = listaParentesco.get(rowIndex);
		switch (columnIndex) {
		case 0:
			Parentesco.setCodigoParentesco(( Integer)aValue);
			break;
		case 1:
			Parentesco.setNombreParentesco((String)aValue);
			break;
		
		default:
			break;
		}
		//actualiza los listeners
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex, rowIndex));
	}
	public void AnadirParentesco(Parentesco ParentescoNuevo)
	{
		if(ParentescoNuevo != null)
			listaParentesco.add(ParentescoNuevo);
		else
			listaParentesco.add(null);
		
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				getColumnCount() -1, getRowCount() -1, 
				TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
		actualizarListeners(eventoNuevo);
	}
	public Parentesco eliminarParentesco(int rowIndex)
	{
		Parentesco ParentescoEliminado = listaParentesco.remove(rowIndex);
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				rowIndex, rowIndex, TableModelEvent.ALL_COLUMNS, 
				TableModelEvent.DELETE);
		actualizarListeners(eventoNuevo);
		return ParentescoEliminado;
	}
	
	public Parentesco obtenerParentesco(int rowIndex)
	{
		if(rowIndex >= 0)
			return listaParentesco.get(rowIndex);
		else 
			return null;
	}
	public void setParentesco(int rowIndex, Parentesco parentescoNuevo)
	{
		if(rowIndex >= 0)
		{
			listaParentesco.set(rowIndex, parentescoNuevo);
		}
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex));
	}
	
	public void setListParentesco(List<Parentesco> lista)
	{		
		listaParentesco.addAll(lista);
		
	}

}
