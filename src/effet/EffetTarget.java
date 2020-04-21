package effet;

import effet.action.Action;
import main.Joueur;

public abstract class EffetTarget extends Effet{

	public EffetTarget(Action action) {
		super(action);
	}

	public abstract void utiliser(Joueur joueur);
	
}
