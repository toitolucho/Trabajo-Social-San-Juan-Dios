package org.quarkbit.trabajosocialsanjuan.dao.domain;

import java.util.Comparator;
import java.util.Date;

public class PersonaKardexFamiliar extends PersonaKardexFamiliarKey  implements Comparable<PersonaKardexFamiliar>{
    /**
     *
     * column personas_kardex_familiares.codigo_parentesco
     *
     * 
     */
    private Integer codigoParentesco;

    /**
     *
     * column personas_kardex_familiares.monto_ingreso
     *
     * 
     */
    private Double montoIngreso;

    /**
     *
     * column personas_kardex_familiares.fecha_registro
     *
     * 
     */
    private Date fechaRegistro;

    /**
     *
     * column personas_kardex_familiares.observaciones
     *
     * 
     */
    private String observaciones;
    
    private Persona persona;
    
    private Parentesco parentesco;

    /**
     * 
     *column personas_kardex_familiares.codigo_parentesco
     *
     * @return the value of personas_kardex_familiares.codigo_parentesco
     *
     * 
     */
    public Integer getCodigoParentesco() {
        return codigoParentesco;
    }

    /**
     * 
     *  column personas_kardex_familiares.codigo_parentesco
     *
     * @param codigoParentesco the value for personas_kardex_familiares.codigo_parentesco
     *
     * 
     */
    public void setCodigoParentesco(Integer codigoParentesco) {
        this.codigoParentesco = codigoParentesco;
    }

    /**
     * 
     *column personas_kardex_familiares.monto_ingreso
     *
     * @return the value of personas_kardex_familiares.monto_ingreso
     *
     * 
     */
    public Double getMontoIngreso() {
        return montoIngreso;
    }

    /**
     * 
     *  column personas_kardex_familiares.monto_ingreso
     *
     * @param montoIngreso the value for personas_kardex_familiares.monto_ingreso
     *
     * 
     */
    public void setMontoIngreso(Double montoIngreso) {
        this.montoIngreso = montoIngreso;
    }

    /**
     * 
     *column personas_kardex_familiares.fecha_registro
     *
     * @return the value of personas_kardex_familiares.fecha_registro
     *
     * 
     */
    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * 
     *  column personas_kardex_familiares.fecha_registro
     *
     * @param fechaRegistro the value for personas_kardex_familiares.fecha_registro
     *
     * 
     */
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * 
     *column personas_kardex_familiares.observaciones
     *
     * @return the value of personas_kardex_familiares.observaciones
     *
     * 
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * 
     *  column personas_kardex_familiares.observaciones
     *
     * @param observaciones the value for personas_kardex_familiares.observaciones
     *
     * 
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones == null ? null : observaciones.trim();
    }

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Parentesco getParentesco() {
		return parentesco;
	}

	public void setParentesco(Parentesco parentesco) {
		this.parentesco = parentesco;
	}

	@Override
	public int compareTo(PersonaKardexFamiliar o) {
		// TODO Auto-generated method stub
		return this.persona.obtenerNombreCompleto().compareTo(o.persona.obtenerNombreCompleto());
	}

	
}