package general;

public abstract class Usuario {
		
	public String nombre;
	public String apellido;
	public String username;
	public String password;

	
	
	// Constructor
	public Usuario(String nom, String ap, String nomUsuario, String contra)
	{
		this.nombre = nom;
		this.apellido = ap;
		this.username = nomUsuario;
		this.password = contra;
	}
}
