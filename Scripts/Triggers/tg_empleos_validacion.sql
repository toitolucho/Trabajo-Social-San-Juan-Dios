CREATE OR REPLACE FUNCTION ftg_empleos() RETURNS TRIGGER AS $personas$
    BEGIN

        IF (TG_OP = 'INSERT') THEN

	    IF(EXISTS (SELECT * FROM empleos WHERE trim(upper(nombre_empleo)) = (upper(new.nombre_empleo)))) THEN
		RAISE EXCEPTION 'El nombre de la empleo ya se encuentra registrado';
	    END IF;
	    
            
            RETURN NEW;
        END IF;

        IF(TG_OP = 'UPDATE') THEN
	    IF(EXISTS (SELECT * FROM empleos WHERE trim(upper(nombre_empleo)) = (upper(new.nombre_empleo))
	    AND NEW.codigo_empleo <> codigo_empleo)) THEN
		RAISE EXCEPTION 'El nombre de la empleo ya se encuentra registrado';
	    END IF;   
            
            RETURN NEW;
        END IF;

        RETURN NULL; -- result is ignored since this is an AFTER trigger
    END;
$personas$ LANGUAGE plpgsql;

CREATE TRIGGER tg_empleos
BEFORE INSERT OR UPDATE ON empleos
    FOR EACH ROW EXECUTE PROCEDURE ftg_empleos();

-- update empleos set nombre_empleo = upper(nombre_empleo)