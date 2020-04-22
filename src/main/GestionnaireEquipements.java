package main;

import java.util.ArrayList;
import java.util.List;

import carte.Equipement;

public class GestionnaireEquipements {
	
	private Joueur j;
	private List<Equipement> equipements;

	public GestionnaireEquipements(Joueur j) {
		this.j = j;
		this.equipements = new ArrayList<Equipement>();
	}
	
	public void ajouterEquipement(Equipement e) {
		this.equipements.add(e);
		e.utiliser(this.j);
		this.j.addToStat(Joueur.PLAYER_NB_EQUIPEMENTS, 1);
	}
	
	public void retirerEquipement(Equipement e) {
		if(this.equipements.contains(e)) {
			e.reverse(j);
			this.equipements.remove(e);
			this.j.addToStat(Joueur.PLAYER_NB_EQUIPEMENTS, -1);
		}
	}
	
	public void reverseEffect(Equipement e) {
		e.reverse(j);
	}

	public List<Equipement> getEquipements() {
		return equipements;
	}

}