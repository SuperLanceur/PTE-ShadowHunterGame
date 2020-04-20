package effet;

import effet.action.Action;
import main.Joueur;

public class EffetSelf extends Effet{

	public EffetSelf(Action action) {
		super(action);
	}

	@Override
	public void utiliser(Joueur joueur) {
		this.getAction().affecte(joueur, joueur);
	}

}
