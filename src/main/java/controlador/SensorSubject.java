package controlador;

import java.math.BigDecimal;

public interface SensorSubject {

    public void attach(ConditionObserver observador);
    public void detach(ConditionObserver observador);
    public void notify(BigDecimal unValor);
}
