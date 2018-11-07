package controlador.actuador;

import dispositivo.Inteligente;



public class ApagarDisp implements Actuador{

	public void actuar(Inteligente dispositivo) {
		dispositivo.apagar();
	}
}