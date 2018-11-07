package general;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Categorias")
public class Categoria {

	 String tipo;
	 float consumoMensualMin;
	 float consumoMensualMax;
	 float cargoMensualFijo;
	 float cargoMensualVar;

	 @Id
	 @GeneratedValue
	 int id;
	
	// constructor
	
	public Categoria(String tipo, float consumoMin, float consumoMax, float cargoFijo, float cargoVar) 
	{
		this.tipo = tipo;
		consumoMensualMin = consumoMin;
		consumoMensualMax = consumoMax;
		cargoMensualFijo = cargoFijo;
		cargoMensualVar = cargoVar;
		
	}
	
	// getters 
	public String tipo() {return tipo;}
	public float consumoMensualMin() {return consumoMensualMin;}
	public float consumoMensualMax() {return consumoMensualMax;}
	public float cargoMensualFijo() {return cargoMensualFijo;}
	public float cargoMensualVar()  {return cargoMensualVar;}


	public float estimarFacturacionMensual(Cliente cliente)
	{
		float consumo = cliente.consumoMensual();
		
		return (cargoMensualFijo + cargoMensualVar * consumo);
		
	}
	
	public boolean pertence(Cliente unCliente){
		
		float consumo = unCliente.consumoMensual();
		
		return 
		  (consumoMensualMin<consumo && 
		  (consumo <=  consumoMensualMax)|| consumoMensualMax==0 );		  

	}
}
