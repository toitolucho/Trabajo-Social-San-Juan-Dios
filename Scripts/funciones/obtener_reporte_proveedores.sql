CREATE OR REPLACE FUNCTION obtener_reporte_proveedores(
	codigo_proveedor_aux 	INT
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
		  p.codigo_proveedor, 
		  p.nombre_proveedor, 
		  p.estado_proveedor, 
		  p.nit_proveedor, 
		  p.descripcion
		FROM 
		  public.proveedores p
		';
	filtro = ' ';
	IF codigo_proveedor_aux IS NOT NULL THEN
		filtro = filtro || ' WHERE p.codigo_proveedor = ' || codigo_proveedor_aux::text || ' ';
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



SELECT * FROM obtener_reporte_proveedores(NULL) 
AS 
(	
	codigo_proveedor INT,
	nombre_proveedor CHARACTER VARYING(200),
	estado_proveedor CHARACTER(1),
	nit_proveedor 	 CHARACTER(15),
	descripcion 	 TEXT
);

