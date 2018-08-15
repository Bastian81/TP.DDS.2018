package controlador;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Regla {

    ArrayList<Actuador> actuadores = new ArrayList<Actuador>();
    ArrayList<CondicionMayor> condiciones = new ArrayList<CondicionMayor>();

public void agregarCondicion(CondicionMayor condicion) {

    condiciones.add(condicion);
}

public void agregarActuador(CondicionMayor condicion) {

    actuadores.add(condicion);
}

public boolean cumpleRegla(BigDecimal unValor) {
    return condiciones.stream().allMatch(condicion -> condicion.cumple(unValor));
}

public void actuar(){

    actuadores.stream().forEach(actuador -> actuador.actuar());
}
}
