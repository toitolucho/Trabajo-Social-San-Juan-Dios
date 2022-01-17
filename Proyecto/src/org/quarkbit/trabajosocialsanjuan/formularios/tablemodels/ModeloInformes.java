package org.quarkbit.trabajosocialsanjuan.formularios.tablemodels;


import java.text.DateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.quarkbit.trabajosocialsanjuan.dao.domain.Informe;


public class ModeloInformes implements TableModel{
	
	
	private LinkedList<Informe> listaInforme = new LinkedList<Informe>();


	public LinkedList<Informe> getListaInforme() {
		return listaInforme;
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
			return Integer.class;//codigo			
		case 1 :
			return String.class;//ref caso
		case 2 :
			return String.class;//fecha
		case 3 :
			return String.class;// nino
		case 4 :
			return String.class;// dirigido a
		case 5 :
			return String.class;// via
		case 6 :
			return String.class;// de (remitente)
		
		default:
			return String.class;
		}
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return "Codigo";			
		case 1 :
			return "Ref. Caso";
		case 2 :
			return "Fecha";
		case 3 :
			return "Niño";
		case 4 :
			return "Dirigido a";
		case 5 :
			return "Via";
		case 6 :
			return "Remitente";
		

		default:
			return "";
		}
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listaInforme.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return listaInforme.get(rowIndex).getCodigoInforme();
		case 1:
			return listaInforme.get(rowIndex).getReferencia();
		case 2:
			return listaInforme.get(rowIndex).getFechaEnvio();
		case 3:
			return listaInforme.get(rowIndex).getNino().obtenerNombreCompleto();
		case 4:
			return listaInforme.get(rowIndex).getPersonaA() != null ?
					listaInforme.get(rowIndex).getPersonaA().obtenerNombreCompleto() : "";
		case 5:
			return listaInforme.get(rowIndex).getPersonaVia() != null ?
					listaInforme.get(rowIndex).getPersonaVia().obtenerNombreCompleto() : "";
		case 6:
			return listaInforme.get(rowIndex).getPersonaDe1() != null ?
					listaInforme.get(rowIndex).getPersonaDe1().obtenerNombreCompleto() : "";
		

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
		Informe Informe = listaInforme.get(rowIndex);
		switch (columnIndex) {
		case 0:
			Informe.setCodigoInforme(( Integer)aValue);
			break;
		case 1:
			Informe.setReferencia((String)aValue);
		case 2:
			Informe.setFechaEnvio((Date)aValue);
			break;
		
		default:
			break;
		}
		//actualiza los listeners
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex, rowIndex));
	}
	public void AnadirInforme(Informe InformeNuevo)
	{
		if(InformeNuevo != null)
			listaInforme.add(InformeNuevo);
		else
			listaInforme.add(null);
		
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				getColumnCount() -1, getRowCount() -1, 
				TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
		actualizarListeners(eventoNuevo);
	}
	public Informe eliminarInforme(int rowIndex)
	{
		Informe InformeEliminado = listaInforme.remove(rowIndex);
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				rowIndex, rowIndex, TableModelEvent.ALL_COLUMNS, 
				TableModelEvent.DELETE);
		actualizarListeners(eventoNuevo);
		return InformeEliminado;
	}
	
	public Informe obtenerInforme(int rowIndex)
	{
		if(rowIndex >= 0)
			try {
				return listaInforme.get(rowIndex);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				return null;
			}
		else 
			return null;
	}
	public void setInforme(int rowIndex, Informe InformeNuevo)
	{
		if(rowIndex >= 0)
		{
			listaInforme.set(rowIndex, InformeNuevo);
		}
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex));
	}
	
	public void setListInforme(List<Informe> lista)
	{	
		listaInforme.clear();
		listaInforme.addAll(lista);
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				0, lista.size(), TableModelEvent.ALL_COLUMNS, 
				TableModelEvent.INSERT);
		actualizarListeners(eventoNuevo);
	}

}
