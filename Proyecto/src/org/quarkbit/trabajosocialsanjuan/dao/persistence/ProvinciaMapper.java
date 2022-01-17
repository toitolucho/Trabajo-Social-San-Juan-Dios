package org.quarkbit.trabajosocialsanjuan.dao.persistence;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Provincia;
import org.quarkbit.trabajosocialsanjuan.dao.domain.ProvinciaExample;
import org.quarkbit.trabajosocialsanjuan.dao.domain.ProvinciaKey;

public interface ProvinciaMapper {
    /**
     * 
     * table provincias
     *
     * 
     */
    int countByExample(ProvinciaExample example);

    /**
     * 
     * table provincias
     *
     * 
     */
    int deleteByExample(ProvinciaExample example);

    /**
     * 
     * table provincias
     *
     * 
     */
    int deleteByPrimaryKey(ProvinciaKey key);

    /**
     * 
     * table provincias
     *
     * 
     */
    int insert(Provincia record);

    /**
     * 
     * table provincias
     *
     * 
     */
    int insertSelective(Provincia record);

    /**
     * 
     * table provincias
     *
     * 
     */
    List<Provincia> selectByExample(ProvinciaExample example);

    /**
     * 
     * table provincias
     *
     * 
     */
    Provincia selectByPrimaryKey(ProvinciaKey key);

    /**
     * 
     * table provincias
     *
     * 
     */
    int updateByExampleSelective(@Param("record") Provincia record, @Param("example") ProvinciaExample example);

    /**
     * 
     * table provincias
     *
     * 
     */
    int updateByExample(@Param("record") Provincia record, @Param("example") ProvinciaExample example);

    /**
     * 
     * table provincias
     *
     * 
     */
    int updateByPrimaryKeySelective(Provincia record);

    /**
     * 
     * table provincias
     *
     * 
     */
    int updateByPrimaryKey(Provincia record);
}