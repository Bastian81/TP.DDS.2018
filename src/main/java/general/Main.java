package general;

import Loader.CargadorJSONClase;
import com.google.gson.reflect.TypeToken;
import datos.ControlJSON;
import datos.JSONLoader;
import datos.Persistencia;
import datos.TipoDispositivo;
import dispositivo.Inteligente;
import geoposicionamiento.ZonaGeografica;
import web.init_web;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        CargadorJSONClase nuevoCargador = new CargadorJSONClase();

        nuevoCargador.recargar();

        //init_web.abrirURL("www.google.com");
/*
        ControlJSON json = new ControlJSON();
        List<Cliente> clientes;
        Type tipo = new TypeToken<List<Cliente>>() {
        }.getType();
        clientes = json.leerJSON("clientes.json",tipo);

        Cliente nuevoCliente = new Cliente("Fernando","Gomez","JuliaG123","contra123",17,"DNI",17856231,1166443322,"juncal 300",null,null,null,null,null,null,null);
        clientes.add(nuevoCliente);

        for(Cliente clie: clientes)
        {
            System.out.println(clie.dispositivosInteligentes);
        }

        json.crearJSON("nuevo2.0.json",clientes,tipo);
        */



        /*

        Forma para instaciar y almacenar las clases:
        1° Leo el JSON y guardo todos los valores leidos de la lista en una variable de tipo List
        2° Persisto cada elemento de esa lista con un foreach

         */
/*        JSONLoader loader;

        loader = new JSONLoader( "geo.json");
        List<ZonaGeografica> zonasGeograficas = loader.getZona();

        Persistencia persistenciaZona = new Persistencia();
        zonasGeograficas.forEach((zona -> persistenciaZona.persistir(zona)));

        loader = new JSONLoader("administradores.json");
        List<Administrador> admin = loader.getAdministradores();

        Persistencia persistenciaAdmin = new Persistencia();
        admin.forEach((administrador -> persistenciaAdmin.persistir(administrador)));
*/
/*
        loader = new JSONLoader( "categorias.json");
        List<Categoria> categorias = loader.getCategorias();

        Persistencia persistenciaCategoria = new Persistencia();
        categorias.forEach(categoria -> persistenciaCategoria.persistir(categoria));


*/
/*       loader = new JSONLoader( "categorias.json");
        List<Categoria> categorias = loader.getCategorias();

        Persistencia persistenciaCategoria = new Persistencia();
        categorias.forEach(categoria -> persistenciaCategoria.persistir(categoria));

        loader = new JSONLoader( "tiposDispositivo.json");
        List<TipoDispositivo> tiposDispositivos = loader.getTiposDispositivo();

        Persistencia persistenciaDisp = new Persistencia();
        tiposDispositivos.forEach(tipo -> persistenciaDisp.persistir(tipo));

        loader = new JSONLoader("clientes2.json");
        List<Cliente> clientes = loader.getClientes();

        Persistencia persistenciaClientes = new Persistencia();
        clientes.forEach(cliente -> persistenciaClientes.persistir(cliente));
*/



            //Esto no va a estar mas
        /*
        loader = new JSONLoader("inteligentes.json");
        List<Inteligente> inteligentes = loader.getInteligentes();

        Persistencia persistenciaInteligentes = new Persistencia();
        inteligentes.forEach(inteligente -> persistenciaInteligentes.persistir(inteligente));
        */

    }
}
