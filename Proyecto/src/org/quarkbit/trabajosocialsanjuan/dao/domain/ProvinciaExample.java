package org.quarkbit.trabajosocialsanjuan.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class ProvinciaExample {
    /**
     *
     * table provincias
     *
     * 
     */
    protected String orderByClause;

    /**
     *
     * table provincias
     *
     * 
     */
    protected boolean distinct;

    /**
     *
     * table provincias
     *
     * 
     */
    protected List<Criteria> oredCriteria;

    /**
     * 
     * table provincias
     *
     * 
     */
    public ProvinciaExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 
     * table provincias
     *
     * 
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 
     * table provincias
     *
     * 
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 
     * table provincias
     *
     * 
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 
     * table provincias
     *
     * 
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 
     * table provincias
     *
     * 
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 
     * table provincias
     *
     * 
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 
     * table provincias
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
     * table provincias
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
     * table provincias
     *
     * 
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 
     * table provincias
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
     * provincias
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
            addCriterion("pro.codigo_pais is null");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisIsNotNull() {
            addCriterion("pro.codigo_pais is not null");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisEqualTo(String value) {
            addCriterion("pro.codigo_pais =", value, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisNotEqualTo(String value) {
            addCriterion("pro.codigo_pais <>", value, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisGreaterThan(String value) {
            addCriterion("pro.codigo_pais >", value, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisGreaterThanOrEqualTo(String value) {
            addCriterion("pro.codigo_pais >=", value, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisLessThan(String value) {
            addCriterion("pro.codigo_pais <", value, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisLessThanOrEqualTo(String value) {
            addCriterion("pro.codigo_pais <=", value, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisLike(String value) {
            addCriterion("pro.codigo_pais like", value, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisNotLike(String value) {
            addCriterion("pro.codigo_pais not like", value, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisIn(List<String> values) {
            addCriterion("pro.codigo_pais in", values, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisNotIn(List<String> values) {
            addCriterion("pro.codigo_pais not in", values, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisBetween(String value1, String value2) {
            addCriterion("pro.codigo_pais between", value1, value2, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisNotBetween(String value1, String value2) {
            addCriterion("pro.codigo_pais not between", value1, value2, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentoIsNull() {
            addCriterion("pro.codigo_departamento is null");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentoIsNotNull() {
            addCriterion("pro.codigo_departamento is not null");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentoEqualTo(String value) {
            addCriterion("pro.codigo_departamento =", value, "codigoDepartamento");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentoNotEqualTo(String value) {
            addCriterion("pro.codigo_departamento <>", value, "codigoDepartamento");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentoGreaterThan(String value) {
            addCriterion("pro.codigo_departamento >", value, "codigoDepartamento");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentoGreaterThanOrEqualTo(String value) {
            addCriterion("pro.codigo_departamento >=", value, "codigoDepartamento");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentoLessThan(String value) {
            addCriterion("pro.codigo_departamento <", value, "codigoDepartamento");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentoLessThanOrEqualTo(String value) {
            addCriterion("pro.codigo_departamento <=", value, "codigoDepartamento");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentoLike(String value) {
            addCriterion("pro.codigo_departamento like", value, "codigoDepartamento");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentoNotLike(String value) {
            addCriterion("pro.codigo_departamento not like", value, "codigoDepartamento");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentoIn(List<String> values) {
            addCriterion("pro.codigo_departamento in", values, "codigoDepartamento");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentoNotIn(List<String> values) {
            addCriterion("pro.codigo_departamento not in", values, "codigoDepartamento");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentoBetween(String value1, String value2) {
            addCriterion("pro.codigo_departamento between", value1, value2, "codigoDepartamento");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentoNotBetween(String value1, String value2) {
            addCriterion("pro.codigo_departamento not between", value1, value2, "codigoDepartamento");
            return (Criteria) this;
        }

        public Criteria andCodigoProvinciaIsNull() {
            addCriterion("pro.codigo_provincia is null");
            return (Criteria) this;
        }

        public Criteria andCodigoProvinciaIsNotNull() {
            addCriterion("pro.codigo_provincia is not null");
            return (Criteria) this;
        }

        public Criteria andCodigoProvinciaEqualTo(String value) {
            addCriterion("pro.codigo_provincia =", value, "codigoProvincia");
            return (Criteria) this;
        }

        public Criteria andCodigoProvinciaNotEqualTo(String value) {
            addCriterion("pro.codigo_provincia <>", value, "codigoProvincia");
            return (Criteria) this;
        }

        public Criteria andCodigoProvinciaGreaterThan(String value) {
            addCriterion("pro.codigo_provincia >", value, "codigoProvincia");
            return (Criteria) this;
        }

        public Criteria andCodigoProvinciaGreaterThanOrEqualTo(String value) {
            addCriterion("pro.codigo_provincia >=", value, "codigoProvincia");
            return (Criteria) this;
        }

        public Criteria andCodigoProvinciaLessThan(String value) {
            addCriterion("pro.codigo_provincia <", value, "codigoProvincia");
            return (Criteria) this;
        }

        public Criteria andCodigoProvinciaLessThanOrEqualTo(String value) {
            addCriterion("pro.codigo_provincia <=", value, "codigoProvincia");
            return (Criteria) this;
        }

        public Criteria andCodigoProvinciaLike(String value) {
            addCriterion("upper(pro.codigo_provincia) like", value, "codigoProvincia");
            return (Criteria) this;
        }

        public Criteria andCodigoProvinciaNotLike(String value) {
            addCriterion("pro.codigo_provincia not like", value, "codigoProvincia");
            return (Criteria) this;
        }

        public Criteria andCodigoProvinciaIn(List<String> values) {
            addCriterion("pro.codigo_provincia in", values, "codigoProvincia");
            return (Criteria) this;
        }

        public Criteria andCodigoProvinciaNotIn(List<String> values) {
            addCriterion("pro.codigo_provincia not in", values, "codigoProvincia");
            return (Criteria) this;
        }

        public Criteria andCodigoProvinciaBetween(String value1, String value2) {
            addCriterion("pro.codigo_provincia between", value1, value2, "codigoProvincia");
            return (Criteria) this;
        }

        public Criteria andCodigoProvinciaNotBetween(String value1, String value2) {
            addCriterion("pro.codigo_provincia not between", value1, value2, "codigoProvincia");
            return (Criteria) this;
        }

        public Criteria andNombreProvinciaIsNull() {
            addCriterion("pro.nombre_provincia is null");
            return (Criteria) this;
        }

        public Criteria andNombreProvinciaIsNotNull() {
            addCriterion("pro.nombre_provincia is not null");
            return (Criteria) this;
        }

        public Criteria andNombreProvinciaEqualTo(String value) {
            addCriterion("pro.nombre_provincia =", value, "nombreProvincia");
            return (Criteria) this;
        }

        public Criteria andNombreProvinciaNotEqualTo(String value) {
            addCriterion("pro.nombre_provincia <>", value, "nombreProvincia");
            return (Criteria) this;
        }

        public Criteria andNombreProvinciaGreaterThan(String value) {
            addCriterion("pro.nombre_provincia >", value, "nombreProvincia");
            return (Criteria) this;
        }

        public Criteria andNombreProvinciaGreaterThanOrEqualTo(String value) {
            addCriterion("pro.nombre_provincia >=", value, "nombreProvincia");
            return (Criteria) this;
        }

        public Criteria andNombreProvinciaLessThan(String value) {
            addCriterion("pro.nombre_provincia <", value, "nombreProvincia");
            return (Criteria) this;
        }

        public Criteria andNombreProvinciaLessThanOrEqualTo(String value) {
            addCriterion("pro.nombre_provincia <=", value, "nombreProvincia");
            return (Criteria) this;
        }

        public Criteria andNombreProvinciaLike(String value) {
            addCriterion("upper(pro.nombre_provincia) like", value, "nombreProvincia");
            return (Criteria) this;
        }

        public Criteria andNombreProvinciaNotLike(String value) {
            addCriterion("pro.nombre_provincia not like", value, "nombreProvincia");
            return (Criteria) this;
        }

        public Criteria andNombreProvinciaIn(List<String> values) {
            addCriterion("pro.nombre_provincia in", values, "nombreProvincia");
            return (Criteria) this;
        }

        public Criteria andNombreProvinciaNotIn(List<String> values) {
            addCriterion("pro.nombre_provincia not in", values, "nombreProvincia");
            return (Criteria) this;
        }

        public Criteria andNombreProvinciaBetween(String value1, String value2) {
            addCriterion("pro.nombre_provincia between", value1, value2, "nombreProvincia");
            return (Criteria) this;
        }

        public Criteria andNombreProvinciaNotBetween(String value1, String value2) {
            addCriterion("pro.nombre_provincia not between", value1, value2, "nombreProvincia");
            return (Criteria) this;
        }
    }

    /**
     * 
     * provincias
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
     * provincias
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