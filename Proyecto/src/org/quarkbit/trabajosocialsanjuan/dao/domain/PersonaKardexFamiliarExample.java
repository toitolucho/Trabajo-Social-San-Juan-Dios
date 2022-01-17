package org.quarkbit.trabajosocialsanjuan.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PersonaKardexFamiliarExample {
    /**
     *
     * table personas_kardex_familiares
     *
     * 
     */
    protected String orderByClause;

    /**
     *
     * table personas_kardex_familiares
     *
     * 
     */
    protected boolean distinct;

    /**
     *
     * table personas_kardex_familiares
     *
     * 
     */
    protected List<Criteria> oredCriteria;

    /**
     * 
     * table personas_kardex_familiares
     *
     * 
     */
    public PersonaKardexFamiliarExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 
     * table personas_kardex_familiares
     *
     * 
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 
     * table personas_kardex_familiares
     *
     * 
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 
     * table personas_kardex_familiares
     *
     * 
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 
     * table personas_kardex_familiares
     *
     * 
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 
     * table personas_kardex_familiares
     *
     * 
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 
     * table personas_kardex_familiares
     *
     * 
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 
     * table personas_kardex_familiares
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
     * table personas_kardex_familiares
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
     * table personas_kardex_familiares
     *
     * 
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 
     * table personas_kardex_familiares
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
     * personas_kardex_familiares
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

        public Criteria andCodigoKardexIsNull() {
            addCriterion("codigo_kardex is null");
            return (Criteria) this;
        }

        public Criteria andCodigoKardexIsNotNull() {
            addCriterion("codigo_kardex is not null");
            return (Criteria) this;
        }

        public Criteria andCodigoKardexEqualTo(Integer value) {
            addCriterion("codigo_kardex =", value, "codigoKardex");
            return (Criteria) this;
        }

        public Criteria andCodigoKardexNotEqualTo(Integer value) {
            addCriterion("codigo_kardex <>", value, "codigoKardex");
            return (Criteria) this;
        }

        public Criteria andCodigoKardexGreaterThan(Integer value) {
            addCriterion("codigo_kardex >", value, "codigoKardex");
            return (Criteria) this;
        }

        public Criteria andCodigoKardexGreaterThanOrEqualTo(Integer value) {
            addCriterion("codigo_kardex >=", value, "codigoKardex");
            return (Criteria) this;
        }

        public Criteria andCodigoKardexLessThan(Integer value) {
            addCriterion("codigo_kardex <", value, "codigoKardex");
            return (Criteria) this;
        }

        public Criteria andCodigoKardexLessThanOrEqualTo(Integer value) {
            addCriterion("codigo_kardex <=", value, "codigoKardex");
            return (Criteria) this;
        }

        public Criteria andCodigoKardexIn(List<Integer> values) {
            addCriterion("codigo_kardex in", values, "codigoKardex");
            return (Criteria) this;
        }

        public Criteria andCodigoKardexNotIn(List<Integer> values) {
            addCriterion("codigo_kardex not in", values, "codigoKardex");
            return (Criteria) this;
        }

        public Criteria andCodigoKardexBetween(Integer value1, Integer value2) {
            addCriterion("codigo_kardex between", value1, value2, "codigoKardex");
            return (Criteria) this;
        }

        public Criteria andCodigoKardexNotBetween(Integer value1, Integer value2) {
            addCriterion("codigo_kardex not between", value1, value2, "codigoKardex");
            return (Criteria) this;
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

        public Criteria andCodigoParentescoIsNull() {
            addCriterion("codigo_parentesco is null");
            return (Criteria) this;
        }

        public Criteria andCodigoParentescoIsNotNull() {
            addCriterion("codigo_parentesco is not null");
            return (Criteria) this;
        }

        public Criteria andCodigoParentescoEqualTo(Integer value) {
            addCriterion("codigo_parentesco =", value, "codigoParentesco");
            return (Criteria) this;
        }

        public Criteria andCodigoParentescoNotEqualTo(Integer value) {
            addCriterion("codigo_parentesco <>", value, "codigoParentesco");
            return (Criteria) this;
        }

        public Criteria andCodigoParentescoGreaterThan(Integer value) {
            addCriterion("codigo_parentesco >", value, "codigoParentesco");
            return (Criteria) this;
        }

        public Criteria andCodigoParentescoGreaterThanOrEqualTo(Integer value) {
            addCriterion("codigo_parentesco >=", value, "codigoParentesco");
            return (Criteria) this;
        }

        public Criteria andCodigoParentescoLessThan(Integer value) {
            addCriterion("codigo_parentesco <", value, "codigoParentesco");
            return (Criteria) this;
        }

        public Criteria andCodigoParentescoLessThanOrEqualTo(Integer value) {
            addCriterion("codigo_parentesco <=", value, "codigoParentesco");
            return (Criteria) this;
        }

        public Criteria andCodigoParentescoIn(List<Integer> values) {
            addCriterion("codigo_parentesco in", values, "codigoParentesco");
            return (Criteria) this;
        }

        public Criteria andCodigoParentescoNotIn(List<Integer> values) {
            addCriterion("codigo_parentesco not in", values, "codigoParentesco");
            return (Criteria) this;
        }

        public Criteria andCodigoParentescoBetween(Integer value1, Integer value2) {
            addCriterion("codigo_parentesco between", value1, value2, "codigoParentesco");
            return (Criteria) this;
        }

        public Criteria andCodigoParentescoNotBetween(Integer value1, Integer value2) {
            addCriterion("codigo_parentesco not between", value1, value2, "codigoParentesco");
            return (Criteria) this;
        }

        public Criteria andMontoIngresoIsNull() {
            addCriterion("monto_ingreso is null");
            return (Criteria) this;
        }

        public Criteria andMontoIngresoIsNotNull() {
            addCriterion("monto_ingreso is not null");
            return (Criteria) this;
        }

        public Criteria andMontoIngresoEqualTo(Double value) {
            addCriterion("monto_ingreso =", value, "montoIngreso");
            return (Criteria) this;
        }

        public Criteria andMontoIngresoNotEqualTo(Double value) {
            addCriterion("monto_ingreso <>", value, "montoIngreso");
            return (Criteria) this;
        }

        public Criteria andMontoIngresoGreaterThan(Double value) {
            addCriterion("monto_ingreso >", value, "montoIngreso");
            return (Criteria) this;
        }

        public Criteria andMontoIngresoGreaterThanOrEqualTo(Double value) {
            addCriterion("monto_ingreso >=", value, "montoIngreso");
            return (Criteria) this;
        }

        public Criteria andMontoIngresoLessThan(Double value) {
            addCriterion("monto_ingreso <", value, "montoIngreso");
            return (Criteria) this;
        }

        public Criteria andMontoIngresoLessThanOrEqualTo(Double value) {
            addCriterion("monto_ingreso <=", value, "montoIngreso");
            return (Criteria) this;
        }

        public Criteria andMontoIngresoIn(List<Double> values) {
            addCriterion("monto_ingreso in", values, "montoIngreso");
            return (Criteria) this;
        }

        public Criteria andMontoIngresoNotIn(List<Double> values) {
            addCriterion("monto_ingreso not in", values, "montoIngreso");
            return (Criteria) this;
        }

        public Criteria andMontoIngresoBetween(Double value1, Double value2) {
            addCriterion("monto_ingreso between", value1, value2, "montoIngreso");
            return (Criteria) this;
        }

        public Criteria andMontoIngresoNotBetween(Double value1, Double value2) {
            addCriterion("monto_ingreso not between", value1, value2, "montoIngreso");
            return (Criteria) this;
        }

        public Criteria andFechaRegistroIsNull() {
            addCriterion("fecha_registro is null");
            return (Criteria) this;
        }

        public Criteria andFechaRegistroIsNotNull() {
            addCriterion("fecha_registro is not null");
            return (Criteria) this;
        }

        public Criteria andFechaRegistroEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_registro =", value, "fechaRegistro");
            return (Criteria) this;
        }

        public Criteria andFechaRegistroNotEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_registro <>", value, "fechaRegistro");
            return (Criteria) this;
        }

        public Criteria andFechaRegistroGreaterThan(Date value) {
            addCriterionForJDBCDate("fecha_registro >", value, "fechaRegistro");
            return (Criteria) this;
        }

        public Criteria andFechaRegistroGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_registro >=", value, "fechaRegistro");
            return (Criteria) this;
        }

        public Criteria andFechaRegistroLessThan(Date value) {
            addCriterionForJDBCDate("fecha_registro <", value, "fechaRegistro");
            return (Criteria) this;
        }

        public Criteria andFechaRegistroLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_registro <=", value, "fechaRegistro");
            return (Criteria) this;
        }

        public Criteria andFechaRegistroIn(List<Date> values) {
            addCriterionForJDBCDate("fecha_registro in", values, "fechaRegistro");
            return (Criteria) this;
        }

        public Criteria andFechaRegistroNotIn(List<Date> values) {
            addCriterionForJDBCDate("fecha_registro not in", values, "fechaRegistro");
            return (Criteria) this;
        }

        public Criteria andFechaRegistroBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fecha_registro between", value1, value2, "fechaRegistro");
            return (Criteria) this;
        }

        public Criteria andFechaRegistroNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fecha_registro not between", value1, value2, "fechaRegistro");
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
     * personas_kardex_familiares
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
     * personas_kardex_familiares
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