CREATE OR REPLACE FUNCTION obtener_historial_clinico_detalle(
	numero_hc_aux		INT,
	numero_consulta_aux	INT
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
		  phc.numero_propiedad, 
		  phc.nombre_propiedad, 
		  phc.abreviacion, 
		  phc.composicion, 
		  phc.descripcion, 
		  pt.nombre_propiedad_tipo, 
		  pt.descripcion, 
		  pt.numero_propiedad_tipo, 
		  hccd.numero_hc_consulta_detalle, 
		  hccd.numero_hc, 
		  hccd.numero_consulta, 
		  hccd.fecha_registro, 
		  hccd.descripcion
		FROM 
		  public.historia_clinico_consulta_detalle hccd,
		  public.propiedades_historial_clinico phc,
		  public.propiedades_tipos pt  
		WHERE hccd.numero_propiedad = phc.numero_propiedad
		AND phc.numero_propiedad_tipo = pt.numero_propiedad_tipo
		';
	filtro = ' ';
	IF numero_hc_aux IS NOT NULL THEN
		filtro = filtro || ' AND hccd.numero_hc = ' || numero_hc_aux::text || ' ';
	END IF;

	IF numero_consulta_aux IS NOT NULL THEN
		filtro = filtro || ' AND hccd.numero_consulta = ' || numero_consulta_aux::text || ' ';
	END IF;

	-- IF fecha_inicio IS NOT NULL AND fecha_fin IS NOT NULL  THEN
-- 		filtro = filtro || ' AND c.fecha_consulta BETWEEN ''' || fecha_inicio::text || ''' AND ''' || fecha_fin::text || ''' ';
-- 	END IF;
	
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


SELECT * FROM obtener_historial_clinico_detalle(1, 1) 
AS 
(
  numero_propiedad		INTEGER, 
  nombre_propiedad		CHARACTER VARYING(150), 
  abreviacion			CHARACTER VARYING(100),	 
  composicion			CHARACTER VARYING(200), 
  descripcion_hc_propiedad	TEXT, 
  nombre_propiedad_tipo		CHARACTER VARYING(200), 
  descripcion_propiedad		TEXT, 
  numero_propiedad_tipo		INTEGER, 
  numero_hc_consulta_detalle	INTEGER, 
  numero_hc			INTEGER, 
  numero_consulta		INTEGER, 
  fecha_registro		DATE, 
  descripcion_detalle		TEXT
)

