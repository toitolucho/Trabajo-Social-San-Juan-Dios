package org.quarkbit.trabajosocialsanjuan.formularios.tablemodels;


import java.util.LinkedList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.quarkbit.trabajosocialsanjuan.dao.domain.Provincia;


public class ModeloProvincias implements TableModel{
	private LinkedList<Provincia> listaProvincia = new LinkedList<Provincia>();


	public LinkedList<Provincia> getListaProvincia() {
		return listaProvincia;
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
			return "Provincia";
		case 2 :
			return "Departamento";
		default:
			return "";
		}
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listaProvincia.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return listaProvincia.get(rowIndex).getCodigoProvincia();
		case 1:
			return listaProvincia.get(rowIndex).getNombreProvincia();
		case 2:
			return listaProvincia.get(rowIndex).getDepartamento() != null ?
					listaProvincia.get(rowIndex).getDepartamento().getNombreDepartamento() :"";	
		

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
		Provincia Provincia = listaProvincia.get(rowIndex);
		switch (columnIndex) {
		case 0:
			Provincia.setCodigoProvincia(( String)aValue);
			break;
		case 1:
			Provincia.setNombreProvincia((String)aValue);
			break;
		
		default:
			break;
		}
		//actualiza los listeners
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex, rowIndex));
	}
	public void AnadirProvincia(Provincia ProvinciaNuevo)
	{
		if(ProvinciaNuevo != null)
			listaProvincia.add(ProvinciaNuevo);
		else
			listaProvincia.add(null);
		
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				getColumnCount() -1, getRowCount() -1, 
				TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
		actualizarListeners(eventoNuevo);
	}
	public Provincia eliminarProvincia(int rowIndex)
	{
		Provincia ProvinciaEliminado = listaProvincia.remove(rowIndex);
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				rowIndex, rowIndex, TableModelEvent.ALL_COLUMNS, 
				TableModelEvent.DELETE);
		actualizarListeners(eventoNuevo);
		return ProvinciaEliminado;
	}
	
	public Provincia obtenerProvincia(int rowIndex)
	{
		if(rowIndex >= 0)
			try {
				return listaProvincia.get(rowIndex);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				return null;
			}
		else 
			return null;
	}
	public void setProvincia(int rowIndex, Provincia ProvinciaNuevo)
	{
		if(rowIndex >= 0)
		{
			listaProvincia.set(rowIndex, ProvinciaNuevo);
		}
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex));
	}
	
	public void setListProvincia(List<Provincia> lista)
	{		
		
		listaProvincia.clear();
		if(lista != null)
			listaProvincia.addAll(lista);
		actualizarListeners(new TableModelEvent(this, 0, getRowCount(), TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT));
	}

}
