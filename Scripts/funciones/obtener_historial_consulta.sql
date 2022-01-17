CREATE OR REPLACE FUNCTION obtener_historial_consulta(
	numero_hc_aux	INT,
	numero_consulta_aux INT,
	fecha_inicio	DATE,
	fecha_fin	DATE
)
RETURNS SETOF RECORD
AS
$body$
DECLARE 
	registro	RECORD;
	sql 		text;
	filtro		TEXT;
BEGIN
	sql = 'SELECT 
		  c.numero_hc, 
		  c.numero_consulta, 
		  c.motivo, 
		  c.fecha_consulta, 
		  CASE c.codigo_tipo_consulta WHEN ''P'' THEN ''PARTICULAR'' WHEN ''N'' THEN ''NORMAL'' WHEN ''T'' THEN ''TRANSFERENCIA'' END, 
		  c.diagnostico, 
		  c.observaciones, 
		  p.paterno, 
		  p.materno, 
		  p.nombres,
		  p.nombres || '' '' || p.paterno || '' '' || p.materno,
		  CASE WHEN p.sexo = ''M'' THEN ''MASCULINO'' ELSE ''FEMENINO'' END as sexo, 
		  pdn.fecha_nacimiento, 
		  pdn.edad, 
		  hc.grupo_sanguinio, 
		  hc.fecha_registro
		FROM 
		  public.consulta c, 
		  public.personas p, 
		  public.historia_clinico hc, 
		  public.personas_datos_nacimiento pdn
		WHERE 
		  c.numero_hc = hc.numero_hc AND
		  p.codigo_persona = pdn.codigo_persona AND
		  hc.idpersona = p.codigo_persona
		';
	filtro = ' ';
	IF numero_hc_aux IS NOT NULL THEN
		filtro = filtro || ' AND c.numero_hc = ' || numero_hc_aux::text || ' ';
	END IF;

	IF numero_consulta_aux IS NOT NULL THEN
		filtro = filtro || ' AND c.numero_consulta = ' || numero_consulta_aux::text || ' ';
	END IF;

	IF fecha_inicio IS NOT NULL AND fecha_fin IS NOT NULL  THEN
		filtro = filtro || ' AND c.fecha_consulta BETWEEN ''' || fecha_inicio::text || ''' AND ''' || fecha_fin::text || ''' ';
	END IF;
	
	RAISE NOTICE ' FILTRO : (%)', SUBSTRING(filtro, LENGTH(filtro)-3);
	
	IF(filtro IS NOT NULL AND filtro <> ' ') THEN
		IF(SUBSTRING(filtro, LENGTH(filtro)-3) = 'AND ') THEN
			--SELECT SUBSTRING('BONITA',4,1) SELECT LENGTH('HOLA')
			filtro = SUBSTRING(filtro, 0, LENGTH(filtro)-4);
		END IF;
		sql = sql || ' ' || filtro;
	END IF;
	
	RAISE NOTICE ' SQL: (%)', sql;
	
	FOR registro IN EXECUTE sql
	LOOP
	RETURN next registro;
	end loop;
	RETURN;


END;
$body$ LANGUAGE 'plpgsql' VOLATILE;


-- 
SELECT * FROM obtener_historial_consulta(1, 7, null, null) 
AS 
(
  numero_hc		INTEGER, 
  numero_consulta	INTEGER, 
  motivo		CHARACTER VARYING(100), 
  fecha_consulta	DATE, 
  tipo_consulta		TEXT, 
  diagnostico		TEXT, 
  observaciones		TEXT, 
  paterno		CHARACTER VARYING(40), 
  materno		CHARACTER VARYING(40), 
  nombres		CHARACTER VARYING(80),
  nombre_completo	TEXT,
  sexo			TEXT, 
  fecha_nacimiento	DATE, 
  edad			INT, 
  grupo_sanguinio	CHARACTER VARYING(10), 
  fecha_registro	DATE
)

-- 
-- SELECT 
--   c.numero_hc, 
--   c.numero_consulta, 
--   c.motivo, 
--   c.fecha_consulta, 
--   CASE c.codigo_tipo_consulta WHEN 'P' THEN 'PARTICULAR' WHEN 'N' THEN 'NORMAL' WHEN 'T' THEN 'TRANSFERENCIA' END, 
--   c.diagnostico, 
--   c.observaciones, 
--   p.paterno, 
--   p.materno, 
--   p.nombres,
--   p.nombres || ' ' || p.paterno || ' ' || p.materno,
--   CASE WHEN p.sexo = 'M' THEN 'MASCULINO' ELSE 'FEMENINO' END as sexo, 
--   pdn.fecha_nacimiento, 
--   pdn.edad, 
--   hc.grupo_sanguinio, 
--   hc.fecha_registro
-- FROM 
--   public.consulta c, 
--   public.personas p, 
--   public.historia_clinico hc, 
--   public.personas_datos_nacimiento pdn
-- WHERE 
--   c.numero_hc = hc.numero_hc AND
--   p.codigo_persona = pdn.codigo_persona AND
--   hc.idpersona = p.codigo_persona;
