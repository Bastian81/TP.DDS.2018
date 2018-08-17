package geoposicionamiento;

import general.Cliente;

import java.util.ArrayList;

public class Transformador {

    Posicion posicion;
    ArrayList<Cliente> clientes = new ArrayList<Cliente>();

public Transformador (double unaLatitud, double unaLongitud) {

    double latitud = unaLatitud;
    double longitud = unaLongitud;
    posicion = new Posicion(latitud, longitud);

}

public void agregarCliente (Cliente unCliente) {

    clientes.add(unCliente);
    unCliente.setTransformador(this);

}

public void vaciarTransformador() {

    clientes.clear();

}

public void eliminarCliente (Cliente unCliente) {



}

public Posicion getPosicion () {
    return posicion;
}

public ArrayList<Cliente> getClientes() {
    return clientes;
}

}
