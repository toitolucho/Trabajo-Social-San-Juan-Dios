package org.quarkbit.trabajosocialsanjuan.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class DocumentoExample {
    /**
     *
     * table documentos
     *
     * 
     */
    protected String orderByClause;

    /**
     *
     * table documentos
     *
     * 
     */
    protected boolean distinct;

    /**
     *
     * table documentos
     *
     * 
     */
    protected List<Criteria> oredCriteria;

    /**
     * 
     * table documentos
     *
     * 
     */
    public DocumentoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 
     * table documentos
     *
     * 
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 
     * table documentos
     *
     * 
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 
     * table documentos
     *
     * 
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 
     * table documentos
     *
     * 
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 
     * table documentos
     *
     * 
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 
     * table documentos
     *
     * 
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 
     * table documentos
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
     * table documentos
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
     * table documentos
     *
     * 
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 
     * table documentos
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
     * documentos
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

        public Criteria andCodigoDocumentoIsNull() {
            addCriterion("codigo_documento is null");
            return (Criteria) this;
        }

        public Criteria andCodigoDocumentoIsNotNull() {
            addCriterion("codigo_documento is not null");
            return (Criteria) this;
        }

        public Criteria andCodigoDocumentoEqualTo(Integer value) {
            addCriterion("codigo_documento =", value, "codigoDocumento");
            return (Criteria) this;
        }

        public Criteria andCodigoDocumentoNotEqualTo(Integer value) {
            addCriterion("codigo_documento <>", value, "codigoDocumento");
            return (Criteria) this;
        }

        public Criteria andCodigoDocumentoGreaterThan(Integer value) {
            addCriterion("codigo_documento >", value, "codigoDocumento");
            return (Criteria) this;
        }

        public Criteria andCodigoDocumentoGreaterThanOrEqualTo(Integer value) {
            addCriterion("codigo_documento >=", value, "codigoDocumento");
            return (Criteria) this;
        }

        public Criteria andCodigoDocumentoLessThan(Integer value) {
            addCriterion("codigo_documento <", value, "codigoDocumento");
            return (Criteria) this;
        }

        public Criteria andCodigoDocumentoLessThanOrEqualTo(Integer value) {
            addCriterion("codigo_documento <=", value, "codigoDocumento");
            return (Criteria) this;
        }

        public Criteria andCodigoDocumentoIn(List<Integer> values) {
            addCriterion("codigo_documento in", values, "codigoDocumento");
            return (Criteria) this;
        }

        public Criteria andCodigoDocumentoNotIn(List<Integer> values) {
            addCriterion("codigo_documento not in", values, "codigoDocumento");
            return (Criteria) this;
        }

        public Criteria andCodigoDocumentoBetween(Integer value1, Integer value2) {
            addCriterion("codigo_documento between", value1, value2, "codigoDocumento");
            return (Criteria) this;
        }

        public Criteria andCodigoDocumentoNotBetween(Integer value1, Integer value2) {
            addCriterion("codigo_documento not between", value1, value2, "codigoDocumento");
            return (Criteria) this;
        }

        public Criteria andNombreDocumentoIsNull() {
            addCriterion("nombre_documento is null");
            return (Criteria) this;
        }

        public Criteria andNombreDocumentoIsNotNull() {
            addCriterion("nombre_documento is not null");
            return (Criteria) this;
        }

        public Criteria andNombreDocumentoEqualTo(String value) {
            addCriterion("nombre_documento =", value, "nombreDocumento");
            return (Criteria) this;
        }

        public Criteria andNombreDocumentoNotEqualTo(String value) {
            addCriterion("nombre_documento <>", value, "nombreDocumento");
            return (Criteria) this;
        }

        public Criteria andNombreDocumentoGreaterThan(String value) {
            addCriterion("nombre_documento >", value, "nombreDocumento");
            return (Criteria) this;
        }

        public Criteria andNombreDocumentoGreaterThanOrEqualTo(String value) {
            addCriterion("nombre_documento >=", value, "nombreDocumento");
            return (Criteria) this;
        }

        public Criteria andNombreDocumentoLessThan(String value) {
            addCriterion("nombre_documento <", value, "nombreDocumento");
            return (Criteria) this;
        }

        public Criteria andNombreDocumentoLessThanOrEqualTo(String value) {
            addCriterion("nombre_documento <=", value, "nombreDocumento");
            return (Criteria) this;
        }

        public Criteria andNombreDocumentoLike(String value) {
            addCriterion("nombre_documento like", value, "nombreDocumento");
            return (Criteria) this;
        }

        public Criteria andNombreDocumentoNotLike(String value) {
            addCriterion("nombre_documento not like", value, "nombreDocumento");
            return (Criteria) this;
        }

        public Criteria andNombreDocumentoIn(List<String> values) {
            addCriterion("nombre_documento in", values, "nombreDocumento");
            return (Criteria) this;
        }

        public Criteria andNombreDocumentoNotIn(List<String> values) {
            addCriterion("nombre_documento not in", values, "nombreDocumento");
            return (Criteria) this;
        }

        public Criteria andNombreDocumentoBetween(String value1, String value2) {
            addCriterion("nombre_documento between", value1, value2, "nombreDocumento");
            return (Criteria) this;
        }

        public Criteria andNombreDocumentoNotBetween(String value1, String value2) {
            addCriterion("nombre_documento not between", value1, value2, "nombreDocumento");
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
     * documentos
     *
     * @mbggenerated do_not_delete_during_merge Wed Jan 22 18:05:01 BOT 2014
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 
     * documentos
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