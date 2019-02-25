package estado;


import dispositivo.Inteligente;

public class Apagado extends Estado{

    public Apagado(String nombre, int id) {
        super(nombre, id);
    }

    public void apagar(Inteligente dispInteligente) {}
    public void encender(Inteligente dispInteligente) { dispInteligente.cambiarEstado(new Encendido(nombre,id));}
    public void modoAhorro(Inteligente dispInteligente) {dispInteligente.cambiarEstado(new Ahorro(nombre,id));}

    public Boolean estaEncendido() {return false;}

    public double porcentajeAhorroConsumo() {return 0;}
}
