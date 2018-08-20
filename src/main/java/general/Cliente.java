package general;
import dispositivo.Dispositivo;
import dispositivo.Inteligente;
import dispositivo.Estandar;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import geoposicionamiento.Posicion;
import geoposicionamiento.Transformador;
import geoposicionamiento.ZonaGeografica;
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
    List<Inteligente> dispositivosInteligentes;
    List<Estandar> dipositivosEstandares;
    DateTime fechaDeAlta;
    List<Sensor> sensores;
	Posicion posicion;


		// Constructor
public Cliente(String nom, String ap, String nomUsuario, String contra, String direccion,String tipoDoc,int doc, int tel, double unaLatitud, double unaLongitud)
{
	super(nom,ap,nomUsuario,contra);
	tipoDocumento = tipoDoc;
	documento = doc;
	telefonoContacto = tel;
	domicilio = direccion;
	DateTime alta = new DateTime();
	this.fechaDeAlta = alta;
	puntos = 0;
	double latitud = unaLatitud;
	double longitud = unaLongitud;
	posicion = new Posicion(latitud, longitud);
}

public Posicion getPosicion() {
    return posicion;
}


public void agregarSensor (Sensor unSensor) {
    sensores.add(unSensor);
}

public int cantDispositivosTotal()
{
	return dispositivosInteligentes.size() + dipositivosEstandares.size();
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
	return dispositivosInteligentes.stream().filter(unDispositivo -> unDispositivo.estaEncendido())
			 .collect(Collectors.toList());
}

public boolean algunoEncendido() 
{
    return dispositivosInteligentes.stream().anyMatch(unDispositivo->unDispositivo.estaEncendido());
}

public float consumoMensual()
{
    float consumo = 0;

    for(Dispositivo dispositivo:dispositivosInteligentes)
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



public void agregarInteligente(Inteligente nuevoDispositivo)
{

		dispositivosInteligentes.add(nuevoDispositivo);
		if(!serialRepetida(nuevoDispositivo.nroSerial()))
            puntos += nuevoDispositivo.puntos();
}

public void agregarEstandar(Estandar nuevoDispositivo)
	{

		dipositivosEstandares.add(nuevoDispositivo);
	}

public boolean serialRepetida(int serial_nueva)
{
        return dispositivosInteligentes.stream().anyMatch(unDispositivo->(unDispositivo.nroSerial() == serial_nueva)); //No me importa si es estandar ya que no da puntos
}


	// Metodo para asignar un transformador a un cliente.
	public void asignarTransformador(List<ZonaGeografica> listaZonas)
	{
		for(ZonaGeografica zonaG : listaZonas)
		{

			if(zonaG.pertenece(this))
			{
				zonaG.asignarTransformador(this);
			}
		}

	}
	
}

