package controlador;

public interface Subject {

    public void attach(Observer observador);
    public void detach(Observer observador);
    public void notificar();
}
