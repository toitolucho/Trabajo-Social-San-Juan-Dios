package org.quarkbit.trabajosocialsanjuan.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class PropiedadTipoExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table propiedades_tipos
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table propiedades_tipos
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table propiedades_tipos
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table propiedades_tipos
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    public PropiedadTipoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table propiedades_tipos
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table propiedades_tipos
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table propiedades_tipos
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table propiedades_tipos
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table propiedades_tipos
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table propiedades_tipos
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table propiedades_tipos
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table propiedades_tipos
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
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
     * This method corresponds to the database table propiedades_tipos
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table propiedades_tipos
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table propiedades_tipos
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
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

        public Criteria andNumeroPropiedadTipoIsNull() {
            addCriterion("numero_propiedad_tipo is null");
            return (Criteria) this;
        }

        public Criteria andNumeroPropiedadTipoIsNotNull() {
            addCriterion("numero_propiedad_tipo is not null");
            return (Criteria) this;
        }

        public Criteria andNumeroPropiedadTipoEqualTo(Integer value) {
            addCriterion("numero_propiedad_tipo =", value, "numeroPropiedadTipo");
            return (Criteria) this;
        }

        public Criteria andNumeroPropiedadTipoNotEqualTo(Integer value) {
            addCriterion("numero_propiedad_tipo <>", value, "numeroPropiedadTipo");
            return (Criteria) this;
        }

        public Criteria andNumeroPropiedadTipoGreaterThan(Integer value) {
            addCriterion("numero_propiedad_tipo >", value, "numeroPropiedadTipo");
            return (Criteria) this;
        }

        public Criteria andNumeroPropiedadTipoGreaterThanOrEqualTo(Integer value) {
            addCriterion("numero_propiedad_tipo >=", value, "numeroPropiedadTipo");
            return (Criteria) this;
        }

        public Criteria andNumeroPropiedadTipoLessThan(Integer value) {
            addCriterion("numero_propiedad_tipo <", value, "numeroPropiedadTipo");
            return (Criteria) this;
        }

        public Criteria andNumeroPropiedadTipoLessThanOrEqualTo(Integer value) {
            addCriterion("numero_propiedad_tipo <=", value, "numeroPropiedadTipo");
            return (Criteria) this;
        }

        public Criteria andNumeroPropiedadTipoIn(List<Integer> values) {
            addCriterion("numero_propiedad_tipo in", values, "numeroPropiedadTipo");
            return (Criteria) this;
        }

        public Criteria andNumeroPropiedadTipoNotIn(List<Integer> values) {
            addCriterion("numero_propiedad_tipo not in", values, "numeroPropiedadTipo");
            return (Criteria) this;
        }

        public Criteria andNumeroPropiedadTipoBetween(Integer value1, Integer value2) {
            addCriterion("numero_propiedad_tipo between", value1, value2, "numeroPropiedadTipo");
            return (Criteria) this;
        }

        public Criteria andNumeroPropiedadTipoNotBetween(Integer value1, Integer value2) {
            addCriterion("numero_propiedad_tipo not between", value1, value2, "numeroPropiedadTipo");
            return (Criteria) this;
        }

        public Criteria andNombrePropiedadTipoIsNull() {
            addCriterion("nombre_propiedad_tipo is null");
            return (Criteria) this;
        }

        public Criteria andNombrePropiedadTipoIsNotNull() {
            addCriterion("nombre_propiedad_tipo is not null");
            return (Criteria) this;
        }

        public Criteria andNombrePropiedadTipoEqualTo(String value) {
            addCriterion("nombre_propiedad_tipo =", value, "nombrePropiedadTipo");
            return (Criteria) this;
        }

        public Criteria andNombrePropiedadTipoNotEqualTo(String value) {
            addCriterion("nombre_propiedad_tipo <>", value, "nombrePropiedadTipo");
            return (Criteria) this;
        }

        public Criteria andNombrePropiedadTipoGreaterThan(String value) {
            addCriterion("nombre_propiedad_tipo >", value, "nombrePropiedadTipo");
            return (Criteria) this;
        }

        public Criteria andNombrePropiedadTipoGreaterThanOrEqualTo(String value) {
            addCriterion("nombre_propiedad_tipo >=", value, "nombrePropiedadTipo");
            return (Criteria) this;
        }

        public Criteria andNombrePropiedadTipoLessThan(String value) {
            addCriterion("nombre_propiedad_tipo <", value, "nombrePropiedadTipo");
            return (Criteria) this;
        }

        public Criteria andNombrePropiedadTipoLessThanOrEqualTo(String value) {
            addCriterion("nombre_propiedad_tipo <=", value, "nombrePropiedadTipo");
            return (Criteria) this;
        }

        public Criteria andNombrePropiedadTipoLike(String value) {
            addCriterion("nombre_propiedad_tipo like", value, "nombrePropiedadTipo");
            return (Criteria) this;
        }

        public Criteria andNombrePropiedadTipoNotLike(String value) {
            addCriterion("nombre_propiedad_tipo not like", value, "nombrePropiedadTipo");
            return (Criteria) this;
        }

        public Criteria andNombrePropiedadTipoIn(List<String> values) {
            addCriterion("nombre_propiedad_tipo in", values, "nombrePropiedadTipo");
            return (Criteria) this;
        }

        public Criteria andNombrePropiedadTipoNotIn(List<String> values) {
            addCriterion("nombre_propiedad_tipo not in", values, "nombrePropiedadTipo");
            return (Criteria) this;
        }

        public Criteria andNombrePropiedadTipoBetween(String value1, String value2) {
            addCriterion("nombre_propiedad_tipo between", value1, value2, "nombrePropiedadTipo");
            return (Criteria) this;
        }

        public Criteria andNombrePropiedadTipoNotBetween(String value1, String value2) {
            addCriterion("nombre_propiedad_tipo not between", value1, value2, "nombrePropiedadTipo");
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
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table propiedades_tipos
     *
     * @mbggenerated do_not_delete_during_merge Sun Apr 13 16:11:45 CEST 2014
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table propiedades_tipos
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
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