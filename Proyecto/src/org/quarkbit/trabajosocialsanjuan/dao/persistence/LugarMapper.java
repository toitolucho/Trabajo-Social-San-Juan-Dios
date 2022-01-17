package org.quarkbit.trabajosocialsanjuan.dao.persistence;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Lugar;
import org.quarkbit.trabajosocialsanjuan.dao.domain.LugarExample;
import org.quarkbit.trabajosocialsanjuan.dao.domain.LugarKey;

public interface LugarMapper {
    /**
     * 
     * table lugares
     *
     * 
     */
    int countByExample(LugarExample example);

    /**
     * 
     * table lugares
     *
     * 
     */
    int deleteByExample(LugarExample example);

    /**
     * 
     * table lugares
     *
     * 
     */
    int deleteByPrimaryKey(LugarKey key);

    /**
     * 
     * table lugares
     *
     * 
     */
    int insert(Lugar record);

    /**
     * 
     * table lugares
     *
     * 
     */
    int insertSelective(Lugar record);

    /**
     * 
     * table lugares
     *
     * 
     */
    List<Lugar> selectByExample(LugarExample example);

    /**
     * 
     * table lugares
     *
     * 
     */
    Lugar selectByPrimaryKey(LugarKey key);

    /**
     * 
     * table lugares
     *
     * 
     */
    int updateByExampleSelective(@Param("record") Lugar record, @Param("example") LugarExample example);

    /**
     * 
     * table lugares
     *
     * 
     */
    int updateByExample(@Param("record") Lugar record, @Param("example") LugarExample example);

    /**
     * 
     * table lugares
     *
     * 
     */
    int updateByPrimaryKeySelective(Lugar record);

    /**
     * 
     * table lugares
     *
     * 
     */
    int updateByPrimaryKey(Lugar record);
}