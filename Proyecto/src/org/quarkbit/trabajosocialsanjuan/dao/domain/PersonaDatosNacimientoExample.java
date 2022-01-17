package org.quarkbit.trabajosocialsanjuan.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PersonaDatosNacimientoExample {
    /**
     *
     * table personas_datos_nacimiento
     *
     * 
     */
    protected String orderByClause;

    /**
     *
     * table personas_datos_nacimiento
     *
     * 
     */
    protected boolean distinct;

    /**
     *
     * table personas_datos_nacimiento
     *
     * 
     */
    protected List<Criteria> oredCriteria;

    /**
     * 
     * table personas_datos_nacimiento
     *
     * 
     */
    public PersonaDatosNacimientoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 
     * table personas_datos_nacimiento
     *
     * 
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 
     * table personas_datos_nacimiento
     *
     * 
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 
     * table personas_datos_nacimiento
     *
     * 
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 
     * table personas_datos_nacimiento
     *
     * 
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 
     * table personas_datos_nacimiento
     *
     * 
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 
     * table personas_datos_nacimiento
     *
     * 
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 
     * table personas_datos_nacimiento
     *
     * 
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 
     * table personas_datos_nacimiento
     *
     * 
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * 
     * table personas_datos_nacimiento
     *
     * 
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 
     * table personas_datos_nacimiento
     *
     * 
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 
     * personas_datos_nacimiento
     *
     * 
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andCodigoPersonaIsNull() {
            addCriterion("codigo_persona is null");
            return (Criteria) this;
        }

        public Criteria andCodigoPersonaIsNotNull() {
            addCriterion("codigo_persona is not null");
            return (Criteria) this;
        }

        public Criteria andCodigoPersonaEqualTo(Integer value) {
            addCriterion("codigo_persona =", value, "codigoPersona");
            return (Criteria) this;
        }

        public Criteria andCodigoPersonaNotEqualTo(Integer value) {
            addCriterion("codigo_persona <>", value, "codigoPersona");
            return (Criteria) this;
        }

        public Criteria andCodigoPersonaGreaterThan(Integer value) {
            addCriterion("codigo_persona >", value, "codigoPersona");
            return (Criteria) this;
        }

        public Criteria andCodigoPersonaGreaterThanOrEqualTo(Integer value) {
            addCriterion("codigo_persona >=", value, "codigoPersona");
            return (Criteria) this;
        }

        public Criteria andCodigoPersonaLessThan(Integer value) {
            addCriterion("codigo_persona <", value, "codigoPersona");
            return (Criteria) this;
        }

        public Criteria andCodigoPersonaLessThanOrEqualTo(Integer value) {
            addCriterion("codigo_persona <=", value, "codigoPersona");
            return (Criteria) this;
        }

        public Criteria andCodigoPersonaIn(List<Integer> values) {
            addCriterion("codigo_persona in", values, "codigoPersona");
            return (Criteria) this;
        }

        public Criteria andCodigoPersonaNotIn(List<Integer> values) {
            addCriterion("codigo_persona not in", values, "codigoPersona");
            return (Criteria) this;
        }

        public Criteria andCodigoPersonaBetween(Integer value1, Integer value2) {
            addCriterion("codigo_persona between", value1, value2, "codigoPersona");
            return (Criteria) this;
        }

        public Criteria andCodigoPersonaNotBetween(Integer value1, Integer value2) {
            addCriterion("codigo_persona not between", value1, value2, "codigoPersona");
            return (Criteria) this;
        }

        public Criteria andFechaNacimientoIsNull() {
            addCriterion("fecha_nacimiento is null");
            return (Criteria) this;
        }

        public Criteria andFechaNacimientoIsNotNull() {
            addCriterion("fecha_nacimiento is not null");
            return (Criteria) this;
        }

        public Criteria andFechaNacimientoEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_nacimiento =", value, "fechaNacimiento");
            return (Criteria) this;
        }

        public Criteria andFechaNacimientoNotEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_nacimiento <>", value, "fechaNacimiento");
            return (Criteria) this;
        }

        public Criteria andFechaNacimientoGreaterThan(Date value) {
            addCriterionForJDBCDate("fecha_nacimiento >", value, "fechaNacimiento");
            return (Criteria) this;
        }

        public Criteria andFechaNacimientoGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_nacimiento >=", value, "fechaNacimiento");
            return (Criteria) this;
        }

        public Criteria andFechaNacimientoLessThan(Date value) {
            addCriterionForJDBCDate("fecha_nacimiento <", value, "fechaNacimiento");
            return (Criteria) this;
        }

        public Criteria andFechaNacimientoLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_nacimiento <=", value, "fechaNacimiento");
            return (Criteria) this;
        }

        public Criteria andFechaNacimientoIn(List<Date> values) {
            addCriterionForJDBCDate("fecha_nacimiento in", values, "fechaNacimiento");
            return (Criteria) this;
        }

        public Criteria andFechaNacimientoNotIn(List<Date> values) {
            addCriterionForJDBCDate("fecha_nacimiento not in", values, "fechaNacimiento");
            return (Criteria) this;
        }

        public Criteria andFechaNacimientoBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fecha_nacimiento between", value1, value2, "fechaNacimiento");
            return (Criteria) this;
        }

        public Criteria andFechaNacimientoNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fecha_nacimiento not between", value1, value2, "fechaNacimiento");
            return (Criteria) this;
        }

        public Criteria andEdadIsNull() {
            addCriterion("edad is null");
            return (Criteria) this;
        }

        public Criteria andEdadIsNotNull() {
            addCriterion("edad is not null");
            return (Criteria) this;
        }

        public Criteria andEdadEqualTo(Integer value) {
            addCriterion("edad =", value, "edad");
            return (Criteria) this;
        }

        public Criteria andEdadNotEqualTo(Integer value) {
            addCriterion("edad <>", value, "edad");
            return (Criteria) this;
        }

        public Criteria andEdadGreaterThan(Integer value) {
            addCriterion("edad >", value, "edad");
            return (Criteria) this;
        }

        public Criteria andEdadGreaterThanOrEqualTo(Integer value) {
            addCriterion("edad >=", value, "edad");
            return (Criteria) this;
        }

        public Criteria andEdadLessThan(Integer value) {
            addCriterion("edad <", value, "edad");
            return (Criteria) this;
        }

        public Criteria andEdadLessThanOrEqualTo(Integer value) {
            addCriterion("edad <=", value, "edad");
            return (Criteria) this;
        }

        public Criteria andEdadIn(List<Integer> values) {
            addCriterion("edad in", values, "edad");
            return (Criteria) this;
        }

        public Criteria andEdadNotIn(List<Integer> values) {
            addCriterion("edad not in", values, "edad");
            return (Criteria) this;
        }

        public Criteria andEdadBetween(Integer value1, Integer value2) {
            addCriterion("edad between", value1, value2, "edad");
            return (Criteria) this;
        }

        public Criteria andEdadNotBetween(Integer value1, Integer value2) {
            addCriterion("edad not between", value1, value2, "edad");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisnIsNull() {
            addCriterion("codigo_paisn is null");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisnIsNotNull() {
            addCriterion("codigo_paisn is not null");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisnEqualTo(String value) {
            addCriterion("codigo_paisn =", value, "codigoPaisn");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisnNotEqualTo(String value) {
            addCriterion("codigo_paisn <>", value, "codigoPaisn");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisnGreaterThan(String value) {
            addCriterion("codigo_paisn >", value, "codigoPaisn");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisnGreaterThanOrEqualTo(String value) {
            addCriterion("codigo_paisn >=", value, "codigoPaisn");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisnLessThan(String value) {
            addCriterion("codigo_paisn <", value, "codigoPaisn");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisnLessThanOrEqualTo(String value) {
            addCriterion("codigo_paisn <=", value, "codigoPaisn");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisnLike(String value) {
            addCriterion("codigo_paisn like", value, "codigoPaisn");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisnNotLike(String value) {
            addCriterion("codigo_paisn not like", value, "codigoPaisn");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisnIn(List<String> values) {
            addCriterion("codigo_paisn in", values, "codigoPaisn");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisnNotIn(List<String> values) {
            addCriterion("codigo_paisn not in", values, "codigoPaisn");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisnBetween(String value1, String value2) {
            addCriterion("codigo_paisn between", value1, value2, "codigoPaisn");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisnNotBetween(String value1, String value2) {
            addCriterion("codigo_paisn not between", value1, value2, "codigoPaisn");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentonIsNull() {
            addCriterion("codigo_departamenton is null");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentonIsNotNull() {
            addCriterion("codigo_departamenton is not null");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentonEqualTo(String value) {
            addCriterion("codigo_departamenton =", value, "codigoDepartamenton");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentonNotEqualTo(String value) {
            addCriterion("codigo_departamenton <>", value, "codigoDepartamenton");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentonGreaterThan(String value) {
            addCriterion("codigo_departamenton >", value, "codigoDepartamenton");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentonGreaterThanOrEqualTo(String value) {
            addCriterion("codigo_departamenton >=", value, "codigoDepartamenton");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentonLessThan(String value) {
            addCriterion("codigo_departamenton <", value, "codigoDepartamenton");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentonLessThanOrEqualTo(String value) {
            addCriterion("codigo_departamenton <=", value, "codigoDepartamenton");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentonLike(String value) {
            addCriterion("codigo_departamenton like", value, "codigoDepartamenton");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentonNotLike(String value) {
            addCriterion("codigo_departamenton not like", value, "codigoDepartamenton");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentonIn(List<String> values) {
            addCriterion("codigo_departamenton in", values, "codigoDepartamenton");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentonNotIn(List<String> values) {
            addCriterion("codigo_departamenton not in", values, "codigoDepartamenton");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentonBetween(String value1, String value2) {
            addCriterion("codigo_departamenton between", value1, value2, "codigoDepartamenton");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentonNotBetween(String value1, String value2) {
            addCriterion("codigo_departamenton not between", value1, value2, "codigoDepartamenton");
            return (Criteria) this;
        }

        public Criteria andCodigoProvincianIsNull() {
            addCriterion("codigo_provincian is null");
            return (Criteria) this;
        }

        public Criteria andCodigoProvincianIsNotNull() {
            addCriterion("codigo_provincian is not null");
            return (Criteria) this;
        }

        public Criteria andCodigoProvincianEqualTo(String value) {
            addCriterion("codigo_provincian =", value, "codigoProvincian");
            return (Criteria) this;
        }

        public Criteria andCodigoProvincianNotEqualTo(String value) {
            addCriterion("codigo_provincian <>", value, "codigoProvincian");
            return (Criteria) this;
        }

        public Criteria andCodigoProvincianGreaterThan(String value) {
            addCriterion("codigo_provincian >", value, "codigoProvincian");
            return (Criteria) this;
        }

        public Criteria andCodigoProvincianGreaterThanOrEqualTo(String value) {
            addCriterion("codigo_provincian >=", value, "codigoProvincian");
            return (Criteria) this;
        }

        public Criteria andCodigoProvincianLessThan(String value) {
            addCriterion("codigo_provincian <", value, "codigoProvincian");
            return (Criteria) this;
        }

        public Criteria andCodigoProvincianLessThanOrEqualTo(String value) {
            addCriterion("codigo_provincian <=", value, "codigoProvincian");
            return (Criteria) this;
        }

        public Criteria andCodigoProvincianLike(String value) {
            addCriterion("codigo_provincian like", value, "codigoProvincian");
            return (Criteria) this;
        }

        public Criteria andCodigoProvincianNotLike(String value) {
            addCriterion("codigo_provincian not like", value, "codigoProvincian");
            return (Criteria) this;
        }

        public Criteria andCodigoProvincianIn(List<String> values) {
            addCriterion("codigo_provincian in", values, "codigoProvincian");
            return (Criteria) this;
        }

        public Criteria andCodigoProvincianNotIn(List<String> values) {
            addCriterion("codigo_provincian not in", values, "codigoProvincian");
            return (Criteria) this;
        }

        public Criteria andCodigoProvincianBetween(String value1, String value2) {
            addCriterion("codigo_provincian between", value1, value2, "codigoProvincian");
            return (Criteria) this;
        }

        public Criteria andCodigoProvincianNotBetween(String value1, String value2) {
            addCriterion("codigo_provincian not between", value1, value2, "codigoProvincian");
            return (Criteria) this;
        }

        public Criteria andCodigoLugarnIsNull() {
            addCriterion("codigo_lugarn is null");
            return (Criteria) this;
        }

        public Criteria andCodigoLugarnIsNotNull() {
            addCriterion("codigo_lugarn is not null");
            return (Criteria) this;
        }

        public Criteria andCodigoLugarnEqualTo(String value) {
            addCriterion("codigo_lugarn =", value, "codigoLugarn");
            return (Criteria) this;
        }

        public Criteria andCodigoLugarnNotEqualTo(String value) {
            addCriterion("codigo_lugarn <>", value, "codigoLugarn");
            return (Criteria) this;
        }

        public Criteria andCodigoLugarnGreaterThan(String value) {
            addCriterion("codigo_lugarn >", value, "codigoLugarn");
            return (Criteria) this;
        }

        public Criteria andCodigoLugarnGreaterThanOrEqualTo(String value) {
            addCriterion("codigo_lugarn >=", value, "codigoLugarn");
            return (Criteria) this;
        }

        public Criteria andCodigoLugarnLessThan(String value) {
            addCriterion("codigo_lugarn <", value, "codigoLugarn");
            return (Criteria) this;
        }

        public Criteria andCodigoLugarnLessThanOrEqualTo(String value) {
            addCriterion("codigo_lugarn <=", value, "codigoLugarn");
            return (Criteria) this;
        }

        public Criteria andCodigoLugarnLike(String value) {
            addCriterion("codigo_lugarn like", value, "codigoLugarn");
            return (Criteria) this;
        }

        public Criteria andCodigoLugarnNotLike(String value) {
            addCriterion("codigo_lugarn not like", value, "codigoLugarn");
            return (Criteria) this;
        }

        public Criteria andCodigoLugarnIn(List<String> values) {
            addCriterion("codigo_lugarn in", values, "codigoLugarn");
            return (Criteria) this;
        }

        public Criteria andCodigoLugarnNotIn(List<String> values) {
            addCriterion("codigo_lugarn not in", values, "codigoLugarn");
            return (Criteria) this;
        }

        public Criteria andCodigoLugarnBetween(String value1, String value2) {
            addCriterion("codigo_lugarn between", value1, value2, "codigoLugarn");
            return (Criteria) this;
        }

        public Criteria andCodigoLugarnNotBetween(String value1, String value2) {
            addCriterion("codigo_lugarn not between", value1, value2, "codigoLugarn");
            return (Criteria) this;
        }

        public Criteria andCodigoNacionalidadIsNull() {
            addCriterion("codigo_nacionalidad is null");
            return (Criteria) this;
        }

        public Criteria andCodigoNacionalidadIsNotNull() {
            addCriterion("codigo_nacionalidad is not null");
            return (Criteria) this;
        }

        public Criteria andCodigoNacionalidadEqualTo(String value) {
            addCriterion("codigo_nacionalidad =", value, "codigoNacionalidad");
            return (Criteria) this;
        }

        public Criteria andCodigoNacionalidadNotEqualTo(String value) {
            addCriterion("codigo_nacionalidad <>", value, "codigoNacionalidad");
            return (Criteria) this;
        }

        public Criteria andCodigoNacionalidadGreaterThan(String value) {
            addCriterion("codigo_nacionalidad >", value, "codigoNacionalidad");
            return (Criteria) this;
        }

        public Criteria andCodigoNacionalidadGreaterThanOrEqualTo(String value) {
            addCriterion("codigo_nacionalidad >=", value, "codigoNacionalidad");
            return (Criteria) this;
        }

        public Criteria andCodigoNacionalidadLessThan(String value) {
            addCriterion("codigo_nacionalidad <", value, "codigoNacionalidad");
            return (Criteria) this;
        }

        public Criteria andCodigoNacionalidadLessThanOrEqualTo(String value) {
            addCriterion("codigo_nacionalidad <=", value, "codigoNacionalidad");
            return (Criteria) this;
        }

        public Criteria andCodigoNacionalidadLike(String value) {
            addCriterion("codigo_nacionalidad like", value, "codigoNacionalidad");
            return (Criteria) this;
        }

        public Criteria andCodigoNacionalidadNotLike(String value) {
            addCriterion("codigo_nacionalidad not like", value, "codigoNacionalidad");
            return (Criteria) this;
        }

        public Criteria andCodigoNacionalidadIn(List<String> values) {
            addCriterion("codigo_nacionalidad in", values, "codigoNacionalidad");
            return (Criteria) this;
        }

        public Criteria andCodigoNacionalidadNotIn(List<String> values) {
            addCriterion("codigo_nacionalidad not in", values, "codigoNacionalidad");
            return (Criteria) this;
        }

        public Criteria andCodigoNacionalidadBetween(String value1, String value2) {
            addCriterion("codigo_nacionalidad between", value1, value2, "codigoNacionalidad");
            return (Criteria) this;
        }

        public Criteria andCodigoNacionalidadNotBetween(String value1, String value2) {
            addCriterion("codigo_nacionalidad not between", value1, value2, "codigoNacionalidad");
            return (Criteria) this;
        }

        public Criteria andObservacionesIsNull() {
            addCriterion("observaciones is null");
            return (Criteria) this;
        }

        public Criteria andObservacionesIsNotNull() {
            addCriterion("observaciones is not null");
            return (Criteria) this;
        }

        public Criteria andObservacionesEqualTo(String value) {
            addCriterion("observaciones =", value, "observaciones");
            return (Criteria) this;
        }

        public Criteria andObservacionesNotEqualTo(String value) {
            addCriterion("observaciones <>", value, "observaciones");
            return (Criteria) this;
        }

        public Criteria andObservacionesGreaterThan(String value) {
            addCriterion("observaciones >", value, "observaciones");
            return (Criteria) this;
        }

        public Criteria andObservacionesGreaterThanOrEqualTo(String value) {
            addCriterion("observaciones >=", value, "observaciones");
            return (Criteria) this;
        }

        public Criteria andObservacionesLessThan(String value) {
            addCriterion("observaciones <", value, "observaciones");
            return (Criteria) this;
        }

        public Criteria andObservacionesLessThanOrEqualTo(String value) {
            addCriterion("observaciones <=", value, "observaciones");
            return (Criteria) this;
        }

        public Criteria andObservacionesLike(String value) {
            addCriterion("observaciones like", value, "observaciones");
            return (Criteria) this;
        }

        public Criteria andObservacionesNotLike(String value) {
            addCriterion("observaciones not like", value, "observaciones");
            return (Criteria) this;
        }

        public Criteria andObservacionesIn(List<String> values) {
            addCriterion("observaciones in", values, "observaciones");
            return (Criteria) this;
        }

        public Criteria andObservacionesNotIn(List<String> values) {
            addCriterion("observaciones not in", values, "observaciones");
            return (Criteria) this;
        }

        public Criteria andObservacionesBetween(String value1, String value2) {
            addCriterion("observaciones between", value1, value2, "observaciones");
            return (Criteria) this;
        }

        public Criteria andObservacionesNotBetween(String value1, String value2) {
            addCriterion("observaciones not between", value1, value2, "observaciones");
            return (Criteria) this;
        }
    }

    /**
     * 
     * personas_datos_nacimiento
     *
     * 
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 
     * personas_datos_nacimiento
     *
     * 
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