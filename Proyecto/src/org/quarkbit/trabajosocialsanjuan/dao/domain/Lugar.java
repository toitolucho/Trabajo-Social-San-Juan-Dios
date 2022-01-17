package org.quarkbit.trabajosocialsanjuan.dao.domain;

public class Lugar extends LugarKey implements Comparable<Lugar>{
    /**
     *
     * column lugares.nombre_lugar
     *
     * 
     */
    private String nombreLugar;
    private Provincia provincia;
    

    /**
     * 
     *column lugares.nombre_lugar
     *
     * @return the value of lugares.nombre_lugar
     *
     * 
     */
    public String getNombreLugar() {
        return nombreLugar;
    }

    /**
     * 
     *  column lugares.nombre_lugar
     *
     * @param nombreLugar the value for lugares.nombre_lugar
     *
     * 
     */
    public void setNombreLugar(String nombreLugar) {
        this.nombreLugar = nombreLugar == null ? null : nombreLugar.trim();
    }

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	
	@Override
	public String toString() {
		return nombreLugar;
	}

	@Override
	public int compareTo(Lugar o) {
		// TODO Auto-generated method stub
		return nombreLugar.compareTo(o.nombreLugar);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nombreLugar == null) ? 0 : nombreLugar.hashCode());
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
		Lugar other = (Lugar) obj;
		if (nombreLugar == null) {
			if (other.nombreLugar != null)
				return false;
		} else if (!nombreLugar.equals(other.nombreLugar))
			return false;
		return true;
	}
	
}