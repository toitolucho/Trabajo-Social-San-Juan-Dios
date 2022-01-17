package org.quarkbit.trabajosocialsanjuan.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class EmpleoExample {
    /**
     *
     * table empleos
     *
     * 
     */
    protected String orderByClause;

    /**
     *
     * table empleos
     *
     * 
     */
    protected boolean distinct;

    /**
     *
     * table empleos
     *
     * 
     */
    protected List<Criteria> oredCriteria;

    /**
     * 
     * table empleos
     *
     * 
     */
    public EmpleoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 
     * table empleos
     *
     * 
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 
     * table empleos
     *
     * 
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 
     * table empleos
     *
     * 
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 
     * table empleos
     *
     * 
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 
     * table empleos
     *
     * 
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 
     * table empleos
     *
     * 
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 
     * table empleos
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
     * table empleos
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
     * table empleos
     *
     * 
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 
     * table empleos
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
     * empleos
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

        public Criteria andCodigoEmpleoIsNull() {
            addCriterion("codigo_empleo is null");
            return (Criteria) this;
        }

        public Criteria andCodigoEmpleoIsNotNull() {
            addCriterion("codigo_empleo is not null");
            return (Criteria) this;
        }

        public Criteria andCodigoEmpleoEqualTo(Integer value) {
            addCriterion("codigo_empleo =", value, "codigoEmpleo");
            return (Criteria) this;
        }

        public Criteria andCodigoEmpleoNotEqualTo(Integer value) {
            addCriterion("codigo_empleo <>", value, "codigoEmpleo");
            return (Criteria) this;
        }

        public Criteria andCodigoEmpleoGreaterThan(Integer value) {
            addCriterion("codigo_empleo >", value, "codigoEmpleo");
            return (Criteria) this;
        }

        public Criteria andCodigoEmpleoGreaterThanOrEqualTo(Integer value) {
            addCriterion("codigo_empleo >=", value, "codigoEmpleo");
            return (Criteria) this;
        }

        public Criteria andCodigoEmpleoLessThan(Integer value) {
            addCriterion("codigo_empleo <", value, "codigoEmpleo");
            return (Criteria) this;
        }

        public Criteria andCodigoEmpleoLessThanOrEqualTo(Integer value) {
            addCriterion("codigo_empleo <=", value, "codigoEmpleo");
            return (Criteria) this;
        }

        public Criteria andCodigoEmpleoIn(List<Integer> values) {
            addCriterion("codigo_empleo in", values, "codigoEmpleo");
            return (Criteria) this;
        }

        public Criteria andCodigoEmpleoNotIn(List<Integer> values) {
            addCriterion("codigo_empleo not in", values, "codigoEmpleo");
            return (Criteria) this;
        }

        public Criteria andCodigoEmpleoBetween(Integer value1, Integer value2) {
            addCriterion("codigo_empleo between", value1, value2, "codigoEmpleo");
            return (Criteria) this;
        }

        public Criteria andCodigoEmpleoNotBetween(Integer value1, Integer value2) {
            addCriterion("codigo_empleo not between", value1, value2, "codigoEmpleo");
            return (Criteria) this;
        }

        public Criteria andNombreEmpleoIsNull() {
            addCriterion("nombre_empleo is null");
            return (Criteria) this;
        }

        public Criteria andNombreEmpleoIsNotNull() {
            addCriterion("nombre_empleo is not null");
            return (Criteria) this;
        }

        public Criteria andNombreEmpleoEqualTo(String value) {
            addCriterion("nombre_empleo =", value, "nombreEmpleo");
            return (Criteria) this;
        }

        public Criteria andNombreEmpleoNotEqualTo(String value) {
            addCriterion("nombre_empleo <>", value, "nombreEmpleo");
            return (Criteria) this;
        }

        public Criteria andNombreEmpleoGreaterThan(String value) {
            addCriterion("nombre_empleo >", value, "nombreEmpleo");
            return (Criteria) this;
        }

        public Criteria andNombreEmpleoGreaterThanOrEqualTo(String value) {
            addCriterion("nombre_empleo >=", value, "nombreEmpleo");
            return (Criteria) this;
        }

        public Criteria andNombreEmpleoLessThan(String value) {
            addCriterion("nombre_empleo <", value, "nombreEmpleo");
            return (Criteria) this;
        }

        public Criteria andNombreEmpleoLessThanOrEqualTo(String value) {
            addCriterion("nombre_empleo <=", value, "nombreEmpleo");
            return (Criteria) this;
        }

        public Criteria andNombreEmpleoLike(String value) {
            addCriterion("nombre_empleo like", value, "nombreEmpleo");
            return (Criteria) this;
        }

        public Criteria andNombreEmpleoNotLike(String value) {
            addCriterion("nombre_empleo not like", value, "nombreEmpleo");
            return (Criteria) this;
        }

        public Criteria andNombreEmpleoIn(List<String> values) {
            addCriterion("nombre_empleo in", values, "nombreEmpleo");
            return (Criteria) this;
        }

        public Criteria andNombreEmpleoNotIn(List<String> values) {
            addCriterion("nombre_empleo not in", values, "nombreEmpleo");
            return (Criteria) this;
        }

        public Criteria andNombreEmpleoBetween(String value1, String value2) {
            addCriterion("nombre_empleo between", value1, value2, "nombreEmpleo");
            return (Criteria) this;
        }

        public Criteria andNombreEmpleoNotBetween(String value1, String value2) {
            addCriterion("nombre_empleo not between", value1, value2, "nombreEmpleo");
            return (Criteria) this;
        }

        public Criteria andDescripcionIsNull() {
            addCriterion("descripcion is null");
            return (Criteria) this;
        }

        public Criteria andDescripcionIsNotNull() {
            addCriterion("descripcion is not null");
            return (Criteria) this;
        }

        public Criteria andDescripcionEqualTo(String value) {
            addCriterion("descripcion =", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionNotEqualTo(String value) {
            addCriterion("descripcion <>", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionGreaterThan(String value) {
            addCriterion("descripcion >", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionGreaterThanOrEqualTo(String value) {
            addCriterion("descripcion >=", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionLessThan(String value) {
            addCriterion("descripcion <", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionLessThanOrEqualTo(String value) {
            addCriterion("descripcion <=", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionLike(String value) {
            addCriterion("descripcion like", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionNotLike(String value) {
            addCriterion("descripcion not like", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionIn(List<String> values) {
            addCriterion("descripcion in", values, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionNotIn(List<String> values) {
            addCriterion("descripcion not in", values, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionBetween(String value1, String value2) {
            addCriterion("descripcion between", value1, value2, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionNotBetween(String value1, String value2) {
            addCriterion("descripcion not between", value1, value2, "descripcion");
            return (Criteria) this;
        }
    }

    /**
     * 
     * empleos
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
     * empleos
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