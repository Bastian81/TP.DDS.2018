package geoposicionamiento;

import dispositivo.Inteligente;
import general.Cliente;
import org.joda.time.DateTime;

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

    String nombreTransformador;

    public String getNombreTransformador() {
        return nombreTransformador;
    }

    public void setNombreTransformador(String nombreTransformador) {
        this.nombreTransformador = nombreTransformador;
    }

    public Transformador (double unaLatitud, double unaLongitud/*, int id*/) {

    double latitud = unaLatitud;
    double longitud = unaLongitud;
    posicion = new Posicion(latitud, longitud);
    //idTrasformador = id;

}

    public Transformador ( String nombreTrans, Posicion posicion, List<Cliente> clientes)
    {

        this.posicion = posicion;
        nombreTransformador = nombreTrans;
        this.clientes = clientes;
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


public float consumoPeriodo(DateTime fechaInicio, DateTime fechaFin)
    {
        float consumo = 0;

        for(Cliente cliente: this.getClientes())
            consumo+= cliente.consumoPeriodo(fechaInicio,fechaFin);

        return consumo;

    }

}
