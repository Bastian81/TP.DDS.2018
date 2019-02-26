package Loader;

import com.google.gson.reflect.TypeToken;
import controlador.Regla;
import datos.ControlJSON;
import datos.TipoDispositivo;
import dispositivo.Inteligente;
import general.Cliente;
import geoposicionamiento.ZonaGeografica;

import java.lang.reflect.Type;
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

    Type tipoDispType = new TypeToken<List<TipoDispositivo>>() {
    }.getType();

    Type tipoInteligente = new TypeToken<List<Inteligente>>() {
    }.getType();

    String archivo;

    public CargadorJSONClase() {
        json = new ControlJSON();
        refresh = new Loader();
    }

    public void recargarZona() {
        archivo = "zonaGeoFull.json";
        json.crearJSON(archivo, refresh.generarZona(), zonaType);
        refresh.generarUsuarios();
        //crearJSON de: actuador y medicion
    }


    //EJ_:Cliente nuevoCliente = new Cliente("Fernando", "Gomez", "JuliaG123", "contra123", 17, "DNI", 17856231, 1166443322, "juncal 300", null, null, null, null, null, null, null);
    //Clientes:
    public void cargarCliente(Cliente nuevoCliente) {
        archivo = "clientes.json";

        json.crearJSON(archivo, clientes, tipoCliente);
        recargarZona();
    }
    public void cargarClientes(List<Cliente> nuevosClientes) {
        archivo = "clientes.json";
        json.crearJSON(archivo, clientes, tipoCliente);
        recargarZona();
    }

    //Tipos Dispositivos:
    public void cargarTipoDispositivo(TipoDispositivo nuevoTipoDisp)
    {
        archivo = "tiposDispositivo.json";
        json.crearJSON(archivo,nuevoTipoDisp,tipoDispType);
    }

    public void cargarTiposDispositivo(List<TipoDispositivo> tipoDispositivos)
    {
        archivo = "tiposDispositivo.json";
        json.crearJSON(archivo,tipoDispositivos,tipoDispType);
    }

    //Dispositivos:
    public void cargarInteligente(Inteligente disp, String nombreUser)
    {
        archivo = "clientes.json";

        List<Cliente> clientes = refresh.leerClientes(); // Me trae todos los clientes

        for(Cliente cliente: clientes)
        {
            if(cliente.username.equals(nombreUser))
            {
                cliente.agregarInteligente(disp);
            }
        }

        json.crearJSON(archivo,clientes,tipoCliente);
        recargarZona();
    }

    public void cargarListaDispositivo(List<Inteligente> tipoDispositivos, String nombreUser)
    {
        archivo = "clientes.json";
        List<Cliente> clientes = refresh.leerClientes();

        for(Cliente cliente: clientes)
        {
            if(cliente.username.equals(nombreUser))
            {
                cliente.agregarInteligentes(tipoDispositivos);
            }
        }

        json.crearJSON(archivo,clientes,tipoCliente);
        recargarZona();
    }

    public void cargarReglas(Regla nuevaRegla)
    {
        archivo = "reglas.json";
        Type reglaType = new TypeToken<List<Regla>>() {
        }.getType();
        json.crearJSON(archivo,nuevaRegla,reglaType);
    }



    //Regla:

}
