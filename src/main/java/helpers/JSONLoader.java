package helpers;
import com.google.gson.Gson;

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
	
	Gson gson = new Gson();	
	DatosJSON datosJson = gson.fromJson(contenidoJSON, DatosJSON.class);	
    datosJson.categorizarClientes();
	
	return datosJson;
  }
  


}