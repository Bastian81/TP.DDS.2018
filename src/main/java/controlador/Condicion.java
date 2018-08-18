package controlador;

public class Condicion extends Observer{

    private Double valorCondicionante;
    boolean estadoCondicion = false;
    private Regla miRegla;
    private Integer tipoCondicion;

public Condicion(Double valor, Regla unaRegla, String unTipoCondicion, Sensor sensorAObservar)
{
	super(sensorAObservar);
    valorCondicionante = valor;
    miRegla = unaRegla;
    unaRegla.agregarCondicion(this);
    definirTipo(unTipoCondicion);
}

public void definirTipo (String unTipo) {

    switch (unTipo) {

        case "mayor":
            tipoCondicion = -1;
        break;

        case "mayorIgual":
            tipoCondicion = -2;
        break;

        case "menor":
            tipoCondicion = 1;
        break;

        case "menorIgual":
            tipoCondicion = 2;
        break;

        case "igual":
            tipoCondicion = 0;
        break;
    }

}

public int validacion (Double unValor){
    return this.valorCondicionante.compareTo(unValor);
}

public boolean getEstado() { return estadoCondicion; }

public void Update()  {
	
	Double unValor = ((Sensor)subject).getValorTomado();

    if(tipoCondicion == 2) {

        if (-1 == validacion(unValor)) {

            this.setEstado(true);
            miRegla.actuar();

        }
        if (0 == validacion(unValor)) {

            this.setEstado(true);
            miRegla.actuar();

        }
        else {
            this.setEstado(false);
        }

    }
    if(tipoCondicion == -2) {

        if (-1 == validacion(unValor)) {

            this.setEstado(true);
            miRegla.actuar();

        }
        if (0 == validacion(unValor)) {

            this.setEstado(true);
            miRegla.actuar();

        }
        else {
            this.setEstado(false);
        }

    }
    else {

        if (tipoCondicion == validacion(unValor)) {

            this.setEstado(true);
            miRegla.actuar();

        }
        else {
            this.setEstado(false);
        }

    }
}

public void setEstado (boolean vof) {
    this.estadoCondicion = vof;
}
}