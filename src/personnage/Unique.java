package personnage;

import main.Joueur;

public abstract class Unique extends CartePersonnage{
	
	private boolean capaciteUsed;
	
	public Unique(String nom, String desc ,int hp, Joueur joueur) {
		super(nom,desc, hp, joueur);
		
	}
	
	public boolean isCapaciteUsed() {
		return capaciteUsed;
	}

	public void setCapaciteUsed(boolean capaciteUsed) {
		this.capaciteUsed = capaciteUsed;
	}
}
