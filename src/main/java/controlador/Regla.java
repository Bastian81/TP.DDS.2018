package controlador;

import java.util.ArrayList;

public class Regla {

    static ArrayList<Actuador> actuadores = new ArrayList<Actuador>();
    static ArrayList<CondicionMayor> condiciones = new ArrayList<CondicionMayor>();

/*public void agregarCondicion(ConditionObserver condicion) {

    condiciones.add(condicion);
}

public void agregarActuador(Actuador actuador) {

    actuadores.add(actuador);
}*/

public static boolean cumpleRegla() {

    return condiciones.stream().allMatch(condicion -> condicion.getEstado());
}

public static void actuar(){

    if( this.cumpleRegla() ) {

        actuadores.stream().forEach(actuador -> actuador.actuar());
    }
}
}
