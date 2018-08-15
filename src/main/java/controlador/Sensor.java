package controlador;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Sensor implements SensorSubject {

    private ArrayList<ConditionObserver> observadores = new ArrayList<ConditionObserver>();

    public void attach(ConditionObserver observador) {
        observadores.add(observador);
    }

    public void detach(ConditionObserver observador) {
        observadores.remove(observador);
    }

    public void medicion(BigDecimal unValor){
        this.notify(unValor);
    }

    public void notify(BigDecimal unValor) {
        for (int i = 0; i < observadores.size(); i++){
            observadores.get(i).Update(unValor);
        }
    }
}


