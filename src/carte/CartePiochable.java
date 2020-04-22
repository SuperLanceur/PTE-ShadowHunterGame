package carte;

import main.Joueur;
import main.Type;

public class CartePiochable<T extends Type> extends CarteCondition{

	
	public CartePiochable(String nom, String description) {
		super(nom, description);
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * 	@param j Appel la méthode utiliser de effet sur le joueur j
	 */
	public void utiliser(Joueur j) {
		super.utiliser(j);
	}
	
}
