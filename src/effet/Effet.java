package effet;

import java.io.Serializable;

import effet.action.Action;
import main.Joueur;

public abstract class Effet implements Serializable{

	private static final long serialVersionUID = 1121660401755188715L;
	
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
