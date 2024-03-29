package org.quarkbit.trabajosocialsanjuan.dao.persistence;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.quarkbit.trabajosocialsanjuan.dao.domain.InformePsicologico;
import org.quarkbit.trabajosocialsanjuan.dao.domain.InformePsicologicoExample;

public interface InformePsicologicoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table informe_psicologico
     *
     * @mbggenerated Sat Mar 29 13:41:55 BOT 2014
     */
    int countByExample(InformePsicologicoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table informe_psicologico
     *
     * @mbggenerated Sat Mar 29 13:41:55 BOT 2014
     */
    int deleteByExample(InformePsicologicoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table informe_psicologico
     *
     * @mbggenerated Sat Mar 29 13:41:55 BOT 2014
     */
    int deleteByPrimaryKey(Integer codigoInformePsicologico);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table informe_psicologico
     *
     * @mbggenerated Sat Mar 29 13:41:55 BOT 2014
     */
    int insert(InformePsicologico record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table informe_psicologico
     *
     * @mbggenerated Sat Mar 29 13:41:55 BOT 2014
     */
    int insertSelective(InformePsicologico record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table informe_psicologico
     *
     * @mbggenerated Sat Mar 29 13:41:55 BOT 2014
     */
    List<InformePsicologico> selectByExample(InformePsicologicoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table informe_psicologico
     *
     * @mbggenerated Sat Mar 29 13:41:55 BOT 2014
     */
    InformePsicologico selectByPrimaryKey(Integer codigoInformePsicologico);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table informe_psicologico
     *
     * @mbggenerated Sat Mar 29 13:41:55 BOT 2014
     */
    int updateByExampleSelective(@Param("record") InformePsicologico record, @Param("example") InformePsicologicoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table informe_psicologico
     *
     * @mbggenerated Sat Mar 29 13:41:55 BOT 2014
     */
    int updateByExample(@Param("record") InformePsicologico record, @Param("example") InformePsicologicoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table informe_psicologico
     *
     * @mbggenerated Sat Mar 29 13:41:55 BOT 2014
     */
    int updateByPrimaryKeySelective(InformePsicologico record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table informe_psicologico
     *
     * @mbggenerated Sat Mar 29 13:41:55 BOT 2014
     */
    int updateByPrimaryKey(InformePsicologico record);
    public int obtenerUltimoId(Map<String, Integer> dato);
}