package org.quarkbit.trabajosocialsanjuan.formularios.tablemodels;


import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.quarkbit.trabajosocialsanjuan.dao.domain.Consulta;
import org.quarkbit.trabajosocialsanjuan.utils.FormUtilities;


public class ModeloConsultas implements TableModel{
	private LinkedList<Consulta> listaConsulta = new LinkedList<Consulta>();


	public LinkedList<Consulta> getListaConsulta() {
		return listaConsulta;
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
			return Integer.class; //Nro Historial Clinico			
		case 1 :
			return String.class;  //Persona
		case 2:
			return String.class; // Fecha Registro
		case 3:
			return String.class; // Motivo
		case 4:
			return String.class; // Diagnostico
		case 5:
			return String.class; // Observaciones
		default:
			return Object.class;
		}
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return "Nº Hist. Clinico";			
		case 1 :
			return "Niño";
		case 2 :
			return "Fecha";
		case 3 :
			return "Motivo";
		case 4 :
			return "Diagnostico";
		case 5 :
			return "Observaciones";

		default:
			return "";
		}
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listaConsulta.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return listaConsulta.get(rowIndex).getNumeroHistorialClinico();
		case 1:
			return listaConsulta.get(rowIndex).getPersona() != null ?
					listaConsulta.get(rowIndex).getPersona().obtenerNombreCompleto() : "";
		case 2:
			return FormUtilities.formatearDate(listaConsulta.get(rowIndex).getFechaConsulta());
		case 3:
			return listaConsulta.get(rowIndex).getMotivo();
		case 4:
			return listaConsulta.get(rowIndex).getDiagnostico();
		case 5:
			return listaConsulta.get(rowIndex).getObservaciones();

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
		Consulta consulta = listaConsulta.get(rowIndex);
		switch (columnIndex) {
		case 0:
			consulta.setNumeroHistorialClinico(( Integer)aValue);
			break;
		case 1:
//			Consulta.setNombreConsulta((String)aValue);
			break;
		case 2:
			consulta.setFechaConsulta((Date) aValue);
		case 3:
			consulta.setMotivo((String)aValue);
		case 4:
			consulta.setDiagnostico((String)aValue);
		case 5:
			consulta.setObservaciones((String)aValue);
		default:
			break;
		}
		//actualiza los listeners
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex, rowIndex));
	}
	public void AnadirConsulta(Consulta ConsultaNuevo)
	{
		if(ConsultaNuevo != null)
			listaConsulta.add(ConsultaNuevo);
		else
			listaConsulta.add(null);
		
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				getColumnCount() -1, getRowCount() -1, 
				TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
		actualizarListeners(eventoNuevo);
	}
	public Consulta eliminarConsulta(int rowIndex)
	{
		Consulta ConsultaEliminado = listaConsulta.remove(rowIndex);
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				rowIndex, rowIndex, TableModelEvent.ALL_COLUMNS, 
				TableModelEvent.DELETE);
		actualizarListeners(eventoNuevo);
		return ConsultaEliminado;
	}
	
	public Consulta obtenerConsulta(int rowIndex)
	{
		if(rowIndex >= 0)
			try {
				return listaConsulta.get(rowIndex);
			} catch (Exception e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				return null;
			}
		else 
			return null;
	}
	public void setConsulta(int rowIndex, Consulta ConsultaNuevo)
	{
		if(rowIndex >= 0)
		{
			listaConsulta.set(rowIndex, ConsultaNuevo);
		}
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex));
	}
	
	public void setListConsulta(List<Consulta> lista)
	{		
		listaConsulta.clear();
		listaConsulta.addAll(lista);
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				0, getRowCount(), TableModelEvent.ALL_COLUMNS, 
				TableModelEvent.INSERT);
		actualizarListeners(eventoNuevo);
		
	}



	public void limpiar()
	{
		this.listaConsulta.clear();
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				0, getRowCount(), TableModelEvent.ALL_COLUMNS, 
				TableModelEvent.DELETE);
		actualizarListeners(eventoNuevo);
	}

}
