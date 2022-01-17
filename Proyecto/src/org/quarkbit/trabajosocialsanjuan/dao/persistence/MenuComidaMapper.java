package org.quarkbit.trabajosocialsanjuan.dao.persistence;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.quarkbit.trabajosocialsanjuan.dao.domain.MenuComida;
import org.quarkbit.trabajosocialsanjuan.dao.domain.MenuComidaExample;

public interface MenuComidaMapper {
    /**
     * 
     * table menus_comidas
     *
     * 
     */
    int countByExample(MenuComidaExample example);

    /**
     * 
     * table menus_comidas
     *
     * 
     */
    int deleteByExample(MenuComidaExample example);

    /**
     * 
     * table menus_comidas
     *
     * 
     */
    int deleteByPrimaryKey(Integer codigoMenuComida);

    /**
     * 
     * table menus_comidas
     *
     * 
     */
    int insert(MenuComida record);

    /**
     * 
     * table menus_comidas
     *
     * 
     */
    int insertSelective(MenuComida record);

    /**
     * 
     * table menus_comidas
     *
     * 
     */
    List<MenuComida> selectByExample(MenuComidaExample example);

    /**
     * 
     * table menus_comidas
     *
     * 
     */
    MenuComida selectByPrimaryKey(Integer codigoMenuComida);

    /**
     * 
     * table menus_comidas
     *
     * 
     */
    int updateByExampleSelective(@Param("record") MenuComida record, @Param("example") MenuComidaExample example);

    /**
     * 
     * table menus_comidas
     *
     * 
     */
    int updateByExample(@Param("record") MenuComida record, @Param("example") MenuComidaExample example);

    /**
     * 
     * table menus_comidas
     *
     * 
     */
    int updateByPrimaryKeySelective(MenuComida record);

    /**
     * 
     * table menus_comidas
     *
     * 
     */
    int updateByPrimaryKey(MenuComida record);
    
    public int obtenerUltimoId(Map<String, Integer> dato);
}