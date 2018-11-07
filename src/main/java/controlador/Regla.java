package controlador;


import java.util.ArrayList;
import java.util.List;

import controlador.condicion.Condicion;
import dispositivo.Inteligente;
import controlador.actuador.Actuador;

import javax.persistence.*;

@Entity
public class Regla {

    @Id
    @GeneratedValue
    int idRegla;

    String nombre;

    //@OneToMany(mappedBy = "zona", cascade = CascadeType.ALL)
    @Transient
    public List<Actuador> actuadores = new ArrayList<>();
    //@OneToMany(mappedBy = "zona", cascade = CascadeType.ALL)
    @Transient
    public List<Condicion> condiciones = new ArrayList<>();

public Regla (String nombreRegla, Inteligente unDispositivo) {

    nombre = nombreRegla;

}

public void agregarCondicion(Condicion condicion) {

    condiciones.add(condicion);
}

public void agregarActuador(Actuador actuador) {

    actuadores.add(actuador);
}

public boolean cumpleRegla() {

    return condiciones.stream().allMatch(condicion -> condicion.getEstado());
}

public void actuar(){

    if( this.cumpleRegla() ) {

        actuadores.forEach(actuador -> actuador.actuar());
    }
}
}
