package dispositivo;
import estado.Ahorro;
import estado.Apagado;
import estado.Encendido;
import estado.Estado;

import java.util.List;

public class Inteligente extends Dispositivo {

    private byte macAddress;
    private Estado estado;
    public List<Estado> listaEstados;

    public Inteligente(String nombre, Float consumo, int nroSerial, byte macAddress, Estado estado)
    {
        super(nombre,consumo,nroSerial);
        this.macAddress = macAddress;
        this.estado = estado;
    }

    // Metodos del Estado
    public Estado ultimoLista( List<Estado> listaDeEstados) {return listaDeEstados.get(listaDeEstados.size() - 1);}

    public void apagar()
    {
        estado.apagar();
        if(estado != ultimoLista(listaEstados) || listaEstados.isEmpty())
        {
            listaEstados.add(new Apagado());
        }
    }

    public void encender()
    {
        estado.encender();
        if(estado != ultimoLista(listaEstados) || listaEstados.isEmpty())
        {
            listaEstados.add(new Encendido());
        }
    }
    public void modoAhorro()
    {
        estado.modoAhorro();
        if(estado != ultimoLista(listaEstados) || listaEstados.isEmpty())
        {
            listaEstados.add(new Ahorro());
        }
    }
    public Boolean estaEncendido() {return estado.estaEncendido();}

    // Metodos para calcular el consumo

    // public float getConsumo()
    // public float consumoPeriodo(fechaInicio,fechaFin)


    public int puntos() {return 15;}

}
