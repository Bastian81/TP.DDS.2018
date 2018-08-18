package controlador;

public class Sensor extends Subject {

    public Double valorTomado = 0.0;
	
	public Double getValorTomado()
	{
		return valorTomado;
	}

    public void medicion(Double unValor){

        valorTomado = unValor;
        this.notifyObservers();
    }
}


