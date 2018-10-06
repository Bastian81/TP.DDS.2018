package general;

import datos.JSONLoader;
import datos.Persistencia;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        JSONLoader loader = new JSONLoader( "categorias.json");
        List<Categoria> categorias = loader.getCategorias();

        Persistencia persistencia = new Persistencia();
        categorias.forEach(categoria -> persistencia.persistir(categoria));

    }
}
