package personnage;

import condition.Condition;
import main.Joueur;

public class Unique extends CartePersonnage{
	
	private boolean capaciteUsed;
	
	public Unique(String nom, int hp, Joueur joueur,Condition condition,boolean capaciteUsed) {
		super(nom, hp, joueur, condition);
		this.setCapaciteUsed(capaciteUsed);
	}

	public boolean isCapaciteUsed() {
		return capaciteUsed;
	}

	public void setCapaciteUsed(boolean capaciteUsed) {
		this.capaciteUsed = capaciteUsed;
	}

}
