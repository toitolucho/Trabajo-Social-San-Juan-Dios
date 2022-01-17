package org.quarkbit.trabajosocialsanjuan.formularios.tablemodels;


import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.quarkbit.trabajosocialsanjuan.dao.domain.InformePsicologico;
import org.quarkbit.trabajosocialsanjuan.utils.FormUtilities;


public class ModeloInformesPsicologico implements TableModel{
	private LinkedList<InformePsicologico> listaInformePsicologico = new LinkedList<InformePsicologico>();


	public LinkedList<InformePsicologico> getListaInformePsicologico() {
		return listaInformePsicologico;
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
			return String.class;//Motivo			
		case 1 :
			return String.class;//fecha
		case 2:
			return String.class;//instrumentos
		case 3:
			return String.class;//Antecedentes
		case 4:
			return String.class;//Diagnostico
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
			return "Motivo";			
		case 1 :
			return "Fecha";
		case 2 :
			return "Instrumentos";
		case 3 :
			return "Antecedentes";
		case 4 :
			return "Diagnostico";
		default:
			return "";
		}
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listaInformePsicologico.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		
		case 0:
			return listaInformePsicologico.get(rowIndex).getMotivoConsulta();
		case 1:
			return FormUtilities.formatearDate(listaInformePsicologico.get(rowIndex).getFechaEvaluacion());
		case 2:
			return listaInformePsicologico.get(rowIndex).getInstrumentos();
		case 3:
			return listaInformePsicologico.get(rowIndex).getAntecedentes();
		case 4:
			return listaInformePsicologico.get(rowIndex).getDiagnostico();
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
		InformePsicologico InformePsicologico = listaInformePsicologico.get(rowIndex);
		switch (columnIndex) {
		case 1:
			InformePsicologico.setMotivoConsulta((String)aValue);
			break;
		case 0:
			InformePsicologico.setFechaEvaluacion((Date)aValue);
			break;
		case 2:
			InformePsicologico.setInstrumentos((String)aValue);
			break;
		case 3:
			InformePsicologico.setAntecedentes((String)aValue);
			break;
		case 4:
			InformePsicologico.setDiagnostico((String)aValue);
			break;
		default:
			break;
		}
		//actualiza los listeners
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex, rowIndex));
	}
	public void AnadirInformePsicologico(InformePsicologico InformePsicologicoNuevo)
	{
		if(InformePsicologicoNuevo != null)
			listaInformePsicologico.add(InformePsicologicoNuevo);
		else
			listaInformePsicologico.add(null);
		
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				getColumnCount() -1, getRowCount() -1, 
				TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
		actualizarListeners(eventoNuevo);
	}
	public InformePsicologico eliminarInformePsicologico(int rowIndex)
	{
		InformePsicologico InformePsicologicoEliminado = listaInformePsicologico.remove(rowIndex);
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				rowIndex, rowIndex, TableModelEvent.ALL_COLUMNS, 
				TableModelEvent.DELETE);
		actualizarListeners(eventoNuevo);
		return InformePsicologicoEliminado;
	}
	
	public InformePsicologico obtenerInformePsicologico(int rowIndex)
	{
		if(rowIndex >= 0)
			try {
				return listaInformePsicologico.get(rowIndex);
			} catch (Exception e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				return null;
			}
		else 
			return null;
	}
	public void setInformePsicologico(int rowIndex, InformePsicologico InformePsicologicoNuevo)
	{
		if(rowIndex >= 0)
		{
			listaInformePsicologico.set(rowIndex, InformePsicologicoNuevo);
		}
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex));
	}
	
	public void setListInformePsicologico(List<InformePsicologico> lista)
	{		
		if(lista != null)
		{
			listaInformePsicologico.clear();
			listaInformePsicologico.addAll(lista);
			TableModelEvent eventoNuevo = new TableModelEvent(this, 
					0, getRowCount(), TableModelEvent.ALL_COLUMNS, 
					TableModelEvent.INSERT);
			actualizarListeners(eventoNuevo);
		}
		
	}



	public void limpiar() {
		listaInformePsicologico.clear();
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				0, getRowCount(), TableModelEvent.ALL_COLUMNS, 
				TableModelEvent.DELETE);
		actualizarListeners(eventoNuevo);
	}

}
