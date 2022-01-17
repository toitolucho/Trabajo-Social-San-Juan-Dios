CREATE OR REPLACE FUNCTION obtener_reporte_ingresos(
	codigo_usuario_aux 	INT, 
	codigo_ingreso_tipo_aux	INT,
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
		  ingresos.codigo_ingreso, 
		  ingresos.fecha_ingreso, 
		  ingresos.nombre_ingreso, 
		  ingresos.codigo_usuario, 
		  ingresos.monto_ingreso, 
		  ingresos.monto_actual, 
		  ingresos.codigo_ingreso_tipo, 
		  ingresos.detalle_ingreso, 
		  ingresos_tipos.nombre_ingreso_tipo, 
		  usuarios.nombre_usuario, 
		  personas.nombres || '' '' || personas.paterno || '' '' || personas.materno,
		  personas.codigo_tipo_persona,
		  usuarios.codigo_tipo,
		  CASE usuarios.codigo_tipo WHEN ''S'' THEN ''SECREATARIA'' WHEN ''M'' THEN ''MEDICO'' WHEN ''V'' THEN ''TRABAJADORA SOCIAL'' WHEN ''A'' THEN ''ADMINISTRADOR(A)'' WHEN ''D'' THEN ''DIRECTOR(A) DEL HOGAR''
		  WHEN ''P'' THEN ''PSICLOGA'' END,
		  CASE personas.codigo_tipo_persona WHEN ''N'' THEN ''NIÑO'' WHEN ''R'' THEN ''FUNCIONARIO'' WHEN ''F'' THEN ''FAMILIARES'' WHEN ''A'' THEN ''APODERADO'' WHEN ''U'' THEN ''USUARIO'' ELSE ''OTRO'' END
		FROM 
		  public.ingresos, 
		  public.usuarios, 
		  public.personas, 
		  public.ingresos_tipos
		WHERE 
		  ingresos.codigo_ingreso_tipo = ingresos_tipos.codigo_ingreso_tipo AND
		  ingresos.codigo_usuario = usuarios.codigo_usuario AND
		  usuarios.codigo_persona = personas.codigo_persona
		';
	filtro = ' ';
	IF codigo_usuario_aux IS NOT NULL THEN
		filtro = filtro || ' AND usuarios.codigo_usuario = ' || codigo_usuario_aux::text || ' ';
	END IF;

	IF codigo_ingreso_tipo_aux IS NOT NULL THEN
		filtro = filtro || ' AND ingresos.codigo_ingreso_tipo = ' || codigo_ingreso_tipo_aux::text || ' ';
	END IF;

	IF fecha_inicio IS NOT NULL AND fecha_fin IS NOT NULL  THEN
		filtro = filtro || ' AND ingresos.fecha_ingreso BETWEEN ''' || fecha_inicio::text || ''' AND ''' || fecha_fin::text || ''' ';
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



SELECT * FROM obtener_reporte_ingresos(NULL, NULL, '21/01/2000' , '31/12/2015') 
AS 
(	
	codigo_ingreso	INTEGER,
	fecha_ingreso	DATE,
	nombre_ingreso	CHARACTER VARYING(250),
	codigo_usuario	INTEGER,
	monto_ingreso	DOUBLE PRECISION,
	monto_actual	DOUBLE PRECISION,
	codigo_ingreso_tipo	INTEGER,
	detalle_ingreso	TEXT,	
	nombre_ingreso_tipo	CHARACTER VARYING(150),
	nombre_usuario	CHARACTER VARYING(200),	
	nombre_completo	TEXT,	
	codigo_tipo_persona CHARACTER(1),
	codigo_tipo_usuario CHARACTER(1),
	tipo_usuario	TEXT,
	tipo_pesona	TEXT
);

