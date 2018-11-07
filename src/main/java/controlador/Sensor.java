package controlador;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Sensores")
public class Sensor extends Subject {

    @Id
    @GeneratedValue
    int id;

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


