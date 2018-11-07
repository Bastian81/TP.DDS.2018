package tests;

import dispositivo.Inteligente;
import estado.Encendido;
import estado.Estado;
import general.Cliente;
import geoposicionamiento.Transformador;
import geoposicionamiento.ZonaGeografica;
import datos.JSONLoader;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestGeo {

    List<ZonaGeografica> zona;
    String archivo =  "geo.json";


    @Before
    public void intialize(){

        JSONLoader loader = new JSONLoader(archivo);
        zona = loader.getZona();
    }

    /*Cliente c1; //almagroNorte, t1//
    Cliente c2; //villaCrespo, t3// //c2 esta mas cerca de t1 pero esta en otra zona//
    Transformador t1; //almagroNorte//
    Transformador t2; //almagroNorte//
    Transformador t3; //villaCrespo//
    ZonaGeografica almagroNorte;
    ZonaGeografica villaCrespo;
    ArrayList<ZonaGeografica> zonasTest;
    Inteligente heladera;
    Encendido on;


    @Before
    public void init ()
    {
        //Instancias//
        //Clientes//
        c1 = new Cliente("Gladys", "Marks",
                "Trevino","Orr",
                "Calle 1","DNI",
                123,123,
                -34.597363, -58.419188);
        c2 = new Cliente("Mindy","Adkins",
                "Randall","Franco",
                "Calle 1","DNI",
                124,124,
                -34.602509, -58.431686);

        //transformadores//
        t1 = new Transformador(-34.598373, -58.419975);
        t2 = new Transformador(-34.600626, -58.425201);
        t3 = new Transformador(-34.598071, -58.456212);

        //zonas//
        zonasTest = new ArrayList<ZonaGeografica>();
        almagroNorte = new ZonaGeografica("almagroNorte", -34.604305, -58.421896, 0.9);
        villaCrespo = new ZonaGeografica("villaCrespo", -34.599449, -58.444196, 1.21);

        //dispositivosInteligentes//
        heladera = new Inteligente("heladera", 5.67f, 1, (byte)1, on);



        //Acciones//
        zonasTest.add(almagroNorte);
        zonasTest.add(villaCrespo);

        c1.agregarInteligente(heladera);

        almagroNorte.agregarTransformador(t1);
        almagroNorte.agregarTransformador(t2);
        villaCrespo.agregarTransformador(t3);

        c1.asignarTransformador(zonasTest);
        c2.asignarTransformador(zonasTest);*/
}

   /* @Test
    public void testCantidadZonas() {

        assertEquals(2, zona.size());

    }*/

    /*@Test
    public void test1(){
        assertEquals(2, almagroNorte.transformadores().size());
        assertEquals(1, villaCrespo.transformadores().size());
    }

    @Test
    public void test2(){
        assertEquals(1, t1.getClientes().size());
        assertEquals(0, t2.getClientes().size());
        assertEquals(1, t3.getClientes().size());
    }

    @Test
    public void test3(){
        assertEquals(c1, t1.getClientes().get(0));
        assertEquals(c2, t3.getClientes().get(0));
    }

    @Test
    public void test4(){
        assertEquals(5.67f, t1.getConsumo(), 0.00f);
    }*/

/*
c2 esta:
 a 0.917 de almagroNorte (afuera)
 a 0.630 de t2 (en otra zona)
 a 1.20 de villaCrespo
 a 2.30 de t3 (el mas cerca en la zona)

 */