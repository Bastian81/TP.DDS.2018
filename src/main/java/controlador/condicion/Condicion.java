package controlador.condicion;

import controlador.Observer;
import controlador.Regla;
import controlador.Sensor;

public abstract class Condicion extends Observer {

    String nombre;
    Double valorCondicionante;
    boolean estadoCondicion = false;
    Regla miRegla;

public Condicion(String nombreCondicion, Double valor, Regla unaRegla, Sensor sensorAObservar)
{
    super(sensorAObservar);
    nombre = nombreCondicion;
    valorCondicionante = valor;
    miRegla = unaRegla;
    unaRegla.agregarCondicion(this);
}

public int validacion (Double unValor)
{
    return this.valorCondicionante.compareTo(unValor);
}

public boolean getEstado() { return estadoCondicion; }

public void setEstado (boolean vof) { this.estadoCondicion = vof; }


}