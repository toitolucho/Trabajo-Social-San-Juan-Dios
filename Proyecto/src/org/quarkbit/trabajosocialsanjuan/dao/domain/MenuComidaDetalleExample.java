package org.quarkbit.trabajosocialsanjuan.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MenuComidaDetalleExample {
    /**
     *
     * table menus_comidas_detalle
     *
     * 
     */
    protected String orderByClause;

    /**
     *
     * table menus_comidas_detalle
     *
     * 
     */
    protected boolean distinct;

    /**
     *
     * table menus_comidas_detalle
     *
     * 
     */
    protected List<Criteria> oredCriteria;

    /**
     * 
     * table menus_comidas_detalle
     *
     * 
     */
    public MenuComidaDetalleExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 
     * table menus_comidas_detalle
     *
     * 
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 
     * table menus_comidas_detalle
     *
     * 
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 
     * table menus_comidas_detalle
     *
     * 
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 
     * table menus_comidas_detalle
     *
     * 
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 
     * table menus_comidas_detalle
     *
     * 
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 
     * table menus_comidas_detalle
     *
     * 
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 
     * table menus_comidas_detalle
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
     * table menus_comidas_detalle
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
     * table menus_comidas_detalle
     *
     * 
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 
     * table menus_comidas_detalle
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
     * menus_comidas_detalle
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

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
        }

        public Criteria andCodigoMenuComidaDetalleIsNull() {
            addCriterion("codigo_menu_comida_detalle is null");
            return (Criteria) this;
        }

        public Criteria andCodigoMenuComidaDetalleIsNotNull() {
            addCriterion("codigo_menu_comida_detalle is not null");
            return (Criteria) this;
        }

        public Criteria andCodigoMenuComidaDetalleEqualTo(Integer value) {
            addCriterion("codigo_menu_comida_detalle =", value, "codigoMenuComidaDetalle");
            return (Criteria) this;
        }

        public Criteria andCodigoMenuComidaDetalleNotEqualTo(Integer value) {
            addCriterion("codigo_menu_comida_detalle <>", value, "codigoMenuComidaDetalle");
            return (Criteria) this;
        }

        public Criteria andCodigoMenuComidaDetalleGreaterThan(Integer value) {
            addCriterion("codigo_menu_comida_detalle >", value, "codigoMenuComidaDetalle");
            return (Criteria) this;
        }

        public Criteria andCodigoMenuComidaDetalleGreaterThanOrEqualTo(Integer value) {
            addCriterion("codigo_menu_comida_detalle >=", value, "codigoMenuComidaDetalle");
            return (Criteria) this;
        }

        public Criteria andCodigoMenuComidaDetalleLessThan(Integer value) {
            addCriterion("codigo_menu_comida_detalle <", value, "codigoMenuComidaDetalle");
            return (Criteria) this;
        }

        public Criteria andCodigoMenuComidaDetalleLessThanOrEqualTo(Integer value) {
            addCriterion("codigo_menu_comida_detalle <=", value, "codigoMenuComidaDetalle");
            return (Criteria) this;
        }

        public Criteria andCodigoMenuComidaDetalleIn(List<Integer> values) {
            addCriterion("codigo_menu_comida_detalle in", values, "codigoMenuComidaDetalle");
            return (Criteria) this;
        }

        public Criteria andCodigoMenuComidaDetalleNotIn(List<Integer> values) {
            addCriterion("codigo_menu_comida_detalle not in", values, "codigoMenuComidaDetalle");
            return (Criteria) this;
        }

        public Criteria andCodigoMenuComidaDetalleBetween(Integer value1, Integer value2) {
            addCriterion("codigo_menu_comida_detalle between", value1, value2, "codigoMenuComidaDetalle");
            return (Criteria) this;
        }

        public Criteria andCodigoMenuComidaDetalleNotBetween(Integer value1, Integer value2) {
            addCriterion("codigo_menu_comida_detalle not between", value1, value2, "codigoMenuComidaDetalle");
            return (Criteria) this;
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

        public Criteria andFechaIsNull() {
            addCriterion("fecha is null");
            return (Criteria) this;
        }

        public Criteria andFechaIsNotNull() {
            addCriterion("fecha is not null");
            return (Criteria) this;
        }

        public Criteria andFechaEqualTo(Date value) {
            addCriterionForJDBCDate("fecha =", value, "fecha");
            return (Criteria) this;
        }

        public Criteria andFechaNotEqualTo(Date value) {
            addCriterionForJDBCDate("fecha <>", value, "fecha");
            return (Criteria) this;
        }

        public Criteria andFechaGreaterThan(Date value) {
            addCriterionForJDBCDate("fecha >", value, "fecha");
            return (Criteria) this;
        }

        public Criteria andFechaGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fecha >=", value, "fecha");
            return (Criteria) this;
        }

        public Criteria andFechaLessThan(Date value) {
            addCriterionForJDBCDate("fecha <", value, "fecha");
            return (Criteria) this;
        }

        public Criteria andFechaLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fecha <=", value, "fecha");
            return (Criteria) this;
        }

        public Criteria andFechaIn(List<Date> values) {
            addCriterionForJDBCDate("fecha in", values, "fecha");
            return (Criteria) this;
        }

        public Criteria andFechaNotIn(List<Date> values) {
            addCriterionForJDBCDate("fecha not in", values, "fecha");
            return (Criteria) this;
        }

        public Criteria andFechaBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fecha between", value1, value2, "fecha");
            return (Criteria) this;
        }

        public Criteria andFechaNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fecha not between", value1, value2, "fecha");
            return (Criteria) this;
        }

        public Criteria andHoraInicioIsNull() {
            addCriterion("hora_inicio is null");
            return (Criteria) this;
        }

        public Criteria andHoraInicioIsNotNull() {
            addCriterion("hora_inicio is not null");
            return (Criteria) this;
        }

        public Criteria andHoraInicioEqualTo(Date value) {
            addCriterionForJDBCTime("hora_inicio =", value, "horaInicio");
            return (Criteria) this;
        }

        public Criteria andHoraInicioNotEqualTo(Date value) {
            addCriterionForJDBCTime("hora_inicio <>", value, "horaInicio");
            return (Criteria) this;
        }

        public Criteria andHoraInicioGreaterThan(Date value) {
            addCriterionForJDBCTime("hora_inicio >", value, "horaInicio");
            return (Criteria) this;
        }

        public Criteria andHoraInicioGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("hora_inicio >=", value, "horaInicio");
            return (Criteria) this;
        }

        public Criteria andHoraInicioLessThan(Date value) {
            addCriterionForJDBCTime("hora_inicio <", value, "horaInicio");
            return (Criteria) this;
        }

        public Criteria andHoraInicioLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("hora_inicio <=", value, "horaInicio");
            return (Criteria) this;
        }

        public Criteria andHoraInicioIn(List<Date> values) {
            addCriterionForJDBCTime("hora_inicio in", values, "horaInicio");
            return (Criteria) this;
        }

        public Criteria andHoraInicioNotIn(List<Date> values) {
            addCriterionForJDBCTime("hora_inicio not in", values, "horaInicio");
            return (Criteria) this;
        }

        public Criteria andHoraInicioBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("hora_inicio between", value1, value2, "horaInicio");
            return (Criteria) this;
        }

        public Criteria andHoraInicioNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("hora_inicio not between", value1, value2, "horaInicio");
            return (Criteria) this;
        }

        public Criteria andHoraFinIsNull() {
            addCriterion("hora_fin is null");
            return (Criteria) this;
        }

        public Criteria andHoraFinIsNotNull() {
            addCriterion("hora_fin is not null");
            return (Criteria) this;
        }

        public Criteria andHoraFinEqualTo(Date value) {
            addCriterionForJDBCTime("hora_fin =", value, "horaFin");
            return (Criteria) this;
        }

        public Criteria andHoraFinNotEqualTo(Date value) {
            addCriterionForJDBCTime("hora_fin <>", value, "horaFin");
            return (Criteria) this;
        }

        public Criteria andHoraFinGreaterThan(Date value) {
            addCriterionForJDBCTime("hora_fin >", value, "horaFin");
            return (Criteria) this;
        }

        public Criteria andHoraFinGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("hora_fin >=", value, "horaFin");
            return (Criteria) this;
        }

        public Criteria andHoraFinLessThan(Date value) {
            addCriterionForJDBCTime("hora_fin <", value, "horaFin");
            return (Criteria) this;
        }

        public Criteria andHoraFinLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("hora_fin <=", value, "horaFin");
            return (Criteria) this;
        }

        public Criteria andHoraFinIn(List<Date> values) {
            addCriterionForJDBCTime("hora_fin in", values, "horaFin");
            return (Criteria) this;
        }

        public Criteria andHoraFinNotIn(List<Date> values) {
            addCriterionForJDBCTime("hora_fin not in", values, "horaFin");
            return (Criteria) this;
        }

        public Criteria andHoraFinBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("hora_fin between", value1, value2, "horaFin");
            return (Criteria) this;
        }

        public Criteria andHoraFinNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("hora_fin not between", value1, value2, "horaFin");
            return (Criteria) this;
        }

        public Criteria andCantidadPersonasIsNull() {
            addCriterion("cantidad_personas is null");
            return (Criteria) this;
        }

        public Criteria andCantidadPersonasIsNotNull() {
            addCriterion("cantidad_personas is not null");
            return (Criteria) this;
        }

        public Criteria andCantidadPersonasEqualTo(Integer value) {
            addCriterion("cantidad_personas =", value, "cantidadPersonas");
            return (Criteria) this;
        }

        public Criteria andCantidadPersonasNotEqualTo(Integer value) {
            addCriterion("cantidad_personas <>", value, "cantidadPersonas");
            return (Criteria) this;
        }

        public Criteria andCantidadPersonasGreaterThan(Integer value) {
            addCriterion("cantidad_personas >", value, "cantidadPersonas");
            return (Criteria) this;
        }

        public Criteria andCantidadPersonasGreaterThanOrEqualTo(Integer value) {
            addCriterion("cantidad_personas >=", value, "cantidadPersonas");
            return (Criteria) this;
        }

        public Criteria andCantidadPersonasLessThan(Integer value) {
            addCriterion("cantidad_personas <", value, "cantidadPersonas");
            return (Criteria) this;
        }

        public Criteria andCantidadPersonasLessThanOrEqualTo(Integer value) {
            addCriterion("cantidad_personas <=", value, "cantidadPersonas");
            return (Criteria) this;
        }

        public Criteria andCantidadPersonasIn(List<Integer> values) {
            addCriterion("cantidad_personas in", values, "cantidadPersonas");
            return (Criteria) this;
        }

        public Criteria andCantidadPersonasNotIn(List<Integer> values) {
            addCriterion("cantidad_personas not in", values, "cantidadPersonas");
            return (Criteria) this;
        }

        public Criteria andCantidadPersonasBetween(Integer value1, Integer value2) {
            addCriterion("cantidad_personas between", value1, value2, "cantidadPersonas");
            return (Criteria) this;
        }

        public Criteria andCantidadPersonasNotBetween(Integer value1, Integer value2) {
            addCriterion("cantidad_personas not between", value1, value2, "cantidadPersonas");
            return (Criteria) this;
        }

        public Criteria andPrecioUnitarioIsNull() {
            addCriterion("precio_unitario is null");
            return (Criteria) this;
        }

        public Criteria andPrecioUnitarioIsNotNull() {
            addCriterion("precio_unitario is not null");
            return (Criteria) this;
        }

        public Criteria andPrecioUnitarioEqualTo(Double value) {
            addCriterion("precio_unitario =", value, "precioUnitario");
            return (Criteria) this;
        }

        public Criteria andPrecioUnitarioNotEqualTo(Double value) {
            addCriterion("precio_unitario <>", value, "precioUnitario");
            return (Criteria) this;
        }

        public Criteria andPrecioUnitarioGreaterThan(Double value) {
            addCriterion("precio_unitario >", value, "precioUnitario");
            return (Criteria) this;
        }

        public Criteria andPrecioUnitarioGreaterThanOrEqualTo(Double value) {
            addCriterion("precio_unitario >=", value, "precioUnitario");
            return (Criteria) this;
        }

        public Criteria andPrecioUnitarioLessThan(Double value) {
            addCriterion("precio_unitario <", value, "precioUnitario");
            return (Criteria) this;
        }

        public Criteria andPrecioUnitarioLessThanOrEqualTo(Double value) {
            addCriterion("precio_unitario <=", value, "precioUnitario");
            return (Criteria) this;
        }

        public Criteria andPrecioUnitarioIn(List<Double> values) {
            addCriterion("precio_unitario in", values, "precioUnitario");
            return (Criteria) this;
        }

        public Criteria andPrecioUnitarioNotIn(List<Double> values) {
            addCriterion("precio_unitario not in", values, "precioUnitario");
            return (Criteria) this;
        }

        public Criteria andPrecioUnitarioBetween(Double value1, Double value2) {
            addCriterion("precio_unitario between", value1, value2, "precioUnitario");
            return (Criteria) this;
        }

        public Criteria andPrecioUnitarioNotBetween(Double value1, Double value2) {
            addCriterion("precio_unitario not between", value1, value2, "precioUnitario");
            return (Criteria) this;
        }
    }

    /**
     * 
     * menus_comidas_detalle
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
     * menus_comidas_detalle
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