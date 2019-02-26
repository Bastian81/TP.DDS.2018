package general;

import javax.persistence.*;


//No usar para clase abstracta: @Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
public class Usuario {

	public String nombre;
	public String apellido;
	public String username;
	public String password;

	@Id
	@GeneratedValue
	int adminId;

	public Usuario(){}
	// Constructor
	public Usuario(String nom, String ap, String nomUsuario, String contra)
	{
		this.nombre = nom;
		this.apellido = ap;
		this.username = nomUsuario;
		this.password = contra;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
}
