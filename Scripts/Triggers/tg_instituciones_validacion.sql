CREATE OR REPLACE FUNCTION ftg_instituciones() RETURNS TRIGGER AS $personas$
    BEGIN

        IF (TG_OP = 'INSERT') THEN

	    IF(EXISTS (SELECT * FROM instituciones WHERE trim(upper(nombre_institucion)) = (upper(new.nombre_institucion)))) THEN
		RAISE EXCEPTION 'El nombre de la institución ya se encuentra registrado';
	    END IF;
	    
            
            RETURN NEW;
        END IF;

        IF(TG_OP = 'UPDATE') THEN
	    IF(EXISTS (SELECT * FROM instituciones WHERE trim(upper(nombre_institucion)) = (upper(new.nombre_institucion))
	    AND NEW.codigo_institucion <> codigo_institucion)) THEN
		RAISE EXCEPTION 'El nombre de la institución ya se encuentra registrado';
	    END IF;   
            
            RETURN NEW;
        END IF;

        RETURN NULL; -- result is ignored since this is an AFTER trigger
    END;
$personas$ LANGUAGE plpgsql;

CREATE TRIGGER tg_instituciones
BEFORE INSERT OR UPDATE ON instituciones
    FOR EACH ROW EXECUTE PROCEDURE ftg_instituciones();

-- UPDATE instituciones set nombre_institucion = upper(nombre_institucion)
