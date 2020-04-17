package personnage;

import condition.Condition;
import main.Joueur;

public class Unique extends CartePersonnage{
	//attributs
	private boolean capaciteUsed;
	
	//constructeur
	public Unique(String nom, int hp, Joueur joueur,Condition condition,boolean capaciteUsed) {
		super(nom, hp, joueur, condition);
		this.capaciteUsed=capaciteUsed;
	}

}
