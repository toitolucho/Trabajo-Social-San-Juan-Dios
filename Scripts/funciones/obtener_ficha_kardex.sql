CREATE OR REPLACE FUNCTION obtener_ficha_kardex(
	codigo_kardex_aux	INT
)
RETURNS SETOF RECORD
AS
$body$
DECLARE 
	registros2		RECORD;
BEGIN
	FOR registros2 IN 

		SELECT 	p.di_persona, pk.nombre_kardex, pk.numero_kardex, pk.fecha_registro, pk.fecha_ingreso, pk.centro,			
			p.nombres || ' ' || p.paterno || ' ' || p.materno as nombre_completo,
			p.nombres, p.paterno, p.materno, pdn.fecha_nacimiento, pdn.edad, 
			CASE WHEN p.sexo = 'M' THEN 'MASCULINO' ELSE 'FEMENINO' END as sexo,
			pa.nombre_pais, dp.nombre_departamento, pr.nombre_provincia, pro.nombre_lugar,
----'N'->NINGUNO, 'A'->ANALFABETO, 'P'->PRIMARIO, 'S'->SECUNDARIO, 'U'->UNIVERSITARIO, 'T'->TECNICO SUPERIOR, 'R'->SUPERIOR    --GRADO INSTRUCCIÓN
			CASE p.grado_instruccion WHEN 'N' THEN 'NINGUNO' WHEN 'A' THEN 'ANALFABETO' WHEN 'P' THEN 'PRIMARIO' 
			WHEN 'S' THEN 'SECUNDARIO' WHEN 'U' THEN 'UNIVERSITARIO' WHEN 'A' THEN 'ANALFABETO' WHEN 'P' THEN 'PRIMARIO' WHEN 'T' THEN 'TECNICO SUPERIOR' END AS grado_instruccion,
			p.domicilio, pk.motivo_ingreso, p2.nombres || ' ' || p2.paterno || ' ' || p2.materno as nombre_completo_ingreso, p2.domicilio as domicilio_ingreso,
			p2.telefono, p2.celular, ruta_archivo_foto,
			pk.fecha_egreso,  p3.nombres || ' ' || p3.paterno || ' ' || p3.materno as nombre_completo_egreso, p3.domicilio as domicilio_egreso,
			pk.motivo_egreso, p3.di_persona,  p3.telefono, p4.nombres || ' ' || p4.paterno || ' ' || p4.materno as nombre_completo_ts
		FROM personas_kardex pk
		INNER JOIN personas p
		ON pk.codigo_persona = p.codigo_persona
		LEFT JOIN personas_datos_nacimiento pdn
		ON p.codigo_persona = pdn.codigo_persona
		LEFT JOIN lugares pro 
		ON pdn.codigo_lugarn = pro.codigo_lugar
		and pdn.codigo_provincian = pro.codigo_provincia
		and pdn.codigo_departamenton = pro.codigo_departamento
		and pdn.codigo_paisn = pro.codigo_pais
		LEFT JOIN provincias pr
		on pro.codigo_provincia = pr.codigo_provincia
		and pro.codigo_departamento = pr.codigo_departamento
		and pro.codigo_pais = pr.codigo_pais
		LEFT JOIN departamentos dp
		ON dp.codigo_departamento = pr.codigo_departamento
		and dp.codigo_pais = pr.codigo_pais
		LEFT JOIN paises pa
		on pa.codigo_pais = dp.codigo_pais
		LEFT JOIN personas p2
		on pk.codigo_persona_ingreso = p2.codigo_persona
		LEFT JOIN personas p3
		on pk.codigo_persona_egreso = p3.codigo_persona
		LEFT JOIN personas p4
		on pk.codigo_persona_trab_social = p4.codigo_persona
		WHERE pk.codigo_kardex = codigo_kardex_aux
	LOOP
		RETURN next registros2;
	END LOOP;
	RETURN;
END;
$body$ LANGUAGE 'plpgsql' VOLATILE;


-- 
SELECT * FROM obtener_ficha_kardex(1) 
AS 
(
	di_persona		CHARACTER (10),
	nombre_kardex		TEXT,
	numero_kardex		INTEGER,
	fecha_registro		DATE,
	fecha_ingreso		DATE,
	
	centro			TEXT,
	nombre_completo		TEXT,
	nombres			CHARACTER VARYING(80),
	paterno			CHARACTER VARYING(40),
	materno			CHARACTER VARYING(40),
	fecha_nacimiento 	DATE,
	edad			INTEGER,
	sexo			TEXT,
	nombre_pais		CHARACTER VARYING(250),
	nombre_departamento 	CHARACTER VARYING(250),
	nombre_provincia	CHARACTER VARYING(250),
	nombre_lugar		CHARACTER VARYING(250),
	grado_instruccion	TEXT,	
	domicilio_persona	TEXT,
	motivo_ingreso		TEXT,	
	nombre_completo_ingreso	TEXT,
	domicilio_ingreso	TEXT,
	telefono_ingreso	CHARACTER VARYING(100),
	celular_ingreso		CHARACTER (10),
	ruta_archivo_foto	TEXT,
	fecha_egreso		DATE,
	nombre_completo_egreso	TEXT,
	domicilio_egreso	TEXT,
	motivo_egreso		TEXT,	
	di_persona_egreso	CHARACTER(10),
	telefono_egreso		CHARACTER VARYING(100),
	nombre_completo_ts	TEXT
)
