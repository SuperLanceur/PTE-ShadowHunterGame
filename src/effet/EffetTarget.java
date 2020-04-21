package effet;

import effet.action.Action;
import main.Joueur;

public class EffetTarget extends Effet{

	private Joueur target;
	
	public EffetTarget(Action action) {
		super(action);
	}
	
	public void setTarget(Joueur target) {
		this.target = target;
	}

	public void utiliser(Joueur joueur) {
		this.getAction().affecte(joueur, target);
	}
	
}
