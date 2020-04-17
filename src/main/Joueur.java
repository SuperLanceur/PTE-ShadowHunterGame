package main;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Joueur {
	private GestionnaireEquipements gestionnaireEquipements;
	
	private String name;
	private boolean revealed;
	private boolean virtual;
	private Plateau plateau;
	
	// map keys
	public static final String PLAYER_HP = "hp";
	public static final String PLAYER_TURN = "turn";
	public static final String PLYAYER_DAMAGE = "damage";
	public static final String PLAYER_RESISTANCE = "resistance";
	public static final String PLAYER_REVEAL = "reveal";
	public static final String PLAYER_IMMUNITY = "immunity";
	
	private Map<String, Integer> stats;
	
	public Joueur(String name) {
		this.name = name;
		this.revealed = false;
		this.virtual = false;
		
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
	
	public void setVirtual() {
		this.virtual = true;
	}
	
	//shadows, hunters ou neutre
	public String getEquipe() {
		return null;
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
	
	

}
