package carte;

import main.Joueur;
import main.Type;


public abstract class Equipement extends CartePiochable<Type>{
	
	
	public Equipement(String nom, String description) {
		super(nom, description);
		// TODO Auto-generated constructor stub
	}

	public void utiliser(Joueur j) {
		if(!j.getEquipements().contains(this)) {
			j.ajouterEquipement(this);	
		}
		super.utiliser(j);
	}
	
	public abstract void reverse(Joueur j);
}