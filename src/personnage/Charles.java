package personnage;

import condition.Condition;
import main.Joueur;

public class Charles extends CartePersonnage{
	//attributs
	private boolean capaciteUsed;
	
	//constructeur
	public Charles(String nom, int hp, Joueur joueur,Condition condition,boolean capaciteUsed) {
		super(nom, hp, joueur, condition);
		this.capaciteUsed=capaciteUsed;
	}

	//m�thode
	public void attaquer(Joueur j) {
		
	}
}
