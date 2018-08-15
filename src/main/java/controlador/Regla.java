package controlador;

import java.util.ArrayList;

public class Regla {

    ArrayList<Actuador> actuadores = new ArrayList<Actuador>();
    ArrayList<CondicionMayor> condiciones = new ArrayList<CondicionMayor>();

/*public void agregarCondicion(ConditionObserver condicion) {

    condiciones.add(condicion);
}

public void agregarActuador(Actuador actuador) {

    actuadores.add(actuador);
}*/

public boolean cumpleRegla() {

    return condiciones.stream().allMatch(condicion -> condicion.getEstado());
}

public void actuar(){

    if(this.cumpleRegla()) {

        actuadores.stream().forEach(actuador -> actuador.actuar());
    }
}
}
