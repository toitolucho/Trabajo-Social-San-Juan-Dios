package org.quarkbit.trabajosocialsanjuan.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class InstitucionExample {
    /**
     *
     * table instituciones
     *
     * 
     */
    protected String orderByClause;

    /**
     *
     * table instituciones
     *
     * 
     */
    protected boolean distinct;

    /**
     *
     * table instituciones
     *
     * 
     */
    protected List<Criteria> oredCriteria;

    /**
     * 
     * table instituciones
     *
     * 
     */
    public InstitucionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 
     * table instituciones
     *
     * 
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 
     * table instituciones
     *
     * 
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 
     * table instituciones
     *
     * 
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 
     * table instituciones
     *
     * 
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 
     * table instituciones
     *
     * 
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 
     * table instituciones
     *
     * 
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 
     * table instituciones
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
     * table instituciones
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
     * table instituciones
     *
     * 
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 
     * table instituciones
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
     * instituciones
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

        public Criteria andCodigoInstitucionIsNull() {
            addCriterion("codigo_institucion is null");
            return (Criteria) this;
        }

        public Criteria andCodigoInstitucionIsNotNull() {
            addCriterion("codigo_institucion is not null");
            return (Criteria) this;
        }

        public Criteria andCodigoInstitucionEqualTo(Integer value) {
            addCriterion("codigo_institucion =", value, "codigoInstitucion");
            return (Criteria) this;
        }

        public Criteria andCodigoInstitucionNotEqualTo(Integer value) {
            addCriterion("codigo_institucion <>", value, "codigoInstitucion");
            return (Criteria) this;
        }

        public Criteria andCodigoInstitucionGreaterThan(Integer value) {
            addCriterion("codigo_institucion >", value, "codigoInstitucion");
            return (Criteria) this;
        }

        public Criteria andCodigoInstitucionGreaterThanOrEqualTo(Integer value) {
            addCriterion("codigo_institucion >=", value, "codigoInstitucion");
            return (Criteria) this;
        }

        public Criteria andCodigoInstitucionLessThan(Integer value) {
            addCriterion("codigo_institucion <", value, "codigoInstitucion");
            return (Criteria) this;
        }

        public Criteria andCodigoInstitucionLessThanOrEqualTo(Integer value) {
            addCriterion("codigo_institucion <=", value, "codigoInstitucion");
            return (Criteria) this;
        }

        public Criteria andCodigoInstitucionIn(List<Integer> values) {
            addCriterion("codigo_institucion in", values, "codigoInstitucion");
            return (Criteria) this;
        }

        public Criteria andCodigoInstitucionNotIn(List<Integer> values) {
            addCriterion("codigo_institucion not in", values, "codigoInstitucion");
            return (Criteria) this;
        }

        public Criteria andCodigoInstitucionBetween(Integer value1, Integer value2) {
            addCriterion("codigo_institucion between", value1, value2, "codigoInstitucion");
            return (Criteria) this;
        }

        public Criteria andCodigoInstitucionNotBetween(Integer value1, Integer value2) {
            addCriterion("codigo_institucion not between", value1, value2, "codigoInstitucion");
            return (Criteria) this;
        }

        public Criteria andNombreInstitucionIsNull() {
            addCriterion("nombre_institucion is null");
            return (Criteria) this;
        }

        public Criteria andNombreInstitucionIsNotNull() {
            addCriterion("nombre_institucion is not null");
            return (Criteria) this;
        }

        public Criteria andNombreInstitucionEqualTo(String value) {
            addCriterion("nombre_institucion =", value, "nombreInstitucion");
            return (Criteria) this;
        }

        public Criteria andNombreInstitucionNotEqualTo(String value) {
            addCriterion("nombre_institucion <>", value, "nombreInstitucion");
            return (Criteria) this;
        }

        public Criteria andNombreInstitucionGreaterThan(String value) {
            addCriterion("nombre_institucion >", value, "nombreInstitucion");
            return (Criteria) this;
        }

        public Criteria andNombreInstitucionGreaterThanOrEqualTo(String value) {
            addCriterion("nombre_institucion >=", value, "nombreInstitucion");
            return (Criteria) this;
        }

        public Criteria andNombreInstitucionLessThan(String value) {
            addCriterion("nombre_institucion <", value, "nombreInstitucion");
            return (Criteria) this;
        }

        public Criteria andNombreInstitucionLessThanOrEqualTo(String value) {
            addCriterion("nombre_institucion <=", value, "nombreInstitucion");
            return (Criteria) this;
        }

        public Criteria andNombreInstitucionLike(String value) {
            addCriterion("nombre_institucion like", value, "nombreInstitucion");
            return (Criteria) this;
        }

        public Criteria andNombreInstitucionNotLike(String value) {
            addCriterion("nombre_institucion not like", value, "nombreInstitucion");
            return (Criteria) this;
        }

        public Criteria andNombreInstitucionIn(List<String> values) {
            addCriterion("nombre_institucion in", values, "nombreInstitucion");
            return (Criteria) this;
        }

        public Criteria andNombreInstitucionNotIn(List<String> values) {
            addCriterion("nombre_institucion not in", values, "nombreInstitucion");
            return (Criteria) this;
        }

        public Criteria andNombreInstitucionBetween(String value1, String value2) {
            addCriterion("nombre_institucion between", value1, value2, "nombreInstitucion");
            return (Criteria) this;
        }

        public Criteria andNombreInstitucionNotBetween(String value1, String value2) {
            addCriterion("nombre_institucion not between", value1, value2, "nombreInstitucion");
            return (Criteria) this;
        }

        public Criteria andDireccionIsNull() {
            addCriterion("direccion is null");
            return (Criteria) this;
        }

        public Criteria andDireccionIsNotNull() {
            addCriterion("direccion is not null");
            return (Criteria) this;
        }

        public Criteria andDireccionEqualTo(String value) {
            addCriterion("direccion =", value, "Direccion");
            return (Criteria) this;
        }

        public Criteria andDireccionNotEqualTo(String value) {
            addCriterion("direccion <>", value, "Direccion");
            return (Criteria) this;
        }

        public Criteria andDireccionGreaterThan(String value) {
            addCriterion("direccion >", value, "Direccion");
            return (Criteria) this;
        }

        public Criteria andDireccionGreaterThanOrEqualTo(String value) {
            addCriterion("direccion >=", value, "Direccion");
            return (Criteria) this;
        }

        public Criteria andDireccionLessThan(String value) {
            addCriterion("direccion <", value, "Direccion");
            return (Criteria) this;
        }

        public Criteria andDireccionLessThanOrEqualTo(String value) {
            addCriterion("direccion <=", value, "Direccion");
            return (Criteria) this;
        }

        public Criteria andDireccionLike(String value) {
            addCriterion("direccion like", value, "Direccion");
            return (Criteria) this;
        }

        public Criteria andDireccionNotLike(String value) {
            addCriterion("direccion not like", value, "Direccion");
            return (Criteria) this;
        }

        public Criteria andDireccionIn(List<String> values) {
            addCriterion("direccion in", values, "Direccion");
            return (Criteria) this;
        }

        public Criteria andDireccionNotIn(List<String> values) {
            addCriterion("direccion not in", values, "Direccion");
            return (Criteria) this;
        }

        public Criteria andDireccionBetween(String value1, String value2) {
            addCriterion("direccion between", value1, value2, "Direccion");
            return (Criteria) this;
        }

        public Criteria andDireccionNotBetween(String value1, String value2) {
            addCriterion("direccion not between", value1, value2, "Direccion");
            return (Criteria) this;
        }

        public Criteria andTelefonoIsNull() {
            addCriterion("telefono is null");
            return (Criteria) this;
        }

        public Criteria andTelefonoIsNotNull() {
            addCriterion("telefono is not null");
            return (Criteria) this;
        }

        public Criteria andTelefonoEqualTo(String value) {
            addCriterion("telefono =", value, "Telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoNotEqualTo(String value) {
            addCriterion("telefono <>", value, "Telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoGreaterThan(String value) {
            addCriterion("telefono >", value, "Telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoGreaterThanOrEqualTo(String value) {
            addCriterion("telefono >=", value, "Telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoLessThan(String value) {
            addCriterion("telefono <", value, "Telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoLessThanOrEqualTo(String value) {
            addCriterion("telefono <=", value, "Telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoLike(String value) {
            addCriterion("telefono like", value, "Telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoNotLike(String value) {
            addCriterion("telefono not like", value, "Telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoIn(List<String> values) {
            addCriterion("telefono in", values, "Telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoNotIn(List<String> values) {
            addCriterion("telefono not in", values, "Telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoBetween(String value1, String value2) {
            addCriterion("telefono between", value1, value2, "Telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoNotBetween(String value1, String value2) {
            addCriterion("telefono not between", value1, value2, "Telefono");
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
     * instituciones
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
     * instituciones
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