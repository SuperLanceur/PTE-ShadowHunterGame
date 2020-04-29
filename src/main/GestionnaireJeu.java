package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import effet.Effet;
import ihm.controller.PlateauController;

public class GestionnaireJeu {
	
	private static GestionnaireJeu gj;	

	private View view;
	
	private static Plateau plateau;
	private static PlateauController pc;
	
	private GestionnaireJeu() {}
	
	public static synchronized GestionnaireJeu getGestionnaireJeu(){
        if(gj == null){
            gj = new GestionnaireJeu();
        }
        return gj;
    }

	
	public Plateau getPlateau() {
		return plateau;
	}

	public static void lancerPartie() {
		plateau.jeu();
	}
	
	public void jouer(Configuration c) {
		
	}
	
	public static Configuration lancerConfiguration() {	
		//TODO
		return null;
	}

	public Joueur choisirParmisTous(Joueur joueur, List<Joueur> joueurs) {
		return joueurs.get(0);
		
	}

	public Effet choisirEffet(Joueur joueur, Effet[] effets) {
		return effets[0];
	}

	public Joueur choisirAdjacents(Joueur joueur, List<Joueur> joueurs) {
		return joueurs.get(0);
	}

	public boolean choisir(Joueur joueur) {
		try {
			return pc.choisir(joueur);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public void rollDice(Joueur joueur, int typeDice, int ... rolls){
		
		pc.rollDice(joueur,typeDice,rolls);
		
	}

	public static void setConfiguration(Configuration c) {
		
		List<Joueur> joueurs = new ArrayList<Joueur>();
		
		for(Joueur j : c.toJoueurs().values()) {
			joueurs.add(j);
		}
		
		plateau = new Plateau(joueurs);	
	}

	public static Map<Integer, Joueur> getJoueursMap(Configuration c) {
		return c.toJoueurs();
		
	}

	public static void setPlateauController(PlateauController pc2) {
		pc = pc2;
		
	}
}
