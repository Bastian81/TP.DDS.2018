package tests;

import general.Cliente;
import geoposicionamiento.Transformador;
import geoposicionamiento.ZonaGeografica;
import org.junit.Before;
import org.junit.Test;

public class TestGeo {

    Cliente c1; //almagroNorte, t1//
    Cliente c2; //villaCrespo, t3// //c2 esta mas cerca de t1 pero esta en otra zona//
    Transformador t1; //almagroNorte//
    Transformador t2; //almagroNorte//
    Transformador t3; //villaCrespo//
    ZonaGeografica almagroNorte;
    ZonaGeografica villaCrespo;


    @Before
    public void mainTest (String[] args)
    {
        //Instancias//
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

        t1 = new Transformador(-34.598373, -58.419975);
        t2 = new Transformador(-34.600626, -58.425201);
        t3 = new Transformador(-34.598071, -58.456212);

        almagroNorte = new ZonaGeografica(-34.604305, -58.421896, 0.9);
        villaCrespo = new ZonaGeografica(-34.599449, -58.444196, 1.21);
}

}
/*
c2 esta:
 a 0.917 de almagroNorte (afuera)
 a 0.630 de t2 (en otra zona)
 a 1.20 de villaCrespo
 a 2.30 de t3 (el mas cerca en la zona)

 */