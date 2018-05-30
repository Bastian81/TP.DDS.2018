package dispositivo;

import estado.Estado;

public class Adaptador extends Inteligente {
    Estandar dispositivoEstandar;
    public Adaptador(String nombre, Float consumo, int nroSerial, byte macAddress, Estado estado)
    {
        super(nombre,consumo,nroSerial,macAddress,estado);
    }
    public void agregarEstandar(Estandar dispEstandar) {dispositivoEstandar = dispEstandar;}

    public int puntos() {return 10;}
}
