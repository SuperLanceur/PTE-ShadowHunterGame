package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import carte.Carte;

public class Plateau {
	private List<Joueur> joueurs;
	private List<CarteLieu> lieux;
	

	public static final String NB_HUNTERS = "nb_hunters";
	public static final String NB_SHADOWS = "nb_shadows";
	public static final String NB_NEUTRES = "nb_neutres";
	public static final String NB_MORTS = "nb_morts";
	public static final String NB_MORTS_NEUTRAL = "nb_morts_neutral";
	public static final String NB_MORTS_HUNTER = "nb_morts_hunter";
	public static final String NB_MORTS_SHADOW = "nb_morts_shadow";
	public static final String PARTIE_FINIE = "partie_finie";
	
	private Map<String, Integer> stats;
	
	
	private Pioche<TypeLumiere> piocheLumiere;
	private Pioche<TypeTenebre> piocheTenebre;
	private Pioche<TypeVision> piocheVision;
	
	
	
	public Plateau(List<Joueur> joueurs) {
		this.joueurs = joueurs;
		this.lieux = new ArrayList<>();
		
		stats = new HashMap<>();
		
		// Initialisation plateau
		stats.put(NB_HUNTERS, 0);
		stats.put(NB_SHADOWS, 0);
		stats.put(NB_NEUTRES, 0);
		stats.put(NB_MORTS, 0);
		stats.put(NB_MORTS_NEUTRAL, 0);
		stats.put(NB_MORTS_HUNTER, 0);
		stats.put(NB_MORTS_SHADOW, 0);
		stats.put(PARTIE_FINIE, 0);
		
	}	
	
	public int rollDices() {
		//pas necessaire?
		return 0;
	}
	
	public void fairePiocher(Joueur joueur, Type type) {
		
	}
	
	public void déplacerJoueur(Joueur joueur, int indexLieu) {
		
	}
	
	public void attaquer(Joueur joueur1, Joueur joueur2) {
		
	}
	
	
	public Joueur selectionnerJoueur() {
		return new Joueur("0");
	}
	
	public int sumRolls() {
		//pas necessaire?
		return 0;
	}
	
	public int roll4() {
		return (int) Math.floor(Math.random() * 3)+1;
	}

	public int rollDices4() {
		return Math.abs(roll4() - roll4());
	}
	
	public int rollDices6() {
		return roll6() + roll6();
	}
	
	public int roll6() {
		return (int) Math.floor(Math.random() * 5)+1;
	}

	public List<Joueur> getJoueurs() {
		return this.joueurs;
	}

	public int getStat(String key) {
		if(this.stats.containsKey(key))
		{
			return this.getStat(key);
		}else {
			
			//TODO Exception
			return -1;
		}
		
	}
}
