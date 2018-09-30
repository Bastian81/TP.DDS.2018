package helpers;
import com.google.gson.*;
import org.joda.time.DateTime;

import java.lang.reflect.Type;

public class JSONLoader
{

  String filePath;  
  FileToStringReader reader;
  DatosJSON datosJson;
  
  
  
  public JSONLoader(String filePath, FileToStringReader reader)
  {
	  this.filePath = filePath;	
	  this.reader = reader;

  }

  public DatosJSON get()
  {
    String contenidoJSON = this.reader.ReadFile(this.filePath);
    Gson gson = gsonInit();

    DatosJSON datosJson = gson.fromJson(contenidoJSON, DatosJSON.class);

	return datosJson;
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


}