package main;

import java.util.ArrayList;
import java.util.List;

import com.sun.tools.javac.Main;

import effet.Effet;

public class GestionnaireJeu {
	
	
	private Plateau plateau;
	
	
	public GestionnaireJeu() {
		this.plateau = new Plateau(new ArrayList<Joueur>());
		
	}
	
	public static void main(String[] args) {
	
		try {
			Main.main(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
