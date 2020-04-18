package personnage;

import condition.Condition;
import main.Joueur;

public class Unique extends CartePersonnage{
	
	private boolean capaciteUsed;
	
	public Unique(String nom, int hp, Joueur joueur,boolean capaciteUsed) {
		super(nom, hp, joueur);
		this.setCapaciteUsed(capaciteUsed);
	}

	public boolean isCapaciteUsed() {
		return capaciteUsed;
	}

	public void setCapaciteUsed(boolean capaciteUsed) {
		this.capaciteUsed = capaciteUsed;
	}

}
