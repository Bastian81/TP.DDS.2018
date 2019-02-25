package estado;

import dispositivo.Inteligente;

public class Ahorro extends Estado {

    public Ahorro(String nombre, int id) {
        super(nombre, id);
    }

    public void apagar(Inteligente dispInteligente) {dispInteligente.cambiarEstado(new Apagado(nombre,id));}
    public void encender(Inteligente dispInteligente) {dispInteligente.cambiarEstado(new Encendido(nombre,id));}
    public void modoAhorro(Inteligente dispInteligente) {}

    public Boolean estaEncendido() {return true;}

    public double porcentajeAhorroConsumo() {return 0.5;}
}
