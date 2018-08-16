package controlador;

import java.util.ArrayList;

public class Sensor implements SensorSubject {

    public Double valorTomado = 0.0;

    private ArrayList<CondicionObserver> observadores = new ArrayList<CondicionObserver>();

    public void attach(CondicionObserver observador) {
        observadores.add(observador);
    }

    public void detach(CondicionObserver observador) {
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


