package org.quarkbit.trabajosocialsanjuan.formularios.tablemodels;


import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.quarkbit.trabajosocialsanjuan.dao.domain.HistorialClinicoConsultaDetalle;
import org.quarkbit.trabajosocialsanjuan.utils.FormUtilities;


public class ModeloHCConsultasDetalle implements TableModel{
	private LinkedList<HistorialClinicoConsultaDetalle> listaHistorialClinicoConsultaDetalle = new LinkedList<HistorialClinicoConsultaDetalle>();


	public LinkedList<HistorialClinicoConsultaDetalle> getListaHistorialClinicoConsultaDetalle() {
		return listaHistorialClinicoConsultaDetalle;
	}

	private LinkedList<TableModelListener> listeners = new LinkedList<TableModelListener>();
	@Override
	public void addTableModelListener(TableModelListener evento) {
		listeners.add(evento);
	}
	
	public void limpiar()
	{
		this.listaHistorialClinicoConsultaDetalle.clear();
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				0, getRowCount(), TableModelEvent.ALL_COLUMNS, 
				TableModelEvent.DELETE);
		actualizarListeners(eventoNuevo);
	}


	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return String.class; //Fecha			
		case 1 :
			return String.class;  //propiedad
		case 2:
			return String.class; // descripcion
		
		default:
			return Object.class;
		}
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return "Fecha";			
		case 1 :
			return "Tipo";
		case 2 :
			return "Diagnostico";

		default:
			return "";
		}
	}

	@Override
	public int getRowCount() {
		return listaHistorialClinicoConsultaDetalle.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return FormUtilities.formatearDate(listaHistorialClinicoConsultaDetalle.get(rowIndex).getFechaRegistro());
		case 1:
			return listaHistorialClinicoConsultaDetalle.get(rowIndex).getPropiedadHistorialClinico() != null ?
					listaHistorialClinicoConsultaDetalle.get(rowIndex).getPropiedadHistorialClinico().getNombrePropiedad() : "";
		case 2:
			return listaHistorialClinicoConsultaDetalle.get(rowIndex).getDescripcion();

		default:
			return null;
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
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
		HistorialClinicoConsultaDetalle HistorialClinicoConsultaDetalle = listaHistorialClinicoConsultaDetalle.get(rowIndex);
		switch (columnIndex) {
		case 0:
			HistorialClinicoConsultaDetalle.setNumeroHistorialClinico(( Integer)aValue);
			break;
		case 1:
//			HistorialClinicoConsultaDetalle.setNombreHistorialClinicoConsultaDetalle((String)aValue);
			break;
		case 2:
//			HistorialClinicoConsultaDetalle.setFechaHistorialClinicoConsultaDetalle((Date) aValue);

		default:
			break;
		}
		//actualiza los listeners
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex, rowIndex));
	}
	public void AnadirHistorialClinicoConsultaDetalle(HistorialClinicoConsultaDetalle HistorialClinicoConsultaDetalleNuevo)
	{
		if(HistorialClinicoConsultaDetalleNuevo != null)
			listaHistorialClinicoConsultaDetalle.add(HistorialClinicoConsultaDetalleNuevo);
		else
			listaHistorialClinicoConsultaDetalle.add(null);
		
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				getColumnCount() -1, getRowCount() -1, 
				TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
		actualizarListeners(eventoNuevo);
	}
	public HistorialClinicoConsultaDetalle eliminarHistorialClinicoConsultaDetalle(int rowIndex)
	{
		HistorialClinicoConsultaDetalle HistorialClinicoConsultaDetalleEliminado = listaHistorialClinicoConsultaDetalle.remove(rowIndex);
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				rowIndex, rowIndex, TableModelEvent.ALL_COLUMNS, 
				TableModelEvent.DELETE);
		actualizarListeners(eventoNuevo);
		return HistorialClinicoConsultaDetalleEliminado;
	}
	
	public HistorialClinicoConsultaDetalle obtenerHistorialClinicoConsultaDetalle(int rowIndex)
	{
		if(rowIndex >= 0)
			try {
				return listaHistorialClinicoConsultaDetalle.get(rowIndex);
			} catch (Exception e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				return null;
			}
		else 
			return null;
	}
	public void setHistorialClinicoConsultaDetalle(int rowIndex, HistorialClinicoConsultaDetalle HistorialClinicoConsultaDetalleNuevo)
	{
		if(rowIndex >= 0)
		{
			listaHistorialClinicoConsultaDetalle.set(rowIndex, HistorialClinicoConsultaDetalleNuevo);
		}
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex));
	}
	
	public void setListHistorialClinicoConsultaDetalle(List<HistorialClinicoConsultaDetalle> lista)
	{		
		listaHistorialClinicoConsultaDetalle.clear();
		listaHistorialClinicoConsultaDetalle.addAll(lista);
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				0, getRowCount(), TableModelEvent.ALL_COLUMNS, 
				TableModelEvent.INSERT);
		actualizarListeners(eventoNuevo);
		
	}

}
