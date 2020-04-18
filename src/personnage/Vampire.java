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
		this.getEffet().utiliser(j);
	}
	
	/**
	 * Lance l'action d'attaquer de Vampire 
	 * <br><br> Efffet :
	 * @param j Le joueur qui subit l'attaque
	 * @return void
	 */
	public void attaquer(Joueur j) {
	
		super.attaquer(j);
		if(this.getJoueur().getRevele())
		{
			utiliser(this.getJoueur());
		}	
	}
}
