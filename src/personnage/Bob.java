package personnage;

import condition.Condition;
import main.Joueur;

public class Bob extends CartePersonnage{
	
	public Bob(String nom, int hp, Joueur joueur, Condition condition,boolean capaciteUsed) {
		super(nom, hp, joueur, condition);
	}

	
	public void attaquer(Joueur j) {
		
	}
}
