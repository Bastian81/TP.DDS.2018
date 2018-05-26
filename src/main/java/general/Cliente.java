package general;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;



public class Cliente extends Usuario {
	
		String tipoDocumento;
		int documento;
		int telefonoContacto;
	    String domicilio;
		List<Dispositivo> dispositivos;
		Categoria categoria;
		
		//fechaDeAlta;
		//categoria
		
		// Constructor
public Cliente(String nom, String ap, String nomUsuario, String contra, String direccion,String tipoDoc,int doc, int tel)
	{
	super(nom,ap,nomUsuario,contra);
	tipoDocumento = tipoDoc;
	documento = doc;
	telefonoContacto = tel;
	domicilio = direccion;
	
	}

public int cantDispositivosTotal() 
	{
	return dispositivos.size();
	}

public int cantDispositivosEncendidos() 
	{
	return dispositivosEncendidos().size();
	}

public int cantDispositivosApagados() 
	{
	return cantDispositivosTotal() - cantDispositivosEncendidos();
	}

public List<Dispositivo> dispositivosEncendidos() 
	{
	return dispositivos.stream().filter(unDispositivo -> unDispositivo.estaEncendido())
			 .collect(Collectors.toList());
	}

public boolean algunoEncendido() 
{
	return dispositivos.stream().anyMatch(unDispositivo->unDispositivo.estaEncendido());

}

	public float consumoMensual() {

		float consumo = 0;
		
		for(Dispositivo dispositivo:dispositivos)
			consumo+= dispositivo.getConsumo();
			
		return consumo;
	}
	
	public float estimarFacturacion(List<Categoria> categorias){
		return 	categoria.estimarFacturacionMensual(this);
	}
	
	public void setCategoria(List<Categoria> categorias)
	{
	
		categorias.sort(Comparator.comparingDouble(Categoria::consumoMensualMin)
                );
		
		this.categoria = (categorias.stream()
									.filter(c->c.pertence(this)).findFirst()
									.get());					
	}



	public Categoria getCategoria() {
		return this.categoria;
	}



	public String nombreCategoria() {
	
		return categoria.tipo();
	}
	
}


