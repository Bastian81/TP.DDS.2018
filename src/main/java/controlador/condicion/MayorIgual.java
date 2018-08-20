package controlador.condicion;

import controlador.Regla;
import controlador.Sensor;

public class MayorIgual extends Condicion{

public MayorIgual(Double valor, Regla unaRegla, Sensor sensorAObservar)
{
    super(valor, unaRegla, sensorAObservar);
}

public void Update()  {

    Double unValor = ((Sensor)subject).getValorTomado();

    if (0 == this.validacion(unValor)) {

        this.setEstado(true);
        super.miRegla.actuar();

    }
    if (-1 == this.validacion(unValor)) {

        this.setEstado(true);
        super.miRegla.actuar();

    }
    else {
        this.setEstado(false);
    }
}
}