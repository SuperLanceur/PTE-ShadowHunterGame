package effet;

import main.Joueur;

public abstract class Effet {

	private Action action;
	
	public Effet(Action action)
	{
		this.action = action;
	}
	
	public abstract void utiliser(Joueur joueur);


	public Action getAction() {
		return action;
	}


	public void setAction(Action action) {
		this.action = action;
	}
	
}
