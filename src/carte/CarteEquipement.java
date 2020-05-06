package carte;

import main.Joueur;
import main.Type;


public abstract class CarteEquipement<T extends Type> extends CartePiochable<Type>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7537771209935892801L;

	public CarteEquipement(String nom, String description) {
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
