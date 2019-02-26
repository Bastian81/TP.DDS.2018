package Loader;


import com.google.gson.reflect.TypeToken;
import controlador.Regla;
import datos.ControlJSON;
import datos.TipoDispositivo;
import dispositivo.Dispositivo;
import dispositivo.Inteligente;
import general.*;
import geoposicionamiento.Posicion;
import geoposicionamiento.Transformador;
import geoposicionamiento.ZonaGeografica;
import org.joda.time.DateTime;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("all")
public class Loader {

    ControlJSON json;

    public Loader() {
        json = new ControlJSON();
    }

    //Para datos harcodeados / ya cargados
    public List<ZonaGeografica> generarZonas() {
        List<ZonaGeografica> zonas = new ArrayList<>();
        zonas.add(generarZona());
        return zonas;
    }

    public ZonaGeografica generarZona() {
        Posicion posHarcodeada = new Posicion(155, -49);
        ZonaGeografica unaZona = new ZonaGeografica("Zona 1", 500, posHarcodeada, generarTransformadores());
        return unaZona;
    }


    public List<Transformador> generarTransformadores() {
        List<Transformador> transformadores = new ArrayList<>();

        Posicion pos1 = new Posicion(123, 30);
        Posicion pos2 = new Posicion(79, -60);
        Posicion pos3 = new Posicion(133, -30);

        List<Cliente> clientes = new ArrayList<>();
        clientes = leerClientes();
        //Sublist:
        //fromIndex – low endpoint (inclusive) of the subList
        //toIndex – high endpoint (exclusive) of the subList

        Transformador transformador1 = new Transformador("Transformador1", pos1, clientes.subList(0, 1));
        Transformador transformador2 = new Transformador("Transformador2", pos2, clientes.subList(1, clientes.size()));

        transformadores.add(transformador1);
        transformadores.add(transformador2);

        return transformadores;
    }

    public List<Cliente> leerClientes() {

        Type tipo = new TypeToken<List<Cliente>>() {
        }.getType();
        return json.leerJSON("clientes.json", tipo);
    }


    //Para datos nuevos
    public ZonaGeografica cargarZonaNueva(String nombreZona, double radioZona, double latitud, double longitud, List<Transformador> transformadores) {
        Posicion posicion = new Posicion(latitud, longitud);
        ZonaGeografica unaZona = new ZonaGeografica(nombreZona, radioZona, posicion, transformadores);
        return unaZona;
    }

    //Otros

    public List<Administrador> leerAdministradores() {
        ControlJSON json = new ControlJSON();
        Type tipo = new TypeToken<List<Administrador>>() {
        }.getType();
        return json.leerJSON("administradores.json", tipo);
    }

    public List<Usuario> leerUsuarios() {
        ControlJSON json = new ControlJSON();
        Type tipo = new TypeToken<List<Usuario>>() {
        }.getType();
        return json.leerJSON("usuarios.json", tipo);
    }


    public List<Usuario> generarUsuarios() {
        Type tipoUsuario = new TypeToken<List<Usuario>>() {
        }.getType();

        int cont = 0;

        List<Usuario> nuevosUsuarios = new ArrayList<>();
        List<Usuario> viejosUsuarios = leerUsuarios(); //Obtengo los usuarios ya previamente cargados

        List<Cliente> clientes = leerClientes(); //Obtengo los clientes
        List<Administrador> administradores = leerAdministradores(); //Obtengo los admins

        if (!clientes.isEmpty() && clientes != null) {
            for (Cliente cliente : clientes) {
                if (viejosUsuarios == null || viejosUsuarios.isEmpty()) {
                    nuevosUsuarios.add(new Usuario(cliente.nombre, cliente.apellido, cliente.username, cliente.password));
                } else if (!(viejosUsuarios.stream().anyMatch(e -> e.username.equals(cliente.username))))
                    nuevosUsuarios.add(new Usuario(cliente.nombre, cliente.apellido, cliente.username, cliente.password));
            }
        }

        if (!administradores.isEmpty() && administradores != null) {
            for (Administrador administrador : administradores) {
                if (viejosUsuarios == null || viejosUsuarios.isEmpty()) {
                    nuevosUsuarios.add(new Usuario(administrador.nombre, administrador.apellido, administrador.username, administrador.password));
                }
                else if (!(viejosUsuarios.stream().anyMatch(e -> e.username.equals(administrador.username))))
                    nuevosUsuarios.add(new Usuario(administrador.nombre, administrador.apellido, administrador.username, administrador.password));
            }
        }

        viejosUsuarios = leerUsuarios();

        //Si ya existia una lista de usuarios no nula Y ademas la nueva lista es vacia o nula

        try {
            if (viejosUsuarios == null && nuevosUsuarios == null) {
                throw new Exception("Error: No hay usuarios en el sistema");
            } else if ((viejosUsuarios != null && !viejosUsuarios.isEmpty()) && (nuevosUsuarios == null || nuevosUsuarios.isEmpty())) {
                return viejosUsuarios;
            } else {
                json.crearJSON("usuarios.json", nuevosUsuarios, tipoUsuario);
                return nuevosUsuarios;
            }
        } catch (Exception exp) {
            exp.getMessage();
            return null;
        }
    }

    public List<TipoDispositivo> leerTipoDispositivo()
    {
        Type tipo = new TypeToken<List<TipoDispositivo>>() {
        }.getType();
        return json.leerJSON("tiposDispositivo.json",tipo);
    }


    public List<Inteligente> leerDispositivosXUsuario(String userName)
    {

        List<Cliente> clientes = leerClientes();
        for (Cliente clie: clientes)
        {
            if(clie.username.equals(userName))
            {
                return clie.getDispositivosInteligentes();
            }
        }
        return null;
    }

    public List<Regla> leerReglas()
    {
        Type tipo = new TypeToken<List<Regla>>() {
        }.getType();
        return json.leerJSON("reglas.json",tipo);
    }

    public List<Regla> leerReglasUsDisp(String userName, int nroSeriaDisp)
    {
        List<Regla> reglas = new ArrayList<>();
        for (Regla regla: reglas)
        {
            if(regla.getNroSerialDisp() == nroSeriaDisp)
            {
                reglas.add(regla);
            }
        }
        return reglas;
    }

    public Inteligente obtenerDispo(String user, int nroSerie)
    {
        List<Inteligente> aux = leerDispositivosXUsuario(user);
        for(Inteligente inte: aux)
        {
            if(inte.nroSerial()==nroSerie)
                return inte;
        }
        return null;
    }

    public double consumoDispositivoUltimoMes(String user, int nroserie)
    {
        Inteligente aux = obtenerDispo(user,nroserie);
        if(aux!=null)
        {
            return aux.consumoPeriodo(new DateTime(),new DateTime().minusMonths(1));
        }
        else
            return 0;
    }
    public double consumoDispositivo(String user, int nroserie)
    {
        Inteligente aux = obtenerDispo(user,nroserie);
        if(aux!=null)
        {
            return aux.getConsumo();
        }
        else
            return 0;
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
