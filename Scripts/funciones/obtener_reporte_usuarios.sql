CREATE OR REPLACE FUNCTION obtener_reporte_usuarios(
	codigo_persona_aux 	INT, 
	codigo_empleo_aux 	INT,
	codigo_tipo_aux		CHAR(1)
)
RETURNS SETOF RECORD
AS
$body$
DECLARE 
	registro	RECORD;
	sql 		text;
	filtro		TEXT;	
BEGIN

	sql = 'select u.codigo_usuario, u.fecha_registro, u.nombre_usuario, u.contrasenia,
			CASE u.codigo_tipo WHEN ''S'' THEN ''SECREATRIA'' WHEN ''M'' THEN ''MEDICO'' WHEN ''V'' THEN ''TRABAJADORA SOCIAL'' WHEN ''A'' THEN ''ADMINISTRADOR(A)''
			WHEN ''D'' THEN ''DIRECTORA DEL HOGAR'' WHEN ''P'' THEN ''PSICOLOGA'' END,
			p.di_persona, p.nombres, p.paterno, p.materno, p.nombres || '' '' || p.paterno || '' '' || p.materno, p.paterno || '' '' || p.materno,
			e.nombre_empleo, CASE p.grado_instruccion WHEN ''N'' THEN ''NINGUNO'' WHEN ''A'' THEN ''ANALFABETO'' WHEN ''P'' THEN ''PRIMARIO'' WHEN ''S'' THEN ''SECUNDARIO''
			WHEN ''T'' THEN ''TECNICO SUPERIOR'' WHEN ''R'' THEN ''SUPERIOR'' END,
			CASE p.sexo WHEN ''F'' THEN ''FEMENINO'' ELSE ''MASCULINO'' END,
			CASE P.estado_civil WHEN ''S'' THEN ''SOLTERO(A)'' WHEN ''C'' THEN ''CASADO(A)'' WHEN ''D'' THEN ''DIVORCIADO(A)'' WHEN ''V'' THEN ''VIUDO'' END,
			p.celular, p.telefono, p.domicilio, p.observaciones
		from usuarios u
		inner join personas p
		on u.codigo_persona = p.codigo_persona
		LEFT JOIN empleos e
		on p.codigo_empleo = e.codigo_empleo
		';
	filtro = ' ';
	IF codigo_persona_aux IS NOT NULL THEN
		filtro = filtro || ' (p.codigo_persona = ' || codigo_persona_aux::text || ') AND ';
	END IF;

	IF codigo_tipo_aux IS NOT NULL THEN
		filtro = filtro || ' (u.codigo_tipo = ''' || codigo_tipo_aux::text || ''') AND ';
	END IF;

	IF codigo_empleo_aux IS NOT NULL THEN
		filtro = filtro || ' (p.codigo_empleo = ' || codigo_empleo_aux::text || ') AND ';
	END IF;
	
	RAISE NOTICE ' FILTRO : (%)', SUBSTRING(filtro, LENGTH(filtro)-3);
	
	IF(filtro IS NOT NULL AND filtro <> ' ') THEN
		IF(SUBSTRING(filtro, LENGTH(filtro)-3) = 'AND ') THEN
			--SELECT SUBSTRING('BONITA',4,1) SELECT LENGTH('HOLA')
			filtro = SUBSTRING(filtro, 0, LENGTH(filtro)-4);
		END IF;
		sql = sql || 'WHERE ' || filtro;
	END IF;
	
	RAISE NOTICE ' SQL: (%)', sql;
	
	FOR registro IN EXECUTE sql
	LOOP
	RETURN next registro;
	end loop;
	RETURN;

END;
$body$ LANGUAGE 'plpgsql' VOLATILE;



SELECT * FROM obtener_reporte_usuarios(1,1, 'M') 
AS 
(	
	codigo_usuario	INTEGER,
	fecha_registro	DATE,
	nombre_usuario	CHARACTER VARYING(200),
	contrasenia	CHARACTER VARYING(100),
	tipo_usuario	TEXT,
	di_persona	CHARACTER(10),
	nombres		CHARACTER VARYING(80),
	paterno		CHARACTER VARYING(40),
	materno		CHARACTER VARYING(40),
	nombre_completo	TEXT,
	apellidos	TEXT,
	nombre_empleo	CHARACTER VARYING(200),
	grado_instruccion	TEXT,
	sexo		TEXT,
	estado_civil	TEXT,
	celular		CHARACTER(10),
	telefono	CHARACTER VARYING(100),
	domicilio	TEXT,
	observaciones	TEXT
);