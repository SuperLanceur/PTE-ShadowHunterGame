package main;

import java.util.HashMap;
import ihm.Couple;

public class Configuration {
	private int nombreJoueurs;
	private int nombreJoueursHumains;
	private HashMap<Integer, Couple> nomsJoueurs;
	
	//TODO : attribut pour prendre en compte si jeu est normal ou demarrage rapide?
	
	public Configuration (HashMap<Integer, Couple> nomsJoueurs,int nj, int njh) {
		this.nomsJoueurs = nomsJoueurs;
		nombreJoueurs = nj;
		nombreJoueursHumains = njh;
	}

	public int getNombreJoueurs() {
		return nombreJoueurs;
	}

	public int getNombreJoueursHumains() {
		return nombreJoueursHumains;
	}

	public List<Joueur> toJoueurs() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
