package org.quarkbit.trabajosocialsanjuan.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class PropiedadHistorialClinicoExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table propiedades_historial_clinico
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table propiedades_historial_clinico
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table propiedades_historial_clinico
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table propiedades_historial_clinico
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    public PropiedadHistorialClinicoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table propiedades_historial_clinico
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table propiedades_historial_clinico
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table propiedades_historial_clinico
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table propiedades_historial_clinico
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table propiedades_historial_clinico
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table propiedades_historial_clinico
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table propiedades_historial_clinico
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
     * This method corresponds to the database table propiedades_historial_clinico
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
     * This method corresponds to the database table propiedades_historial_clinico
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table propiedades_historial_clinico
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
     * This class corresponds to the database table propiedades_historial_clinico
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

        public Criteria andNumeroPropiedadIsNull() {
            addCriterion("numero_propiedad is null");
            return (Criteria) this;
        }

        public Criteria andNumeroPropiedadIsNotNull() {
            addCriterion("numero_propiedad is not null");
            return (Criteria) this;
        }

        public Criteria andNumeroPropiedadEqualTo(Integer value) {
            addCriterion("numero_propiedad =", value, "numeroPropiedad");
            return (Criteria) this;
        }

        public Criteria andNumeroPropiedadNotEqualTo(Integer value) {
            addCriterion("numero_propiedad <>", value, "numeroPropiedad");
            return (Criteria) this;
        }

        public Criteria andNumeroPropiedadGreaterThan(Integer value) {
            addCriterion("numero_propiedad >", value, "numeroPropiedad");
            return (Criteria) this;
        }

        public Criteria andNumeroPropiedadGreaterThanOrEqualTo(Integer value) {
            addCriterion("numero_propiedad >=", value, "numeroPropiedad");
            return (Criteria) this;
        }

        public Criteria andNumeroPropiedadLessThan(Integer value) {
            addCriterion("numero_propiedad <", value, "numeroPropiedad");
            return (Criteria) this;
        }

        public Criteria andNumeroPropiedadLessThanOrEqualTo(Integer value) {
            addCriterion("numero_propiedad <=", value, "numeroPropiedad");
            return (Criteria) this;
        }

        public Criteria andNumeroPropiedadIn(List<Integer> values) {
            addCriterion("numero_propiedad in", values, "numeroPropiedad");
            return (Criteria) this;
        }

        public Criteria andNumeroPropiedadNotIn(List<Integer> values) {
            addCriterion("numero_propiedad not in", values, "numeroPropiedad");
            return (Criteria) this;
        }

        public Criteria andNumeroPropiedadBetween(Integer value1, Integer value2) {
            addCriterion("numero_propiedad between", value1, value2, "numeroPropiedad");
            return (Criteria) this;
        }

        public Criteria andNumeroPropiedadNotBetween(Integer value1, Integer value2) {
            addCriterion("numero_propiedad not between", value1, value2, "numeroPropiedad");
            return (Criteria) this;
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
            addCriterion("phc.numero_propiedad_tipo =", value, "numeroPropiedadTipo");
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

        public Criteria andNombrePropiedadIsNull() {
            addCriterion("nombre_propiedad is null");
            return (Criteria) this;
        }

        public Criteria andNombrePropiedadIsNotNull() {
            addCriterion("nombre_propiedad is not null");
            return (Criteria) this;
        }

        public Criteria andNombrePropiedadEqualTo(String value) {
            addCriterion("nombre_propiedad =", value, "nombrePropiedad");
            return (Criteria) this;
        }

        public Criteria andNombrePropiedadNotEqualTo(String value) {
            addCriterion("nombre_propiedad <>", value, "nombrePropiedad");
            return (Criteria) this;
        }

        public Criteria andNombrePropiedadGreaterThan(String value) {
            addCriterion("nombre_propiedad >", value, "nombrePropiedad");
            return (Criteria) this;
        }

        public Criteria andNombrePropiedadGreaterThanOrEqualTo(String value) {
            addCriterion("nombre_propiedad >=", value, "nombrePropiedad");
            return (Criteria) this;
        }

        public Criteria andNombrePropiedadLessThan(String value) {
            addCriterion("nombre_propiedad <", value, "nombrePropiedad");
            return (Criteria) this;
        }

        public Criteria andNombrePropiedadLessThanOrEqualTo(String value) {
            addCriterion("nombre_propiedad <=", value, "nombrePropiedad");
            return (Criteria) this;
        }

        public Criteria andNombrePropiedadLike(String value) {
            addCriterion("upper(nombre_propiedad) like", value, "nombrePropiedad");
            return (Criteria) this;
        }

        public Criteria andNombrePropiedadNotLike(String value) {
            addCriterion("nombre_propiedad not like", value, "nombrePropiedad");
            return (Criteria) this;
        }

        public Criteria andNombrePropiedadIn(List<String> values) {
            addCriterion("nombre_propiedad in", values, "nombrePropiedad");
            return (Criteria) this;
        }

        public Criteria andNombrePropiedadNotIn(List<String> values) {
            addCriterion("nombre_propiedad not in", values, "nombrePropiedad");
            return (Criteria) this;
        }

        public Criteria andNombrePropiedadBetween(String value1, String value2) {
            addCriterion("nombre_propiedad between", value1, value2, "nombrePropiedad");
            return (Criteria) this;
        }

        public Criteria andNombrePropiedadNotBetween(String value1, String value2) {
            addCriterion("nombre_propiedad not between", value1, value2, "nombrePropiedad");
            return (Criteria) this;
        }

        public Criteria andAbreviacionIsNull() {
            addCriterion("abreviacion is null");
            return (Criteria) this;
        }

        public Criteria andAbreviacionIsNotNull() {
            addCriterion("abreviacion is not null");
            return (Criteria) this;
        }

        public Criteria andAbreviacionEqualTo(String value) {
            addCriterion("abreviacion =", value, "abreviacion");
            return (Criteria) this;
        }

        public Criteria andAbreviacionNotEqualTo(String value) {
            addCriterion("abreviacion <>", value, "abreviacion");
            return (Criteria) this;
        }

        public Criteria andAbreviacionGreaterThan(String value) {
            addCriterion("abreviacion >", value, "abreviacion");
            return (Criteria) this;
        }

        public Criteria andAbreviacionGreaterThanOrEqualTo(String value) {
            addCriterion("abreviacion >=", value, "abreviacion");
            return (Criteria) this;
        }

        public Criteria andAbreviacionLessThan(String value) {
            addCriterion("abreviacion <", value, "abreviacion");
            return (Criteria) this;
        }

        public Criteria andAbreviacionLessThanOrEqualTo(String value) {
            addCriterion("abreviacion <=", value, "abreviacion");
            return (Criteria) this;
        }

        public Criteria andAbreviacionLike(String value) {
            addCriterion("abreviacion like", value, "abreviacion");
            return (Criteria) this;
        }

        public Criteria andAbreviacionNotLike(String value) {
            addCriterion("abreviacion not like", value, "abreviacion");
            return (Criteria) this;
        }

        public Criteria andAbreviacionIn(List<String> values) {
            addCriterion("abreviacion in", values, "abreviacion");
            return (Criteria) this;
        }

        public Criteria andAbreviacionNotIn(List<String> values) {
            addCriterion("abreviacion not in", values, "abreviacion");
            return (Criteria) this;
        }

        public Criteria andAbreviacionBetween(String value1, String value2) {
            addCriterion("abreviacion between", value1, value2, "abreviacion");
            return (Criteria) this;
        }

        public Criteria andAbreviacionNotBetween(String value1, String value2) {
            addCriterion("abreviacion not between", value1, value2, "abreviacion");
            return (Criteria) this;
        }

        public Criteria andComposicionIsNull() {
            addCriterion("composicion is null");
            return (Criteria) this;
        }

        public Criteria andComposicionIsNotNull() {
            addCriterion("composicion is not null");
            return (Criteria) this;
        }

        public Criteria andComposicionEqualTo(String value) {
            addCriterion("composicion =", value, "composicion");
            return (Criteria) this;
        }

        public Criteria andComposicionNotEqualTo(String value) {
            addCriterion("composicion <>", value, "composicion");
            return (Criteria) this;
        }

        public Criteria andComposicionGreaterThan(String value) {
            addCriterion("composicion >", value, "composicion");
            return (Criteria) this;
        }

        public Criteria andComposicionGreaterThanOrEqualTo(String value) {
            addCriterion("composicion >=", value, "composicion");
            return (Criteria) this;
        }

        public Criteria andComposicionLessThan(String value) {
            addCriterion("composicion <", value, "composicion");
            return (Criteria) this;
        }

        public Criteria andComposicionLessThanOrEqualTo(String value) {
            addCriterion("composicion <=", value, "composicion");
            return (Criteria) this;
        }

        public Criteria andComposicionLike(String value) {
            addCriterion("composicion like", value, "composicion");
            return (Criteria) this;
        }

        public Criteria andComposicionNotLike(String value) {
            addCriterion("composicion not like", value, "composicion");
            return (Criteria) this;
        }

        public Criteria andComposicionIn(List<String> values) {
            addCriterion("composicion in", values, "composicion");
            return (Criteria) this;
        }

        public Criteria andComposicionNotIn(List<String> values) {
            addCriterion("composicion not in", values, "composicion");
            return (Criteria) this;
        }

        public Criteria andComposicionBetween(String value1, String value2) {
            addCriterion("composicion between", value1, value2, "composicion");
            return (Criteria) this;
        }

        public Criteria andComposicionNotBetween(String value1, String value2) {
            addCriterion("composicion not between", value1, value2, "composicion");
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
     * This class corresponds to the database table propiedades_historial_clinico
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
     * This class corresponds to the database table propiedades_historial_clinico
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