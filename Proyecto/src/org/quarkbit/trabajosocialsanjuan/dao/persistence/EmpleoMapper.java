package org.quarkbit.trabajosocialsanjuan.dao.persistence;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Empleo;
import org.quarkbit.trabajosocialsanjuan.dao.domain.EmpleoExample;

public interface EmpleoMapper {
    /**
     * 
     * table empleos
     *
     * 
     */
    int countByExample(EmpleoExample example);

    /**
     * 
     * table empleos
     *
     * 
     */
    int deleteByExample(EmpleoExample example);

    /**
     * 
     * table empleos
     *
     * 
     */
    int deleteByPrimaryKey(Integer codigoEmpleo);

    /**
     * 
     * table empleos
     *
     * 
     */
    int insert(Empleo record);

    /**
     * 
     * table empleos
     *
     * 
     */
    int insertSelective(Empleo record);

    /**
     * 
     * table empleos
     *
     * 
     */
    List<Empleo> selectByExample(EmpleoExample example);

    /**
     * 
     * table empleos
     *
     * 
     */
    Empleo selectByPrimaryKey(Integer codigoEmpleo);

    /**
     * 
     * table empleos
     *
     * 
     */
    int updateByExampleSelective(@Param("record") Empleo record, @Param("example") EmpleoExample example);

    /**
     * 
     * table empleos
     *
     * 
     */
    int updateByExample(@Param("record") Empleo record, @Param("example") EmpleoExample example);

    /**
     * 
     * table empleos
     *
     * 
     */
    int updateByPrimaryKeySelective(Empleo record);

    /**
     * 
     * table empleos
     *
     * 
     */
    int updateByPrimaryKey(Empleo record);
    
    public int obtenerUltimoId(Map<String, Integer> dato);
}