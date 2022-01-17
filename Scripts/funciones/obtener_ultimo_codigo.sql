CREATE OR REPLACE FUNCTION obtener_ultimo_codigo(nombre_tabla character varying)
  RETURNS integer AS
$BODY$
DECLARE	
	codigo_secuencial INTEGER;
	nro_filas	   INT;
BEGIN 

	IF(nombre_tabla = 'categorias_comidas') THEN
	   SELECT last_value into codigo_secuencial 
	   FROM categorias_comidas_codigo_categoria_seq 
	   ORDER BY last_value
	   DESC LIMIT 1 OFFSET 0;

	   SELECT COUNT(*) into nro_filas 
	   FROM categorias_comidas;
	   
	ELSIF (nombre_tabla = 'comidas') THEN
	   SELECT last_value into codigo_secuencial 
	   FROM comidas_codigo_comida_seq 
	   ORDER BY last_value
	   DESC LIMIT 1 OFFSET 0;

	   SELECT COUNT(*) into nro_filas 
	   FROM comidas;
	ELSIF (nombre_tabla = 'documentos') THEN
	   SELECT last_value into codigo_secuencial 
	   FROM documentos_codigo_documento_seq 
	   ORDER BY last_value
	   DESC LIMIT 1 OFFSET 0;

	   SELECT COUNT(*) into nro_filas 
	   FROM documentos;

	ELSIF (nombre_tabla = 'egresos') THEN
	   SELECT last_value into codigo_secuencial 
	   FROM egresos_codigo_egreso_seq 
	   ORDER BY last_value
	   DESC LIMIT 1 OFFSET 0;

	   SELECT COUNT(*) into nro_filas 
	   FROM egresos;

	ELSIF (nombre_tabla = 'empleos') THEN
	   SELECT last_value into codigo_secuencial 
	   FROM empleos_codigo_empleo_seq 
	   ORDER BY last_value
	   DESC LIMIT 1 OFFSET 0;

	   SELECT COUNT(*) into nro_filas 
	   FROM empleos;


	ELSIF (nombre_tabla = 'ingresos') THEN
	   SELECT last_value into codigo_secuencial 
	   FROM ingresos_codigo_ingreso_seq 
	   ORDER BY last_value
	   DESC LIMIT 1 OFFSET 0;

	   SELECT COUNT(*) into nro_filas 
	   FROM ingresos;
	   
	ELSIF (nombre_tabla = 'ingresos_tipos') THEN
	   SELECT last_value into codigo_secuencial 
	   FROM ingresos_tipos_codigo_ingreso_tipo_seq 
	   ORDER BY last_value
	   DESC LIMIT 1 OFFSET 0;

	   SELECT COUNT(*) into nro_filas 
	   FROM ingresos_tipos;
	   
	ELSIF (nombre_tabla = 'instituciones') THEN
	   SELECT last_value into codigo_secuencial 
	   FROM instituciones_codigo_institucion_seq 
	   ORDER BY last_value
	   DESC LIMIT 1 OFFSET 0;

	   SELECT COUNT(*) into nro_filas 
	   FROM instituciones;

	ELSIF (nombre_tabla = 'menus_comidas') THEN
	   SELECT last_value into codigo_secuencial 
	   FROM menus_comidas_codigo_menu_comida_seq 
	   ORDER BY last_value
	   DESC LIMIT 1 OFFSET 0;

	   SELECT COUNT(*) into nro_filas 
	   FROM menus_comidas;

	ELSIF (nombre_tabla = 'menus_comidas_detalle') THEN
	   SELECT last_value into codigo_secuencial 
	   FROM menus_comidas_detalle_codigo_menu_comida_detalle_seq 
	   ORDER BY last_value
	   DESC LIMIT 1 OFFSET 0;

	   SELECT COUNT(*) into nro_filas 
	   FROM menus_comidas_detalle;

	ELSIF (nombre_tabla = 'parentescos') THEN
	   SELECT last_value into codigo_secuencial 
	   FROM parentescos_codigo_parentesco_seq 
	   ORDER BY last_value
	   DESC LIMIT 1 OFFSET 0;

	   SELECT COUNT(*) into nro_filas 
	   FROM parentescos;


	ELSIF (nombre_tabla = 'personas') THEN
	   SELECT last_value into codigo_secuencial 
	   FROM personas_codigo_persona_seq 
	   ORDER BY last_value
	   DESC LIMIT 1 OFFSET 0;

	   SELECT COUNT(*) into nro_filas 
	   FROM personas;
	   
	ELSIF (nombre_tabla = 'personas_kardex') THEN
	   SELECT last_value into codigo_secuencial 
	   FROM personas_kardex_codigo_kardex_seq 
	   ORDER BY last_value
	   DESC LIMIT 1 OFFSET 0;

	   SELECT COUNT(*) into nro_filas 
	   FROM personas_kardex;
	   
	ELSIF (nombre_tabla = 'proveedores') THEN
	   SELECT last_value into codigo_secuencial 
	   FROM proveedores_codigo_proveedor_seq 
	   ORDER BY last_value
	   DESC LIMIT 1 OFFSET 0;

	   SELECT COUNT(*) into nro_filas 
	   FROM proveedores;
	   
	ELSIF (nombre_tabla = 'usuarios') THEN
	   SELECT last_value into codigo_secuencial 
	   FROM usuarios_codigo_usuario_seq 
	   ORDER BY last_value
	   DESC LIMIT 1 OFFSET 0;

	   SELECT COUNT(*) into nro_filas 
	   FROM usuarios;
	   
	ELSIF (nombre_tabla = 'informes') THEN
	   SELECT last_value into codigo_secuencial 
	   FROM informes_codigo_informe_seq 
	   ORDER BY last_value
	   DESC LIMIT 1 OFFSET 0;

	   SELECT COUNT(*) into nro_filas 
	   FROM informes;

	 ELSIF (nombre_tabla = 'informe_psicologico') THEN
	   SELECT last_value into codigo_secuencial 
	   FROM informe_psicologico_codigo_informe_psico_seq 
	   ORDER BY last_value
	   DESC LIMIT 1 OFFSET 0;

	   SELECT COUNT(*) into nro_filas 
	   FROM informe_psicologico;


	 ELSIF (nombre_tabla = 'propiedades_tipos') THEN
	   SELECT last_value into codigo_secuencial 
	   FROM propiedades_tipos_numero_propiedad_tipo_seq 
	   ORDER BY last_value
	   DESC LIMIT 1 OFFSET 0;

	   SELECT COUNT(*) into nro_filas 
	   FROM propiedades_tipos;

	 ELSIF (nombre_tabla = 'propiedades_historial_clinico') THEN
	   SELECT last_value into codigo_secuencial 
	   FROM propiedades_historial_clinico_numero_propiedad_seq 
	   ORDER BY last_value
	   DESC LIMIT 1 OFFSET 0;

	   SELECT COUNT(*) into nro_filas 
	   FROM propiedades_historial_clinico;
	   
	ELSIF (nombre_tabla = 'historia_clinico') THEN
	   SELECT last_value into codigo_secuencial 
	   FROM historia_clinico_numero_hc_seq 
	   ORDER BY last_value
	   DESC LIMIT 1 OFFSET 0;

	   SELECT COUNT(*) into nro_filas 
	   FROM historia_clinico;
	   
	ELSIF (nombre_tabla = 'consulta') THEN
	   SELECT last_value into codigo_secuencial 
	   FROM consulta_numero_consulta_seq 
	   ORDER BY last_value
	   DESC LIMIT 1 OFFSET 0;

	   SELECT COUNT(*) into nro_filas 
	   FROM consulta;
	   
	ELSIF (nombre_tabla = 'historia_clinico_consulta_detalle') THEN
	   SELECT last_value into codigo_secuencial 
	   FROM historia_clinico_consulta_detall_numero_hc_consulta_detalle_seq	postgres 
	   ORDER BY last_value
	   DESC LIMIT 1 OFFSET 0;

	   SELECT COUNT(*) into nro_filas 
	   FROM historia_clinico_consulta_detalle;
	     
	END IF;

   
    	   
   IF(nro_filas = 0 and codigo_secuencial = 1) THEN
	codigo_secuencial := 1;
   END IF;
   RETURN codigo_secuencial;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION obtener_ultimo_codigo(character varying)
  OWNER TO postgres;