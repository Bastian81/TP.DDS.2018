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
	
	public void procesarDispositivos(List<Inteligente> dispositivos)
	{
		List<Float> consumosHorarios = dispositivos.stream()
            .map(disp -> (disp.getConsumo()))
            .collect(Collectors.toList());
		
		double[] primConsumosHs = consumosHorarios.stream().mapToDouble(Float::doubleValue).toArray();
			
		crearFuncionEconomica(primConsumosHs);
		//agregar restricciones de tabla cargada via JSON
		solucion = resolver();
		
		if(ahorroAutomatico)
		{
			int i;
			for(i = 0; i < dispositivos.size(); i++)
			{
				Inteligente disp = dispositivos.get(i);
				double horas = disp.getUsoTotalDelMesActualEnHoras();
				if(horas > solucion.getPoint()[i])
					disp.apagar();
			}
		}
	}
	
	public double getHorasRecomendadas(List<Inteligente> dispositivos, Dispositivo disp)
	{
		int index = dispositivos.indexOf(disp);
		return solucion.getPoint()[index];
	}
}