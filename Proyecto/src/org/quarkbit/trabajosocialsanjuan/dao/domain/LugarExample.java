package org.quarkbit.trabajosocialsanjuan.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class LugarExample {
    /**
     *
     * table lugares
     *
     * 
     */
    protected String orderByClause;

    /**
     *
     * table lugares
     *
     * 
     */
    protected boolean distinct;

    /**
     *
     * table lugares
     *
     * 
     */
    protected List<Criteria> oredCriteria;

    /**
     * 
     * table lugares
     *
     * 
     */
    public LugarExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 
     * table lugares
     *
     * 
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 
     * table lugares
     *
     * 
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 
     * table lugares
     *
     * 
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 
     * table lugares
     *
     * 
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 
     * table lugares
     *
     * 
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 
     * table lugares
     *
     * 
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 
     * table lugares
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
     * table lugares
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
     * table lugares
     *
     * 
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 
     * table lugares
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
     * lugares
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
            addCriterion("l.codigo_pais is null");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisIsNotNull() {
            addCriterion("l.codigo_pais is not null");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisEqualTo(String value) {
            addCriterion("l.codigo_pais =", value, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisNotEqualTo(String value) {
            addCriterion("l.codigo_pais <>", value, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisGreaterThan(String value) {
            addCriterion("l.codigo_pais >", value, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisGreaterThanOrEqualTo(String value) {
            addCriterion("l.codigo_pais >=", value, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisLessThan(String value) {
            addCriterion("l.codigo_pais <", value, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisLessThanOrEqualTo(String value) {
            addCriterion("l.codigo_pais <=", value, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisLike(String value) {
            addCriterion("l.codigo_pais like", value, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisNotLike(String value) {
            addCriterion("l.codigo_pais not like", value, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisIn(List<String> values) {
            addCriterion("l.codigo_pais in", values, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisNotIn(List<String> values) {
            addCriterion("l.codigo_pais not in", values, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisBetween(String value1, String value2) {
            addCriterion("l.codigo_pais between", value1, value2, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisNotBetween(String value1, String value2) {
            addCriterion("l.codigo_pais not between", value1, value2, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentoIsNull() {
            addCriterion("l.codigo_departamento is null");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentoIsNotNull() {
            addCriterion("l.codigo_departamento is not null");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentoEqualTo(String value) {
            addCriterion("l.codigo_departamento =", value, "codigoDepartamento");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentoNotEqualTo(String value) {
            addCriterion("l.codigo_departamento <>", value, "codigoDepartamento");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentoGreaterThan(String value) {
            addCriterion("l.codigo_departamento >", value, "codigoDepartamento");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentoGreaterThanOrEqualTo(String value) {
            addCriterion("l.codigo_departamento >=", value, "codigoDepartamento");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentoLessThan(String value) {
            addCriterion("l.codigo_departamento <", value, "codigoDepartamento");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentoLessThanOrEqualTo(String value) {
            addCriterion("l.codigo_departamento <=", value, "codigoDepartamento");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentoLike(String value) {
            addCriterion("l.codigo_departamento like", value, "codigoDepartamento");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentoNotLike(String value) {
            addCriterion("l.codigo_departamento not like", value, "codigoDepartamento");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentoIn(List<String> values) {
            addCriterion("l.codigo_departamento in", values, "codigoDepartamento");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentoNotIn(List<String> values) {
            addCriterion("l.codigo_departamento not in", values, "codigoDepartamento");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentoBetween(String value1, String value2) {
            addCriterion("l.codigo_departamento between", value1, value2, "codigoDepartamento");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentoNotBetween(String value1, String value2) {
            addCriterion("l.codigo_departamento not between", value1, value2, "codigoDepartamento");
            return (Criteria) this;
        }

        public Criteria andCodigoProvinciaIsNull() {
            addCriterion("l.codigo_provincia is null");
            return (Criteria) this;
        }

        public Criteria andCodigoProvinciaIsNotNull() {
            addCriterion("l.codigo_provincia is not null");
            return (Criteria) this;
        }

        public Criteria andCodigoProvinciaEqualTo(String value) {
            addCriterion("l.codigo_provincia =", value, "codigoProvincia");
            return (Criteria) this;
        }

        public Criteria andCodigoProvinciaNotEqualTo(String value) {
            addCriterion("l.codigo_provincia <>", value, "codigoProvincia");
            return (Criteria) this;
        }

        public Criteria andCodigoProvinciaGreaterThan(String value) {
            addCriterion("l.codigo_provincia >", value, "codigoProvincia");
            return (Criteria) this;
        }

        public Criteria andCodigoProvinciaGreaterThanOrEqualTo(String value) {
            addCriterion("l.codigo_provincia >=", value, "codigoProvincia");
            return (Criteria) this;
        }

        public Criteria andCodigoProvinciaLessThan(String value) {
            addCriterion("l.codigo_provincia <", value, "codigoProvincia");
            return (Criteria) this;
        }

        public Criteria andCodigoProvinciaLessThanOrEqualTo(String value) {
            addCriterion("l.codigo_provincia <=", value, "codigoProvincia");
            return (Criteria) this;
        }

        public Criteria andCodigoProvinciaLike(String value) {
            addCriterion("l.codigo_provincia like", value, "codigoProvincia");
            return (Criteria) this;
        }

        public Criteria andCodigoProvinciaNotLike(String value) {
            addCriterion("l.codigo_provincia not like", value, "codigoProvincia");
            return (Criteria) this;
        }

        public Criteria andCodigoProvinciaIn(List<String> values) {
            addCriterion("l.codigo_provincia in", values, "codigoProvincia");
            return (Criteria) this;
        }

        public Criteria andCodigoProvinciaNotIn(List<String> values) {
            addCriterion("l.codigo_provincia not in", values, "codigoProvincia");
            return (Criteria) this;
        }

        public Criteria andCodigoProvinciaBetween(String value1, String value2) {
            addCriterion("l.codigo_provincia between", value1, value2, "codigoProvincia");
            return (Criteria) this;
        }

        public Criteria andCodigoProvinciaNotBetween(String value1, String value2) {
            addCriterion("l.codigo_provincia not between", value1, value2, "codigoProvincia");
            return (Criteria) this;
        }

        public Criteria andCodigoLugarIsNull() {
            addCriterion("l.codigo_lugar is null");
            return (Criteria) this;
        }

        public Criteria andCodigoLugarIsNotNull() {
            addCriterion("l.codigo_lugar is not null");
            return (Criteria) this;
        }

        public Criteria andCodigoLugarEqualTo(String value) {
            addCriterion("l.codigo_lugar =", value, "codigoLugar");
            return (Criteria) this;
        }

        public Criteria andCodigoLugarNotEqualTo(String value) {
            addCriterion("l.codigo_lugar <>", value, "codigoLugar");
            return (Criteria) this;
        }

        public Criteria andCodigoLugarGreaterThan(String value) {
            addCriterion("l.codigo_lugar >", value, "codigoLugar");
            return (Criteria) this;
        }

        public Criteria andCodigoLugarGreaterThanOrEqualTo(String value) {
            addCriterion("l.codigo_lugar >=", value, "codigoLugar");
            return (Criteria) this;
        }

        public Criteria andCodigoLugarLessThan(String value) {
            addCriterion("l.codigo_lugar <", value, "codigoLugar");
            return (Criteria) this;
        }

        public Criteria andCodigoLugarLessThanOrEqualTo(String value) {
            addCriterion("l.codigo_lugar <=", value, "codigoLugar");
            return (Criteria) this;
        }

        public Criteria andCodigoLugarLike(String value) {
            addCriterion("upper(l.codigo_lugar) like", value, "codigoLugar");
            return (Criteria) this;
        }

        public Criteria andCodigoLugarNotLike(String value) {
            addCriterion("l.codigo_lugar not like", value, "codigoLugar");
            return (Criteria) this;
        }

        public Criteria andCodigoLugarIn(List<String> values) {
            addCriterion("l.codigo_lugar in", values, "codigoLugar");
            return (Criteria) this;
        }

        public Criteria andCodigoLugarNotIn(List<String> values) {
            addCriterion("l.codigo_lugar not in", values, "codigoLugar");
            return (Criteria) this;
        }

        public Criteria andCodigoLugarBetween(String value1, String value2) {
            addCriterion("l.codigo_lugar between", value1, value2, "codigoLugar");
            return (Criteria) this;
        }

        public Criteria andCodigoLugarNotBetween(String value1, String value2) {
            addCriterion("l.codigo_lugar not between", value1, value2, "codigoLugar");
            return (Criteria) this;
        }

        public Criteria andNombreLugarIsNull() {
            addCriterion("l.nombre_lugar is null");
            return (Criteria) this;
        }

        public Criteria andNombreLugarIsNotNull() {
            addCriterion("l.nombre_lugar is not null");
            return (Criteria) this;
        }

        public Criteria andNombreLugarEqualTo(String value) {
            addCriterion("l.nombre_lugar =", value, "nombreLugar");
            return (Criteria) this;
        }

        public Criteria andNombreLugarNotEqualTo(String value) {
            addCriterion("l.nombre_lugar <>", value, "nombreLugar");
            return (Criteria) this;
        }

        public Criteria andNombreLugarGreaterThan(String value) {
            addCriterion("l.nombre_lugar >", value, "nombreLugar");
            return (Criteria) this;
        }

        public Criteria andNombreLugarGreaterThanOrEqualTo(String value) {
            addCriterion("l.nombre_lugar >=", value, "nombreLugar");
            return (Criteria) this;
        }

        public Criteria andNombreLugarLessThan(String value) {
            addCriterion("l.nombre_lugar <", value, "nombreLugar");
            return (Criteria) this;
        }

        public Criteria andNombreLugarLessThanOrEqualTo(String value) {
            addCriterion("l.nombre_lugar <=", value, "nombreLugar");
            return (Criteria) this;
        }

        public Criteria andNombreLugarLike(String value) {
            addCriterion("upper(l.nombre_lugar) like", value, "nombreLugar");
            return (Criteria) this;
        }

        public Criteria andNombreLugarNotLike(String value) {
            addCriterion("l.nombre_lugar not like", value, "nombreLugar");
            return (Criteria) this;
        }

        public Criteria andNombreLugarIn(List<String> values) {
            addCriterion("l.nombre_lugar in", values, "nombreLugar");
            return (Criteria) this;
        }

        public Criteria andNombreLugarNotIn(List<String> values) {
            addCriterion("l.nombre_lugar not in", values, "nombreLugar");
            return (Criteria) this;
        }

        public Criteria andNombreLugarBetween(String value1, String value2) {
            addCriterion("l.nombre_lugar between", value1, value2, "nombreLugar");
            return (Criteria) this;
        }

        public Criteria andNombreLugarNotBetween(String value1, String value2) {
            addCriterion("l.nombre_lugar not between", value1, value2, "nombreLugar");
            return (Criteria) this;
        }
    }

    /**
     * 
     * lugares
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
     * lugares
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