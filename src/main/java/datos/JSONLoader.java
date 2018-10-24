package datos;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import geoposicionamiento.ZonaGeografica;
import org.joda.time.DateTime;

import general.Administrador;
import general.Categoria;
import general.Cliente;


public class JSONLoader
{
  Gson gson;
  JsonReader reader;
  String resources = "src/main/resources/data/";

  public JSONLoader(String filePath) {
    try {
        FileReader fileReader = new FileReader(resources + filePath);
        this.reader = new JsonReader(fileReader);
        this.gson = gsonInit();
    }
    catch(FileNotFoundException ex)
    {
        System.out.println("Archivo no encontrado, " + ex.getMessage());
    }

  }
  public List<Administrador> getAdministradores()
  {
     // System.out.println("Paso 0");
      Type tipo = new TypeToken<List<Administrador>>(){}.getType();
      return gson.fromJson(reader, tipo);
  }


    public List<Cliente> getClientes()
    {
        List<Cliente> clientes = null;

        try {
            Type tipo = new TypeToken<List<Cliente>>() {
            }.getType();
            clientes =  gson.fromJson(reader, tipo);
        }
        catch(Exception e)
        {
            System.out.println("Error al intentar levantar los clientes: " + e.getMessage());
        }

        return clientes;
    }

    public List<Categoria> getCategorias()
    {
        Type tipo = new TypeToken<List<Categoria>>(){}.getType();
        return gson.fromJson(reader, tipo);

    }

    public List<TipoDispositivo> getTiposDispositivo()
    {
        Type tipo = new TypeToken<List<TipoDispositivo>>(){}.getType();
        return gson.fromJson(reader, tipo);
    }

    //Armo esto para que se puedan levantar las fechas como DateTime
    private Gson gsonInit()
    {
        return new GsonBuilder().registerTypeAdapter(DateTime.class, new JsonDeserializer<DateTime>() {
            @Override
            public DateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                    throws JsonParseException {
                return new DateTime(json.getAsString());
            }
        }).create();
    }

    public List<ZonaGeografica> getZona()
    {
        List<ZonaGeografica> zonas = null;

        try {
            Type tipo = new TypeToken<List<ZonaGeografica>>() {
            }.getType();
            zonas =  gson.fromJson(reader, tipo);
        }
        catch(Exception e)
        {
            System.out.println("Error al intentar levantar las zonas: " + e.getMessage());
        }

        return zonas;
    }

}