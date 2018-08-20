package controlador;

import controlador.Subject;

public abstract class Observer
{
	public Subject subject;
	
	public Observer(Subject sujetoAObservar)
	{
		subject = sujetoAObservar;
	}
	
	public abstract void Update();
}
