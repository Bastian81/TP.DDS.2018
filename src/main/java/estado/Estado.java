package estado;

import dispositivo.Inteligente;

public abstract class Estado {

            //ver que significa para el sistema que el dispositivo este apagado.
            //ver si el estado va a conocer la cliente.
    String nombre;
    int id;

    public Estado(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    public abstract void apagar(Inteligente dispInteligente);
    public abstract void encender(Inteligente dispInteligente);
    public abstract void modoAhorro(Inteligente dispInteligente);
    public abstract Boolean estaEncendido();
    public abstract double porcentajeAhorroConsumo();
}
