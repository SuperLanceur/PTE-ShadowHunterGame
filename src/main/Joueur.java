package main;
import java.util.HashMap;
import java.util.Map;

import carte.CartePersonnage;
import carte.Type;

public class Joueur {
	
	private Map<String, Integer> stats = new HashMap<>();
	private GestionnaireEquipements gestionnaireEquipements;
	
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

	public Type getType() {
		// TODO Auto-generated method stub
		return null;
	}

	public CartePersonnage getCartePersonnage() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
