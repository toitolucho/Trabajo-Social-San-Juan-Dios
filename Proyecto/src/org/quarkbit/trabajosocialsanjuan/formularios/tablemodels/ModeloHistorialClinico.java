package org.quarkbit.trabajosocialsanjuan.formularios.tablemodels;


import java.util.LinkedList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.quarkbit.trabajosocialsanjuan.dao.domain.HistorialClinico;;


public class ModeloHistorialClinico implements TableModel{
	private LinkedList<HistorialClinico> listaHistorialClinico = new LinkedList<HistorialClinico>();


	public LinkedList<HistorialClinico> getListaHistorialClinico() {
		return listaHistorialClinico;
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
			return String.class;
		case 3:
			return String.class;
		
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
			return "Nº Hist. Clinico.";			
		case 1 :
			return "Niño";
		case 2 :
			return "Fecha Reg.";
		case 3 :
			return "Grupo Sanguineo";

		default:
			return "";
		}
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listaHistorialClinico.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return listaHistorialClinico.get(rowIndex).getNumeroHistorialClinico();
		case 1:
			return listaHistorialClinico.get(rowIndex).getPersona().obtenerNombreCompleto();
		case 2:
			return listaHistorialClinico.get(rowIndex).getFecha_registro();
		case 3:
			return listaHistorialClinico.get(rowIndex).getGrupoSanguinio();
		

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
		HistorialClinico HistorialClinico = listaHistorialClinico.get(rowIndex);
		switch (columnIndex) {
		case 0:
			HistorialClinico.setNumeroHistorialClinico(( Integer)aValue);
			break;
		case 1:
//			HistorialClinico.setNombreHistorialClinico((String)aValue);
			break;
		
		default:
			break;
		}
		//actualiza los listeners
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex, rowIndex));
	}
	public void AnadirHistorialClinico(HistorialClinico HistorialClinicoNuevo)
	{
		if(HistorialClinicoNuevo != null)
			listaHistorialClinico.add(HistorialClinicoNuevo);
		else
			listaHistorialClinico.add(null);
		
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				getColumnCount() -1, getRowCount() -1, 
				TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
		actualizarListeners(eventoNuevo);
	}
	public HistorialClinico eliminarHistorialClinico(int rowIndex)
	{
		HistorialClinico HistorialClinicoEliminado = listaHistorialClinico.remove(rowIndex);
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				rowIndex, rowIndex, TableModelEvent.ALL_COLUMNS, 
				TableModelEvent.DELETE);
		actualizarListeners(eventoNuevo);
		return HistorialClinicoEliminado;
	}
	
	public HistorialClinico obtenerHistorialClinico(int rowIndex)
	{
		if(rowIndex >= 0)
			try {
				return listaHistorialClinico.get(rowIndex);
			} catch (Exception e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				return null;
			}
		else 
			return null;
	}
	public void setHistorialClinico(int rowIndex, HistorialClinico HistorialClinicoNuevo)
	{
		if(rowIndex >= 0)
		{
			listaHistorialClinico.set(rowIndex, HistorialClinicoNuevo);
		}
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex));
	}
	
	public void setListHistorialClinico(List<HistorialClinico> lista)
	{		
		listaHistorialClinico.clear();
		listaHistorialClinico.addAll(lista);
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				0, getRowCount(), TableModelEvent.ALL_COLUMNS, 
				TableModelEvent.INSERT);
		actualizarListeners(eventoNuevo);
	}

}
