package org.quarkbit.trabajosocialsanjuan.dao.domain;

public class Provincia extends ProvinciaKey implements Comparable<Provincia>{
    /**
     *
     * column provincias.nombre_provincia
     *
     * 
     */
    private String nombreProvincia;
    private Departamento departamento;
    
    /**
     * 
     *column provincias.nombre_provincia
     *
     * @return the value of provincias.nombre_provincia
     *
     * 
     */
    public String getNombreProvincia() {
        return nombreProvincia;
    }

    /**
     * 
     *  column provincias.nombre_provincia
     *
     * @param nombreProvincia the value for provincias.nombre_provincia
     *
     * 
     */
    public void setNombreProvincia(String nombreProvincia) {
        this.nombreProvincia = nombreProvincia == null ? null : nombreProvincia.trim();
    }

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	@Override
	public String toString() {
		return nombreProvincia;
	}

	@Override
	public int compareTo(Provincia o) {
		// TODO Auto-generated method stub
		return nombreProvincia.compareTo(o.nombreProvincia);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nombreProvincia == null) ? 0 : nombreProvincia.hashCode());
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
		Provincia other = (Provincia) obj;
		if (nombreProvincia == null) {
			if (other.nombreProvincia != null)
				return false;
		} else if (!nombreProvincia.equals(other.nombreProvincia))
			return false;
		return true;
	}
	
	
}