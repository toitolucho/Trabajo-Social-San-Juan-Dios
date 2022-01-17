package org.quarkbit.trabajosocialsanjuan.dao.domain;

public class Comida {
    /**
     *
     * column comidas.codigo_comida
     *
     * 
     */
    private Integer codigoComida;

    /**
     *
     * column comidas.nombre_comida
     *
     * 
     */
    private String nombreComida;

    /**
     *
     * column comidas.codigo_categoria
     *
     * 
     */
    private Integer codigoCategoria;

    /**
     *
     * column comidas.precio_estimado
     *
     * 
     */
    private Double precioEstimado;

    /**
     *
     * column comidas.descripcion
     *
     * 
     */
    private String descripcion;
    
    
    private CategoriaComida categoriaComida;

    /**
     * 
     *column comidas.codigo_comida
     *
     * @return the value of comidas.codigo_comida
     *
     * 
     */
    public Integer getCodigoComida() {
        return codigoComida;
    }

    /**
     * 
     *  column comidas.codigo_comida
     *
     * @param codigoComida the value for comidas.codigo_comida
     *
     * 
     */
    public void setCodigoComida(Integer codigoComida) {
        this.codigoComida = codigoComida;
    }

    /**
     * 
     *column comidas.nombre_comida
     *
     * @return the value of comidas.nombre_comida
     *
     * 
     */
    public String getNombreComida() {
        return nombreComida;
    }

    /**
     * 
     *  column comidas.nombre_comida
     *
     * @param nombreComida the value for comidas.nombre_comida
     *
     * 
     */
    public void setNombreComida(String nombreComida) {
        this.nombreComida = nombreComida == null ? null : nombreComida.trim();
    }

    /**
     * 
     *column comidas.codigo_categoria
     *
     * @return the value of comidas.codigo_categoria
     *
     * 
     */
    public Integer getCodigoCategoria() {
        return codigoCategoria;
    }

    /**
     * 
     *  column comidas.codigo_categoria
     *
     * @param codigoCategoria the value for comidas.codigo_categoria
     *
     * 
     */
    public void setCodigoCategoria(Integer codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    /**
     * 
     *column comidas.precio_estimado
     *
     * @return the value of comidas.precio_estimado
     *
     * 
     */
    public Double getPrecioEstimado() {
        return precioEstimado;
    }

    /**
     * 
     *  column comidas.precio_estimado
     *
     * @param precioEstimado the value for comidas.precio_estimado
     *
     * 
     */
    public void setPrecioEstimado(Double precioEstimado) {
        this.precioEstimado = precioEstimado;
    }

    /**
     * 
     *column comidas.descripcion
     *
     * @return the value of comidas.descripcion
     *
     * 
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * 
     *  column comidas.descripcion
     *
     * @param descripcion the value for comidas.descripcion
     *
     * 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion == null ? null : descripcion.trim();
    }

	public CategoriaComida getCategoriaComida() {
		return categoriaComida;
	}

	public void setCategoriaComida(CategoriaComida categoriaComida) {
		this.categoriaComida = categoriaComida;
		if(categoriaComida != null)
			this.codigoCategoria = categoriaComida.getCodigoCategoria();
	}

	@Override
	public String toString() {
		return nombreComida;
	}
	
	
	
}