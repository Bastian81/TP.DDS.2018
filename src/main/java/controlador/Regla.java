package controlador;

import dispositivo.Inteligente;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Regla implements RuleObserver {

    ArrayList<Actuador> actuadores = new ArrayList<Actuador>();
    ArrayList<Condicion> condiciones = new ArrayList<Condicion>();

public void agregarCondicion(Condicion condicion) {

    condiciones.add(condicion);
}

public void agregarActuador(Condicion condicion) {

    condiciones.add(condicion);
}

public void Update(BigDecimal unValor) {
    if (this.cumpleRegla(unValor)){
        this.actuar();
    }
}

public boolean cumpleRegla(BigDecimal unValor) {
    return condiciones.stream().allMatch(condicion -> condicion.cumple(unValor))
}

public void actuar(){

    actuadores.stream().forEach(actuador -> actuador.actuar());
}
}
