package org.quarkbit.trabajosocialsanjuan.dao.persistence;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Departamento;
import org.quarkbit.trabajosocialsanjuan.dao.domain.DepartamentoExample;
import org.quarkbit.trabajosocialsanjuan.dao.domain.DepartamentoKey;

public interface DepartamentoMapper {
    /**
     * 
     * table departamentos
     *
     * 
     */
    int countByExample(DepartamentoExample example);

    /**
     * 
     * table departamentos
     *
     * 
     */
    int deleteByExample(DepartamentoExample example);

    /**
     * 
     * table departamentos
     *
     * 
     */
    int deleteByPrimaryKey(DepartamentoKey key);

    /**
     * 
     * table departamentos
     *
     * 
     */
    int insert(Departamento record);

    /**
     * 
     * table departamentos
     *
     * 
     */
    int insertSelective(Departamento record);

    /**
     * 
     * table departamentos
     *
     * 
     */
    List<Departamento> selectByExample(DepartamentoExample example);

    /**
     * 
     * table departamentos
     *
     * 
     */
    Departamento selectByPrimaryKey(DepartamentoKey key);

    /**
     * 
     * table departamentos
     *
     * 
     */
    int updateByExampleSelective(@Param("record") Departamento record, @Param("example") DepartamentoExample example);

    /**
     * 
     * table departamentos
     *
     * 
     */
    int updateByExample(@Param("record") Departamento record, @Param("example") DepartamentoExample example);

    /**
     * 
     * table departamentos
     *
     * 
     */
    int updateByPrimaryKeySelective(Departamento record);

    /**
     * 
     * table departamentos
     *
     * 
     */
    int updateByPrimaryKey(Departamento record);
    
    public int obtenerCodigoGeografico(Map<String, String> dato);
}