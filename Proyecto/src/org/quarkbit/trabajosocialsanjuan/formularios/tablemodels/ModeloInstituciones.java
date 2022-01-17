package org.quarkbit.trabajosocialsanjuan.formularios.tablemodels;


import java.util.LinkedList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.quarkbit.trabajosocialsanjuan.dao.domain.Institucion;


public class ModeloInstituciones implements TableModel{
	private LinkedList<Institucion> listaInstitucion = new LinkedList<Institucion>();


	public LinkedList<Institucion> getListaInstitucion() {
		return listaInstitucion;
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
			return "Institucion";

		default:
			return "";
		}
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listaInstitucion.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return listaInstitucion.get(rowIndex).getCodigoInstitucion();
		case 1:
			return listaInstitucion.get(rowIndex).getNombreInstitucion();
		

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
		Institucion Institucion = listaInstitucion.get(rowIndex);
		switch (columnIndex) {
		case 0:
			Institucion.setCodigoInstitucion(( Integer)aValue);
			break;
		case 1:
			Institucion.setNombreInstitucion((String)aValue);
			break;
		
		default:
			break;
		}
		//actualiza los listeners
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex, rowIndex));
	}
	public void AnadirInstitucion(Institucion InstitucionNuevo)
	{
		if(InstitucionNuevo != null)
			listaInstitucion.add(InstitucionNuevo);
		else
			listaInstitucion.add(null);
		
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				getColumnCount() -1, getRowCount() -1, 
				TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
		actualizarListeners(eventoNuevo);
	}
	public Institucion eliminarInstitucion(int rowIndex)
	{
		Institucion InstitucionEliminado = listaInstitucion.remove(rowIndex);
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				rowIndex, rowIndex, TableModelEvent.ALL_COLUMNS, 
				TableModelEvent.DELETE);
		actualizarListeners(eventoNuevo);
		return InstitucionEliminado;
	}
	
	public Institucion obtenerInstitucion(int rowIndex)
	{
		if(rowIndex >= 0)
			return listaInstitucion.get(rowIndex);
		else 
			return null;
	}
	public void setInstitucion(int rowIndex, Institucion InstitucionNuevo)
	{
		if(rowIndex >= 0)
		{
			listaInstitucion.set(rowIndex, InstitucionNuevo);
		}
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex));
	}
	
	public void setListInstitucion(List<Institucion> lista)
	{		
		listaInstitucion.addAll(lista);
		
	}

}
