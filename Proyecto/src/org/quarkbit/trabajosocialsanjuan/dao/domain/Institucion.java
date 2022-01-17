package org.quarkbit.trabajosocialsanjuan.dao.domain;

public class Institucion {
    /**
     *
     * column instituciones.codigo_institucion
     *
     * 
     */
    private Integer codigoInstitucion;

    /**
     *
     * column instituciones.nombre_institucion
     *
     * 
     */
    private String nombreInstitucion;

    /**
     *
     * column instituciones.direccion
     *
     * 
     */
    private String Direccion;

    /**
     *
     * column instituciones.telefono
     *
     * 
     */
    private String Telefono;

    /**
     *
     * column instituciones.descripcion
     *
     * 
     */
    private String descripcion;

    /**
     * 
     *column instituciones.codigo_institucion
     *
     * @return the value of instituciones.codigo_institucion
     *
     * 
     */
    public Integer getCodigoInstitucion() {
        return codigoInstitucion;
    }

    /**
     * 
     *  column instituciones.codigo_institucion
     *
     * @param codigoInstitucion the value for instituciones.codigo_institucion
     *
     * 
     */
    public void setCodigoInstitucion(Integer codigoInstitucion) {
        this.codigoInstitucion = codigoInstitucion;
    }

    /**
     * 
     *column instituciones.nombre_institucion
     *
     * @return the value of instituciones.nombre_institucion
     *
     * 
     */
    public String getNombreInstitucion() {
        return nombreInstitucion;
    }

    /**
     * 
     *  column instituciones.nombre_institucion
     *
     * @param nombreInstitucion the value for instituciones.nombre_institucion
     *
     * 
     */
    public void setNombreInstitucion(String nombreInstitucion) {
        this.nombreInstitucion = nombreInstitucion == null ? null : nombreInstitucion.trim();
    }

    /**
     * 
     *column instituciones.direccion
     *
     * @return the value of instituciones.direccion
     *
     * 
     */
    public String getDireccion() {
        return Direccion;
    }

    /**
     * 
     *  column instituciones.direccion
     *
     * @param Direccion the value for instituciones.direccion
     *
     * 
     */
    public void setDireccion(String Direccion) {
        this.Direccion = Direccion == null ? null : Direccion.trim();
    }

    /**
     * 
     *column instituciones.telefono
     *
     * @return the value of instituciones.telefono
     *
     * 
     */
    public String getTelefono() {
        return Telefono;
    }

    /**
     * 
     *  column instituciones.telefono
     *
     * @param Telefono the value for instituciones.telefono
     *
     * 
     */
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono == null ? null : Telefono.trim();
    }

    /**
     * 
     *column instituciones.descripcion
     *
     * @return the value of instituciones.descripcion
     *
     * 
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * 
     *  column instituciones.descripcion
     *
     * @param descripcion the value for instituciones.descripcion
     *
     * 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion == null ? null : descripcion.trim();
    }

	@Override
	public String toString() {
		return nombreInstitucion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((codigoInstitucion == null) ? 0 : codigoInstitucion
						.hashCode());
		result = prime
				* result
				+ ((nombreInstitucion == null) ? 0 : nombreInstitucion
						.hashCode());
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
		Institucion other = (Institucion) obj;
		if (codigoInstitucion == null) {
			if (other.codigoInstitucion != null)
				return false;
		} else if (!codigoInstitucion.equals(other.codigoInstitucion))
			return false;
		if (nombreInstitucion == null) {
			if (other.nombreInstitucion != null)
				return false;
		} else if (!nombreInstitucion.equals(other.nombreInstitucion))
			return false;
		return true;
	}
    
    
}