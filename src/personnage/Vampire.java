package personnage;

import condition.Condition;
import main.Joueur;

public class Vampire extends CartePersonnage{
	//constructeur
	public Vampire(String nom, int hp, Joueur joueur, Condition condition) {
		super(nom, hp, joueur, condition);
		//this.setEffet(
		
		//new EffetSelf( new ActionAltererStatistiquesJoueur("HP",2,true));
	//);
		//
	}

	public void utiliser(Joueur j)
	{
		//this.getEffet().affecte(this.joueur)
	}
	
	//m�thode
	public void attaquer(Joueur j) {
	
		// attaquer(j)
		//utiliser(this.joueur);
		
	}
}
