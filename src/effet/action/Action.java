package effet.action;

import java.io.Serializable;

import main.Joueur;

public abstract class Action implements Serializable{


	private static final long serialVersionUID = 4290735254363171340L;

	public abstract void affecte(Joueur j1, Joueur j2);
	
}
