package controlador;

public interface ConditionObserver {

    public boolean estadoCondicion = false;

public void Update(Double unValor);

public int validacion (Double unValor);

public boolean getEstado();
}
