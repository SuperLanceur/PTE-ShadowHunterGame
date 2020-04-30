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
	
	private Map<Integer, Joueur> mapJoueurs;
	
	private Plateau plateau;
	private PlateauController pc;
	
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

	public void lancerPartie() {
		this.plateau.jeu();
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
	
	public void setConfiguration(Configuration c) {
	
		Map<Integer, Joueur> mapJoueurs = convertConfiguration(c);
		this.mapJoueurs = mapJoueurs;
		
		List<Joueur> joueurs = new ArrayList();
		
		for(Joueur j : mapJoueurs.values()) {
			joueurs.add(j);
		}
		
		this.plateau = new Plateau(joueurs);
		
	}

	public Map<Integer, Joueur> convertConfiguration(Configuration c) {
		
		return c.toJoueurs();
	}

	public Map<Integer, Joueur> getMapJoueurs() {
		return this.mapJoueurs;
	}

	public void setPlateauController(PlateauController pc2) {
		this.pc = pc2;
		
	}
}
