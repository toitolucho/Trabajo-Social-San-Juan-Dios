package org.quarkbit.trabajosocialsanjuan.formularios.tablemodels;


import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.quarkbit.trabajosocialsanjuan.dao.domain.Egreso;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Ingreso;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Partida;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Proveedor;


public class ModeloEgresos implements TableModel{
	private LinkedList<Egreso> listaEgreso = new LinkedList<Egreso>();


	public LinkedList<Egreso> getListaEgreso() {
		return listaEgreso;
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
			return Date.class;	 //Fecha		
		case 1 :
			return String.class; //Partida
		case 2:
			return String.class; //Nro Factura
		case 3:
			return String.class; //Proveedor
		case 4:
			return Double.class; //Monto
		
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
			return "Fecha";			
		case 1 :
			return "Partida";
		case 2:
			return "Nro Factura";			
		case 3 :
			return "Proveedor";
		case 4:
			return "Monto";
		default:
			return "";
		}
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listaEgreso.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return listaEgreso.get(rowIndex).getFechaEgreso();
		case 1:
			return listaEgreso.get(rowIndex).getPartida();
		case 2:
			return listaEgreso.get(rowIndex).getNroFactura();
		case 3:
			return listaEgreso.get(rowIndex).getProveedor();
		case 4:
			return listaEgreso.get(rowIndex).getMontoSalida();
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
		Egreso Egreso = listaEgreso.get(rowIndex);
		switch (columnIndex) {
		case 0:
			Egreso.setCodigoEgreso(( Integer)aValue);
			break;
		case 1:
			Egreso.setPartida((Partida) aValue);
			break;
		case 2:
			Egreso.setNroFactura((Integer) aValue);
			break;
		case 3:
			Egreso.setProveedor((Proveedor) aValue);
			break;
		case 4:
			Egreso.setMontoSalida((Double) aValue );
			break;
			
		default:
			break;
		}
		//actualiza los listeners
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex, rowIndex));
	}
	public void AnadirEgreso(Egreso EgresoNuevo)
	{
		if(EgresoNuevo != null)
			listaEgreso.add(EgresoNuevo);
		else
			listaEgreso.add(null);
		
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				getColumnCount() -1, getRowCount() -1, 
				TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
		actualizarListeners(eventoNuevo);
	}
	public Egreso eliminarEgreso(int rowIndex)
	{
		Egreso EgresoEliminado = listaEgreso.remove(rowIndex);
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				rowIndex, rowIndex, TableModelEvent.ALL_COLUMNS, 
				TableModelEvent.DELETE);
		actualizarListeners(eventoNuevo);
		return EgresoEliminado;
	}
	
	public Egreso obtenerEgreso(int rowIndex)
	{
		if(rowIndex >= 0)
			return listaEgreso.get(rowIndex);
		else 
			return null;
	}
	public void setEgreso(int rowIndex, Egreso EgresoNuevo)
	{
		if(rowIndex >= 0)
		{
			listaEgreso.set(rowIndex, EgresoNuevo);
		}
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex));
	}
	
	public void setListEgreso(List<Egreso> lista)
	{		
		listaEgreso.clear();
		listaEgreso.addAll(lista);
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				0, getRowCount(), TableModelEvent.ALL_COLUMNS, 
				TableModelEvent.INSERT);
		actualizarListeners(eventoNuevo);
		
	}


	public double obtenerMontoEgresoTotal()
	{
		double suma  = 0;
		for (Egreso ingreso : listaEgreso) {
			suma += ingreso.getMontoSalida();
		}
		System.out.println(suma);
		return suma;
	}
//	public double obtenerSaldoEgresoTotal()
//	{
//		double suma  = 0;
//		for (Egreso ingreso : listaEgreso) {
//			suma += ingreso.getMontoSalida();
//		}
//		return suma;
//	}

}
