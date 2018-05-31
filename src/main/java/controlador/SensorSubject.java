package controlador;

import java.math.BigDecimal;

public interface SensorSubject {

    public void attach(RuleObserver observador);
    public void detach(RuleObserver observador);
    public void notify(BigDecimal unValor);
}
