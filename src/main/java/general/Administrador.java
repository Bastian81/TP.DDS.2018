package general;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Months;

public class Administrador extends Usuario {
	
	 int adminID;
	 Date fechaDeAlta;

	// Constructor
public Administrador(String nombre, String ap, String userName, String password, int numeroId)
	{
		super(nombre,ap,userName,password);
		this.adminID = numeroId;
	}

public int mesesAdministrando() {
		
		DateTime hoy = new DateTime();
		DateTime fechaAlta = new DateTime(fechaDeAlta);		
		
		return Months.monthsBetween(fechaAlta, hoy).getMonths();
	}


}

