package org.quarkbit.trabajosocialsanjuan.dao.persistence;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Egreso;
import org.quarkbit.trabajosocialsanjuan.dao.domain.EgresoExample;

public interface EgresoMapper {
    /**
     * 
     * table egresos
     *
     * 
     */
    int countByExample(EgresoExample example);

    /**
     * 
     * table egresos
     *
     * 
     */
    int deleteByExample(EgresoExample example);

    /**
     * 
     * table egresos
     *
     * 
     */
    int deleteByPrimaryKey(Integer codigoEgreso);

    /**
     * 
     * table egresos
     *
     * 
     */
    int insert(Egreso record);

    /**
     * 
     * table egresos
     *
     * 
     */
    int insertSelective(Egreso record);

    /**
     * 
     * table egresos
     *
     * 
     */
    List<Egreso> selectByExample(EgresoExample example);

    /**
     * 
     * table egresos
     *
     * 
     */
    Egreso selectByPrimaryKey(Integer codigoEgreso);

    /**
     * 
     * table egresos
     *
     * 
     */
    int updateByExampleSelective(@Param("record") Egreso record, @Param("example") EgresoExample example);

    /**
     * 
     * table egresos
     *
     * 
     */
    int updateByExample(@Param("record") Egreso record, @Param("example") EgresoExample example);

    /**
     * 
     * table egresos
     *
     * 
     */
    int updateByPrimaryKeySelective(Egreso record);

    /**
     * 
     * table egresos
     *
     * 
     */
    int updateByPrimaryKey(Egreso record);
    
    public int obtenerUltimoId(Map<String, Integer> dato);
    
    int obtenerFechaHoraServidor(Map<String, Date> mapa);
}