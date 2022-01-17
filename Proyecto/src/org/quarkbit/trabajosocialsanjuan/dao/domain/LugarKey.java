package org.quarkbit.trabajosocialsanjuan.dao.domain;

public class LugarKey {
    /**
     *
     * column lugares.codigo_pais
     *
     * 
     */
    private String codigoPais;

    /**
     *
     * column lugares.codigo_departamento
     *
     * 
     */
    private String codigoDepartamento;

    /**
     *
     * column lugares.codigo_provincia
     *
     * 
     */
    private String codigoProvincia;

    /**
     *
     * column lugares.codigo_lugar
     *
     * 
     */
    private String codigoLugar;

    /**
     * 
     *column lugares.codigo_pais
     *
     * @return the value of lugares.codigo_pais
     *
     * 
     */
    public String getCodigoPais() {
        return codigoPais;
    }

    /**
     * 
     *  column lugares.codigo_pais
     *
     * @param codigoPais the value for lugares.codigo_pais
     *
     * 
     */
    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais == null ? null : codigoPais.trim();
    }

    /**
     * 
     *column lugares.codigo_departamento
     *
     * @return the value of lugares.codigo_departamento
     *
     * 
     */
    public String getCodigoDepartamento() {
        return codigoDepartamento;
    }

    /**
     * 
     *  column lugares.codigo_departamento
     *
     * @param codigoDepartamento the value for lugares.codigo_departamento
     *
     * 
     */
    public void setCodigoDepartamento(String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento == null ? null : codigoDepartamento.trim();
    }

    /**
     * 
     *column lugares.codigo_provincia
     *
     * @return the value of lugares.codigo_provincia
     *
     * 
     */
    public String getCodigoProvincia() {
        return codigoProvincia;
    }

    /**
     * 
     *  column lugares.codigo_provincia
     *
     * @param codigoProvincia the value for lugares.codigo_provincia
     *
     * 
     */
    public void setCodigoProvincia(String codigoProvincia) {
        this.codigoProvincia = codigoProvincia == null ? null : codigoProvincia.trim();
    }

    /**
     * 
     *column lugares.codigo_lugar
     *
     * @return the value of lugares.codigo_lugar
     *
     * 
     */
    public String getCodigoLugar() {
        return codigoLugar;
    }

    /**
     * 
     *  column lugares.codigo_lugar
     *
     * @param codigoLugar the value for lugares.codigo_lugar
     *
     * 
     */
    public void setCodigoLugar(String codigoLugar) {
        this.codigoLugar = codigoLugar == null ? null : codigoLugar.trim();
    }
}