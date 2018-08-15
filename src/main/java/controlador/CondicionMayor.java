package controlador;

import java.math.BigDecimal;

public class Condicion implements ConditionObserver {

    private float valorCondicionante;
    private

public void Update(BigDecimal unValor) {
    if (this.cumple(unValor)){
        Regla.cumpleRegla();
    }
}

public boolean cumple(BigDecimal unValor){

}
}
