package controlador.actuador;

import dispositivo.Inteligente;



public class EncenderDisp extends Actuador{

	String nombreEncender;

	public EncenderDisp(String nombre, Inteligente disp){
		super(disp);
		nombreEncender = nombre;
	}

	public void actuar() {
		dispositivo.encender();
	}
}