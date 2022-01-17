package org.quarkbit.trabajosocialsanjuan.dao.domain;

public class Documento implements Comparable<Documento> {
    /**
     *
     * column documentos.codigo_documento
     *
     * 
     */
    private Integer codigoDocumento;

    /**
     *
     * column documentos.nombre_documento
     *
     * 
     */
    private String nombreDocumento;

    /**
     *
     * column documentos.descripcion
     *
     * 
     */
    private String descripcion;

    /**
     * 
     *column documentos.codigo_documento
     *
     * @return the value of documentos.codigo_documento
     *
     * 
     */
    public Integer getCodigoDocumento() {
        return codigoDocumento;
    }

    /**
     * 
     *  column documentos.codigo_documento
     *
     * @param codigoDocumento the value for documentos.codigo_documento
     *
     * 
     */
    public void setCodigoDocumento(Integer codigoDocumento) {
        this.codigoDocumento = codigoDocumento;
    }

    /**
     * 
     *column documentos.nombre_documento
     *
     * @return the value of documentos.nombre_documento
     *
     * 
     */
    public String getNombreDocumento() {
        return nombreDocumento;
    }

    /**
     * 
     *  column documentos.nombre_documento
     *
     * @param nombreDocumento the value for documentos.nombre_documento
     *
     * 
     */
    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento == null ? null : nombreDocumento.trim();
    }

    /**
     * 
     *column documentos.descripcion
     *
     * @return the value of documentos.descripcion
     *
     * 
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * 
     *  column documentos.descripcion
     *
     * @param descripcion the value for documentos.descripcion
     *
     * 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion == null ? null : descripcion.trim();
    } 

	@Override
	public int compareTo(Documento o) {
		// TODO Auto-generated method stub
		return this.nombreDocumento.compareTo(o.nombreDocumento);
	}
}