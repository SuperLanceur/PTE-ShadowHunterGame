package effet.action;

import main.Joueur;

public class ActionMultipleChoisir extends ActionMultiple{


	public ActionMultipleChoisir(Action...actions) {
		super(actions);
	}

	/**
	 * Lance l'action d'activer toutes les actions contenues dans ActionMultiple.
	 * @param j1 Le joueur qui lance l'action
	 * @param j2 Le joueur qui subit l'action
	 * @return void
	 */
	@Override
	public void affecte(Joueur j1, Joueur j2) {
		
		Action a = (Action) j1.choisir(this.getList(), Action.class);
		a.affecte(j1, j2);
	}
}
