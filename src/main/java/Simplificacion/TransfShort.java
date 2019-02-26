package Simplificacion;

import geoposicionamiento.Transformador;

public class TransfShort {
    String nombreTrans;
    double consumo;

    public TransfShort(String nombreTrans, double consumo) {
        this.nombreTrans = nombreTrans;
        this.consumo = consumo;
    }

    public String getNombreTrans() {
        return nombreTrans;
    }

    public void setNombreTrans(String nombreTrans) {
        this.nombreTrans = nombreTrans;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }
}
