package Loader;

import controlador.Regla;
import controlador.Sensor;
import controlador.actuador.*;
import controlador.condicion.Condicion;
import datos.TipoDispositivo;
import dispositivo.Dispositivo;
import dispositivo.Estandar;
import dispositivo.Inteligente;
import estado.Estado;
import general.Administrador;
import general.Categoria;
import general.Cliente;
import general.SimplexManager;
import geoposicionamiento.Posicion;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

public class InstanciadorClases {
    //A nivel unidad
    public TipoDispositivo crearTipoDisp(String nombre, float consumoMin, float consumoMax)
    {
        return new TipoDispositivo(nombre, consumoMin,consumoMax);
    }

    public Inteligente crearDispInteligente(String nombre, Float consumo, int nroSerial, String nombreUsuario, String macAddress, Estado estado)
    {
        return new Inteligente(nombre, consumo, nroSerial, nombreUsuario,macAddress,estado);
    }

    public Cliente crearBaseCliente(String nom, String ap, String nomUsuario, String contra, String tipoDocumento, int documento, int telefonoContacto, String domicilio, float latitud,float longitud)
    {
        return new Cliente(nom,ap,nomUsuario,contra,tipoDocumento,documento,telefonoContacto,domicilio,latitud,longitud);
    }

    public Cliente crearCliente(String nom, String ap, String nomUsuario, String contra, String tipoDocumento, int documento, int telefonoContacto, String domicilio, float latitud,float longitud, List<Inteligente> dispositivosInteligentes, List<Sensor> sensores)
    {
        return new Cliente(nom,ap,nomUsuario,contra,tipoDocumento,documento,telefonoContacto,domicilio,latitud,longitud,dispositivosInteligentes,sensores);
    }

    public Administrador crearAdmin(String nom, String ap, String nomUsuario, String contra)
    {
        return new Administrador(nom,ap,nomUsuario,contra);
    }

    public Regla crearRegla(int idRegla, String nombre, int nroSerial)
    {
        return new Regla(idRegla,nombre,nroSerial);
    }

    public Regla crearRegla(String nombre, List<Actuador> actuadores, List<Condicion> condiciones, int nroSerial)
    {
        return new Regla(nombre,actuadores,condiciones,nroSerial);
    }





    public AhorrarDisp crearActuadorAhorro(Inteligente dispositivo, String nombre, int id)
    {
        return new AhorrarDisp(dispositivo,nombre,id);
    }
    public ApagarDisp crearApagarDisp(Inteligente dispositivo, String nombre, int id)
    {
        return new ApagarDisp(dispositivo,nombre,id);
    }
    public EncenderDisp crearEncenderDisp(Inteligente dispositivo, String nombre, int id)
    {
        return new EncenderDisp(dispositivo,nombre,id);
    }
}



