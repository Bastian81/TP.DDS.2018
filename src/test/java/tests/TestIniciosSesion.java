package tests;

import Loader.Loader;
import general.Administrador;
import general.Cliente;
import general.Usuario;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import Loader.*;

import static org.junit.Assert.assertTrue;

public class TestIniciosSesion {
    Loader cargadorJSON = new Loader();
    List<Usuario> usuarios = new ArrayList<>();
    List<Cliente> clientes = new ArrayList<>();
    List<Administrador> admins = new ArrayList<>();
    String user;
    String password;
    Boolean existe = false;
    EntregaFinal entregaFinal = new EntregaFinal();

    @Before
    public void inicializar()
    {
        usuarios = cargadorJSON.generarUsuarios();
        clientes = cargadorJSON.leerClientes();
        admins = cargadorJSON.leerAdministradores();
    }

    @Test
    public void existenUsuarios()
    {
        usuarios = cargadorJSON.generarUsuarios();
        assertTrue(!usuarios.isEmpty());
    }

    @Test
    public void existeUnUsuario()
    {

        user = usuarios.get(0).username;
        assertTrue(entregaFinal.existeUsuario(user));
    }

    @Test
    public void puedeIniciarSesionCliente()
    {
         user = clientes.get(0).username;
         password = clientes.get(0).password;
        assertTrue(entregaFinal.puedeIniciarSesionCliente(user,password));
    }

    @Test
    public void puedeIniciarSesionAdmin()
    {
        user = admins.get(0).username;
        password = admins.get(0).password;
        assertTrue(entregaFinal.puedeIniciarSesionAdmin(user,password));
    }


    @Test
    public void esCliente()
    {
        user = clientes.get(0).username;
        assertTrue(entregaFinal.esCliente(user));
    }

    @Test
    public void esAdmin()
    {
        user = admins.get(0).username;
        assertTrue(entregaFinal.esAdmin(user));
    }
}
