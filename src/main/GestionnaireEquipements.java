package main;

import java.util.HashMap;
import java.util.Map;

public class GestionnaireEquipements {
	private Map<String, Integer> stats = new HashMap<>();
	
	public int getNbEquipments() {
		return stats.size();
	}
}
