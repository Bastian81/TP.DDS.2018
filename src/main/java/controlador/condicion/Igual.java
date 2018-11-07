package controlador.condicion;

import controlador.Regla;
import controlador.Sensor;

public class Igual extends Condicion{

public Igual(String nombreCondicion, Double valor, Regla unaRegla, Sensor sensorAObservar)
{
    super(nombreCondicion, valor, unaRegla, sensorAObservar);
}

public void Update()  {

    Double unValor = ((Sensor)subject).getValorTomado();

    if (0 == this.validacion(unValor)) {

        this.setEstado(true);
        super.miRegla.actuar();

    }

    else {
        this.setEstado(false);
    }
}
}
