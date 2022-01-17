package org.quarkbit.trabajosocialsanjuan.dao.persistence;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Institucion;
import org.quarkbit.trabajosocialsanjuan.dao.domain.InstitucionExample;

public interface InstitucionMapper {
    /**
     * 
     * table instituciones
     *
     * 
     */
    int countByExample(InstitucionExample example);

    /**
     * 
     * table instituciones
     *
     * 
     */
    int deleteByExample(InstitucionExample example);

    /**
     * 
     * table instituciones
     *
     * 
     */
    int deleteByPrimaryKey(Integer codigoInstitucion);

    /**
     * 
     * table instituciones
     *
     * 
     */
    int insert(Institucion record);

    /**
     * 
     * table instituciones
     *
     * 
     */
    int insertSelective(Institucion record);

    /**
     * 
     * table instituciones
     *
     * 
     */
    List<Institucion> selectByExample(InstitucionExample example);

    /**
     * 
     * table instituciones
     *
     * 
     */
    Institucion selectByPrimaryKey(Integer codigoInstitucion);

    /**
     * 
     * table instituciones
     *
     * 
     */
    int updateByExampleSelective(@Param("record") Institucion record, @Param("example") InstitucionExample example);

    /**
     * 
     * table instituciones
     *
     * 
     */
    int updateByExample(@Param("record") Institucion record, @Param("example") InstitucionExample example);

    /**
     * 
     * table instituciones
     *
     * 
     */
    int updateByPrimaryKeySelective(Institucion record);

    /**
     * 
     * table instituciones
     *
     * 
     */
    int updateByPrimaryKey(Institucion record);
    
    public int obtenerUltimoId(Map<String, Integer> dato);
}