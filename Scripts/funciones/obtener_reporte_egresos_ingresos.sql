CREATE OR REPLACE FUNCTION obtener_reporte_egresos_ingresos(
	codigo_ingreso_aux	INT, 
	codigo_ingreso_tipo_aux	INT,
	codigo_proveedor_aux 	INT, 
	codigo_partida_aux	CHARACTER(10),
	fecha_inicio		DATE,
	fecha_fin		DATE
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
		  ing.nombre_ingreso, 
		  ing.fecha_ingreso, 
		  ing.monto_ingreso, 
		  ing.monto_actual, 
		  it.nombre_ingreso_tipo, 
		  it.codigo_ingreso_tipo, 
		  p.nombre_partida, 
		  pro.nombre_proveedor, 
		  pro.nit_proveedor, 
		  egr.fecha_egreso, 
		  egr.codigo_egreso, 
		  ing.codigo_ingreso, 
		  egr.codigo_partida, 		  
		  egr.nro_factura, 
		  egr.monto_salida, 
		  egr.observaciones
		FROM 
		  public.ingresos ing, 
		  public.ingresos_tipos it, 
		  public.egresos egr, 
		  public.proveedores pro, 
		  public.partidas p
		WHERE 
		  it.codigo_ingreso_tipo = ing.codigo_ingreso_tipo AND
		  egr.codigo_partida = p.codigo_partida AND
		  egr.codigo_proveedor = pro.codigo_proveedor AND
		  egr.codigo_ingreso = ing.codigo_ingreso
		';
	filtro = ' ';
	IF codigo_ingreso_aux IS NOT NULL THEN
		filtro = filtro || ' AND ing.codigo_ingreso = ' || codigo_ingreso_aux::text || ' ';
	END IF;

	IF codigo_ingreso_tipo_aux IS NOT NULL THEN
		filtro = filtro || ' AND it.codigo_ingreso_tipo = ' || codigo_ingreso_tipo_aux::text || ' ';
	END IF;

	IF codigo_proveedor_aux IS NOT NULL THEN
		filtro = filtro || ' AND pro.codigo_proveedor = ' || codigo_proveedor_aux::text || ' ';
	END IF;

	IF codigo_partida_aux IS NOT NULL THEN
		filtro = filtro || ' AND e.codigo_partida = ''' || codigo_partida_aux || ''' ';
	END IF;

	IF fecha_inicio IS NOT NULL AND fecha_fin IS NOT NULL  THEN
		filtro = filtro || ' AND ing.fecha_ingreso BETWEEN ''' || fecha_inicio::text || ''' AND ''' || fecha_fin::text || ''' ';
	END IF;
	
	RAISE NOTICE ' FILTRO : (%)', SUBSTRING(filtro, LENGTH(filtro)-3);
	
	IF(filtro IS NOT NULL AND filtro <> ' ') THEN
		IF(SUBSTRING(filtro, LENGTH(filtro)-3) = 'AND ') THEN
			--SELECT SUBSTRING('BONITA',4,1) SELECT LENGTH('HOLA')
			filtro = SUBSTRING(filtro, 0, LENGTH(filtro)-4);
		END IF;
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


-- 
-- SELECT * FROM obtener_reporte_egresos(NULL, NULL, null, '21/01/2000' , '31/12/2015') 
-- SELECT * FROM obtener_reporte_egresos_ingresos(NULL, NULL, NULL, NULL, '21/01/2000' , '31/12/2015') 
SELECT * FROM obtener_reporte_egresos_ingresos(NULL, NULL, NULL, NULL, null , null) 
AS 
(	
	nombre_ingreso	CHARACTER VARYING(250),
	fecha_ingreso	DATE,	
	monto_ingreso	DOUBLE PRECISION,
	monto_actual	DOUBLE PRECISION,
	nombre_ingreso_tipo CHARACTER VARYING(150),
	codigo_ingreso_tipo INTEGER,
	nombre_partida	CHARACTER VARYING(250),
	nombre_proveedor CHARACTER VARYING(200),
	nit_proveedor	CHARACTER(15),
	fecha_egreso	DATE,		
	codigo_egreso	INTEGER,
	codigo_ingreso	INTEGER,
	codigo_partida	CHARACTER(10),
	nro_factura	INTEGER,
	monto_salida	DOUBLE PRECISION,
	observaciones 	TEXT
);




