package controlador;

public class CondicionMenor implements ConditionObserver {

    private Double valorCondicionante;
    boolean estadoCondicion = false;
    private Regla miRegla = null;

public CondicionMenor (Double valor)    {

    this.valorCondicionante = valor;
}

public void agregarRegla (Regla unaRegla) {

    miRegla = unaRegla;
}

public int validacion (Double unValor){
    return this.valorCondicionante.compareTo(unValor);
}

public boolean getEstado() { return estadoCondicion; }

public void Update(Double unValor)  {
    if (1 == validacion(unValor)) {

        this.setEstado(true);
        Regla unaRegla = new Regla();
        unaRegla.actuar();
    }
    else {
        this.setEstado(false);
    }
}

public void setEstado (boolean vof) {
    this.estadoCondicion = vof;
}
}