package Loader;


import com.google.gson.reflect.TypeToken;
import datos.ControlJSON;
import dispositivo.Inteligente;
import general.Categoria;
import general.Cliente;
import general.SimplexManager;
import geoposicionamiento.Posicion;
import geoposicionamiento.Transformador;
import geoposicionamiento.ZonaGeografica;
import org.joda.time.DateTime;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;



public class Loader {


    //Para datos harcodeados / ya cargados
    public List<ZonaGeografica> generarZonas()
    {
            List<ZonaGeografica> zonas = new ArrayList<>();
            zonas.add(generarZona());
            return zonas;
    }

    public ZonaGeografica generarZona()
    {
        Posicion posHarcodeada = new Posicion(155,-49);
        ZonaGeografica unaZona = new ZonaGeografica("Zona 1",500,posHarcodeada, generarTransformadores());
        return unaZona;
    }


    public List<Transformador> generarTransformadores()
    {
        List<Transformador> transformadores = new ArrayList<>();

        Posicion pos1 = new Posicion(123,30);
        Posicion pos2 = new Posicion(79,-60);
        Posicion pos3 = new Posicion(133,-30);

        List<Cliente> clientes = new ArrayList<>();
        clientes = generarClientes();
        //Sublist:
        //fromIndex – low endpoint (inclusive) of the subList
        //toIndex – high endpoint (exclusive) of the subList

        Transformador transformador1 = new Transformador("Transformador1",pos1,clientes.subList(0,1));
        Transformador transformador2 = new Transformador("Transformador2",pos2,clientes.subList(1,clientes.size()));

        transformadores.add(transformador1);
        transformadores.add(transformador2);

        return transformadores;
    }

    public List<Cliente> generarClientes()
    {
        ControlJSON json = new ControlJSON();
        Type tipo = new TypeToken<List<Cliente>>() {
        }.getType();
        return json.leerJSON("clientes.json",tipo);
    }


    //Para datos nuevos
    public ZonaGeografica cargarZonaNueva(String nombreZona, double radioZona, double latitud, double longitud, List<Transformador> transformadores)
    {
        Posicion posicion = new Posicion(latitud,longitud);
        ZonaGeografica unaZona = new ZonaGeografica(nombreZona,radioZona,posicion,transformadores);
        return unaZona;
    }
}

        /*Categoria cat1 = new Categoria("R1",0,150,9,3);
        Categoria cat2 = new Categoria("R2",0,220,7,5);
        Categoria cat3 = new Categoria("R3",0,330,20,10);

        List<Posicion> posRandom = new ArrayList<>();

        posRandom.add(new Posicion(120,40));
        posRandom.add(new Posicion(60,40));
        posRandom.add(new Posicion(45,-54));
        posRandom.add(new Posicion(134,-44));

        List<Inteligente> inteligentes = new ArrayList<>();
        List<Inteligente> estandar = new ArrayList<>();

        Cliente unCliente = new Cliente("Jualia","Gomez","JuliaG123","contra123",17,"DNI",17856231,1166443322,"juncal 300",cat1,null,null,null,null,posRandom.get(0),null);

        clientes.add(unCliente);*/
