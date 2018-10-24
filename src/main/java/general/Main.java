package general;

import datos.JSONLoader;
import datos.Persistencia;
import datos.TipoDispositivo;
import geoposicionamiento.ZonaGeografica;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        /*JSONLoader loader = new JSONLoader( "categorias.json");
        List<Categoria> categorias = loader.getCategorias();

        Persistencia persistencia = new Persistencia();
        categorias.forEach(categoria -> persistencia.persistir(categoria));

        JSONLoader loader2 = new JSONLoader("administradores.json");
        List<Administrador> admin = loader2.getAdministradores();

        Persistencia persistenciaAdmin = new Persistencia();
        admin.forEach((administrador -> persistenciaAdmin.persistir(administrador)));

        loader = new JSONLoader( "tiposDispositivo.json");
        List<TipoDispositivo> tiposDispositivos = loader.getTiposDispositivo();

        Persistencia persistenciaDisp = new Persistencia();
        tiposDispositivos.forEach(tipo -> persistenciaDisp.persistir(tipo));*/

        JSONLoader loader = new JSONLoader( "geo.json");
        List<ZonaGeografica> zonasGeograficas = loader.getZona();

        Persistencia persistenciaZona = new Persistencia();
        zonasGeograficas.forEach(zona -> persistenciaZona.persistir(zona));
    }
}
