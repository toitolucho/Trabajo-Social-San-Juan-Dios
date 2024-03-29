package org.quarkbit.trabajosocialsanjuan.dao.domain;

import java.util.Date;

public class Consulta {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column consulta.numero_consulta
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    private Integer numeroConsulta;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column consulta.numero_hc
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    private Integer numeroHistorialClinico;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column consulta.motivo
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    private String motivo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column consulta.fecha_consulta
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    private Date fechaConsulta;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column consulta.codigo_tipo_consulta
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    private String codigoTipoConsulta;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column consulta.diagnostico
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    private String diagnostico;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column consulta.observaciones
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    private String observaciones;

    private Persona persona;
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column consulta.numero_consulta
     *
     * @return the value of consulta.numero_consulta
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    public Integer getNumeroConsulta() {
        return numeroConsulta;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column consulta.numero_consulta
     *
     * @param numeroConsulta the value for consulta.numero_consulta
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    public void setNumeroConsulta(Integer numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column consulta.numero_hc
     *
     * @return the value of consulta.numero_hc
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    public Integer getNumeroHistorialClinico() {
        return numeroHistorialClinico;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column consulta.numero_hc
     *
     * @param numeroHistorialClinico the value for consulta.numero_hc
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    public void setNumeroHistorialClinico(Integer numeroHistorialClinico) {
        this.numeroHistorialClinico = numeroHistorialClinico;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column consulta.motivo
     *
     * @return the value of consulta.motivo
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column consulta.motivo
     *
     * @param motivo the value for consulta.motivo
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo == null ? null : motivo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column consulta.fecha_consulta
     *
     * @return the value of consulta.fecha_consulta
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    public Date getFechaConsulta() {
        return fechaConsulta;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column consulta.fecha_consulta
     *
     * @param fechaConsulta the value for consulta.fecha_consulta
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    public void setFechaConsulta(Date fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column consulta.codigo_tipo_consulta
     *
     * @return the value of consulta.codigo_tipo_consulta
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    public String getCodigoTipoConsulta() {
        return codigoTipoConsulta;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column consulta.codigo_tipo_consulta
     *
     * @param codigoTipoConsulta the value for consulta.codigo_tipo_consulta
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    public void setCodigoTipoConsulta(String codigoTipoConsulta) {
        this.codigoTipoConsulta = codigoTipoConsulta == null ? null : codigoTipoConsulta.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column consulta.diagnostico
     *
     * @return the value of consulta.diagnostico
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    public String getDiagnostico() {
        return diagnostico;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column consulta.diagnostico
     *
     * @param diagnostico the value for consulta.diagnostico
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico == null ? null : diagnostico.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column consulta.observaciones
     *
     * @return the value of consulta.observaciones
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column consulta.observaciones
     *
     * @param observaciones the value for consulta.observaciones
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
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
}