CREATE OR REPLACE FUNCTION listar_grupo_familiar_kardex(
	codigo_kardex_aux	INT
)
RETURNS SETOF RECORD
AS
$body$
DECLARE 
	registros2		RECORD;
BEGIN
	FOR registros2 IN 
		SELECT 	p.nombres || ' ' || p.paterno || ' ' || p.materno as nombre_completo,
			par.nombre_parentesco as relacion, 0 as edad,
			CASE p.estado_civil WHEN 'S' THEN 'SOLTERO(A)' WHEN 'C' THEN 'CASADO(A)' WHEN 'D' THEN 'DIVORCIADO(A)' ELSE 'VIUDO(A)' END AS estado_civil,
			CASE p.grado_instruccion WHEN 'N' THEN 'NINGUNO' WHEN 'A' THEN 'ANALFABETO' WHEN 'P' THEN 'PRIMARIO' 
			WHEN 'S' THEN 'SECUNDARIO' WHEN 'U' THEN 'UNIVERSITARIO' WHEN 'A' THEN 'ANALFABETO' WHEN 'P' THEN 'PRIMARIO'END AS grado_instruccion,
			e.nombre_empleo, pkf.monto_ingreso, pkf.observaciones
		FROM personas_kardex_familiares PKF
		INNER JOIN personas P
		ON PKF.codigo_persona = P.codigo_persona
		INNER JOIN parentescos par
		ON PKF.codigo_parentesco = par.codigo_parentesco
		LEFT JOIN empleos e
		ON P.codigo_empleo = e.codigo_empleo
		WHERE PKF.codigo_kardex = codigo_kardex_aux
		
	LOOP
		RETURN next registros2;
	END LOOP;
	RETURN;
END;
$body$ LANGUAGE 'plpgsql' VOLATILE;



-- SELECT * FROM listar_grupo_familiar_kardex(34) 
-- AS 
-- (
-- 	nombre_completo		TEXT,
-- 	relacion		CHARACTER VARYING(100),
-- 	edad			INTEGER,
-- 	estado_civil		TEXT,
-- 	grado_instruccion	TEXT,
-- 	nombre_empleo		CHARACTER VARYING(200),
-- 	monto_ingreso		DOUBLE PRECISION,
-- 	observaciones		TEXT
-- )
-- 
-- select * from personas_kardex_familiares
