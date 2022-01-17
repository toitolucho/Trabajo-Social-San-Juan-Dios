package org.quarkbit.trabajosocialsanjuan.dao.domain;

public class PersonaKardexFamiliarKey {
    /**
     *
     * column personas_kardex_familiares.codigo_kardex
     *
     * 
     */
    private Integer codigoKardex;

    /**
     *
     * column personas_kardex_familiares.codigo_persona
     *
     * 
     */
    private Integer codigoPersona;

    /**
     * 
     *column personas_kardex_familiares.codigo_kardex
     *
     * @return the value of personas_kardex_familiares.codigo_kardex
     *
     * 
     */
    public Integer getCodigoKardex() {
        return codigoKardex;
    }

    /**
     * 
     *  column personas_kardex_familiares.codigo_kardex
     *
     * @param codigoKardex the value for personas_kardex_familiares.codigo_kardex
     *
     * 
     */
    public void setCodigoKardex(Integer codigoKardex) {
        this.codigoKardex = codigoKardex;
    }

    /**
     * 
     *column personas_kardex_familiares.codigo_persona
     *
     * @return the value of personas_kardex_familiares.codigo_persona
     *
     * 
     */
    public Integer getCodigoPersona() {
        return codigoPersona;
    }

    /**
     * 
     *  column personas_kardex_familiares.codigo_persona
     *
     * @param codigoPersona the value for personas_kardex_familiares.codigo_persona
     *
     * 
     */
    public void setCodigoPersona(Integer codigoPersona) {
        this.codigoPersona = codigoPersona;
    }
}