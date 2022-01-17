package org.quarkbit.trabajosocialsanjuan.dao.persistence;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Pais;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PaisExample;

public interface PaisMapper {
    /**
     * 
     * table paises
     *
     * 
     */
    int countByExample(PaisExample example);

    /**
     * 
     * table paises
     *
     * 
     */
    int deleteByExample(PaisExample example);

    /**
     * 
     * table paises
     *
     * 
     */
    int deleteByPrimaryKey(String codigoPais);

    /**
     * 
     * table paises
     *
     * 
     */
    int insert(Pais record);

    /**
     * 
     * table paises
     *
     * 
     */
    int insertSelective(Pais record);

    /**
     * 
     * table paises
     *
     * 
     */
    List<Pais> selectByExample(PaisExample example);

    /**
     * 
     * table paises
     *
     * 
     */
    Pais selectByPrimaryKey(String codigoPais);

    /**
     * 
     * table paises
     *
     * 
     */
    int updateByExampleSelective(@Param("record") Pais record, @Param("example") PaisExample example);

    /**
     * 
     * table paises
     *
     * 
     */
    int updateByExample(@Param("record") Pais record, @Param("example") PaisExample example);

    /**
     * 
     * table paises
     *
     * 
     */
    int updateByPrimaryKeySelective(Pais record);

    /**
     * 
     * table paises
     *
     * 
     */
    int updateByPrimaryKey(Pais record);
    
    public int obtenerCodigoGeografico(Map<String, String> dato);
}