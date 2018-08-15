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
    if (-1 == validacion(unValor)) {

        this.setEstado(true);
        Regla.actuar();
    }
    else    {
        this.setEstado(false);
    }
}

public void setEstado (boolean vof) {
    this.estadoCondicion = vof;
}
}