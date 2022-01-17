package org.quarkbit.trabajosocialsanjuan.dao.domain;

import java.util.Date;

public class PersonaKardexDocumento extends PersonaKardexDocumentoKey {
    /**
     *
     * column personas_kardex_documentos.fecha_registro
     *
     * 
     */
    private Date fechaRegistro;

    /**
     *
     * column personas_kardex_documentos.tramito_trab_social
     *
     * 
     */
    private String tramitoTrabSocial;
    
    private Documento documento;

    /**
     * 
     *column personas_kardex_documentos.fecha_registro
     *
     * @return the value of personas_kardex_documentos.fecha_registro
     *
     * 
     */
    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * 
     *  column personas_kardex_documentos.fecha_registro
     *
     * @param fechaRegistro the value for personas_kardex_documentos.fecha_registro
     *
     * 
     */
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * 
     *column personas_kardex_documentos.tramito_trab_social
     *
     * @return the value of personas_kardex_documentos.tramito_trab_social
     *
     * 
     */
    public String getTramitoTrabSocial() {
        return tramitoTrabSocial;
    }

    /**
     * 
     *  column personas_kardex_documentos.tramito_trab_social
     *
     * @param tramitoTrabSocial the value for personas_kardex_documentos.tramito_trab_social
     *
     * 
     */
    public void setTramitoTrabSocial(String tramitoTrabSocial) {
        this.tramitoTrabSocial = tramitoTrabSocial == null ? null : tramitoTrabSocial.trim();
    }

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

}