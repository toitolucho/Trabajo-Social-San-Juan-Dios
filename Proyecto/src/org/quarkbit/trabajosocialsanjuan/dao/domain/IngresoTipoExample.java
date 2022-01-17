package org.quarkbit.trabajosocialsanjuan.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class IngresoTipoExample {
    /**
     *
     * table ingresos_tipos
     *
     * 
     */
    protected String orderByClause;

    /**
     *
     * table ingresos_tipos
     *
     * 
     */
    protected boolean distinct;

    /**
     *
     * table ingresos_tipos
     *
     * 
     */
    protected List<Criteria> oredCriteria;

    /**
     * 
     * table ingresos_tipos
     *
     * 
     */
    public IngresoTipoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 
     * table ingresos_tipos
     *
     * 
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 
     * table ingresos_tipos
     *
     * 
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 
     * table ingresos_tipos
     *
     * 
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 
     * table ingresos_tipos
     *
     * 
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 
     * table ingresos_tipos
     *
     * 
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 
     * table ingresos_tipos
     *
     * 
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 
     * table ingresos_tipos
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
     * table ingresos_tipos
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
     * table ingresos_tipos
     *
     * 
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 
     * table ingresos_tipos
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
     * ingresos_tipos
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

        public Criteria andCodigoIngresoTipoIsNull() {
            addCriterion("codigo_ingreso_tipo is null");
            return (Criteria) this;
        }

        public Criteria andCodigoIngresoTipoIsNotNull() {
            addCriterion("codigo_ingreso_tipo is not null");
            return (Criteria) this;
        }

        public Criteria andCodigoIngresoTipoEqualTo(Integer value) {
            addCriterion("codigo_ingreso_tipo =", value, "codigoIngresoTipo");
            return (Criteria) this;
        }

        public Criteria andCodigoIngresoTipoNotEqualTo(Integer value) {
            addCriterion("codigo_ingreso_tipo <>", value, "codigoIngresoTipo");
            return (Criteria) this;
        }

        public Criteria andCodigoIngresoTipoGreaterThan(Integer value) {
            addCriterion("codigo_ingreso_tipo >", value, "codigoIngresoTipo");
            return (Criteria) this;
        }

        public Criteria andCodigoIngresoTipoGreaterThanOrEqualTo(Integer value) {
            addCriterion("codigo_ingreso_tipo >=", value, "codigoIngresoTipo");
            return (Criteria) this;
        }

        public Criteria andCodigoIngresoTipoLessThan(Integer value) {
            addCriterion("codigo_ingreso_tipo <", value, "codigoIngresoTipo");
            return (Criteria) this;
        }

        public Criteria andCodigoIngresoTipoLessThanOrEqualTo(Integer value) {
            addCriterion("codigo_ingreso_tipo <=", value, "codigoIngresoTipo");
            return (Criteria) this;
        }

        public Criteria andCodigoIngresoTipoIn(List<Integer> values) {
            addCriterion("codigo_ingreso_tipo in", values, "codigoIngresoTipo");
            return (Criteria) this;
        }

        public Criteria andCodigoIngresoTipoNotIn(List<Integer> values) {
            addCriterion("codigo_ingreso_tipo not in", values, "codigoIngresoTipo");
            return (Criteria) this;
        }

        public Criteria andCodigoIngresoTipoBetween(Integer value1, Integer value2) {
            addCriterion("codigo_ingreso_tipo between", value1, value2, "codigoIngresoTipo");
            return (Criteria) this;
        }

        public Criteria andCodigoIngresoTipoNotBetween(Integer value1, Integer value2) {
            addCriterion("codigo_ingreso_tipo not between", value1, value2, "codigoIngresoTipo");
            return (Criteria) this;
        }

        public Criteria andNombreIngresoTipoIsNull() {
            addCriterion("nombre_ingreso_tipo is null");
            return (Criteria) this;
        }

        public Criteria andNombreIngresoTipoIsNotNull() {
            addCriterion("nombre_ingreso_tipo is not null");
            return (Criteria) this;
        }

        public Criteria andNombreIngresoTipoEqualTo(String value) {
            addCriterion("nombre_ingreso_tipo =", value, "nombreIngresoTipo");
            return (Criteria) this;
        }

        public Criteria andNombreIngresoTipoNotEqualTo(String value) {
            addCriterion("nombre_ingreso_tipo <>", value, "nombreIngresoTipo");
            return (Criteria) this;
        }

        public Criteria andNombreIngresoTipoGreaterThan(String value) {
            addCriterion("nombre_ingreso_tipo >", value, "nombreIngresoTipo");
            return (Criteria) this;
        }

        public Criteria andNombreIngresoTipoGreaterThanOrEqualTo(String value) {
            addCriterion("nombre_ingreso_tipo >=", value, "nombreIngresoTipo");
            return (Criteria) this;
        }

        public Criteria andNombreIngresoTipoLessThan(String value) {
            addCriterion("nombre_ingreso_tipo <", value, "nombreIngresoTipo");
            return (Criteria) this;
        }

        public Criteria andNombreIngresoTipoLessThanOrEqualTo(String value) {
            addCriterion("nombre_ingreso_tipo <=", value, "nombreIngresoTipo");
            return (Criteria) this;
        }

        public Criteria andNombreIngresoTipoLike(String value) {
            addCriterion("nombre_ingreso_tipo like", value, "nombreIngresoTipo");
            return (Criteria) this;
        }

        public Criteria andNombreIngresoTipoNotLike(String value) {
            addCriterion("nombre_ingreso_tipo not like", value, "nombreIngresoTipo");
            return (Criteria) this;
        }

        public Criteria andNombreIngresoTipoIn(List<String> values) {
            addCriterion("nombre_ingreso_tipo in", values, "nombreIngresoTipo");
            return (Criteria) this;
        }

        public Criteria andNombreIngresoTipoNotIn(List<String> values) {
            addCriterion("nombre_ingreso_tipo not in", values, "nombreIngresoTipo");
            return (Criteria) this;
        }

        public Criteria andNombreIngresoTipoBetween(String value1, String value2) {
            addCriterion("nombre_ingreso_tipo between", value1, value2, "nombreIngresoTipo");
            return (Criteria) this;
        }

        public Criteria andNombreIngresoTipoNotBetween(String value1, String value2) {
            addCriterion("nombre_ingreso_tipo not between", value1, value2, "nombreIngresoTipo");
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
     * ingresos_tipos
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
     * ingresos_tipos
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