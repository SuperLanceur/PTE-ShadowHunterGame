package ihm;

public class Couple {
	private String nom;
	private boolean ia; // true -> joueur virtuel
	
	public Couple (String nom, boolean ia) {
		this.nom = nom;
		this.ia = ia;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public boolean isIa() {
		return ia;
	}

	public void setIa(boolean ia) {
		this.ia = ia;
	}

}
