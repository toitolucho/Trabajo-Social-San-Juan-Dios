package org.quarkbit.trabajosocialsanjuan.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class PartidaExample {
    /**
     *
     * table partidas
     *
     * 
     */
    protected String orderByClause;

    /**
     *
     * table partidas
     *
     * 
     */
    protected boolean distinct;

    /**
     *
     * table partidas
     *
     * 
     */
    protected List<Criteria> oredCriteria;

    /**
     * 
     * table partidas
     *
     * 
     */
    public PartidaExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 
     * table partidas
     *
     * 
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 
     * table partidas
     *
     * 
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 
     * table partidas
     *
     * 
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 
     * table partidas
     *
     * 
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 
     * table partidas
     *
     * 
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 
     * table partidas
     *
     * 
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 
     * table partidas
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
     * table partidas
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
     * table partidas
     *
     * 
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 
     * table partidas
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
     * partidas
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

        public Criteria andCodigoPartidaIsNull() {
            addCriterion("codigo_partida is null");
            return (Criteria) this;
        }

        public Criteria andCodigoPartidaIsNotNull() {
            addCriterion("codigo_partida is not null");
            return (Criteria) this;
        }

        public Criteria andCodigoPartidaEqualTo(String value) {
            addCriterion("codigo_partida =", value, "codigoPartida");
            return (Criteria) this;
        }

        public Criteria andCodigoPartidaNotEqualTo(String value) {
            addCriterion("codigo_partida <>", value, "codigoPartida");
            return (Criteria) this;
        }

        public Criteria andCodigoPartidaGreaterThan(String value) {
            addCriterion("codigo_partida >", value, "codigoPartida");
            return (Criteria) this;
        }

        public Criteria andCodigoPartidaGreaterThanOrEqualTo(String value) {
            addCriterion("codigo_partida >=", value, "codigoPartida");
            return (Criteria) this;
        }

        public Criteria andCodigoPartidaLessThan(String value) {
            addCriterion("codigo_partida <", value, "codigoPartida");
            return (Criteria) this;
        }

        public Criteria andCodigoPartidaLessThanOrEqualTo(String value) {
            addCriterion("codigo_partida <=", value, "codigoPartida");
            return (Criteria) this;
        }

        public Criteria andCodigoPartidaLike(String value) {
            addCriterion("codigo_partida like", value, "codigoPartida");
            return (Criteria) this;
        }

        public Criteria andCodigoPartidaNotLike(String value) {
            addCriterion("codigo_partida not like", value, "codigoPartida");
            return (Criteria) this;
        }

        public Criteria andCodigoPartidaIn(List<String> values) {
            addCriterion("codigo_partida in", values, "codigoPartida");
            return (Criteria) this;
        }

        public Criteria andCodigoPartidaNotIn(List<String> values) {
            addCriterion("codigo_partida not in", values, "codigoPartida");
            return (Criteria) this;
        }

        public Criteria andCodigoPartidaBetween(String value1, String value2) {
            addCriterion("codigo_partida between", value1, value2, "codigoPartida");
            return (Criteria) this;
        }

        public Criteria andCodigoPartidaNotBetween(String value1, String value2) {
            addCriterion("codigo_partida not between", value1, value2, "codigoPartida");
            return (Criteria) this;
        }

        public Criteria andCodigoPartidaPadreIsNull() {
            addCriterion("codigo_partida_padre is null");
            return (Criteria) this;
        }

        public Criteria andCodigoPartidaPadreIsNotNull() {
            addCriterion("codigo_partida_padre is not null");
            return (Criteria) this;
        }

        public Criteria andCodigoPartidaPadreEqualTo(String value) {
            addCriterion("codigo_partida_padre =", value, "codigoPartidaPadre");
            return (Criteria) this;
        }

        public Criteria andCodigoPartidaPadreNotEqualTo(String value) {
            addCriterion("codigo_partida_padre <>", value, "codigoPartidaPadre");
            return (Criteria) this;
        }

        public Criteria andCodigoPartidaPadreGreaterThan(String value) {
            addCriterion("codigo_partida_padre >", value, "codigoPartidaPadre");
            return (Criteria) this;
        }

        public Criteria andCodigoPartidaPadreGreaterThanOrEqualTo(String value) {
            addCriterion("codigo_partida_padre >=", value, "codigoPartidaPadre");
            return (Criteria) this;
        }

        public Criteria andCodigoPartidaPadreLessThan(String value) {
            addCriterion("codigo_partida_padre <", value, "codigoPartidaPadre");
            return (Criteria) this;
        }

        public Criteria andCodigoPartidaPadreLessThanOrEqualTo(String value) {
            addCriterion("codigo_partida_padre <=", value, "codigoPartidaPadre");
            return (Criteria) this;
        }

        public Criteria andCodigoPartidaPadreLike(String value) {
            addCriterion("codigo_partida_padre like", value, "codigoPartidaPadre");
            return (Criteria) this;
        }

        public Criteria andCodigoPartidaPadreNotLike(String value) {
            addCriterion("codigo_partida_padre not like", value, "codigoPartidaPadre");
            return (Criteria) this;
        }

        public Criteria andCodigoPartidaPadreIn(List<String> values) {
            addCriterion("codigo_partida_padre in", values, "codigoPartidaPadre");
            return (Criteria) this;
        }

        public Criteria andCodigoPartidaPadreNotIn(List<String> values) {
            addCriterion("codigo_partida_padre not in", values, "codigoPartidaPadre");
            return (Criteria) this;
        }

        public Criteria andCodigoPartidaPadreBetween(String value1, String value2) {
            addCriterion("codigo_partida_padre between", value1, value2, "codigoPartidaPadre");
            return (Criteria) this;
        }

        public Criteria andCodigoPartidaPadreNotBetween(String value1, String value2) {
            addCriterion("codigo_partida_padre not between", value1, value2, "codigoPartidaPadre");
            return (Criteria) this;
        }

        public Criteria andNombrePartidaIsNull() {
            addCriterion("nombre_partida is null");
            return (Criteria) this;
        }

        public Criteria andNombrePartidaIsNotNull() {
            addCriterion("nombre_partida is not null");
            return (Criteria) this;
        }

        public Criteria andNombrePartidaEqualTo(String value) {
            addCriterion("nombre_partida =", value, "nombrePartida");
            return (Criteria) this;
        }

        public Criteria andNombrePartidaNotEqualTo(String value) {
            addCriterion("nombre_partida <>", value, "nombrePartida");
            return (Criteria) this;
        }

        public Criteria andNombrePartidaGreaterThan(String value) {
            addCriterion("nombre_partida >", value, "nombrePartida");
            return (Criteria) this;
        }

        public Criteria andNombrePartidaGreaterThanOrEqualTo(String value) {
            addCriterion("nombre_partida >=", value, "nombrePartida");
            return (Criteria) this;
        }

        public Criteria andNombrePartidaLessThan(String value) {
            addCriterion("nombre_partida <", value, "nombrePartida");
            return (Criteria) this;
        }

        public Criteria andNombrePartidaLessThanOrEqualTo(String value) {
            addCriterion("nombre_partida <=", value, "nombrePartida");
            return (Criteria) this;
        }

        public Criteria andNombrePartidaLike(String value) {
            addCriterion("nombre_partida like", value, "nombrePartida");
            return (Criteria) this;
        }

        public Criteria andNombrePartidaNotLike(String value) {
            addCriterion("nombre_partida not like", value, "nombrePartida");
            return (Criteria) this;
        }

        public Criteria andNombrePartidaIn(List<String> values) {
            addCriterion("nombre_partida in", values, "nombrePartida");
            return (Criteria) this;
        }

        public Criteria andNombrePartidaNotIn(List<String> values) {
            addCriterion("nombre_partida not in", values, "nombrePartida");
            return (Criteria) this;
        }

        public Criteria andNombrePartidaBetween(String value1, String value2) {
            addCriterion("nombre_partida between", value1, value2, "nombrePartida");
            return (Criteria) this;
        }

        public Criteria andNombrePartidaNotBetween(String value1, String value2) {
            addCriterion("nombre_partida not between", value1, value2, "nombrePartida");
            return (Criteria) this;
        }

        public Criteria andDescripcionIsNull() {
            addCriterion("descripcion_partida is null");
            return (Criteria) this;
        }

        public Criteria andDescripcionIsNotNull() {
            addCriterion("descripcion_partida is not null");
            return (Criteria) this;
        }

        public Criteria andDescripcionEqualTo(String value) {
            addCriterion("descripcion_partida =", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionNotEqualTo(String value) {
            addCriterion("descripcion_partida <>", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionGreaterThan(String value) {
            addCriterion("descripcion_partida >", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionGreaterThanOrEqualTo(String value) {
            addCriterion("descripcion_partida >=", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionLessThan(String value) {
            addCriterion("descripcion_partida <", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionLessThanOrEqualTo(String value) {
            addCriterion("descripcion_partida <=", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionLike(String value) {
            addCriterion("descripcion_partida like", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionNotLike(String value) {
            addCriterion("descripcion_partida not like", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionIn(List<String> values) {
            addCriterion("descripcion_partida in", values, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionNotIn(List<String> values) {
            addCriterion("descripcion_partida not in", values, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionBetween(String value1, String value2) {
            addCriterion("descripcion_partida between", value1, value2, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionNotBetween(String value1, String value2) {
            addCriterion("descripcion_partida not between", value1, value2, "descripcion");
            return (Criteria) this;
        }
    }

    /**
     * 
     * partidas
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
     * partidas
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