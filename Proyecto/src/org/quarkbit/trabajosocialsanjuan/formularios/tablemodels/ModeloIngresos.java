package org.quarkbit.trabajosocialsanjuan.formularios.tablemodels;


import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.quarkbit.trabajosocialsanjuan.dao.domain.Ingreso;
import org.quarkbit.trabajosocialsanjuan.dao.domain.IngresoTipo;


public class ModeloIngresos implements TableModel{
	private LinkedList<Ingreso> listaIngreso = new LinkedList<Ingreso>();


	public LinkedList<Ingreso> getListaIngreso() {
		return listaIngreso;
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
			return String.class; //	Nombre 		
		case 1 :
			return Date.class; // fecha ingreso
		case 2:
			return Double.class; // monto ingreso
		case 3:
			return Double.class;// saldo
		case 4 :
			return String.class; // Tipo Ingreso
		
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
			return "Nombre";			
		case 1 :
			return "Fecha";
		case 2 :
			return "Monto";
		case 3 :
			return "Saldo";
		case 4 :
			return "Tipo";
		default:
			return "";
		}
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listaIngreso.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return listaIngreso.get(rowIndex).getNombreIngreso();
		case 1:
			return listaIngreso.get(rowIndex).getFechaIngreso();
		case 2:
			return listaIngreso.get(rowIndex).getMontoIngreso();
		case 3:
			return listaIngreso.get(rowIndex).getMontoActual();
		case 4:
			return listaIngreso.get(rowIndex).getIngresoTipo() != null ? listaIngreso.get(rowIndex).getIngresoTipo().getNombreIngresoTipo() : "";
		

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
		Ingreso Ingreso = listaIngreso.get(rowIndex);
		switch (columnIndex) {
		case 0:
			Ingreso.setNombreIngreso((String) aValue);
			break;
		case 1:
			Ingreso.setFechaIngreso(( Date)aValue);
			
			break;
		case 2:
			Ingreso.setMontoIngreso((Double)aValue);
			break;
		case 3:
			Ingreso.setMontoActual((Double)aValue);
			break;
		case 4:
			Ingreso.setIngresoTipo(( IngresoTipo)aValue);
			break;
		
		default:
			break;
		}
		//actualiza los listeners
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex, rowIndex));
	}
	public void AnadirIngreso(Ingreso IngresoNuevo)
	{
		if(IngresoNuevo != null)
			listaIngreso.add(IngresoNuevo);
		else
			listaIngreso.add(null);
		
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				getColumnCount() -1, getRowCount() -1, 
				TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
		actualizarListeners(eventoNuevo);
	}
	public Ingreso eliminarIngreso(int rowIndex)
	{
		Ingreso IngresoEliminado = listaIngreso.remove(rowIndex);
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				rowIndex, rowIndex, TableModelEvent.ALL_COLUMNS, 
				TableModelEvent.DELETE);
		actualizarListeners(eventoNuevo);
		return IngresoEliminado;
	}
	
	public Ingreso obtenerIngreso(int rowIndex)
	{
		if(rowIndex >= 0)
			return listaIngreso.get(rowIndex);
		else 
			return null;
	}
	public void setIngreso(int rowIndex, Ingreso IngresoNuevo)
	{
		if(rowIndex >= 0)
		{
			listaIngreso.set(rowIndex, IngresoNuevo);
		}
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex));
	}
	
	public void setListIngreso(List<Ingreso> lista)
	{
		listaIngreso.clear();
		listaIngreso.addAll(lista);
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				0, getRowCount(), TableModelEvent.ALL_COLUMNS, 
				TableModelEvent.INSERT);
		actualizarListeners(eventoNuevo);
	}
	
	public double obtenerMontoIngresoTotal()
	{
		double suma  = 0;
		for (Ingreso ingreso : listaIngreso) {
			suma += ingreso.getMontoIngreso();
		}
		return suma;
	}
	public double obtenerSaldoIngresoTotal()
	{
		double suma  = 0;
		for (Ingreso ingreso : listaIngreso) {
			suma += ingreso.getMontoActual();
		}
		return suma;
	}
}
