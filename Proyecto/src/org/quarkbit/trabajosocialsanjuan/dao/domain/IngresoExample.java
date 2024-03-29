package org.quarkbit.trabajosocialsanjuan.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class IngresoExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ingresos
     *
     * @mbggenerated Thu Mar 20 09:56:36 BOT 2014
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ingresos
     *
     * @mbggenerated Thu Mar 20 09:56:36 BOT 2014
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ingresos
     *
     * @mbggenerated Thu Mar 20 09:56:36 BOT 2014
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ingresos
     *
     * @mbggenerated Thu Mar 20 09:56:36 BOT 2014
     */
    public IngresoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ingresos
     *
     * @mbggenerated Thu Mar 20 09:56:36 BOT 2014
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ingresos
     *
     * @mbggenerated Thu Mar 20 09:56:36 BOT 2014
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ingresos
     *
     * @mbggenerated Thu Mar 20 09:56:36 BOT 2014
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ingresos
     *
     * @mbggenerated Thu Mar 20 09:56:36 BOT 2014
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ingresos
     *
     * @mbggenerated Thu Mar 20 09:56:36 BOT 2014
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ingresos
     *
     * @mbggenerated Thu Mar 20 09:56:36 BOT 2014
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ingresos
     *
     * @mbggenerated Thu Mar 20 09:56:36 BOT 2014
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ingresos
     *
     * @mbggenerated Thu Mar 20 09:56:36 BOT 2014
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
     * This method corresponds to the database table ingresos
     *
     * @mbggenerated Thu Mar 20 09:56:36 BOT 2014
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ingresos
     *
     * @mbggenerated Thu Mar 20 09:56:36 BOT 2014
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ingresos
     *
     * @mbggenerated Thu Mar 20 09:56:36 BOT 2014
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

        public Criteria andCodigoIngresoIsNull() {
            addCriterion("codigo_ingreso is null");
            return (Criteria) this;
        }

        public Criteria andCodigoIngresoIsNotNull() {
            addCriterion("codigo_ingreso is not null");
            return (Criteria) this;
        }

        public Criteria andCodigoIngresoEqualTo(Integer value) {
            addCriterion("codigo_ingreso =", value, "codigoIngreso");
            return (Criteria) this;
        }

        public Criteria andCodigoIngresoNotEqualTo(Integer value) {
            addCriterion("codigo_ingreso <>", value, "codigoIngreso");
            return (Criteria) this;
        }

        public Criteria andCodigoIngresoGreaterThan(Integer value) {
            addCriterion("codigo_ingreso >", value, "codigoIngreso");
            return (Criteria) this;
        }

        public Criteria andCodigoIngresoGreaterThanOrEqualTo(Integer value) {
            addCriterion("codigo_ingreso >=", value, "codigoIngreso");
            return (Criteria) this;
        }

        public Criteria andCodigoIngresoLessThan(Integer value) {
            addCriterion("codigo_ingreso <", value, "codigoIngreso");
            return (Criteria) this;
        }

        public Criteria andCodigoIngresoLessThanOrEqualTo(Integer value) {
            addCriterion("codigo_ingreso <=", value, "codigoIngreso");
            return (Criteria) this;
        }

        public Criteria andCodigoIngresoIn(List<Integer> values) {
            addCriterion("codigo_ingreso in", values, "codigoIngreso");
            return (Criteria) this;
        }

        public Criteria andCodigoIngresoNotIn(List<Integer> values) {
            addCriterion("codigo_ingreso not in", values, "codigoIngreso");
            return (Criteria) this;
        }

        public Criteria andCodigoIngresoBetween(Integer value1, Integer value2) {
            addCriterion("codigo_ingreso between", value1, value2, "codigoIngreso");
            return (Criteria) this;
        }

        public Criteria andCodigoIngresoNotBetween(Integer value1, Integer value2) {
            addCriterion("codigo_ingreso not between", value1, value2, "codigoIngreso");
            return (Criteria) this;
        }

        public Criteria andFechaIngresoIsNull() {
            addCriterion("fecha_ingreso is null");
            return (Criteria) this;
        }

        public Criteria andFechaIngresoIsNotNull() {
            addCriterion("fecha_ingreso is not null");
            return (Criteria) this;
        }

        public Criteria andFechaIngresoEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_ingreso =", value, "fechaIngreso");
            return (Criteria) this;
        }

        public Criteria andFechaIngresoNotEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_ingreso <>", value, "fechaIngreso");
            return (Criteria) this;
        }

        public Criteria andFechaIngresoGreaterThan(Date value) {
            addCriterionForJDBCDate("fecha_ingreso >", value, "fechaIngreso");
            return (Criteria) this;
        }

        public Criteria andFechaIngresoGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_ingreso >=", value, "fechaIngreso");
            return (Criteria) this;
        }

        public Criteria andFechaIngresoLessThan(Date value) {
            addCriterionForJDBCDate("fecha_ingreso <", value, "fechaIngreso");
            return (Criteria) this;
        }

        public Criteria andFechaIngresoLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_ingreso <=", value, "fechaIngreso");
            return (Criteria) this;
        }

        public Criteria andFechaIngresoIn(List<Date> values) {
            addCriterionForJDBCDate("fecha_ingreso in", values, "fechaIngreso");
            return (Criteria) this;
        }

        public Criteria andFechaIngresoNotIn(List<Date> values) {
            addCriterionForJDBCDate("fecha_ingreso not in", values, "fechaIngreso");
            return (Criteria) this;
        }

        public Criteria andFechaIngresoBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fecha_ingreso between", value1, value2, "fechaIngreso");
            return (Criteria) this;
        }

        public Criteria andFechaIngresoNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fecha_ingreso not between", value1, value2, "fechaIngreso");
            return (Criteria) this;
        }

        public Criteria andNombreIngresoIsNull() {
            addCriterion("nombre_ingreso is null");
            return (Criteria) this;
        }

        public Criteria andNombreIngresoIsNotNull() {
            addCriterion("nombre_ingreso is not null");
            return (Criteria) this;
        }

        public Criteria andNombreIngresoEqualTo(String value) {
            addCriterion("nombre_ingreso =", value, "nombreIngreso");
            return (Criteria) this;
        }

        public Criteria andNombreIngresoNotEqualTo(String value) {
            addCriterion("nombre_ingreso <>", value, "nombreIngreso");
            return (Criteria) this;
        }

        public Criteria andNombreIngresoGreaterThan(String value) {
            addCriterion("nombre_ingreso >", value, "nombreIngreso");
            return (Criteria) this;
        }

        public Criteria andNombreIngresoGreaterThanOrEqualTo(String value) {
            addCriterion("nombre_ingreso >=", value, "nombreIngreso");
            return (Criteria) this;
        }

        public Criteria andNombreIngresoLessThan(String value) {
            addCriterion("nombre_ingreso <", value, "nombreIngreso");
            return (Criteria) this;
        }

        public Criteria andNombreIngresoLessThanOrEqualTo(String value) {
            addCriterion("nombre_ingreso <=", value, "nombreIngreso");
            return (Criteria) this;
        }

        public Criteria andNombreIngresoLike(String value) {
            addCriterion("nombre_ingreso like", value, "nombreIngreso");
            return (Criteria) this;
        }

        public Criteria andNombreIngresoNotLike(String value) {
            addCriterion("nombre_ingreso not like", value, "nombreIngreso");
            return (Criteria) this;
        }

        public Criteria andNombreIngresoIn(List<String> values) {
            addCriterion("nombre_ingreso in", values, "nombreIngreso");
            return (Criteria) this;
        }

        public Criteria andNombreIngresoNotIn(List<String> values) {
            addCriterion("nombre_ingreso not in", values, "nombreIngreso");
            return (Criteria) this;
        }

        public Criteria andNombreIngresoBetween(String value1, String value2) {
            addCriterion("nombre_ingreso between", value1, value2, "nombreIngreso");
            return (Criteria) this;
        }

        public Criteria andNombreIngresoNotBetween(String value1, String value2) {
            addCriterion("nombre_ingreso not between", value1, value2, "nombreIngreso");
            return (Criteria) this;
        }

        public Criteria andCodigoUsuarioIsNull() {
            addCriterion("codigo_usuario is null");
            return (Criteria) this;
        }

        public Criteria andCodigoUsuarioIsNotNull() {
            addCriterion("codigo_usuario is not null");
            return (Criteria) this;
        }

        public Criteria andCodigoUsuarioEqualTo(Integer value) {
            addCriterion("codigo_usuario =", value, "codigoUsuario");
            return (Criteria) this;
        }

        public Criteria andCodigoUsuarioNotEqualTo(Integer value) {
            addCriterion("codigo_usuario <>", value, "codigoUsuario");
            return (Criteria) this;
        }

        public Criteria andCodigoUsuarioGreaterThan(Integer value) {
            addCriterion("codigo_usuario >", value, "codigoUsuario");
            return (Criteria) this;
        }

        public Criteria andCodigoUsuarioGreaterThanOrEqualTo(Integer value) {
            addCriterion("codigo_usuario >=", value, "codigoUsuario");
            return (Criteria) this;
        }

        public Criteria andCodigoUsuarioLessThan(Integer value) {
            addCriterion("codigo_usuario <", value, "codigoUsuario");
            return (Criteria) this;
        }

        public Criteria andCodigoUsuarioLessThanOrEqualTo(Integer value) {
            addCriterion("codigo_usuario <=", value, "codigoUsuario");
            return (Criteria) this;
        }

        public Criteria andCodigoUsuarioIn(List<Integer> values) {
            addCriterion("codigo_usuario in", values, "codigoUsuario");
            return (Criteria) this;
        }

        public Criteria andCodigoUsuarioNotIn(List<Integer> values) {
            addCriterion("codigo_usuario not in", values, "codigoUsuario");
            return (Criteria) this;
        }

        public Criteria andCodigoUsuarioBetween(Integer value1, Integer value2) {
            addCriterion("codigo_usuario between", value1, value2, "codigoUsuario");
            return (Criteria) this;
        }

        public Criteria andCodigoUsuarioNotBetween(Integer value1, Integer value2) {
            addCriterion("codigo_usuario not between", value1, value2, "codigoUsuario");
            return (Criteria) this;
        }

        public Criteria andMontoIngresoIsNull() {
            addCriterion("monto_ingreso is null");
            return (Criteria) this;
        }

        public Criteria andMontoIngresoIsNotNull() {
            addCriterion("monto_ingreso is not null");
            return (Criteria) this;
        }

        public Criteria andMontoIngresoEqualTo(Double value) {
            addCriterion("monto_ingreso =", value, "montoIngreso");
            return (Criteria) this;
        }

        public Criteria andMontoIngresoNotEqualTo(Double value) {
            addCriterion("monto_ingreso <>", value, "montoIngreso");
            return (Criteria) this;
        }

        public Criteria andMontoIngresoGreaterThan(Double value) {
            addCriterion("monto_ingreso >", value, "montoIngreso");
            return (Criteria) this;
        }

        public Criteria andMontoIngresoGreaterThanOrEqualTo(Double value) {
            addCriterion("monto_ingreso >=", value, "montoIngreso");
            return (Criteria) this;
        }

        public Criteria andMontoIngresoLessThan(Double value) {
            addCriterion("monto_ingreso <", value, "montoIngreso");
            return (Criteria) this;
        }

        public Criteria andMontoIngresoLessThanOrEqualTo(Double value) {
            addCriterion("monto_ingreso <=", value, "montoIngreso");
            return (Criteria) this;
        }

        public Criteria andMontoIngresoIn(List<Double> values) {
            addCriterion("monto_ingreso in", values, "montoIngreso");
            return (Criteria) this;
        }

        public Criteria andMontoIngresoNotIn(List<Double> values) {
            addCriterion("monto_ingreso not in", values, "montoIngreso");
            return (Criteria) this;
        }

        public Criteria andMontoIngresoBetween(Double value1, Double value2) {
            addCriterion("monto_ingreso between", value1, value2, "montoIngreso");
            return (Criteria) this;
        }

        public Criteria andMontoIngresoNotBetween(Double value1, Double value2) {
            addCriterion("monto_ingreso not between", value1, value2, "montoIngreso");
            return (Criteria) this;
        }

        public Criteria andMontoActualIsNull() {
            addCriterion("monto_actual is null");
            return (Criteria) this;
        }

        public Criteria andMontoActualIsNotNull() {
            addCriterion("monto_actual is not null");
            return (Criteria) this;
        }

        public Criteria andMontoActualEqualTo(Double value) {
            addCriterion("monto_actual =", value, "montoActual");
            return (Criteria) this;
        }

        public Criteria andMontoActualNotEqualTo(Double value) {
            addCriterion("monto_actual <>", value, "montoActual");
            return (Criteria) this;
        }

        public Criteria andMontoActualGreaterThan(Double value) {
            addCriterion("monto_actual >", value, "montoActual");
            return (Criteria) this;
        }

        public Criteria andMontoActualGreaterThanOrEqualTo(Double value) {
            addCriterion("monto_actual >=", value, "montoActual");
            return (Criteria) this;
        }

        public Criteria andMontoActualLessThan(Double value) {
            addCriterion("monto_actual <", value, "montoActual");
            return (Criteria) this;
        }

        public Criteria andMontoActualLessThanOrEqualTo(Double value) {
            addCriterion("monto_actual <=", value, "montoActual");
            return (Criteria) this;
        }

        public Criteria andMontoActualIn(List<Double> values) {
            addCriterion("monto_actual in", values, "montoActual");
            return (Criteria) this;
        }

        public Criteria andMontoActualNotIn(List<Double> values) {
            addCriterion("monto_actual not in", values, "montoActual");
            return (Criteria) this;
        }

        public Criteria andMontoActualBetween(Double value1, Double value2) {
            addCriterion("monto_actual between", value1, value2, "montoActual");
            return (Criteria) this;
        }

        public Criteria andMontoActualNotBetween(Double value1, Double value2) {
            addCriterion("monto_actual not between", value1, value2, "montoActual");
            return (Criteria) this;
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

        public Criteria andDetalleIngresoIsNull() {
            addCriterion("detalle_ingreso is null");
            return (Criteria) this;
        }

        public Criteria andDetalleIngresoIsNotNull() {
            addCriterion("detalle_ingreso is not null");
            return (Criteria) this;
        }

        public Criteria andDetalleIngresoEqualTo(String value) {
            addCriterion("detalle_ingreso =", value, "detalleIngreso");
            return (Criteria) this;
        }

        public Criteria andDetalleIngresoNotEqualTo(String value) {
            addCriterion("detalle_ingreso <>", value, "detalleIngreso");
            return (Criteria) this;
        }

        public Criteria andDetalleIngresoGreaterThan(String value) {
            addCriterion("detalle_ingreso >", value, "detalleIngreso");
            return (Criteria) this;
        }

        public Criteria andDetalleIngresoGreaterThanOrEqualTo(String value) {
            addCriterion("detalle_ingreso >=", value, "detalleIngreso");
            return (Criteria) this;
        }

        public Criteria andDetalleIngresoLessThan(String value) {
            addCriterion("detalle_ingreso <", value, "detalleIngreso");
            return (Criteria) this;
        }

        public Criteria andDetalleIngresoLessThanOrEqualTo(String value) {
            addCriterion("detalle_ingreso <=", value, "detalleIngreso");
            return (Criteria) this;
        }

        public Criteria andDetalleIngresoLike(String value) {
            addCriterion("detalle_ingreso like", value, "detalleIngreso");
            return (Criteria) this;
        }

        public Criteria andDetalleIngresoNotLike(String value) {
            addCriterion("detalle_ingreso not like", value, "detalleIngreso");
            return (Criteria) this;
        }

        public Criteria andDetalleIngresoIn(List<String> values) {
            addCriterion("detalle_ingreso in", values, "detalleIngreso");
            return (Criteria) this;
        }

        public Criteria andDetalleIngresoNotIn(List<String> values) {
            addCriterion("detalle_ingreso not in", values, "detalleIngreso");
            return (Criteria) this;
        }

        public Criteria andDetalleIngresoBetween(String value1, String value2) {
            addCriterion("detalle_ingreso between", value1, value2, "detalleIngreso");
            return (Criteria) this;
        }

        public Criteria andDetalleIngresoNotBetween(String value1, String value2) {
            addCriterion("detalle_ingreso not between", value1, value2, "detalleIngreso");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ingresos
     *
     * @mbggenerated do_not_delete_during_merge Thu Mar 20 09:56:36 BOT 2014
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ingresos
     *
     * @mbggenerated Thu Mar 20 09:56:36 BOT 2014
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