package org.quarkbit.trabajosocialsanjuan.dao.domain;

public class ProvinciaKey {
    /**
     *
     * column provincias.codigo_pais
     *
     * 
     */
    private String codigoPais;

    /**
     *
     * column provincias.codigo_departamento
     *
     * 
     */
    private String codigoDepartamento;

    /**
     *
     * column provincias.codigo_provincia
     *
     * 
     */
    private String codigoProvincia;

    /**
     * 
     *column provincias.codigo_pais
     *
     * @return the value of provincias.codigo_pais
     *
     * 
     */
    public String getCodigoPais() {
        return codigoPais;
    }

    /**
     * 
     *  column provincias.codigo_pais
     *
     * @param codigoPais the value for provincias.codigo_pais
     *
     * 
     */
    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais == null ? null : codigoPais.trim();
    }

    /**
     * 
     *column provincias.codigo_departamento
     *
     * @return the value of provincias.codigo_departamento
     *
     * 
     */
    public String getCodigoDepartamento() {
        return codigoDepartamento;
    }

    /**
     * 
     *  column provincias.codigo_departamento
     *
     * @param codigoDepartamento the value for provincias.codigo_departamento
     *
     * 
     */
    public void setCodigoDepartamento(String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento == null ? null : codigoDepartamento.trim();
    }

    /**
     * 
     *column provincias.codigo_provincia
     *
     * @return the value of provincias.codigo_provincia
     *
     * 
     */
    public String getCodigoProvincia() {
        return codigoProvincia;
    }

    /**
     * 
     *  column provincias.codigo_provincia
     *
     * @param codigoProvincia the value for provincias.codigo_provincia
     *
     * 
     */
    public void setCodigoProvincia(String codigoProvincia) {
        this.codigoProvincia = codigoProvincia == null ? null : codigoProvincia.trim();
    }
}