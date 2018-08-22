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

public double getConsumo()
{
    double aux = 0;
    for(Cliente cliente : this.getClientes())
    {
        aux += cliente.consumoMensual();
    }
    return aux;

    //buscar alternativa:  return this.getClientes().sumAll({cliente -> cliente.getConsumo()});
}

public void asignarZona(List<ZonaGeografica> listaZonas)
{
    for(ZonaGeografica zonaG : listaZonas)
    {

        if(zonaG.transformadorPertenece(this))
        {
            zonaG.agregarTransformador(this);
        }
    }
}

}
