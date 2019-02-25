package controlador.actuador;

import dispositivo.Inteligente;


public abstract class Actuador {

	Inteligente dispositivo;
	String nombre;
	int id;

	public Actuador(Inteligente dispositivo, String nombre, int id) {
		this.dispositivo = dispositivo;
		this.nombre = nombre;
		this.id = id;
	}

	public void actuar(){};

}
