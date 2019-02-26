package tests;

import Loader.Loader;
import general.Usuario;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TestCargaJsonUsuarios {
     Loader cargadorJSON = new Loader();
     List<Usuario> usuarios = new ArrayList<>();

     @Test
    public void cargarUsuarios()
     {
         usuarios = cargadorJSON.generarUsuarios();
         assertTrue(!usuarios.isEmpty());
     }
}
