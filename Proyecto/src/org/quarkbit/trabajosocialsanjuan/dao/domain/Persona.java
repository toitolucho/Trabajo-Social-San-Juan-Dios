package org.quarkbit.trabajosocialsanjuan.dao.domain;

public class Persona {
    /**
     *
     * column personas.codigo_persona
     *
     * 
     */
    private Integer codigoPersona;

    /**
     *
     * column personas.di_persona
     *
     * 
     */
    private String diPersona;

    /**
     *
     * column personas.paterno
     *
     * 
     */
    private String paterno;

    /**
     *
     * column personas.materno
     *
     * 
     */
    private String materno;

    /**
     *
     * column personas.nombres
     *
     * 
     */
    private String nombres;

    /**
     *
     * column personas.codigo_tipo_persona
     *
     * 
     */
    private String codigoTipoPersona;

    /**
     *
     * column personas.codigo_empleo
     *
     * 
     */
    private Integer codigoEmpleo;

    /**
     *
     * column personas.grado_instruccion
     *
     * 
     */
    private String gradoInstruccion;

    /**
     *
     * column personas.sexo
     *
     * 
     */
    private String sexo;

    /**
     *
     * column personas.estado_civil
     *
     * 
     */
    private String estadoCivil;

    /**
     *
     * column personas.celular
     *
     * 
     */
    private String celular;

    /**
     *
     * column personas.telefono
     *
     * 
     */
    private String telefono;

    /**
     *
     * column personas.domicilio
     *
     * 
     */
    private String domicilio;

    /**
     *
     * column personas.observaciones
     *
     * 
     */
    private String observaciones;

    private Empleo empleo;
    /**
     * 
     *column personas.codigo_persona
     *
     * @return the value of personas.codigo_persona
     *
     * 
     */
    public Integer getCodigoPersona() {
        return codigoPersona;
    }

    /**
     * 
     *  column personas.codigo_persona
     *
     * @param codigoPersona the value for personas.codigo_persona
     *
     * 
     */
    public void setCodigoPersona(Integer codigoPersona) {
        this.codigoPersona = codigoPersona;
    }

    /**
     * 
     *column personas.di_persona
     *
     * @return the value of personas.di_persona
     *
     * 
     */
    public String getDiPersona() {
        return diPersona;
    }

    /**
     * 
     *  column personas.di_persona
     *
     * @param diPersona the value for personas.di_persona
     *
     * 
     */
    public void setDiPersona(String diPersona) {
        this.diPersona = diPersona == null ? null : diPersona.trim();
    }

    /**
     * 
     *column personas.paterno
     *
     * @return the value of personas.paterno
     *
     * 
     */
    public String getPaterno() {
        return paterno;
    }

    /**
     * 
     *  column personas.paterno
     *
     * @param paterno the value for personas.paterno
     *
     * 
     */
    public void setPaterno(String paterno) {
        this.paterno = paterno == null ? null : paterno.trim();
    }

    /**
     * 
     *column personas.materno
     *
     * @return the value of personas.materno
     *
     * 
     */
    public String getMaterno() {
        return materno;
    }

    /**
     * 
     *  column personas.materno
     *
     * @param materno the value for personas.materno
     *
     * 
     */
    public void setMaterno(String materno) {
        this.materno = materno == null ? null : materno.trim();
    }

    /**
     * 
     *column personas.nombres
     *
     * @return the value of personas.nombres
     *
     * 
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * 
     *  column personas.nombres
     *
     * @param nombres the value for personas.nombres
     *
     * 
     */
    public void setNombres(String nombres) {
        this.nombres = nombres == null ? null : nombres.trim();
    }

    /**
     * 
     *column personas.codigo_tipo_persona
     *
     * @return the value of personas.codigo_tipo_persona
     *
     * 
     */
    public String getCodigoTipoPersona() {
        return codigoTipoPersona;
    }

    /**
     * 
     *  column personas.codigo_tipo_persona
     *
     * @param codigoTipoPersona the value for personas.codigo_tipo_persona
     *
     * 
     */
    public void setCodigoTipoPersona(String codigoTipoPersona) {
        this.codigoTipoPersona = codigoTipoPersona == null ? null : codigoTipoPersona.trim();
    }

    /**
     * 
     *column personas.codigo_empleo
     *
     * @return the value of personas.codigo_empleo
     *
     * 
     */
    public Integer getCodigoEmpleo() {
        return codigoEmpleo;
    }

    /**
     * 
     *  column personas.codigo_empleo
     *
     * @param codigoEmpleo the value for personas.codigo_empleo
     *
     * 
     */
    public void setCodigoEmpleo(Integer codigoEmpleo) {
        this.codigoEmpleo = codigoEmpleo;
    }

    /**
     * 
     *column personas.grado_instruccion
     *
     * @return the value of personas.grado_instruccion
     *
     * 
     */
    public String getGradoInstruccion() {
        return gradoInstruccion;
    }

    /**
     * 
     *  column personas.grado_instruccion
     *
     * @param gradoInstruccion the value for personas.grado_instruccion
     *
     * 
     */
    public void setGradoInstruccion(String gradoInstruccion) {
        this.gradoInstruccion = gradoInstruccion == null ? null : gradoInstruccion.trim();
    }

    /**
     * 
     *column personas.sexo
     *
     * @return the value of personas.sexo
     *
     * 
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * 
     *  column personas.sexo
     *
     * @param sexo the value for personas.sexo
     *
     * 
     */
    public void setSexo(String sexo) {
        this.sexo = sexo == null ? null : sexo.trim();
    }

    /**
     * 
     *column personas.estado_civil
     *
     * @return the value of personas.estado_civil
     *
     * 
     */
    public String getEstadoCivil() {
        return estadoCivil;
    }

    /**
     * 
     *  column personas.estado_civil
     *
     * @param estadoCivil the value for personas.estado_civil
     *
     * 
     */
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil == null ? null : estadoCivil.trim();
    }

    /**
     * 
     *column personas.celular
     *
     * @return the value of personas.celular
     *
     * 
     */
    public String getCelular() {
        return celular;
    }

    /**
     * 
     *  column personas.celular
     *
     * @param celular the value for personas.celular
     *
     * 
     */
    public void setCelular(String celular) {
        this.celular = celular == null ? null : celular.trim();
    }

    /**
     * 
     *column personas.telefono
     *
     * @return the value of personas.telefono
     *
     * 
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * 
     *  column personas.telefono
     *
     * @param telefono the value for personas.telefono
     *
     * 
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono == null ? null : telefono.trim();
    }

    /**
     * 
     *column personas.domicilio
     *
     * @return the value of personas.domicilio
     *
     * 
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * 
     *  column personas.domicilio
     *
     * @param domicilio the value for personas.domicilio
     *
     * 
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio == null ? null : domicilio.trim();
    }

    /**
     * 
     *column personas.observaciones
     *
     * @return the value of personas.observaciones
     *
     * 
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * 
     *  column personas.observaciones
     *
     * @param observaciones the value for personas.observaciones
     *
     * 
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones == null ? null : observaciones.trim();
    }
    
    
    public String obtenerNombreCompleto()
    {    	
    	return nombres + " " + ( paterno != null ?  paterno : "") + " " +( materno != null ?  materno : "");
    }

	public Empleo getEmpleo() {
		return empleo;
	}

	public void setEmpleo(Empleo empleo) {
		this.empleo = empleo;
	}
    
	//"NINGUNO", "ANALFABETO", "PRIMARIO", "SECUNDARIO", "UNIVERSITARIO", "TECNICO SUPERIOR", "SUPERIOR "
	public String getInstruccion()
	{
		//'N'->NINGUNO, 'A'->ANALFABETO, 'P'->PRIMARIO, 'S'->SECUNDARIO, 'U'->UNIVERSITARIO, 'T'->TECNICO SUPERIOR, 'R'->SUPERIOR
		switch (gradoInstruccion) {
		case "N":
			return "NINGUNO";
		case "A":
			return "ANALFABETO";	
		case "P":
			return "PRIMARIO";
		case "S":
			return "SECUNDARIO";
		case "U":
			return "UNIVERSITARIO";
		case "T":
			return "TECNICO SUPERIOR";
		case "R":
			return "SUPERIOR";
		default:
			return "";
			
		}
	}
    
	public void setInstruccion(String gradoItem)
	{
		switch (gradoItem) {
		case "NINGUNO":
			gradoInstruccion =  "N";
			break;
		case "ANALFABERO":
			gradoInstruccion =  "A";
			break;
		case "PRIMARIO":
			gradoInstruccion =  "P";
			break;
		case "SECUNDARIO":
			gradoInstruccion = "S";
			break;
		case "UNIVERSITARIO":
			gradoInstruccion = "U";
		case "TECNICO SUPERIOR":
			gradoInstruccion = "T";
			break;
		case "SUPERIOR":
			gradoInstruccion = "R";
			break;
		default:
			gradoInstruccion = "N";
			break;
			
		}
	}
	
	
	
	public String getEstCivil()
	{
		//'N'->NINGUNO, 'A'->ANALFABETO, 'P'->PRIMARIO, 'S'->SECUNDARIO, 'U'->UNIVERSITARIO, 'T'->TECNICO SUPERIOR, 'R'->SUPERIOR
		switch (estadoCivil) {
		case "S":
			return "SOLTERO(A)";
		case "C":
			return "CASADO(A)";	
		case "D":
			return "DIVORCIADO(A)";
		case "V":
			return "VIUDO(A)";
		
		default:
			return "";
			
		}
	}
    
	public void setEstCivil(String gradoItem)
	{
		switch (gradoItem) {
		case "SOLTERO(A)":
			estadoCivil =  "S";
			break;
		case "CASADO(A)":
			estadoCivil =  "C";
			break;
		case "DIVORCIADO(A)":
			estadoCivil =  "D";
			break;
		case "VIUDO(A)":
			estadoCivil = "V";
			break;
		
		default:
			estadoCivil = "S";
			break;
			
		}
	}

	@Override
	public String toString() {
		return obtenerNombreCompleto();
	}
	
	
}