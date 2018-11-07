package dispositivo;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Dispositivo {


    @Id
            @GeneratedValue
    int id;

    private String nombre;
    private int nroSerial;
    private Float consumo;

    public Dispositivo(String nombre, Float consumo, int nroSerial)
    {
        this.nombre = nombre;
        this.consumo = consumo;
        this.nroSerial = nroSerial;

    }

    public int nroSerial() {return nroSerial;}
    public String getNombre() {return nombre;}
    public Float getConsumo() {return consumo;}
    public Boolean esInt() {return false;}

    public int puntos() {return 0;}


    // Para cambiar estado del dispositivo
    // public void estado(Boolean nuevoEstado) {estado = nuevoEstado;}

}
