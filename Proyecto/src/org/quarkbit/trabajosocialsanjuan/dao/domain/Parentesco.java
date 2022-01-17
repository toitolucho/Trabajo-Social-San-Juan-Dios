package org.quarkbit.trabajosocialsanjuan.dao.domain;

public class Parentesco {
    /**
     *
     * column parentescos.codigo_parentesco
     *
     * 
     */
    private Integer codigoParentesco;

    /**
     *
     * column parentescos.nombre_parentesco
     *
     * 
     */
    private String nombreParentesco;

    /**
     *
     * column parentescos.descripcion
     *
     * 
     */
    private String descripcion;

    /**
     * 
     *column parentescos.codigo_parentesco
     *
     * @return the value of parentescos.codigo_parentesco
     *
     * 
     */
    public Integer getCodigoParentesco() {
        return codigoParentesco;
    }

    /**
     * 
     *  column parentescos.codigo_parentesco
     *
     * @param codigoParentesco the value for parentescos.codigo_parentesco
     *
     * 
     */
    public void setCodigoParentesco(Integer codigoParentesco) {
        this.codigoParentesco = codigoParentesco;
    }

    /**
     * 
     *column parentescos.nombre_parentesco
     *
     * @return the value of parentescos.nombre_parentesco
     *
     * 
     */
    public String getNombreParentesco() {
        return nombreParentesco;
    }

    /**
     * 
     *  column parentescos.nombre_parentesco
     *
     * @param nombreParentesco the value for parentescos.nombre_parentesco
     *
     * 
     */
    public void setNombreParentesco(String nombreParentesco) {
        this.nombreParentesco = nombreParentesco == null ? null : nombreParentesco.trim();
    }

    /**
     * 
     *column parentescos.descripcion
     *
     * @return the value of parentescos.descripcion
     *
     * 
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * 
     *  column parentescos.descripcion
     *
     * @param descripcion the value for parentescos.descripcion
     *
     * 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion == null ? null : descripcion.trim();
    }

	@Override
	public String toString() {
		return nombreParentesco;
	}
    
    
}