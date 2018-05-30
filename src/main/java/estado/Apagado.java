package estado;


import dispositivo.Inteligente;

public class Apagado implements Estado{
    public void apagar(Inteligente dispInteligente) {}
    public void encender(Inteligente dispInteligente) { dispInteligente.cambiarEstado(new Encendido());}
    public void modoAhorro(Inteligente dispInteligente) {dispInteligente.cambiarEstado(new Ahorro());}

    public Boolean estaEncendido() {return false;}

    public double porcentajeAhorroConsumo() {return 0;};
}
