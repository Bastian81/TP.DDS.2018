package general;

import org.apache.commons.math3.optim.*;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import simplex.SimplexFacade;
import dispositivo.Dispositivo;
import dispositivo.Inteligente;

public class SimplexManager extends SimplexFacade{
	
	boolean ahorroAutomatico;
	PointValuePair solucion;
	
	public SimplexManager()
	{
		super(GoalType.MAXIMIZE, true);
		ahorroAutomatico = false;
	}
	
	public void procesardispositivosInteligentes(List<Inteligente> dispositivosInteligentes)
	{
		List<Float> consumosHorarios = dispositivosInteligentes.stream()
            .map(disp -> (disp.getConsumo()))
            .collect(Collectors.toList());
		
		double[] primConsumosHs = consumosHorarios.stream().mapToDouble(Float::doubleValue).toArray();
			
		crearFuncionEconomica(primConsumosHs);
		//agregar restricciones de tabla cargada via JSON
		solucion = resolver();
		
		if(ahorroAutomatico)
		{
			int i;
			for(i = 0; i < dispositivosInteligentes.size(); i++)
			{
				Inteligente disp = dispositivosInteligentes.get(i);
				double horas = disp.getUsoTotalDelMesActualEnHoras();
				if(horas > solucion.getPoint()[i])
					disp.apagar();
			}
		}
	}
	
	public double getHorasRecomendadas(List<Inteligente> dispositivosInteligentes, Dispositivo disp)
	{
		int index = dispositivosInteligentes.indexOf(disp);
		return solucion.getPoint()[index];
	}

	public void activarAhorroAutomatico(){
		ahorroAutomatico = true;
	}

	public void desactivarAhorroAutomatico(){
		ahorroAutomatico = false;
	}
}