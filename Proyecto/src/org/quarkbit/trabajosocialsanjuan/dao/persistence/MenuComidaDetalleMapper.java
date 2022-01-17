package org.quarkbit.trabajosocialsanjuan.dao.persistence;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.quarkbit.trabajosocialsanjuan.dao.domain.MenuComidaDetalle;
import org.quarkbit.trabajosocialsanjuan.dao.domain.MenuComidaDetalleExample;

public interface MenuComidaDetalleMapper {
    /**
     * 
     * table menus_comidas_detalle
     *
     * 
     */
    int countByExample(MenuComidaDetalleExample example);

    /**
     * 
     * table menus_comidas_detalle
     *
     * 
     */
    int deleteByExample(MenuComidaDetalleExample example);

    /**
     * 
     * table menus_comidas_detalle
     *
     * 
     */
    int deleteByPrimaryKey(Integer codigoMenuComidaDetalle);

    /**
     * 
     * table menus_comidas_detalle
     *
     * 
     */
    int insert(MenuComidaDetalle record);

    /**
     * 
     * table menus_comidas_detalle
     *
     * 
     */
    int insertSelective(MenuComidaDetalle record);

    /**
     * 
     * table menus_comidas_detalle
     *
     * 
     */
    List<MenuComidaDetalle> selectByExample(MenuComidaDetalleExample example);

    /**
     * 
     * table menus_comidas_detalle
     *
     * 
     */
    MenuComidaDetalle selectByPrimaryKey(Integer codigoMenuComidaDetalle);

    /**
     * 
     * table menus_comidas_detalle
     *
     * 
     */
    int updateByExampleSelective(@Param("record") MenuComidaDetalle record, @Param("example") MenuComidaDetalleExample example);

    /**
     * 
     * table menus_comidas_detalle
     *
     * 
     */
    int updateByExample(@Param("record") MenuComidaDetalle record, @Param("example") MenuComidaDetalleExample example);

    /**
     * 
     * table menus_comidas_detalle
     *
     * 
     */
    int updateByPrimaryKeySelective(MenuComidaDetalle record);

    /**
     * 
     * table menus_comidas_detalle
     *
     * 
     */
    int updateByPrimaryKey(MenuComidaDetalle record);
    
    public int obtenerUltimoId(Map<String, Integer> dato);
}