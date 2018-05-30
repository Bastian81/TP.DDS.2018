package general;
import dispositivo.Dispositivo;
import dispositivo.Inteligente;
import dispositivo.Estandar;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.joda.time.DateTime;
import controlador.Sensor;


import org.joda.time.DateTime;


public class Cliente extends Usuario
{
    int puntos;
    String tipoDocumento;
    int documento;
    int telefonoContacto;
    String domicilio;
    Categoria categoria;
    List<Dispositivo> dispositivos;
    Date fechaDeAlta;
    List<Sensor> sensores;
		
		// Constructor
public Cliente(String nom, String ap, String nomUsuario, String contra, String direccion,String tipoDoc,int doc, int tel)
{
	super(nom,ap,nomUsuario,contra);
	tipoDocumento = tipoDoc;
	documento = doc;
	telefonoContacto = tel;
	domicilio = direccion;
	DateTime alta = new DateTime();
	this.fechaDeAlta = alta;
	puntos = 0;
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

	//Adaptar estos metodos

public List<Dispositivo> dispositivosEncendidos() 
{
	return dispositivos.stream().filter(unDispositivo -> unDispositivo.estaEncendido())
			 .collect(Collectors.toList());
}

public boolean algunoEncendido() 
{
    return dispositivos.stream().anyMatch(unDispositivo->unDispositivo.estaEncendido());
}

public float consumoMensual()
{
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



public Categoria getCategoria()
{
		return this.categoria;
}



public String nombreCategoria()
{
		return categoria.tipo();
}



public void agregarDispositivo(Dispositivo nuevoDispositivo)
{
		dispositivos.add(nuevoDispositivo);
		if(!serialRepetida(nuevoDispositivo.nroSerial()))
            puntos += nuevoDispositivo.puntos();
}

public boolean serialRepetida(int serial_nueva)
{
        return dispositivos.stream().anyMatch(unDispositivo->(unDispositivo.nroSerial() == serial_nueva));
}
	
}


