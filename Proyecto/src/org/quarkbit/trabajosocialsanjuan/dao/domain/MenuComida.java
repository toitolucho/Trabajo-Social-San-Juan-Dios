package org.quarkbit.trabajosocialsanjuan.dao.domain;

import java.util.Date;

public class MenuComida {
    /**
     *
     * column menus_comidas.codigo_menu_comida
     *
     * 
     */
    private Integer codigoMenuComida;

    /**
     *
     * column menus_comidas.nombre_menu
     *
     * 
     */
    private String nombreMenu;

    /**
     *
     * column menus_comidas.fecha_inicio
     *
     * 
     */
    private Date fechaInicio;

    /**
     *
     * column menus_comidas.fecha_fin
     *
     * 
     */
    private Date fechaFin;

    /**
     *
     * column menus_comidas.fecha_registro
     *
     * 
     */
    private Date fechaRegistro;

    /**
     *
     * column menus_comidas.codigo_usuario
     *
     * 
     */
    private Integer codigoUsuario;

    /**
     *
     * column menus_comidas.codigo_estado
     *
     * 
     */
    private String codigoEstado;

    /**
     *
     * column menus_comidas.monto_total
     *
     * 
     */
    private Double montoTotal;

    /**
     *
     * column menus_comidas.observaciones
     *
     * 
     */
    private String observaciones;

    /**
     * 
     *column menus_comidas.codigo_menu_comida
     *
     * @return the value of menus_comidas.codigo_menu_comida
     *
     * 
     */
    public Integer getCodigoMenuComida() {
        return codigoMenuComida;
    }

    /**
     * 
     *  column menus_comidas.codigo_menu_comida
     *
     * @param codigoMenuComida the value for menus_comidas.codigo_menu_comida
     *
     * 
     */
    public void setCodigoMenuComida(Integer codigoMenuComida) {
        this.codigoMenuComida = codigoMenuComida;
    }

    /**
     * 
     *column menus_comidas.nombre_menu
     *
     * @return the value of menus_comidas.nombre_menu
     *
     * 
     */
    public String getNombreMenu() {
        return nombreMenu;
    }

    /**
     * 
     *  column menus_comidas.nombre_menu
     *
     * @param nombreMenu the value for menus_comidas.nombre_menu
     *
     * 
     */
    public void setNombreMenu(String nombreMenu) {
        this.nombreMenu = nombreMenu == null ? null : nombreMenu.trim();
    }

    /**
     * 
     *column menus_comidas.fecha_inicio
     *
     * @return the value of menus_comidas.fecha_inicio
     *
     * 
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * 
     *  column menus_comidas.fecha_inicio
     *
     * @param fechaInicio the value for menus_comidas.fecha_inicio
     *
     * 
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * 
     *column menus_comidas.fecha_fin
     *
     * @return the value of menus_comidas.fecha_fin
     *
     * 
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * 
     *  column menus_comidas.fecha_fin
     *
     * @param fechaFin the value for menus_comidas.fecha_fin
     *
     * 
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * 
     *column menus_comidas.fecha_registro
     *
     * @return the value of menus_comidas.fecha_registro
     *
     * 
     */
    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * 
     *  column menus_comidas.fecha_registro
     *
     * @param fechaRegistro the value for menus_comidas.fecha_registro
     *
     * 
     */
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * 
     *column menus_comidas.codigo_usuario
     *
     * @return the value of menus_comidas.codigo_usuario
     *
     * 
     */
    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    /**
     * 
     *  column menus_comidas.codigo_usuario
     *
     * @param codigoUsuario the value for menus_comidas.codigo_usuario
     *
     * 
     */
    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    /**
     * 
     *column menus_comidas.codigo_estado
     *
     * @return the value of menus_comidas.codigo_estado
     *
     * 
     */
    public String getCodigoEstado() {
        return codigoEstado;
    }

    /**
     * 
     *  column menus_comidas.codigo_estado
     *
     * @param codigoEstado the value for menus_comidas.codigo_estado
     *
     * 
     */
    public void setCodigoEstado(String codigoEstado) {
        this.codigoEstado = codigoEstado == null ? null : codigoEstado.trim();
    }

    /**
     * 
     *column menus_comidas.monto_total
     *
     * @return the value of menus_comidas.monto_total
     *
     * 
     */
    public Double getMontoTotal() {
        return montoTotal;
    }

    /**
     * 
     *  column menus_comidas.monto_total
     *
     * @param montoTotal the value for menus_comidas.monto_total
     *
     * 
     */
    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    /**
     * 
     *column menus_comidas.observaciones
     *
     * @return the value of menus_comidas.observaciones
     *
     * 
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * 
     *  column menus_comidas.observaciones
     *
     * @param observaciones the value for menus_comidas.observaciones
     *
     * 
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones == null ? null : observaciones.trim();
    }
}