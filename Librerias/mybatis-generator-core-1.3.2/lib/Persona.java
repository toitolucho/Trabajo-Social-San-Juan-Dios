package org.iitic.asignaciondocente.dao.domain;

public class Persona implements Comparable<Persona> {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PERSONAS.ID_PERSONA
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    private Integer idPersona;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PERSONAS.CI_PERSONA
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    private String ciPersona;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PERSONAS.NOMBRE_COMPLETO
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    private String nombreCompleto;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PERSONAS.SEXO
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    private String sexo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PERSONAS.CELULAR
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    private String celular;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PERSONAS.CORREO_ELECTRONICO
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    private String correoElectronico;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PERSONAS.ID_PROFESION
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    private Integer idProfesion;
    
    private TipoAsignacion tipoAsignacion;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PERSONAS.ID_PERSONA
     *
     * @return the value of PERSONAS.ID_PERSONA
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    public Integer getIdPersona() {
        return idPersona;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PERSONAS.ID_PERSONA
     *
     * @param idPersona the value for PERSONAS.ID_PERSONA
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PERSONAS.CI_PERSONA
     *
     * @return the value of PERSONAS.CI_PERSONA
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    public String getCiPersona() {
        return ciPersona;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PERSONAS.CI_PERSONA
     *
     * @param ciPersona the value for PERSONAS.CI_PERSONA
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    public void setCiPersona(String ciPersona) {
        this.ciPersona = ciPersona == null ? null : ciPersona.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PERSONAS.NOMBRE_COMPLETO
     *
     * @return the value of PERSONAS.NOMBRE_COMPLETO
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PERSONAS.NOMBRE_COMPLETO
     *
     * @param nombreCompleto the value for PERSONAS.NOMBRE_COMPLETO
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto == null ? null : nombreCompleto.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PERSONAS.SEXO
     *
     * @return the value of PERSONAS.SEXO
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PERSONAS.SEXO
     *
     * @param sexo the value for PERSONAS.SEXO
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    public void setSexo(String sexo) {
        this.sexo = sexo == null ? null : sexo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PERSONAS.CELULAR
     *
     * @return the value of PERSONAS.CELULAR
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    public String getCelular() {
        return celular;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PERSONAS.CELULAR
     *
     * @param celular the value for PERSONAS.CELULAR
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    public void setCelular(String celular) {
        this.celular = celular == null ? null : celular.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PERSONAS.CORREO_ELECTRONICO
     *
     * @return the value of PERSONAS.CORREO_ELECTRONICO
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PERSONAS.CORREO_ELECTRONICO
     *
     * @param correoElectronico the value for PERSONAS.CORREO_ELECTRONICO
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico == null ? null : correoElectronico.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PERSONAS.ID_PROFESION
     *
     * @return the value of PERSONAS.ID_PROFESION
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    public Integer getIdProfesion() {
        return idProfesion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PERSONAS.ID_PROFESION
     *
     * @param idProfesion the value for PERSONAS.ID_PROFESION
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    public void setIdProfesion(Integer idProfesion) {
        this.idProfesion = idProfesion;
    }
    
    


@Override
	public int compareTo(Persona o) {
		// TODO Auto-generated method stub
		return o.nombreCompleto.compareTo(this.nombreCompleto);
	}
	


	
	public String obtenerSexo()
	{	
		if(this.sexo.compareTo("M") == 0)
			return "MASCULINO";
		else
			return "FEMENINO";
	}
	
	public void enviarSexo(String sexo)
	{
		if(sexo.compareTo("MASCULINO") == 0)
			this.sexo = "M";
		else
			this.sexo = "F";
			
	}

	@Override
	public String toString() {
		return nombreCompleto;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombreCompleto == null) ? 0 : nombreCompleto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (nombreCompleto == null) {
			if (other.nombreCompleto != null)
				return false;
		} else if (!nombreCompleto.equals(other.nombreCompleto))
			return false;
		return true;
	}

	public TipoAsignacion getTipoAsignacion() {
		return tipoAsignacion;
	}

	public void setTipoAsignacion(TipoAsignacion tipoAsignacion) {
		this.tipoAsignacion = tipoAsignacion;
	}







}