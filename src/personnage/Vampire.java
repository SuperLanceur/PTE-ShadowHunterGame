package personnage;

import condition.Condition;
import effet.Action;
import effet.ActionAltererStatistiquesJoueur;
import effet.Effet;
import effet.EffetSelf;
import main.Joueur;

public class Vampire extends CartePersonnage{
	
	public Vampire(String nom, int hp, Joueur joueur, Condition condition) {
		super(nom, hp, joueur, condition);
		
		Action action = new ActionAltererStatistiquesJoueur("HP",2,true);
		Effet effet = new EffetSelf(action);
		this.setEffet(effet);
		
	}

	public void utiliser(Joueur j)
	{
		this.getEffet().utiliser(j);
	}
	
	/**
	 * Lance l'action d'attaquer de Vampire 
	 * <br><br> Effet :
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
