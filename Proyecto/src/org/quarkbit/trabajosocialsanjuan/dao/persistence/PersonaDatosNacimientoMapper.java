package org.quarkbit.trabajosocialsanjuan.dao.persistence;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PersonaDatosNacimiento;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PersonaDatosNacimientoExample;

public interface PersonaDatosNacimientoMapper {
    /**
     * 
     * table personas_datos_nacimiento
     *
     * 
     */
    int countByExample(PersonaDatosNacimientoExample example);

    /**
     * 
     * table personas_datos_nacimiento
     *
     * 
     */
    int deleteByExample(PersonaDatosNacimientoExample example);

    /**
     * 
     * table personas_datos_nacimiento
     *
     * 
     */
    int deleteByPrimaryKey(Integer codigoPersona);

    /**
     * 
     * table personas_datos_nacimiento
     *
     * 
     */
    int insert(PersonaDatosNacimiento record);

    /**
     * 
     * table personas_datos_nacimiento
     *
     * 
     */
    int insertSelective(PersonaDatosNacimiento record);

    /**
     * 
     * table personas_datos_nacimiento
     *
     * 
     */
    List<PersonaDatosNacimiento> selectByExample(PersonaDatosNacimientoExample example);

    /**
     * 
     * table personas_datos_nacimiento
     *
     * 
     */
    PersonaDatosNacimiento selectByPrimaryKey(Integer codigoPersona);

    /**
     * 
     * table personas_datos_nacimiento
     *
     * 
     */
    int updateByExampleSelective(@Param("record") PersonaDatosNacimiento record, @Param("example") PersonaDatosNacimientoExample example);

    /**
     * 
     * table personas_datos_nacimiento
     *
     * 
     */
    int updateByExample(@Param("record") PersonaDatosNacimiento record, @Param("example") PersonaDatosNacimientoExample example);

    /**
     * 
     * table personas_datos_nacimiento
     *
     * 
     */
    int updateByPrimaryKeySelective(PersonaDatosNacimiento record);

    /**
     * 
     * table personas_datos_nacimiento
     *
     * 
     */
    int updateByPrimaryKey(PersonaDatosNacimiento record);
}