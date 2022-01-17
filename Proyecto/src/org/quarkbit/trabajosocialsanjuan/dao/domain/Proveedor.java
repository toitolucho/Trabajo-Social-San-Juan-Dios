package org.quarkbit.trabajosocialsanjuan.dao.domain;

public class Proveedor {
    /**
     *
     * column proveedores.codigo_proveedor
     *
     * 
     */
    private Integer codigoProveedor;

    /**
     *
     * column proveedores.nombre_proveedor
     *
     * 
     */
    private String nombreProveedor;

    /**
     *
     * column proveedores.estado_proveedor
     *
     * 
     */
    private String estadoProveedor;

    /**
     *
     * column proveedores.nit_proveedor
     *
     * 
     */
    private String nitProveedor;

    /**
     *
     * column proveedores.descripcion
     *
     * 
     */
    private String descripcion;

    /**
     * 
     *column proveedores.codigo_proveedor
     *
     * @return the value of proveedores.codigo_proveedor
     *
     * 
     */
    public Integer getCodigoProveedor() {
        return codigoProveedor;
    }

    /**
     * 
     *  column proveedores.codigo_proveedor
     *
     * @param codigoProveedor the value for proveedores.codigo_proveedor
     *
     * 
     */
    public void setCodigoProveedor(Integer codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    /**
     * 
     *column proveedores.nombre_proveedor
     *
     * @return the value of proveedores.nombre_proveedor
     *
     * 
     */
    public String getNombreProveedor() {
        return nombreProveedor;
    }

    /**
     * 
     *  column proveedores.nombre_proveedor
     *
     * @param nombreProveedor the value for proveedores.nombre_proveedor
     *
     * 
     */
    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor == null ? null : nombreProveedor.trim();
    }

    /**
     * 
     *column proveedores.estado_proveedor
     *
     * @return the value of proveedores.estado_proveedor
     *
     * 
     */
    public String getEstadoProveedor() {
        return estadoProveedor;
    }

    /**
     * 
     *  column proveedores.estado_proveedor
     *
     * @param estadoProveedor the value for proveedores.estado_proveedor
     *
     * 
     */
    public void setEstadoProveedor(String estadoProveedor) {
        this.estadoProveedor = estadoProveedor == null ? null : estadoProveedor.trim();
    }

    /**
     * 
     *column proveedores.nit_proveedor
     *
     * @return the value of proveedores.nit_proveedor
     *
     * 
     */
    public String getNitProveedor() {
        return nitProveedor;
    }

    /**
     * 
     *  column proveedores.nit_proveedor
     *
     * @param nitProveedor the value for proveedores.nit_proveedor
     *
     * 
     */
    public void setNitProveedor(String nitProveedor) {
        this.nitProveedor = nitProveedor == null ? null : nitProveedor.trim();
    }

    /**
     * 
     *column proveedores.descripcion
     *
     * @return the value of proveedores.descripcion
     *
     * 
     */
    public String getDescripcion() {
        return descripcion;
    }
    public boolean isHabilitado()
    {
    	return estadoProveedor.compareTo("A") == 0;
    }
    
    public String getEstado()
    {
    	return isHabilitado() ? "HABILITADO" : "DESHABILITADO";
    }

	@Override
	public String toString() {
		return nombreProveedor.trim();
	}
    /**
     * 
     *  column proveedores.descripcion
     *
     * @param descripcion the value for proveedores.descripcion
     *
     * 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion == null ? null : descripcion.trim();
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codigoProveedor == null) ? 0 : codigoProveedor.hashCode());
		result = prime * result
				+ ((nombreProveedor == null) ? 0 : nombreProveedor.hashCode());
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
		Proveedor other = (Proveedor) obj;
		if (codigoProveedor == null) {
			if (other.codigoProveedor != null)
				return false;
		} else if (!codigoProveedor.equals(other.codigoProveedor))
			return false;
		if (nombreProveedor == null) {
			if (other.nombreProveedor != null)
				return false;
		} else if (!nombreProveedor.equals(other.nombreProveedor))
			return false;
		return true;
	}
    
    
    
    
}