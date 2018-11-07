package geoposicionamiento;

import javax.persistence.*;

@Embeddable
@Table (name = "Posiciones")
public class Posicion {

    public double latitud;
    public double longitud;
/*
    @Id
    @GeneratedValue
    int idPosicion;
*/
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
