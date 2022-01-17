package org.quarkbit.trabajosocialsanjuan.formularios.tablemodels;


import java.util.LinkedList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.quarkbit.trabajosocialsanjuan.dao.domain.Lugar;


public class ModeloLugares implements TableModel{
	private LinkedList<Lugar> listaLugar = new LinkedList<Lugar>();


	public LinkedList<Lugar> getListaLugar() {
		return listaLugar;
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
		case 3 :
			return String.class;
		case 4 :
			return String.class;
		case 5 :
			return String.class;
		default:
			return Object.class;
		}
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return "Codigo";			
		case 1 :
			return "Lugar";
		case 2 :
			return "Provincia";
		case 3 :
			return "Departamento";
		case 4 :
			return "Pais";
		default:
			return "";
		}
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listaLugar.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return listaLugar.get(rowIndex).getCodigoLugar();
		case 1:
			return listaLugar.get(rowIndex).getNombreLugar();
		case 2:
			return listaLugar.get(rowIndex).getProvincia() != null ?
				listaLugar.get(rowIndex).getProvincia().getNombreProvincia() :"" ;
		case 3:
			return  (listaLugar.get(rowIndex).getProvincia() != null && listaLugar.get(rowIndex).getProvincia().getDepartamento() != null) ?
					listaLugar.get(rowIndex).getProvincia().getDepartamento() .getNombreDepartamento() : "";
		case 4:
			return (listaLugar.get(rowIndex).getProvincia() != null && 
					listaLugar.get(rowIndex).getProvincia().getDepartamento() != null && 
					listaLugar.get(rowIndex).getProvincia().getDepartamento().getPais() != null) ?
					listaLugar.get(rowIndex).getProvincia().getDepartamento().getPais().getNombrePais() : "";

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
		Lugar Lugar = listaLugar.get(rowIndex);
		switch (columnIndex) {
		case 0:
			Lugar.setCodigoLugar(( String)aValue);
			break;
		case 1:
			Lugar.setNombreLugar((String)aValue);
			break;
		
		default:
			break;
		}
		//actualiza los listeners
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex, rowIndex));
	}
	public void AnadirLugar(Lugar LugarNuevo)
	{
		if(LugarNuevo != null)
			listaLugar.add(LugarNuevo);
		else
			listaLugar.add(null);
		
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				getColumnCount() -1, getRowCount() -1, 
				TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
		actualizarListeners(eventoNuevo);
	}
	public Lugar eliminarLugar(int rowIndex)
	{
		Lugar LugarEliminado = listaLugar.remove(rowIndex);
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				rowIndex, rowIndex, TableModelEvent.ALL_COLUMNS, 
				TableModelEvent.DELETE);
		actualizarListeners(eventoNuevo);
		return LugarEliminado;
	}
	
	public Lugar obtenerLugar(int rowIndex)
	{
		if(rowIndex >= 0)
			try {
				return listaLugar.get(rowIndex);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				return null;
			}
		else 
			return null;
	}
	public void setLugar(int rowIndex, Lugar LugarNuevo)
	{
		if(rowIndex >= 0)
		{
			listaLugar.set(rowIndex, LugarNuevo);
		}
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex));
	}
	
	public void setListLugar(List<Lugar> lista)
	{		
		
		listaLugar.clear();
		if(lista != null)
			listaLugar.addAll(lista);
		actualizarListeners(new TableModelEvent(this, 0, getRowCount(), TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT));
	}

}
