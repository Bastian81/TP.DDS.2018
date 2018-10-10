package datos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TipoDispositivo {
    byte minimo,maximo;
    String nombre;

    @Id
    int id;


    public byte getMinimo() {
        return minimo;
    }

    public byte getMaximo() {
        return maximo;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
