package main;

import java.util.List;

import effet.Effet;

public class GestionnaireJeu {
	private Plateau plateau;
	private View view;
	
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

	public Joueur choisirParmisTous(Joueur joueur, List<Joueur> joueurs) {
		return joueur;
		// TODO Auto-generated method stub
		
	}

	public Effet choisirEffet(Joueur joueur, Effet[] effets) {
		// TODO Auto-generated method stub
		return null;
	}

	public Joueur choisirAdjacents(Joueur joueur, List<Joueur> joueurs) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean choisir(Joueur joueur) {
		// TODO Auto-generated method stub
		return false;
	}
	

	
}
