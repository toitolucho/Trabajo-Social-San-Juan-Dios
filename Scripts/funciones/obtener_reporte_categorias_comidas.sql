CREATE OR REPLACE FUNCTION obtener_reporte_categorias_comidas(
	codigo_categoria_aux 	INT
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
		  comidas.codigo_comida, 
		  comidas.nombre_comida, 
		  comidas.codigo_categoria, 
		  comidas.precio_estimado, 
		  comidas.descripcion, 
		  categorias_comidas.nombre_categoria, 
		  categorias_comidas.orden_categoria, 
		  categorias_comidas.hora_inicio, 
		  categorias_comidas.hora_fin
		FROM 
		  public.comidas, 
		  public.categorias_comidas
		WHERE 
		  comidas.codigo_categoria = categorias_comidas.codigo_categoria
		';
	filtro = ' ';
	IF codigo_categoria_aux IS NOT NULL THEN
		filtro = filtro || ' AND comidas.codigo_categoria = ' || codigo_categoria_aux::text || ' ';
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



SELECT * FROM obtener_reporte_categorias_comidas(null) 
AS 
(	
	codigo_comida	INTEGER,	
	nombre_comida	CHARACTER VARYING(250),
	codigo_categoria INTEGER,
	precio_estimado	DOUBLE PRECISION,
	descripcion	TEXT,		
	nombre_categoria CHARACTER VARYING(200),
	orden_categoria	 INTEGER,
	hora_inicio	 TIME,
	hora_fin	TIME
);

