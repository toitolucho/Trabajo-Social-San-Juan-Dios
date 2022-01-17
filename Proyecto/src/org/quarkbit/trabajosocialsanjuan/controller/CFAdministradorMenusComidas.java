package org.quarkbit.trabajosocialsanjuan.controller;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.net.URL;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.swing.CellEditor;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import org.apache.ibatis.session.SqlSession;
import org.quarkbit.trabajosocialsanjuan.dao.Coneccion;
import org.quarkbit.trabajosocialsanjuan.dao.domain.CategoriaComida;
import org.quarkbit.trabajosocialsanjuan.dao.domain.CategoriaComidaExample;
import org.quarkbit.trabajosocialsanjuan.dao.domain.MenuComidaDetalle;
import org.quarkbit.trabajosocialsanjuan.dao.domain.MenuComidaDetalleExample;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.CategoriaComidaMapper;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.ComidaMapper;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.MenuComidaMapper;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.MenuComidaDetalleMapper;
import org.quarkbit.trabajosocialsanjuan.formularios.FAdministradorMenusComidas;
import org.quarkbit.trabajosocialsanjuan.formularios.FMenuComidaDetalle;
import org.quarkbit.trabajosocialsanjuan.formularios.FPrincipal;
import org.quarkbit.trabajosocialsanjuan.utils.FormUtilities;
import org.quarkbit.trabajosocialsanjuan.utils.GeneraReport;
import org.quarkbit.trabajosocialsanjuan.utils.HoraTiempo;
import org.quarkbit.trabajosocialsanjuan.utils.PeriodoTiempo;
import org.quarkbit.trabajosocialsanjuan.utils.componentes.JTableHorario;


import datechooser.events.SelectionChangedEvent;
import datechooser.events.SelectionChangedListener;
import datechooser.model.multiple.Period;
import datechooser.model.multiple.PeriodSet;

public class CFAdministradorMenusComidas extends WindowAdapter implements
		ActionListener, KeyListener, ListSelectionListener,
		SelectionChangedListener, MouseListener, DocumentListener,
		FocusListener, TableModelListener {
	

	
	private Color colorReservado = new Color(235, 226, 181);
	private Color colorAlquilado = new Color(232, 174, 174);
	private Color colorPasado = new Color(193, 235, 246);
	private int tiempoToleranciaAnulacion = 6; // en horas
	private int tiempoToleranciaAlquiler = 15; // en minutos
	private int idFormulario = -1;
	double listaMontosPrecios[]  = new double[7];
	double montoAcumuladoMenu = 0;
	double montoTotalAcumuladoMenu = 0;

	SqlSession session;
	CategoriaComidaMapper daoCategoriaComidaMapper;
	ComidaMapper daoComidaMapper;
	MenuComidaMapper daoMenuComidaMapper;
	MenuComidaDetalleMapper daoMenuComidaDetalleMapper;
	
	List<MenuComidaDetalle> listaMenuComidaDetalle;
	List<CategoriaComida> listaCategoriaComida;
	
	

	FAdministradorMenusComidas formAlquilerCampoDeportivo = null;
//	AlquilerCampoDeportivo alquilerCampoDeportivo = null;
//	AlquilerCampoDeportivoDetalle alquilerCampoDeportivoDetalle = null;
	Date fechaHoraServidor = null;
//	ModeloAlquilerCampoDeportivo modeloAlquilerCampoDeportivo = null;
//	ModeloAlquilerCampoDeportivoDetalle modeloAlquilerCampoDeportivoDetalle = null;
//	ModeloCampoDeporitvoHorarioFila modeloCampoDeporitvoHorarioFila;
//	List<AlquilerCampoDeportivo> listaAlquilerCampoDeportivo = null;
//	List<AlquilerCampoDeportivoDetalle> listaAlquilerCampoDeportivoDetalle = null;
//	List<AlquilerCampoDeportivoDetalleHorario> listaAlquilerCampoDeportivoDetalleHorarioSemanal = null;
//	List<ReservaCampoDeportivoDetalleHorario> listaReservaCampoDeportivoDetalleHorarioSemanal = null;
	boolean modoEdicion = false;
	boolean grillaBusquedaSeleccionada = false;
	String rutaLocal;
	Period semanaSeleccionada = null;
	int tiempoPeriodoSeparacion = 60;
	int indice;
	int cantidadCategorias = 0; 
	
	private final String[] diasSemanaHeader= new String[]{"COMIDAS",
			"LUNES","MARTES","MIERCOLES","JUEVES","VIERNES","SABADO","DOMINGO"};
	private int filaInicioSeleccionada;
	private int filaFinSeleccionada;
	
	
	@SuppressWarnings("unchecked")
	public CFAdministradorMenusComidas(FAdministradorMenusComidas formAlquilerCampoDeportivo){
		this.formAlquilerCampoDeportivo = formAlquilerCampoDeportivo;
		
		session = Coneccion.getSqlSessionFactory().openSession();
		daoCategoriaComidaMapper = session.getMapper(CategoriaComidaMapper.class);
		daoComidaMapper = session.getMapper(ComidaMapper.class);
		daoMenuComidaMapper = session.getMapper(MenuComidaMapper.class);
		daoMenuComidaDetalleMapper = session.getMapper(MenuComidaDetalleMapper.class);
		
		cantidadCategorias = daoCategoriaComidaMapper.countByExample(null);
		
		
		this.formAlquilerCampoDeportivo.getJTableHorariosCampos().addFocusListener(this);
		this.formAlquilerCampoDeportivo.getJTableHorariosCampos().getSelectionModel().addListSelectionListener(this);		
		
		//generamos el horario
		crearHorario();
	

		
		rutaLocal = FormUtilities.obtenerRutaLocal();
		
		
		semanaSeleccionada = new Period(Calendar.getInstance());
		Calendar inicio = Calendar.getInstance();
		Calendar fin = Calendar.getInstance();
		
		//domingo = 1, Lunes 2, Martes 3, miercoles 4.. sabado=7  -> Calendar.DAY_OF_WEEK)
		int diaSemana = Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == 1 ? 6 : - 1;
		diaSemana += Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
		
		System.out.println("Dia semana "  + diaSemana);
		//En el componente primer dia es Lunes = 1 Martes = 2......,  Domingo = 7   y ultimo dia domingo
		inicio.add(Calendar.DATE, -diaSemana+1); //
		fin.add(Calendar.DATE, 7-diaSemana);
		
		semanaSeleccionada.setStartDate(inicio);
		semanaSeleccionada.setEndDate(fin);

//		System.out.println(semanaSeleccionada);
		
		formAlquilerCampoDeportivo.getPnlDateChooser().getSelectedPeriodSet().clear();
		formAlquilerCampoDeportivo.getPnlDateChooser().addSelectionChangedListener(this);
		formAlquilerCampoDeportivo.getPnlDateChooser().setSelection(new PeriodSet(semanaSeleccionada));
		semanaSeleccionada = null;
		onSelectionChange(new SelectionChangedEvent(formAlquilerCampoDeportivo.getPnlDateChooser()));
		
//		this.formAlquilerCampoDeportivo.addInternalFrameListener(this);

	}
	
	
	
	@SuppressWarnings("serial")
	public void crearHorario(){
		
		JTableHorario jTableHorario = new JTableHorario( cantidadCategorias,8){
			public boolean isCellEditable(int row,int column){  
			    return false;  
			  }  
		};
		jTableHorario.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		jTableHorario.setRowSelectionAllowed(false);		
		jTableHorario.setColumnSelectionAllowed(false);
		jTableHorario.setCellSelectionEnabled(true);
		
		jTableHorario.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
//		((JTextArea) jTableHorario.getEditorComponent()).setEditable(false);
		
		
		this.formAlquilerCampoDeportivo.setjTableHorariosCampos(jTableHorario);
		for(int i = 0; i< 8; i++)
		{			
			this.formAlquilerCampoDeportivo.getJTableHorariosCampos().getColumnModel().getColumn(i).setHeaderValue(diasSemanaHeader[i]);
		}		

		int filas = 0;
		
		CategoriaComidaExample filtro = new CategoriaComidaExample();
		filtro.or().andEstadoCategoriaEqualTo("A");
		filtro.setOrderByClause("orden_categoria");
		listaCategoriaComida = daoCategoriaComidaMapper.selectByExample(filtro);
		for (CategoriaComida categoria : listaCategoriaComida) {
			
			for(int columnas = 0; columnas<8; columnas++)
			{
				if(columnas == 0)
					this.formAlquilerCampoDeportivo.getJTableHorariosCampos().setValueAt(categoria, filas, columnas);
				else
					this.formAlquilerCampoDeportivo.getJTableHorariosCampos().setValueAt("", filas, columnas);
			}
			jTableHorario.setRowHeight(filas, 45);
			filas++;
		}
		
		
		
		this.formAlquilerCampoDeportivo.getJTableHorariosCampos().addFocusListener(this);
		this.formAlquilerCampoDeportivo.getJTableHorariosCampos().getSelectionModel().addListSelectionListener(this);
		this.formAlquilerCampoDeportivo.getJTableHorariosCampos().addMouseListener(this);
	}
	
	public void limpiarHorario(){		
		for(int horas = 0; horas<cantidadCategorias; horas++)
		{
			for(int columnas = 1; columnas<8; columnas++)
			{				
				this.formAlquilerCampoDeportivo.getJTableHorariosCampos().setValueAt("", horas, columnas);
			}			
		}
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void valueChanged(ListSelectionEvent event) {
		// TODO Auto-generated method stub
		
		
		if (event.getValueIsAdjusting())
			return; 
		ListSelectionModel rowSM = (ListSelectionModel) event.getSource();
		if(this.grillaBusquedaSeleccionada)			
		{
			indice = rowSM.getMinSelectionIndex();
			llenarDatos(indice);
		}
		else
		{
			JTable table = formAlquilerCampoDeportivo.getJTableHorariosCampos();
			if (event.getSource() == table.getSelectionModel()
		              && table.getRowSelectionAllowed()) {
		            int rowIndexStart = table.getSelectedRow();
		            int rowIndexEnd = table.getSelectionModel().getMaxSelectionIndex();
		            
		            filaInicioSeleccionada = rowIndexStart;
		            filaFinSeleccionada = rowIndexEnd;		            
		            
		            if(table.getSelectedColumn() > 0 && filaInicioSeleccionada >=0 && filaFinSeleccionada >= 0)
		            {
//		            	PeriodoTiempo periodoInicio = (PeriodoTiempo) table.getValueAt(filaInicioSeleccionada, 0);
//			            PeriodoTiempo periodoFin = (PeriodoTiempo) table.getValueAt(filaFinSeleccionada, 0);
			            
			            CategoriaComida categoriaSeleccionada =  (CategoriaComida) table.getValueAt(filaInicioSeleccionada, 0);
			            
			            PeriodoTiempo periodoTotal = new PeriodoTiempo(HoraTiempo.toHoraTiempo(categoriaSeleccionada.getHoraInicio()), HoraTiempo.toHoraTiempo(categoriaSeleccionada.getHoraFin()));
			            
			            Period periodoSemana = this.formAlquilerCampoDeportivo.getPnlDateChooser().getSelectedPeriodSet().getFirstPeriod();
			            int diaSemanaSeleccionado = this.formAlquilerCampoDeportivo.getJTableHorariosCampos().getSelectedColumn();
			            Calendar calendarioFecha = Calendar.getInstance();
			            calendarioFecha.setTime(periodoSemana.getStartDate().getTime());
			            calendarioFecha.add(Calendar.DATE, diaSemanaSeleccionado-1); 
			            Date fechaSeleccionada = calendarioFecha.getTime();
			            DateFormat df = new SimpleDateFormat("EEEE dd ' de ' MMMM ' del ' yyyy");		            
			            formAlquilerCampoDeportivo.lblDatosSeleccion.setText(categoriaSeleccionada + " " + periodoTotal + ", " + df.format(fechaSeleccionada).toUpperCase());
//			            System.out.println(formAlquilerCampoDeportivo.lblDatosSeleccion.getText());
		            }
		            else
		            	formAlquilerCampoDeportivo.lblDatosSeleccion.setText("");
		            
		        } else if (event.getSource() == table.getColumnModel().getSelectionModel()
		               && table.getColumnSelectionAllowed() ){
		            
		        }

		        if (event.getValueIsAdjusting()) {
		            // The mouse button has not yet been released
		        	System.out.println("EVENTO DEL BOTON DEL MOUSE CUANDO AUN NO HA SIDO LEVANTADO");
		        }
		}
	}

	@Override
	public void onSelectionChange(SelectionChangedEvent arg0) {
		// TODO Auto-generated method stub
		cargarHorarioSemanal(); 
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(grillaBusquedaSeleccionada)
		{	
	        if(e.getClickCount() == 2)
	        {
	        	formAlquilerCampoDeportivo.getJTabbedPane().setSelectedIndex(0);
	        }
		}
		if(this.formAlquilerCampoDeportivo.getJTableHorariosCampos().isFocusOwner())			
			maybeShowPopup(e);

	}

	@Override
	public void mouseReleased(MouseEvent event) {
		if(this.formAlquilerCampoDeportivo.getJTableHorariosCampos().isFocusOwner() && !grillaBusquedaSeleccionada)			
			maybeShowPopup(event);

	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
//		if(this.formAlquilerCampoDeportivo.getJcheckAutomatico().isSelected() && this.formAlquilerCampoDeportivo.getJtxtTextoBusqueda().getText().length() > 1)
//			buscaAlquilerCampoDeportivo();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
//		if(this.formAlquilerCampoDeportivo.getJcheckAutomatico().isSelected() && this.formAlquilerCampoDeportivo.getJtxtTextoBusqueda().getText().length() > 1)
//			buscaAlquilerCampoDeportivo();
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
//		if (e.getSource() == formAlquilerCampoDeportivo.getJTableBusqueda()) grillaBusquedaSeleccionada = true;
//		if (e.getSource() == formAlquilerCampoDeportivo.getJTableHorariosCampos()) grillaBusquedaSeleccionada = false;
	}

	@Override
	public void focusLost(FocusEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource() == formAlquilerCampoDeportivo.getJTableHorariosCampos()
				&& formAlquilerCampoDeportivo.getJTabbedPane().getSelectedIndex() != 2){
			filaFinSeleccionada = -1;
			filaInicioSeleccionada = -1;
		}
	}
	
	private void maybeShowPopup(MouseEvent e) {
		JTableHorario jTable = this.formAlquilerCampoDeportivo.getJTableHorariosCampos();
		if (e.isPopupTrigger() && jTable.isEnabled()) {
			Point p = new Point(e.getX(), e.getY());
			int col = jTable.columnAtPoint(p);
			int row = jTable.rowAtPoint(p);			
			

			
			if (row >= 0 && row < jTable.getRowCount()) {
				cancelCellEditing();
				
				// create popup menu...				
				JPopupMenu contextMenu = formAlquilerCampoDeportivo.getJPopupMenuHorario();
				if(row<= filaFinSeleccionada && row >= filaInicioSeleccionada && jTable.getSelectedColumn() == col && jTable.getSelectedColumn()!= 0)
				{
					if(sonCeldasSolapadas(jTable, filaInicioSeleccionada, filaFinSeleccionada, jTable.getSelectedColumn())){
						org.quarkbit.trabajosocialsanjuan.utils.FormUtilities.showMessage("Seleccion INVALIDA", "No puede realizar ninguna operacion con las Celdas Seleccionadas", formAlquilerCampoDeportivo);
						jTable.clearSelection();
						return;
					}
					if(isCellOcupada(jTable, filaInicioSeleccionada, filaFinSeleccionada, jTable.getSelectedColumn())){
						
//						if(jTable.getValueAt(jTable.getSelectedRow(), jTable.getSelectedColumn()) instanceof AlquilerCampoDeportivoDetalleHorario)							
//						{							
//							habilitarBotonesPopupMenu(false, true, true, true);							
//						}
//						else if(jTable.getValueAt(jTable.getSelectedRow(), jTable.getSelectedColumn()) instanceof ReservaCampoDeportivoDetalleHorario)
//							habilitarBotonesPopupMenu(false, true, false, false);
					}
					else
					{						
						habilitarBotonesPopupMenu(true, true, false, false);
					}
						
					// ... and show it
					if (contextMenu != null
							&& contextMenu.getComponentCount() > 0) {
						contextMenu.show(jTable, p.x, p.y);
					}
				}

			}
		}
	}
	
	public boolean sonCeldasSolapadas(JTableHorario jtable, int filaInicio, int filaFin, int columna){
		boolean celdaOcupada = false;
		boolean celdaLibre = false;
		for(int i= filaInicio; i<=filaFin; i++ )
		{			
			if(jtable.getValueAt(i, columna) instanceof MenuComidaDetalle)
			{
				celdaOcupada = true;		
			}
			else
				celdaLibre = true;
		}
		return celdaLibre && celdaOcupada;
	}
	
	public boolean isCellOcupada(JTableHorario jtable, int filaInicio, int filaFin, int columna){
		boolean ocupado = false;
		System.out.println( "inicio " + filaInicio + ", fin " + filaFin);
		for(int i= filaInicio; i<=filaFin; i++ )
			if(jtable.getValueAt(i, columna) instanceof MenuComidaDetalle)
			{
				ocupado = true;
				break;
			}
				
		return ocupado;
	}
	
	private void cancelCellEditing() {
		CellEditor ce = this.formAlquilerCampoDeportivo.getJTableHorariosCampos().getCellEditor();
		if (ce != null) {
			ce.cancelCellEditing();
		}
	}
	
	public void habilitarBotonesPopupMenu(boolean reservar, boolean cancelar, boolean anular, boolean verDetalle){		
		this.formAlquilerCampoDeportivo.getJMenuItemAnular().setEnabled(anular);
		this.formAlquilerCampoDeportivo.getJMenuItemCancelar().setEnabled(cancelar);		
		this.formAlquilerCampoDeportivo.getJMenuItemDetalle().setEnabled(verDetalle);
		this.formAlquilerCampoDeportivo.getJMenuItemAlquilar().setEnabled(reservar);
	}
	
	
	@SuppressWarnings("unchecked")
	public void cargarHorarioSemanal(){

			Calendar calendarioInicio = Calendar.getInstance();
			calendarioInicio.clear();			
			Calendar calendarioFin = Calendar.getInstance();
			calendarioFin.clear();
			Calendar fechaSeleccionada = formAlquilerCampoDeportivo.getPnlDateChooser().getSelectedDate();			
			calendarioInicio.setTime(fechaSeleccionada.getTime());
			calendarioFin.setTime(fechaSeleccionada.getTime());
			
			System.out.println("del " + calendarioInicio.getTime() +" al "+ calendarioFin.getTime());
			
			switch (fechaSeleccionada.get(Calendar.DAY_OF_WEEK)) {
			case 1://DOMINGO
				calendarioInicio.add(Calendar.DATE, -6);
				break;
			case 2://LUNES
				calendarioFin.add(Calendar.DATE, 6);
				break;	
			case 3://MARTES
				calendarioInicio.add(Calendar.DATE, -1);
				calendarioFin.add(Calendar.DATE, 5);
				break;
			case 4://MIERCOLES
				calendarioInicio.add(Calendar.DATE, -2);
				calendarioFin.add(Calendar.DATE, 4);
				break;
			case 5://JUEVES
				calendarioInicio.add(Calendar.DATE, -3);
				calendarioFin.add(Calendar.DATE, 3);
				break;
			case 6://VIERNES
				calendarioInicio.add(Calendar.DATE, -4);
				calendarioFin.add(Calendar.DATE, 2);
				break;
			case 7://SABADO
				calendarioInicio.add(Calendar.DATE, -5);
				calendarioFin.add(Calendar.DATE, 1);
				break;
			default:
				break;
			}
			
			formAlquilerCampoDeportivo.getPnlDateChooser().getSelectedPeriodSet().clear();
			Period semana = new Period(calendarioInicio, calendarioFin); 
			PeriodSet semanaSet = new PeriodSet();
			semanaSet.add(semana);
			formAlquilerCampoDeportivo.getPnlDateChooser().setSelection(semanaSet);
			if(semanaSeleccionada != null && semanaSeleccionada.compareTo(semana) == 0)
				System.out.println("es el mismo periodo");
			else{				
				this.semanaSeleccionada = semana;

				
				
				MenuComidaDetalleExample filtro = new MenuComidaDetalleExample();
				filtro.or().andFechaBetween(calendarioInicio.getTime(), calendarioFin.getTime());
				filtro.setOrderByClause("mcd.fecha, cc.orden_categoria");
				listaMenuComidaDetalle = daoMenuComidaDetalleMapper.selectByExample(filtro);
				
				
				montoAcumuladoMenu = 0;
				limpiarHorario();				
				Calendar calendario = Calendar.getInstance();	
				for(int i = 0; i< 7; i++)
				{
					listaMontosPrecios[i] = 0;
				}
				for (MenuComidaDetalle menuDetalle : listaMenuComidaDetalle) {
					int diaSemana; 
					calendario.setTime(menuDetalle.getFecha());
					diaSemana = calendario.get(Calendar.DAY_OF_WEEK);
					if(diaSemana == 1)
					{
						diaSemana = 6;
					}
					else
					{
						diaSemana -=2;
					}
					
					listaMontosPrecios[diaSemana] += menuDetalle.getPrecioTotal();
					int indice = Collections.binarySearch(listaCategoriaComida, menuDetalle.getCategoriaComida());
					this.formAlquilerCampoDeportivo.getJTableHorariosCampos().setValueAt(menuDetalle, indice, diaSemana+1);					
					this.formAlquilerCampoDeportivo.getJTableHorariosCampos().setDataAwareColor(menuDetalle, colorAlquilado);
					montoAcumuladoMenu += menuDetalle.getPrecioUnitario();
				}
				String Resumen ="";
				montoTotalAcumuladoMenu = 0;
				for (double d : listaMontosPrecios) {
					Resumen += "                      " + d + " Bs";
					montoTotalAcumuladoMenu += d;
				}
				formAlquilerCampoDeportivo.getLblResumenDiario().setText(Resumen);
				formAlquilerCampoDeportivo.getLblResumenSemanal().setText("Total Comidas " +montoAcumuladoMenu);
				formAlquilerCampoDeportivo.getLblResumenSemanalTotal().setText("Total : " + montoTotalAcumuladoMenu);
				
			}
			

//		}
	}
	

	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		String accion = event.getActionCommand();
		
		
		//para el PopupMenu
		if(accion.compareTo(formAlquilerCampoDeportivo.getJMenuItemCancelar().getActionCommand())== 0){
			this.formAlquilerCampoDeportivo.getJTableHorariosCampos().clearSelection();
		}
		
		if(accion.compareTo(formAlquilerCampoDeportivo.getJMenuItemAlquilar().getActionCommand())== 0){
			if(formAlquilerCampoDeportivo.getJTableHorariosCampos().getSelectedRowCount() >= 1
					&& formAlquilerCampoDeportivo.getJTableHorariosCampos().getSelectedColumn() != 0)
			{
				JTableHorario table = formAlquilerCampoDeportivo.getJTableHorariosCampos();
//				CampoDeportivo campoDeportivo = (CampoDeportivo) formAlquilerCampoDeportivo.getJcBoxCampoDeportivo().getSelectedItem();
//				
//				PeriodoTiempo periodoInicio = (PeriodoTiempo) table.getValueAt(filaInicioSeleccionada, 0);
//	            PeriodoTiempo periodoFin = (PeriodoTiempo) table.getValueAt(filaFinSeleccionada, 0);	            
//	            PeriodoTiempo periodoTotal = new PeriodoTiempo(periodoInicio.getHoraInicio(), periodoFin.getHoraFin());
//				
	            Period periodoSemana = this.formAlquilerCampoDeportivo.getPnlDateChooser().getSelectedPeriodSet().getFirstPeriod();
	            int diaSemanaSeleccionado = this.formAlquilerCampoDeportivo.getJTableHorariosCampos().getSelectedColumn();
	            Calendar calendarioFecha = Calendar.getInstance();	            	            
	            calendarioFecha.setTime(periodoSemana.getStartDate().getTime());	            
	            calendarioFecha.add(Calendar.DATE, diaSemanaSeleccionado-1);
//	            calendarioFecha.set(Calendar.HOUR_OF_DAY, periodoTotal.getHoraInicio().getHora());
//	            calendarioFecha.set(Calendar.MINUTE, periodoInicio.getHoraInicio().getMinuto());
//	            calendarioFecha.set(Calendar.SECOND, periodoInicio.getHoraInicio().getSegundo());
	            Date fechaSeleccionada = calendarioFecha.getTime();
//	            Date fechaSeleccionada= formAlquilerCampoDeportivo.getPnlDateChooser().getSelectedDate().getTime();
	            
            
	            if(isCellOcupada(table, table.getSelectedRow(), table.getSelectedRow(), diaSemanaSeleccionado))
	            {
	            	FormUtilities.showMessage("Seleccion Invalida", "No puede reservar el Periodo Seleccionado, debido a que se encuentra ya ocupado", formAlquilerCampoDeportivo);
	            	return;
	            }
	            
	            CategoriaComida catComidaAux = ( CategoriaComida)table.getValueAt(table.getSelectedRow(), 0);
	            
	            setEnableTxtFields(true);
				clearFields();
				MenuComidaDetalle menuDetalle = new MenuComidaDetalle();
				menuDetalle.setCategoriaComida(catComidaAux);
				menuDetalle.setFecha(fechaSeleccionada);
				
				FMenuComidaDetalle formMenuDetalle = new FMenuComidaDetalle(formAlquilerCampoDeportivo);
				formMenuDetalle.cargarDatos(menuDetalle);
				FormUtilities.centrar(formMenuDetalle);
				formMenuDetalle.setVisible(true);
				
				menuDetalle = formMenuDetalle.menuDetalle;
				if(menuDetalle != null)
				{
					daoMenuComidaDetalleMapper.insert(menuDetalle);
					session.commit();
					
					semanaSeleccionada = null;
					onSelectionChange(new SelectionChangedEvent(formAlquilerCampoDeportivo.getPnlDateChooser()));
				}

				
			    habilitarBotones(false, true, true, false, false, false, false);
			    this.formAlquilerCampoDeportivo.getJTabbedPane().setSelectedIndex(0);

			}
		}
		
		if(accion.compareTo(formAlquilerCampoDeportivo.getJMenuItemAnular().getActionCommand())== 0){
			if(formAlquilerCampoDeportivo.getJTableHorariosCampos().getSelectedRowCount() >= 1
					&& formAlquilerCampoDeportivo.getJTableHorariosCampos().getSelectedColumn() != 0
					&& isCellOcupada(formAlquilerCampoDeportivo.getJTableHorariosCampos(), formAlquilerCampoDeportivo.getJTableHorariosCampos().getSelectedRow(),formAlquilerCampoDeportivo.getJTableHorariosCampos().getSelectedRow(), formAlquilerCampoDeportivo.getJTableHorariosCampos().getSelectedColumn())
					&& JOptionPane.showConfirmDialog(formAlquilerCampoDeportivo, "¿Se encuentra seguro eliminar el registro seleccionado?", "Menu de Comidas", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION )
			{
				int fila = formAlquilerCampoDeportivo.getJTableHorariosCampos().getSelectedRow();
				int columna = formAlquilerCampoDeportivo.getJTableHorariosCampos().getSelectedColumn();
				
				MenuComidaDetalle menuDetalle = (MenuComidaDetalle) formAlquilerCampoDeportivo.getJTableHorariosCampos().getValueAt(fila, columna);
				if(menuDetalle != null)
				{
					daoMenuComidaDetalleMapper.deleteByPrimaryKey(menuDetalle.getCodigoMenuComidaDetalle());
					session.commit();
					
					semanaSeleccionada = null;
					cargarHorarioSemanal();
				}
			}
				
		}
		
		if (accion.compareTo("Reporte") == 0) 
		{
			
			String path = rutaLocal + "org/quarkbit/trabajosocialsanjuan/reportes/";
			GeneraReport gr = new GeneraReport();			
			gr.loadReportJasper(path + "generar_menu_semanal.jasper");
			gr.setParameters("Fecha_Inicio",formAlquilerCampoDeportivo.getPnlDateChooser().getSelectedPeriodSet().getFirstDate().getTime());
			gr.setParameters("Fecha_Fin",formAlquilerCampoDeportivo.getPnlDateChooser().getSelectedPeriodSet().getFirstPeriod().getEndDate().getTime());
			gr.setParameters("Institucion", "HOGAR TATA JUAN DE DIOS");
			gr.fillReport(session.getConnection());			
			gr.previewReportModal();
			
		}
		if (accion.compareTo("Cerrar") == 0) {
			
			this.formAlquilerCampoDeportivo.setVisible(false);
			this.formAlquilerCampoDeportivo.dispose();
		}
		
		//para el PopupMenu

		
		if (accion.compareTo("nuevo") == 0) {
			
			
			
		}
		if (accion.compareTo("cancelar") == 0) {
			
						
		}

		
		
		
		
	}
	

	
	/**
	 * @return the colorReservado
	 */
	public Color getColorReservado() {
		return colorReservado;
	}

	/**
	 * @param colorReservado the colorReservado to set
	 */
	public void setColorReservado(Color colorReservado) {
		this.colorReservado = colorReservado;
	}

	/**
	 * @return the colorAlquilado
	 */
	public Color getColorAlquilado() {
		return colorAlquilado;
	}

	/**
	 * @param colorAlquilado the colorAlquilado to set
	 */
	public void setColorAlquilado(Color colorAlquilado) {
		this.colorAlquilado = colorAlquilado;
	}

	/**
	 * @return the colorPasado
	 */
	public Color getColorPasado() {
		return colorPasado;
	}

	/**
	 * @param colorPasado the colorPasado to set
	 */
	public void setColorPasado(Color colorPasado) {
		this.colorPasado = colorPasado;
	}
	
	@SuppressWarnings("unchecked")
	public void onFormShow()
	{
//		configuracionFormulario();
//		if(alquilerCampoDeportivo == null)
//		{
//			alquilerCampoDeportivo = new AlquilerCampoDeportivo();
//			alquilerCampoDeportivoDetalle = new AlquilerCampoDeportivoDetalle();
//		}
//		try {
//			int idalquilerCampoDeportivo =0; 
//			idalquilerCampoDeportivo = dao.getIdLastObjetoTabla(alquilerCampoDeportivo, "T");
//			System.out.println(idalquilerCampoDeportivo);
//			alquilerCampoDeportivo.setIdservicio(idalquilerCampoDeportivo);
//			alquilerCampoDeportivo = (AlquilerCampoDeportivo) dao.obtenerObjeto(alquilerCampoDeportivo);
//			
//			List<CampoDeportivo> listaCampoDeportivo = dao.getObjects("CampoDeportivo");
//			for (CampoDeportivo campoDeportivo : listaCampoDeportivo) {
//				campoDeportivo.setDireccion("");
//				formAlquilerCampoDeportivo.getJcBoxCampoDeportivo().addItem(campoDeportivo);
//			}
//			fechaHoraServidor = dao.obtenerFechaHoraServidor();			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		
//		this.clearFields();
//		if (alquilerCampoDeportivo != null){
//			this.llenarTxtFields(alquilerCampoDeportivo);			
//		}
//		else
//		{
//			alquilerCampoDeportivo = new AlquilerCampoDeportivo();			
//		}
		formAlquilerCampoDeportivo.getPnlDateChooser().setSelectedDate(Calendar.getInstance());
		cargarHorarioSemanal();
		this.setEnableTxtFields(false);
		this.formAlquilerCampoDeportivo.lblColorAlquilado.setBackground(colorAlquilado);
		this.formAlquilerCampoDeportivo.lblColorPasado.setBackground(colorPasado);
		this.formAlquilerCampoDeportivo.lblColorReservado.setBackground(colorReservado);
		
	}
	
	
	
	
	
	public void setEnableTxtFields(boolean habilitar) {
//		this.formAlquilerCampoDeportivo.getJtxtAreaObservaciones().setEnabled(habilitar);				
//		this.formAlquilerCampoDeportivo.getJbtnBuscarPersonaSolicitante().setEnabled(habilitar);
//		this.formAlquilerCampoDeportivo.getJbtnInsertarPersonaCliente().setEnabled(habilitar);
//		this.formAlquilerCampoDeportivo.getJtxtNumeroAutorizacion().setEnabled(habilitar);
	}
	public void clearFields() {		
//		this.formAlquilerCampoDeportivo.getJtxtAreaObservaciones().setText("");
//		this.formAlquilerCampoDeportivo.getJtxtPersonaSolicitante().setText("");
//		this.formAlquilerCampoDeportivo.getJtxtPersonaResponsable().setText("");		
//		this.formAlquilerCampoDeportivo.getJtxtMontoTotal().setText("0.00");
//		this.formAlquilerCampoDeportivo.getJtxtNumeroAutorizacion().setText("");		
//		modeloAlquilerCampoDeportivoDetalle.clear();
	}
	
//	public void llenarTxtFields(AlquilerCampoDeportivo alquilerCampoDeport) {
//		this.formAlquilerCampoDeportivo.getJtxtAreaObservaciones().setText(alquilerCampoDeport.getObservaciones());
//		this.formAlquilerCampoDeportivo.getJtxtPersonaSolicitante().setText(alquilerCampoDeport.getCliente_solicitante().getNombreCompleto());
//		this.formAlquilerCampoDeportivo.getJtxtPersonaResponsable().setText(alquilerCampoDeport.getPersona_responsable().getNombreCompleto());		
//		this.formAlquilerCampoDeportivo.getJtxtNroServicio().setText(String.valueOf(alquilerCampoDeport.getIdservicio()));
//		this.formAlquilerCampoDeportivo.getJtxtMontoTotal().setText(String.valueOf(alquilerCampoDeport.getMonto_total_pago()));
//		this.formAlquilerCampoDeportivo.getJtxtNumeroAutorizacion().setText(String.valueOf(alquilerCampoDeport.getNumero_autorizacion()));
//		Calendar calendario = Calendar.getInstance();
//		calendario.setTime(alquilerCampoDeport.getFecha_registro_servicio());
//		this.formAlquilerCampoDeportivo.getDatecboxFechaRegistro().setCurrent(calendario);
//		
//		
//		modeloAlquilerCampoDeportivoDetalle.clear();
//		modeloAlquilerCampoDeportivoDetalle.setData(alquilerCampoDeport.getListaAlquilerCampoDeportivoDetalle());				
//		
//		
//	}
	
	public void habilitarBotones( boolean nuevo, boolean aceptar, boolean cancelar, boolean anular, boolean reportes, boolean buscar, boolean editar)
	{
//		this.formAlquilerCampoDeportivo.getJbtnNuevo().setEnabled(nuevo);
//		this.formAlquilerCampoDeportivo.getJbtnInsertar().setEnabled(aceptar);
//		this.formAlquilerCampoDeportivo.getJbtnCancelar().setEnabled(cancelar);		
//		this.formAlquilerCampoDeportivo.getJbtnReportes().setEnabled(reportes);
//		this.formAlquilerCampoDeportivo.getJbtnBuscar().setEnabled(buscar);		
//		this.formAlquilerCampoDeportivo.getJbtnAnular().setEnabled(anular);
//		this.formAlquilerCampoDeportivo.getJbtnEditar().setEnabled(editar);
//		
//		this.formAlquilerCampoDeportivo.getJtxtTextoBusqueda().setEnabled(buscar);
		
	}
	public void llenarDatos(int indice) {
		if (indice >= 0) {
//			this.formAlquilerCampoDeportivo.getJTableBusqueda().setRowSelectionInterval(indice, indice);
//			this.alquilerCampoDeportivo = modeloAlquilerCampoDeportivo.getAlquilerCampoDeportivo(indice);
//			if(alquilerCampoDeportivo != null)
//				llenarTxtFields(alquilerCampoDeportivo);
//			else
//			{
//				clearFields();
//				this.setEnableTxtFields(false);
//			}
		}
	}

	
	public boolean esFechaValida(Date fecha){
		Calendar fechaHoraServer = Calendar.getInstance();
		fechaHoraServer.setTime(fechaHoraServidor);
		
		Calendar fechaComparacion = Calendar.getInstance();
		fechaComparacion.setTime(fecha);
		
		if(fechaComparacion.after(fechaHoraServer))
			return true;
		else if(fechaComparacion.compareTo(fechaHoraServer)== 0)
			return true;
		else
			return false;
	}
	
	public boolean esFechaValida(Date fecha, int tiempoTolerancia){
		Calendar fechaHoraServer = Calendar.getInstance();
		fechaHoraServer.setTime(fechaHoraServidor);
		fechaHoraServer.add(Calendar.MINUTE, -tiempoTolerancia);
		
		Calendar fechaComparacion = Calendar.getInstance();
		fechaComparacion.setTime(fecha);
		
		if(fechaComparacion.after(fechaHoraServer))
			return true;
		else if(fechaComparacion.compareTo(fechaHoraServer)== 0)
			return true;
		else
			return false;
	}
	
	public void internalFrameClosing(InternalFrameEvent  event){		
		this.formAlquilerCampoDeportivo.getJTableHorariosCampos().clearSelection();

		this.formAlquilerCampoDeportivo.getJTabbedPane().setSelectedIndex(0);
		setEnableTxtFields(false);
		//this.clearFields();		
	}



	@Override
	public void tableChanged(TableModelEvent event) {
		// TODO Auto-generated method stub
//		if(event.getColumn() == 3 && modeloAlquilerCampoDeportivoDetalle != null
//				&& modeloAlquilerCampoDeportivoDetalle.getRowCount() > 0 )
//		{
//			formAlquilerCampoDeportivo.getJtxtMontoTotal().setText(String.valueOf(modeloAlquilerCampoDeportivoDetalle.getMontoTotal()));
//		}
	}
	
	/**
	 * @return the tiempoToleranciaAnulacion
	 */
	public int getTiempoToleranciaAnulacion() {
		return tiempoToleranciaAnulacion;
	}



	/**
	 * @param tiempoToleranciaAnulacion the tiempoToleranciaAnulacion to set
	 */
	public void setTiempoToleranciaAnulacion(int tiempoToleranciaAnulacion) {
		this.tiempoToleranciaAnulacion = tiempoToleranciaAnulacion;
	}



	public void setTiempoToleranciaAlquiler(int tiempoToleranciaAlquiler) {
		this.tiempoToleranciaAlquiler = tiempoToleranciaAlquiler;
	}



	public int getTiempoToleranciaAlquiler() {
		return tiempoToleranciaAlquiler;
	}
	
	public void setIdFormulario(int idFormulario) {
		this.idFormulario = idFormulario;
	}


}
