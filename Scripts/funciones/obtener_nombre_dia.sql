CREATE OR REPLACE FUNCTION obtener_nombre_dia(
	numero_dia int
)
  RETURNS VARCHAR(100) AS
$BODY$
DECLARE	
	nombre_dia VARCHAR(100);
	
BEGIN 

	IF(numero_dia = 2) THEN
	   nombre_dia = 'LUNES';	   
	ELSIF (numero_dia = 3) THEN
	  nombre_dia = 'MARTES';
	ELSIF (numero_dia = 4) THEN
	  nombre_dia = 'MIERCOLES';
	ELSIF (numero_dia = 5) THEN
	  nombre_dia = 'JUEVES';
	ELSIF  (numero_dia = 6) THEN
	  nombre_dia = 'VIERNES';
	ELSIF  (numero_dia = 7) THEN
	   nombre_dia = 'SABADO';
	ELSIF  (numero_dia = 1) THEN
	   nombre_dia = 'DOMINGO';
	END IF;

   
   RETURN nombre_dia;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION  obtener_nombre_dia(numero_dia int ) OWNER TO postgres;


-- select obtener_nombre_dia(5)