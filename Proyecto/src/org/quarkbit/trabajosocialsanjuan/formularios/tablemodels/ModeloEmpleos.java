package org.quarkbit.trabajosocialsanjuan.formularios.tablemodels;


import java.util.LinkedList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.quarkbit.trabajosocialsanjuan.dao.domain.Empleo;


public class ModeloEmpleos implements TableModel{
	private LinkedList<Empleo> listaEmpleo = new LinkedList<Empleo>();


	public LinkedList<Empleo> getListaEmpleo() {
		return listaEmpleo;
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
			return "Empleo";

		default:
			return "";
		}
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listaEmpleo.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return listaEmpleo.get(rowIndex).getCodigoEmpleo();
		case 1:
			return listaEmpleo.get(rowIndex).getNombreEmpleo();
		

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
		Empleo Empleo = listaEmpleo.get(rowIndex);
		switch (columnIndex) {
		case 0:
			Empleo.setCodigoEmpleo(( Integer)aValue);
			break;
		case 1:
			Empleo.setNombreEmpleo((String)aValue);
			break;
		
		default:
			break;
		}
		//actualiza los listeners
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex, rowIndex));
	}
	public void AnadirEmpleo(Empleo EmpleoNuevo)
	{
		if(EmpleoNuevo != null)
			listaEmpleo.add(EmpleoNuevo);
		else
			listaEmpleo.add(null);
		
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				getColumnCount() -1, getRowCount() -1, 
				TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
		actualizarListeners(eventoNuevo);
	}
	public Empleo eliminarEmpleo(int rowIndex)
	{
		Empleo EmpleoEliminado = listaEmpleo.remove(rowIndex);
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				rowIndex, rowIndex, TableModelEvent.ALL_COLUMNS, 
				TableModelEvent.DELETE);
		actualizarListeners(eventoNuevo);
		return EmpleoEliminado;
	}
	
	public Empleo obtenerEmpleo(int rowIndex)
	{
		if(rowIndex >= 0)
			try {
				return listaEmpleo.get(rowIndex);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				return null;
			}
		else 
			return null;
	}
	public void setEmpleo(int rowIndex, Empleo EmpleoNuevo)
	{
		if(rowIndex >= 0)
		{
			listaEmpleo.set(rowIndex, EmpleoNuevo);
		}
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex));
	}
	
	public void setListEmpleo(List<Empleo> lista)
	{		
		listaEmpleo.addAll(lista);
		
	}

}
