package effet.action;

import main.Joueur;

public class ActionReveal extends Action {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7972405763634156578L;
	
	@Override
	public void affecte(Joueur j1, Joueur j2) {
		j2.reveal();
	}

	@Override
	public String toString() {
		return "Se réveler";
	}
}
