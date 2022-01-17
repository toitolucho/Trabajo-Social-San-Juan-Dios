package org.quarkbit.trabajosocialsanjuan.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PersonaKardexDocumentoExample {
    /**
     *
     * table personas_kardex_documentos
     *
     * 
     */
    protected String orderByClause;

    /**
     *
     * table personas_kardex_documentos
     *
     * 
     */
    protected boolean distinct;

    /**
     *
     * table personas_kardex_documentos
     *
     * 
     */
    protected List<Criteria> oredCriteria;

    /**
     * 
     * table personas_kardex_documentos
     *
     * 
     */
    public PersonaKardexDocumentoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 
     * table personas_kardex_documentos
     *
     * 
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 
     * table personas_kardex_documentos
     *
     * 
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 
     * table personas_kardex_documentos
     *
     * 
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 
     * table personas_kardex_documentos
     *
     * 
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 
     * table personas_kardex_documentos
     *
     * 
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 
     * table personas_kardex_documentos
     *
     * 
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 
     * table personas_kardex_documentos
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
     * table personas_kardex_documentos
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
     * table personas_kardex_documentos
     *
     * 
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 
     * table personas_kardex_documentos
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
     * personas_kardex_documentos
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andCodigoKardexIsNull() {
            addCriterion("codigo_kardex is null");
            return (Criteria) this;
        }

        public Criteria andCodigoKardexIsNotNull() {
            addCriterion("codigo_kardex is not null");
            return (Criteria) this;
        }

        public Criteria andCodigoKardexEqualTo(Integer value) {
            addCriterion("codigo_kardex =", value, "codigoKardex");
            return (Criteria) this;
        }

        public Criteria andCodigoKardexNotEqualTo(Integer value) {
            addCriterion("codigo_kardex <>", value, "codigoKardex");
            return (Criteria) this;
        }

        public Criteria andCodigoKardexGreaterThan(Integer value) {
            addCriterion("codigo_kardex >", value, "codigoKardex");
            return (Criteria) this;
        }

        public Criteria andCodigoKardexGreaterThanOrEqualTo(Integer value) {
            addCriterion("codigo_kardex >=", value, "codigoKardex");
            return (Criteria) this;
        }

        public Criteria andCodigoKardexLessThan(Integer value) {
            addCriterion("codigo_kardex <", value, "codigoKardex");
            return (Criteria) this;
        }

        public Criteria andCodigoKardexLessThanOrEqualTo(Integer value) {
            addCriterion("codigo_kardex <=", value, "codigoKardex");
            return (Criteria) this;
        }

        public Criteria andCodigoKardexIn(List<Integer> values) {
            addCriterion("codigo_kardex in", values, "codigoKardex");
            return (Criteria) this;
        }

        public Criteria andCodigoKardexNotIn(List<Integer> values) {
            addCriterion("codigo_kardex not in", values, "codigoKardex");
            return (Criteria) this;
        }

        public Criteria andCodigoKardexBetween(Integer value1, Integer value2) {
            addCriterion("codigo_kardex between", value1, value2, "codigoKardex");
            return (Criteria) this;
        }

        public Criteria andCodigoKardexNotBetween(Integer value1, Integer value2) {
            addCriterion("codigo_kardex not between", value1, value2, "codigoKardex");
            return (Criteria) this;
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

        public Criteria andFechaRegistroIsNull() {
            addCriterion("fecha_registro is null");
            return (Criteria) this;
        }

        public Criteria andFechaRegistroIsNotNull() {
            addCriterion("fecha_registro is not null");
            return (Criteria) this;
        }

        public Criteria andFechaRegistroEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_registro =", value, "fechaRegistro");
            return (Criteria) this;
        }

        public Criteria andFechaRegistroNotEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_registro <>", value, "fechaRegistro");
            return (Criteria) this;
        }

        public Criteria andFechaRegistroGreaterThan(Date value) {
            addCriterionForJDBCDate("fecha_registro >", value, "fechaRegistro");
            return (Criteria) this;
        }

        public Criteria andFechaRegistroGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_registro >=", value, "fechaRegistro");
            return (Criteria) this;
        }

        public Criteria andFechaRegistroLessThan(Date value) {
            addCriterionForJDBCDate("fecha_registro <", value, "fechaRegistro");
            return (Criteria) this;
        }

        public Criteria andFechaRegistroLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_registro <=", value, "fechaRegistro");
            return (Criteria) this;
        }

        public Criteria andFechaRegistroIn(List<Date> values) {
            addCriterionForJDBCDate("fecha_registro in", values, "fechaRegistro");
            return (Criteria) this;
        }

        public Criteria andFechaRegistroNotIn(List<Date> values) {
            addCriterionForJDBCDate("fecha_registro not in", values, "fechaRegistro");
            return (Criteria) this;
        }

        public Criteria andFechaRegistroBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fecha_registro between", value1, value2, "fechaRegistro");
            return (Criteria) this;
        }

        public Criteria andFechaRegistroNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fecha_registro not between", value1, value2, "fechaRegistro");
            return (Criteria) this;
        }

        public Criteria andTramitoTrabSocialIsNull() {
            addCriterion("tramito_trab_social is null");
            return (Criteria) this;
        }

        public Criteria andTramitoTrabSocialIsNotNull() {
            addCriterion("tramito_trab_social is not null");
            return (Criteria) this;
        }

        public Criteria andTramitoTrabSocialEqualTo(String value) {
            addCriterion("tramito_trab_social =", value, "tramitoTrabSocial");
            return (Criteria) this;
        }

        public Criteria andTramitoTrabSocialNotEqualTo(String value) {
            addCriterion("tramito_trab_social <>", value, "tramitoTrabSocial");
            return (Criteria) this;
        }

        public Criteria andTramitoTrabSocialGreaterThan(String value) {
            addCriterion("tramito_trab_social >", value, "tramitoTrabSocial");
            return (Criteria) this;
        }

        public Criteria andTramitoTrabSocialGreaterThanOrEqualTo(String value) {
            addCriterion("tramito_trab_social >=", value, "tramitoTrabSocial");
            return (Criteria) this;
        }

        public Criteria andTramitoTrabSocialLessThan(String value) {
            addCriterion("tramito_trab_social <", value, "tramitoTrabSocial");
            return (Criteria) this;
        }

        public Criteria andTramitoTrabSocialLessThanOrEqualTo(String value) {
            addCriterion("tramito_trab_social <=", value, "tramitoTrabSocial");
            return (Criteria) this;
        }

        public Criteria andTramitoTrabSocialLike(String value) {
            addCriterion("tramito_trab_social like", value, "tramitoTrabSocial");
            return (Criteria) this;
        }

        public Criteria andTramitoTrabSocialNotLike(String value) {
            addCriterion("tramito_trab_social not like", value, "tramitoTrabSocial");
            return (Criteria) this;
        }

        public Criteria andTramitoTrabSocialIn(List<String> values) {
            addCriterion("tramito_trab_social in", values, "tramitoTrabSocial");
            return (Criteria) this;
        }

        public Criteria andTramitoTrabSocialNotIn(List<String> values) {
            addCriterion("tramito_trab_social not in", values, "tramitoTrabSocial");
            return (Criteria) this;
        }

        public Criteria andTramitoTrabSocialBetween(String value1, String value2) {
            addCriterion("tramito_trab_social between", value1, value2, "tramitoTrabSocial");
            return (Criteria) this;
        }

        public Criteria andTramitoTrabSocialNotBetween(String value1, String value2) {
            addCriterion("tramito_trab_social not between", value1, value2, "tramitoTrabSocial");
            return (Criteria) this;
        }
    }

    /**
     * 
     * personas_kardex_documentos
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
     * personas_kardex_documentos
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