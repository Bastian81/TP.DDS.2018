package controlador.actuador;

import dispositivo.Inteligente;



public class EncenderDisp extends Actuador{

	public EncenderDisp(Inteligente dispositivo, String nombre, int id) {
		super(dispositivo, nombre, id);
	}

	public void actuar() {
		dispositivo.encender();
	}
}