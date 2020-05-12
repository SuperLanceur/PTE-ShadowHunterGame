package main;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import carte.CarteEquipement;
import carte.CarteLieu;
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
	
	private void changeStat(String key, int valeur) {
		this.stats.put(key, valeur);
	}
	public void setStat(String key, int valeur) {
		System.out.println(this.nom+" "+this);
		if(key.contentEquals(PLAYER_HP)) {	
			this.plateau.alerationVie(this,valeur);
		}
		this.stats.put(key, valeur);
		updateVictoirePlateau();
		updateVie();
	}
	
	//pour tests IA
	public void setHP(int val) {
		this.stats.put("HP", val);
	}
	
	//pour tests IA
	public void setNbEquip(int val) {
		this.stats.put("nb_equipements", val);
	}
	//pour tests IA
		public void setDamage(int val) {
			this.stats.put("DAMAGE", val);
		}
	
	private void updateVie() {
		int damage = damageTaken();
		this.plateau.updateVieJoueur(this, damage);
	}

	public int damageTaken() {
		System.out.println(this.cartePersonnage.getPv()+ " "+this.getStat(PLAYER_HP));
		return this.cartePersonnage.getPv() - this.getStat(PLAYER_HP);
	}
	
	private void updateVictoirePlateau() {

		int result = victoire() ? 0 : 1;
		this.plateau.setStat(Plateau.PARTIE_FINIE, result);
	}
	
	public boolean victoire() {
		return this.cartePersonnage.victoire();
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

	public List<CarteEquipement> getEquipements() {
		return this.gestionnaireEquipements.getEquipements();
	}

	public void voler(Joueur j2, CarteEquipement equipement) {
		
		j2.gestionnaireEquipements.retirer(equipement);
		this.gestionnaireEquipements.ajouter(equipement);	}

	
	
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

	public boolean getRevele() {
		return this.revele;
	}

	public CartePersonnage getCartePersonnage() {
		return this.cartePersonnage;
	}

	public void setCartePersonnage(CartePersonnage cp) {
		this.cartePersonnage = cp;
		this.changeStat(PLAYER_HP, cp.getPv());
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

	public void ajouterEquipement(CarteEquipement equipement) {
		this.gestionnaireEquipements.ajouter(equipement);	
	}

	public void retirerEquipement(CarteEquipement equipement) {
		this.gestionnaireEquipements.retirer(equipement);	
	}

	public boolean hasOpponents() {
		List<Joueur> joueursRange = this.getJoueursRange();
		return !joueursRange.isEmpty();
	}
	
	public List<Joueur> getJoueursRange() {
		CarteLieu cl = this.carteLieu;
		List<Joueur> joueurs = new ArrayList<Joueur>();
		joueurs.addAll(cl.getJoueurs());
		joueurs.addAll(cl.getJoueursAdjacents());
		joueurs.remove(this);
		return joueurs;
	}

	public boolean choisir(Contexte activerEffetLieu) {
		return this.plateau.choisir(this, activerEffetLieu);
	}
	
	public Object choisir(List<?> list,Class cls) {
		return this.plateau.choisir(this,list, cls);
	}

	public Joueur choisirAdjacents() {
		return this.plateau.choisirAdjacents(this);
	}
	
	public Joueur choisiParmisTous() {
		return this.plateau.choisirParmisTous(this);
	}

	public void ajouterEquipementIHM(CarteEquipement e) {
		this.plateau.ajouterEquipementIHM(this,e);
		
	}
	
	public void removeEquipementIHM(CarteEquipement e) {
		this.plateau.retirerEquipementIHM(this,e);
		
	}

	

	
}
