package controlador.actuador;

import dispositivo.Inteligente;

public class EncenderDisp implements Actuador{
	
	public void actuar(Inteligente dispositivo) {
		dispositivo.encender();
	}
}