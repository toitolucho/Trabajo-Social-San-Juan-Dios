CREATE OR REPLACE FUNCTION obtener_historial_consulta_detalle(
	numero_hc_aux	INT,
	fecha_inicio		DATE,
	fecha_fin		DATE
)
RETURNS SETOF RECORD
AS
$body$
DECLARE 
	registros2		RECORD;
BEGIN
	FOR registros2 IN 

		SELECT 
		  c.numero_consulta, 
		  c.numero_hc, 
		  c.motivo, 
		  c.fecha_consulta, 
		  c.diagnostico, 
		  c.observaciones, 
		  hc.grupo_sanguinio, 
		  hc.fecha_registro, 
		  p.paterno, 
		  p.materno, 
		  p.nombres, 
		  p.nombres || ' ' || p.paterno || ' ' || p.materno,
		  CASE WHEN p.sexo = 'M' THEN 'MASCULINO' ELSE 'FEMENINO' END as sexo, 
		  pdn.fecha_nacimiento, 
		  pdn.edad, 
		  hccd.fecha_registro, 
		  hccd.descripcion, 
		  pt.nombre_propiedad_tipo, 
		  phc.nombre_propiedad
		FROM 
		  public.consulta c, 
		  public.historia_clinico hc, 
		  public.personas p, 
		  public.personas_datos_nacimiento pdn, 
		  public.historia_clinico_consulta_detalle hccd, 
		  public.propiedades_historial_clinico phc, 
		  public.propiedades_tipos pt
		WHERE 
		  c.numero_hc = hc.numero_hc AND
		  c.numero_hc = hccd.numero_hc AND
		  hc.idpersona = p.codigo_persona AND
		  p.codigo_persona = pdn.codigo_persona AND
		  hccd.numero_propiedad_tipo = pt.numero_propiedad_tipo AND
		  hccd.numero_propiedad = phc.numero_propiedad
	LOOP
		RETURN next registros2;
	END LOOP;
	RETURN;
END;
$body$ LANGUAGE 'plpgsql' VOLATILE;


-- 
SELECT * FROM obtener_historial_consulta_detalle(1,null, null) 
AS 
(
  numero_consulta	INTEGER, 
  numero_hc		INTEGER,   
  motivo		CHARACTER VARYING(100), 
  fecha_consulta	DATE, 
  diagnostico		TEXT, 
  observaciones		TEXT, 
  grupo_sanguinio	CHARACTER VARYING(10), 
  fecha_registro	DATE,
  paterno		CHARACTER VARYING(40), 
  materno		CHARACTER VARYING(40), 
  nombres		CHARACTER VARYING(80),
  nombre_completo	TEXT,
  sexo			TEXT, 
  fecha_nacimiento	DATE, 
  edad			INT, 
  fecha_registro_detalle DATE, 
  descripcion		TEXT, 
  nombre_propiedad_tipo CHARACTER VARYING(200), 
  nombre_propiedad	CHARACTER VARYING(150)
)

-- 
-- SELECT 
--   c.numero_consulta, 
--   c.numero_hc, 
--   c.motivo, 
--   c.fecha_consulta, 
--   c.diagnostico, 
--   c.observaciones, 
--   hc.grupo_sanguinio, 
--   hc.fecha_registro, 
--   p.paterno, 
--   p.materno, 
--   p.nombres, 
--   p.nombres || ' ' || p.paterno || ' ' || p.materno,
--   CASE WHEN p.sexo = 'M' THEN 'MASCULINO' ELSE 'FEMENINO' END as sexo, 
--   pdn.fecha_nacimiento, 
--   pdn.edad,   
--   hccd.fecha_registro, 
--   hccd.descripcion, 
--   pt.nombre_propiedad_tipo, 
--   phc.nombre_propiedad
-- FROM 
--   public.consulta c, 
--   public.historia_clinico hc, 
--   public.personas p, 
--   public.personas_datos_nacimiento pdn, 
--   public.historia_clinico_consulta_detalle hccd, 
--   public.propiedades_historial_clinico phc, 
--   public.propiedades_tipos pt
-- WHERE 
--   c.numero_hc = hc.numero_hc AND
--   c.numero_hc = hccd.numero_hc AND
--   hc.idpersona = p.codigo_persona AND
--   p.codigo_persona = pdn.codigo_persona AND
--   hccd.numero_propiedad_tipo = pt.numero_propiedad_tipo AND
--   hccd.numero_propiedad = phc.numero_propiedad