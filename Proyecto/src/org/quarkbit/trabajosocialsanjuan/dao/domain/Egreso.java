package org.quarkbit.trabajosocialsanjuan.dao.domain;

import java.util.Date;
import java.util.List;

public class Egreso {
    /**
     *
     * column egresos.codigo_egreso
     *
     * 
     */
    private Integer codigoEgreso;

    /**
     *
     * column egresos.fecha_egreso
     *
     * 
     */
    private Date fechaEgreso;

    /**
     *
     * column egresos.codigo_usuario
     *
     * 
     */
    private Integer codigoUsuario;

    /**
     *
     * column egresos.codigo_partida
     *
     * 
     */
    private String codigoPartida;

    /**
     *
     * column egresos.codigo_ingreso
     *
     * 
     */
    private Integer codigoIngreso;

    /**
     *
     * column egresos.fecha_registro
     *
     * 
     */
    private Date fechaRegistro;

    /**
     *
     * column egresos.nro_factura
     *
     * 
     */
    private Integer nroFactura;

    /**
     *
     * column egresos.codigo_proveedor
     *
     * 
     */
    private Integer codigo_proveedor;

    /**
     *
     * column egresos.monto_salida
     *
     * 
     */
    private Double montoSalida;

    /**
     *
     * column egresos.observaciones
     *
     * 
     */
    private String observaciones;
    
    private Proveedor proveedor;
    private Ingreso ingreso;
    private Partida partida;
    

    /**
     * 
     *column egresos.codigo_egreso
     *
     * @return the value of egresos.codigo_egreso
     *
     * 
     */
    public Integer getCodigoEgreso() {
        return codigoEgreso;
    }

    /**
     * 
     *  column egresos.codigo_egreso
     *
     * @param codigoEgreso the value for egresos.codigo_egreso
     *
     * 
     */
    public void setCodigoEgreso(Integer codigoEgreso) {
        this.codigoEgreso = codigoEgreso;
    }

    /**
     * 
     *column egresos.fecha_egreso
     *
     * @return the value of egresos.fecha_egreso
     *
     * 
     */
    public Date getFechaEgreso() {
        return fechaEgreso;
    }

    /**
     * 
     *  column egresos.fecha_egreso
     *
     * @param fechaEgreso the value for egresos.fecha_egreso
     *
     * 
     */
    public void setFechaEgreso(Date fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

    /**
     * 
     *column egresos.codigo_usuario
     *
     * @return the value of egresos.codigo_usuario
     *
     * 
     */
    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    /**
     * 
     *  column egresos.codigo_usuario
     *
     * @param codigoUsuario the value for egresos.codigo_usuario
     *
     * 
     */
    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    /**
     * 
     *column egresos.codigo_partida
     *
     * @return the value of egresos.codigo_partida
     *
     * 
     */
    public String getCodigoPartida() {
        return codigoPartida;
    }

    /**
     * 
     *  column egresos.codigo_partida
     *
     * @param codigoPartida the value for egresos.codigo_partida
     *
     * 
     */
    public void setCodigoPartida(String codigoPartida) {
        this.codigoPartida = codigoPartida == null ? null : codigoPartida.trim();
    }

    /**
     * 
     *column egresos.codigo_ingreso
     *
     * @return the value of egresos.codigo_ingreso
     *
     * 
     */
    public Integer getCodigoIngreso() {
        return codigoIngreso;
    }

    /**
     * 
     *  column egresos.codigo_ingreso
     *
     * @param codigoIngreso the value for egresos.codigo_ingreso
     *
     * 
     */
    public void setCodigoIngreso(Integer codigoIngreso) {
        this.codigoIngreso = codigoIngreso;
    }

    /**
     * 
     *column egresos.fecha_registro
     *
     * @return the value of egresos.fecha_registro
     *
     * 
     */
    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * 
     *  column egresos.fecha_registro
     *
     * @param fechaRegistro the value for egresos.fecha_registro
     *
     * 
     */
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * 
     *column egresos.nro_factura
     *
     * @return the value of egresos.nro_factura
     *
     * 
     */
    public Integer getNroFactura() {
        return nroFactura;
    }

    /**
     * 
     *  column egresos.nro_factura
     *
     * @param nroFactura the value for egresos.nro_factura
     *
     * 
     */
    public void setNroFactura(Integer nroFactura) {
        this.nroFactura = nroFactura;
    }

    /**
     * 
     *column egresos.codigo_proveedor
     *
     * @return the value of egresos.codigo_proveedor
     *
     * 
     */
    public Integer getCodigo_proveedor() {
        return codigo_proveedor;
    }

    /**
     * 
     *  column egresos.codigo_proveedor
     *
     * @param codigo_proveedor the value for egresos.codigo_proveedor
     *
     * 
     */
    public void setCodigo_proveedor(Integer codigo_proveedor) {
        this.codigo_proveedor = codigo_proveedor;
    }

    /**
     * 
     *column egresos.monto_salida
     *
     * @return the value of egresos.monto_salida
     *
     * 
     */
    public Double getMontoSalida() {
        return montoSalida;
    }

    /**
     * 
     *  column egresos.monto_salida
     *
     * @param montoSalida the value for egresos.monto_salida
     *
     * 
     */
    public void setMontoSalida(Double montoSalida) {
        this.montoSalida = montoSalida;
    }

    /**
     * 
     *column egresos.observaciones
     *
     * @return the value of egresos.observaciones
     *
     * 
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * 
     *  column egresos.observaciones
     *
     * @param observaciones the value for egresos.observaciones
     *
     * 
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones == null ? null : observaciones.trim();
    }

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Ingreso getIngreso() {
		return ingreso;
	}

	public void setIngreso(Ingreso ingreso) {
		this.ingreso = ingreso;
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}
}