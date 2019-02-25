package controlador.actuador;

import dispositivo.Inteligente;



public class ApagarDisp extends Actuador{


	public ApagarDisp(Inteligente dispositivo, String nombre, int id) {
		super(dispositivo, nombre, id);
	}

	public void actuar() {
		dispositivo.apagar();
	}
}