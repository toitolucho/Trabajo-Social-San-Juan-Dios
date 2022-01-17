package org.quarkbit.trabajosocialsanjuan.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class PaisExample {
    /**
     *
     * table paises
     *
     * 
     */
    protected String orderByClause;

    /**
     *
     * table paises
     *
     * 
     */
    protected boolean distinct;

    /**
     *
     * table paises
     *
     * 
     */
    protected List<Criteria> oredCriteria;

    /**
     * 
     * table paises
     *
     * 
     */
    public PaisExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 
     * table paises
     *
     * 
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 
     * table paises
     *
     * 
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 
     * table paises
     *
     * 
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 
     * table paises
     *
     * 
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 
     * table paises
     *
     * 
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 
     * table paises
     *
     * 
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 
     * table paises
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
     * table paises
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
     * table paises
     *
     * 
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 
     * table paises
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
     * paises
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

        public Criteria andCodigoPaisIsNull() {
            addCriterion("codigo_pais is null");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisIsNotNull() {
            addCriterion("codigo_pais is not null");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisEqualTo(String value) {
            addCriterion("codigo_pais =", value, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisNotEqualTo(String value) {
            addCriterion("codigo_pais <>", value, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisGreaterThan(String value) {
            addCriterion("codigo_pais >", value, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisGreaterThanOrEqualTo(String value) {
            addCriterion("codigo_pais >=", value, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisLessThan(String value) {
            addCriterion("codigo_pais <", value, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisLessThanOrEqualTo(String value) {
            addCriterion("codigo_pais <=", value, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisLike(String value) {
            addCriterion("upper(codigo_pais) like", value, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisNotLike(String value) {
            addCriterion("codigo_pais not like", value, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisIn(List<String> values) {
            addCriterion("codigo_pais in", values, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisNotIn(List<String> values) {
            addCriterion("codigo_pais not in", values, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisBetween(String value1, String value2) {
            addCriterion("codigo_pais between", value1, value2, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisNotBetween(String value1, String value2) {
            addCriterion("codigo_pais not between", value1, value2, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andNombrePaisIsNull() {
            addCriterion("nombre_pais is null");
            return (Criteria) this;
        }

        public Criteria andNombrePaisIsNotNull() {
            addCriterion("nombre_pais is not null");
            return (Criteria) this;
        }

        public Criteria andNombrePaisEqualTo(String value) {
            addCriterion("nombre_pais =", value, "nombrePais");
            return (Criteria) this;
        }

        public Criteria andNombrePaisNotEqualTo(String value) {
            addCriterion("nombre_pais <>", value, "nombrePais");
            return (Criteria) this;
        }

        public Criteria andNombrePaisGreaterThan(String value) {
            addCriterion("nombre_pais >", value, "nombrePais");
            return (Criteria) this;
        }

        public Criteria andNombrePaisGreaterThanOrEqualTo(String value) {
            addCriterion("nombre_pais >=", value, "nombrePais");
            return (Criteria) this;
        }

        public Criteria andNombrePaisLessThan(String value) {
            addCriterion("nombre_pais <", value, "nombrePais");
            return (Criteria) this;
        }

        public Criteria andNombrePaisLessThanOrEqualTo(String value) {
            addCriterion("nombre_pais <=", value, "nombrePais");
            return (Criteria) this;
        }

        public Criteria andNombrePaisLike(String value) {
            addCriterion("upper(nombre_pais) like", value, "nombrePais");
            return (Criteria) this;
        }

        public Criteria andNombrePaisNotLike(String value) {
            addCriterion("nombre_pais not like", value, "nombrePais");
            return (Criteria) this;
        }

        public Criteria andNombrePaisIn(List<String> values) {
            addCriterion("nombre_pais in", values, "nombrePais");
            return (Criteria) this;
        }

        public Criteria andNombrePaisNotIn(List<String> values) {
            addCriterion("nombre_pais not in", values, "nombrePais");
            return (Criteria) this;
        }

        public Criteria andNombrePaisBetween(String value1, String value2) {
            addCriterion("nombre_pais between", value1, value2, "nombrePais");
            return (Criteria) this;
        }

        public Criteria andNombrePaisNotBetween(String value1, String value2) {
            addCriterion("nombre_pais not between", value1, value2, "nombrePais");
            return (Criteria) this;
        }

        public Criteria andNacionalidadIsNull() {
            addCriterion("nacionalidad is null");
            return (Criteria) this;
        }

        public Criteria andNacionalidadIsNotNull() {
            addCriterion("nacionalidad is not null");
            return (Criteria) this;
        }

        public Criteria andNacionalidadEqualTo(String value) {
            addCriterion("nacionalidad =", value, "nacionalidad");
            return (Criteria) this;
        }

        public Criteria andNacionalidadNotEqualTo(String value) {
            addCriterion("nacionalidad <>", value, "nacionalidad");
            return (Criteria) this;
        }

        public Criteria andNacionalidadGreaterThan(String value) {
            addCriterion("nacionalidad >", value, "nacionalidad");
            return (Criteria) this;
        }

        public Criteria andNacionalidadGreaterThanOrEqualTo(String value) {
            addCriterion("nacionalidad >=", value, "nacionalidad");
            return (Criteria) this;
        }

        public Criteria andNacionalidadLessThan(String value) {
            addCriterion("nacionalidad <", value, "nacionalidad");
            return (Criteria) this;
        }

        public Criteria andNacionalidadLessThanOrEqualTo(String value) {
            addCriterion("nacionalidad <=", value, "nacionalidad");
            return (Criteria) this;
        }

        public Criteria andNacionalidadLike(String value) {
            addCriterion("nacionalidad like", value, "nacionalidad");
            return (Criteria) this;
        }

        public Criteria andNacionalidadNotLike(String value) {
            addCriterion("nacionalidad not like", value, "nacionalidad");
            return (Criteria) this;
        }

        public Criteria andNacionalidadIn(List<String> values) {
            addCriterion("nacionalidad in", values, "nacionalidad");
            return (Criteria) this;
        }

        public Criteria andNacionalidadNotIn(List<String> values) {
            addCriterion("nacionalidad not in", values, "nacionalidad");
            return (Criteria) this;
        }

        public Criteria andNacionalidadBetween(String value1, String value2) {
            addCriterion("nacionalidad between", value1, value2, "nacionalidad");
            return (Criteria) this;
        }

        public Criteria andNacionalidadNotBetween(String value1, String value2) {
            addCriterion("nacionalidad not between", value1, value2, "nacionalidad");
            return (Criteria) this;
        }
    }

    /**
     * 
     * paises
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
     * paises
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