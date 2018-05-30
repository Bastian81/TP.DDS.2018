package estado;

import dispositivo.Inteligente;

public interface Estado {

            //ver que significa para el sistema que el dispositivo este apagado.
            //ver si el estado va a conocer la cliente.

    public void apagar(Inteligente dispInteligente);
    public void encender(Inteligente dispInteligente);
    public void modoAhorro(Inteligente dispInteligente);
    public Boolean estaEncendido();
    public double porcentajeAhorroConsumo();
}
