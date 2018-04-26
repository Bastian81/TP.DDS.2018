package general;

public class Categoria {

	public String tipo;
	public float consumoMensualMin;
	public float consumoMensualMax;
	public float cargoMensualFijo;
	public float cargoMensualVar;
	
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
		return 12;
	}
	
}
