package org.quarkbit.trabajosocialsanjuan.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EgresoExample {
    /**
     *
     * table egresos
     *
     * 
     */
    protected String orderByClause;

    /**
     *
     * table egresos
     *
     * 
     */
    protected boolean distinct;

    /**
     *
     * table egresos
     *
     * 
     */
    protected List<Criteria> oredCriteria;

    /**
     * 
     * table egresos
     *
     * 
     */
    public EgresoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 
     * table egresos
     *
     * 
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 
     * table egresos
     *
     * 
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 
     * table egresos
     *
     * 
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 
     * table egresos
     *
     * 
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 
     * table egresos
     *
     * 
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 
     * table egresos
     *
     * 
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 
     * table egresos
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
     * table egresos
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
     * table egresos
     *
     * 
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 
     * table egresos
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
     * egresos
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

        public Criteria andCodigoEgresoIsNull() {
            addCriterion("e.codigo_egreso is null");
            return (Criteria) this;
        }

        public Criteria andCodigoEgresoIsNotNull() {
            addCriterion("e.codigo_egreso is not null");
            return (Criteria) this;
        }

        public Criteria andCodigoEgresoEqualTo(Integer value) {
            addCriterion("e.codigo_egreso =", value, "codigoEgreso");
            return (Criteria) this;
        }

        public Criteria andCodigoEgresoNotEqualTo(Integer value) {
            addCriterion("e.codigo_egreso <>", value, "codigoEgreso");
            return (Criteria) this;
        }

        public Criteria andCodigoEgresoGreaterThan(Integer value) {
            addCriterion("e.codigo_egreso >", value, "codigoEgreso");
            return (Criteria) this;
        }

        public Criteria andCodigoEgresoGreaterThanOrEqualTo(Integer value) {
            addCriterion("e.codigo_egreso >=", value, "codigoEgreso");
            return (Criteria) this;
        }

        public Criteria andCodigoEgresoLessThan(Integer value) {
            addCriterion("e.codigo_egreso <", value, "codigoEgreso");
            return (Criteria) this;
        }

        public Criteria andCodigoEgresoLessThanOrEqualTo(Integer value) {
            addCriterion("e.codigo_egreso <=", value, "codigoEgreso");
            return (Criteria) this;
        }

        public Criteria andCodigoEgresoIn(List<Integer> values) {
            addCriterion("e.codigo_egreso in", values, "codigoEgreso");
            return (Criteria) this;
        }

        public Criteria andCodigoEgresoNotIn(List<Integer> values) {
            addCriterion("e.codigo_egreso not in", values, "codigoEgreso");
            return (Criteria) this;
        }

        public Criteria andCodigoEgresoBetween(Integer value1, Integer value2) {
            addCriterion("e.codigo_egreso between", value1, value2, "codigoEgreso");
            return (Criteria) this;
        }

        public Criteria andCodigoEgresoNotBetween(Integer value1, Integer value2) {
            addCriterion("e.codigo_egreso not between", value1, value2, "codigoEgreso");
            return (Criteria) this;
        }

        public Criteria andFechaEgresoIsNull() {
            addCriterion("e.fecha_egreso is null");
            return (Criteria) this;
        }

        public Criteria andFechaEgresoIsNotNull() {
            addCriterion("e.fecha_egreso is not null");
            return (Criteria) this;
        }

        public Criteria andFechaEgresoEqualTo(Date value) {
            addCriterionForJDBCDate("e.fecha_egreso =", value, "fechaEgreso");
            return (Criteria) this;
        }

        public Criteria andFechaEgresoNotEqualTo(Date value) {
            addCriterionForJDBCDate("e.fecha_egreso <>", value, "fechaEgreso");
            return (Criteria) this;
        }

        public Criteria andFechaEgresoGreaterThan(Date value) {
            addCriterionForJDBCDate("e.fecha_egreso >", value, "fechaEgreso");
            return (Criteria) this;
        }

        public Criteria andFechaEgresoGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("e.fecha_egreso >=", value, "fechaEgreso");
            return (Criteria) this;
        }

        public Criteria andFechaEgresoLessThan(Date value) {
            addCriterionForJDBCDate("e.fecha_egreso <", value, "fechaEgreso");
            return (Criteria) this;
        }

        public Criteria andFechaEgresoLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("e.fecha_egreso <=", value, "fechaEgreso");
            return (Criteria) this;
        }

        public Criteria andFechaEgresoIn(List<Date> values) {
            addCriterionForJDBCDate("e.fecha_egreso in", values, "fechaEgreso");
            return (Criteria) this;
        }

        public Criteria andFechaEgresoNotIn(List<Date> values) {
            addCriterionForJDBCDate("e.fecha_egreso not in", values, "fechaEgreso");
            return (Criteria) this;
        }

        public Criteria andFechaEgresoBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("e.fecha_egreso between", value1, value2, "fechaEgreso");
            return (Criteria) this;
        }

        public Criteria andFechaEgresoNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("e.fecha_egreso not between", value1, value2, "fechaEgreso");
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

        public Criteria andNroFacturaIsNull() {
            addCriterion("nro_factura is null");
            return (Criteria) this;
        }

        public Criteria andNroFacturaIsNotNull() {
            addCriterion("nro_factura is not null");
            return (Criteria) this;
        }

        public Criteria andNroFacturaEqualTo(Integer value) {
            addCriterion("nro_factura =", value, "nroFactura");
            return (Criteria) this;
        }

        public Criteria andNroFacturaNotEqualTo(Integer value) {
            addCriterion("nro_factura <>", value, "nroFactura");
            return (Criteria) this;
        }

        public Criteria andNroFacturaGreaterThan(Integer value) {
            addCriterion("nro_factura >", value, "nroFactura");
            return (Criteria) this;
        }

        public Criteria andNroFacturaGreaterThanOrEqualTo(Integer value) {
            addCriterion("nro_factura >=", value, "nroFactura");
            return (Criteria) this;
        }

        public Criteria andNroFacturaLessThan(Integer value) {
            addCriterion("nro_factura <", value, "nroFactura");
            return (Criteria) this;
        }

        public Criteria andNroFacturaLessThanOrEqualTo(Integer value) {
            addCriterion("nro_factura <=", value, "nroFactura");
            return (Criteria) this;
        }

        public Criteria andNroFacturaIn(List<Integer> values) {
            addCriterion("nro_factura in", values, "nroFactura");
            return (Criteria) this;
        }

        public Criteria andNroFacturaNotIn(List<Integer> values) {
            addCriterion("nro_factura not in", values, "nroFactura");
            return (Criteria) this;
        }

        public Criteria andNroFacturaBetween(Integer value1, Integer value2) {
            addCriterion("nro_factura between", value1, value2, "nroFactura");
            return (Criteria) this;
        }

        public Criteria andNroFacturaNotBetween(Integer value1, Integer value2) {
            addCriterion("nro_factura not between", value1, value2, "nroFactura");
            return (Criteria) this;
        }

        public Criteria andCodigo_proveedorIsNull() {
            addCriterion("codigo_proveedor is null");
            return (Criteria) this;
        }

        public Criteria andCodigo_proveedorIsNotNull() {
            addCriterion("codigo_proveedor is not null");
            return (Criteria) this;
        }

        public Criteria andCodigo_proveedorEqualTo(Integer value) {
            addCriterion("codigo_proveedor =", value, "codigo_proveedor");
            return (Criteria) this;
        }

        public Criteria andCodigo_proveedorNotEqualTo(Integer value) {
            addCriterion("codigo_proveedor <>", value, "codigo_proveedor");
            return (Criteria) this;
        }

        public Criteria andCodigo_proveedorGreaterThan(Integer value) {
            addCriterion("codigo_proveedor >", value, "codigo_proveedor");
            return (Criteria) this;
        }

        public Criteria andCodigo_proveedorGreaterThanOrEqualTo(Integer value) {
            addCriterion("codigo_proveedor >=", value, "codigo_proveedor");
            return (Criteria) this;
        }

        public Criteria andCodigo_proveedorLessThan(Integer value) {
            addCriterion("codigo_proveedor <", value, "codigo_proveedor");
            return (Criteria) this;
        }

        public Criteria andCodigo_proveedorLessThanOrEqualTo(Integer value) {
            addCriterion("codigo_proveedor <=", value, "codigo_proveedor");
            return (Criteria) this;
        }

        public Criteria andCodigo_proveedorIn(List<Integer> values) {
            addCriterion("codigo_proveedor in", values, "codigo_proveedor");
            return (Criteria) this;
        }

        public Criteria andCodigo_proveedorNotIn(List<Integer> values) {
            addCriterion("codigo_proveedor not in", values, "codigo_proveedor");
            return (Criteria) this;
        }

        public Criteria andCodigo_proveedorBetween(Integer value1, Integer value2) {
            addCriterion("codigo_proveedor between", value1, value2, "codigo_proveedor");
            return (Criteria) this;
        }

        public Criteria andCodigo_proveedorNotBetween(Integer value1, Integer value2) {
            addCriterion("codigo_proveedor not between", value1, value2, "codigo_proveedor");
            return (Criteria) this;
        }

        public Criteria andMontoSalidaIsNull() {
            addCriterion("monto_salida is null");
            return (Criteria) this;
        }

        public Criteria andMontoSalidaIsNotNull() {
            addCriterion("monto_salida is not null");
            return (Criteria) this;
        }

        public Criteria andMontoSalidaEqualTo(Double value) {
            addCriterion("monto_salida =", value, "montoSalida");
            return (Criteria) this;
        }

        public Criteria andMontoSalidaNotEqualTo(Double value) {
            addCriterion("monto_salida <>", value, "montoSalida");
            return (Criteria) this;
        }

        public Criteria andMontoSalidaGreaterThan(Double value) {
            addCriterion("monto_salida >", value, "montoSalida");
            return (Criteria) this;
        }

        public Criteria andMontoSalidaGreaterThanOrEqualTo(Double value) {
            addCriterion("monto_salida >=", value, "montoSalida");
            return (Criteria) this;
        }

        public Criteria andMontoSalidaLessThan(Double value) {
            addCriterion("monto_salida <", value, "montoSalida");
            return (Criteria) this;
        }

        public Criteria andMontoSalidaLessThanOrEqualTo(Double value) {
            addCriterion("monto_salida <=", value, "montoSalida");
            return (Criteria) this;
        }

        public Criteria andMontoSalidaIn(List<Double> values) {
            addCriterion("monto_salida in", values, "montoSalida");
            return (Criteria) this;
        }

        public Criteria andMontoSalidaNotIn(List<Double> values) {
            addCriterion("monto_salida not in", values, "montoSalida");
            return (Criteria) this;
        }

        public Criteria andMontoSalidaBetween(Double value1, Double value2) {
            addCriterion("monto_salida between", value1, value2, "montoSalida");
            return (Criteria) this;
        }

        public Criteria andMontoSalidaNotBetween(Double value1, Double value2) {
            addCriterion("monto_salida not between", value1, value2, "montoSalida");
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
     * egresos
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
     * egresos
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