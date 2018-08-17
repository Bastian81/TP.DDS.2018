package geoposicionamiento;

import general.Cliente;

import java.util.ArrayList;

public class ZonaGeografica {

    ArrayList<Transformador> transformadores = new ArrayList<Transformador>();
    ArrayList<Cliente> clientes = new ArrayList<Cliente>();

public void agregarCliente (Cliente unCliente) {

    clientes.add(unCliente);
    this.asignarTransformador(unCliente);

}

public void asignarTransformador (Cliente unCliente) {

    transformadorCercano(unCliente).agregarCliente(unCliente);

}

public Transformador transformadorCercano (Cliente unCliente) {

    int i;
    double max = 0.0;
    double[] distancias = new double[100];
    distancias = distanciaTransformadores(unCliente);


    for(i=0; i < distancias.length; i++) {

        if(distancias[i] >= max) {
            max = distancias[i];
        }
    }
    return transformadores.stream()
                        .filter(transformador -> this.distanciaTransformador(unCliente, transformador) == max)
                        .findFirst()
                        .get();
}

public double distanciaTransformador (Cliente unCliente, Transformador unTransformador) {

    return distanciaKM(unCliente.getPosicion(), unTransformador.getPosicion());

}

public double[] distanciaTransformadores (Cliente unCliente) {

    return transformadores.stream().map(transformador -> distanciaKM(unCliente.getPosicion(), transformador.getPosicion()));

}

public void eliminarCliente (Cliente unCliente) {

    unCliente.getTransformador().eliminarCliente(unCliente);

}

public void agregarTransformador (Transformador transformador) {

    transformadores.add(transformador);
    this.actualizarAsignacion();

}

public void actualizarAsignacion() {

    this.vaciarTransformadores();
    clientes.forEach(cliente -> this.asignarTransformador(cliente));

}

public void vaciarTransformadores() {

    transformadores.forEach(transformador -> transformador.vaciarTransformador());

}

public void eliminarTransformador(Transformador unTransformador) {



}

public static double distanciaKM(Posicion casa, Posicion transformador) {

    double radioTierra = 6371.0;//en kilómetros
    double distancia;
    double casaLat;
    double casaLong;
    double tranLat;
    double tranLong;
    casa.getLatitud() = casaLat;
    casa.getLongitud() = casaLong;
    transformador.getLatitud() = tranLat;
    transformador.getLongitud() = tranLong;

    //diferencias
    double difLat = Math.toRadians(tranLat - casaLat);
    double difLong = Math.toRadians(tranLong - casaLong);

    //seno
    double senoDifLat = Math.sin(difLat / 2);
    double senoDifLng = Math.sin(difLong / 2);

    //variable 1 con cosenos y potencias
    double var1 =   Math.pow(senoDifLat, 2) +
                    Math.pow(senoDifLng, 2) *
                    Math.cos(Math.toRadians(casaLat)) *
                    Math.cos(Math.toRadians(tranLat));

    //variable 2
    double var2 = 2 * Math.atan2(Math.sqrt(var1), Math.sqrt(1 - var1));

    //calculo final
    distancia = radioTierra * var2;

    return distancia;
}

}
