package org.quarkbit.trabajosocialsanjuan.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import org.quarkbit.trabajosocialsanjuan.formularios.FRangoFechas;
import org.quarkbit.trabajosocialsanjuan.utils.FormUtilities;


public class CFRangoFechas implements ActionListener{
	FRangoFechas formRangoFechas;
	private Date FechaInicio, FechaFin;
	public boolean OperacionConfirmada = false;
	
	public CFRangoFechas(FRangoFechas form)
	{
		this.formRangoFechas = form;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String accion = event.getActionCommand();
		if(accion.compareTo("aceptar")== 0)
		{			
			FechaInicio = formRangoFechas.getJcalendarComboFechaInicio().getDate();
			FechaFin = formRangoFechas.getJcalendarComboFechaFin().getDate();
			if(FechaInicio.after(FechaFin))
			{
				FormUtilities.showMessage("Rango de Fechas no Valida", "No puede ingresar una Fecha Inicio Superior a la Fecha Fin", formRangoFechas);
				return;
			}
			OperacionConfirmada = true;
		}
		else
		{
			OperacionConfirmada = false;
		}
		this.formRangoFechas.setVisible(false);
		
	}
	public void setFechaInicio(Date fechaInicio) {
		FechaInicio = fechaInicio;
	}
	public Date getFechaInicio() {
		return FechaInicio;
	}
	public void setFechaFin(Date fechaFin) {
		FechaFin = fechaFin;
	}
	public Date getFechaFin() {
		return FechaFin;
	}

}
