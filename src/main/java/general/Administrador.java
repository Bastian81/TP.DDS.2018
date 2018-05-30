package general;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Months;

public class Administrador extends Usuario {
	
	 int adminID;
	 DateTime fechaDeAlta;

	// Constructor
public Administrador(String nombre, String ap, String userName, String password, int numeroId)
	{
		super(nombre,ap,userName,password);
		this.adminID = numeroId;
		DateTime alta = new DateTime();
		this.fechaDeAlta = alta;
	}

public int mesesAdministrando() {
		
		DateTime hoy = new DateTime();
		
		return Months.monthsBetween(fechaDeAlta, hoy).getMonths();
	}


}

