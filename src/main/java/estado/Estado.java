package estado;

public interface Estado {

            //ver que significa para el sistema que el dispositivo este apagado.
            //ver si el estado va a conocer la cliente.

    public void apagar();
    public void encender();
    public void modoAhorro();
    public Boolean estaEncendido();
}
