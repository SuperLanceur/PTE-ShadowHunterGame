package main;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import effet.Effet;
import personnage.CartePersonnage;



public class Joueur {
	private GestionnaireEquipements gestionnaireEquipements;
	
	private String nom;
	private boolean revele;
	private Plateau plateau;
	private CartePersonnage cartePersonnage;
	private Equipe equipe;
	
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
	
	public int setStat(String key, int valeur) {
		return stats.put(key, valeur);
	}
	
	public int getStat(String key) {
		return stats.get(key);
	}
	
	
	public int getNbEquipments() {
		return gestionnaireEquipements.getNbEquipments();
	}

	public List<Joueur> getJoueursAdjacents() {
		// TODO Auto-generated method stub
		return null;
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

	public void piocher() {
		// TODO Auto-generated method stub
		
	}

	public void attaquer(Joueur j2) {
		// TODO Auto-generated method stub
		
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

}
