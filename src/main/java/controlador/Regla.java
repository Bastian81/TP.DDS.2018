package controlador;

import java.util.ArrayList;

public class Regla {

    ArrayList<Actuador> actuadores = new ArrayList<Actuador>();
    ArrayList<ConditionObserver> condiciones = new ArrayList<ConditionObserver>();

public void agregarCondicion(ConditionObserver condicion) {

    condiciones.add(condicion);
    condicion.agregarRegla(this);
}

public void agregarActuador(Actuador actuador) {

    actuadores.add(actuador);
}

public boolean cumpleRegla() {

    return condiciones.stream().allMatch(condicion -> condicion.getEstado());
}

public void actuar(){

    if( this.cumpleRegla() ) {

        actuadores.forEach(actuador -> actuador.actuar());
    }
}
}
