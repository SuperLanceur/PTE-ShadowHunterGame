package main;

import java.util.HashMap;
import java.util.Map;

import ihm.Couple;

public class Configuration {
	
	private HashMap<Integer, Couple> nomsJoueurs;
	
	//TODO : attribut pour prendre en compte si jeu est normal ou demarrage rapide?
	
	public Configuration (HashMap<Integer, Couple> nomsJoueurs) {
		this.nomsJoueurs = nomsJoueurs;

	}

	public Map<Integer,Joueur> toJoueurs() {
		
		Map<Integer, Joueur> joueurs = new HashMap<Integer, Joueur>();
		
		for(Integer i : nomsJoueurs.keySet()) {
			
			Couple c = nomsJoueurs.get(i);
			
			if(c.isIa()) {
				joueurs.put(i,new JoueurVirtuel(c.getNom(),c.getLvlIa()));
			}else {
				joueurs.put(i,new Joueur(c.getNom()));
			}
		}
		
		return joueurs;
		
	}
	
}
