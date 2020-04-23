package main;

import java.util.List;

public class Configuration {
	private int nombreJoueurs;
	private int nombreJoueursHumains;
	private List<String> nomsJoueurs;
	
	//TODO : attribut pour prendre en compte si jeu est normal ou demarrage rapide?
	
	public Configuration (List<String> nomsJoueurs,int nj, int njh) {
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
	
}
