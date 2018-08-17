package controlador;

import dispositivo.Inteligente;

public class Actuador {

    int tipoActuador;

public Actuador(String unTipoActuador) {

    definirTipo(unTipoActuador);
}

public void definirTipo (String unTipo) {

    switch (unTipo) {

        case "apagar":
            tipoActuador = 0;
            break;

        case "encender":
            tipoActuador = 1;
            break;

        case "modoAhorro":
            tipoActuador = -1;
            break;

    }
}

public void actuar(Inteligente unDispositivo) {

    if(tipoActuador == 0){
        unDispositivo.apagar();
    }

    if(tipoActuador == 1){
        unDispositivo.apagar();
    }

    if(tipoActuador == -1){
        unDispositivo.apagar();
    }

}

}
