package org.quarkbit.trabajosocialsanjuan.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MenuComidaExample {
    /**
     *
     * table menus_comidas
     *
     * 
     */
    protected String orderByClause;

    /**
     *
     * table menus_comidas
     *
     * 
     */
    protected boolean distinct;

    /**
     *
     * table menus_comidas
     *
     * 
     */
    protected List<Criteria> oredCriteria;

    /**
     * 
     * table menus_comidas
     *
     * 
     */
    public MenuComidaExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 
     * table menus_comidas
     *
     * 
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 
     * table menus_comidas
     *
     * 
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 
     * table menus_comidas
     *
     * 
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 
     * table menus_comidas
     *
     * 
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 
     * table menus_comidas
     *
     * 
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 
     * table menus_comidas
     *
     * 
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 
     * table menus_comidas
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
     * table menus_comidas
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
     * table menus_comidas
     *
     * 
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 
     * table menus_comidas
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
     * menus_comidas
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

        public Criteria andCodigoMenuComidaIsNull() {
            addCriterion("codigo_menu_comida is null");
            return (Criteria) this;
        }

        public Criteria andCodigoMenuComidaIsNotNull() {
            addCriterion("codigo_menu_comida is not null");
            return (Criteria) this;
        }

        public Criteria andCodigoMenuComidaEqualTo(Integer value) {
            addCriterion("codigo_menu_comida =", value, "codigoMenuComida");
            return (Criteria) this;
        }

        public Criteria andCodigoMenuComidaNotEqualTo(Integer value) {
            addCriterion("codigo_menu_comida <>", value, "codigoMenuComida");
            return (Criteria) this;
        }

        public Criteria andCodigoMenuComidaGreaterThan(Integer value) {
            addCriterion("codigo_menu_comida >", value, "codigoMenuComida");
            return (Criteria) this;
        }

        public Criteria andCodigoMenuComidaGreaterThanOrEqualTo(Integer value) {
            addCriterion("codigo_menu_comida >=", value, "codigoMenuComida");
            return (Criteria) this;
        }

        public Criteria andCodigoMenuComidaLessThan(Integer value) {
            addCriterion("codigo_menu_comida <", value, "codigoMenuComida");
            return (Criteria) this;
        }

        public Criteria andCodigoMenuComidaLessThanOrEqualTo(Integer value) {
            addCriterion("codigo_menu_comida <=", value, "codigoMenuComida");
            return (Criteria) this;
        }

        public Criteria andCodigoMenuComidaIn(List<Integer> values) {
            addCriterion("codigo_menu_comida in", values, "codigoMenuComida");
            return (Criteria) this;
        }

        public Criteria andCodigoMenuComidaNotIn(List<Integer> values) {
            addCriterion("codigo_menu_comida not in", values, "codigoMenuComida");
            return (Criteria) this;
        }

        public Criteria andCodigoMenuComidaBetween(Integer value1, Integer value2) {
            addCriterion("codigo_menu_comida between", value1, value2, "codigoMenuComida");
            return (Criteria) this;
        }

        public Criteria andCodigoMenuComidaNotBetween(Integer value1, Integer value2) {
            addCriterion("codigo_menu_comida not between", value1, value2, "codigoMenuComida");
            return (Criteria) this;
        }

        public Criteria andNombreMenuIsNull() {
            addCriterion("nombre_menu is null");
            return (Criteria) this;
        }

        public Criteria andNombreMenuIsNotNull() {
            addCriterion("nombre_menu is not null");
            return (Criteria) this;
        }

        public Criteria andNombreMenuEqualTo(String value) {
            addCriterion("nombre_menu =", value, "nombreMenu");
            return (Criteria) this;
        }

        public Criteria andNombreMenuNotEqualTo(String value) {
            addCriterion("nombre_menu <>", value, "nombreMenu");
            return (Criteria) this;
        }

        public Criteria andNombreMenuGreaterThan(String value) {
            addCriterion("nombre_menu >", value, "nombreMenu");
            return (Criteria) this;
        }

        public Criteria andNombreMenuGreaterThanOrEqualTo(String value) {
            addCriterion("nombre_menu >=", value, "nombreMenu");
            return (Criteria) this;
        }

        public Criteria andNombreMenuLessThan(String value) {
            addCriterion("nombre_menu <", value, "nombreMenu");
            return (Criteria) this;
        }

        public Criteria andNombreMenuLessThanOrEqualTo(String value) {
            addCriterion("nombre_menu <=", value, "nombreMenu");
            return (Criteria) this;
        }

        public Criteria andNombreMenuLike(String value) {
            addCriterion("nombre_menu like", value, "nombreMenu");
            return (Criteria) this;
        }

        public Criteria andNombreMenuNotLike(String value) {
            addCriterion("nombre_menu not like", value, "nombreMenu");
            return (Criteria) this;
        }

        public Criteria andNombreMenuIn(List<String> values) {
            addCriterion("nombre_menu in", values, "nombreMenu");
            return (Criteria) this;
        }

        public Criteria andNombreMenuNotIn(List<String> values) {
            addCriterion("nombre_menu not in", values, "nombreMenu");
            return (Criteria) this;
        }

        public Criteria andNombreMenuBetween(String value1, String value2) {
            addCriterion("nombre_menu between", value1, value2, "nombreMenu");
            return (Criteria) this;
        }

        public Criteria andNombreMenuNotBetween(String value1, String value2) {
            addCriterion("nombre_menu not between", value1, value2, "nombreMenu");
            return (Criteria) this;
        }

        public Criteria andFechaInicioIsNull() {
            addCriterion("fecha_inicio is null");
            return (Criteria) this;
        }

        public Criteria andFechaInicioIsNotNull() {
            addCriterion("fecha_inicio is not null");
            return (Criteria) this;
        }

        public Criteria andFechaInicioEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_inicio =", value, "fechaInicio");
            return (Criteria) this;
        }

        public Criteria andFechaInicioNotEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_inicio <>", value, "fechaInicio");
            return (Criteria) this;
        }

        public Criteria andFechaInicioGreaterThan(Date value) {
            addCriterionForJDBCDate("fecha_inicio >", value, "fechaInicio");
            return (Criteria) this;
        }

        public Criteria andFechaInicioGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_inicio >=", value, "fechaInicio");
            return (Criteria) this;
        }

        public Criteria andFechaInicioLessThan(Date value) {
            addCriterionForJDBCDate("fecha_inicio <", value, "fechaInicio");
            return (Criteria) this;
        }

        public Criteria andFechaInicioLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_inicio <=", value, "fechaInicio");
            return (Criteria) this;
        }

        public Criteria andFechaInicioIn(List<Date> values) {
            addCriterionForJDBCDate("fecha_inicio in", values, "fechaInicio");
            return (Criteria) this;
        }

        public Criteria andFechaInicioNotIn(List<Date> values) {
            addCriterionForJDBCDate("fecha_inicio not in", values, "fechaInicio");
            return (Criteria) this;
        }

        public Criteria andFechaInicioBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fecha_inicio between", value1, value2, "fechaInicio");
            return (Criteria) this;
        }

        public Criteria andFechaInicioNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fecha_inicio not between", value1, value2, "fechaInicio");
            return (Criteria) this;
        }

        public Criteria andFechaFinIsNull() {
            addCriterion("fecha_fin is null");
            return (Criteria) this;
        }

        public Criteria andFechaFinIsNotNull() {
            addCriterion("fecha_fin is not null");
            return (Criteria) this;
        }

        public Criteria andFechaFinEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_fin =", value, "fechaFin");
            return (Criteria) this;
        }

        public Criteria andFechaFinNotEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_fin <>", value, "fechaFin");
            return (Criteria) this;
        }

        public Criteria andFechaFinGreaterThan(Date value) {
            addCriterionForJDBCDate("fecha_fin >", value, "fechaFin");
            return (Criteria) this;
        }

        public Criteria andFechaFinGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_fin >=", value, "fechaFin");
            return (Criteria) this;
        }

        public Criteria andFechaFinLessThan(Date value) {
            addCriterionForJDBCDate("fecha_fin <", value, "fechaFin");
            return (Criteria) this;
        }

        public Criteria andFechaFinLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fecha_fin <=", value, "fechaFin");
            return (Criteria) this;
        }

        public Criteria andFechaFinIn(List<Date> values) {
            addCriterionForJDBCDate("fecha_fin in", values, "fechaFin");
            return (Criteria) this;
        }

        public Criteria andFechaFinNotIn(List<Date> values) {
            addCriterionForJDBCDate("fecha_fin not in", values, "fechaFin");
            return (Criteria) this;
        }

        public Criteria andFechaFinBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fecha_fin between", value1, value2, "fechaFin");
            return (Criteria) this;
        }

        public Criteria andFechaFinNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fecha_fin not between", value1, value2, "fechaFin");
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

        public Criteria andCodigoEstadoIsNull() {
            addCriterion("codigo_estado is null");
            return (Criteria) this;
        }

        public Criteria andCodigoEstadoIsNotNull() {
            addCriterion("codigo_estado is not null");
            return (Criteria) this;
        }

        public Criteria andCodigoEstadoEqualTo(String value) {
            addCriterion("codigo_estado =", value, "codigoEstado");
            return (Criteria) this;
        }

        public Criteria andCodigoEstadoNotEqualTo(String value) {
            addCriterion("codigo_estado <>", value, "codigoEstado");
            return (Criteria) this;
        }

        public Criteria andCodigoEstadoGreaterThan(String value) {
            addCriterion("codigo_estado >", value, "codigoEstado");
            return (Criteria) this;
        }

        public Criteria andCodigoEstadoGreaterThanOrEqualTo(String value) {
            addCriterion("codigo_estado >=", value, "codigoEstado");
            return (Criteria) this;
        }

        public Criteria andCodigoEstadoLessThan(String value) {
            addCriterion("codigo_estado <", value, "codigoEstado");
            return (Criteria) this;
        }

        public Criteria andCodigoEstadoLessThanOrEqualTo(String value) {
            addCriterion("codigo_estado <=", value, "codigoEstado");
            return (Criteria) this;
        }

        public Criteria andCodigoEstadoLike(String value) {
            addCriterion("codigo_estado like", value, "codigoEstado");
            return (Criteria) this;
        }

        public Criteria andCodigoEstadoNotLike(String value) {
            addCriterion("codigo_estado not like", value, "codigoEstado");
            return (Criteria) this;
        }

        public Criteria andCodigoEstadoIn(List<String> values) {
            addCriterion("codigo_estado in", values, "codigoEstado");
            return (Criteria) this;
        }

        public Criteria andCodigoEstadoNotIn(List<String> values) {
            addCriterion("codigo_estado not in", values, "codigoEstado");
            return (Criteria) this;
        }

        public Criteria andCodigoEstadoBetween(String value1, String value2) {
            addCriterion("codigo_estado between", value1, value2, "codigoEstado");
            return (Criteria) this;
        }

        public Criteria andCodigoEstadoNotBetween(String value1, String value2) {
            addCriterion("codigo_estado not between", value1, value2, "codigoEstado");
            return (Criteria) this;
        }

        public Criteria andMontoTotalIsNull() {
            addCriterion("monto_total is null");
            return (Criteria) this;
        }

        public Criteria andMontoTotalIsNotNull() {
            addCriterion("monto_total is not null");
            return (Criteria) this;
        }

        public Criteria andMontoTotalEqualTo(Double value) {
            addCriterion("monto_total =", value, "montoTotal");
            return (Criteria) this;
        }

        public Criteria andMontoTotalNotEqualTo(Double value) {
            addCriterion("monto_total <>", value, "montoTotal");
            return (Criteria) this;
        }

        public Criteria andMontoTotalGreaterThan(Double value) {
            addCriterion("monto_total >", value, "montoTotal");
            return (Criteria) this;
        }

        public Criteria andMontoTotalGreaterThanOrEqualTo(Double value) {
            addCriterion("monto_total >=", value, "montoTotal");
            return (Criteria) this;
        }

        public Criteria andMontoTotalLessThan(Double value) {
            addCriterion("monto_total <", value, "montoTotal");
            return (Criteria) this;
        }

        public Criteria andMontoTotalLessThanOrEqualTo(Double value) {
            addCriterion("monto_total <=", value, "montoTotal");
            return (Criteria) this;
        }

        public Criteria andMontoTotalIn(List<Double> values) {
            addCriterion("monto_total in", values, "montoTotal");
            return (Criteria) this;
        }

        public Criteria andMontoTotalNotIn(List<Double> values) {
            addCriterion("monto_total not in", values, "montoTotal");
            return (Criteria) this;
        }

        public Criteria andMontoTotalBetween(Double value1, Double value2) {
            addCriterion("monto_total between", value1, value2, "montoTotal");
            return (Criteria) this;
        }

        public Criteria andMontoTotalNotBetween(Double value1, Double value2) {
            addCriterion("monto_total not between", value1, value2, "montoTotal");
            return (Criteria) this;
        }

        public Criteria andObservacionesIsNull() {
            addCriterion("observaciones is null");
            return (Criteria) this;
        }

        public Criteria andObservacionesIsNotNull() {
            addCriterion("observaciones is not null");
            return (Criteria) this;
        }

        public Criteria andObservacionesEqualTo(String value) {
            addCriterion("observaciones =", value, "observaciones");
            return (Criteria) this;
        }

        public Criteria andObservacionesNotEqualTo(String value) {
            addCriterion("observaciones <>", value, "observaciones");
            return (Criteria) this;
        }

        public Criteria andObservacionesGreaterThan(String value) {
            addCriterion("observaciones >", value, "observaciones");
            return (Criteria) this;
        }

        public Criteria andObservacionesGreaterThanOrEqualTo(String value) {
            addCriterion("observaciones >=", value, "observaciones");
            return (Criteria) this;
        }

        public Criteria andObservacionesLessThan(String value) {
            addCriterion("observaciones <", value, "observaciones");
            return (Criteria) this;
        }

        public Criteria andObservacionesLessThanOrEqualTo(String value) {
            addCriterion("observaciones <=", value, "observaciones");
            return (Criteria) this;
        }

        public Criteria andObservacionesLike(String value) {
            addCriterion("observaciones like", value, "observaciones");
            return (Criteria) this;
        }

        public Criteria andObservacionesNotLike(String value) {
            addCriterion("observaciones not like", value, "observaciones");
            return (Criteria) this;
        }

        public Criteria andObservacionesIn(List<String> values) {
            addCriterion("observaciones in", values, "observaciones");
            return (Criteria) this;
        }

        public Criteria andObservacionesNotIn(List<String> values) {
            addCriterion("observaciones not in", values, "observaciones");
            return (Criteria) this;
        }

        public Criteria andObservacionesBetween(String value1, String value2) {
            addCriterion("observaciones between", value1, value2, "observaciones");
            return (Criteria) this;
        }

        public Criteria andObservacionesNotBetween(String value1, String value2) {
            addCriterion("observaciones not between", value1, value2, "observaciones");
            return (Criteria) this;
        }
    }

    /**
     * 
     * menus_comidas
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
     * menus_comidas
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