package estado;


import dispositivo.Inteligente;

public class Encendido implements Estado {
    public void apagar(Inteligente dispInteligente) { dispInteligente.cambiarEstado(new Apagado());}
    public void encender(Inteligente dispInteligente) {}
    public void modoAhorro(Inteligente dispInteligente) {dispInteligente.cambiarEstado(new Ahorro());}

    public Boolean estaEncendido() {return true;}

    public double porcentajeAhorroConsumo() {return 1;};
}
