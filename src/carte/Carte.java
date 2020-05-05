package carte;

import java.io.Serializable;

import main.Joueur;

public abstract class Carte implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3227553705226975570L;
	private String nom;
	private String description;
	
	public Carte(String nom, String description) {
		this.setNom(nom);
		this.setDescription(description);
	}
	
	public abstract void utiliser(Joueur j);

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
