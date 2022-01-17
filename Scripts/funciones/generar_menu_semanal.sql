CREATE OR REPLACE FUNCTION generar_menu_semanal(
	fecha_inicio_aux DATE, 
	fecha_fin_aux 	 DATE
)
RETURNS SETOF RECORD
AS
$body$
DECLARE 
	registros2		RECORD;
BEGIN
	FOR registros2 IN 

		SELECT  TA.nombre_categoria, TA.orden_categoria, TA.hora_inicio, TA.hora_fin, 
			(CASE WHEN c.nombre_comida IS NULL THEN ' ' ELSE c.nombre_comida END)::CHARACTER VARYING(250) AS nombre_comida,
			dia_semana::CHARACTER VARYING as dia,  mcd.fecha, mcd.cantidad_personas, mcd.precio_unitario
		FROM(
			SELECT *
			FROM
			(
				SELECT codigo_categoria, nombre_categoria, orden_categoria, hora_inicio, hora_fin
				FROM categorias_comidas cc
				WHERE cc.estado_categoria = 'A'
			) as CAT,
			(
				SELECT 'LUNES' AS dia_semana, 1 orden
				UNION
				SELECT 'MARTES',2
				UNION
				SELECT 'MIERCOLES',3
				UNION
				SELECT 'JUEVES',4
				UNION
				SELECT 'VIERNES',5
				UNION
				SELECT 'SABADO',6
				UNION
				SELECT 'DOMINGO',7
			) as SEM
		) TA		
		LEFT JOIN menus_comidas_detalle mcd
		ON TA.codigo_categoria = mcd.codigo_categoria
		AND TA.dia_semana = obtener_nombre_dia(to_char(mcd.fecha, 'D') ::int)
-- 		and mcd.fecha between '24/02/2014' AND '02/03/2014'		
		and mcd.fecha between fecha_inicio_aux AND fecha_fin_aux		
		left join comidas c
		on mcd.codigo_comida = c.codigo_comida		
		ORDER BY TA.orden_categoria, TA.orden
		


		-- 
-- 		SELECT cc.nombre_categoria, cc.orden_categoria, cc.hora_inicio, cc.hora_fin, c.nombre_comida, 
-- 			obtener_nombre_dia(to_char(mcd.fecha, 'D') ::int) as dia,  mcd.fecha, mcd.cantidad_personas, mcd.precio_unitario
-- 		FROM menus_comidas_detalle mcd
-- 		INNER JOIN comidas c
-- 		ON mcd.codigo_comida = c.codigo_comida
-- 		RIGHT JOIN categorias_comidas cc
-- 		ON mcd.codigo_categoria = cc.codigo_categoria
-- 		WHERE cc.estado_categoria = 'A'
-- 		AND mcd.fecha between '24/02/2014' AND '02/03/2014'
-- 		ORDER BY cc.orden_categoria, mcd.fecha, cc.hora_inicio
	LOOP		
		RETURN next registros2;
	END LOOP;
	RETURN;
END;
$body$ LANGUAGE 'plpgsql' VOLATILE;



SELECT * FROM generar_menu_semanal('24/02/2014', '02/03/2014') 
AS 
(	nombre_categoria	CHARACTER VARYING(200),
	orden_categoria		INTEGER,
	hora_inicio		TIME,
	hora_fin		TIME,
	nombre_comida		CHARACTER VARYING(250),
	dia			CHARACTER VARYING,
	fecha			DATE,
	cantidad_personas	INTEGER,
	precio_unitario		DOUBLE PRECISION
)

