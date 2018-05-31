package controlador;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Sensor implements SensorSubject {

    private ArrayList<RuleObserver> observadores = new ArrayList<RuleObserver>();

    public void attach(RuleObserver observador) {
        observadores.add(observador);
    }

    public void detach(RuleObserver observador) {
        observadores.remove(observador);
    }

    public void medicion(BigDecimal unValor){
        this.notificar(unValor);
    }

    public void notify(BigDecimal unValor) {
        for (int i = 0; i < observadores.size(); i++){
            observadores.get(i).Update(unValor);
        }
    }
}


