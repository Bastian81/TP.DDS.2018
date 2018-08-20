package tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import dispositivo.Inteligente;
import controlador.Condicion;
import controlador.Regla;
import controlador.Sensor;
import estado.*;
import actuador.*;


public class TestControlador {

    Sensor sensorTemp;
    Sensor sensorMov;
    Encendido on;
    Inteligente heladera;
    Regla apagarPorTempYMov;
    Condicion tempM20;
    Condicion mov0;
    Actuador apagar;
	
	@Before
	public void init()
	{
        //instancias//
        sensorTemp = new Sensor();
        sensorMov = new Sensor();
        on = new Encendido();
        heladera = new Inteligente("heladera", 5.67f, 1, (byte)1, on);
        apagarPorTempYMov = new Regla(heladera);
        tempM20 = new Condicion(20.0, apagarPorTempYMov, "mayorIgual", sensorTemp);
        mov0 = new Condicion(0.0, apagarPorTempYMov, "igual", sensorMov);
        apagar = new ApagarDisp();

        //adds//
        sensorTemp.attach(tempM20);
        sensorMov.attach(mov0);
        apagarPorTempYMov.agregarActuador(apagar);

        //acciones//
        sensorTemp.medicion(20.0);
        sensorTemp.medicion(16.0);
        sensorMov.medicion(0.0);
	}
	
	@Test
	public void test1(){
		assertTrue(heladera.estaEncendido());
	}
	
	@Test
	public void test2() {
		sensorTemp.medicion(30.0);
		assertFalse(heladera.estaEncendido());
	}

 //   public void testApagado//
}


