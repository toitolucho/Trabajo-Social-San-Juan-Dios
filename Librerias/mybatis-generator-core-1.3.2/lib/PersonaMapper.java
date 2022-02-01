package org.iitic.asignaciondocente.dao.persistence;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.iitic.asignaciondocente.dao.domain.Persona;
import org.iitic.asignaciondocente.dao.domain.PersonaExample;

public interface PersonaMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PERSONAS
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    int countByExample(PersonaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PERSONAS
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    int deleteByExample(PersonaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PERSONAS
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    int deleteByPrimaryKey(Integer idPersona);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PERSONAS
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    int insert(Persona record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PERSONAS
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    int insertSelective(Persona record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PERSONAS
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    List<Persona> selectByExample(PersonaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PERSONAS
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    Persona selectByPrimaryKey(Integer idPersona);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PERSONAS
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    int updateByExampleSelective(@Param("record") Persona record, @Param("example") PersonaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PERSONAS
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    int updateByExample(@Param("record") Persona record, @Param("example") PersonaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PERSONAS
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    int updateByPrimaryKeySelective(Persona record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PERSONAS
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    int updateByPrimaryKey(Persona record);
    int obtenerUltimoId();
	List<Persona> ListarPersonasAleatorio (Map<String, Object> params);
	List<Persona> ListarPersonasAleatorio_X_GRUPOS(Map<String, Object> params);
    List<Persona> BuscarPersonasGestion (Map<String, Object> params);
    List<Persona> BuscarEstudiantesGestion (Map<String, Object> params);
    List<Persona> BuscarAutoridadesGestion (Map<String, Object> params);
    List<Persona> BuscarDocentesGestion (Map<String, Object> params);
    List<Persona> ListarPersonasEvento (Map<String, Object> params);
    List<Persona> ListarPersonasAutoridadesEvento (Integer v_id_evento);
    Persona ObtenerPersonasEstudianteEvento(Integer v_id_evento);
    
    List<Persona> buscarDocentesCertificaciones (Map<String, Object> params);   
    
}