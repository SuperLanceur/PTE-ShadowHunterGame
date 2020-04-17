package main;
import java.util.HashMap;
import java.util.Map;

public class Joueur {
	private Map<String, Integer> stats = new HashMap<>();
	private GestionnaireEquipements gestionnaireEquipements;
	private boolean devoile;
	
	//constructeurs
	public Joueur(boolean devoile) {
		this.devoile=devoile;
	}
	
	//shadows, hunters ou neutre
	public String getEquipe() {
		return null;
	}
	
	public int getHP() {
		return stats.get("HP");
	}
	
	public int getDamage() {
		return stats.get("DAMAGE");
	}
	
	public int getNbEquipments() {
		return gestionnaireEquipements.getNbEquipments();
	}

	public boolean isDevoile() {
		return devoile;
	}

	public void setDevoile(boolean devoile) {
		this.devoile = devoile;
	}

	public Map<String, Integer> getStats() {
		return stats;
	}

	public GestionnaireEquipements getGestionnaireEquipements() {
		return gestionnaireEquipements;
	}
	
}
