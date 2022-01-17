package org.quarkbit.trabajosocialsanjuan.dao.persistence;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Comida;
import org.quarkbit.trabajosocialsanjuan.dao.domain.ComidaExample;

public interface ComidaMapper {
    /**
     * 
     * table comidas
     *
     * 
     */
    int countByExample(ComidaExample example);

    /**
     * 
     * table comidas
     *
     * 
     */
    int deleteByExample(ComidaExample example);

    /**
     * 
     * table comidas
     *
     * 
     */
    int deleteByPrimaryKey(Integer codigoComida);

    /**
     * 
     * table comidas
     *
     * 
     */
    int insert(Comida record);

    /**
     * 
     * table comidas
     *
     * 
     */
    int insertSelective(Comida record);

    /**
     * 
     * table comidas
     *
     * 
     */
    List<Comida> selectByExample(ComidaExample example);

    /**
     * 
     * table comidas
     *
     * 
     */
    Comida selectByPrimaryKey(Integer codigoComida);

    /**
     * 
     * table comidas
     *
     * 
     */
    int updateByExampleSelective(@Param("record") Comida record, @Param("example") ComidaExample example);

    /**
     * 
     * table comidas
     *
     * 
     */
    int updateByExample(@Param("record") Comida record, @Param("example") ComidaExample example);

    /**
     * 
     * table comidas
     *
     * 
     */
    int updateByPrimaryKeySelective(Comida record);

    /**
     * 
     * table comidas
     *
     * 
     */
    int updateByPrimaryKey(Comida record);
    
    public int obtenerUltimoId(Map<String, Integer> dato);
}