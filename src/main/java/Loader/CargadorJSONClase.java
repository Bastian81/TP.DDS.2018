package Loader;

import com.google.gson.reflect.TypeToken;
import controlador.Regla;
import datos.ControlJSON;
import dispositivo.Inteligente;
import general.Cliente;
import geoposicionamiento.ZonaGeografica;
import sun.misc.Cleaner;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("all")
public class CargadorJSONClase {

    ControlJSON json;
    Loader refresh;
    List<Cliente> clientes;
    Type zonaType = new TypeToken<List<ZonaGeografica>>() {
    }.getType();
    Type tipoCliente = new TypeToken<List<Cliente>>() {
    }.getType();
    String archivo;

    public CargadorJSONClase() {
        json = new ControlJSON();
        refresh = new Loader();
    }

    public void recargar() {
        archivo = "zonaGeoFull.json";
        json.crearJSON(archivo, refresh.generarZona(), zonaType);
    }


    //EJ_:Cliente nuevoCliente = new Cliente("Fernando", "Gomez", "JuliaG123", "contra123", 17, "DNI", 17856231, 1166443322, "juncal 300", null, null, null, null, null, null, null);
    public void cargarCliente(Cliente nuevoCliente) {
        archivo = "clientes.json";

        //Leo los clientes actuales, los guardo en una lista y agrego el cliente nuevo. Luego borro y creo un nuevo clientes.json y recargo el archivo fact
        clientes = json.leerJSON(archivo, tipoCliente);
        clientes.add(nuevoCliente);

        json.crearJSON(archivo, clientes, tipoCliente);
        recargar();

    }

    public void cargarClientes(List<Cliente> nuevosClientes) {
        archivo = "clientes.json";

        //Leo los clientes actuales, los guardo en una lista y agrego el cliente nuevo. Luego borro y creo un nuevo clientes.json y recargo el archivo fact
        clientes = json.leerJSON(archivo, tipoCliente);
        clientes.addAll(nuevosClientes);

        json.crearJSON(archivo, clientes, tipoCliente);
        recargar();

    }
/*
    public Cliente crearCliente()
    {

    }
    public Inteligente crearDispositivo()
    {

    }
    public Regla crearDispositivo()
    {

    }
    */
}
