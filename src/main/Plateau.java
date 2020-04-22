package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import carte.CarteLieu;

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
	

	public Plateau(List<Joueur> joueurs) {
		
		joueurs.forEach(x -> x.setPlateau(this));
		
		this.joueurs = joueurs;
		this.lieux = new ArrayList<>();
		
		this.stats = new HashMap<>();
		
		// Initialisation plateau
		this.stats.put(NB_HUNTERS, 0);
		this.stats.put(NB_SHADOWS, 0);
		this.stats.put(NB_NEUTRES, 0);
		this.stats.put(NB_MORTS, 0);
		this.stats.put(NB_MORTS_NEUTRAL, 0);
		this.stats.put(NB_MORTS_HUNTER, 0);
		this.stats.put(NB_MORTS_SHADOW, 0);
		this.stats.put(PARTIE_FINIE, 0);
		
		
		
		
	}	
	
	public void jeu() {
		
		int nbJoueurs = this.joueurs.size()-1;
		int i = 1;
		
		while(true) {
			
			Joueur currentJoueur = this.joueurs.get(nbJoueurs % i);
			deplacer(currentJoueur);
			
			if(currentJoueur.choisir()) {
				currentJoueur.utiliserEffetLieu();
			}
			
			if(currentJoueur.choisir()){
				Joueur cible = currentJoueur.choisirAdjacents();
				attaquer(currentJoueur,cible);
			}
			
			i++;
		}
	}
	
	public void deplacer(Joueur currentJoueur) {
		
		
		boolean attributed = false;
		
		while(!attributed) {
			int roll = sumRolls();
			for(CarteLieu cl : lieux) {
				
				if(cl.coordinatesContains(roll) && currentJoueur.getCarteLieu() != cl){
					
					currentJoueur.deplacer(cl);
					attributed = true;
					break;
				}
			}
		}
	}
	
	
	public void attaquer(Joueur joueur1, Joueur joueur2) {
		
		int attaque = diffRolls();
		
		if(attaque != 0) {
			
			joueur1.attaquer(joueur2,attaque);
		}
	}
	
	
	public Joueur selectionnerJoueur() {
		return new Joueur("0");
	}
	
	public int diffRolls() {
		return Math.abs(roll6()-roll4());	
	}
	
	public int roll4() {
		return (int) Math.floor(Math.random() * 3)+1;
	}
	
	public int roll6() {
		return (int) Math.floor(Math.random() * 5)+1;
	}
	
	public int sumRolls()
	{
		return roll6() + roll4();
	}
	
	public List<Joueur> getJoueurs() {
		return this.joueurs;
	}

	public void setStat(String key, int valeur) {
		this.stats.put(key, valeur);
	}
	
	public int getStat(String key) {
		
		if(this.stats.containsKey(key))
		{
			return this.stats.get(key);
		}else {
			
			//TODO Exception
			return -1;
		}
		
	}
	
	public void shuffleLieux(){
		
		this.lieux.forEach(x -> x.setVoisin(null));
		
		if(lieux.size() % 2 == 0) {
			
			Collections.shuffle(lieux);
			
			for(int i = 0; i < lieux.size()-2; i += 2) {
				
				lieux.get(i).setVoisin(lieux.get(i+2));
				lieux.get(i+2).setVoisin(lieux.get(i));
			}
			
		}else {
			
		}
	}
	
	public void setLieux(List<CarteLieu> lieux) {
		this.lieux = lieux;
		shuffleLieux();
	}
}
