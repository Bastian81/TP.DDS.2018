package general;

public class Cliente extends Usuarios {
	
		public String tipoDocumento;
		public int documento;
		int telefonoContacto;
		public Dispositivos dispositivos;
		
		//fechaDeAlta;
		//categoria
		
		// Constructor
public Cliente(String nom, String ap, String nomUsuario, String contra, String domicilio,String tipoDoc,int doc, int tel) 
	{
	super(nom,ap,nomUsuario,contra,domicilio);
	tipoDocumento = tipoDoc;
	documento = doc;
	telefonoContacto = tel;
	}



public boolean algunoEncendido(Dispositivos dispositivos) 
{
	// hacer dispoositivos -> any -> esta encendido
	return false;
}

}
