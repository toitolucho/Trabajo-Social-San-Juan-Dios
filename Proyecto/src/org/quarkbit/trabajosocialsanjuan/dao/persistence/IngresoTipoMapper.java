package org.quarkbit.trabajosocialsanjuan.dao.persistence;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.quarkbit.trabajosocialsanjuan.dao.domain.IngresoTipo;
import org.quarkbit.trabajosocialsanjuan.dao.domain.IngresoTipoExample;

public interface IngresoTipoMapper {
    /**
     * 
     * table ingresos_tipos
     *
     * 
     */
    int countByExample(IngresoTipoExample example);

    /**
     * 
     * table ingresos_tipos
     *
     * 
     */
    int deleteByExample(IngresoTipoExample example);

    /**
     * 
     * table ingresos_tipos
     *
     * 
     */
    int deleteByPrimaryKey(Integer codigoIngresoTipo);

    /**
     * 
     * table ingresos_tipos
     *
     * 
     */
    int insert(IngresoTipo record);

    /**
     * 
     * table ingresos_tipos
     *
     * 
     */
    int insertSelective(IngresoTipo record);

    /**
     * 
     * table ingresos_tipos
     *
     * 
     */
    List<IngresoTipo> selectByExample(IngresoTipoExample example);

    /**
     * 
     * table ingresos_tipos
     *
     * 
     */
    IngresoTipo selectByPrimaryKey(Integer codigoIngresoTipo);

    /**
     * 
     * table ingresos_tipos
     *
     * 
     */
    int updateByExampleSelective(@Param("record") IngresoTipo record, @Param("example") IngresoTipoExample example);

    /**
     * 
     * table ingresos_tipos
     *
     * 
     */
    int updateByExample(@Param("record") IngresoTipo record, @Param("example") IngresoTipoExample example);

    /**
     * 
     * table ingresos_tipos
     *
     * 
     */
    int updateByPrimaryKeySelective(IngresoTipo record);

    /**
     * 
     * table ingresos_tipos
     *
     * 
     */
    int updateByPrimaryKey(IngresoTipo record);
    
    public int obtenerUltimoId(Map<String, Integer> dato);
}