package controlador.actuador;

import dispositivo.Inteligente;



public class AhorrarDisp implements Actuador{

	public void actuar(Inteligente dispositivo) {
		dispositivo.modoAhorro();
	}
}