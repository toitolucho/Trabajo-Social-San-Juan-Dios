package org.quarkbit.trabajosocialsanjuan.dao.domain;

public class IngresoTipo {
    /**
     *
     * column ingresos_tipos.codigo_ingreso_tipo
     *
     * 
     */
    private Integer codigoIngresoTipo;

    /**
     *
     * column ingresos_tipos.nombre_ingreso_tipo
     *
     * 
     */
    private String nombreIngresoTipo;

    /**
     *
     * column ingresos_tipos.descripcion
     *
     * 
     */
    private String descripcion;

    /**
     * 
     *column ingresos_tipos.codigo_ingreso_tipo
     *
     * @return the value of ingresos_tipos.codigo_ingreso_tipo
     *
     * 
     */
    public Integer getCodigoIngresoTipo() {
        return codigoIngresoTipo;
    }

    /**
     * 
     *  column ingresos_tipos.codigo_ingreso_tipo
     *
     * @param codigoIngresoTipo the value for ingresos_tipos.codigo_ingreso_tipo
     *
     * 
     */
    public void setCodigoIngresoTipo(Integer codigoIngresoTipo) {
        this.codigoIngresoTipo = codigoIngresoTipo;
    }

    /**
     * 
     *column ingresos_tipos.nombre_ingreso_tipo
     *
     * @return the value of ingresos_tipos.nombre_ingreso_tipo
     *
     * 
     */
    public String getNombreIngresoTipo() {
        return nombreIngresoTipo;
    }

    /**
     * 
     *  column ingresos_tipos.nombre_ingreso_tipo
     *
     * @param nombreIngresoTipo the value for ingresos_tipos.nombre_ingreso_tipo
     *
     * 
     */
    public void setNombreIngresoTipo(String nombreIngresoTipo) {
        this.nombreIngresoTipo = nombreIngresoTipo == null ? null : nombreIngresoTipo.trim();
    }

    /**
     * 
     *column ingresos_tipos.descripcion
     *
     * @return the value of ingresos_tipos.descripcion
     *
     * 
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * 
     *  column ingresos_tipos.descripcion
     *
     * @param descripcion the value for ingresos_tipos.descripcion
     *
     * 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion == null ? null : descripcion.trim();
    }

	@Override
	public String toString() {
		return nombreIngresoTipo ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((nombreIngresoTipo == null) ? 0 : nombreIngresoTipo
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
		IngresoTipo other = (IngresoTipo) obj;
		if (nombreIngresoTipo == null) {
			if (other.nombreIngresoTipo != null)
				return false;
		} else if (!nombreIngresoTipo.equals(other.nombreIngresoTipo))
			return false;
		return true;
	}
    
	
	
    
}