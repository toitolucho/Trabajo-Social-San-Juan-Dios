package org.quarkbit.trabajosocialsanjuan.dao.domain;



public class Pais implements Comparable<Pais> {
    /**
     *
     * column paises.codigo_pais
     *
     * 
     */
    private String codigoPais;

    /**
     *
     * column paises.nombre_pais
     *
     * 
     */
    private String nombrePais;

    /**
     *
     * column paises.nacionalidad
     *
     * 
     */
    private String nacionalidad;

    /**
     * 
     *column paises.codigo_pais
     *
     * @return the value of paises.codigo_pais
     *
     * 
     */
    public String getCodigoPais() {
        return codigoPais;
    }

    /**
     * 
     *  column paises.codigo_pais
     *
     * @param codigoPais the value for paises.codigo_pais
     *
     * 
     */
    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais == null ? null : codigoPais.trim();
    }

    /**
     * 
     *column paises.nombre_pais
     *
     * @return the value of paises.nombre_pais
     *
     * 
     */
    public String getNombrePais() {
        return nombrePais;
    }

    /**
     * 
     *  column paises.nombre_pais
     *
     * @param nombrePais the value for paises.nombre_pais
     *
     * 
     */
    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais == null ? null : nombrePais.trim();
    }

    /**
     * 
     *column paises.nacionalidad
     *
     * @return the value of paises.nacionalidad
     *
     * 
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * 
     *  column paises.nacionalidad
     *
     * @param nacionalidad the value for paises.nacionalidad
     *
     * 
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad == null ? null : nacionalidad.trim();
    }

	@Override
	public String toString() {
		return nombrePais;
	}

	@Override
	public int compareTo(Pais o) {
		// TODO Auto-generated method stub
		return nombrePais.compareTo(o.nombrePais);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nombrePais == null) ? 0 : nombrePais.hashCode());
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
		Pais other = (Pais) obj;
		if (nombrePais == null) {
			if (other.nombrePais != null)
				return false;
		} else if (!nombrePais.equals(other.nombrePais))
			return false;
		return true;
	}
    
    
}