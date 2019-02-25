package controlador.actuador;

import dispositivo.Inteligente;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class AhorrarDisp extends Actuador{

	/*@Id
	@GeneratedValue
	int idAhorro;*/


	public AhorrarDisp(Inteligente dispositivo, String nombre, int id) {
		super(dispositivo, nombre, id);
	}

	public void actuar() {
		dispositivo.modoAhorro();
	}
}