package controlador;

public class CondicionMayor implements ConditionObserver {

    private Double valorCondicionante;

public CondicionMayor (Double valor)    {

    this.valorCondicionante = valor;
}

public int validacion (Double unValor){
    this.valorCondicionante.compareTo(unValor);
}

public boolean getEstado() { return estadoCondicion; }

public void Update(Double unValor)  {
    if (validacion(unValor) = -1) {

        this.estadoCondicion = true;
        Regla.actuar();
    }
    else    {
        this.estadoCondicion = false;
    }
}
}