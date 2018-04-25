package general;

public class Administrador extends Usuario {
	
	public int numId;
	//fechaDeAlta; Ver como manejar fechas en java(librerias)

	
	// Constructor
public Administrador(String nom, String ap, String nomUsuario, String contra, String domicilio, int numeroId) 
{
	super(nom,ap,nomUsuario,contra,domicilio);
	this.numId = numeroId;
}

/*
	public float mesesAdministrando() {
		return cantidadMeses;
	}
*/

}
