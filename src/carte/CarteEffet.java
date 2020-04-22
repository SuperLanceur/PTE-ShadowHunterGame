package carte;

import main.Joueur;
import effet.Effet;

public abstract class CarteEffet extends Carte{

	private Effet effet;
	
	public CarteEffet(String nom, String description) {
		super(nom, description);

	}
	
	/*
	 * 	@param j Appel la méthode utiliser de effet sur le joueur j
	 */
	public void utiliser(Joueur j) {
		this.effet.utiliser(j);
	}
	
	public void setEffet(Effet e) {
		this.effet = e;
	}
	
	public Effet getEffet() {
		return this.effet;
	}
}
