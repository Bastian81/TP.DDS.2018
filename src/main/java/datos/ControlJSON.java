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
            if (tmpDir.exists()) {
                if (leerJSON(nombreArchivo, tipo) != null && !leerJSON(nombreArchivo, tipo).isEmpty()) {
                    generica.addAll(leerJSON(nombreArchivo, tipo));            //Guardo lo que ya tenia en el archivo y lo agrego a la lista
                }
            }
                try (FileWriter writer = new FileWriter(resources + nombreArchivo)) {
                    gson.toJson(generica, tipo, writer);
                } catch (IOException e) {
                    e.printStackTrace();
                }

    }

    public <T> List<T> leerJSON(String file,Type tipo) {

        try {
            File tmpDir = new File(resources + file);
            if (!tmpDir.exists())
            {
                throw new FileNotFoundException("Error: no se encontro el archivo a leer");
            }
            fileReader = new FileReader(resources + file);
            this.reader = new JsonReader(fileReader);

            return gson.fromJson(reader, tipo);

        } catch (FileNotFoundException e) {

            e.getMessage();
            return null;
        }


    }

    //Extra:
    //Pasarle siempre el tipo de lista!!
    public <T> void crearJSON(String nombreArchivo, T generica, Type tipo) {
        File tmpDir = new File(resources + nombreArchivo);
        List<T> genericas = new ArrayList<>();

        if (!tmpDir.exists()) {
            //Guardo lo que ya tenia en el archivo y lo agrego a la lista
            if (leerJSON(nombreArchivo, tipo) != null && !leerJSON(nombreArchivo, tipo).isEmpty()) {
                genericas.addAll(leerJSON(nombreArchivo, tipo));
            }
        }

        try (FileWriter writer = new FileWriter(resources + nombreArchivo)) {
            genericas.add(generica);
            gson.toJson(genericas, tipo, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
