package org.quarkbit.trabajosocialsanjuan.formularios.tablemodels;


import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.quarkbit.trabajosocialsanjuan.dao.domain.Documento;


public class ModeloDocumentos implements TableModel{
	private LinkedList<Documento> listaDocumento = new LinkedList<Documento>();


	public LinkedList<Documento> getListaDocumento() {
		return listaDocumento;
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
			return "Documento";

		default:
			return "";
		}
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listaDocumento.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return listaDocumento.get(rowIndex).getCodigoDocumento();
		case 1:
			return listaDocumento.get(rowIndex).getNombreDocumento();
		

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
		Documento Documento = listaDocumento.get(rowIndex);
		switch (columnIndex) {
		case 0:
			Documento.setCodigoDocumento(( Integer)aValue);
			break;
		case 1:
			Documento.setNombreDocumento((String)aValue);
			break;
		
		default:
			break;
		}
		//actualiza los listeners
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex, rowIndex));
	}
	public void AnadirDocumento(Documento DocumentoNuevo)
	{
		if(DocumentoNuevo != null)
			listaDocumento.add(DocumentoNuevo);
		else
			listaDocumento.add(null);
		
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				getColumnCount() -1, getRowCount() -1, 
				TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
		actualizarListeners(eventoNuevo);
	}
	public Documento eliminarDocumento(int rowIndex)
	{
		Documento DocumentoEliminado = listaDocumento.remove(rowIndex);
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				rowIndex, rowIndex, TableModelEvent.ALL_COLUMNS, 
				TableModelEvent.DELETE);
		actualizarListeners(eventoNuevo);
		return DocumentoEliminado;
	}
	
	public Documento obtenerDocumento(int rowIndex)
	{
		if(rowIndex >= 0)
			try {
				return listaDocumento.get(rowIndex);
			} catch (Exception e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				return null;
			}
		else 
			return null;
	}
	public void setDocumento(int rowIndex, Documento DocumentoNuevo)
	{
		if(rowIndex >= 0)
		{
			listaDocumento.set(rowIndex, DocumentoNuevo);
		}
		actualizarListeners(new TableModelEvent(this, rowIndex, rowIndex));
	}
	
	public void setListDocumento(List<Documento> lista)
	{		
		listaDocumento.addAll(lista);
		
	}

	public void clear()
	{
		listaDocumento.removeAll(listaDocumento);
		TableModelEvent eventoNuevo = new TableModelEvent(this, 
				0, getRowCount(), TableModelEvent.ALL_COLUMNS, 
				TableModelEvent.DELETE);
		actualizarListeners(eventoNuevo);
	}

	public boolean existe(Documento documentoActual) {
		if(documentoActual != null)
		{
		// TODO Auto-generated method stub
			Collections.sort(listaDocumento);
			System.out.println("Existe " + Collections.binarySearch(listaDocumento, documentoActual));
			return Collections.binarySearch(listaDocumento, documentoActual) >= 0;
		}
		else
		{
			return false;
		
		}
	}

}
