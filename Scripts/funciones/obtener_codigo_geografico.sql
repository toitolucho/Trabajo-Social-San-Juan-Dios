DROP FUNCTION obtener_codigo_geografico(
	nombre_tabla 		VARCHAR(200),
	codigo_pais		CHAR(2), 
	codigo_departamento	CHAR(2),
	codigo_provincia	CHAR(2)
);


CREATE OR REPLACE FUNCTION obtener_codigo_geografico(
	nombre_tabla 		VARCHAR(200),
	codigo_pais_aux		CHAR(2), 
	codigo_departamento_aux	CHAR(2),
	codigo_provincia_aux	CHAR(2)
)
  RETURNS CHAR(3) AS
$BODY$
DECLARE	
	codigo_secuencial  CHAR(3);
	nro_filas	   INT;
	codigo_geografico  CHAR(3);
BEGIN 

	IF(nombre_tabla = 'paises') THEN
	   
	   SELECT count(codigo_pais) + 1 INTO nro_filas
	   FROM paises;

	   codigo_geografico = RIGHT( '0' || nro_filas,2);
	   
	ELSIF (nombre_tabla = 'departamentos') THEN
		SELECT  RIGHT( '0' || codigo_departamento::int + 1, 2) into codigo_geografico
		FROM departamentos
		WHERE codigo_pais = codigo_pais_aux
		ORDER BY codigo_departamento DESC
		LIMIT 1 OFFSET 0;

		codigo_geografico = CASE WHEN codigo_geografico IS NULL THEN '01' ELSE codigo_geografico END;
	   
	ELSIF (nombre_tabla = 'provincias') THEN
		SELECT  RIGHT( '0' || codigo_provincia::int + 1, 2) into codigo_geografico
		FROM provincias
		WHERE codigo_pais = codigo_pais_aux
		and codigo_departamento = codigo_departamento_aux
		ORDER BY codigo_provincia DESC
		LIMIT 1 OFFSET 0;

		codigo_geografico = CASE WHEN codigo_geografico IS NULL THEN '01' ELSE codigo_geografico END;

	ELSIF (nombre_tabla = 'lugares') THEN
	   SELECT  RIGHT( '00' || codigo_lugar::int + 1, 3) into codigo_geografico
		FROM lugares
		WHERE codigo_pais = codigo_pais_aux
		and codigo_departamento = codigo_departamento_aux
		and codigo_provincia = codigo_provincia_aux
		ORDER BY codigo_lugar DESC
		LIMIT 1 OFFSET 0;

		codigo_geografico = CASE WHEN codigo_geografico IS NULL THEN '001' ELSE codigo_geografico END;	
	   
	END IF;

  RAISE NOTICE 'Codigo Generado = %',  codigo_geografico;
   RETURN codigo_geografico;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

  
ALTER FUNCTION obtener_codigo_geografico(
	nombre_tabla 		VARCHAR(200),
	codigo_pais_aux		CHAR(2), 
	codigo_departamento_aux	CHAR(2),
	codigo_provincia_aux	CHAR(2)
) OWNER TO postgres;


-- SELECT obtener_codigo_geografico('paises', 'BO', '02', null)
-- select *, upper(nombre_pais) from paises
-- select * 
-- from DEPARTAMENTOS d
-- INNER JOIN paises p
-- on d.codigo_pais = p.codigo_pais
-- 
-- select * from lugares
-- where nombre_lugar like '%r%'
-- 
-- select *
-- from provincias pro
-- inner join departamentos d
-- on pro.codigo_departamento = d.codigo_departamento
-- and pro.codigo_pais = d.codigo_pais
-- inner join paises p
-- on d.codigo_pais = p.codigo_pais
-- 
-- 
-- select l.*, p.nombre_provincia, d.nombre_departamento, pa.nombre_pais
-- from lugares l
-- inner join provincias p
-- on l.codigo_provincia = p.codigo_provincia
-- and l.codigo_departamento = p.codigo_departamento
-- and l.codigo_pais = p.codigo_pais
-- inner join departamentos d
-- on p.codigo_departamento =d.codigo_departamento
-- and p.codigo_pais = d.codigo_pais
-- inner join paises pa
-- on d.codigo_pais = pa.codigo_pais