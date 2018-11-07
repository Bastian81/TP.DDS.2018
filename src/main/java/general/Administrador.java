package general;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.joda.time.Months;

import javax.persistence.*;

@Entity
@Table (name = "Administradores")
public class Administrador extends Usuario {

	@Transient
	//@Temporal
			DateTime fechaDeAlta;


	// Constructor

	public Administrador(String nombre, String ap, String userName, String password, int numeroId) //
	{
		super(nombre,ap,userName,password);
		this.adminId = numeroId;
		DateTime alta = new DateTime();
		this.fechaDeAlta = alta;
	}

	public Administrador(String nombre, String ap, String userName, String password,DateTime fechaAlta, int numeroId)// ,int numeroId
	{
		super(nombre,ap,userName,password);
		this.adminId = numeroId;
		this.fechaDeAlta = fechaAlta;
	}

	public int mesesAdministrando() {

		DateTime hoy = new DateTime();

		return Months.monthsBetween(fechaDeAlta, hoy).getMonths();
	}


}

