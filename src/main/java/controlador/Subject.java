package controlador;
import java.util.ArrayList;

public abstract class Subject
{	
	private ArrayList<Observer> observadores = new ArrayList<Observer>();

    public void attach(Observer observador)
	{
		observadores.add(observador);
	}
    public void detach(Observer observador)
	{
		observadores.remove(observador);
	}
	
	public void notifyObservers()
	{
        for (int i = 0; i < observadores.size(); i++)
            observadores.get(i).Update();
    }
}
