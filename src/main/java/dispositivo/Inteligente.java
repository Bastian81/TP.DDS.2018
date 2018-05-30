package dispositivo;
import estado.Ahorro;
import estado.Apagado;
import estado.Encendido;
import estado.Estado;
import org.joda.time.DateTime;

import java.util.List;

public class Inteligente extends Dispositivo {

    private byte macAddress;
    private Estado estado;
    public List<Estado> listaEstados;
    public List<DateTime> listaFechas;

    public Inteligente(String nombre, Float consumo, int nroSerial, byte macAddress, Estado estado)
    {
        super(nombre,consumo,nroSerial);
        this.macAddress = macAddress;
        this.estado = estado;
    }
    public Estado ultimoLista() {return listaEstados.get(listaEstados.size() - 1);}

    public void cambiarEstado(Estado nuevoEstado)
    {
        this.estado = nuevoEstado;
        if(estado != ultimoLista() || listaEstados.isEmpty())
        {
            listaEstados.add(nuevoEstado);
            listaFechas.add(new DateTime());
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


    // public float getConsumoPorHoras(int cantidadHoras)

    //    public float consumoPeriodo(fechaInicio,fechaFin)



    public int puntos() {return 15;}

}
