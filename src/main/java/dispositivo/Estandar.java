package dispositivo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "Estandares")
public class Estandar extends Dispositivo{
    int horasPorDia;
    public Estandar(String nombre, Float consumo, int nroSerial,int horasPorDia)
    {
        super(nombre,consumo,nroSerial);
        this.horasPorDia = horasPorDia;
    }

    public Estandar(String nombre, Float consumo, int nroSerial, String nombreUsuario, int horasPorDia) {
        super(nombre, consumo, nroSerial, nombreUsuario);
        this.horasPorDia = horasPorDia;
    }

    public int getHorasPorDia() {
        return horasPorDia;
    }

    public void setHorasPorDia(int horasPorDia) {
        this.horasPorDia = horasPorDia;
    }
//Posee el consumo estandar que esta en Dispositivo
}
