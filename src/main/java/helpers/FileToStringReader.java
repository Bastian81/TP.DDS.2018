package helpers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileToStringReader {
	 public String ReadFile(String filePath)
	  {
	     try
	     {
			Path path = Paths.get(filePath);
			byte[] bytes = Files.readAllBytes(path);	
	        String content = new String(bytes);
	   		
		    return content;
		 }
		 catch(Exception ex)
		 {
		    return "";
		 }
	  }
	
}
