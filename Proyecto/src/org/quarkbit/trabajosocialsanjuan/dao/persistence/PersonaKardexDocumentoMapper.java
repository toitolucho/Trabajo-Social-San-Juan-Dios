package org.quarkbit.trabajosocialsanjuan.dao.persistence;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PersonaKardexDocumento;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PersonaKardexDocumentoExample;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PersonaKardexDocumentoKey;

public interface PersonaKardexDocumentoMapper {
    /**
     * 
     * table personas_kardex_documentos
     *
     * 
     */
    int countByExample(PersonaKardexDocumentoExample example);

    /**
     * 
     * table personas_kardex_documentos
     *
     * 
     */
    int deleteByExample(PersonaKardexDocumentoExample example);

    /**
     * 
     * table personas_kardex_documentos
     *
     * 
     */
    int deleteByPrimaryKey(PersonaKardexDocumentoKey key);

    /**
     * 
     * table personas_kardex_documentos
     *
     * 
     */
    int insert(PersonaKardexDocumento record);

    /**
     * 
     * table personas_kardex_documentos
     *
     * 
     */
    int insertSelective(PersonaKardexDocumento record);

    /**
     * 
     * table personas_kardex_documentos
     *
     * 
     */
    List<PersonaKardexDocumento> selectByExample(PersonaKardexDocumentoExample example);

    /**
     * 
     * table personas_kardex_documentos
     *
     * 
     */
    PersonaKardexDocumento selectByPrimaryKey(PersonaKardexDocumentoKey key);

    /**
     * 
     * table personas_kardex_documentos
     *
     * 
     */
    int updateByExampleSelective(@Param("record") PersonaKardexDocumento record, @Param("example") PersonaKardexDocumentoExample example);

    /**
     * 
     * table personas_kardex_documentos
     *
     * 
     */
    int updateByExample(@Param("record") PersonaKardexDocumento record, @Param("example") PersonaKardexDocumentoExample example);

    /**
     * 
     * table personas_kardex_documentos
     *
     * 
     */
    int updateByPrimaryKeySelective(PersonaKardexDocumento record);

    /**
     * 
     * table personas_kardex_documentos
     *
     * 
     */
    int updateByPrimaryKey(PersonaKardexDocumento record);
}