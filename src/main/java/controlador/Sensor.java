package controlador;

import java.util.ArrayList;

public class Sensor implements SensorSubject {

    public Double valorTomado = 0;

    private ArrayList<ConditionObserver> observadores = new ArrayList<ConditionObserver>();

    public void attach(ConditionObserver observador) {
        observadores.add(observador);
    }

    public void detach(ConditionObserver observador) {
        observadores.remove(observador);
    }

    public void medicion(Double unValor){

        valorTomado = unValor;
        this.notify(unValor);
    }

    public void notify(Double unValor) {
        for (int i = 0; i < observadores.size(); i++){
            observadores.get(i).Update(unValor);
        }
    }
}


