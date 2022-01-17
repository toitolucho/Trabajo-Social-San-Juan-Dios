package org.quarkbit.trabajosocialsanjuan.dao.persistence;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Partida;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PartidaExample;

public interface PartidaMapper {
    /**
     * 
     * table partidas
     *
     * 
     */
    int countByExample(PartidaExample example);

    /**
     * 
     * table partidas
     *
     * 
     */
    int deleteByExample(PartidaExample example);

    /**
     * 
     * table partidas
     *
     * 
     */
    int deleteByPrimaryKey(String codigoPartida);

    /**
     * 
     * table partidas
     *
     * 
     */
    int insert(Partida record);

    /**
     * 
     * table partidas
     *
     * 
     */
    int insertSelective(Partida record);

    /**
     * 
     * table partidas
     *
     * 
     */
    List<Partida> selectByExample(PartidaExample example);

    /**
     * 
     * table partidas
     *
     * 
     */
    Partida selectByPrimaryKey(String codigoPartida);

    /**
     * 
     * table partidas
     *
     * 
     */
    int updateByExampleSelective(@Param("record") Partida record, @Param("example") PartidaExample example);

    /**
     * 
     * table partidas
     *
     * 
     */
    int updateByExample(@Param("record") Partida record, @Param("example") PartidaExample example);

    /**
     * 
     * table partidas
     *
     * 
     */
    int updateByPrimaryKeySelective(Partida record);

    /**
     * 
     * table partidas
     *
     * 
     */
    int updateByPrimaryKey(Partida record);
}