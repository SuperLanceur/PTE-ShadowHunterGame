package personnage;

import condition.Condition;
import main.Joueur;

public class Vampire extends CartePersonnage{
	//constructeur
	public Vampire(String nom, int hp, Joueur joueur, Condition condition) {
		super(nom, hp, joueur, condition);
	}

	//méthode
	public void attaquer(Joueur j) {
		
	}
}
