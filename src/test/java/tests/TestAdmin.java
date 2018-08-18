/*package tests;

import static org.junit.Assert.*;

import java.util.Comparator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import general.Administrador;
import helpers.FileToStringReader;
import helpers.JSONLoader;
import helpers.DatosJSON;

public class TestAdmin {

	DatosJSON datosJson;
	List<Administrador> administradores;
	

	@Before
	public void intialize(){
		
		String filePath = "src/test/resources/SGE.json";		
		FileToStringReader reader = new FileToStringReader();	
		JSONLoader loader = new JSONLoader(filePath, reader);	  	
		datosJson = loader.get();
		
		administradores = datosJson.getAdministradores();
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
*/