package estado;

import dispositivo.Inteligente;

public class Ahorro implements Estado {

    public void apagar(Inteligente dispInteligente) {dispInteligente.cambiarEstado(new Apagado());}
    public void encender(Inteligente dispInteligente) {dispInteligente.cambiarEstado(new Encendido());}
    public void modoAhorro(Inteligente dispInteligente) {}

    public Boolean estaEncendido() {return true;}

    public double porcentajeAhorroConsumo() {return 0.5;}
}
