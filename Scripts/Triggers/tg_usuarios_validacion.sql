CREATE OR REPLACE FUNCTION ftg_usuarios() RETURNS TRIGGER AS $personas$
    BEGIN

        IF (TG_OP = 'INSERT') THEN

	    IF(EXISTS (SELECT * FROM usuarios WHERE trim(upper(nombre_usuario)) = (upper(new.nombre_usuario)))) THEN
		RAISE EXCEPTION 'El nombre de la cuenta de usuarios ya se encuentra registrado';
	    END IF;
	    
            
            RETURN NEW;
        END IF;

        IF(TG_OP = 'UPDATE') THEN
	    IF(EXISTS (SELECT * FROM usuarios WHERE trim(upper(nombre_usuario)) = (upper(new.nombre_usuario))
	    AND NEW.codigo_usuario <> codigo_usuario)) THEN
		RAISE EXCEPTION 'El nombre de la cuenta de usuarios ya se encuentra registrado';
	    END IF;   
            
            RETURN NEW;
        END IF;

        RETURN NULL; -- result is ignored since this is an AFTER trigger
    END;
$personas$ LANGUAGE plpgsql;

CREATE TRIGGER tg_usuarios
BEFORE INSERT OR UPDATE ON usuarios
    FOR EACH ROW EXECUTE PROCEDURE ftg_usuarios();


-- UPDATE usuarios set nombre_usuario = upper(nombre_usuario)


