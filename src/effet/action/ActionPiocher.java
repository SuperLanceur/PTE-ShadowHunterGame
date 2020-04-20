package effet.action;

import main.Joueur;

public class ActionPiocher extends Action{

	public ActionPiocher() {
		super();
	}
	
	/**
	 * Lance l'action de piocher une carte.
	 * @param j1 Le joueur qui lance l'action
	 * @param j2 Le joueur qui subit l'action
	 * @return void
	 */
	@Override
	public void affecte(Joueur j1, Joueur j2) {
		j2.piocher();
	}

}
