package main;

import java.util.ArrayList;
import java.util.List;

import effet.Effet;

public class GestionnaireJeu {
	
	
	private Plateau plateau;
	private View view;
	
	
	
	public GestionnaireJeu() {
		this.plateau = new Plateau(new ArrayList<Joueur>());
		
	}
	
	public static void main(String[] args) {
		
		switch(1){
		
		case 1:
			lancerPartie();
		case 2:
			lancerConfiguration();
		default:
			break;
		}
	}
	
	public Plateau getPlateau() {
		return plateau;
	}

	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}

	public static void lancerPartie() {
		
	}
	
	public void jouer(Configuration c) {
		
	}
	
	public static Configuration lancerConfiguration() {
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
