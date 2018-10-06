package tests;

import static org.junit.Assert.*;

import java.util.Comparator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import general.Administrador;
import datos.JSONLoader;

public class TestCargaJsonAdministradores {


	List<Administrador> administradores;
	String archivo =  "administradores.json";

	@Before
	public void intialize(){

		JSONLoader loader = new JSONLoader(archivo);
		this.administradores = loader.getAdministradores();

	}
	
	@Test
	public void testCantidadAdmins() {
		
        assertEquals(3, administradores.size());
	}
	

	@Test
	public void testMesesAdministrando() {

		administradores.sort(Comparator.
							comparingInt(Administrador::mesesAdministrando).
							reversed());

		assertTrue(administradores.get(0).mesesAdministrando()>=148);

	}



}
