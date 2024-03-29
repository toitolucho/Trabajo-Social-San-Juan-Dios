package org.quarkbit.trabajosocialsanjuan.dao.persistence;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.quarkbit.trabajosocialsanjuan.dao.domain.CategoriaComida;
import org.quarkbit.trabajosocialsanjuan.dao.domain.CategoriaComidaExample;

public interface CategoriaComidaMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categorias_comidas
     *
     * @mbggenerated Fri Feb 21 14:48:59 BOT 2014
     */
    int countByExample(CategoriaComidaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categorias_comidas
     *
     * @mbggenerated Fri Feb 21 14:48:59 BOT 2014
     */
    int deleteByExample(CategoriaComidaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categorias_comidas
     *
     * @mbggenerated Fri Feb 21 14:48:59 BOT 2014
     */
    int deleteByPrimaryKey(Integer codigoCategoria);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categorias_comidas
     *
     * @mbggenerated Fri Feb 21 14:48:59 BOT 2014
     */
    int insert(CategoriaComida record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categorias_comidas
     *
     * @mbggenerated Fri Feb 21 14:48:59 BOT 2014
     */
    int insertSelective(CategoriaComida record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categorias_comidas
     *
     * @mbggenerated Fri Feb 21 14:48:59 BOT 2014
     */
    List<CategoriaComida> selectByExample(CategoriaComidaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categorias_comidas
     *
     * @mbggenerated Fri Feb 21 14:48:59 BOT 2014
     */
    CategoriaComida selectByPrimaryKey(Integer codigoCategoria);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categorias_comidas
     *
     * @mbggenerated Fri Feb 21 14:48:59 BOT 2014
     */
    int updateByExampleSelective(@Param("record") CategoriaComida record, @Param("example") CategoriaComidaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categorias_comidas
     *
     * @mbggenerated Fri Feb 21 14:48:59 BOT 2014
     */
    int updateByExample(@Param("record") CategoriaComida record, @Param("example") CategoriaComidaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categorias_comidas
     *
     * @mbggenerated Fri Feb 21 14:48:59 BOT 2014
     */
    int updateByPrimaryKeySelective(CategoriaComida record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categorias_comidas
     *
     * @mbggenerated Fri Feb 21 14:48:59 BOT 2014
     */
    int updateByPrimaryKey(CategoriaComida record);
    
    public int obtenerUltimoId(Map<String, Integer> dato);
}