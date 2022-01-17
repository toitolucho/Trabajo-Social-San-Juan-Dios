CREATE OR REPLACE FUNCTION listar_informe_reporte(
	codigo_informe_aux	INT
)
RETURNS SETOF RECORD
AS
$body$
DECLARE 
	registros2		RECORD;
BEGIN
	FOR registros2 IN 
		SELECT 	i.codigo_informe, i.codigo_kardex, i.codigo_institucion, i.codigo_tipo_informe, 
			i.codigo_persona_dirigido, i.codigo_persona_via, i.codigo_persona_de_01, 
			i.codigo_persona_de_02, i.codigo_persona_de_03, i.referencia, i.fecha_registro, 
			i.fecha_envio, i.diagnostico, i.sugerencias, 
			id.referencia_caso, id.fecha_inicio, id.fecha_fin, id.situacion_habitacional, 
			id.integracion_familiar, id.desarrollo_afectivo, id.historia_social, id.situacion_actual, 
			id.fuentes_informacion, id.descripcion_caso, id.documentos_adjuntos, p1.nombres || ' ' || p1.paterno || ' ' || p1.materno as nombre_completo_nino,
			pdn.fecha_nacimiento as fecha_nacimiento_nino, pdn.edad as edad_nino,
			pa.nombre_pais, dp.nombre_departamento, pro.nombre_provincia, lu.nombre_lugar,
			pea.nombres || ' ' || pea.paterno || ' ' || pea.materno as nombre_completo_A,
			peVIA.nombres || ' ' || peVIA.paterno || ' ' || peVIA.materno as nombre_completo_VIA,
			peDe01.nombres || ' ' || peDe01.paterno || ' ' || peDe01.materno as nombre_completo_de01,
			peDe02.nombres || ' ' || peDe02.paterno || ' ' || peDe02.materno as nombre_completo_de02,
			peDe03.nombres || ' ' || peDe03.paterno || ' ' || peDe03.materno as nombre_completo_de03,
			'2º Sección - Kinder "Nazareno"'::text as escolaridad, 'Hogar "Tata Juan de Dios"'::text as Domicilio_actual,
			pk.motivo_ingreso, pk.fecha_ingreso, UPPER(emp1.nombre_empleo), UPPER(emp2.nombre_empleo),
			UPPER(emp3.nombre_empleo), UPPER(emp4.nombre_empleo), UPPER(emp5.nombre_empleo)
			
		FROM informes i
		LEFT JOIN informes_detalle id
		on i.codigo_informe = id.codigo_informe
		LEFT JOIN personas_kardex pk
		ON pk.codigo_kardex = i.codigo_kardex
		LEFT JOIN personas p1
		on pk.codigo_persona = p1.codigo_persona
		LEFT JOIN personas_datos_nacimiento pdn
		on p1.codigo_persona = pdn.codigo_persona
		left join paises pa
		on pa.codigo_pais = pdn.codigo_paisn
		left join departamentos dp
		on dp.codigo_pais = pdn.codigo_paisn
		and dp.codigo_departamento = pdn.codigo_departamenton
		left join provincias pro
		on pro.codigo_pais = pdn.codigo_paisn 
		and pro.codigo_departamento = pdn.codigo_departamenton
		and pro.codigo_provincia = pdn.codigo_provincian
		left join lugares lu
		on lu.codigo_pais = pdn.codigo_paisn 
		and lu.codigo_departamento = pdn.codigo_departamenton
		and lu.codigo_provincia = pdn.codigo_provincian
		and lu.codigo_lugar = pdn.codigo_lugarn
		LEFT JOIN personas peA
		on peA.codigo_persona = i.codigo_persona_dirigido
		LEFT JOIN personas peVIA
		on peVIA.codigo_persona = i.codigo_persona_via
		LEFT JOIN personas peDe01
		on peDe01.codigo_persona = i.codigo_persona_de_01
		LEFT JOIN personas peDe02
		on peDe02.codigo_persona = i.codigo_persona_de_02
		LEFT JOIN personas peDe03
		on peDe03.codigo_persona = i.codigo_persona_de_03
		left join empleos emp1
		on emp1.codigo_empleo = pea.codigo_empleo
		left join empleos emp2
		on emp2.codigo_empleo = peVIA.codigo_empleo
		left join empleos emp3
		on emp3.codigo_empleo = peDe01.codigo_empleo
		left join empleos emp4
		on emp4.codigo_empleo = peDe02.codigo_empleo
		left join empleos emp5
		on emp5.codigo_empleo = peDe03.codigo_empleo
		WHERE i.codigo_informe = codigo_informe_aux
		
		
	LOOP
		RETURN next registros2;
	END LOOP;
	RETURN;
END;
$body$ LANGUAGE 'plpgsql' VOLATILE;


-- 
-- SELECT * FROM listar_informe_reporte(1) 
-- AS 
-- (
-- 	codigo_informe 		INTEGER, 
-- 	codigo_kardex		INTEGER, 
-- 	codigo_institucion	INTEGER, 
-- 	codigo_tipo_informe	CHARACTER(1), 
-- 	codigo_persona_dirigido	INTEGER, 
-- 	codigo_persona_via	INTEGER, 
-- 	codigo_persona_de_01	INTEGER, 
-- 	codigo_persona_de_02	INTEGER, 
-- 	codigo_persona_de_03	INTEGER, 
-- 	referencia		TEXT, 
-- 	fecha_registro		DATE, 
-- 	fecha_envio		DATE, 
-- 	diagnostico		TEXT, 
-- 	sugerencias		TEXT, 
-- 	referencia_caso		TEXT, 
-- 	fecha_inicio		DATE, 
-- 	fecha_fin		DATE, 
-- 	situacion_habitacional	TEXT, 
-- 	integracion_familiar	TEXT, 
-- 	desarrollo_afectivo	TEXT, 
-- 	historia_social		TEXT, 
-- 	situacion_actual	TEXT, 
-- 	fuentes_informacion	TEXT, 
-- 	descripcion_caso	TEXT, 
-- 	documentos_adjuntos	TEXT, 
-- 	nombre_completo_nino	TEXT,
-- 	fecha_nacimiento_nino	DATE, 
-- 	edad_nino		INTEGER,
-- 	nombre_pais		CHARACTER VARYING(250), 
-- 	nombre_departamento	CHARACTER VARYING(250), 
-- 	nombre_provincia	CHARACTER VARYING(250), 
-- 	nombre_lugar		CHARACTER VARYING(250),
-- 	nombre_completo_A	TEXT,
-- 	nombre_completo_VIA	TEXT,
-- 	nombre_completo_de01	TEXT,
-- 	nombre_completo_de02	TEXT,
-- 	nombre_completo_de03	TEXT,
-- 	escolaridad		TEXT, 
-- 	Domicilio_actual	TEXT,
-- 	motivo_ingreso		TEXT, 
-- 	fecha_ingreso		DATE,
-- 	nombre_empleoA		TEXT,
-- 	nombre_empleoVIA	TEXT,
-- 	nombre_empleoDe01	TEXT,
-- 	nombre_empleoDe02	TEXT,
-- 	nombre_empleoDe03	TEXT
-- )
