package general;

public class Usuario {
		
	public String nombre;
	public String apellido;
	public String username;
	public String password;
	public String domicilio;
	
	
	// Constructor
	public Usuario(String nom, String ap, String nomUsuario, String contra, String domicilio) 
	{
		this.nombre = nom;
		this.apellido = ap;
		this.username = nomUsuario;
		this.password = contra;
		this.domicilio = domicilio;
	}
}
