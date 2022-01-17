package org.quarkbit.trabajosocialsanjuan.dao.domain;

public class DepartamentoKey {
    /**
     *
     * column departamentos.codigo_pais
     *
     * 
     */
    private String codigoPais;

    /**
     *
     * column departamentos.codigo_departamento
     *
     * 
     */
    private String codigoDepartamento;

    /**
     * 
     *column departamentos.codigo_pais
     *
     * @return the value of departamentos.codigo_pais
     *
     * 
     */
    public String getCodigoPais() {
        return codigoPais;
    }

    /**
     * 
     *  column departamentos.codigo_pais
     *
     * @param codigoPais the value for departamentos.codigo_pais
     *
     * 
     */
    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais == null ? null : codigoPais.trim();
    }

    /**
     * 
     *column departamentos.codigo_departamento
     *
     * @return the value of departamentos.codigo_departamento
     *
     * 
     */
    public String getCodigoDepartamento() {
        return codigoDepartamento;
    }

    /**
     * 
     *  column departamentos.codigo_departamento
     *
     * @param codigoDepartamento the value for departamentos.codigo_departamento
     *
     * 
     */
    public void setCodigoDepartamento(String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento == null ? null : codigoDepartamento.trim();
    }
}