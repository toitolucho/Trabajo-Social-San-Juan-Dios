package org.quarkbit.trabajosocialsanjuan.dao.persistence;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Informe;
import org.quarkbit.trabajosocialsanjuan.dao.domain.InformeExample;

public interface InformeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table informes
     *
     * @mbggenerated Tue Mar 04 17:35:57 BOT 2014
     */
    int countByExample(InformeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table informes
     *
     * @mbggenerated Tue Mar 04 17:35:57 BOT 2014
     */
    int deleteByExample(InformeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table informes
     *
     * @mbggenerated Tue Mar 04 17:35:57 BOT 2014
     */
    int deleteByPrimaryKey(Integer codigoInforme);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table informes
     *
     * @mbggenerated Tue Mar 04 17:35:57 BOT 2014
     */
    int insert(Informe record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table informes
     *
     * @mbggenerated Tue Mar 04 17:35:57 BOT 2014
     */
    int insertSelective(Informe record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table informes
     *
     * @mbggenerated Tue Mar 04 17:35:57 BOT 2014
     */
    List<Informe> selectByExample(InformeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table informes
     *
     * @mbggenerated Tue Mar 04 17:35:57 BOT 2014
     */
    Informe selectByPrimaryKey(Integer codigoInforme);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table informes
     *
     * @mbggenerated Tue Mar 04 17:35:57 BOT 2014
     */
    int updateByExampleSelective(@Param("record") Informe record, @Param("example") InformeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table informes
     *
     * @mbggenerated Tue Mar 04 17:35:57 BOT 2014
     */
    int updateByExample(@Param("record") Informe record, @Param("example") InformeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table informes
     *
     * @mbggenerated Tue Mar 04 17:35:57 BOT 2014
     */
    int updateByPrimaryKeySelective(Informe record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table informes
     *
     * @mbggenerated Tue Mar 04 17:35:57 BOT 2014
     */
    int updateByPrimaryKey(Informe record);
    public int obtenerUltimoId(Map<String, Integer> dato);
}