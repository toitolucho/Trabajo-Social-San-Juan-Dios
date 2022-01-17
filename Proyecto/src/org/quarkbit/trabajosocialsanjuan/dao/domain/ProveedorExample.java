package org.quarkbit.trabajosocialsanjuan.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class ProveedorExample {
    /**
     *
     * table proveedores
     *
     * 
     */
    protected String orderByClause;

    /**
     *
     * table proveedores
     *
     * 
     */
    protected boolean distinct;

    /**
     *
     * table proveedores
     *
     * 
     */
    protected List<Criteria> oredCriteria;

    /**
     * 
     * table proveedores
     *
     * 
     */
    public ProveedorExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 
     * table proveedores
     *
     * 
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 
     * table proveedores
     *
     * 
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 
     * table proveedores
     *
     * 
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 
     * table proveedores
     *
     * 
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 
     * table proveedores
     *
     * 
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 
     * table proveedores
     *
     * 
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 
     * table proveedores
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
     * table proveedores
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
     * table proveedores
     *
     * 
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 
     * table proveedores
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
     * proveedores
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

        public Criteria andCodigoProveedorIsNull() {
            addCriterion("codigo_proveedor is null");
            return (Criteria) this;
        }

        public Criteria andCodigoProveedorIsNotNull() {
            addCriterion("codigo_proveedor is not null");
            return (Criteria) this;
        }

        public Criteria andCodigoProveedorEqualTo(Integer value) {
            addCriterion("codigo_proveedor =", value, "codigoProveedor");
            return (Criteria) this;
        }

        public Criteria andCodigoProveedorNotEqualTo(Integer value) {
            addCriterion("codigo_proveedor <>", value, "codigoProveedor");
            return (Criteria) this;
        }

        public Criteria andCodigoProveedorGreaterThan(Integer value) {
            addCriterion("codigo_proveedor >", value, "codigoProveedor");
            return (Criteria) this;
        }

        public Criteria andCodigoProveedorGreaterThanOrEqualTo(Integer value) {
            addCriterion("codigo_proveedor >=", value, "codigoProveedor");
            return (Criteria) this;
        }

        public Criteria andCodigoProveedorLessThan(Integer value) {
            addCriterion("codigo_proveedor <", value, "codigoProveedor");
            return (Criteria) this;
        }

        public Criteria andCodigoProveedorLessThanOrEqualTo(Integer value) {
            addCriterion("codigo_proveedor <=", value, "codigoProveedor");
            return (Criteria) this;
        }

        public Criteria andCodigoProveedorIn(List<Integer> values) {
            addCriterion("codigo_proveedor in", values, "codigoProveedor");
            return (Criteria) this;
        }

        public Criteria andCodigoProveedorNotIn(List<Integer> values) {
            addCriterion("codigo_proveedor not in", values, "codigoProveedor");
            return (Criteria) this;
        }

        public Criteria andCodigoProveedorBetween(Integer value1, Integer value2) {
            addCriterion("codigo_proveedor between", value1, value2, "codigoProveedor");
            return (Criteria) this;
        }

        public Criteria andCodigoProveedorNotBetween(Integer value1, Integer value2) {
            addCriterion("codigo_proveedor not between", value1, value2, "codigoProveedor");
            return (Criteria) this;
        }

        public Criteria andNombreProveedorIsNull() {
            addCriterion("nombre_proveedor is null");
            return (Criteria) this;
        }

        public Criteria andNombreProveedorIsNotNull() {
            addCriterion("nombre_proveedor is not null");
            return (Criteria) this;
        }

        public Criteria andNombreProveedorEqualTo(String value) {
            addCriterion("nombre_proveedor =", value, "nombreProveedor");
            return (Criteria) this;
        }

        public Criteria andNombreProveedorNotEqualTo(String value) {
            addCriterion("nombre_proveedor <>", value, "nombreProveedor");
            return (Criteria) this;
        }

        public Criteria andNombreProveedorGreaterThan(String value) {
            addCriterion("nombre_proveedor >", value, "nombreProveedor");
            return (Criteria) this;
        }

        public Criteria andNombreProveedorGreaterThanOrEqualTo(String value) {
            addCriterion("nombre_proveedor >=", value, "nombreProveedor");
            return (Criteria) this;
        }

        public Criteria andNombreProveedorLessThan(String value) {
            addCriterion("nombre_proveedor <", value, "nombreProveedor");
            return (Criteria) this;
        }

        public Criteria andNombreProveedorLessThanOrEqualTo(String value) {
            addCriterion("nombre_proveedor <=", value, "nombreProveedor");
            return (Criteria) this;
        }

        public Criteria andNombreProveedorLike(String value) {
            addCriterion("upper(nombre_proveedor) like", value, "nombreProveedor");
            return (Criteria) this;
        }

        public Criteria andNombreProveedorNotLike(String value) {
            addCriterion("nombre_proveedor not like", value, "nombreProveedor");
            return (Criteria) this;
        }

        public Criteria andNombreProveedorIn(List<String> values) {
            addCriterion("nombre_proveedor in", values, "nombreProveedor");
            return (Criteria) this;
        }

        public Criteria andNombreProveedorNotIn(List<String> values) {
            addCriterion("nombre_proveedor not in", values, "nombreProveedor");
            return (Criteria) this;
        }

        public Criteria andNombreProveedorBetween(String value1, String value2) {
            addCriterion("nombre_proveedor between", value1, value2, "nombreProveedor");
            return (Criteria) this;
        }

        public Criteria andNombreProveedorNotBetween(String value1, String value2) {
            addCriterion("nombre_proveedor not between", value1, value2, "nombreProveedor");
            return (Criteria) this;
        }

        public Criteria andEstadoProveedorIsNull() {
            addCriterion("estado_proveedor is null");
            return (Criteria) this;
        }

        public Criteria andEstadoProveedorIsNotNull() {
            addCriterion("estado_proveedor is not null");
            return (Criteria) this;
        }

        public Criteria andEstadoProveedorEqualTo(String value) {
            addCriterion("estado_proveedor =", value, "estadoProveedor");
            return (Criteria) this;
        }

        public Criteria andEstadoProveedorNotEqualTo(String value) {
            addCriterion("estado_proveedor <>", value, "estadoProveedor");
            return (Criteria) this;
        }

        public Criteria andEstadoProveedorGreaterThan(String value) {
            addCriterion("estado_proveedor >", value, "estadoProveedor");
            return (Criteria) this;
        }

        public Criteria andEstadoProveedorGreaterThanOrEqualTo(String value) {
            addCriterion("estado_proveedor >=", value, "estadoProveedor");
            return (Criteria) this;
        }

        public Criteria andEstadoProveedorLessThan(String value) {
            addCriterion("estado_proveedor <", value, "estadoProveedor");
            return (Criteria) this;
        }

        public Criteria andEstadoProveedorLessThanOrEqualTo(String value) {
            addCriterion("estado_proveedor <=", value, "estadoProveedor");
            return (Criteria) this;
        }

        public Criteria andEstadoProveedorLike(String value) {
            addCriterion("estado_proveedor like", value, "estadoProveedor");
            return (Criteria) this;
        }

        public Criteria andEstadoProveedorNotLike(String value) {
            addCriterion("estado_proveedor not like", value, "estadoProveedor");
            return (Criteria) this;
        }

        public Criteria andEstadoProveedorIn(List<String> values) {
            addCriterion("estado_proveedor in", values, "estadoProveedor");
            return (Criteria) this;
        }

        public Criteria andEstadoProveedorNotIn(List<String> values) {
            addCriterion("estado_proveedor not in", values, "estadoProveedor");
            return (Criteria) this;
        }

        public Criteria andEstadoProveedorBetween(String value1, String value2) {
            addCriterion("estado_proveedor between", value1, value2, "estadoProveedor");
            return (Criteria) this;
        }

        public Criteria andEstadoProveedorNotBetween(String value1, String value2) {
            addCriterion("estado_proveedor not between", value1, value2, "estadoProveedor");
            return (Criteria) this;
        }

        public Criteria andNitProveedorIsNull() {
            addCriterion("nit_proveedor is null");
            return (Criteria) this;
        }

        public Criteria andNitProveedorIsNotNull() {
            addCriterion("nit_proveedor is not null");
            return (Criteria) this;
        }

        public Criteria andNitProveedorEqualTo(String value) {
            addCriterion("nit_proveedor =", value, "nitProveedor");
            return (Criteria) this;
        }

        public Criteria andNitProveedorNotEqualTo(String value) {
            addCriterion("nit_proveedor <>", value, "nitProveedor");
            return (Criteria) this;
        }

        public Criteria andNitProveedorGreaterThan(String value) {
            addCriterion("nit_proveedor >", value, "nitProveedor");
            return (Criteria) this;
        }

        public Criteria andNitProveedorGreaterThanOrEqualTo(String value) {
            addCriterion("nit_proveedor >=", value, "nitProveedor");
            return (Criteria) this;
        }

        public Criteria andNitProveedorLessThan(String value) {
            addCriterion("nit_proveedor <", value, "nitProveedor");
            return (Criteria) this;
        }

        public Criteria andNitProveedorLessThanOrEqualTo(String value) {
            addCriterion("nit_proveedor <=", value, "nitProveedor");
            return (Criteria) this;
        }

        public Criteria andNitProveedorLike(String value) {
            addCriterion("nit_proveedor like", value, "nitProveedor");
            return (Criteria) this;
        }

        public Criteria andNitProveedorNotLike(String value) {
            addCriterion("nit_proveedor not like", value, "nitProveedor");
            return (Criteria) this;
        }

        public Criteria andNitProveedorIn(List<String> values) {
            addCriterion("nit_proveedor in", values, "nitProveedor");
            return (Criteria) this;
        }

        public Criteria andNitProveedorNotIn(List<String> values) {
            addCriterion("nit_proveedor not in", values, "nitProveedor");
            return (Criteria) this;
        }

        public Criteria andNitProveedorBetween(String value1, String value2) {
            addCriterion("nit_proveedor between", value1, value2, "nitProveedor");
            return (Criteria) this;
        }

        public Criteria andNitProveedorNotBetween(String value1, String value2) {
            addCriterion("nit_proveedor not between", value1, value2, "nitProveedor");
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
     * proveedores
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
     * proveedores
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