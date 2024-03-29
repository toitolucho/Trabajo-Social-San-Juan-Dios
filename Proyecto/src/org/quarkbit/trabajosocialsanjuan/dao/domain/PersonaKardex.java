package org.quarkbit.trabajosocialsanjuan.dao.domain;

import java.util.Date;

public class PersonaKardex {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column personas_kardex.codigo_kardex
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    private Integer codigoKardex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column personas_kardex.numero_kardex
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    private Integer numeroKardex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column personas_kardex.codigo_persona
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    private Integer codigoPersona;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column personas_kardex.fecha_registro
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    private Date fechaRegistro;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column personas_kardex.fecha_ingreso
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    private Date fechaIngreso;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column personas_kardex.fecha_egreso
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    private Date fechaEgreso;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column personas_kardex.centro
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    private String centro;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column personas_kardex.motivo_ingreso
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    private String motivoIngreso;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column personas_kardex.codigo_persona_ingreso
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    private Integer codigoPersonaIngreso;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column personas_kardex.motivo_egreso
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    private String motivoEgreso;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column personas_kardex.codigo_persona_egreso
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    private Integer codigoPersonaEgreso;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column personas_kardex.codigo_persona_trab_social
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    private Integer codigoPersonaTrabSocial;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column personas_kardex.nombre_kardex
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    private String nombreKardex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column personas_kardex.codigo_usuario
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    private Integer codigoUsuario;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column personas_kardex.codigo_institucion
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    private Integer codigoInstitucion;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column personas_kardex.ruta_archivo_foto
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    private String rutaArchivoFoto;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column personas_kardex.codigo_estado
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    private String codigoEstado;

    private Institucion institucion;
    private Persona trabajadoraSosial;
    private Persona personaIngreso;
    private Persona personaEgreso;
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column personas_kardex.codigo_kardex
     *
     * @return the value of personas_kardex.codigo_kardex
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    public Integer getCodigoKardex() {
        return codigoKardex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column personas_kardex.codigo_kardex
     *
     * @param codigoKardex the value for personas_kardex.codigo_kardex
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    public void setCodigoKardex(Integer codigoKardex) {
        this.codigoKardex = codigoKardex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column personas_kardex.numero_kardex
     *
     * @return the value of personas_kardex.numero_kardex
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    public Integer getNumeroKardex() {
        return numeroKardex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column personas_kardex.numero_kardex
     *
     * @param numeroKardex the value for personas_kardex.numero_kardex
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    public void setNumeroKardex(Integer numeroKardex) {
        this.numeroKardex = numeroKardex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column personas_kardex.codigo_persona
     *
     * @return the value of personas_kardex.codigo_persona
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    public Integer getCodigoPersona() {
        return codigoPersona;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column personas_kardex.codigo_persona
     *
     * @param codigoPersona the value for personas_kardex.codigo_persona
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    public void setCodigoPersona(Integer codigoPersona) {
        this.codigoPersona = codigoPersona;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column personas_kardex.fecha_registro
     *
     * @return the value of personas_kardex.fecha_registro
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column personas_kardex.fecha_registro
     *
     * @param fechaRegistro the value for personas_kardex.fecha_registro
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column personas_kardex.fecha_ingreso
     *
     * @return the value of personas_kardex.fecha_ingreso
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column personas_kardex.fecha_ingreso
     *
     * @param fechaIngreso the value for personas_kardex.fecha_ingreso
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column personas_kardex.fecha_egreso
     *
     * @return the value of personas_kardex.fecha_egreso
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    public Date getFechaEgreso() {
        return fechaEgreso;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column personas_kardex.fecha_egreso
     *
     * @param fechaEgreso the value for personas_kardex.fecha_egreso
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    public void setFechaEgreso(Date fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column personas_kardex.centro
     *
     * @return the value of personas_kardex.centro
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    public String getCentro() {
        return centro;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column personas_kardex.centro
     *
     * @param centro the value for personas_kardex.centro
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    public void setCentro(String centro) {
        this.centro = centro == null ? null : centro.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column personas_kardex.motivo_ingreso
     *
     * @return the value of personas_kardex.motivo_ingreso
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    public String getMotivoIngreso() {
        return motivoIngreso;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column personas_kardex.motivo_ingreso
     *
     * @param motivoIngreso the value for personas_kardex.motivo_ingreso
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    public void setMotivoIngreso(String motivoIngreso) {
        this.motivoIngreso = motivoIngreso == null ? null : motivoIngreso.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column personas_kardex.codigo_persona_ingreso
     *
     * @return the value of personas_kardex.codigo_persona_ingreso
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    public Integer getCodigoPersonaIngreso() {
        return codigoPersonaIngreso;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column personas_kardex.codigo_persona_ingreso
     *
     * @param codigoPersonaIngreso the value for personas_kardex.codigo_persona_ingreso
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    public void setCodigoPersonaIngreso(Integer codigoPersonaIngreso) {
        this.codigoPersonaIngreso = codigoPersonaIngreso;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column personas_kardex.motivo_egreso
     *
     * @return the value of personas_kardex.motivo_egreso
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    public String getMotivoEgreso() {
        return motivoEgreso;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column personas_kardex.motivo_egreso
     *
     * @param motivoEgreso the value for personas_kardex.motivo_egreso
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    public void setMotivoEgreso(String motivoEgreso) {
        this.motivoEgreso = motivoEgreso == null ? null : motivoEgreso.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column personas_kardex.codigo_persona_egreso
     *
     * @return the value of personas_kardex.codigo_persona_egreso
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    public Integer getCodigoPersonaEgreso() {
        return codigoPersonaEgreso;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column personas_kardex.codigo_persona_egreso
     *
     * @param codigoPersonaEgreso the value for personas_kardex.codigo_persona_egreso
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    public void setCodigoPersonaEgreso(Integer codigoPersonaEgreso) {
        this.codigoPersonaEgreso = codigoPersonaEgreso;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column personas_kardex.codigo_persona_trab_social
     *
     * @return the value of personas_kardex.codigo_persona_trab_social
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    public Integer getCodigoPersonaTrabSocial() {
        return codigoPersonaTrabSocial;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column personas_kardex.codigo_persona_trab_social
     *
     * @param codigoPersonaTrabSocial the value for personas_kardex.codigo_persona_trab_social
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    public void setCodigoPersonaTrabSocial(Integer codigoPersonaTrabSocial) {
        this.codigoPersonaTrabSocial = codigoPersonaTrabSocial;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column personas_kardex.nombre_kardex
     *
     * @return the value of personas_kardex.nombre_kardex
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    public String getNombreKardex() {
        return nombreKardex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column personas_kardex.nombre_kardex
     *
     * @param nombreKardex the value for personas_kardex.nombre_kardex
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    public void setNombreKardex(String nombreKardex) {
        this.nombreKardex = nombreKardex == null ? null : nombreKardex.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column personas_kardex.codigo_usuario
     *
     * @return the value of personas_kardex.codigo_usuario
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column personas_kardex.codigo_usuario
     *
     * @param codigoUsuario the value for personas_kardex.codigo_usuario
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column personas_kardex.codigo_institucion
     *
     * @return the value of personas_kardex.codigo_institucion
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    public Integer getCodigoInstitucion() {
        return codigoInstitucion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column personas_kardex.codigo_institucion
     *
     * @param codigoInstitucion the value for personas_kardex.codigo_institucion
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    public void setCodigoInstitucion(Integer codigoInstitucion) {
        this.codigoInstitucion = codigoInstitucion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column personas_kardex.ruta_archivo_foto
     *
     * @return the value of personas_kardex.ruta_archivo_foto
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    public String getRutaArchivoFoto() {
        return rutaArchivoFoto;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column personas_kardex.ruta_archivo_foto
     *
     * @param rutaArchivoFoto the value for personas_kardex.ruta_archivo_foto
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    public void setRutaArchivoFoto(String rutaArchivoFoto) {
        this.rutaArchivoFoto = rutaArchivoFoto == null ? null : rutaArchivoFoto.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column personas_kardex.codigo_estado
     *
     * @return the value of personas_kardex.codigo_estado
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    public String getCodigoEstado() {
        return codigoEstado;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column personas_kardex.codigo_estado
     *
     * @param codigoEstado the value for personas_kardex.codigo_estado
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    public void setCodigoEstado(String codigoEstado) {
        this.codigoEstado = codigoEstado == null ? null : codigoEstado.trim();
    }
    
    public Institucion getInstitucion() {
		return institucion;
	}

	public void setInstitucion(Institucion institucion) {
		this.institucion = institucion;
	}

	public Persona getTrabajadoraSosial() {
		return trabajadoraSosial;
	}

	public void setTrabajadoraSosial(Persona trabajadoraSosial) {
		this.trabajadoraSosial = trabajadoraSosial;
	}



	public Persona getPersonaIngreso() {
		return personaIngreso;
	}

	public void setPersonaIngreso(Persona personaIngreso) {
		this.personaIngreso = personaIngreso;
	}

	public Persona getPersonaEgreso() {
		return personaEgreso;
	}

	public void setPersonaEgreso(Persona personaEgreso) {
		this.personaEgreso = personaEgreso;
	}
}