package controlador;

import java.math.BigDecimal;

public class CondicionMayor implements ConditionObserver {

    private float valorCondicionante;

public CondicionMayor (BigDecimal valor)    {

    this.valorCondicionante = valor;
}

public boolean validacion (BigDecimal unValor){
    unValor > valorCondicionante;
}
}
