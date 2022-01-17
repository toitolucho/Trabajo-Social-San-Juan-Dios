package org.quarkbit.trabajosocialsanjuan.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class PersonaExample {
    /**
     *
     * table personas
     *
     * 
     */
    protected String orderByClause;

    /**
     *
     * table personas
     *
     * 
     */
    protected boolean distinct;

    /**
     *
     * table personas
     *
     * 
     */
    protected List<Criteria> oredCriteria;

    /**
     * 
     * table personas
     *
     * 
     */
    public PersonaExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 
     * table personas
     *
     * 
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 
     * table personas
     *
     * 
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 
     * table personas
     *
     * 
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 
     * table personas
     *
     * 
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 
     * table personas
     *
     * 
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 
     * table personas
     *
     * 
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 
     * table personas
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
     * table personas
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
     * table personas
     *
     * 
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 
     * table personas
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
     * personas
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

        public Criteria andCodigoPersonaIsNull() {
            addCriterion("codigo_persona is null");
            return (Criteria) this;
        }

        public Criteria andCodigoPersonaIsNotNull() {
            addCriterion("codigo_persona is not null");
            return (Criteria) this;
        }

        public Criteria andCodigoPersonaEqualTo(Integer value) {
            addCriterion("codigo_persona =", value, "codigoPersona");
            return (Criteria) this;
        }

        public Criteria andCodigoPersonaNotEqualTo(Integer value) {
            addCriterion("codigo_persona <>", value, "codigoPersona");
            return (Criteria) this;
        }

        public Criteria andCodigoPersonaGreaterThan(Integer value) {
            addCriterion("codigo_persona >", value, "codigoPersona");
            return (Criteria) this;
        }

        public Criteria andCodigoPersonaGreaterThanOrEqualTo(Integer value) {
            addCriterion("codigo_persona >=", value, "codigoPersona");
            return (Criteria) this;
        }

        public Criteria andCodigoPersonaLessThan(Integer value) {
            addCriterion("codigo_persona <", value, "codigoPersona");
            return (Criteria) this;
        }

        public Criteria andCodigoPersonaLessThanOrEqualTo(Integer value) {
            addCriterion("codigo_persona <=", value, "codigoPersona");
            return (Criteria) this;
        }

        public Criteria andCodigoPersonaIn(List<Integer> values) {
            addCriterion("codigo_persona in", values, "codigoPersona");
            return (Criteria) this;
        }

        public Criteria andCodigoPersonaNotIn(List<Integer> values) {
            addCriterion("codigo_persona not in", values, "codigoPersona");
            return (Criteria) this;
        }

        public Criteria andCodigoPersonaBetween(Integer value1, Integer value2) {
            addCriterion("codigo_persona between", value1, value2, "codigoPersona");
            return (Criteria) this;
        }

        public Criteria andCodigoPersonaNotBetween(Integer value1, Integer value2) {
            addCriterion("codigo_persona not between", value1, value2, "codigoPersona");
            return (Criteria) this;
        }

        public Criteria andDiPersonaIsNull() {
            addCriterion("di_persona is null");
            return (Criteria) this;
        }

        public Criteria andDiPersonaIsNotNull() {
            addCriterion("di_persona is not null");
            return (Criteria) this;
        }

        public Criteria andDiPersonaEqualTo(String value) {
            addCriterion("di_persona =", value, "diPersona");
            return (Criteria) this;
        }

        public Criteria andDiPersonaNotEqualTo(String value) {
            addCriterion("di_persona <>", value, "diPersona");
            return (Criteria) this;
        }

        public Criteria andDiPersonaGreaterThan(String value) {
            addCriterion("di_persona >", value, "diPersona");
            return (Criteria) this;
        }

        public Criteria andDiPersonaGreaterThanOrEqualTo(String value) {
            addCriterion("di_persona >=", value, "diPersona");
            return (Criteria) this;
        }

        public Criteria andDiPersonaLessThan(String value) {
            addCriterion("di_persona <", value, "diPersona");
            return (Criteria) this;
        }

        public Criteria andDiPersonaLessThanOrEqualTo(String value) {
            addCriterion("di_persona <=", value, "diPersona");
            return (Criteria) this;
        }

        public Criteria andDiPersonaLike(String value) {
            addCriterion("di_persona like", value, "diPersona");
            return (Criteria) this;
        }

        public Criteria andDiPersonaNotLike(String value) {
            addCriterion("di_persona not like", value, "diPersona");
            return (Criteria) this;
        }

        public Criteria andDiPersonaIn(List<String> values) {
            addCriterion("di_persona in", values, "diPersona");
            return (Criteria) this;
        }

        public Criteria andDiPersonaNotIn(List<String> values) {
            addCriterion("di_persona not in", values, "diPersona");
            return (Criteria) this;
        }

        public Criteria andDiPersonaBetween(String value1, String value2) {
            addCriterion("di_persona between", value1, value2, "diPersona");
            return (Criteria) this;
        }

        public Criteria andDiPersonaNotBetween(String value1, String value2) {
            addCriterion("di_persona not between", value1, value2, "diPersona");
            return (Criteria) this;
        }

        public Criteria andPaternoIsNull() {
            addCriterion("paterno is null");
            return (Criteria) this;
        }

        public Criteria andPaternoIsNotNull() {
            addCriterion("paterno is not null");
            return (Criteria) this;
        }

        public Criteria andPaternoEqualTo(String value) {
            addCriterion("paterno =", value, "paterno");
            return (Criteria) this;
        }

        public Criteria andPaternoNotEqualTo(String value) {
            addCriterion("paterno <>", value, "paterno");
            return (Criteria) this;
        }

        public Criteria andPaternoGreaterThan(String value) {
            addCriterion("paterno >", value, "paterno");
            return (Criteria) this;
        }

        public Criteria andPaternoGreaterThanOrEqualTo(String value) {
            addCriterion("paterno >=", value, "paterno");
            return (Criteria) this;
        }

        public Criteria andPaternoLessThan(String value) {
            addCriterion("paterno <", value, "paterno");
            return (Criteria) this;
        }

        public Criteria andPaternoLessThanOrEqualTo(String value) {
            addCriterion("paterno <=", value, "paterno");
            return (Criteria) this;
        }

        public Criteria andPaternoLike(String value) {
            addCriterion("upper(paterno) like", value.toUpperCase(), "paterno");
            return (Criteria) this;
        }

        public Criteria andPaternoNotLike(String value) {
            addCriterion("paterno not like", value, "paterno");
            return (Criteria) this;
        }

        public Criteria andPaternoIn(List<String> values) {
            addCriterion("paterno in", values, "paterno");
            return (Criteria) this;
        }

        public Criteria andPaternoNotIn(List<String> values) {
            addCriterion("paterno not in", values, "paterno");
            return (Criteria) this;
        }

        public Criteria andPaternoBetween(String value1, String value2) {
            addCriterion("paterno between", value1, value2, "paterno");
            return (Criteria) this;
        }

        public Criteria andPaternoNotBetween(String value1, String value2) {
            addCriterion("paterno not between", value1, value2, "paterno");
            return (Criteria) this;
        }

        public Criteria andMaternoIsNull() {
            addCriterion("materno is null");
            return (Criteria) this;
        }

        public Criteria andMaternoIsNotNull() {
            addCriterion("materno is not null");
            return (Criteria) this;
        }

        public Criteria andMaternoEqualTo(String value) {
            addCriterion("materno =", value, "materno");
            return (Criteria) this;
        }

        public Criteria andMaternoNotEqualTo(String value) {
            addCriterion("materno <>", value, "materno");
            return (Criteria) this;
        }

        public Criteria andMaternoGreaterThan(String value) {
            addCriterion("materno >", value, "materno");
            return (Criteria) this;
        }

        public Criteria andMaternoGreaterThanOrEqualTo(String value) {
            addCriterion("materno >=", value, "materno");
            return (Criteria) this;
        }

        public Criteria andMaternoLessThan(String value) {
            addCriterion("materno <", value, "materno");
            return (Criteria) this;
        }

        public Criteria andMaternoLessThanOrEqualTo(String value) {
            addCriterion("materno <=", value, "materno");
            return (Criteria) this;
        }

        public Criteria andMaternoLike(String value) {
            addCriterion("upper(materno) like", value.toUpperCase(), "materno");
            return (Criteria) this;
        }

        public Criteria andMaternoNotLike(String value) {
            addCriterion("materno not like", value, "materno");
            return (Criteria) this;
        }

        public Criteria andMaternoIn(List<String> values) {
            addCriterion("materno in", values, "materno");
            return (Criteria) this;
        }

        public Criteria andMaternoNotIn(List<String> values) {
            addCriterion("materno not in", values, "materno");
            return (Criteria) this;
        }

        public Criteria andMaternoBetween(String value1, String value2) {
            addCriterion("materno between", value1, value2, "materno");
            return (Criteria) this;
        }

        public Criteria andMaternoNotBetween(String value1, String value2) {
            addCriterion("materno not between", value1, value2, "materno");
            return (Criteria) this;
        }

        public Criteria andNombresIsNull() {
            addCriterion("nombres is null");
            return (Criteria) this;
        }

        public Criteria andNombresIsNotNull() {
            addCriterion("nombres is not null");
            return (Criteria) this;
        }

        public Criteria andNombresEqualTo(String value) {
            addCriterion("nombres =", value, "nombres");
            return (Criteria) this;
        }

        public Criteria andNombresNotEqualTo(String value) {
            addCriterion("nombres <>", value, "nombres");
            return (Criteria) this;
        }

        public Criteria andNombresGreaterThan(String value) {
            addCriterion("nombres >", value, "nombres");
            return (Criteria) this;
        }

        public Criteria andNombresGreaterThanOrEqualTo(String value) {
            addCriterion("nombres >=", value, "nombres");
            return (Criteria) this;
        }

        public Criteria andNombresLessThan(String value) {
            addCriterion("nombres <", value, "nombres");
            return (Criteria) this;
        }

        public Criteria andNombresLessThanOrEqualTo(String value) {
            addCriterion("nombres <=", value, "nombres");
            return (Criteria) this;
        }

        public Criteria andNombresLike(String value) {
            addCriterion("upper(nombres) like", value.toUpperCase(), "nombres");
            return (Criteria) this;
        }

        public Criteria andNombresNotLike(String value) {
            addCriterion("nombres not like", value, "nombres");
            return (Criteria) this;
        }

        public Criteria andNombresIn(List<String> values) {
            addCriterion("nombres in", values, "nombres");
            return (Criteria) this;
        }

        public Criteria andNombresNotIn(List<String> values) {
            addCriterion("nombres not in", values, "nombres");
            return (Criteria) this;
        }

        public Criteria andNombresBetween(String value1, String value2) {
            addCriterion("nombres between", value1, value2, "nombres");
            return (Criteria) this;
        }

        public Criteria andNombresNotBetween(String value1, String value2) {
            addCriterion("nombres not between", value1, value2, "nombres");
            return (Criteria) this;
        }

        public Criteria andCodigoTipoPersonaIsNull() {
            addCriterion("codigo_tipo_persona is null");
            return (Criteria) this;
        }

        public Criteria andCodigoTipoPersonaIsNotNull() {
            addCriterion("codigo_tipo_persona is not null");
            return (Criteria) this;
        }

        public Criteria andCodigoTipoPersonaEqualTo(String value) {
            addCriterion("codigo_tipo_persona =", value, "codigoTipoPersona");
            return (Criteria) this;
        }

        public Criteria andCodigoTipoPersonaNotEqualTo(String value) {
            addCriterion("codigo_tipo_persona <>", value, "codigoTipoPersona");
            return (Criteria) this;
        }

        public Criteria andCodigoTipoPersonaGreaterThan(String value) {
            addCriterion("codigo_tipo_persona >", value, "codigoTipoPersona");
            return (Criteria) this;
        }

        public Criteria andCodigoTipoPersonaGreaterThanOrEqualTo(String value) {
            addCriterion("codigo_tipo_persona >=", value, "codigoTipoPersona");
            return (Criteria) this;
        }

        public Criteria andCodigoTipoPersonaLessThan(String value) {
            addCriterion("codigo_tipo_persona <", value, "codigoTipoPersona");
            return (Criteria) this;
        }

        public Criteria andCodigoTipoPersonaLessThanOrEqualTo(String value) {
            addCriterion("codigo_tipo_persona <=", value, "codigoTipoPersona");
            return (Criteria) this;
        }

        public Criteria andCodigoTipoPersonaLike(String value) {
            addCriterion("codigo_tipo_persona like", value, "codigoTipoPersona");
            return (Criteria) this;
        }

        public Criteria andCodigoTipoPersonaNotLike(String value) {
            addCriterion("codigo_tipo_persona not like", value, "codigoTipoPersona");
            return (Criteria) this;
        }

        public Criteria andCodigoTipoPersonaIn(List<String> values) {
            addCriterion("codigo_tipo_persona in", values, "codigoTipoPersona");
            return (Criteria) this;
        }

        public Criteria andCodigoTipoPersonaNotIn(List<String> values) {
            addCriterion("codigo_tipo_persona not in", values, "codigoTipoPersona");
            return (Criteria) this;
        }

        public Criteria andCodigoTipoPersonaBetween(String value1, String value2) {
            addCriterion("codigo_tipo_persona between", value1, value2, "codigoTipoPersona");
            return (Criteria) this;
        }

        public Criteria andCodigoTipoPersonaNotBetween(String value1, String value2) {
            addCriterion("codigo_tipo_persona not between", value1, value2, "codigoTipoPersona");
            return (Criteria) this;
        }

        public Criteria andCodigoEmpleoIsNull() {
            addCriterion("p.codigo_empleo is null");
            return (Criteria) this;
        }

        public Criteria andCodigoEmpleoIsNotNull() {
            addCriterion("p.codigo_empleo is not null");
            return (Criteria) this;
        }

        public Criteria andCodigoEmpleoEqualTo(Integer value) {
            addCriterion("p.codigo_empleo =", value, "codigoEmpleo");
            return (Criteria) this;
        }

        public Criteria andCodigoEmpleoNotEqualTo(Integer value) {
            addCriterion("p.codigo_empleo <>", value, "codigoEmpleo");
            return (Criteria) this;
        }

        public Criteria andCodigoEmpleoGreaterThan(Integer value) {
            addCriterion("p.codigo_empleo >", value, "codigoEmpleo");
            return (Criteria) this;
        }

        public Criteria andCodigoEmpleoGreaterThanOrEqualTo(Integer value) {
            addCriterion("p.codigo_empleo >=", value, "codigoEmpleo");
            return (Criteria) this;
        }

        public Criteria andCodigoEmpleoLessThan(Integer value) {
            addCriterion("p.codigo_empleo <", value, "codigoEmpleo");
            return (Criteria) this;
        }

        public Criteria andCodigoEmpleoLessThanOrEqualTo(Integer value) {
            addCriterion("p.codigo_empleo <=", value, "codigoEmpleo");
            return (Criteria) this;
        }

        public Criteria andCodigoEmpleoIn(List<Integer> values) {
            addCriterion("p.codigo_empleo in", values, "codigoEmpleo");
            return (Criteria) this;
        }

        public Criteria andCodigoEmpleoNotIn(List<Integer> values) {
            addCriterion("p.codigo_empleo not in", values, "codigoEmpleo");
            return (Criteria) this;
        }

        public Criteria andCodigoEmpleoBetween(Integer value1, Integer value2) {
            addCriterion("p.codigo_empleo between", value1, value2, "codigoEmpleo");
            return (Criteria) this;
        }

        public Criteria andCodigoEmpleoNotBetween(Integer value1, Integer value2) {
            addCriterion("p.codigo_empleo not between", value1, value2, "codigoEmpleo");
            return (Criteria) this;
        }

        public Criteria andGradoInstruccionIsNull() {
            addCriterion("grado_instruccion is null");
            return (Criteria) this;
        }

        public Criteria andGradoInstruccionIsNotNull() {
            addCriterion("grado_instruccion is not null");
            return (Criteria) this;
        }

        public Criteria andGradoInstruccionEqualTo(String value) {
            addCriterion("grado_instruccion =", value, "gradoInstruccion");
            return (Criteria) this;
        }

        public Criteria andGradoInstruccionNotEqualTo(String value) {
            addCriterion("grado_instruccion <>", value, "gradoInstruccion");
            return (Criteria) this;
        }

        public Criteria andGradoInstruccionGreaterThan(String value) {
            addCriterion("grado_instruccion >", value, "gradoInstruccion");
            return (Criteria) this;
        }

        public Criteria andGradoInstruccionGreaterThanOrEqualTo(String value) {
            addCriterion("grado_instruccion >=", value, "gradoInstruccion");
            return (Criteria) this;
        }

        public Criteria andGradoInstruccionLessThan(String value) {
            addCriterion("grado_instruccion <", value, "gradoInstruccion");
            return (Criteria) this;
        }

        public Criteria andGradoInstruccionLessThanOrEqualTo(String value) {
            addCriterion("grado_instruccion <=", value, "gradoInstruccion");
            return (Criteria) this;
        }

        public Criteria andGradoInstruccionLike(String value) {
            addCriterion("grado_instruccion like", value, "gradoInstruccion");
            return (Criteria) this;
        }

        public Criteria andGradoInstruccionNotLike(String value) {
            addCriterion("grado_instruccion not like", value, "gradoInstruccion");
            return (Criteria) this;
        }

        public Criteria andGradoInstruccionIn(List<String> values) {
            addCriterion("grado_instruccion in", values, "gradoInstruccion");
            return (Criteria) this;
        }

        public Criteria andGradoInstruccionNotIn(List<String> values) {
            addCriterion("grado_instruccion not in", values, "gradoInstruccion");
            return (Criteria) this;
        }

        public Criteria andGradoInstruccionBetween(String value1, String value2) {
            addCriterion("grado_instruccion between", value1, value2, "gradoInstruccion");
            return (Criteria) this;
        }

        public Criteria andGradoInstruccionNotBetween(String value1, String value2) {
            addCriterion("grado_instruccion not between", value1, value2, "gradoInstruccion");
            return (Criteria) this;
        }

        public Criteria andSexoIsNull() {
            addCriterion("sexo is null");
            return (Criteria) this;
        }

        public Criteria andSexoIsNotNull() {
            addCriterion("sexo is not null");
            return (Criteria) this;
        }

        public Criteria andSexoEqualTo(String value) {
            addCriterion("sexo =", value, "sexo");
            return (Criteria) this;
        }

        public Criteria andSexoNotEqualTo(String value) {
            addCriterion("sexo <>", value, "sexo");
            return (Criteria) this;
        }

        public Criteria andSexoGreaterThan(String value) {
            addCriterion("sexo >", value, "sexo");
            return (Criteria) this;
        }

        public Criteria andSexoGreaterThanOrEqualTo(String value) {
            addCriterion("sexo >=", value, "sexo");
            return (Criteria) this;
        }

        public Criteria andSexoLessThan(String value) {
            addCriterion("sexo <", value, "sexo");
            return (Criteria) this;
        }

        public Criteria andSexoLessThanOrEqualTo(String value) {
            addCriterion("sexo <=", value, "sexo");
            return (Criteria) this;
        }

        public Criteria andSexoLike(String value) {
            addCriterion("sexo like", value, "sexo");
            return (Criteria) this;
        }

        public Criteria andSexoNotLike(String value) {
            addCriterion("sexo not like", value, "sexo");
            return (Criteria) this;
        }

        public Criteria andSexoIn(List<String> values) {
            addCriterion("sexo in", values, "sexo");
            return (Criteria) this;
        }

        public Criteria andSexoNotIn(List<String> values) {
            addCriterion("sexo not in", values, "sexo");
            return (Criteria) this;
        }

        public Criteria andSexoBetween(String value1, String value2) {
            addCriterion("sexo between", value1, value2, "sexo");
            return (Criteria) this;
        }

        public Criteria andSexoNotBetween(String value1, String value2) {
            addCriterion("sexo not between", value1, value2, "sexo");
            return (Criteria) this;
        }

        public Criteria andEstadoCivilIsNull() {
            addCriterion("estado_civil is null");
            return (Criteria) this;
        }

        public Criteria andEstadoCivilIsNotNull() {
            addCriterion("estado_civil is not null");
            return (Criteria) this;
        }

        public Criteria andEstadoCivilEqualTo(String value) {
            addCriterion("estado_civil =", value, "estadoCivil");
            return (Criteria) this;
        }

        public Criteria andEstadoCivilNotEqualTo(String value) {
            addCriterion("estado_civil <>", value, "estadoCivil");
            return (Criteria) this;
        }

        public Criteria andEstadoCivilGreaterThan(String value) {
            addCriterion("estado_civil >", value, "estadoCivil");
            return (Criteria) this;
        }

        public Criteria andEstadoCivilGreaterThanOrEqualTo(String value) {
            addCriterion("estado_civil >=", value, "estadoCivil");
            return (Criteria) this;
        }

        public Criteria andEstadoCivilLessThan(String value) {
            addCriterion("estado_civil <", value, "estadoCivil");
            return (Criteria) this;
        }

        public Criteria andEstadoCivilLessThanOrEqualTo(String value) {
            addCriterion("estado_civil <=", value, "estadoCivil");
            return (Criteria) this;
        }

        public Criteria andEstadoCivilLike(String value) {
            addCriterion("estado_civil like", value, "estadoCivil");
            return (Criteria) this;
        }

        public Criteria andEstadoCivilNotLike(String value) {
            addCriterion("estado_civil not like", value, "estadoCivil");
            return (Criteria) this;
        }

        public Criteria andEstadoCivilIn(List<String> values) {
            addCriterion("estado_civil in", values, "estadoCivil");
            return (Criteria) this;
        }

        public Criteria andEstadoCivilNotIn(List<String> values) {
            addCriterion("estado_civil not in", values, "estadoCivil");
            return (Criteria) this;
        }

        public Criteria andEstadoCivilBetween(String value1, String value2) {
            addCriterion("estado_civil between", value1, value2, "estadoCivil");
            return (Criteria) this;
        }

        public Criteria andEstadoCivilNotBetween(String value1, String value2) {
            addCriterion("estado_civil not between", value1, value2, "estadoCivil");
            return (Criteria) this;
        }

        public Criteria andCelularIsNull() {
            addCriterion("celular is null");
            return (Criteria) this;
        }

        public Criteria andCelularIsNotNull() {
            addCriterion("celular is not null");
            return (Criteria) this;
        }

        public Criteria andCelularEqualTo(String value) {
            addCriterion("celular =", value, "celular");
            return (Criteria) this;
        }

        public Criteria andCelularNotEqualTo(String value) {
            addCriterion("celular <>", value, "celular");
            return (Criteria) this;
        }

        public Criteria andCelularGreaterThan(String value) {
            addCriterion("celular >", value, "celular");
            return (Criteria) this;
        }

        public Criteria andCelularGreaterThanOrEqualTo(String value) {
            addCriterion("celular >=", value, "celular");
            return (Criteria) this;
        }

        public Criteria andCelularLessThan(String value) {
            addCriterion("celular <", value, "celular");
            return (Criteria) this;
        }

        public Criteria andCelularLessThanOrEqualTo(String value) {
            addCriterion("celular <=", value, "celular");
            return (Criteria) this;
        }

        public Criteria andCelularLike(String value) {
            addCriterion("celular like", value, "celular");
            return (Criteria) this;
        }

        public Criteria andCelularNotLike(String value) {
            addCriterion("celular not like", value, "celular");
            return (Criteria) this;
        }

        public Criteria andCelularIn(List<String> values) {
            addCriterion("celular in", values, "celular");
            return (Criteria) this;
        }

        public Criteria andCelularNotIn(List<String> values) {
            addCriterion("celular not in", values, "celular");
            return (Criteria) this;
        }

        public Criteria andCelularBetween(String value1, String value2) {
            addCriterion("celular between", value1, value2, "celular");
            return (Criteria) this;
        }

        public Criteria andCelularNotBetween(String value1, String value2) {
            addCriterion("celular not between", value1, value2, "celular");
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
            addCriterion("telefono =", value, "telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoNotEqualTo(String value) {
            addCriterion("telefono <>", value, "telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoGreaterThan(String value) {
            addCriterion("telefono >", value, "telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoGreaterThanOrEqualTo(String value) {
            addCriterion("telefono >=", value, "telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoLessThan(String value) {
            addCriterion("telefono <", value, "telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoLessThanOrEqualTo(String value) {
            addCriterion("telefono <=", value, "telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoLike(String value) {
            addCriterion("telefono like", value, "telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoNotLike(String value) {
            addCriterion("telefono not like", value, "telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoIn(List<String> values) {
            addCriterion("telefono in", values, "telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoNotIn(List<String> values) {
            addCriterion("telefono not in", values, "telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoBetween(String value1, String value2) {
            addCriterion("telefono between", value1, value2, "telefono");
            return (Criteria) this;
        }

        public Criteria andTelefonoNotBetween(String value1, String value2) {
            addCriterion("telefono not between", value1, value2, "telefono");
            return (Criteria) this;
        }

        public Criteria andDomicilioIsNull() {
            addCriterion("domicilio is null");
            return (Criteria) this;
        }

        public Criteria andDomicilioIsNotNull() {
            addCriterion("domicilio is not null");
            return (Criteria) this;
        }

        public Criteria andDomicilioEqualTo(String value) {
            addCriterion("domicilio =", value, "domicilio");
            return (Criteria) this;
        }

        public Criteria andDomicilioNotEqualTo(String value) {
            addCriterion("domicilio <>", value, "domicilio");
            return (Criteria) this;
        }

        public Criteria andDomicilioGreaterThan(String value) {
            addCriterion("domicilio >", value, "domicilio");
            return (Criteria) this;
        }

        public Criteria andDomicilioGreaterThanOrEqualTo(String value) {
            addCriterion("domicilio >=", value, "domicilio");
            return (Criteria) this;
        }

        public Criteria andDomicilioLessThan(String value) {
            addCriterion("domicilio <", value, "domicilio");
            return (Criteria) this;
        }

        public Criteria andDomicilioLessThanOrEqualTo(String value) {
            addCriterion("domicilio <=", value, "domicilio");
            return (Criteria) this;
        }

        public Criteria andDomicilioLike(String value) {
            addCriterion("domicilio like", value, "domicilio");
            return (Criteria) this;
        }

        public Criteria andDomicilioNotLike(String value) {
            addCriterion("domicilio not like", value, "domicilio");
            return (Criteria) this;
        }

        public Criteria andDomicilioIn(List<String> values) {
            addCriterion("domicilio in", values, "domicilio");
            return (Criteria) this;
        }

        public Criteria andDomicilioNotIn(List<String> values) {
            addCriterion("domicilio not in", values, "domicilio");
            return (Criteria) this;
        }

        public Criteria andDomicilioBetween(String value1, String value2) {
            addCriterion("domicilio between", value1, value2, "domicilio");
            return (Criteria) this;
        }

        public Criteria andDomicilioNotBetween(String value1, String value2) {
            addCriterion("domicilio not between", value1, value2, "domicilio");
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
     * personas
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
     * personas
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