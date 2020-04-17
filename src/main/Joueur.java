package main;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Joueur {
	private Map<String, Integer> stats = new HashMap<>();
	private GestionnaireEquipements gestionnaireEquipements;
	
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
