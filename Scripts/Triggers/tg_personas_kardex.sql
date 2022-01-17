CREATE OR REPLACE FUNCTION ftg_personas() RETURNS TRIGGER AS $personas$
    BEGIN

        IF (TG_OP = 'DELETE') THEN

	    DELETE FROM Personas_Datos_Nacimiento
	    WHERE codigo_persona = OLD.codigo_persona;
	    
	   
	    
	    DELETE FROM Personas_Kardex_Documentos
	    WHERE codigo_kardex in (	SELECT codigo_kardex FROM Personas_Kardex pk
					WHERE pk.codigo_persona = OLD.codigo_persona);

					
	    DELETE FROM Personas_Kardex_Familiares
	    WHERE codigo_kardex in (	SELECT codigo_kardex FROM Personas_Kardex pk
					WHERE pk.codigo_persona = OLD.codigo_persona);

	    DELETE FROM Personas_Kardex
	    WHERE codigo_persona = OLD.codigo_persona;

	    --DELETE FROM personas_historial_clinico;
            
            RETURN OLD;
        END IF;
        -- ELSIF (TG_OP = 'UPDATE' AND OLD.monto_salida != NEW.monto_salida) THEN
--             UPDATE ingresos SET monto_actual =  monto_actual + OLD.monto_salida - NEW.monto_salida
-- 	    WHERE codigo_ingreso = OLD.codigo_ingreso;
--             RETURN NEW;
--         ELSIF (TG_OP = 'INSERT') THEN
--             UPDATE ingresos SET monto_actual =  monto_actual - NEW.monto_salida
-- 	    WHERE codigo_ingreso = NEW.codigo_ingreso;
--             RETURN NEW;
--         END IF;
        RETURN NULL; -- result is ignored since this is an AFTER trigger
    END;
$personas$ LANGUAGE plpgsql;

CREATE TRIGGER tg_personas
BEFORE DELETE ON personas
    FOR EACH ROW EXECUTE PROCEDURE ftg_personas();
