package general;

import datos.JSONLoader;
import datos.Persistencia;
import datos.TipoDispositivo;
import dispositivo.Inteligente;
import geoposicionamiento.ZonaGeografica;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        /*

        Forma para instaciar y almacenar las clases:
        1° Leo el JSON y guardo todos los valores leidos de la lista en una variable de tipo List
        2° Persisto cada elemento de esa lista con un foreach

         */
        JSONLoader loader;

        loader = new JSONLoader( "geo.json");
        List<ZonaGeografica> zonasGeograficas = loader.getZona();

        Persistencia persistenciaZona = new Persistencia();
        zonasGeograficas.forEach((zona -> persistenciaZona.persistir(zona)));

        loader = new JSONLoader("administradores.json");
        List<Administrador> admin = loader.getAdministradores();

        Persistencia persistenciaAdmin = new Persistencia();
        admin.forEach((administrador -> persistenciaAdmin.persistir(administrador)));


        loader = new JSONLoader( "categorias.json");
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

            //Esto no va a estar mas
        /*
        loader = new JSONLoader("inteligentes.json");
        List<Inteligente> inteligentes = loader.getInteligentes();

        Persistencia persistenciaInteligentes = new Persistencia();
        inteligentes.forEach(inteligente -> persistenciaInteligentes.persistir(inteligente));
        */
    }
}
