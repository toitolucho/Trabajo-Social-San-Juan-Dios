CREATE OR REPLACE FUNCTION ftg_ingresos_tipos() RETURNS TRIGGER AS $personas$
    BEGIN

        IF (TG_OP = 'INSERT') THEN

	    IF(EXISTS (SELECT * FROM ingresos_tipos WHERE trim(upper(nombre_ingreso_tipo)) = (upper(new.nombre_ingreso_tipo)))) THEN
		RAISE EXCEPTION 'El nombre de la fuente de ingreso ya se encuentra registrado';
	    END IF;
	    
            
            RETURN NEW;
        END IF;

        IF(TG_OP = 'UPDATE') THEN
	    IF(EXISTS (SELECT * FROM ingresos_tipos WHERE trim(upper(nombre_ingreso_tipo)) = (upper(new.nombre_ingreso_tipo))
	    AND NEW.codigo_ingreso_tipo <> codigo_ingreso_tipo)) THEN
		RAISE EXCEPTION 'El nombre de la fuente de ingreso ya se encuentra registrado';
	    END IF;   
            
            RETURN NEW;
        END IF;

        RETURN NULL; -- result is ignored since this is an AFTER trigger
    END;
$personas$ LANGUAGE plpgsql;

CREATE TRIGGER tg_ingresos_tipos
BEFORE INSERT OR UPDATE ON ingresos_tipos
    FOR EACH ROW EXECUTE PROCEDURE ftg_ingresos_tipos();

-- UPDATE ingresos_tipos set nombre_ingreso_tipo = upper(nombre_ingreso_tipo)
