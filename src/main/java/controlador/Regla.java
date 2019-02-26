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

    int nroSerialDisp;

    public Regla (String nombreRegla, Inteligente unDispositivo) {
        nombre = nombreRegla;
    }

    public Regla(String nombre, List<Actuador> actuadores, List<Condicion> condiciones, int nroSerialDisp) {

        this.nombre = nombre;
        this.actuadores = actuadores;
        this.condiciones = condiciones;
        this.nroSerialDisp = nroSerialDisp;
    }

    public Regla(int idRegla, String nombre, int nroSerialDisp) {
        this.idRegla = idRegla;
        this.nombre = nombre;
        this.nroSerialDisp = nroSerialDisp;
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

    public int getIdRegla() {
        return idRegla;
    }

    public void setIdRegla(int idRegla) {
        this.idRegla = idRegla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Actuador> getActuadores() {
        return actuadores;
    }

    public void setActuadores(List<Actuador> actuadores) {
        this.actuadores = actuadores;
    }

    public List<Condicion> getCondiciones() {
        return condiciones;
    }

    public void setCondiciones(List<Condicion> condiciones) {
        this.condiciones = condiciones;
    }

    public int getNroSerialDisp() {
        return nroSerialDisp;
    }

    public void setNroSerialDisp(int nroSerialDisp) {
        this.nroSerialDisp = nroSerialDisp;
    }
}
