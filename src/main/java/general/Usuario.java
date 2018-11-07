package general;

import javax.persistence.*;


//No usar para clase abstracta: @Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
public abstract class Usuario {

	public String nombre;
	public String apellido;
	public String username;
	public String password;

	@Id
	@GeneratedValue
	int adminId;

	// Constructor
	public Usuario(String nom, String ap, String nomUsuario, String contra)
	{
		this.nombre = nom;
		this.apellido = ap;
		this.username = nomUsuario;
		this.password = contra;
	}
}
