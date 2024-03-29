package org.quarkbit.trabajosocialsanjuan.dao.persistence;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.quarkbit.trabajosocialsanjuan.dao.domain.HistorialClinicoConsultaDetalle;
import org.quarkbit.trabajosocialsanjuan.dao.domain.HistorialClinicoConsultaDetalleExample;

public interface HistorialClinicoConsultaDetalleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table historia_clinico_consulta_detalle
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    int countByExample(HistorialClinicoConsultaDetalleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table historia_clinico_consulta_detalle
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    int deleteByExample(HistorialClinicoConsultaDetalleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table historia_clinico_consulta_detalle
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    int deleteByPrimaryKey(Integer numeroHCConsultaDetalle);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table historia_clinico_consulta_detalle
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    int insert(HistorialClinicoConsultaDetalle record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table historia_clinico_consulta_detalle
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    int insertSelective(HistorialClinicoConsultaDetalle record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table historia_clinico_consulta_detalle
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    List<HistorialClinicoConsultaDetalle> selectByExample(HistorialClinicoConsultaDetalleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table historia_clinico_consulta_detalle
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    HistorialClinicoConsultaDetalle selectByPrimaryKey(Integer numeroHCConsultaDetalle);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table historia_clinico_consulta_detalle
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    int updateByExampleSelective(@Param("record") HistorialClinicoConsultaDetalle record, @Param("example") HistorialClinicoConsultaDetalleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table historia_clinico_consulta_detalle
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    int updateByExample(@Param("record") HistorialClinicoConsultaDetalle record, @Param("example") HistorialClinicoConsultaDetalleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table historia_clinico_consulta_detalle
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    int updateByPrimaryKeySelective(HistorialClinicoConsultaDetalle record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table historia_clinico_consulta_detalle
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    int updateByPrimaryKey(HistorialClinicoConsultaDetalle record);
    public int obtenerUltimoId(Map<String, Integer> dato);
}