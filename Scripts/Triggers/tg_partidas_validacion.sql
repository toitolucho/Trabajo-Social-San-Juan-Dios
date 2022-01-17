CREATE OR REPLACE FUNCTION ftg_partidas() RETURNS TRIGGER AS $personas$
    BEGIN

        IF (TG_OP = 'INSERT') THEN

	    IF(EXISTS (SELECT * FROM partidas WHERE trim(upper(nombre_partida)) = (upper(new.nombre_partida)))) THEN
		RAISE EXCEPTION 'El nombre de la partida ya se encuentra registrado';
	    END IF;

	    IF(EXISTS (SELECT * FROM partidas WHERE trim(upper(codigo_partida)) = (upper(new.codigo_partida)))) THEN
		RAISE EXCEPTION 'El codigo de la partida ya se encuentra registrado';
	    END IF;
            
            RETURN NEW;
        END IF;

        IF(TG_OP = 'UPDATE') THEN
	    IF(EXISTS (SELECT * FROM partidas WHERE trim(upper(nombre_partida)) = (upper(new.nombre_partida))
	    AND NEW.codigo_partida <> codigo_partida)) THEN
		RAISE EXCEPTION 'El nombre de la partida ya se encuentra registrado';
	    END IF;   
            
            RETURN NEW;
        END IF;

        RETURN NULL; -- result is ignored since this is an AFTER trigger
    END;
$personas$ LANGUAGE plpgsql;

CREATE TRIGGER tg_partidas
BEFORE INSERT OR UPDATE ON partidas
    FOR EACH ROW EXECUTE PROCEDURE ftg_partidas();

-- UPDATE partidas set nombre_partida = upper(nombre_partida)
