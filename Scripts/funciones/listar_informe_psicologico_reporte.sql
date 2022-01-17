CREATE OR REPLACE FUNCTION listar_informe_psicologico_reporte(
	codigo_informe_psico_aux	INT
)
RETURNS SETOF RECORD
AS
$body$
DECLARE 
	registros2		RECORD;
BEGIN
	FOR registros2 IN 
		SELECT 
		  ip.codigo_informe_psico, 
		  ip.codigo_kardex, 
		  ip.motivo_consulta, 
		  ip.fecha_evaluacion, 
		  ip.codigo_persona_evalua, 
		  ip.instrumentos,
		  ip.antecedentes, 
		  ip.aspectos_relevantes, 
		  ip.conductas_observadas, 
		  ip.res_motricidad_gruesa, 
		  ip.res_motricidad_fino, 
		  ip.res_audicion_lenguaje, 
		  ip.res_personal_social, 
		  ip.res_total, 
		  ip.diagnostico, 
		  ip.recomendaciones, 
		  pk.numero_kardex, 
		  pk.fecha_ingreso, 
		  pk.motivo_ingreso, 
		  p.di_persona, 
		  p.paterno, 
		  p.materno, 
		  p.nombres, 
		  p.nombres || ' ' || p.paterno || ' ' || p.materno as nombre_completo_nino,
		  CASE p.sexo WHEN 'F' THEN 'FEMENINO' ELSE 'MASCULINO' END AS sexo, 
		  pdn.fecha_nacimiento, 
		  pdn.edad, 
		  de.codigo_pais, 
		  de.nombre_departamento, 
		  pa.nombre_pais, 
		  pev.materno, 
		  pev.nombres, 
		  pev.paterno, 
		  CASE WHEN pev.paterno IS NOT NULL THEN pev.nombres || ' ' || pev.paterno || ' ' || pev.materno  ELSE 'Lic. Rusena Mamani T.' END as nombre_completo_evaluador,
		  pev.di_persona, 'HOGAR TATA JUAN DE DIOS'::TEXT AS hogar
		FROM 
		  public.informe_psicologico ip
		INNER JOIN
		  public.personas_kardex pk
		ON ip.codigo_kardex = pk.codigo_kardex 
		INNER JOIN 
		  public.personas p
		ON pk.codigo_persona = p.codigo_persona 
		INNER JOIN
		  public.personas_datos_nacimiento pdn 
		ON p.codigo_persona = pdn.codigo_persona
		LEFT JOIN
		  public.personas pev
		ON pev.codigo_persona = ip.codigo_persona_evalua
		LEFT JOIN 
		  public.paises pa
		ON  pa.codigo_pais = pdn.codigo_paisn 
		LEFT JOIN
		  public.departamentos de
		ON de.codigo_pais = pdn.codigo_paisn AND
		  de.codigo_departamento = pdn.codigo_departamenton
		WHERE ip.codigo_informe_psico = codigo_informe_psico_aux
		
		
	LOOP
		RETURN next registros2;
	END LOOP;
	RETURN;
END;
$body$ LANGUAGE 'plpgsql' VOLATILE;





SELECT * FROM listar_informe_psicologico_reporte(2) 
AS 
(
	codigo_informe_psico	INTEGER, 
	codigo_kardex		INTEGER, 
	motivo_consulta		TEXT, 
	fecha_evaluacion	DATE, 
	codigo_persona_evalua	INTEGER, 
	instrumentos		TEXT, 
	antecedentes		TEXT, 
	aspectos_relevantes	TEXT, 
	conductas_observadas	TEXT, 
	res_motricidad_gruesa	TEXT, 
	res_motricidad_fino	TEXT, 
	res_audicion_lenguaje	TEXT, 
	res_personal_social	TEXT, 
	res_total		TEXT, 
	diagnostico		TEXT, 
	recomendaciones		TEXT, 
	numero_kardex		INTEGER, 
	fecha_ingreso		DATE, 
	motivo_ingreso		TEXT, 
	di_persona_nino		CHARACTER(10), 
	paterno_nino		CHARACTER VARYING(40), 
	materno_nino		CHARACTER VARYING(40),	 
	nombres_nino		CHARACTER VARYING(80), 
	nombre_completo_nino	TEXT,
	sexo			TEXT, 
	fecha_nacimiento	DATE, 
	edad			INTEGER, 
	codigo_pais		CHARACTER(2), 
	nombre_departamento	CHARACTER VARYING(250), 
	nombre_pais		CHARACTER VARYING(250), 
	materno_evaluador	CHARACTER VARYING(40), 
	nombres_evaluador	CHARACTER VARYING(80), 
	paterno_evaluador	CHARACTER VARYING(40), 
	nombre_completo_evaluador TEXT,
	di_persona_evaluador	CHARACTER(10),
	hogar			TEXT
)

-- 
-- 
-- SELECT 
--   ip.codigo_informe_psico, 
--   ip.codigo_kardex, 
--   ip.motivo_consulta, 
--   ip.fecha_evaluacion, 
--   ip.codigo_persona_evalua, 
--   ip.instrumentos, 
--   ip.antecedentes, 
--   ip.aspectos_relevantes, 
--   ip.conductas_observadas, 
--   ip.res_motricidad_gruesa, 
--   ip.res_motricidad_fino, 
--   ip.res_audicion_lenguaje, 
--   ip.res_personal_social, 
--   ip.res_total, 
--   ip.diagnostico, 
--   ip.recomendaciones, 
--   pk.numero_kardex, 
--   pk.fecha_ingreso, 
--   pk.motivo_ingreso, 
--   p.di_persona, 
--   p.paterno, 
--   p.materno, 
--   p.nombres, 
--   p.nombres || ' ' || p.paterno || ' ' || p.materno as nombre_completo_nino,
--   CASE p.sexo WHEN 'F' THEN 'FEMENINO' ELSE 'MASCULINO' END AS sexo, 
--   pdn.fecha_nacimiento, 
--   pdn.edad, 
--   de.codigo_pais, 
--   de.nombre_departamento, 
--   pa.nombre_pais, 
--   pev.materno, 
--   pev.nombres, 
--   pev.paterno, 
--   pev.nombres || ' ' || pev.paterno || ' ' || pev.materno as nombre_completo_evaluador,
--   pev.di_persona
-- FROM 
--   public.informe_psicologico ip
-- INNER JOIN
--   public.personas_kardex pk
-- ON ip.codigo_kardex = pk.codigo_kardex 
-- INNER JOIN 
--   public.personas p
-- ON pk.codigo_persona = p.codigo_persona 
-- INNER JOIN
--   public.personas_datos_nacimiento pdn 
-- ON p.codigo_persona = pdn.codigo_persona
-- LEFT JOIN
--   public.personas pev
-- ON pev.codigo_persona = ip.codigo_persona_evalua
-- LEFT JOIN 
--   public.paises pa
-- ON  pa.codigo_pais = pdn.codigo_paisn 
-- LEFT JOIN
--   public.departamentos de
-- ON de.codigo_pais = pdn.codigo_paisn AND
--   de.codigo_departamento = pdn.codigo_departamenton

