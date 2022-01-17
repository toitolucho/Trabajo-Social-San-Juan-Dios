CREATE OR REPLACE FUNCTION listar_documentos_kardex(
	codigo_kardex_aux	INT
)
RETURNS SETOF RECORD
AS
$body$
DECLARE 
	registros2		RECORD;
BEGIN
	FOR registros2 IN 
		SELECT d.codigo_documento, d.nombre_documento, CASE WHEN pkd.codigo_kardex IS NULL THEN ' ' ELSE 'X' END AS cuenta
 		FROM documentos d
		LEFT JOIN personas_kardex_documentos pkd
		on d.codigo_documento = pkd.codigo_documento
		and pkd.codigo_kardex = codigo_kardex_aux
		ORDER BY d.codigo_documento
		
	LOOP
		RETURN next registros2;
	END LOOP;
	RETURN;
END;
$body$ LANGUAGE 'plpgsql' VOLATILE;



-- SELECT * FROM listar_documentos_kardex(1) 
-- AS 
-- (	codigo_documento	INTEGER,
-- 	nombre_documento	CHARACTER VARYING(150),
-- 	cuenta			TEXT
-- )
