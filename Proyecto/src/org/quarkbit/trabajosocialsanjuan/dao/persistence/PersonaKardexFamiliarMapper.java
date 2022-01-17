package org.quarkbit.trabajosocialsanjuan.dao.persistence;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PersonaKardexFamiliar;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PersonaKardexFamiliarExample;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PersonaKardexFamiliarKey;

public interface PersonaKardexFamiliarMapper {
    /**
     * 
     * table personas_kardex_familiares
     *
     * 
     */
    int countByExample(PersonaKardexFamiliarExample example);

    /**
     * 
     * table personas_kardex_familiares
     *
     * 
     */
    int deleteByExample(PersonaKardexFamiliarExample example);

    /**
     * 
     * table personas_kardex_familiares
     *
     * 
     */
    int deleteByPrimaryKey(PersonaKardexFamiliarKey key);

    /**
     * 
     * table personas_kardex_familiares
     *
     * 
     */
    int insert(PersonaKardexFamiliar record);

    /**
     * 
     * table personas_kardex_familiares
     *
     * 
     */
    int insertSelective(PersonaKardexFamiliar record);

    /**
     * 
     * table personas_kardex_familiares
     *
     * 
     */
    List<PersonaKardexFamiliar> selectByExample(PersonaKardexFamiliarExample example);

    /**
     * 
     * table personas_kardex_familiares
     *
     * 
     */
    PersonaKardexFamiliar selectByPrimaryKey(PersonaKardexFamiliarKey key);

    /**
     * 
     * table personas_kardex_familiares
     *
     * 
     */
    int updateByExampleSelective(@Param("record") PersonaKardexFamiliar record, @Param("example") PersonaKardexFamiliarExample example);

    /**
     * 
     * table personas_kardex_familiares
     *
     * 
     */
    int updateByExample(@Param("record") PersonaKardexFamiliar record, @Param("example") PersonaKardexFamiliarExample example);

    /**
     * 
     * table personas_kardex_familiares
     *
     * 
     */
    int updateByPrimaryKeySelective(PersonaKardexFamiliar record);

    /**
     * 
     * table personas_kardex_familiares
     *
     * 
     */
    int updateByPrimaryKey(PersonaKardexFamiliar record);
}