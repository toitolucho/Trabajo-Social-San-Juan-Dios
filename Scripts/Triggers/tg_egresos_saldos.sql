CREATE OR REPLACE FUNCTION ftg_egresos_saldos() RETURNS TRIGGER AS $egresos$
    BEGIN
        --
        -- Create a row in emp_audit to reflect the operation performed on emp,
        -- make use of the special variable TG_OP to work out the operation.
        --
        IF (TG_OP = 'DELETE') THEN
            UPDATE ingresos SET monto_actual =  monto_actual + OLD.monto_salida
	    WHERE codigo_ingreso = OLD.codigo_ingreso;
            RETURN OLD;
        ELSIF (TG_OP = 'UPDATE' AND OLD.monto_salida != NEW.monto_salida) THEN
            UPDATE ingresos SET monto_actual =  monto_actual + OLD.monto_salida - NEW.monto_salida
	    WHERE codigo_ingreso = OLD.codigo_ingreso;
            RETURN NEW;
        ELSIF (TG_OP = 'INSERT') THEN
            UPDATE ingresos SET monto_actual =  monto_actual - NEW.monto_salida
	    WHERE codigo_ingreso = NEW.codigo_ingreso;
            RETURN NEW;
        END IF;
        RETURN NULL; -- result is ignored since this is an AFTER trigger
    END;
$egresos$ LANGUAGE plpgsql;

CREATE TRIGGER tg_egresos_saldos
AFTER INSERT OR UPDATE OR DELETE ON egresos
    FOR EACH ROW EXECUTE PROCEDURE ftg_egresos_saldos();

