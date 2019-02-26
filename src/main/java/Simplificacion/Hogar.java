package Simplificacion;

public class Hogar {
    String nombreCliente;
    double consumo;

    public Hogar(String nombreCliente, double consumo) {
        this.nombreCliente = nombreCliente;
        this.consumo = consumo;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }
}
