package controlador;

public interface SensorSubject {

    public void attach(CondicionObserver observador);
    public void detach(CondicionObserver observador);
    public void notify(Double unValor);
}
