package tests;

import Loader.*;
import Simplificacion.Hogar;
import Simplificacion.TransfShort;
import general.Administrador;
import general.Cliente;
import general.Usuario;
import geoposicionamiento.Transformador;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

public class TestConsumoPromedio {
    Loader cargadorJSON;
    List<Transformador> transformadores;
    List<Cliente> clientes;

    List<Hogar> hogares;
    List<TransfShort> miniTrans;

    EntregaFinal entregaFinal = new EntregaFinal();

    @Before
    public void inicializar()
    {
        cargadorJSON = new Loader();
        transformadores = cargadorJSON.generarTransformadores();
        clientes = cargadorJSON.leerClientes();
        hogares = new ArrayList<>();
        miniTrans = new ArrayList<>();
    }

    @Test
    public void consumoPromedioTrans()
    {
        miniTrans = entregaFinal.consumoPromedioTrans();

        //assertEquals();
    }
}
