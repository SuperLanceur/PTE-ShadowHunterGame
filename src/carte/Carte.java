package carte;

import main.Joueur;

public abstract class Carte {

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
