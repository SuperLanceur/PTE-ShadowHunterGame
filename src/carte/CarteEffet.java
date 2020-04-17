package carte;

import main.Joueur;
import effet.Effet;

public abstract class CarteEffet extends Carte{

	private Effet effet;
	
	
	/*
	 * 	@param j Appel la méthode utiliser de effet sur le joueur j
	 */
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
