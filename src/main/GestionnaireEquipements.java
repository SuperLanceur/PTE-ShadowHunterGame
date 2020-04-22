package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import carte.Equipement;
import carte.EquipementStat;
import condition.Condition;

public class GestionnaireEquipements {
	// String est le nom de l'equip, et Equip c'est l'objet, on suppose ici qu'il ne
	// peut pas y avoir de doublon d'equipement
	private Map<String, Equipement> equipements = new HashMap<>();

	public int getNbEquipments() {
		return equipements.size();
	}

	// precondition : verifier que le gestionnaire contient l'equipement avec
	// containsEquipement
	public Equipement getEquipement(String key) {
		return equipements.get(key);
	}

	public boolean containsEquipement(String key) {
		return equipements.containsKey(key);
	}

	public void addEquipement(String s, Equipement e) {
		equipements.put(s, e);
	}

	// ex : si le joueur se fait voler un equipement, on l'enleve de la liste
	// d'equipements
	public Equipement removeEquipement(String key) {
		return equipements.remove(key);
	}

	// methode qui renvoit une liste des effets des equipements du joueur qui
	// s'activeront dans une certaine phase de la partie par rapport a la condition
	// en parametre
	public List<Effet> getEffets(Condition c) {
		// TODO
		return null;
	}

	// pour methode choisir de joueur
	public Equipement[] getArrayEquipements() {
		return (Equipement[]) equipements.values().toArray();
	}
	
	public int getDamageUpdate() {
		int res = 0;
		Equipement[] e = (Equipement[]) equipements.values().toArray();
		for(int i = 0; i<equipements.values().toArray().length;i++) {
			if(e[i] instanceof EquipementStat) {
				//res+=(EquipementStat)e[i].get
			}
		}
		return res;
	}

}
