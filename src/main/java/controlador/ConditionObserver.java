package controlador;

import java.math.BigDecimal;

public interface ConditionObserver {

    public void Update(BigDecimal unValor)  {
        if (validacion(unValor) = true) {
            Regla.cumpleRegla(boolean true);
        }
        else    {
            Regla.cumpleRegla(boolean false);
        }

    }

    public boolean validacion (BigDecimal unValor);

}
