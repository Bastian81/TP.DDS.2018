package geoposicionamiento;

import general.Cliente;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

@Entity
public class ZonaGeografica {

    String nombreZona;

    @Transient
    Posicion posicionZona;

    double radioZona;

    @OneToMany(mappedBy = "zona", cascade = CascadeType.ALL)
    //@JoinColumn(name = "idTrasnformador")
    public List<Transformador> transformadores = new ArrayList<>();

    @Id
    @GeneratedValue
    int zonaId;


public ZonaGeografica(String nombre, double unaLatitud, double unaLongitud, double radio) {

    nombreZona = nombre;
    double latitud = unaLatitud;
    double longitud = unaLongitud;
    posicionZona = new Posicion(latitud, longitud);
    radioZona = radio;

}

public Posicion getPosicion() {return posicionZona;}
public double radioZona() {return radioZona;}
public List<Transformador> transformadores() {return transformadores;}

    //Metodo para saber si un cliente pertenece a una zona geografica
public Boolean clientePertenece(Cliente unCliente)
{
    // Un cliente pertenece a una zona si la distancia de su posicion al centro de la zona es menor al radio de la zona.
    double distanciaZonaCasa;
    distanciaZonaCasa = this.distanciaKM(unCliente.getPosicion(),this.getPosicion());
    if(distanciaZonaCasa <= this.radioZona())
    {
        return true;
    }
    return false;
}

public Transformador asignarTransformador (Cliente unCliente)
{
    // Asigna a un cliente el transformador mas cercano

    ArrayList<Double> aux = new ArrayList<>(); // En aux se guardan todas las distancias entre Cliente-Transformadores

    for(Transformador transformador: transformadores)
    {
        aux.add(this.distanciaKM(transformador.getPosicion(), unCliente.getPosicion()));
    }

    Collections.sort(aux);

    for(Transformador transformador: transformadores)
    {
        if( this.distanciaKM(transformador.getPosicion(), unCliente.getPosicion()) == aux.get(0) )
            {
                return transformador;
            }
    }

    return null;
}

public boolean existeOtroMasCercano(Posicion casaCliente, Posicion transformadorActual, List<Transformador> listaTransformadores)
{
    double distanciaActual = this.distanciaKM(casaCliente,transformadorActual);


    if(listaTransformadores.stream().anyMatch(t -> ((this.distanciaKM(t.getPosicion(),casaCliente)) < distanciaActual))) {
        return true;
    }
    return false;
}



public void agregarTransformador (Transformador transformador)
{
        Transformador transformadorDesignado;
        this.transformadores().add(transformador);
        for(Transformador transformador1: this.transformadores()) //Se deben actualizar los clientes de c/transformador
        {
            for(Cliente cliente: transformador1.getClientes())
            {
                if(this.existeOtroMasCercano(cliente.getPosicion(),transformador1.getPosicion(), this.transformadores)) //Si hay un T mas cercano
                {
                    transformador1.getClientes().remove(cliente); //elimina al cliente de T
                    transformadorDesignado = this.asignarTransformador(cliente);           //Reasignalo
                    transformadorDesignado.agregarCliente(cliente);
                }
            }
        }
}

public void eliminarTransformador(Transformador unTransformador)
{
    Transformador transformadorDesignado;
    this.transformadores().remove(unTransformador);
    ArrayList<Cliente> clientesAux = new ArrayList<>();
    for(Cliente cliente: unTransformador.getClientes())
    {
        transformadorDesignado = this.asignarTransformador(cliente); // Asigna un nuevo transformador a cada cliente
        transformadorDesignado.agregarCliente(cliente);
    }
}

public static double distanciaKM(Posicion a, Posicion b)
{

    double radioTierra = 6371.0;//en kilómetros//
    double distancia;
    double casaLat;
    double casaLong;
    double tranLat;
    double tranLong;
    casaLat = a.getLatitud();
    casaLong = a.getLongitud();
    tranLat = b.getLatitud();
    tranLong = b.getLongitud();

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

public double getConsumo()
{
    double aux = 0;
    for(Transformador transformador : this.transformadores())
    {
        aux += transformador.getConsumo();
    }
    return aux;
}

}





/* CODIGO VIEJO
public void actualizarAsignacion()
{

    this.vaciarTransformadores();
    clientes.forEach(cliente -> this.asignarTransformador(cliente));

}
/*

 */
/*
public void asignarTransformador (Cliente unCliente) {

    transformadorCercano(unCliente).agregarCliente(unCliente);

}

public void vaciarTransformadores()
{

        for (Transformador transformador: this.transformadores())
        {
            transformador.vaciarTransformador();
        }

    }

public Transformador transformadorCercano (Cliente unCliente) {

    int i;
    double max = 0.0;
    final double finalMax;
    List<Double> distancias = new ArrayList<Double>();
    distancias = distanciaTransformadores(unCliente);


    for(i=0; i < distancias.size(); i++) {

        if(distancias.get(i) >= max) {
            max = distancias.get(i);
        }
    }

    finalMax = max;
    return transformadores.stream()
                        .filter(transformador -> this.distanciaTransformador(unCliente, transformador) == finalMax)
                        .findFirst()
                        .get();
}

public double distanciaTransformador (Cliente unCliente, Transformador unTransformador) {

    return distanciaKM(unCliente.getPosicion(), unTransformador.getPosicion());

}

public List<Double> distanciaTransformadores (Cliente unCliente) {

    return transformadores.stream()
            .map(transformador -> distanciaKM(unCliente.getPosicion(), transformador.getPosicion()))
            .collect(Collectors.toList());

}
*/
