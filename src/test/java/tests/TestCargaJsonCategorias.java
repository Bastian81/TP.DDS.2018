package tests;

import general.Categoria;

import datos.JSONLoader;
import org.junit.Before;
import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class TestCargaJsonCategorias {


	List<Categoria> categorias;
	String archivo =  "categorias.json";
	

	@Before
	public void intialize(){

        JSONLoader loader = new JSONLoader(archivo);
        this.categorias = loader.getCategorias();
	}
	
	@Test
	public void testCargarCategorias() {

		assertEquals(9, categorias.size());
		
	}
	



	
	
}
