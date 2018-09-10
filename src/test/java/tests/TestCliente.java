package tests;

import static org.junit.Assert.*;

import java.util.List;
import java.util.function.Predicate;

import org.junit.Before;
import org.junit.Test;

import general.Categoria;
import general.Cliente;
import helpers.FileToStringReader;
import helpers.JSONLoader;
import helpers.DatosJSON;

public class TestCliente {

	Cliente miCliente;
	DatosJSON datosJson;
	List<Cliente> clientes;
	List<Categoria> categorias;

	@Before
	public void intialize(){
		
		String filePath = "src/test/resources/SGE.json";		
		FileToStringReader reader = new FileToStringReader();	
		JSONLoader loader = new JSONLoader(filePath, reader);	  	
		datosJson = loader.get();
		
		clientes = datosJson.getClientes();
		categorias = datosJson.getCategorias();
        clientes.forEach(cliente->cliente.setCategoria(categorias));


    }
	
	
	@Test
	public void testCantidadClientes() {
		
		assertEquals(7, clientes.size());
		
	}
	
	@Test
	public void testCantidadCategorias() {
		
		assertEquals(9, categorias.size());
		
	}
	
	@Test
	public void testCategoriaCliente() {
		
		for(Cliente cliente:clientes)
		{			
			float consumo = cliente.consumoMensual();
			Categoria categoria = cliente.getCategoria();
						
			if(consumo>1400)
				assertEquals(categoria.tipo(),"R9");
			else if (consumo>700)
				assertEquals(categoria.tipo(),"R8");
			else if (consumo>600)
				assertEquals(categoria.tipo(),"R7");
			else if (consumo>500)
				assertEquals(categoria.tipo(),"R6");
			else if (consumo>450)
				assertEquals(categoria.tipo(),"R5");
			else if (consumo>400)
				assertEquals(categoria.tipo(),"R4");
			else if (consumo>325)
				assertEquals(categoria.tipo(),"R3");
			else if (consumo>150)
				assertEquals(categoria.tipo(),"R2");
			else
				assertEquals(categoria.tipo(),"R1");
		}
		
	}
	
	@Test
	public void testEstimarFacturacion() {	
		
		assertTrue("R1 estimado menor o igual a 115.36",facturacionEstimadaClienteDe("R1")<=115.36);
		assertTrue("R2 estimado menor o igual a 266.62",facturacionEstimadaClienteDe("R2")<=266.62);
		assertTrue("R3 estimado menor o igual a 333.11",facturacionEstimadaClienteDe("R3")<=333.11);
		assertTrue("R4 estimado menor o igual a 403.84",facturacionEstimadaClienteDe("R4")<=403.84);
		assertTrue("R5 estimado menor o igual a 507.38",facturacionEstimadaClienteDe("R5")<=507.38);
		assertTrue("R6 estimado menor o igual a 719.95",facturacionEstimadaClienteDe("R6")<=719.95);
		assertTrue("R7 estimado menor o igual a 1039.29",facturacionEstimadaClienteDe("R7")<=1039.29);
		assertTrue("R8 estimado menor o igual a 1737.36",facturacionEstimadaClienteDe("R8")<=1737.36);
		assertTrue("R9 estimado mayor a 2078.59",facturacionEstimadaClienteDe("R9")>2078.59);
		
	}
	
	Float facturacionEstimadaClienteDe(String unTipo){
		Predicate<Cliente> porCategoria = cliente -> cliente.nombreCategoria().equals(unTipo);
				
		Cliente cliente =  clientes.stream().filter(porCategoria)
								.findAny().orElse(null);	
		if(cliente!=null)
		return cliente.estimarFacturacion(categorias);
		else
			return (float) 0;
	}

}
