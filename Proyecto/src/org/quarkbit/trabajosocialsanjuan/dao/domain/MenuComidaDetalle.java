package org.quarkbit.trabajosocialsanjuan.dao.domain;

import java.util.Date;

public class MenuComidaDetalle {
    /**
     *
     * column menus_comidas_detalle.codigo_menu_comida_detalle
     *
     * 
     */
    private Integer codigoMenuComidaDetalle;

    /**
     *
     * column menus_comidas_detalle.codigo_menu_comida
     *
     * 
     */
    private Integer codigoMenuComida;

    /**
     *
     * column menus_comidas_detalle.codigo_comida
     *
     * 
     */
    private Integer codigoComida;

    /**
     *
     * column menus_comidas_detalle.codigo_categoria
     *
     * 
     */
    private Integer codigoCategoria;

    /**
     *
     * column menus_comidas_detalle.fecha
     *
     * 
     */
    private Date fecha;

    /**
     *
     * column menus_comidas_detalle.hora_inicio
     *
     * 
     */
    private Date horaInicio;

    /**
     *
     * column menus_comidas_detalle.hora_fin
     *
     * 
     */
    private Date horaFin;

    /**
     *
     * column menus_comidas_detalle.cantidad_personas
     *
     * 
     */
    private Integer cantidadPersonas;

    /**
     *
     * column menus_comidas_detalle.precio_unitario
     *
     * 
     */
    private Double precioUnitario;
    
    
    private Comida comida;
    private CategoriaComida categoriaComida;
    
    
    
    

    /**
     * 
     *column menus_comidas_detalle.codigo_menu_comida_detalle
     *
     * @return the value of menus_comidas_detalle.codigo_menu_comida_detalle
     *
     * 
     */
    public Integer getCodigoMenuComidaDetalle() {
        return codigoMenuComidaDetalle;
    }

    /**
     * 
     *  column menus_comidas_detalle.codigo_menu_comida_detalle
     *
     * @param codigoMenuComidaDetalle the value for menus_comidas_detalle.codigo_menu_comida_detalle
     *
     * 
     */
    public void setCodigoMenuComidaDetalle(Integer codigoMenuComidaDetalle) {
        this.codigoMenuComidaDetalle = codigoMenuComidaDetalle;
    }

    /**
     * 
     *column menus_comidas_detalle.codigo_menu_comida
     *
     * @return the value of menus_comidas_detalle.codigo_menu_comida
     *
     * 
     */
    public Integer getCodigoMenuComida() {
        return codigoMenuComida;
    }

    /**
     * 
     *  column menus_comidas_detalle.codigo_menu_comida
     *
     * @param codigoMenuComida the value for menus_comidas_detalle.codigo_menu_comida
     *
     * 
     */
    public void setCodigoMenuComida(Integer codigoMenuComida) {
        this.codigoMenuComida = codigoMenuComida;
    }

    /**
     * 
     *column menus_comidas_detalle.codigo_comida
     *
     * @return the value of menus_comidas_detalle.codigo_comida
     *
     * 
     */
    public Integer getCodigoComida() {
        return codigoComida;
    }

    /**
     * 
     *  column menus_comidas_detalle.codigo_comida
     *
     * @param codigoComida the value for menus_comidas_detalle.codigo_comida
     *
     * 
     */
    public void setCodigoComida(Integer codigoComida) {
        this.codigoComida = codigoComida;
    }

    /**
     * 
     *column menus_comidas_detalle.codigo_categoria
     *
     * @return the value of menus_comidas_detalle.codigo_categoria
     *
     * 
     */
    public Integer getCodigoCategoria() {
        return codigoCategoria;
    }

    /**
     * 
     *  column menus_comidas_detalle.codigo_categoria
     *
     * @param codigoCategoria the value for menus_comidas_detalle.codigo_categoria
     *
     * 
     */
    public void setCodigoCategoria(Integer codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    /**
     * 
     *column menus_comidas_detalle.fecha
     *
     * @return the value of menus_comidas_detalle.fecha
     *
     * 
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * 
     *  column menus_comidas_detalle.fecha
     *
     * @param fecha the value for menus_comidas_detalle.fecha
     *
     * 
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * 
     *column menus_comidas_detalle.hora_inicio
     *
     * @return the value of menus_comidas_detalle.hora_inicio
     *
     * 
     */
    public Date getHoraInicio() {
        return horaInicio;
    }

    /**
     * 
     *  column menus_comidas_detalle.hora_inicio
     *
     * @param horaInicio the value for menus_comidas_detalle.hora_inicio
     *
     * 
     */
    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * 
     *column menus_comidas_detalle.hora_fin
     *
     * @return the value of menus_comidas_detalle.hora_fin
     *
     * 
     */
    public Date getHoraFin() {
        return horaFin;
    }

    /**
     * 
     *  column menus_comidas_detalle.hora_fin
     *
     * @param horaFin the value for menus_comidas_detalle.hora_fin
     *
     * 
     */
    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    /**
     * 
     *column menus_comidas_detalle.cantidad_personas
     *
     * @return the value of menus_comidas_detalle.cantidad_personas
     *
     * 
     */
    public Integer getCantidadPersonas() {
        return cantidadPersonas;
    }

    /**
     * 
     *  column menus_comidas_detalle.cantidad_personas
     *
     * @param cantidadPersonas the value for menus_comidas_detalle.cantidad_personas
     *
     * 
     */
    public void setCantidadPersonas(Integer cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    /**
     * 
     *column menus_comidas_detalle.precio_unitario
     *
     * @return the value of menus_comidas_detalle.precio_unitario
     *
     * 
     */
    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     * 
     *  column menus_comidas_detalle.precio_unitario
     *
     * @param precioUnitario the value for menus_comidas_detalle.precio_unitario
     *
     * 
     */
    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

	public Comida getComida() {
		return comida;
	}

	public void setComida(Comida comida) {
		this.comida = comida;
	}

	public CategoriaComida getCategoriaComida() {
		return categoriaComida;
	}

	public void setCategoriaComida(CategoriaComida categoriaComida) {
		this.categoriaComida = categoriaComida;
	}

	@Override
	public String toString() {
		return comida.toString();
	}
	
	
	public double getPrecioTotal()
	{
		return cantidadPersonas * precioUnitario;
	}
	
}