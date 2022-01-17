CREATE OR REPLACE FUNCTION ftg_comidas() RETURNS TRIGGER AS $personas$
    BEGIN

        IF (TG_OP = 'INSERT') THEN

	    IF(EXISTS (SELECT * FROM comidas WHERE trim(upper(nombre_comida)) = (upper(new.nombre_comida)))) THEN
		RAISE EXCEPTION 'El nombre de la comida ya se encuentra registrado';
	    END IF;
	    
            
            RETURN NEW;
        END IF;

        IF(TG_OP = 'UPDATE') THEN
	    IF(EXISTS (SELECT * FROM comidas WHERE trim(upper(nombre_comida)) = (upper(new.nombre_comida))
	    AND NEW.codigo_comida <> codigo_comida)) THEN
		RAISE EXCEPTION 'El nombre de la comida ya se encuentra registrado';
	    END IF;   
            
            RETURN NEW;
        END IF;

        RETURN NULL; -- result is ignored since this is an AFTER trigger
    END;
$personas$ LANGUAGE plpgsql;

CREATE TRIGGER tg_comidas
BEFORE INSERT OR UPDATE ON comidas
    FOR EACH ROW EXECUTE PROCEDURE ftg_comidas();

-- UPDATE comidas set nombre_comida = upper(nombre_comida)
