package org.quarkbit.trabajosocialsanjuan.formularios.tablemodels;


import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.quarkbit.trabajosocialsanjuan.dao.domain.Persona;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PersonaKardexFamiliar;



public class ModeloFamiliares implements TableModel{
	protected LinkedList<PersonaKardexFamiliar> listaPersonaKardexFamiliar = new LinkedList<PersonaKardexFamiliar>();


	public LinkedList<PersonaKardexFamiliar> getListaPersonaKardexFamiliar() {
		return listaPersonaKardexFamiliar;
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
			return Date.class;
		case 3 :
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
			return "Familiar";			
		case 1 :
			return "Parentesco";
		case 2 :
			return "Fecha Ing.";
		case 3 :
			return "Observaciones";

		default:
			return "";
		}
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listaPersonaKardexFamiliar.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return listaPersonaKardexFamiliar.get(rowIndex).getPersona().obtenerNombreCompleto();
		case 1:
			return listaPersonaKardexFamiliar.get(rowIndex).getParentesco();
		case 2:
			return listaPersonaKardexFamiliar.get(rowIndex).getFechaRegistro();
		case 3:
			return listaPersonaKardexFamiliar.get(rowIndex).getObservaciones();	
		
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
		PersonaKardexFamiliar PersonaKardexFamiliar = listaPersonaKardexFamiliar.get(rowIndex);
		switch (columnIndex) {
		case 2:
			PersonaKardexFamiliar.setFechaRegistro(( Date)aValue);
			break;
		case 3:
			PersonaKardexFamiliar.setObservaciones((String)aValue);
			break;
		
		default:
			break;
		}
		//actualiza los listeners
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex, rowIndex));
	}
	public void AnadirPersonaKardexFamiliar(PersonaKardexFamiliar PersonaKardexFamiliarNuevo)
	{
		if(PersonaKardexFamiliarNuevo != null)
			listaPersonaKardexFamiliar.add(PersonaKardexFamiliarNuevo);
		else
			listaPersonaKardexFamiliar.add(null);
		
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				getColumnCount() -1, getRowCount() -1, 
				TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
		actualizarListeners(eventoNuevo);
	}
	public PersonaKardexFamiliar eliminarPersonaKardexFamiliar(int rowIndex)
	{
		PersonaKardexFamiliar PersonaKardexFamiliarEliminado = listaPersonaKardexFamiliar.remove(rowIndex);
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				rowIndex, rowIndex, TableModelEvent.ALL_COLUMNS, 
				TableModelEvent.DELETE);
		actualizarListeners(eventoNuevo);
		return PersonaKardexFamiliarEliminado;
	}
	
	public PersonaKardexFamiliar obtenerPersonaKardexFamiliar(int rowIndex)
	{
		if(rowIndex >= 0)
			return listaPersonaKardexFamiliar.get(rowIndex);
		else 
			return null;
	}
	public void setPersonaKardexFamiliar(int rowIndex, PersonaKardexFamiliar PersonaKardexFamiliarNuevo)
	{
		if(rowIndex >= 0)
		{
			listaPersonaKardexFamiliar.set(rowIndex, PersonaKardexFamiliarNuevo);
		}
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex));
	}
	
	public void setListPersonaKardexFamiliar(List<PersonaKardexFamiliar> lista)
	{	
		listaPersonaKardexFamiliar.clear();
		listaPersonaKardexFamiliar.addAll(lista);
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				0, getRowCount(), TableModelEvent.ALL_COLUMNS, 
				TableModelEvent.INSERT);
		actualizarListeners(eventoNuevo);
		
	}
	
	public void clear()
	{
		listaPersonaKardexFamiliar.clear();
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				0, getRowCount(), TableModelEvent.ALL_COLUMNS, 
				TableModelEvent.DELETE);
		actualizarListeners(eventoNuevo);
	}
	
	public boolean existe(PersonaKardexFamiliar personaFamiliar)
	{
		Collections.sort(listaPersonaKardexFamiliar);
		return Collections.binarySearch(listaPersonaKardexFamiliar, personaFamiliar) >= 0;
	}



}
