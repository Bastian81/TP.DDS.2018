package controlador.actuador;

import dispositivo.Inteligente;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class AhorrarDisp extends Actuador{

	/*@Id
	@GeneratedValue
	int idAhorro;*/

	String nombreAhorro;

	public AhorrarDisp(String nombre, Inteligente disp){
		super(disp);
		nombreAhorro = nombre;
	}

	public void actuar() {
		dispositivo.modoAhorro();
	}
}