package carte;

import main.Joueur;

import java.io.Serializable;

import effet.Effet;

public abstract class CarteEffet extends Carte implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5248405395465365805L;
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
