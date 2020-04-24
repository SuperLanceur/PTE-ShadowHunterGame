package main;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import carte.CarteLieu;
import carte.Equipement;
import effet.Effet;
import personnage.CartePersonnage;
import personnage.CartePersonnage.Equipe;



public class Joueur {
	private GestionnaireEquipements gestionnaireEquipements;
	private String nom;
	private boolean revele;
	private Plateau plateau;
	private CartePersonnage cartePersonnage;
	
	private CarteLieu carteLieu;
	
	
	// map keys
	public static final String PLAYER_HP = "hp";
	public static final String PLAYER_TURN = "turn";
	public static final String PLAYER_DAMAGE = "damage";
	public static final String PLAYER_RESISTANCE = "resistance";
	public static final String PLAYER_REVEAL = "reveal";
	public static final String PLAYER_IMMUNITY = "immunity";
	public static final String PLAYER_NB_EQUIPEMENTS = "nb_equipements";
	
	private Map<String, Integer> stats;
	
	
	
	public Joueur(String nom) {
		
		if(nom == null) {
			this.nom = "errorNamePlayer";
		}
		this.nom = nom;
		this.revele = false;
		this.gestionnaireEquipements = new GestionnaireEquipements(this);
		
		stats = new HashMap<>();
		
		
		// Initialisation joueur depuis valeurs perso
		
		stats.put(PLAYER_HP, 20);
		//stats.put(PLAYER_TURN, 1);		
		stats.put(PLAYER_DAMAGE, 0);
		stats.put(PLAYER_NB_EQUIPEMENTS, 0);
		stats.put(PLAYER_RESISTANCE, 0);
		stats.put(PLAYER_REVEAL, 0);
		stats.put(PLAYER_IMMUNITY, 0); 
		// immunité à certains effets?
	}
		
	//shadows, hunters ou neutre
	public Equipe getEquipe() {
		return this.cartePersonnage.getEquipe();
	}
	
	public void setStat(String key, int valeur) {
		
		// TODO Il faut créer des observers de mort
		this.stats.put(key, valeur);
	}
	
	public int getStat(String key) {
	
		if(stats.containsKey(key)) {
			return stats.get(key);
		}else {
			
			return -1;
		}		
	}


	public List<Joueur> getJoueursAdjacents() {
		
		List<Joueur> joueurs = this.carteLieu.getJoueursAdjacents();
		joueurs.remove(this);
		return joueurs;
	}

	public List<Equipement> getEquipements() {
		return this.gestionnaireEquipements.getEquipements();
	}

	public void voler(Joueur j2, Equipement equipement) {
		
		j2.gestionnaireEquipements.retirer(equipement);
		this.gestionnaireEquipements.ajouter(equipement);	}

	public Equipement choisir(List<Equipement> equipements) {
		// TODO Auto-generated method stub
		return null;
	}

	public void attaquer(Joueur j2, int attaqueDice) {
		
		int blessure = evaluerImmunite(j2)*(this.evaluerAttaque(j2) + attaqueDice);
		
		if(blessure > 0)
		{
			this.cartePersonnage.attaquer(j2, blessure);
		}
	}
	
	private int evaluerAttaque(Joueur j2) {
		
		return this.getStat(PLAYER_DAMAGE)-j2.getStat(PLAYER_RESISTANCE);
	}

	private int evaluerImmunite(Joueur j2) {
		
		int nbToursImmune = j2.getStat(PLAYER_IMMUNITY);
		
		return nbToursImmune > 0 ? 0 : 1;
	}
	
	public void addToStat(String key, int valeur)
	{
		int valeurBase = this.getStat(key);
		this.setStat(key,valeurBase+valeur);
	}


	public Plateau getPlateau() {
		return this.plateau;
	}
	
	public boolean choisir() {
		return this.plateau.choisir(this);
	}
	
	public Joueur choisirAdjacents() {
		return this.plateau.choisirAdjacents(this);
	}

	public Effet choisir(Effet[] effets) {
		return this.plateau.choisirEffet(this,effets);
	}
	
	public Joueur choisiParmisTous() {
		return this.plateau.choisirParmisTous(this);
	}

	public boolean getRevele() {
		return this.revele;
	}

	public CartePersonnage getCartePersonnage() {
		return this.cartePersonnage;
	}

	public void setCartePersonnage(CartePersonnage cp) {
		this.cartePersonnage = cp;
	}

	public void setPlateau(Plateau plateau2) {
		this.plateau = plateau2;
	}

	

	public void utiliserEffetLieu() {
		this.carteLieu.utiliser(this);	
	}

	public void deplacer(CarteLieu cl) {

		if(this.carteLieu != null){
			this.carteLieu.remove(this);
		}
	
		this.carteLieu = cl;
		cl.ajouterJoueur(this);
	}

	

	public CarteLieu getCarteLieu() {
		return this.carteLieu;
	}
	
	public String getNom() {
		return this.nom;
	}
	public void reveal() {
		this.revele = true;
	}
	
	public void setRevele(boolean b) {
		this.revele = b;
	}

	public void ajouterEquipement(Equipement equipement) {
		this.gestionnaireEquipements.ajouter(equipement);	
	}

	public void retirerEquipement(Equipement equipement) {
		this.gestionnaireEquipements.retirer(equipement);	
	}

	public boolean hasOpponents() {
		CarteLieu cl = this.carteLieu;
		List<Joueur> joueurs = new ArrayList<Joueur>();
				
		joueurs.addAll(cl.getJoueurs());
		joueurs.addAll(cl.getJoueursAdjacents());
		joueurs.remove(this);
		
		return !joueurs.isEmpty();
	}

}
