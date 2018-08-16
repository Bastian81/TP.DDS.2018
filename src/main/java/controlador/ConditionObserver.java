package controlador;

public interface ConditionObserver {

public void agregarRegla(Regla unaRegla);

public void Update(Double unValor);

public int validacion (Double unValor);

public boolean getEstado();
}
