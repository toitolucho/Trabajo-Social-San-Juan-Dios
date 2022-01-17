CREATE OR REPLACE FUNCTION obtener_reporte_categorias_comidas01(
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
		  cc.codigo_categoria, 
		  cc.nombre_categoria, 
		  cc.orden_categoria, 
		  cc.descripcion, 
		  cc.hora_inicio, 
		  cc.hora_fin, 
		  CASE cc.estado_categoria WHEN ''A'' THEN ''HABILITADO'' ELSE ''BAJA'' END
		FROM 
		  public.categorias_comidas cc
		';
	filtro = ' ';
	IF codigo_categoria_aux IS NOT NULL THEN
		filtro = filtro || ' WHERE cc.codigo_categoria = ' || codigo_categoria_aux::text || ' ';
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



SELECT * FROM obtener_reporte_categorias_comidas01(NULL) 
AS 
(
	codigo_categoria INT,
	nombre_categoria CHARACTER VARYING(200),
	orden_categoria  INTEGER,	
	descripcion 	 TEXT,
	hora_inicio 	 TIME WITHOUT TIME ZONE,
	hora_fin 	 TIME WITHOUT TIME ZONE,
	estado		 TEXT
);


