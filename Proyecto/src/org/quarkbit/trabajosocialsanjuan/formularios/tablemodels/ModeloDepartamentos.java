package org.quarkbit.trabajosocialsanjuan.formularios.tablemodels;


import java.util.LinkedList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.quarkbit.trabajosocialsanjuan.dao.domain.Departamento;


public class ModeloDepartamentos implements TableModel{
	private LinkedList<Departamento> listaDepartamento = new LinkedList<Departamento>();


	public LinkedList<Departamento> getListaDepartamento() {
		return listaDepartamento;
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
			return "Codigo";			
		case 1 :
			return "Pais";
		case 2 :
			return "Departamento";
		default:
			return "";
		}
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listaDepartamento.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return listaDepartamento.get(rowIndex).getCodigoDepartamento();
		case 1:
			return listaDepartamento.get(rowIndex).getNombreDepartamento();
		case 2:
			return listaDepartamento.get(rowIndex).getPais() != null ?
					listaDepartamento.get(rowIndex).getPais().getNombrePais() :"";	
		

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
		Departamento Departamento = listaDepartamento.get(rowIndex);
		switch (columnIndex) {
		case 0:
			Departamento.setCodigoDepartamento(( String)aValue);
			break;
		case 1:
			Departamento.setNombreDepartamento((String)aValue);
			break;
		
		default:
			break;
		}
		//actualiza los listeners
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex, rowIndex));
	}
	public void AnadirDepartamento(Departamento DepartamentoNuevo)
	{
		if(DepartamentoNuevo != null)
			listaDepartamento.add(DepartamentoNuevo);
		else
			listaDepartamento.add(null);
		
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				getColumnCount() -1, getRowCount() -1, 
				TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
		actualizarListeners(eventoNuevo);
	}
	public Departamento eliminarDepartamento(int rowIndex)
	{
		Departamento DepartamentoEliminado = listaDepartamento.remove(rowIndex);
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				rowIndex, rowIndex, TableModelEvent.ALL_COLUMNS, 
				TableModelEvent.DELETE);
		actualizarListeners(eventoNuevo);
		return DepartamentoEliminado;
	}
	
	public Departamento obtenerDepartamento(int rowIndex)
	{
		if(rowIndex >= 0)
			try {
				return listaDepartamento.get(rowIndex);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				return null;
			}
		else 
			return null;
	}
	public void setDepartamento(int rowIndex, Departamento DepartamentoNuevo)
	{
		if(rowIndex >= 0)
		{
			listaDepartamento.set(rowIndex, DepartamentoNuevo);
		}
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex));
	}
	
	public void setListDepartamento(List<Departamento> lista)
	{	
		listaDepartamento.clear();
		if(lista != null)
			listaDepartamento.addAll(lista);
		actualizarListeners(new TableModelEvent(this, 0, getRowCount(), TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT));
	}

}
