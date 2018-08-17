package geoposicionamiento;

public class Posicion {

    public double latitud;
    public double longitud;

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
