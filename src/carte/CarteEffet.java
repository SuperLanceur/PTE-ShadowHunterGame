package carte;

import main.Joueur;
import effet.Effet;

public abstract class CarteEffet extends Carte{

	private Effet effet;
	
	public void utiliser(Joueur j) {
		effet.utiliser(j);
	}
	
}
