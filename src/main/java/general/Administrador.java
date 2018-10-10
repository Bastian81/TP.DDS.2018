package general;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.joda.time.Months;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Administrador extends Usuario {

	@Transient
	DateTime fechaDeAlta;

	@Id
	@GeneratedValue
	int adminID;
	// Constructor

public Administrador(String nombre, String ap, String userName, String password, int numeroId)
	{
		super(nombre,ap,userName,password);
		this.adminID = numeroId;
		DateTime alta = new DateTime();
		this.fechaDeAlta = alta;
	}

	public Administrador(String nombre, String ap, String userName, String password,DateTime fechaAlta ,int numeroId)
	{
		super(nombre,ap,userName,password);
		this.adminID = numeroId;
		this.fechaDeAlta = fechaAlta;
	}

public int mesesAdministrando() {
		
		DateTime hoy = new DateTime();
		
		return Months.monthsBetween(fechaDeAlta, hoy).getMonths();
	}


}

