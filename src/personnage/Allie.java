package personnage;

import condition.Condition;
import main.Joueur;

public class Allie extends Unique{
	//constructeur
	public Allie(String nom, int hp, Joueur joueur, Condition condition,boolean capaciteUsed) {
		super(nom, hp, joueur, condition, capaciteUsed);
	}

	//méthode
	public void deplacer() {
			
	}

}
