package dispositivo;

import general.Cliente;

import javax.persistence.*;

@MappedSuperclass
public abstract class Dispositivo {


    @Id
            @GeneratedValue
    int id;

    @ManyToOne
    public Cliente cliente;

    private String nombre;
    private int nroSerial;
    private Float consumo;

    String nombreUsuario;

    public Dispositivo(String nombre, Float consumo, int nroSerial)
    {
        this.nombre = nombre;
        this.consumo = consumo;
        this.nroSerial = nroSerial;
    }

    public Dispositivo(String nombre, Float consumo, int nroSerial,String nombreUsuario)
    {
        this.nombre = nombre;
        this.consumo = consumo;
        this.nroSerial = nroSerial;
        this.nombreUsuario = nombreUsuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNroSerial() {
        return nroSerial;
    }

    public void setNroSerial(int nroSerial) {
        this.nroSerial = nroSerial;
    }

    public void setConsumo(Float consumo) {
        this.consumo = consumo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int nroSerial() {return nroSerial;}
    public String getNombre() {return nombre;}
    public Float getConsumo() {return consumo;}
    public Boolean esInt() {return false;}

    public int puntos() {return 0;}


    // Para cambiar estado del dispositivo
    // public void estado(Boolean nuevoEstado) {estado = nuevoEstado;}

}
