package controlador;

import java.util.ArrayList;
import dispositivo.Inteligente;

public class Regla {

    ArrayList<Actuador> actuadores = new ArrayList<Actuador>();
    ArrayList<CondicionObserver> condiciones = new ArrayList<CondicionObserver>();
    Inteligente dispositivo;

public Regla (Inteligente unDispositivo) {

    dispositivo = unDispositivo;

}

public void agregarCondicion(CondicionObserver condicion) {

    condiciones.add(condicion);
}

public void agregarActuador(Actuador actuador) {

    actuadores.add(actuador);
}

public boolean cumpleRegla() {

    return condiciones.stream().allMatch(condicion -> condicion.getEstado());
}

public void actuar(){

    if( this.cumpleRegla() ) {

        actuadores.forEach(actuador -> actuador.actuar(dispositivo));
    }
}
}
