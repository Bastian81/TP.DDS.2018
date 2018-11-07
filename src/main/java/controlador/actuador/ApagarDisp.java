package controlador.actuador;

import dispositivo.Inteligente;



public class ApagarDisp extends Actuador{

	String nombreApagar;

	public ApagarDisp(String nombre, Inteligente disp)
	{
		super(disp);
		nombreApagar = nombre;
	}

	public void actuar() {
		dispositivo.apagar();
	}
}