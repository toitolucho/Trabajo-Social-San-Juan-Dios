CREATE OR REPLACE FUNCTION ftg_categorias_comidas() RETURNS TRIGGER AS $personas$
    BEGIN

       IF (TG_OP = 'INSERT') THEN

	    IF(EXISTS (SELECT * FROM categorias_comidas WHERE trim(upper(nombre_categoria)) = (upper(new.nombre_categoria)))) THEN
		RAISE EXCEPTION 'El nombre de la categoria ya se encuentra registrado';
	    END IF;
	    
            
            RETURN NEW;
        END IF;

        IF(TG_OP = 'UPDATE') THEN
	    IF(EXISTS (SELECT * FROM categorias_comidas WHERE trim(upper(nombre_categoria)) = (upper(new.nombre_categoria))
	    AND NEW.codigo_categoria <> codigo_categoria)) THEN
		RAISE EXCEPTION 'El nombre de la categoria ya se encuentra registrado';
	    END IF;   
            
            RETURN NEW;
        END IF;

        RETURN NULL; -- result is ignored since this is an AFTER trigger
    END;
$personas$ LANGUAGE plpgsql;

CREATE TRIGGER tg_categorias_comidas
BEFORE INSERT OR UPDATE ON categorias_comidas
    FOR EACH ROW EXECUTE PROCEDURE ftg_categorias_comidas();

