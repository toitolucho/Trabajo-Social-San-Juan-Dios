package org.quarkbit.trabajosocialsanjuan.dao.persistence;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Parentesco;
import org.quarkbit.trabajosocialsanjuan.dao.domain.ParentescoExample;

public interface ParentescoMapper {
    /**
     * 
     * table parentescos
     *
     * 
     */
    int countByExample(ParentescoExample example);

    /**
     * 
     * table parentescos
     *
     * 
     */
    int deleteByExample(ParentescoExample example);

    /**
     * 
     * table parentescos
     *
     * 
     */
    int deleteByPrimaryKey(Integer codigoParentesco);

    /**
     * 
     * table parentescos
     *
     * 
     */
    int insert(Parentesco record);

    /**
     * 
     * table parentescos
     *
     * 
     */
    int insertSelective(Parentesco record);

    /**
     * 
     * table parentescos
     *
     * 
     */
    List<Parentesco> selectByExample(ParentescoExample example);

    /**
     * 
     * table parentescos
     *
     * 
     */
    Parentesco selectByPrimaryKey(Integer codigoParentesco);

    /**
     * 
     * table parentescos
     *
     * 
     */
    int updateByExampleSelective(@Param("record") Parentesco record, @Param("example") ParentescoExample example);

    /**
     * 
     * table parentescos
     *
     * 
     */
    int updateByExample(@Param("record") Parentesco record, @Param("example") ParentescoExample example);

    /**
     * 
     * table parentescos
     *
     * 
     */
    int updateByPrimaryKeySelective(Parentesco record);

    /**
     * 
     * table parentescos
     *
     * 
     */
    int updateByPrimaryKey(Parentesco record);
    
    public int obtenerUltimoId(Map<String, Integer> dato);
}