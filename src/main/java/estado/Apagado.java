package estado;


public class Apagado implements Estado{
    public void apagar() {}
    public void encender() {}
    public void modoAhorro() {}
    public Boolean estaEncendido() {return false;}
}
