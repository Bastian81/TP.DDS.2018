package controlador.actuador;

import dispositivo.Inteligente;


public abstract class Actuador {

	Inteligente dispositivo;

	public Actuador(Inteligente disp){

		dispositivo = disp;

	}

	public void actuar(){};

}
