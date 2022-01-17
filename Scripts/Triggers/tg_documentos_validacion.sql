CREATE OR REPLACE FUNCTION ftg_documentos() RETURNS TRIGGER AS $personas$
    BEGIN

        IF (TG_OP = 'INSERT') THEN

	    IF(EXISTS (SELECT * FROM documentos WHERE trim(upper(nombre_documento)) = (upper(new.nombre_documento)))) THEN
		RAISE EXCEPTION 'El nombre del documento ya se encuentra registrado';
	    END IF;
	    
            
            RETURN NEW;
        END IF;

        IF(TG_OP = 'UPDATE') THEN
	    IF(EXISTS (SELECT * FROM documentos WHERE trim(upper(nombre_documento)) = (upper(new.nombre_documento))
	    AND NEW.codigo_documento <> codigo_documento)) THEN
		RAISE EXCEPTION 'El nombre del documento ya se encuentra registrado';
	    END IF;   
            
            RETURN NEW;
        END IF;

        RETURN NULL; -- result is ignored since this is an AFTER trigger
    END;
$personas$ LANGUAGE plpgsql;

CREATE TRIGGER tg_documentos
BEFORE INSERT OR UPDATE ON documentos
    FOR EACH ROW EXECUTE PROCEDURE ftg_documentos();


-- UPDATE DOCUMENTOS set nombre_documento = UPPER(nombre_documento)