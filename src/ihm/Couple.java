package ihm;

public class Couple {
	private String nom;
	private boolean ia; // true -> joueur virtuel
	private int lvlIa;
	
	public Couple (String nom) {
		this.nom = nom;
		this.ia = false;
	}
	
	public Couple (String nom, int niveau) {
		this.nom = nom;
		this.lvlIa = niveau;
		this.ia = true;
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

	public int getLvlIa() {
		return lvlIa;
	}

	public void setLvlIa(int lvlIa) {
		this.lvlIa = lvlIa;
	}
	
	

}
