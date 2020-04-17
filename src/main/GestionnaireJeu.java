package main;

public class GestionnaireJeu {
	private Plateau plateau;
	
	public GestionnaireJeu (Plateau p) {
		plateau = p;
	}
	
	public Plateau getPlateau() {
		return plateau;
	}

	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}

	public void lancerPartie(Configuration c) {
		//TODO
	}
	
	public Configuration lancerConfiguration() {
		//TODO
		return null;
	}

}
