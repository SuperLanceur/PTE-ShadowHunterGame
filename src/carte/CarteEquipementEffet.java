package carte;

import main.Joueur;
import main.Type;

public class CarteEquipementEffet<T extends Type> extends CarteEquipement<Type> {

	public CarteEquipementEffet(String nom, String description) {
		super(nom, description);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -7036514419711836673L;

	@Override
	public void reverse(Joueur j) {
		// TODO Auto-generated method stub
		
	}

}
