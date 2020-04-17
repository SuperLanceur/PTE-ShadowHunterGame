package main;

public class Configuration {
	private int nombreJoueurs;
	private int nombreJoueursHumains;
	
	//TODO : attribut pour prendre en compte si jeu est normal ou demarrage rapide?
	
	public Configuration (int nj, int njh) {
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
