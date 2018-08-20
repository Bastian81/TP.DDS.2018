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
	
	PointValuePair solucion;
	
	public SimplexManager()
	{
		super(GoalType.MAXIMIZE, true);
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
	}
	
	public double getHorasRecomendadas(List<Inteligente> dispositivos, Dispositivo disp)
	{
		int index = dispositivos.indexOf(disp);
		return solucion.getPoint()[index];
	}
}