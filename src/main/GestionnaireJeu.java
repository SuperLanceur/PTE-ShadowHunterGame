package main;

import java.util.List;

import com.sun.tools.javac.Main;

import effet.Effet;

public class GestionnaireJeu {
	
	
	private static GestionnaireJeu gj;	
	private Plateau plateau;
	
	private GestionnaireJeu() {}
	
	public static synchronized GestionnaireJeu getGestionnaireJeu(){
        if(gj == null){
            gj = new GestionnaireJeu();
        }
        return gj;
    }
	
	public static void main(String[] args) {
	
		try {
			Main.main(null);
		} catch (Exception e) {
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

	public void setConfiguration(Configuration c) {
		
		List<Joueur> joueurs = c.toJoueurs();
		this.plateau = new Plateau(joueurs);	
	}
}
