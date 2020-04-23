package main;

import java.util.List;

public class View{
	
	
	public static void initPartie(List<Joueur> joueurs) {
				
	}
	
	public static void lancerPartie() {
			
	}

	public static void menu() throws Exception {
		
	}
	
	public static void applyConfiguration(Configuration c) {
		
		GestionnaireJeu gj = GestionnaireJeu.getGestionnaireJeu();
		gj.setConfiguration(c);
	}
	
	public static List<Joueur> getJoueurs() {
		return null;
	}
}
