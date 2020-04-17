package effet;

import carte.Joueur;

public abstract class Effet {

	private Action action;
	
	public Effet()
	{
		
	}
	
	
	public abstract void utiliser(Joueur joueur);


	public Action getAction() {
		return action;
	}


	public void setAction(Action action) {
		this.action = action;
	}
	
}
