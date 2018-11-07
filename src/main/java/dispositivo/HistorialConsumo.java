package dispositivo;

import estado.Estado;

import org.joda.time.DateTime;
import org.joda.time.Days;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table (name = "Historial_Consumo")
public class HistorialConsumo {

    @Id
    @GeneratedValue
    int id;

    @Transient
    Estado estadoActual;

    DateTime fechaEstado;

    HistorialConsumo(Estado estadoActual, DateTime fechaEstado)
    {
     this.estadoActual = estadoActual;
     this.fechaEstado = fechaEstado;
    }

    public Estado getEstadoActual() {return estadoActual;}
    public DateTime getFechaEstado() {return fechaEstado;}


    public double tiempoUso(List<HistorialConsumo> listaConsumo)
    {
        return Days.daysBetween(fechaEstado,fechaSiguiente(listaConsumo)).getDays()/24;
    }

    public DateTime fechaSiguiente(List<HistorialConsumo> listaConsumo)
    {
        if(fechaEstado == listaConsumo.get(listaConsumo.size() - 1).getFechaEstado())
        {
           return new DateTime();
        }
        return listaConsumo.stream().filter(historialConsumo -> fechaEstado.isBefore(historialConsumo.getFechaEstado())).collect(Collectors.toList()).get(0).getFechaEstado();
    }

}
