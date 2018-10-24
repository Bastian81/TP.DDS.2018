package geoposicionamiento;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Embeddable
public class Posicion {

    public double latitud;
    public double longitud;

    /*@Id
    @GeneratedValue
    int idPosicion;*/

public Posicion(){}

public Posicion (double unaLatitud, double unaLongitud){

    latitud = unaLatitud;
    longitud = unaLongitud;

}

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }
}
