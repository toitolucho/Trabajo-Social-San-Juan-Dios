package org.quarkbit.trabajosocialsanjuan.dao.persistence;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PersonaKardex;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PersonaKardexExample;

public interface PersonaKardexMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table personas_kardex
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    int countByExample(PersonaKardexExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table personas_kardex
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    int deleteByExample(PersonaKardexExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table personas_kardex
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    int deleteByPrimaryKey(Integer codigoKardex);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table personas_kardex
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    int insert(PersonaKardex record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table personas_kardex
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    int insertSelective(PersonaKardex record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table personas_kardex
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    List<PersonaKardex> selectByExample(PersonaKardexExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table personas_kardex
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    PersonaKardex selectByPrimaryKey(Integer codigoKardex);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table personas_kardex
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    int updateByExampleSelective(@Param("record") PersonaKardex record, @Param("example") PersonaKardexExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table personas_kardex
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    int updateByExample(@Param("record") PersonaKardex record, @Param("example") PersonaKardexExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table personas_kardex
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    int updateByPrimaryKeySelective(PersonaKardex record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table personas_kardex
     *
     * @mbggenerated Thu Feb 13 17:38:19 BOT 2014
     */
    int updateByPrimaryKey(PersonaKardex record);

	int obtenerUltimoId(Map<String, Integer> mapa);
}