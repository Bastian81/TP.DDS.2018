package dispositivo;
import estado.Estado;
import org.joda.time.DateTime;
import org.joda.time.Days;

import java.util.List;
import java.util.stream.Collectors;


public class Inteligente extends Dispositivo {

    private byte macAddress;
    private Estado estado;
    public List<HistorialConsumo> historialConsumo;

    public Inteligente(String nombre, Float consumo, int nroSerial, byte macAddress, Estado estado)
    {
        super(nombre,consumo,nroSerial);
        this.macAddress = macAddress;
        this.estado = estado;
    }
    public HistorialConsumo ultimoLista() {return historialConsumo.get(historialConsumo.size() - 1);}

    public void cambiarEstado(Estado nuevoEstado)
    {
        this.estado = nuevoEstado;
        if(estado != ultimoLista().getEstadoActual() || historialConsumo.isEmpty())
        {
            HistorialConsumo nuevoCambio = new HistorialConsumo(estado,new DateTime());
            historialConsumo.add(nuevoCambio);
        }
    }

    // Metodos del Estado

    public void apagar()
    {
        estado.apagar(this);
    }

    public void encender()
    {
        estado.encender(this);
    }
    public void modoAhorro()
    {
        estado.modoAhorro(this);
    }
    public Boolean estaEncendido() {return estado.estaEncendido();}



    // Metodos para calcular el consumo


    public double getConsumoPorHoras(int cantidadHoras)             //Cuanto consumio en las ultimas horas
    {
        return consumoPeriodo(obtenerFechaAnterior(cantidadHoras),new DateTime());
    }
    public DateTime obtenerFechaAnterior(int cantHoras)
    {
        return new DateTime().plusHours(-cantHoras);
    }

    public double consumoPeriodo(DateTime fechaInicio,DateTime fechaFin)       //Consumo comprendido entre dos periodos
    {
        List<HistorialConsumo> listaAux;
        listaAux = historialConsumo.stream().filter(unCambioHistorial -> betweenPeriodo(unCambioHistorial.getFechaEstado(),fechaInicio,fechaFin)).collect(Collectors.toList());
       return listaAux.stream().mapToDouble(unCambioHistorial -> calculoConsumo(unCambioHistorial,listaAux)).sum();
    }

    public double calculoConsumo(HistorialConsumo cambioHistorial, List<HistorialConsumo> listaCambiosHistorial)
    {
        return cambioHistorial.getEstadoActual().porcentajeAhorroConsumo()*this.getConsumo()*cambioHistorial.tiempoUso(listaCambiosHistorial);
    }


    public Boolean betweenPeriodo (DateTime fechaEstado,DateTime fechaInicio,DateTime fechaFin)
    {
        return fechaInicio.isBefore(fechaEstado) && fechaEstado.isBefore(fechaFin);
    }

    public Boolean esInt() {return true;}
    public int puntos() {return 15;}
}
