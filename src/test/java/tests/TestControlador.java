package tests;

import dispositivo.Inteligente;
import controlador.Actuador;
import controlador.CondicionMayor;
import controlador.Regla;
import controlador.Sensor;
import controlador.CondicionMenor;
import estado.Apagado;


public class TestControlador {

    public static void main(String[] args) {

        Sensor sensorTemp = new Sensor();
        Regla apagarPorTemp = new Regla();
        CondicionMayor tempM20 = new CondicionMayor(20.0);
        Apagado off = new Apagado();
        Inteligente heladera = new Inteligente("heladera", 5.67f, 1, (byte)1, off);
        Actuador apagar = new Actuador(heladera);

        apagarPorTemp.agregarCondicion(tempM20);
        sensorTemp.attach(tempM20);
        apagarPorTemp.agregarActuador(apagar);

        sensorTemp.medicion(21.0);
        



    }
}
