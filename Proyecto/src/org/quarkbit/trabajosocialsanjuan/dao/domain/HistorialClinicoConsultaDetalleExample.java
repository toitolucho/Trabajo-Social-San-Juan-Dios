package org.quarkbit.trabajosocialsanjuan.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class HistorialClinicoConsultaDetalleExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table historia_clinico_consulta_detalle
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table historia_clinico_consulta_detalle
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table historia_clinico_consulta_detalle
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table historia_clinico_consulta_detalle
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    public HistorialClinicoConsultaDetalleExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table historia_clinico_consulta_detalle
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table historia_clinico_consulta_detalle
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table historia_clinico_consulta_detalle
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table historia_clinico_consulta_detalle
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table historia_clinico_consulta_detalle
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table historia_clinico_consulta_detalle
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table historia_clinico_consulta_detalle
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
     * This method corresponds to the database table historia_clinico_consulta_detalle
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
     * This method corresponds to the database table historia_clinico_consulta_detalle
     *
     * @mbggenerated Sun Apr 13 16:11:45 CEST 2014
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table historia_clinico_consulta_detalle
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
     * This class corresponds to the database table historia_clinico_consulta_detalle
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

        public Criteria andNumeroHCConsultaDetalleIsNull() {
            addCriterion("numero_hc_consulta_detalle is null");
            return (Criteria) this;
        }

        public Criteria andNumeroHCConsultaDetalleIsNotNull() {
            addCriterion("numero_hc_consulta_detalle is not null");
            return (Criteria) this;
        }

        public Criteria andNumeroHCConsultaDetalleEqualTo(Integer value) {
            addCriterion("numero_hc_consulta_detalle =", value, "numeroHCConsultaDetalle");
            return (Criteria) this;
        }

        public Criteria andNumeroHCConsultaDetalleNotEqualTo(Integer value) {
            addCriterion("numero_hc_consulta_detalle <>", value, "numeroHCConsultaDetalle");
            return (Criteria) this;
        }

        public Criteria andNumeroHCConsultaDetalleGreaterThan(Integer value) {
            addCriterion("numero_hc_consulta_detalle >", value, "numeroHCConsultaDetalle");
            return (Criteria) this;
        }

        public Criteria andNumeroHCConsultaDetalleGreaterThanOrEqualTo(Integer value) {
            addCriterion("numero_hc_consulta_detalle >=", value, "numeroHCConsultaDetalle");
            return (Criteria) this;
        }

        public Criteria andNumeroHCConsultaDetalleLessThan(Integer value) {
            addCriterion("numero_hc_consulta_detalle <", value, "numeroHCConsultaDetalle");
            return (Criteria) this;
        }

        public Criteria andNumeroHCConsultaDetalleLessThanOrEqualTo(Integer value) {
            addCriterion("numero_hc_consulta_detalle <=", value, "numeroHCConsultaDetalle");
            return (Criteria) this;
        }

        public Criteria andNumeroHCConsultaDetalleIn(List<Integer> values) {
            addCriterion("numero_hc_consulta_detalle in", values, "numeroHCConsultaDetalle");
            return (Criteria) this;
        }

        public Criteria andNumeroHCConsultaDetalleNotIn(List<Integer> values) {
            addCriterion("numero_hc_consulta_detalle not in", values, "numeroHCConsultaDetalle");
            return (Criteria) this;
        }

        public Criteria andNumeroHCConsultaDetalleBetween(Integer value1, Integer value2) {
            addCriterion("numero_hc_consulta_detalle between", value1, value2, "numeroHCConsultaDetalle");
            return (Criteria) this;
        }

        public Criteria andNumeroHCConsultaDetalleNotBetween(Integer value1, Integer value2) {
            addCriterion("numero_hc_consulta_detalle not between", value1, value2, "numeroHCConsultaDetalle");
            return (Criteria) this;
        }

        public Criteria andNumeroHistorialClinicoIsNull() {
            addCriterion("numero_hc is null");
            return (Criteria) this;
        }

        public Criteria andNumeroHistorialClinicoIsNotNull() {
            addCriterion("numero_hc is not null");
            return (Criteria) this;
        }

        public Criteria andNumeroHistorialClinicoEqualTo(Integer value) {
            addCriterion("hccd.numero_hc =", value, "numeroHistorialClinico");
            return (Criteria) this;
        }

        public Criteria andNumeroHistorialClinicoNotEqualTo(Integer value) {
            addCriterion("numero_hc <>", value, "numeroHistorialClinico");
            return (Criteria) this;
        }

        public Criteria andNumeroHistorialClinicoGreaterThan(Integer value) {
            addCriterion("numero_hc >", value, "numeroHistorialClinico");
            return (Criteria) this;
        }

        public Criteria andNumeroHistorialClinicoGreaterThanOrEqualTo(Integer value) {
            addCriterion("numero_hc >=", value, "numeroHistorialClinico");
            return (Criteria) this;
        }

        public Criteria andNumeroHistorialClinicoLessThan(Integer value) {
            addCriterion("numero_hc <", value, "numeroHistorialClinico");
            return (Criteria) this;
        }

        public Criteria andNumeroHistorialClinicoLessThanOrEqualTo(Integer value) {
            addCriterion("numero_hc <=", value, "numeroHistorialClinico");
            return (Criteria) this;
        }

        public Criteria andNumeroHistorialClinicoIn(List<Integer> values) {
            addCriterion("numero_hc in", values, "numeroHistorialClinico");
            return (Criteria) this;
        }

        public Criteria andNumeroHistorialClinicoNotIn(List<Integer> values) {
            addCriterion("numero_hc not in", values, "numeroHistorialClinico");
            return (Criteria) this;
        }

        public Criteria andNumeroHistorialClinicoBetween(Integer value1, Integer value2) {
            addCriterion("numero_hc between", value1, value2, "numeroHistorialClinico");
            return (Criteria) this;
        }

        public Criteria andNumeroHistorialClinicoNotBetween(Integer value1, Integer value2) {
            addCriterion("numero_hc not between", value1, value2, "numeroHistorialClinico");
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
            addCriterion("hccd.numero_propiedad_tipo =", value, "numeroPropiedadTipo");
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

        public Criteria andNumeroConsultaIsNull() {
            addCriterion("numero_consulta is null");
            return (Criteria) this;
        }

        public Criteria andNumeroConsultaIsNotNull() {
            addCriterion("numero_consulta is not null");
            return (Criteria) this;
        }

        public Criteria andNumeroConsultaEqualTo(Integer value) {
            addCriterion("numero_consulta =", value, "numeroConsulta");
            return (Criteria) this;
        }

        public Criteria andNumeroConsultaNotEqualTo(Integer value) {
            addCriterion("numero_consulta <>", value, "numeroConsulta");
            return (Criteria) this;
        }

        public Criteria andNumeroConsultaGreaterThan(Integer value) {
            addCriterion("numero_consulta >", value, "numeroConsulta");
            return (Criteria) this;
        }

        public Criteria andNumeroConsultaGreaterThanOrEqualTo(Integer value) {
            addCriterion("numero_consulta >=", value, "numeroConsulta");
            return (Criteria) this;
        }

        public Criteria andNumeroConsultaLessThan(Integer value) {
            addCriterion("numero_consulta <", value, "numeroConsulta");
            return (Criteria) this;
        }

        public Criteria andNumeroConsultaLessThanOrEqualTo(Integer value) {
            addCriterion("numero_consulta <=", value, "numeroConsulta");
            return (Criteria) this;
        }

        public Criteria andNumeroConsultaIn(List<Integer> values) {
            addCriterion("numero_consulta in", values, "numeroConsulta");
            return (Criteria) this;
        }

        public Criteria andNumeroConsultaNotIn(List<Integer> values) {
            addCriterion("numero_consulta not in", values, "numeroConsulta");
            return (Criteria) this;
        }

        public Criteria andNumeroConsultaBetween(Integer value1, Integer value2) {
            addCriterion("numero_consulta between", value1, value2, "numeroConsulta");
            return (Criteria) this;
        }

        public Criteria andNumeroConsultaNotBetween(Integer value1, Integer value2) {
            addCriterion("numero_consulta not between", value1, value2, "numeroConsulta");
            return (Criteria) this;
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
     * This class corresponds to the database table historia_clinico_consulta_detalle
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
     * This class corresponds to the database table historia_clinico_consulta_detalle
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