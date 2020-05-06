package carte;

import effet.Effet;
import main.Joueur;


public abstract class CarteEquipement extends CartePiochable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 7537771209935892801L;

	public CarteEquipement(Type t, Effet effet) {
		super(t, effet);
	}

	public void utiliser(Joueur j) {
		if(!j.getEquipements().contains(this)) {
			j.ajouterEquipement(this);	
		}
		super.utiliser(j);
	}
	
	public abstract void reverse(Joueur j);
}
