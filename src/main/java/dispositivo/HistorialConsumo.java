package dispositivo;

import com.sun.org.apache.xpath.internal.operations.Bool;
import estado.Estado;

import org.joda.time.DateTime;

public class HistorialConsumo {
    Estado estadoActual;
    DateTime fechaEstado;

    HistorialConsumo(Estado estadoActual, DateTime fechaEstado)
    {
     this.estadoActual = estadoActual;
     this.fechaEstado = fechaEstado;
    }

    public Estado getEstadoActual() {return estadoActual;}
    public DateTime getFechaEstado() {return fechaEstado;}

}
