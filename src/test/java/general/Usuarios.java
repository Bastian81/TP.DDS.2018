package general;

public class Usuarios {
		
	public String nombre;
	public String apellido;
	public String nombreUsuario;
	public String contraseņa;
	public String domicilio;
	
	
	// Constructor
	public Usuarios(String nom, String ap, String nomUsuario, String contra, String domicilio) 
	{
		this.nombre = nom;
		this.apellido = ap;
		this.nombreUsuario = nomUsuario;
		this.contraseņa = contra;
		this.domicilio = domicilio;
	}
}
