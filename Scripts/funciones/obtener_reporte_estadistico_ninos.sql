CREATE OR REPLACE FUNCTION obtener_reporte_estadistico_ninos(
	edad_aux 	INT,
	fecha_inicio		DATE,
	fecha_fin		DATE
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
		  pk.codigo_kardex, pk.numero_kardex, pk.fecha_ingreso, pk.nombre_kardex, p.nombres, p.paterno || '' '' || p.materno, p.nombres || '' ''  || p.paterno || '' '' || p.materno,
		  pk.centro, pk.motivo_ingreso, pk.motivo_egreso, 
		  CASE 	WHEN pdn.edad = 0 THEN ''NIÑOS DE 0 A 1 AÑOS DE EDAD''
			WHEN pdn.edad = 1 THEN ''NIÑOS DE 1 A 2 AÑOS DE EDAD''
			WHEN pdn.edad = 2 THEN ''NIÑOS DE 2 A 3 AÑOS DE EDAD''
			WHEN pdn.edad = 3 THEN ''NIÑOS DE 3 A 4 AÑOS DE EDAD''
			WHEN pdn.edad = 4 THEN ''NIÑOS DE 4 A 5 AÑOS DE EDAD''
			ELSE ''NIÑOS DE 5 A 6 AÑOS DE EDAD'' END,
		  CASE WHEN p.sexo = ''F'' THEN ''FEMENINO'' ELSE ''MASCULINO'' END
		FROM 
		  public.personas_kardex pk, 
		  public.personas p, 
		  public.personas_datos_nacimiento pdn
		WHERE 
		  p.codigo_persona = pk.codigo_persona AND
		  p.codigo_persona = pdn.codigo_persona
		  and p.codigo_tipo_persona = ''N''
		  and pk.codigo_estado = ''A''

		';
	filtro = ' ';
	IF edad_aux IS NOT NULL THEN
		filtro = filtro || ' AND pdn.edad <= ' || edad_aux || ' ';
	END IF;

	IF fecha_inicio IS NOT NULL AND fecha_fin IS NOT NULL  THEN
		filtro = filtro || ' AND pk.fecha_ingreso BETWEEN ''' || fecha_inicio::text || ''' AND ''' || fecha_fin::text || ''' ';
	END IF;
	
	IF(filtro IS NOT NULL AND filtro <> ' ') THEN
		
		sql = sql || ' ' || filtro;
	END IF;
	
	
	
	FOR registro IN EXECUTE sql
	LOOP
	RETURN next registro;
	end loop;
	RETURN;

END;
$body$ LANGUAGE 'plpgsql' VOLATILE;



SELECT * FROM obtener_reporte_estadistico_ninos(6, null, null) 
AS 
(
	codigo_kardex	INTEGER,
	numero_kardex	INTEGER,
	fecha_ingreso	DATE,
	nombre_kardex	TEXT,
	nombres		CHARACTER VARYING(80),
	apellidos	TEXT,
	nombre_completo	TEXT,
	centro		TEXT,
	motivo_ingreso	TEXT,
	motivo_egreso	TEXT,
	categoria_edad	TEXT,
	sexo		TEXT

);

-- 
-- SELECT 
--   pk.codigo_kardex, pk.numero_kardex, pk.fecha_ingreso, pk.nombre_kardex, p.nombres, p.paterno || ' ' || p.materno, p.nombres || ' '  || p.paterno || ' ' || p.materno,
--   pk.centro, pk.motivo_ingreso, pk.motivo_egreso, 
--   CASE 	WHEN pdn.edad = 0 THEN 'NIÑOS DE 0 A 1 AÑOS DE EDAD'
-- 	WHEN pdn.edad = 1 THEN 'NIÑOS DE 1 A 2 AÑOS DE EDAD'
-- 	WHEN pdn.edad = 2 THEN 'NIÑOS DE 2 A 3 AÑOS DE EDAD'
-- 	WHEN pdn.edad = 3 THEN 'NIÑOS DE 3 A 4 AÑOS DE EDAD'
-- 	WHEN pdn.edad = 4 THEN 'NIÑOS DE 4 A 5 AÑOS DE EDAD'
-- 	ELSE 'NIÑOS DE 5 AÑOS PARA ARRIBA' END
-- FROM 
--   public.personas_kardex pk, 
--   public.personas p, 
--   public.personas_datos_nacimiento pdn
-- WHERE 
--   p.codigo_persona = pk.codigo_persona AND
--   p.codigo_persona = pdn.codigo_persona
--   and p.codigo_tipo_persona = 'N'
--   and pk.codigo_estado = 'A'



SELECT 
		  pk.codigo_kardex, pk.numero_kardex, pk.fecha_ingreso, pk.nombre_kardex, p.nombres, p.paterno || ' ' || p.materno, p.nombres || ' '  || p.paterno || ' ' || p.materno,
		  pk.centro, pk.motivo_ingreso, pk.motivo_egreso, 
		  CASE 	WHEN pdn.edad = 0 THEN 'NIÑOS DE 0 A 1 AÑOS DE EDAD'
			WHEN pdn.edad = 1 THEN 'NIÑOS DE 1 A 2 AÑOS DE EDAD'
			WHEN pdn.edad = 2 THEN 'NIÑOS DE 2 A 3 AÑOS DE EDAD'
			WHEN pdn.edad = 3 THEN 'NIÑOS DE 3 A 4 AÑOS DE EDAD'
			WHEN pdn.edad = 4 THEN 'NIÑOS DE 4 A 5 AÑOS DE EDAD'
			ELSE 'NIÑOS DE 5 A 6 AÑOS DE EDAD' END,
		  CASE WHEN p.sexo = 'F' THEN 'FEMENINO' ELSE 'MASCULINO' END
		FROM 
		  public.personas_kardex pk, 
		  public.personas p, 
		  public.personas_datos_nacimiento pdn
		WHERE 
		  p.codigo_persona = pk.codigo_persona AND
		  p.codigo_persona = pdn.codigo_persona
		  and p.codigo_tipo_persona = 'N'
		  and pk.codigo_estado = 'A'