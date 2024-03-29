package org.quarkbit.trabajosocialsanjuan.dao.domain;

public class PropiedadTipo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column propiedades_tipos.numero_propiedad_tipo
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    private Integer numeroPropiedadTipo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column propiedades_tipos.nombre_propiedad_tipo
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    private String nombrePropiedadTipo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column propiedades_tipos.descripcion
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    private String descripcion;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column propiedades_tipos.numero_propiedad_tipo
     *
     * @return the value of propiedades_tipos.numero_propiedad_tipo
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    public Integer getNumeroPropiedadTipo() {
        return numeroPropiedadTipo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column propiedades_tipos.numero_propiedad_tipo
     *
     * @param numeroPropiedadTipo the value for propiedades_tipos.numero_propiedad_tipo
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    public void setNumeroPropiedadTipo(Integer numeroPropiedadTipo) {
        this.numeroPropiedadTipo = numeroPropiedadTipo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column propiedades_tipos.nombre_propiedad_tipo
     *
     * @return the value of propiedades_tipos.nombre_propiedad_tipo
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    public String getNombrePropiedadTipo() {
        return nombrePropiedadTipo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column propiedades_tipos.nombre_propiedad_tipo
     *
     * @param nombrePropiedadTipo the value for propiedades_tipos.nombre_propiedad_tipo
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    public void setNombrePropiedadTipo(String nombrePropiedadTipo) {
        this.nombrePropiedadTipo = nombrePropiedadTipo == null ? null : nombrePropiedadTipo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column propiedades_tipos.descripcion
     *
     * @return the value of propiedades_tipos.descripcion
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column propiedades_tipos.descripcion
     *
     * @param descripcion the value for propiedades_tipos.descripcion
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion == null ? null : descripcion.trim();
    }

	@Override
	public String toString() {
		return nombrePropiedadTipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((nombrePropiedadTipo == null) ? 0 : nombrePropiedadTipo
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
		PropiedadTipo other = (PropiedadTipo) obj;
		if (nombrePropiedadTipo == null) {
			if (other.nombrePropiedadTipo != null)
				return false;
		} else if (!nombrePropiedadTipo.equals(other.nombrePropiedadTipo))
			return false;
		return true;
	}
    
    
}