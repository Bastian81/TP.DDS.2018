package geoposicionamiento;

import general.Cliente;

import javax.persistence.*;
import javax.persistence.criteria.Fetch;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "Transformadores")
public class Transformador {

    //@OneToMany(mappedBy = "transformador", cascade = CascadeType.ALL)
    @OneToMany(cascade=CascadeType.ALL)
    List<Cliente> clientes = new ArrayList<>();

    @Embedded
    private Posicion posicion;

    @Id
    @GeneratedValue
    //@Column(name = "idTransformador", unique = true)
    int idTrasformador;

    @ManyToOne
    //@JoinColumn(name = "zonaId", nullable = false)
    public ZonaGeografica zona;

public Transformador (double unaLatitud, double unaLongitud/*, int id*/) {

    double latitud = unaLatitud;
    double longitud = unaLongitud;
    posicion = new Posicion(latitud, longitud);
    //idTrasformador = id;

}

public Posicion getPosicion () {
        return posicion;
    }
public List<Cliente> getClientes() {
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

}
