package effet;

import main.Joueur;

public class ActionAttaquer extends Action {

	/**
	 * Lance l'action d'attaquer
	 * @param j1 Le joueur qui attaque
	 * @param j2 Le joueur qui subit l'attaque
	 * @return void
	 */
	@Override
	public void affecte(Joueur j1, Joueur j2) {
		j1.attaquer(j2);
	}

}