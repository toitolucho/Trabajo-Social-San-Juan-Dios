package org.quarkbit.trabajosocialsanjuan.dao.persistence;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Documento;
import org.quarkbit.trabajosocialsanjuan.dao.domain.DocumentoExample;

public interface DocumentoMapper {
    /**
     * 
     * table documentos
     *
     * 
     */
    int countByExample(DocumentoExample example);

    /**
     * 
     * table documentos
     *
     * 
     */
    int deleteByExample(DocumentoExample example);

    /**
     * 
     * table documentos
     *
     * 
     */
    int deleteByPrimaryKey(Integer codigoDocumento);

    /**
     * 
     * table documentos
     *
     * 
     */
    int insert(Documento record);

    /**
     * 
     * table documentos
     *
     * 
     */
    int insertSelective(Documento record);

    /**
     * 
     * table documentos
     *
     * 
     */
    List<Documento> selectByExample(DocumentoExample example);

    /**
     * 
     * table documentos
     *
     * 
     */
    Documento selectByPrimaryKey(Integer codigoDocumento);

    /**
     * 
     * table documentos
     *
     * 
     */
    int updateByExampleSelective(@Param("record") Documento record, @Param("example") DocumentoExample example);

    /**
     * 
     * table documentos
     *
     * 
     */
    int updateByExample(@Param("record") Documento record, @Param("example") DocumentoExample example);

    /**
     * 
     * table documentos
     *
     * 
     */
    int updateByPrimaryKeySelective(Documento record);

    /**
     * 
     * table documentos
     *
     * 
     */
    int updateByPrimaryKey(Documento record);
    public int obtenerUltimoId(Map<String, Integer> dato);
}