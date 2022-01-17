CREATE OR REPLACE FUNCTION obtener_reporte_egresos(
	codigo_usuario_aux 	INT, 
	codigo_proveedor_aux 	INT, 
	codigo_partida_aux	CHARACTER(10),
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
		  e.codigo_egreso, 
		  e.fecha_egreso, 
		  e.codigo_usuario, 
		  e.codigo_partida, 
		  e.codigo_ingreso, 
		  e.fecha_registro, 
		  e.nro_factura, 
		  e.codigo_proveedor, 
		  e.monto_salida, 
		  e.observaciones, 
		  par.nombre_partida, 
		  pro.nombre_proveedor, 
		  pro.nit_proveedor, 
		  u.codigo_persona, 
		  u.nombre_usuario, 
		  u.codigo_tipo, 
		  p.nombres || '' '' || p.paterno || '' '' || p.materno,
		  CASE u.codigo_tipo WHEN ''S'' THEN ''SECREATARIA'' WHEN ''M'' THEN ''MEDICO'' WHEN ''V'' THEN ''TRABAJADORA SOCIAL'' WHEN ''A'' THEN ''ADMINISTRADOR(A)'' WHEN ''D'' THEN ''DIRECTOR(A) DEL HOGAR''
		  WHEN ''P'' THEN ''PSICLOGA'' END,
		  CASE p.codigo_tipo_persona WHEN ''N'' THEN ''NIÑO'' WHEN ''R'' THEN ''FUNCIONARIO'' WHEN ''F'' THEN ''FAMILIARES'' WHEN ''A'' THEN ''APODERADO'' WHEN ''U'' THEN ''USUARIO'' ELSE ''OTRO'' END
		FROM 
		  public.egresos e, 
		  public.personas p, 
		  public.usuarios u, 
		  public.partidas par, 
		  public.proveedores pro
		WHERE 
		  e.codigo_usuario = u.codigo_usuario AND
		  u.codigo_persona = p.codigo_persona AND
		  par.codigo_partida = e.codigo_partida AND
		  pro.codigo_proveedor = e.codigo_proveedor
		';
	filtro = ' ';
	IF codigo_usuario_aux IS NOT NULL THEN
		filtro = filtro || ' AND u.codigo_usuario = ' || codigo_usuario_aux::text || ' ';
	END IF;

	IF codigo_proveedor_aux IS NOT NULL THEN
		filtro = filtro || ' AND pro.codigo_proveedor = ' || codigo_proveedor_aux::text || ' ';
	END IF;

	IF codigo_partida_aux IS NOT NULL THEN
		filtro = filtro || ' AND e.codigo_partida = ''' || codigo_partida_aux || ''' ';
	END IF;

	IF fecha_inicio IS NOT NULL AND fecha_fin IS NOT NULL  THEN
		filtro = filtro || ' AND e.fecha_egreso BETWEEN ''' || fecha_inicio::text || ''' AND ''' || fecha_fin::text || ''' ';
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
-- SELECT * FROM obtener_reporte_egresos(NULL, NULL, null, '21/01/2000' , '31/12/2015') 
SELECT * FROM obtener_reporte_egresos(1, 1, '31100', '21/01/2000' , '31/12/2015') 
AS 
(	
	codigo_egreso	INTEGER,
	fecha_egreso	DATE,	
	codigo_usuario	INTEGER,
	codigo_partida	CHARACTER(10),
	codigo_ingreso	INTEGER,
	fecha_registro	DATE,
	nro_factura	INTEGER,
	codigo_proveedor INTEGER,
	monto_salida	DOUBLE PRECISION,
	observaciones 	TEXT,
	nombre_partida	CHARACTER VARYING(250),
	nombre_proveedor CHARACTER VARYING(200),
	nit_proveedor	CHARACTER(15),
	codigo_persona	INTEGER,	
	nombre_usuario	CHARACTER VARYING(200),	
	codigo_tipo_usuario CHARACTER(1),
	nombre_completo	TEXT,	
	--codigo_tipo_persona CHARACTER(1),	
	tipo_usuario	TEXT,
	tipo_pesona	TEXT
);


-- 
-- 
-- SELECT 
--   e.codigo_egreso, 
--   e.fecha_egreso, 
--   e.codigo_usuario, 
--   e.codigo_partida, 
--   e.codigo_ingreso, 
--   e.fecha_registro, 
--   e.nro_factura, 
--   e.codigo_proveedor, 
--   e.monto_salida, 
--   e.observaciones, 
--   par.nombre_partida, 
--   pro.nombre_proveedor, 
--   pro.nit_proveedor, 
--   u.codigo_persona, 
--   u.nombre_usuario, 
--   u.codigo_tipo, 
--   p.nombres || ' ' || p.paterno || ' ' || p.materno,
--   CASE u.codigo_tipo WHEN 'S' THEN 'SECREATARIA' WHEN 'M' THEN 'MEDICO' WHEN 'V' THEN 'TRABAJADORA SOCIAL' WHEN 'A' THEN 'ADMINISTRADOR(A)' WHEN 'D' THEN 'DIRECTOR(A) DEL HOGAR'
--   WHEN 'P' THEN 'PSICLOGA' END,
--   CASE p.codigo_tipo_persona WHEN 'N' THEN 'NIÑO' WHEN 'R' THEN 'FUNCIONARIO' WHEN 'F' THEN 'FAMILIARES' WHEN 'A' THEN 'APODERADO' WHEN 'U' THEN 'USUARIO' ELSE 'OTRO' END
-- FROM 
--   public.egresos e, 
--   public.personas p, 
--   public.usuarios u, 
--   public.partidas par, 
--   public.proveedores pro
-- WHERE 
--   e.codigo_usuario = u.codigo_usuario AND
--   u.codigo_persona = p.codigo_persona AND
--   par.codigo_partida = e.codigo_partida AND
--   pro.codigo_proveedor = e.codigo_proveedor
