package datos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TipoDispositivo {
    float minimo,maximo;
    String nombre;

    @GeneratedValue
    @Id
    int id;


    public float getMinimo() {
        return minimo;
    }

    public float getMaximo() {
        return maximo;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
