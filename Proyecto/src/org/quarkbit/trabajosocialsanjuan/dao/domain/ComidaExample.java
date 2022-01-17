package org.quarkbit.trabajosocialsanjuan.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class ComidaExample {
    /**
     *
     * table comidas
     *
     * 
     */
    protected String orderByClause;

    /**
     *
     * table comidas
     *
     * 
     */
    protected boolean distinct;

    /**
     *
     * table comidas
     *
     * 
     */
    protected List<Criteria> oredCriteria;

    /**
     * 
     * table comidas
     *
     * 
     */
    public ComidaExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 
     * table comidas
     *
     * 
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 
     * table comidas
     *
     * 
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 
     * table comidas
     *
     * 
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 
     * table comidas
     *
     * 
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 
     * table comidas
     *
     * 
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 
     * table comidas
     *
     * 
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 
     * table comidas
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
     * table comidas
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
     * table comidas
     *
     * 
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 
     * table comidas
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
     * comidas
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

        public Criteria andCodigoComidaIsNull() {
            addCriterion("codigo_comida is null");
            return (Criteria) this;
        }

        public Criteria andCodigoComidaIsNotNull() {
            addCriterion("codigo_comida is not null");
            return (Criteria) this;
        }

        public Criteria andCodigoComidaEqualTo(Integer value) {
            addCriterion("codigo_comida =", value, "codigoComida");
            return (Criteria) this;
        }

        public Criteria andCodigoComidaNotEqualTo(Integer value) {
            addCriterion("codigo_comida <>", value, "codigoComida");
            return (Criteria) this;
        }

        public Criteria andCodigoComidaGreaterThan(Integer value) {
            addCriterion("codigo_comida >", value, "codigoComida");
            return (Criteria) this;
        }

        public Criteria andCodigoComidaGreaterThanOrEqualTo(Integer value) {
            addCriterion("codigo_comida >=", value, "codigoComida");
            return (Criteria) this;
        }

        public Criteria andCodigoComidaLessThan(Integer value) {
            addCriterion("codigo_comida <", value, "codigoComida");
            return (Criteria) this;
        }

        public Criteria andCodigoComidaLessThanOrEqualTo(Integer value) {
            addCriterion("codigo_comida <=", value, "codigoComida");
            return (Criteria) this;
        }

        public Criteria andCodigoComidaIn(List<Integer> values) {
            addCriterion("codigo_comida in", values, "codigoComida");
            return (Criteria) this;
        }

        public Criteria andCodigoComidaNotIn(List<Integer> values) {
            addCriterion("codigo_comida not in", values, "codigoComida");
            return (Criteria) this;
        }

        public Criteria andCodigoComidaBetween(Integer value1, Integer value2) {
            addCriterion("codigo_comida between", value1, value2, "codigoComida");
            return (Criteria) this;
        }

        public Criteria andCodigoComidaNotBetween(Integer value1, Integer value2) {
            addCriterion("codigo_comida not between", value1, value2, "codigoComida");
            return (Criteria) this;
        }

        public Criteria andNombreComidaIsNull() {
            addCriterion("nombre_comida is null");
            return (Criteria) this;
        }

        public Criteria andNombreComidaIsNotNull() {
            addCriterion("nombre_comida is not null");
            return (Criteria) this;
        }

        public Criteria andNombreComidaEqualTo(String value) {
            addCriterion("nombre_comida =", value, "nombreComida");
            return (Criteria) this;
        }

        public Criteria andNombreComidaNotEqualTo(String value) {
            addCriterion("nombre_comida <>", value, "nombreComida");
            return (Criteria) this;
        }

        public Criteria andNombreComidaGreaterThan(String value) {
            addCriterion("nombre_comida >", value, "nombreComida");
            return (Criteria) this;
        }

        public Criteria andNombreComidaGreaterThanOrEqualTo(String value) {
            addCriterion("nombre_comida >=", value, "nombreComida");
            return (Criteria) this;
        }

        public Criteria andNombreComidaLessThan(String value) {
            addCriterion("nombre_comida <", value, "nombreComida");
            return (Criteria) this;
        }

        public Criteria andNombreComidaLessThanOrEqualTo(String value) {
            addCriterion("nombre_comida <=", value, "nombreComida");
            return (Criteria) this;
        }

        public Criteria andNombreComidaLike(String value) {
            addCriterion("nombre_comida like", value, "nombreComida");
            return (Criteria) this;
        }

        public Criteria andNombreComidaNotLike(String value) {
            addCriterion("nombre_comida not like", value, "nombreComida");
            return (Criteria) this;
        }

        public Criteria andNombreComidaIn(List<String> values) {
            addCriterion("nombre_comida in", values, "nombreComida");
            return (Criteria) this;
        }

        public Criteria andNombreComidaNotIn(List<String> values) {
            addCriterion("nombre_comida not in", values, "nombreComida");
            return (Criteria) this;
        }

        public Criteria andNombreComidaBetween(String value1, String value2) {
            addCriterion("nombre_comida between", value1, value2, "nombreComida");
            return (Criteria) this;
        }

        public Criteria andNombreComidaNotBetween(String value1, String value2) {
            addCriterion("nombre_comida not between", value1, value2, "nombreComida");
            return (Criteria) this;
        }

        public Criteria andCodigoCategoriaIsNull() {
            addCriterion("codigo_categoria is null");
            return (Criteria) this;
        }

        public Criteria andCodigoCategoriaIsNotNull() {
            addCriterion("codigo_categoria is not null");
            return (Criteria) this;
        }

        public Criteria andCodigoCategoriaEqualTo(Integer value) {
            addCriterion("codigo_categoria =", value, "codigoCategoria");
            return (Criteria) this;
        }

        public Criteria andCodigoCategoriaNotEqualTo(Integer value) {
            addCriterion("codigo_categoria <>", value, "codigoCategoria");
            return (Criteria) this;
        }

        public Criteria andCodigoCategoriaGreaterThan(Integer value) {
            addCriterion("codigo_categoria >", value, "codigoCategoria");
            return (Criteria) this;
        }

        public Criteria andCodigoCategoriaGreaterThanOrEqualTo(Integer value) {
            addCriterion("codigo_categoria >=", value, "codigoCategoria");
            return (Criteria) this;
        }

        public Criteria andCodigoCategoriaLessThan(Integer value) {
            addCriterion("codigo_categoria <", value, "codigoCategoria");
            return (Criteria) this;
        }

        public Criteria andCodigoCategoriaLessThanOrEqualTo(Integer value) {
            addCriterion("codigo_categoria <=", value, "codigoCategoria");
            return (Criteria) this;
        }

        public Criteria andCodigoCategoriaIn(List<Integer> values) {
            addCriterion("codigo_categoria in", values, "codigoCategoria");
            return (Criteria) this;
        }

        public Criteria andCodigoCategoriaNotIn(List<Integer> values) {
            addCriterion("codigo_categoria not in", values, "codigoCategoria");
            return (Criteria) this;
        }

        public Criteria andCodigoCategoriaBetween(Integer value1, Integer value2) {
            addCriterion("codigo_categoria between", value1, value2, "codigoCategoria");
            return (Criteria) this;
        }

        public Criteria andCodigoCategoriaNotBetween(Integer value1, Integer value2) {
            addCriterion("codigo_categoria not between", value1, value2, "codigoCategoria");
            return (Criteria) this;
        }

        public Criteria andPrecioEstimadoIsNull() {
            addCriterion("precio_estimado is null");
            return (Criteria) this;
        }

        public Criteria andPrecioEstimadoIsNotNull() {
            addCriterion("precio_estimado is not null");
            return (Criteria) this;
        }

        public Criteria andPrecioEstimadoEqualTo(Double value) {
            addCriterion("precio_estimado =", value, "precioEstimado");
            return (Criteria) this;
        }

        public Criteria andPrecioEstimadoNotEqualTo(Double value) {
            addCriterion("precio_estimado <>", value, "precioEstimado");
            return (Criteria) this;
        }

        public Criteria andPrecioEstimadoGreaterThan(Double value) {
            addCriterion("precio_estimado >", value, "precioEstimado");
            return (Criteria) this;
        }

        public Criteria andPrecioEstimadoGreaterThanOrEqualTo(Double value) {
            addCriterion("precio_estimado >=", value, "precioEstimado");
            return (Criteria) this;
        }

        public Criteria andPrecioEstimadoLessThan(Double value) {
            addCriterion("precio_estimado <", value, "precioEstimado");
            return (Criteria) this;
        }

        public Criteria andPrecioEstimadoLessThanOrEqualTo(Double value) {
            addCriterion("precio_estimado <=", value, "precioEstimado");
            return (Criteria) this;
        }

        public Criteria andPrecioEstimadoIn(List<Double> values) {
            addCriterion("precio_estimado in", values, "precioEstimado");
            return (Criteria) this;
        }

        public Criteria andPrecioEstimadoNotIn(List<Double> values) {
            addCriterion("precio_estimado not in", values, "precioEstimado");
            return (Criteria) this;
        }

        public Criteria andPrecioEstimadoBetween(Double value1, Double value2) {
            addCriterion("precio_estimado between", value1, value2, "precioEstimado");
            return (Criteria) this;
        }

        public Criteria andPrecioEstimadoNotBetween(Double value1, Double value2) {
            addCriterion("precio_estimado not between", value1, value2, "precioEstimado");
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
     * comidas
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
     * comidas
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