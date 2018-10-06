package tests;

import datos.JSONLoader;
import datos.TipoDispositivo;
import general.Categoria;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class TestCargaJsonTiposDispositivo {


	List<TipoDispositivo> tipos;
	String archivo =  "tiposDispositivo.json";


	@Before
	public void intialize(){

        JSONLoader loader = new JSONLoader(archivo);
        this.tipos = loader.getTiposDispositivo();
	}
	
	@Test
	public void testCargarCategorias() {

		assertEquals(8, tipos.size());
		
	}
	



	
	
}
