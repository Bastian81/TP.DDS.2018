package tests;

import java.util.List;

import general.Administrador;
import general.Categoria;
import general.Cliente;

public class DatosJSON {

	List<Cliente> clientes;
	List<Categoria> categorias;
	List<Administrador> administradores;
	
	public List<Cliente> getClientes() {
		return clientes;
	}
	
	public List<Categoria> getCategorias() {
		return categorias;
	}
	public List<Administrador> getAdministradores() {
		
		return administradores;
	}

	public void categorizarClientes() {

		clientes.forEach(cliente->cliente.setCategoria(categorias));		   
		
	}



	
}
