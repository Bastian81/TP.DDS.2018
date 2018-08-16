package tests;

import dispositivo.Inteligente;
import controlador.Actuador;
import controlador.Condicion;
import controlador.Regla;
import controlador.Sensor;
import estado.Apagado;


public class TestControlador {

    public static void main(String[] args) {

        //instancias//
        Sensor sensorTemp = new Sensor();
        Regla apagarPorTemp = new Regla();
        Condicion tempM20 = new Condicion(20.0, apagarPorTemp, "mayorIgual");
        Apagado off = new Apagado();
        Inteligente heladera = new Inteligente("heladera", 5.67f, 1, (byte)1, off);
        Actuador apagar = new Actuador(heladera);

        //adds//
        sensorTemp.attach(tempM20);
        apagarPorTemp.agregarActuador(apagar);

        //acciones//
        sensorTemp.medicion(20.0);
    }
}
