package geoposicionamiento;

import general.Cliente;

import java.util.ArrayList;
import java.util.List;

public class Transformador {

    Posicion posicion;
    ArrayList<Cliente> clientes = new ArrayList<Cliente>();

public Transformador (double unaLatitud, double unaLongitud) {

    double latitud = unaLatitud;
    double longitud = unaLongitud;
    posicion = new Posicion(latitud, longitud);

}

public Posicion getPosicion () {
        return posicion;
    }
public ArrayList<Cliente> getClientes() {
        return clientes;
    }

public void agregarCliente (Cliente unCliente) {

    clientes.add(unCliente);

}

public void vaciarTransformador() {

    clientes.clear();

}

public void eliminarCliente (Cliente unCliente) {
    clientes.remove(unCliente);
}

}
