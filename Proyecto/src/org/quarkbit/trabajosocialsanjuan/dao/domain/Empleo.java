package org.quarkbit.trabajosocialsanjuan.dao.domain;

public class Empleo {
    /**
     *
     * column empleos.codigo_empleo
     *
     * 
     */
    private Integer codigoEmpleo;

    /**
     *
     * column empleos.nombre_empleo
     *
     * 
     */
    private String nombreEmpleo;

    /**
     *
     * column empleos.descripcion
     *
     * 
     */
    private String descripcion;

    /**
     * 
     *column empleos.codigo_empleo
     *
     * @return the value of empleos.codigo_empleo
     *
     * 
     */
    public Integer getCodigoEmpleo() {
        return codigoEmpleo;
    }

    /**
     * 
     *  column empleos.codigo_empleo
     *
     * @param codigoEmpleo the value for empleos.codigo_empleo
     *
     * 
     */
    public void setCodigoEmpleo(Integer codigoEmpleo) {
        this.codigoEmpleo = codigoEmpleo;
    }

    /**
     * 
     *column empleos.nombre_empleo
     *
     * @return the value of empleos.nombre_empleo
     *
     * 
     */
    public String getNombreEmpleo() {
        return nombreEmpleo;
    }

    /**
     * 
     *  column empleos.nombre_empleo
     *
     * @param nombreEmpleo the value for empleos.nombre_empleo
     *
     * 
     */
    public void setNombreEmpleo(String nombreEmpleo) {
        this.nombreEmpleo = nombreEmpleo == null ? null : nombreEmpleo.trim();
    }

    /**
     * 
     *column empleos.descripcion
     *
     * @return the value of empleos.descripcion
     *
     * 
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * 
     *  column empleos.descripcion
     *
     * @param descripcion the value for empleos.descripcion
     *
     * 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion == null ? null : descripcion.trim();
    }

	@Override
	public String toString() {
		return nombreEmpleo;
	}
    
    
}