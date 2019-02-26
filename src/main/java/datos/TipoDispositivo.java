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

    public TipoDispositivo(String nombre, float minimo, float maximo) {
        this.minimo = minimo;
        this.maximo = maximo;
        this.nombre = nombre;
    }

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
