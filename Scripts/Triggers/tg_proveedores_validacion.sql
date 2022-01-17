CREATE OR REPLACE FUNCTION ftg_proveedores() RETURNS TRIGGER AS $personas$
    BEGIN

        IF (TG_OP = 'INSERT') THEN

	    IF(EXISTS (SELECT * FROM proveedores WHERE trim(upper(nombre_proveedor)) = (upper(new.nombre_proveedor)))) THEN
		RAISE EXCEPTION 'El nombre de la comida ya se encuentra registrado';
	    END IF;
	    
            
            RETURN NEW;
        END IF;

        IF(TG_OP = 'UPDATE') THEN
	    IF(EXISTS (SELECT * FROM proveedores WHERE trim(upper(nombre_proveedor)) = (upper(new.nombre_proveedor))
	    AND NEW.codigo_proveedor <> codigo_proveedor)) THEN
		RAISE EXCEPTION 'El nombre de la comida ya se encuentra registrado';
	    END IF;   
            
            RETURN NEW;
        END IF;

        RETURN NULL; -- result is ignored since this is an AFTER trigger
    END;
$personas$ LANGUAGE plpgsql;

CREATE TRIGGER tg_proveedores
BEFORE INSERT OR UPDATE ON proveedores
    FOR EACH ROW EXECUTE PROCEDURE ftg_proveedores();

-- UPDATE proveedores set nombre_proveedor = upper(nombre_proveedor)
