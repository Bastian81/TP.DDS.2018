package datos;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class ControlJSON {
    Gson gson = new Gson();
    JsonReader reader;
    String resources = "src/main/resources/data/";
    FileReader fileReader = null;


    public ControlJSON() {}

    public <T> void crearJSON(String nombreArchivo, List<T> generica, Type tipo)
    {
        File tmpDir = new File(resources + nombreArchivo);
        if(tmpDir.exists()) {
            generica.addAll(leerJSON(nombreArchivo,tipo));            //Guardo lo que ya tenia en el archivo y lo agrego a la lista
        }
            try (FileWriter writer = new FileWriter(resources + nombreArchivo)) {
                gson.toJson(generica,tipo, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public <T> List<T> leerJSON(String file,Type tipo) {
        try {
            fileReader = new FileReader(resources + file);
            this.reader = new JsonReader(fileReader);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return gson.fromJson(reader, tipo);
    }

    //Extra:

    public <T> void crearJSON(String nombreArchivo, T generica, Type tipo)
    {
        File tmpDir = new File(resources + nombreArchivo);
        List<T> genericas = new ArrayList<>();
        genericas.add(generica);
        if(tmpDir.exists()) {
            genericas.addAll(leerJSON(nombreArchivo,tipo));                       //Guardo lo que ya tenia en el archivo y lo agrego a la lista
        }
        try (FileWriter writer = new FileWriter(resources + nombreArchivo)) {
            gson.toJson(genericas,tipo, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
