CREATE OR REPLACE FUNCTION obtener_nombre_mes(
	numero_mes int
)
  RETURNS VARCHAR(100) AS
$BODY$
DECLARE	
	nombre_mes VARCHAR(100);
	
BEGIN 

	IF(numero_mes = 1) THEN
	   nombre_mes = 'ENERO';	   
	ELSIF (numero_mes = 2) THEN
	  nombre_mes = 'FEBRERO';
	ELSIF (numero_mes = 3) THEN
	  nombre_mes = 'MARZO';
	ELSIF (numero_mes = 4) THEN
	  nombre_mes = 'ABRIL';
	ELSIF  (numero_mes = 5) THEN
	  nombre_mes = 'MAYO';
	ELSIF  (numero_mes = 6) THEN
	   nombre_mes = 'JUNIO';
	ELSIF  (numero_mes = 7) THEN
	   nombre_mes = 'JULIO';
	ELSIF (numero_mes = 8) THEN
	  nombre_mes = 'AGOSTO';
	ELSIF (numero_mes = 9) THEN
	  nombre_mes = 'SEPTIEMBRE';
	ELSIF (numero_mes = 10) THEN
	  nombre_mes = 'OCTUBRE';
	ELSIF  (numero_mes = 11) THEN
	  nombre_mes = 'NOVIEMBRE';
	ELSIF  (numero_mes = 12) THEN
	   nombre_mes = 'DICIEMBRE';
	
	END IF;

   
   RETURN nombre_mes;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION  obtener_nombre_mes(numero_mes int ) OWNER TO postgres;


-- select obtener_nombre_mes(10)