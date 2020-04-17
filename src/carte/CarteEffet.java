package carte;

import main.Joueur;
import effet.Effet;

public abstract class CarteEffet extends Carte{

	private Effet effet;
	
	public void utiliser(Joueur j) {
		effet.utiliser(j);
	}
	
	public void setEffet(Effet e) {
		effet = e;
	}
	
	public Effet getEffet() {
		return effet;
	}
}
