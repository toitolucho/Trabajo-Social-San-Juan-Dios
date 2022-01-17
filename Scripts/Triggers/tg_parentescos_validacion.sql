CREATE OR REPLACE FUNCTION ftg_parentescos() RETURNS TRIGGER AS $personas$
    BEGIN

        IF (TG_OP = 'INSERT') THEN

	    IF(EXISTS (SELECT * FROM parentescos WHERE trim(upper(nombre_parentesco)) = (upper(new.nombre_parentesco)))) THEN
		RAISE EXCEPTION 'El nombre del parentesco ya se encuentra registrado';
	    END IF;
	    
            
            RETURN NEW;
        END IF;

        IF(TG_OP = 'UPDATE') THEN
	    IF(EXISTS (SELECT * FROM parentescos WHERE trim(upper(nombre_parentesco)) = (upper(new.nombre_parentesco))
	    AND NEW.codigo_parentesco <> codigo_parentesco)) THEN
		RAISE EXCEPTION 'El nombre del parentesco ya se encuentra registrado';
	    END IF;   
            
            RETURN NEW;
        END IF;

        RETURN NULL; -- result is ignored since this is an AFTER trigger
    END;
$personas$ LANGUAGE plpgsql;

CREATE TRIGGER tg_parentescos
BEFORE INSERT OR UPDATE ON parentescos
    FOR EACH ROW EXECUTE PROCEDURE ftg_parentescos();

-- UPDATE parentescos set nombre_parentesco = upper(nombre_parentesco)
