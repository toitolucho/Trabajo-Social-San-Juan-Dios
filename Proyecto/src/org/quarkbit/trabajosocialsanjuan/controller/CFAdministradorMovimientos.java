package org.quarkbit.trabajosocialsanjuan.controller;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.apache.ibatis.session.SqlSession;
import org.quarkbit.trabajosocialsanjuan.dao.Coneccion;
import org.quarkbit.trabajosocialsanjuan.dao.domain.EgresoExample;
import org.quarkbit.trabajosocialsanjuan.dao.domain.IngresoExample;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.EgresoMapper;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.IngresoMapper;
import org.quarkbit.trabajosocialsanjuan.formularios.FAdministradorMovimientos;
import org.quarkbit.trabajosocialsanjuan.formularios.FEgresos;
import org.quarkbit.trabajosocialsanjuan.formularios.FIngresos;
import org.quarkbit.trabajosocialsanjuan.formularios.tablemodels.ModeloEgresos;
import org.quarkbit.trabajosocialsanjuan.formularios.tablemodels.ModeloIngresos;
import org.quarkbit.trabajosocialsanjuan.utils.FormUtilities;
import org.quarkbit.trabajosocialsanjuan.utils.GeneraReport;

public class CFAdministradorMovimientos implements ActionListener, ListSelectionListener{

	FAdministradorMovimientos formMovimientos;
	SqlSession session;
	IngresoMapper daoIngresos;
	EgresoMapper daoEgresos;
	ModeloIngresos modeloIngresos;
	ModeloEgresos modeloEgresos;
	private String rutaLocal;
	
	public CFAdministradorMovimientos(FAdministradorMovimientos formMovimientos)
	{
		this.formMovimientos = formMovimientos;
		session = Coneccion.getSqlSessionFactory().openSession();
		
		daoIngresos = session.getMapper(IngresoMapper.class);
		daoEgresos = session.getMapper(EgresoMapper.class);
		
		modeloIngresos = new ModeloIngresos();
		modeloEgresos = new ModeloEgresos();
		
		rutaLocal = FormUtilities.obtenerRutaLocal();
				
	}
	
	public void onFormShown()
	{
		formMovimientos.getTableEgresos().setModel(modeloEgresos);
		formMovimientos.getTableIngresos().setModel(modeloIngresos);
		formMovimientos.getTableEgresos().getSelectionModel().addListSelectionListener(this);
		formMovimientos.getTableIngresos().getSelectionModel().addListSelectionListener(this);
		
		
		Calendar fechaInicio = Calendar.getInstance();
		Calendar fechaFin = Calendar.getInstance();
		fechaInicio.set(Calendar.DAY_OF_MONTH, 1);
		fechaFin.set(Calendar.HOUR_OF_DAY, 23);
		fechaFin.set(Calendar.MINUTE, 59);
		fechaFin.set(Calendar.SECOND, 59);
		formMovimientos.getDateFechaInicio().setDate(fechaInicio.getTime());
		formMovimientos.getDateFechaFin().setDate(fechaFin.getTime());
		actionPerformed(new ActionEvent(formMovimientos, 20, "Actualizar"));
		
////		System.out.println(fechaInicio.getTime() + "           " + Calendar.getInstance().getTime());
//		IngresoExample filtro = new IngresoExample();
//		filtro.or().andFechaIngresoBetween(fechaInicio.getTime(), Calendar.getInstance().getTime());
////		System.out.println(daoIngresos.selectByExample(filtro).size());
//		modeloIngresos.setListIngreso(daoIngresos.selectByExample(filtro));
		
//		EgresoExample filtro2 = new EgresoExample();
//		filtro2.or().andFechaEgresoBetween(fechaInicio.getTime(), Calendar.getInstance().getTime());
//		modeloEgresos.setListEgreso( daoEgresos.selectByExample(filtro2));

		formMovimientos.getBtnEliminar().addActionListener(this);
		formMovimientos.getBtnModificar().addActionListener(this);
		formMovimientos.getBtnNuevo().addActionListener(this);
		formMovimientos.getBtnReporte().addActionListener(this);
		formMovimientos.getBtnActualizar().addActionListener(this);
		
		FormUtilities.centrar(formMovimientos);
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().compareTo("Nuevo") == 0)
		{
			if(formMovimientos.getTabbedPane().getSelectedComponent().equals(formMovimientos.getPnlIngresos()))
			{
				FIngresos formIngresos = new FIngresos(null);
				formIngresos.control.mostrarParaInsercion(null);
				FormUtilities.centrar(formIngresos);
				formIngresos.setVisible(true);			
				
			}
			else
			{
				FEgresos formEgresos = new FEgresos(null);
				formEgresos.control.mostrarParaInsercion(null);
				FormUtilities.centrar(formEgresos);
				formEgresos.setVisible(true);
				
			}
			session.commit();
			actionPerformed(new ActionEvent(formMovimientos, 20, "Actualizar"));
		}
		
		if(e.getActionCommand().compareTo("Actualizar") == 0)
		{
			
			if(formMovimientos.getDateFechaInicio().getDate() == null)
			{
				JOptionPane.showMessageDialog(formMovimientos, "No ha ingresado la Fecha de Inicio", "Administrador de Movimientos", JOptionPane.ERROR_MESSAGE);
				formMovimientos.getDateFechaInicio().grabFocus();
				return;
			}
			if(formMovimientos.getDateFechaFin().getDate() == null)
			{
				JOptionPane.showMessageDialog(formMovimientos, "No ha ingresado la Fecha de Culminacion", "Administrador de Movimientos", JOptionPane.ERROR_MESSAGE);
				formMovimientos.getDateFechaFin().grabFocus();
				return;
			}
		
			
			IngresoExample filtro3 = new IngresoExample();
			filtro3.clear();
			filtro3.or().andFechaIngresoBetween(formMovimientos.getDateFechaInicio().getDate(), formMovimientos.getDateFechaFin().getDate());
			modeloIngresos.setListIngreso(daoIngresos.selectByExample(filtro3));
			
			
			EgresoExample filtro2 = new EgresoExample();
			filtro2.clear();
			filtro2.or().andFechaEgresoBetween(formMovimientos.getDateFechaInicio().getDate(), formMovimientos.getDateFechaFin().getDate());
			modeloEgresos.setListEgreso( daoEgresos.selectByExample(filtro2));
			
			formMovimientos.getLblTotalEgresos().setText("T. Egresos: " + String.valueOf(modeloEgresos.obtenerMontoEgresoTotal())+"Bs");
			formMovimientos.getLblTotalIngresos().setText("T. Ingresos: " + String.valueOf(modeloIngresos.obtenerMontoIngresoTotal())+"Bs"
					+ "                 | Saldo:" + String.valueOf(modeloIngresos.obtenerSaldoIngresoTotal()));
			
//			System.out.println(formMovimientos.getDateFechaFin().getDate());
		}
		if(e.getActionCommand().compareTo("Modificar") == 0)
		{
			if(formMovimientos.getTabbedPane().getSelectedComponent().equals(formMovimientos.getPnlIngresos()))
			{
				if(formMovimientos.getTableIngresos().getSelectedRow() >= 0)
				{
					FIngresos formIngresos = new FIngresos(null);
					formIngresos.control.mostrarParaInsercion(modeloIngresos.obtenerIngreso(formMovimientos.getTableIngresos().getSelectedRow()));
					FormUtilities.centrar(formIngresos);
					formIngresos.setVisible(true);
					session.commit();
					actionPerformed(new ActionEvent(formMovimientos, 20, "Actualizar"));
				}
			}
			else
			{
				if(formMovimientos.getTableEgresos().getSelectedRow() >= 0)
				{
					FEgresos formEgresos = new FEgresos(null);
					formEgresos.control.mostrarParaInsercion(modeloEgresos.obtenerEgreso(formMovimientos.getTableEgresos().getSelectedRow()));
					FormUtilities.centrar(formEgresos);
					formEgresos.setVisible(true);
					session.commit();
					actionPerformed(new ActionEvent(formMovimientos, 20, "Actualizar"));
				}
			}
		}
		if(e.getActionCommand().compareTo("Eliminar") == 0)
		{
			try {
				if(formMovimientos.getTabbedPane().getSelectedComponent().equals(formMovimientos.getPnlIngresos()))
				{
					if(JOptionPane.showConfirmDialog(formMovimientos, "¿Se encuentra seguro de eliminar el registro actual?", "Administrador de Movimientos", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION
							&& formMovimientos.getTableIngresos().getSelectedRow() >= 0)
					{
						daoIngresos.deleteByPrimaryKey(modeloIngresos.obtenerIngreso(formMovimientos.getTableIngresos().getSelectedRow()).getCodigoIngreso());
						session.commit();
						actionPerformed(new ActionEvent(formMovimientos, 20, "Actualizar"));
						
					}
				}
				else				
				{
					if(JOptionPane.showConfirmDialog(formMovimientos, "¿Se encuentra seguro de eliminar el registro actual?", "Administrador de Movimientos", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION
							&& formMovimientos.getTableEgresos().getSelectedRow() >= 0)
					{
						daoEgresos.deleteByPrimaryKey(modeloEgresos.obtenerEgreso(formMovimientos.getTableEgresos().getSelectedRow()).getCodigoEgreso());
						session.commit();
						actionPerformed(new ActionEvent(formMovimientos, 20, "Actualizar"));
						
					}
				}
				JOptionPane.showMessageDialog(formMovimientos, "Registro eliminado correctamente", "Administrador Movimiento", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				session.clearCache();
				session.commit();
				JOptionPane.showMessageDialog(formMovimientos, "El registro que desea eliminar se encuentra en uso en otras transacciones", "Administrador Movimientos", JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getActionCommand().compareTo("Reporte") == 0)
		{
			String path = rutaLocal + "org/quarkbit/trabajosocialsanjuan/reportes/";
			GeneraReport gr = new GeneraReport();			
			gr.loadReportJasper(path + "obtener_egresos_reporte.jasper");
			gr.setParameters("fecha_inicio_aux",formMovimientos.getDateFechaInicio().getDate());
			gr.setParameters("fecha_fin_aux",formMovimientos.getDateFechaFin().getDate());
			gr.setParameters("codigo_partida_aux", null);
			gr.setParameters("codigo_proveedor_aux", null);
			gr.fillReport(session.getConnection());			
			gr.previewReportModal();
		}
	}

}
