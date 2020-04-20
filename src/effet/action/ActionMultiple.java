package effet.action;

import java.util.List;

import main.Joueur;

public class ActionMultiple extends Action{

	private List<Action> actions;
	
	public ActionMultiple(List<Action> actions)
	{
		super();
		this.actions = actions;
	}

	/**
	 * Lance l'action d'activer toutes les actions contenues dans ActionMultiple.
	 * @param j1 Le joueur qui lance l'action
	 * @param j2 Le joueur qui subit l'action
	 * @return void
	 */
	@Override
	public void affecte(Joueur j1, Joueur j2) {
		
		for(Action action : actions) {
			
			action.affecte(j1, j2);
		}
	}
}
