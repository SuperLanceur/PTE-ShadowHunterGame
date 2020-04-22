package main;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import carte.CarteLieu;
import effet.Effet;
import personnage.CartePersonnage;



public class Joueur {
	private GestionnaireEquipements gestionnaireEquipements;
	private String nom;
	private boolean revele;
	private Plateau plateau;
	private CartePersonnage cartePersonnage;
	private Equipe equipe;
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
	
	public enum Equipe{
		NEUTRE,
		SHADOW,
		HUNTER
	}
	
	public Joueur(String nom) {
		this.nom = nom;
		this.revele = false;
		
		
		stats = new HashMap<>();
		
		
		// Initialisation joueur depuis valeurs perso
		
		//stats.put(PLAYER_HP, char.getHP());
		//stats.put(PLAYER_TURN, 1);		
		//stats.put(PLAYER_DAMAGE, 0); - dégats en +
		//stats.put(PLAYER_RESISTANCE, 0);
		//stats.put(PLAYER_REVEAL, 0);
		//stats.put(PLAYER_IMMUNITY, 0); 
		// immunité à certains effets?
	}
		
	//shadows, hunters ou neutre
	public Equipe getEquipe() {
		return this.equipe;
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
	
	
	public int getNbEquipments() {
		return gestionnaireEquipements.getNbEquipments();
	}

	public List<Joueur> getJoueursAdjacents() {
		
		List<Joueur> joueurs = this.carteLieu.getJoueursAdjacents();
		joueurs.remove(this);
		return joueurs;
	}

	public Equipement[] getEquipements() {
		// TODO Auto-generated method stub
		return null;
	}

	public void voler(Joueur j2, Equipement equipement) {
		// TODO Auto-generated method stub
		
	}

	public Equipement choisir(Equipement[] equipements) {
		// TODO Auto-generated method stub
		return null;
	}

	public void attaquer(Joueur j2, int attaqueDice) {
		
		int blessure = evaluerImmunite(j2)*(this.evaluerAttaque(j2) + attaqueDice);
		
		if(blessure > 0)
		{
			j2.addToStat(PLAYER_HP, -blessure);
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
		this.setStat(Joueur.PLAYER_HP,valeurBase+valeur);
	}


	public Plateau getPlateau() {
		return this.plateau;
	}

	public Joueur choisirAdjacents() {
		// TODO Auto-generated method stub
		return null;
	}

	public Effet choisir(Effet[] effets) {
		// TODO Auto-generated method stub
		return null;
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

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
		
	}

	public void setPlateau(Plateau plateau2) {
		this.plateau = plateau2;
	}

	public boolean choisir() {
		// TODO Auto-generated method stub
		return false;
	}

	public void utiliserEffetLieu() {
		this.carteLieu.utiliser(this);	
	}

	public void deplacer(CarteLieu cl) {

		if(this.carteLieu != null){
			this.carteLieu.remove(this);
		}
		
		this.carteLieu = cl;
		
	}

	public Joueur choisirTous() {
		// TODO Auto-generated method stub
		return null;
	}

	public CarteLieu getCarteLieu() {
		return this.carteLieu;
	}
	
	public String getNom() {
		return this.nom;
	}

}
