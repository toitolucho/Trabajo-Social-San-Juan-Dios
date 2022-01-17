package org.quarkbit.trabajosocialsanjuan.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class DepartamentoExample {
    /**
     *
     * table departamentos
     *
     * 
     */
    protected String orderByClause;

    /**
     *
     * table departamentos
     *
     * 
     */
    protected boolean distinct;

    /**
     *
     * table departamentos
     *
     * 
     */
    protected List<Criteria> oredCriteria;

    /**
     * 
     * table departamentos
     *
     * 
     */
    public DepartamentoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 
     * table departamentos
     *
     * 
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 
     * table departamentos
     *
     * 
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 
     * table departamentos
     *
     * 
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 
     * table departamentos
     *
     * 
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 
     * table departamentos
     *
     * 
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 
     * table departamentos
     *
     * 
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 
     * table departamentos
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
     * table departamentos
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
     * table departamentos
     *
     * 
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 
     * table departamentos
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
     * departamentos
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
            addCriterion("d.codigo_pais is null");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisIsNotNull() {
            addCriterion("d.codigo_pais is not null");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisEqualTo(String value) {
            addCriterion("d.codigo_pais =", value, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisNotEqualTo(String value) {
            addCriterion("d.codigo_pais <>", value, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisGreaterThan(String value) {
            addCriterion("d.codigo_pais >", value, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisGreaterThanOrEqualTo(String value) {
            addCriterion("d.codigo_pais >=", value, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisLessThan(String value) {
            addCriterion("d.codigo_pais <", value, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisLessThanOrEqualTo(String value) {
            addCriterion("d.codigo_pais <=", value, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisLike(String value) {
            addCriterion("upper(d.codigo_pais) like", value, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisNotLike(String value) {
            addCriterion("d.codigo_pais not like", value, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisIn(List<String> values) {
            addCriterion("d.codigo_pais in", values, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisNotIn(List<String> values) {
            addCriterion("d.codigo_pais not in", values, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisBetween(String value1, String value2) {
            addCriterion("d.codigo_pais between", value1, value2, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoPaisNotBetween(String value1, String value2) {
            addCriterion("d.codigo_pais not between", value1, value2, "codigoPais");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentoIsNull() {
            addCriterion("d.codigo_departamento is null");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentoIsNotNull() {
            addCriterion("d.codigo_departamento is not null");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentoEqualTo(String value) {
            addCriterion("d.codigo_departamento =", value, "codigoDepartamento");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentoNotEqualTo(String value) {
            addCriterion("d.codigo_departamento <>", value, "codigoDepartamento");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentoGreaterThan(String value) {
            addCriterion("d.codigo_departamento >", value, "codigoDepartamento");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentoGreaterThanOrEqualTo(String value) {
            addCriterion("d.codigo_departamento >=", value, "codigoDepartamento");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentoLessThan(String value) {
            addCriterion("d.codigo_departamento <", value, "codigoDepartamento");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentoLessThanOrEqualTo(String value) {
            addCriterion("d.codigo_departamento <=", value, "codigoDepartamento");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentoLike(String value) {
            addCriterion("d.codigo_departamento like", value, "codigoDepartamento");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentoNotLike(String value) {
            addCriterion("d.codigo_departamento not like", value, "codigoDepartamento");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentoIn(List<String> values) {
            addCriterion("d.codigo_departamento in", values, "codigoDepartamento");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentoNotIn(List<String> values) {
            addCriterion("d.codigo_departamento not in", values, "codigoDepartamento");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentoBetween(String value1, String value2) {
            addCriterion("d.codigo_departamento between", value1, value2, "codigoDepartamento");
            return (Criteria) this;
        }

        public Criteria andCodigoDepartamentoNotBetween(String value1, String value2) {
            addCriterion("d.codigo_departamento not between", value1, value2, "codigoDepartamento");
            return (Criteria) this;
        }

        public Criteria andNombreDepartamentoIsNull() {
            addCriterion("nombre_departamento is null");
            return (Criteria) this;
        }

        public Criteria andNombreDepartamentoIsNotNull() {
            addCriterion("nombre_departamento is not null");
            return (Criteria) this;
        }

        public Criteria andNombreDepartamentoEqualTo(String value) {
            addCriterion("nombre_departamento =", value, "nombreDepartamento");
            return (Criteria) this;
        }

        public Criteria andNombreDepartamentoNotEqualTo(String value) {
            addCriterion("nombre_departamento <>", value, "nombreDepartamento");
            return (Criteria) this;
        }

        public Criteria andNombreDepartamentoGreaterThan(String value) {
            addCriterion("nombre_departamento >", value, "nombreDepartamento");
            return (Criteria) this;
        }

        public Criteria andNombreDepartamentoGreaterThanOrEqualTo(String value) {
            addCriterion("nombre_departamento >=", value, "nombreDepartamento");
            return (Criteria) this;
        }

        public Criteria andNombreDepartamentoLessThan(String value) {
            addCriterion("nombre_departamento <", value, "nombreDepartamento");
            return (Criteria) this;
        }

        public Criteria andNombreDepartamentoLessThanOrEqualTo(String value) {
            addCriterion("nombre_departamento <=", value, "nombreDepartamento");
            return (Criteria) this;
        }

        public Criteria andNombreDepartamentoLike(String value) {
            addCriterion("upper(nombre_departamento) like", value, "nombreDepartamento");
            return (Criteria) this;
        }

        public Criteria andNombreDepartamentoNotLike(String value) {
            addCriterion("nombre_departamento not like", value, "nombreDepartamento");
            return (Criteria) this;
        }

        public Criteria andNombreDepartamentoIn(List<String> values) {
            addCriterion("nombre_departamento in", values, "nombreDepartamento");
            return (Criteria) this;
        }

        public Criteria andNombreDepartamentoNotIn(List<String> values) {
            addCriterion("nombre_departamento not in", values, "nombreDepartamento");
            return (Criteria) this;
        }

        public Criteria andNombreDepartamentoBetween(String value1, String value2) {
            addCriterion("nombre_departamento between", value1, value2, "nombreDepartamento");
            return (Criteria) this;
        }

        public Criteria andNombreDepartamentoNotBetween(String value1, String value2) {
            addCriterion("nombre_departamento not between", value1, value2, "nombreDepartamento");
            return (Criteria) this;
        }
    }

    /**
     * 
     * departamentos
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
     * departamentos
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