CREATE OR REPLACE FUNCTION obtener_reporte_ingresos_tipos(
	codigo_ingreso_tipo_aux 	INT
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
		  it.codigo_ingreso_tipo, 
		  it.nombre_ingreso_tipo, 
		  it.descripcion
		FROM 
		  public.ingresos_tipos it
		';
	filtro = ' ';
	IF codigo_ingreso_tipo_aux IS NOT NULL THEN
		filtro = filtro || ' WHERE it.codigo_ingreso_tipo = ' || codigo_ingreso_tipo_aux::text || ' ';
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



SELECT * FROM obtener_reporte_ingresos_tipos(NULL) 
AS 
(	
	  codigo_ingreso_tipo 	INT,
	  nombre_ingreso_tipo 	CHARACTER VARYING(150),
	  descripcion 		CHARACTER VARYING(300)
);




