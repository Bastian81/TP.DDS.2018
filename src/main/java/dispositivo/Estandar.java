package dispositivo;

public class Estandar extends Dispositivo{
    int horasPorDia;
    public Estandar(String nombre, Float consumo, int nroSerial,int horasPorDia)
    {
        super(nombre,consumo,nroSerial);
        this.horasPorDia = horasPorDia;
    }




    //Posee el consumo estandar que esta en Dispositivo
}
