package org.iitic.asignaciondocente.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class PersonaExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table PERSONAS
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table PERSONAS
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table PERSONAS
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PERSONAS
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    public PersonaExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PERSONAS
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PERSONAS
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PERSONAS
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PERSONAS
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PERSONAS
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PERSONAS
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PERSONAS
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PERSONAS
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PERSONAS
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PERSONAS
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table PERSONAS
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdPersonaIsNull() {
            addCriterion("ID_PERSONA is null");
            return (Criteria) this;
        }

        public Criteria andIdPersonaIsNotNull() {
            addCriterion("ID_PERSONA is not null");
            return (Criteria) this;
        }

        public Criteria andIdPersonaEqualTo(Integer value) {
            addCriterion("ID_PERSONA =", value, "idPersona");
            return (Criteria) this;
        }

        public Criteria andIdPersonaNotEqualTo(Integer value) {
            addCriterion("ID_PERSONA <>", value, "idPersona");
            return (Criteria) this;
        }

        public Criteria andIdPersonaGreaterThan(Integer value) {
            addCriterion("ID_PERSONA >", value, "idPersona");
            return (Criteria) this;
        }

        public Criteria andIdPersonaGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID_PERSONA >=", value, "idPersona");
            return (Criteria) this;
        }

        public Criteria andIdPersonaLessThan(Integer value) {
            addCriterion("ID_PERSONA <", value, "idPersona");
            return (Criteria) this;
        }

        public Criteria andIdPersonaLessThanOrEqualTo(Integer value) {
            addCriterion("ID_PERSONA <=", value, "idPersona");
            return (Criteria) this;
        }

        public Criteria andIdPersonaIn(List<Integer> values) {
            addCriterion("ID_PERSONA in", values, "idPersona");
            return (Criteria) this;
        }

        public Criteria andIdPersonaNotIn(List<Integer> values) {
            addCriterion("ID_PERSONA not in", values, "idPersona");
            return (Criteria) this;
        }

        public Criteria andIdPersonaBetween(Integer value1, Integer value2) {
            addCriterion("ID_PERSONA between", value1, value2, "idPersona");
            return (Criteria) this;
        }

        public Criteria andIdPersonaNotBetween(Integer value1, Integer value2) {
            addCriterion("ID_PERSONA not between", value1, value2, "idPersona");
            return (Criteria) this;
        }

        public Criteria andCiPersonaIsNull() {
            addCriterion("CI_PERSONA is null");
            return (Criteria) this;
        }

        public Criteria andCiPersonaIsNotNull() {
            addCriterion("CI_PERSONA is not null");
            return (Criteria) this;
        }

        public Criteria andCiPersonaEqualTo(String value) {
            addCriterion("CI_PERSONA =", value, "ciPersona");
            return (Criteria) this;
        }

        public Criteria andCiPersonaNotEqualTo(String value) {
            addCriterion("CI_PERSONA <>", value, "ciPersona");
            return (Criteria) this;
        }

        public Criteria andCiPersonaGreaterThan(String value) {
            addCriterion("CI_PERSONA >", value, "ciPersona");
            return (Criteria) this;
        }

        public Criteria andCiPersonaGreaterThanOrEqualTo(String value) {
            addCriterion("CI_PERSONA >=", value, "ciPersona");
            return (Criteria) this;
        }

        public Criteria andCiPersonaLessThan(String value) {
            addCriterion("CI_PERSONA <", value, "ciPersona");
            return (Criteria) this;
        }

        public Criteria andCiPersonaLessThanOrEqualTo(String value) {
            addCriterion("CI_PERSONA <=", value, "ciPersona");
            return (Criteria) this;
        }

        public Criteria andCiPersonaLike(String value) {
            addCriterion("CI_PERSONA like", value, "ciPersona");
            return (Criteria) this;
        }

        public Criteria andCiPersonaNotLike(String value) {
            addCriterion("CI_PERSONA not like", value, "ciPersona");
            return (Criteria) this;
        }

        public Criteria andCiPersonaIn(List<String> values) {
            addCriterion("CI_PERSONA in", values, "ciPersona");
            return (Criteria) this;
        }

        public Criteria andCiPersonaNotIn(List<String> values) {
            addCriterion("CI_PERSONA not in", values, "ciPersona");
            return (Criteria) this;
        }

        public Criteria andCiPersonaBetween(String value1, String value2) {
            addCriterion("CI_PERSONA between", value1, value2, "ciPersona");
            return (Criteria) this;
        }

        public Criteria andCiPersonaNotBetween(String value1, String value2) {
            addCriterion("CI_PERSONA not between", value1, value2, "ciPersona");
            return (Criteria) this;
        }

        public Criteria andNombreCompletoIsNull() {
            addCriterion("NOMBRE_COMPLETO is null");
            return (Criteria) this;
        }

        public Criteria andNombreCompletoIsNotNull() {
            addCriterion("NOMBRE_COMPLETO is not null");
            return (Criteria) this;
        }

        public Criteria andNombreCompletoEqualTo(String value) {
            addCriterion("NOMBRE_COMPLETO =", value, "nombreCompleto");
            return (Criteria) this;
        }

        public Criteria andNombreCompletoNotEqualTo(String value) {
            addCriterion("NOMBRE_COMPLETO <>", value, "nombreCompleto");
            return (Criteria) this;
        }

        public Criteria andNombreCompletoGreaterThan(String value) {
            addCriterion("NOMBRE_COMPLETO >", value, "nombreCompleto");
            return (Criteria) this;
        }

        public Criteria andNombreCompletoGreaterThanOrEqualTo(String value) {
            addCriterion("NOMBRE_COMPLETO >=", value, "nombreCompleto");
            return (Criteria) this;
        }

        public Criteria andNombreCompletoLessThan(String value) {
            addCriterion("NOMBRE_COMPLETO <", value, "nombreCompleto");
            return (Criteria) this;
        }

        public Criteria andNombreCompletoLessThanOrEqualTo(String value) {
            addCriterion("NOMBRE_COMPLETO <=", value, "nombreCompleto");
            return (Criteria) this;
        }

        public Criteria andNombreCompletoLike(String value) {
            addCriterion("NOMBRE_COMPLETO like", value, "nombreCompleto");
            return (Criteria) this;
        }

        public Criteria andNombreCompletoNotLike(String value) {
            addCriterion("NOMBRE_COMPLETO not like", value, "nombreCompleto");
            return (Criteria) this;
        }

        public Criteria andNombreCompletoIn(List<String> values) {
            addCriterion("NOMBRE_COMPLETO in", values, "nombreCompleto");
            return (Criteria) this;
        }

        public Criteria andNombreCompletoNotIn(List<String> values) {
            addCriterion("NOMBRE_COMPLETO not in", values, "nombreCompleto");
            return (Criteria) this;
        }

        public Criteria andNombreCompletoBetween(String value1, String value2) {
            addCriterion("NOMBRE_COMPLETO between", value1, value2, "nombreCompleto");
            return (Criteria) this;
        }

        public Criteria andNombreCompletoNotBetween(String value1, String value2) {
            addCriterion("NOMBRE_COMPLETO not between", value1, value2, "nombreCompleto");
            return (Criteria) this;
        }

        public Criteria andSexoIsNull() {
            addCriterion("SEXO is null");
            return (Criteria) this;
        }

        public Criteria andSexoIsNotNull() {
            addCriterion("SEXO is not null");
            return (Criteria) this;
        }

        public Criteria andSexoEqualTo(String value) {
            addCriterion("SEXO =", value, "sexo");
            return (Criteria) this;
        }

        public Criteria andSexoNotEqualTo(String value) {
            addCriterion("SEXO <>", value, "sexo");
            return (Criteria) this;
        }

        public Criteria andSexoGreaterThan(String value) {
            addCriterion("SEXO >", value, "sexo");
            return (Criteria) this;
        }

        public Criteria andSexoGreaterThanOrEqualTo(String value) {
            addCriterion("SEXO >=", value, "sexo");
            return (Criteria) this;
        }

        public Criteria andSexoLessThan(String value) {
            addCriterion("SEXO <", value, "sexo");
            return (Criteria) this;
        }

        public Criteria andSexoLessThanOrEqualTo(String value) {
            addCriterion("SEXO <=", value, "sexo");
            return (Criteria) this;
        }

        public Criteria andSexoLike(String value) {
            addCriterion("SEXO like", value, "sexo");
            return (Criteria) this;
        }

        public Criteria andSexoNotLike(String value) {
            addCriterion("SEXO not like", value, "sexo");
            return (Criteria) this;
        }

        public Criteria andSexoIn(List<String> values) {
            addCriterion("SEXO in", values, "sexo");
            return (Criteria) this;
        }

        public Criteria andSexoNotIn(List<String> values) {
            addCriterion("SEXO not in", values, "sexo");
            return (Criteria) this;
        }

        public Criteria andSexoBetween(String value1, String value2) {
            addCriterion("SEXO between", value1, value2, "sexo");
            return (Criteria) this;
        }

        public Criteria andSexoNotBetween(String value1, String value2) {
            addCriterion("SEXO not between", value1, value2, "sexo");
            return (Criteria) this;
        }

        public Criteria andCelularIsNull() {
            addCriterion("CELULAR is null");
            return (Criteria) this;
        }

        public Criteria andCelularIsNotNull() {
            addCriterion("CELULAR is not null");
            return (Criteria) this;
        }

        public Criteria andCelularEqualTo(String value) {
            addCriterion("CELULAR =", value, "celular");
            return (Criteria) this;
        }

        public Criteria andCelularNotEqualTo(String value) {
            addCriterion("CELULAR <>", value, "celular");
            return (Criteria) this;
        }

        public Criteria andCelularGreaterThan(String value) {
            addCriterion("CELULAR >", value, "celular");
            return (Criteria) this;
        }

        public Criteria andCelularGreaterThanOrEqualTo(String value) {
            addCriterion("CELULAR >=", value, "celular");
            return (Criteria) this;
        }

        public Criteria andCelularLessThan(String value) {
            addCriterion("CELULAR <", value, "celular");
            return (Criteria) this;
        }

        public Criteria andCelularLessThanOrEqualTo(String value) {
            addCriterion("CELULAR <=", value, "celular");
            return (Criteria) this;
        }

        public Criteria andCelularLike(String value) {
            addCriterion("CELULAR like", value, "celular");
            return (Criteria) this;
        }

        public Criteria andCelularNotLike(String value) {
            addCriterion("CELULAR not like", value, "celular");
            return (Criteria) this;
        }

        public Criteria andCelularIn(List<String> values) {
            addCriterion("CELULAR in", values, "celular");
            return (Criteria) this;
        }

        public Criteria andCelularNotIn(List<String> values) {
            addCriterion("CELULAR not in", values, "celular");
            return (Criteria) this;
        }

        public Criteria andCelularBetween(String value1, String value2) {
            addCriterion("CELULAR between", value1, value2, "celular");
            return (Criteria) this;
        }

        public Criteria andCelularNotBetween(String value1, String value2) {
            addCriterion("CELULAR not between", value1, value2, "celular");
            return (Criteria) this;
        }

        public Criteria andCorreoElectronicoIsNull() {
            addCriterion("CORREO_ELECTRONICO is null");
            return (Criteria) this;
        }

        public Criteria andCorreoElectronicoIsNotNull() {
            addCriterion("CORREO_ELECTRONICO is not null");
            return (Criteria) this;
        }

        public Criteria andCorreoElectronicoEqualTo(String value) {
            addCriterion("CORREO_ELECTRONICO =", value, "correoElectronico");
            return (Criteria) this;
        }

        public Criteria andCorreoElectronicoNotEqualTo(String value) {
            addCriterion("CORREO_ELECTRONICO <>", value, "correoElectronico");
            return (Criteria) this;
        }

        public Criteria andCorreoElectronicoGreaterThan(String value) {
            addCriterion("CORREO_ELECTRONICO >", value, "correoElectronico");
            return (Criteria) this;
        }

        public Criteria andCorreoElectronicoGreaterThanOrEqualTo(String value) {
            addCriterion("CORREO_ELECTRONICO >=", value, "correoElectronico");
            return (Criteria) this;
        }

        public Criteria andCorreoElectronicoLessThan(String value) {
            addCriterion("CORREO_ELECTRONICO <", value, "correoElectronico");
            return (Criteria) this;
        }

        public Criteria andCorreoElectronicoLessThanOrEqualTo(String value) {
            addCriterion("CORREO_ELECTRONICO <=", value, "correoElectronico");
            return (Criteria) this;
        }

        public Criteria andCorreoElectronicoLike(String value) {
            addCriterion("CORREO_ELECTRONICO like", value, "correoElectronico");
            return (Criteria) this;
        }

        public Criteria andCorreoElectronicoNotLike(String value) {
            addCriterion("CORREO_ELECTRONICO not like", value, "correoElectronico");
            return (Criteria) this;
        }

        public Criteria andCorreoElectronicoIn(List<String> values) {
            addCriterion("CORREO_ELECTRONICO in", values, "correoElectronico");
            return (Criteria) this;
        }

        public Criteria andCorreoElectronicoNotIn(List<String> values) {
            addCriterion("CORREO_ELECTRONICO not in", values, "correoElectronico");
            return (Criteria) this;
        }

        public Criteria andCorreoElectronicoBetween(String value1, String value2) {
            addCriterion("CORREO_ELECTRONICO between", value1, value2, "correoElectronico");
            return (Criteria) this;
        }

        public Criteria andCorreoElectronicoNotBetween(String value1, String value2) {
            addCriterion("CORREO_ELECTRONICO not between", value1, value2, "correoElectronico");
            return (Criteria) this;
        }

        public Criteria andIdProfesionIsNull() {
            addCriterion("ID_PROFESION is null");
            return (Criteria) this;
        }

        public Criteria andIdProfesionIsNotNull() {
            addCriterion("ID_PROFESION is not null");
            return (Criteria) this;
        }

        public Criteria andIdProfesionEqualTo(Integer value) {
            addCriterion("ID_PROFESION =", value, "idProfesion");
            return (Criteria) this;
        }

        public Criteria andIdProfesionNotEqualTo(Integer value) {
            addCriterion("ID_PROFESION <>", value, "idProfesion");
            return (Criteria) this;
        }

        public Criteria andIdProfesionGreaterThan(Integer value) {
            addCriterion("ID_PROFESION >", value, "idProfesion");
            return (Criteria) this;
        }

        public Criteria andIdProfesionGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID_PROFESION >=", value, "idProfesion");
            return (Criteria) this;
        }

        public Criteria andIdProfesionLessThan(Integer value) {
            addCriterion("ID_PROFESION <", value, "idProfesion");
            return (Criteria) this;
        }

        public Criteria andIdProfesionLessThanOrEqualTo(Integer value) {
            addCriterion("ID_PROFESION <=", value, "idProfesion");
            return (Criteria) this;
        }

        public Criteria andIdProfesionIn(List<Integer> values) {
            addCriterion("ID_PROFESION in", values, "idProfesion");
            return (Criteria) this;
        }

        public Criteria andIdProfesionNotIn(List<Integer> values) {
            addCriterion("ID_PROFESION not in", values, "idProfesion");
            return (Criteria) this;
        }

        public Criteria andIdProfesionBetween(Integer value1, Integer value2) {
            addCriterion("ID_PROFESION between", value1, value2, "idProfesion");
            return (Criteria) this;
        }

        public Criteria andIdProfesionNotBetween(Integer value1, Integer value2) {
            addCriterion("ID_PROFESION not between", value1, value2, "idProfesion");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table PERSONAS
     *
     * @mbggenerated do_not_delete_during_merge Thu Feb 02 20:21:35 BOT 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table PERSONAS
     *
     * @mbggenerated Thu Feb 02 20:21:35 BOT 2017
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}