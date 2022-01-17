package org.quarkbit.trabajosocialsanjuan.dao.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.quarkbit.trabajosocialsanjuan.utils.FJTree.Element;

public class Partida {
    /**
     *
     * column partidas.codigo_partida
     *
     * 
     */
    private String codigoPartida;

    /**
     *
     * column partidas.codigo_partida_padre
     *
     * 
     */
    private String codigoPartidaPadre;

    /**
     *
     * column partidas.nombre_partida
     *
     * 
     */
    private String nombrePartida;

    /**
     *
     * column partidas.descripcion_partida
     *
     * 
     */
    private String descripcion;
    
    private Partida partidaPadre;
    private Collection<Partida> partidas = new  ArrayList<Partida>();

    /**
     * 
     *column partidas.codigo_partida
     *
     * @return the value of partidas.codigo_partida
     *
     * 
     */
    public String getCodigoPartida() {
        return codigoPartida;
    }

    /**
     * 
     *  column partidas.codigo_partida
     *
     * @param codigoPartida the value for partidas.codigo_partida
     *
     * 
     */
    public void setCodigoPartida(String codigoPartida) {
        this.codigoPartida = codigoPartida == null ? null : codigoPartida.trim();
    }

    /**
     * 
     *column partidas.codigo_partida_padre
     *
     * @return the value of partidas.codigo_partida_padre
     *
     * 
     */
    public String getCodigoPartidaPadre() {
        return codigoPartidaPadre;
    }

    /**
     * 
     *  column partidas.codigo_partida_padre
     *
     * @param codigoPartidaPadre the value for partidas.codigo_partida_padre
     *
     * 
     */
    public void setCodigoPartidaPadre(String codigoPartidaPadre) {
        this.codigoPartidaPadre = codigoPartidaPadre == null ? null : codigoPartidaPadre.trim();
    }

    /**
     * 
     *column partidas.nombre_partida
     *
     * @return the value of partidas.nombre_partida
     *
     * 
     */
    public String getNombrePartida() {
        return nombrePartida;
    }

    /**
     * 
     *  column partidas.nombre_partida
     *
     * @param nombrePartida the value for partidas.nombre_partida
     *
     * 
     */
    public void setNombrePartida(String nombrePartida) {
        this.nombrePartida = nombrePartida == null ? null : nombrePartida.trim();
    }

    /**
     * 
     *column partidas.descripcion_partida
     *
     * @return the value of partidas.descripcion_partida
     *
     * 
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * 
     *  column partidas.descripcion_partida
     *
     * @param descripcion the value for partidas.descripcion_partida
     *
     * 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion == null ? null : descripcion.trim();
    }

	public Partida getPartidaPadre() {
		return partidaPadre;
	}

	public void setPartidaPadre(Partida partidaPadre) {
		
		this.partidaPadre = partidaPadre;
//		if(partidaPadre != null)
//			this.codigoPartidaPadre = partidaPadre.getCodigoPartida();
	}

	@Override
	public String toString() {
		return codigoPartida.trim() + " - " +  nombrePartida.trim();
	}

	public Collection<Partida> getPartidas() {
		return partidas;
	}

	public void setPartidas(Collection<Partida> partidas) {
		this.partidas = partidas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nombrePartida == null) ? 0 : nombrePartida.hashCode());
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
		Partida other = (Partida) obj;
		if (nombrePartida == null) {
			if (other.nombrePartida != null)
				return false;
		} else if (!nombrePartida.equals(other.nombrePartida))
			return false;
		return true;
	}

	
	
	
    
    
}