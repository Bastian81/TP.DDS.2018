package controlador;

import java.util.ArrayList;

public class Sensor extends Subject {

    public Double valorTomado = 0.0;
	
	public Double getValorTomado(void)
	{
		return valorTomado;
	}

    public void medicion(Double unValor){

        valorTomado = unValor;
        this.notify(void);
    }
}


