package org.quarkbit.trabajosocialsanjuan.dao.persistence;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Persona;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PersonaExample;

public interface PersonaMapper {
    /**
     * 
     * table personas
     *
     * 
     */
    int countByExample(PersonaExample example);

    /**
     * 
     * table personas
     *
     * 
     */
    int deleteByExample(PersonaExample example);

    /**
     * 
     * table personas
     *
     * 
     */
    int deleteByPrimaryKey(Integer codigoPersona);

    /**
     * 
     * table personas
     *
     * 
     */
    int insert(Persona record);

    /**
     * 
     * table personas
     *
     * 
     */
    int insertSelective(Persona record);

    /**
     * 
     * table personas
     *
     * 
     */
    List<Persona> selectByExample(PersonaExample example);

    /**
     * 
     * table personas
     *
     * 
     */
    Persona selectByPrimaryKey(Integer codigoPersona);

    /**
     * 
     * table personas
     *
     * 
     */
    int updateByExampleSelective(@Param("record") Persona record, @Param("example") PersonaExample example);

    /**
     * 
     * table personas
     *
     * 
     */
    int updateByExample(@Param("record") Persona record, @Param("example") PersonaExample example);

    /**
     * 
     * table personas
     *
     * 
     */
    int updateByPrimaryKeySelective(Persona record);

    /**
     * 
     * table personas
     *
     * 
     */
    int updateByPrimaryKey(Persona record);
    
    public int obtenerUltimoId(Map<String, Integer> dato);
}