package Loader;

import Simplificacion.Hogar;
import Simplificacion.TransfShort;
import controlador.Regla;
import controlador.actuador.Actuador;
import controlador.condicion.Condicion;
import datos.TipoDispositivo;
import general.Administrador;
import general.Usuario;

import dispositivo.Inteligente;
import general.Cliente;
import geoposicionamiento.Transformador;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

//Clase especifica para responder preguntas/consultas de la entrega
//Ctrl + Alt + . -> para moverte entre regiones: desplegarlas con el + y ocultarlas con el -
public class EntregaFinal {

    //region Variables
    Loader nuevoLector;
    CargadorJSONClase nuevoCargador;
    InstanciadorClases nuevoInstanciador;

    List<Hogar> hogares = new ArrayList<>();

    List<TransfShort> transCortos = new ArrayList<>();

    List<Cliente> clientes;

    List<Administrador> admins;

    List<Usuario> usuarios;

    List<Transformador> transformadores;

    List<TipoDispositivo> tipoDispositivos;

    String nombre, contra, archivo;


    //endregion


    //region Constructor
    public EntregaFinal() {

        nuevoLector = new Loader();
        nuevoCargador = new CargadorJSONClase();
        nuevoInstanciador = new InstanciadorClases();

        clientes = nuevoLector.leerClientes();
        admins = nuevoLector.leerAdministradores();
        usuarios = nuevoLector.leerUsuarios();
        if(usuarios == null)
            usuarios = nuevoLector.generarUsuarios();
    }
//endregion

    //Actualiza los archivos json correspondientes
    public void refresh()
    {
        clientes = nuevoLector.leerClientes();
        admins = nuevoLector.leerAdministradores();
        usuarios = nuevoLector.leerUsuarios();
        if(usuarios == null)
            usuarios = nuevoLector.generarUsuarios();
    }



    //region Login Admins y Clientes
    public Boolean puedeIniciarSesionCliente(String usuario,String contra)
    {
        refresh();
        return usuarios.stream().anyMatch(user -> user.username.equals(usuario) && user.password.equals(contra)) && esCliente(usuario);
    }
    public Boolean puedeIniciarSesionAdmin(String usuario,String contra)
    {
        refresh();
        return usuarios.stream().anyMatch(user -> user.username.equals(usuario) && user.password.equals(contra)) && esAdmin(usuario);
    }

    public Boolean esCliente(String usuario)
    {
        refresh();
        return existeUsuario(usuario) && clientes.stream().anyMatch(user -> user.username.equals(usuario));
    }

    public Boolean esAdmin(String usuario)
    {
        refresh();
        return existeUsuario(usuario) && admins.stream().anyMatch(user -> user.username.equals(usuario));
    }

    public Boolean existeUsuario(String usuario)
    {
        refresh();
        return usuarios.stream().anyMatch(user -> user.username.equals(usuario));
    }
    //endregion


    //region Get Hogares y Transformadores
    public List<Hogar> getHogares()
    {
        refresh();
        hogares = null;
        hogares.clear();
        for(Cliente clien: clientes)
        {
            hogares.add(new Hogar(clien.username,clien.consumoMensual())); //devuelve el consumo anual
        }
        return hogares;
    }

    public List<TransfShort> getTransformadoresShort()
    {

        transCortos = null;
        transCortos.clear();
        for(Transformador trans: transformadores)
        {
            transCortos.add(new TransfShort(trans.getNombreTransformador(),trans.getConsumo()));
        }
        return transCortos;
    }
//endregion

    //region Hogares y Transformadores -> Consumo + Consumo/Periodo
    public List<TransfShort> consumoPromedioTrans()
    {
        refresh();
        transCortos = null;
        transCortos.clear();
        for(Transformador trans: transformadores)
        {
            transCortos.add(new TransfShort(trans.getNombreTransformador(),trans.getConsumo()/12));
        }
        return transCortos;
    }

    public List<TransfShort> consumoPromedioTransPeriodo(DateTime fechaInicio,DateTime fechaFin)
    {
        refresh();
        transCortos = null;
        transCortos.clear();
        for(Transformador trans: transformadores)
        {
            transCortos.add(new TransfShort(trans.getNombreTransformador(),trans.consumoPeriodo(fechaInicio,fechaFin)));
        }
        return transCortos;
    }


    public List<Hogar> consumoTotalHogar()
    {
        refresh();
        hogares = null;
        hogares.clear();
        for(Cliente clien: clientes)
        {
            hogares.add(new Hogar(clien.username,clien.consumoMensual()*12)); //devuelve el consumo anual
        }
        return hogares;
    }

    public List<Hogar> consumoTotalHogarPeriodo(DateTime fechaInicio,DateTime fechaFin)
    {
        refresh();
        hogares = null;
        hogares.clear();
        for(Cliente clien: clientes)
        {
            hogares.add(new Hogar(clien.username,clien.consumoPeriodo(fechaInicio,fechaFin))); //devuelve el consumo anual
        }
        return hogares;
    }
    //endregion



    //region Crear TipoDispositivo + listar TiposDispositivos
    public void crearTipoDispositivo(String nombre, float consumoMin, float consumoMax)
    {
        nuevoCargador.cargarTipoDispositivo(nuevoInstanciador.crearTipoDisp(nombre,consumoMin,consumoMax));
    }

    public List<TipoDispositivo> leerTipoDisp()
    {
        return nuevoLector.leerTipoDispositivo();
    }
    //endregion

    //region Cargar Dispositivo/s + leer Dispositivos

    public void crearDispositivos(List<Inteligente> dispositivos, String username)
    {
        nuevoCargador.cargarListaDispositivo(dispositivos,username);
    }

    public void crearDispositivo(Inteligente dispositivo, String username)
    {
        nuevoCargador.cargarInteligente(dispositivo,username);
    }

    public List<Inteligente> leerDisp(String user)
    {
        return nuevoLector.leerDispositivosXUsuario(user);
    }

    //endregion



    //region Listar y Crear Reglas

    public List<Regla> getReglas()
    {
        return nuevoLector.leerReglas();
    }

    public List<Regla> getReglas(String user, int nroSerie)
    {
        return nuevoLector.leerReglasUsDisp(user,nroSerie);
    }
    public void crearRegla(String nombre, List<Actuador> actuadores, List<Condicion> condiciones, int nroSerial)
    {
        nuevoCargador.cargarReglas(nuevoInstanciador.crearRegla(nombre,actuadores,condiciones,nroSerial));
    }

    //endregion

    //region Consumo
    //region consumo del Dispositivo en el Ultimo Mes

    public double consumoDispositivoUltimoMes(String username, int nroSerie)
    {
        return nuevoLector.consumoDispositivoUltimoMes(username,nroSerie);
    }

    //endregion

    //region Consumo en horas del Dipositivo
    public double consumoDispositivo(String username, int nroSerie)
    {
        return nuevoLector.consumoDispositivo(username,nroSerie);
    }
    //endregion
    //endregion


    //region Extra: listarClientes
    public List<Cliente> listaCliente()
    {
        refresh();
        return clientes;
    }
    //endregion




}
