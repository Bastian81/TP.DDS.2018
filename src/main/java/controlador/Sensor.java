package controlador;

import java.util.ArrayList;
import java.util.List;

public class Sensor implements Subject{

    public boolean estado;
    public List<Regla> reglas;
    private ArrayList<Observer> observadores = new ArrayList<Observer>();

    public void attach(Observer observador) {
        observadores.add(observador);
    }

    public void detach(Observer observador) {
        observadores.remove(observador);
    }

    public void informarCambio () {
        if (this.cumpleReglas()){
            this.notificar();
        }
    }

    public boolean cumpleReglas() {

        reglas.stream().allMatch(regla -> regla.cumpleRegla());
    }

    public void notificar() {
        for (int i = 0; i < observadores.size(); i++){
            observadores.get(i).Update();
        }

    }
}


