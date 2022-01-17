package org.quarkbit.trabajosocialsanjuan.dao.domain;

public class Departamento extends DepartamentoKey implements Comparable<Departamento> {
    /**
     *
     * column departamentos.nombre_departamento
     *
     * 
     */
	
	private Pais pais;
	
    private String nombreDepartamento;

    /**
     * 
     *column departamentos.nombre_departamento
     *
     * @return the value of departamentos.nombre_departamento
     *
     * 
     */
    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    /**
     * 
     *  column departamentos.nombre_departamento
     *
     * @param nombreDepartamento the value for departamentos.nombre_departamento
     *
     * 
     */
    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento == null ? null : nombreDepartamento.trim();
    }

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	@Override
	public String toString() {
		return nombreDepartamento;
	}

	@Override
	public int compareTo(Departamento o) {
		// TODO Auto-generated method stub
		return nombreDepartamento.compareTo(o.nombreDepartamento);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((nombreDepartamento == null) ? 0 : nombreDepartamento
						.hashCode());
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
		Departamento other = (Departamento) obj;
		if (nombreDepartamento == null) {
			if (other.nombreDepartamento != null)
				return false;
		} else if (!nombreDepartamento.equals(other.nombreDepartamento))
			return false;
		return true;
	}
	
	
}