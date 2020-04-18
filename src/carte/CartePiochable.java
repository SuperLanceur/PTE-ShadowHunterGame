package carte;

import main.Joueur;
import main.Type;

public class CartePiochable<T extends Type> extends CarteCondition{

	
	public void utiliser(Joueur j) {
		super.utiliser(j);
	}
	
}
