CREATE OR REPLACE FUNCTION obtener_reporte_partidas(
	codigo_partida_aux 	CHARACTER(10)
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
		  p1.nombre_partida, 
		  p2.nombre_partida, 
		  p2.codigo_partida, 
		  p2.codigo_partida_padre, 
		  p2.descripcion_partida
		FROM 
		  public.partidas p1
		RIGHT JOIN
		  public.partidas p2
		ON
		  p1.codigo_partida = p2.codigo_partida_padre
		';
	filtro = ' ';
	IF codigo_partida_aux IS NOT NULL THEN
		filtro = filtro || ' WHERE p1.codigo_partida = ''' || codigo_partida_aux || ''' ';
	END IF;

	IF(filtro IS NOT NULL AND filtro <> ' ') THEN
		
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



-- SELECT * FROM obtener_reporte_partidas('43000     ') 
SELECT * FROM obtener_reporte_partidas(NULL) 
AS 
(	  nombre_partida_padre CHARACTER VARYING(250),	
	  nombre_partida CHARACTER VARYING(250),
	  codigo_partida CHARACTER(10),
	  codigo_partida_padre CHARACTER(10),	  
	  descripcion_partida TEXT
) ORDER BY codigo_partida_padre;




