CREATE OR REPLACE FUNCTION ftg_paises() RETURNS TRIGGER AS $personas$
    BEGIN

        IF (TG_OP = 'INSERT') THEN

	    IF(EXISTS (SELECT * FROM paises WHERE trim(upper(nombre_pais)) = (upper(new.nombre_pais)))) THEN
		RAISE EXCEPTION 'El nombre del pais ya se encuentra registrado';
	    END IF;
	    
            
            RETURN NEW;
        END IF;

	IF(TG_OP = 'UPDATE') THEN
	    IF(EXISTS (SELECT * FROM paises WHERE trim(upper(nombre_pais)) = (upper(new.nombre_pais))
	    AND NEW.codigo_pais <> codigo_pais)) THEN
		RAISE EXCEPTION 'El nombre del pais ya se encuentra registrado';
	    END IF;   
            
            RETURN NEW;
        END IF;
        
        RETURN NULL; -- result is ignored since this is an AFTER trigger
    END;
$personas$ LANGUAGE plpgsql;

CREATE TRIGGER tg_paises
BEFORE INSERT OR UPDATE ON paises
    FOR EACH ROW EXECUTE PROCEDURE ftg_paises();

