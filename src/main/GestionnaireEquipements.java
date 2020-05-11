package main;

import java.util.ArrayList;
import java.util.List;

import carte.CarteEquipement;

public class GestionnaireEquipements {
	
	private Joueur j;
	private List<CarteEquipement> equipements;

	public GestionnaireEquipements(Joueur j) {
		this.j = j;
		this.equipements = new ArrayList<CarteEquipement>();
	}
	
	public void ajouter(CarteEquipement e) {
		this.equipements.add(e);
		e.utiliser(this.j);
		this.j.addToStat(Joueur.PLAYER_NB_EQUIPEMENTS, 1);
		this.j.ajouterEquipementIHM(e);
	}
	
	public void retirer(CarteEquipement e) {
		if(this.equipements.contains(e)) {
			e.reverse(j);
			this.equipements.remove(e);
			this.j.addToStat(Joueur.PLAYER_NB_EQUIPEMENTS, -1);
			this.j.removeEquipementIHM(e);
		}
		
		
		
	}
	
	public List<CarteEquipement> getEquipements() {
		return equipements;
	}

}