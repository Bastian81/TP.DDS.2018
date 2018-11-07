package controlador;

import general.Cliente;

import javax.persistence.*;

@Entity
@Table (name = "Sensores")
public class Sensor extends Subject {

    @Id
    @GeneratedValue
    int id;
    String nombre;

    @ManyToOne
    Cliente cliente;

    public Sensor(String nombreSensor) {

        nombre = nombreSensor;

    }

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


