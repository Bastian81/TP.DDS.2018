package estado;


import dispositivo.Inteligente;

public class Encendido extends Estado {

    public Encendido(String nombre, int id) {
        super(nombre, id);
    }

    public void apagar(Inteligente dispInteligente) { dispInteligente.cambiarEstado(new Apagado(nombre,id));}
    public void encender(Inteligente dispInteligente) {}
    public void modoAhorro(Inteligente dispInteligente) {dispInteligente.cambiarEstado(new Ahorro(nombre,id));}

    public Boolean estaEncendido() {return true;}

    public double porcentajeAhorroConsumo() {return 1;};
}
