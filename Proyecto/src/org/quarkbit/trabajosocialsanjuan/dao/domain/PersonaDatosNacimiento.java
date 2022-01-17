package org.quarkbit.trabajosocialsanjuan.dao.domain;

import java.util.Date;

public class PersonaDatosNacimiento {
    /**
     *
     * column personas_datos_nacimiento.codigo_persona
     *
     * 
     */
    private Integer codigoPersona;

    /**
     *
     * column personas_datos_nacimiento.fecha_nacimiento
     *
     * 
     */
    private Date fechaNacimiento;

    /**
     *
     * column personas_datos_nacimiento.edad
     *
     * 
     */
    private Integer edad;

    /**
     *
     * column personas_datos_nacimiento.codigo_paisn
     *
     * 
     */
    private String codigoPaisn;

    /**
     *
     * column personas_datos_nacimiento.codigo_departamenton
     *
     * 
     */
    private String codigoDepartamenton;

    /**
     *
     * column personas_datos_nacimiento.codigo_provincian
     *
     * 
     */
    private String codigoProvincian;

    /**
     *
     * column personas_datos_nacimiento.codigo_lugarn
     *
     * 
     */
    private String codigoLugarn;

    /**
     *
     * column personas_datos_nacimiento.codigo_nacionalidad
     *
     * 
     */
    private String codigoNacionalidad;

    /**
     *
     * column personas_datos_nacimiento.observaciones
     *
     * 
     */
    private String observaciones;
    
    
    public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	private Pais pais;
    private Departamento departamento;
    private Provincia provincia;
    private Lugar lugar;

    /**
     * 
     *column personas_datos_nacimiento.codigo_persona
     *
     * @return the value of personas_datos_nacimiento.codigo_persona
     *
     * 
     */
    public Integer getCodigoPersona() {
        return codigoPersona;
    }

    /**
     * 
     *  column personas_datos_nacimiento.codigo_persona
     *
     * @param codigoPersona the value for personas_datos_nacimiento.codigo_persona
     *
     * 
     */
    public void setCodigoPersona(Integer codigoPersona) {
        this.codigoPersona = codigoPersona;
    }

    /**
     * 
     *column personas_datos_nacimiento.fecha_nacimiento
     *
     * @return the value of personas_datos_nacimiento.fecha_nacimiento
     *
     * 
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * 
     *  column personas_datos_nacimiento.fecha_nacimiento
     *
     * @param fechaNacimiento the value for personas_datos_nacimiento.fecha_nacimiento
     *
     * 
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * 
     *column personas_datos_nacimiento.edad
     *
     * @return the value of personas_datos_nacimiento.edad
     *
     * 
     */
    public Integer getEdad() {
        return edad;
    }

    /**
     * 
     *  column personas_datos_nacimiento.edad
     *
     * @param edad the value for personas_datos_nacimiento.edad
     *
     * 
     */
    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    /**
     * 
     *column personas_datos_nacimiento.codigo_paisn
     *
     * @return the value of personas_datos_nacimiento.codigo_paisn
     *
     * 
     */
    public String getCodigoPaisn() {
        return codigoPaisn;
    }

    /**
     * 
     *  column personas_datos_nacimiento.codigo_paisn
     *
     * @param codigoPaisn the value for personas_datos_nacimiento.codigo_paisn
     *
     * 
     */
    public void setCodigoPaisn(String codigoPaisn) {
        this.codigoPaisn = codigoPaisn == null ? null : codigoPaisn.trim();
    }

    /**
     * 
     *column personas_datos_nacimiento.codigo_departamenton
     *
     * @return the value of personas_datos_nacimiento.codigo_departamenton
     *
     * 
     */
    public String getCodigoDepartamenton() {
        return codigoDepartamenton;
    }

    /**
     * 
     *  column personas_datos_nacimiento.codigo_departamenton
     *
     * @param codigoDepartamenton the value for personas_datos_nacimiento.codigo_departamenton
     *
     * 
     */
    public void setCodigoDepartamenton(String codigoDepartamenton) {
        this.codigoDepartamenton = codigoDepartamenton == null ? null : codigoDepartamenton.trim();
    }

    /**
     * 
     *column personas_datos_nacimiento.codigo_provincian
     *
     * @return the value of personas_datos_nacimiento.codigo_provincian
     *
     * 
     */
    public String getCodigoProvincian() {
        return codigoProvincian;
    }

    /**
     * 
     *  column personas_datos_nacimiento.codigo_provincian
     *
     * @param codigoProvincian the value for personas_datos_nacimiento.codigo_provincian
     *
     * 
     */
    public void setCodigoProvincian(String codigoProvincian) {
        this.codigoProvincian = codigoProvincian == null ? null : codigoProvincian.trim();
    }

    /**
     * 
     *column personas_datos_nacimiento.codigo_lugarn
     *
     * @return the value of personas_datos_nacimiento.codigo_lugarn
     *
     * 
     */
    public String getCodigoLugarn() {
        return codigoLugarn;
    }

    /**
     * 
     *  column personas_datos_nacimiento.codigo_lugarn
     *
     * @param codigoLugarn the value for personas_datos_nacimiento.codigo_lugarn
     *
     * 
     */
    public void setCodigoLugarn(String codigoLugarn) {
        this.codigoLugarn = codigoLugarn == null ? null : codigoLugarn.trim();
    }

    /**
     * 
     *column personas_datos_nacimiento.codigo_nacionalidad
     *
     * @return the value of personas_datos_nacimiento.codigo_nacionalidad
     *
     * 
     */
    public String getCodigoNacionalidad() {
        return codigoNacionalidad;
    }

    /**
     * 
     *  column personas_datos_nacimiento.codigo_nacionalidad
     *
     * @param codigoNacionalidad the value for personas_datos_nacimiento.codigo_nacionalidad
     *
     * 
     */
    public void setCodigoNacionalidad(String codigoNacionalidad) {
        this.codigoNacionalidad = codigoNacionalidad == null ? null : codigoNacionalidad.trim();
    }

    /**
     * 
     *column personas_datos_nacimiento.observaciones
     *
     * @return the value of personas_datos_nacimiento.observaciones
     *
     * 
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * 
     *  column personas_datos_nacimiento.observaciones
     *
     * @param observaciones the value for personas_datos_nacimiento.observaciones
     *
     * 
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones == null ? null : observaciones.trim();
    }

	public Lugar getLugar() {
		return lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}
}