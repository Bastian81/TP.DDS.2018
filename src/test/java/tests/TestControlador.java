package tests;

import dispositivo.Inteligente;
import controlador.Actuador;
import controlador.Condicion;
import controlador.Regla;
import controlador.Sensor;
import estado.Apagado;
import estado.Encendido;


public class TestControlador {

    public static void main(String[] args) {

        //instancias//
        Sensor sensorTemp = new Sensor();
        Sensor sensorMov = new Sensor();
        Encendido on = new Encendido();
        Inteligente heladera = new Inteligente("heladera", 5.67f, 1, (byte)1, on);
        Regla apagarPorTempYMov = new Regla(heladera);
        Condicion tempM20 = new Condicion(20.0, apagarPorTempYMov, "mayorIgual");
        Condicion mov0 = new Condicion(0.0, apagarPorTempYMov, "igual");
        Actuador apagar = new Actuador("apagar");

        //adds//
        sensorTemp.attach(tempM20);
        sensorMov.attach(mov0);
        apagarPorTempYMov.agregarActuador(apagar);

        //acciones//
        sensorTemp.medicion(20.0);
        sensorTemp.medicion(16.0);
        sensorMov.medicion(0.0);


    }

 //   public void testApagado//
}


