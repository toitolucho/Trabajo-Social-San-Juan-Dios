CREATE OR REPLACE FUNCTION obtener_egresos_reporte(
	fecha_inicio_aux	DATE,
	fecha_fin_aux		DATE,
	codigo_partida_aux	INT,
	codigo_proveedor_aux	INT
)
RETURNS SETOF RECORD
AS
$body$
DECLARE 
	registros2		RECORD;
BEGIN
	FOR registros2 IN 

		SELECT 	p.codigo_partida, p.nombre_partida, e.fecha_registro, e.nro_factura, e.fecha_egreso, 
			e.monto_salida, e.observaciones, pro.nombre_proveedor, pro.nit_proveedor
		FROM egresos e
		INNER JOIN partidas p
		ON e.codigo_partida = p.codigo_partida
		INNER JOIN proveedores pro
		ON pro.codigo_proveedor = e.codigo_proveedor
		WHERE e.fecha_egreso between fecha_inicio_aux and fecha_fin_aux
	LOOP
		RETURN next registros2;
	END LOOP;
	RETURN;
END;
$body$ LANGUAGE 'plpgsql' VOLATILE;



-- SELECT * FROM obtener_egresos_reporte('01/01/2014','31/12/2014',3,2) 
-- AS 
-- (	codigo_partida		CHARACTER(10),
-- 	nombre_partida		CHARACTER VARYING(250),
-- 	fecha_registro		DATE,
-- 	nro_factura		INTEGER,
-- 	fecha_egreso		DATE,
-- 	monto_salida		DOUBLE PRECISION,
-- 	observaciones		TEXT,
-- 	nombre_proveedor	CHARACTER VARYING(200),
-- 	nit_proveedor		CHARACTER(15)
-- )
