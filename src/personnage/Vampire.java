package personnage;

import condition.Condition;
import condition.ConditionMultipleOR;
import condition.ConditionStatistiques;
import effet.Action;
import effet.ActionAltererStatistiquesJoueur;
import effet.Effet;
import effet.EffetSelf;
import main.Joueur;
import main.Plateau;

public class Vampire extends CartePersonnage{
	
	public Vampire(String nom, int hp, Joueur joueur) {
		super(nom, hp, joueur);
		
		Action action = new ActionAltererStatistiquesJoueur("HP",2,true);
		Effet effet = new EffetSelf(action);
		this.setEffet(effet);
		
		int nbHunter = joueur.getPlateau().getStat(Plateau.NB_HUNTERS);
		Condition condition =  new ConditionMultipleOR(
				new ConditionStatistiques(ConditionStatistiques.PLATEAU, Plateau.NB_MORTS_HUNTER, nbHunter, ConditionStatistiques.MORE)
				,
				new ConditionStatistiques(ConditionStatistiques.PLATEAU, Plateau.NB_MORTS_NEUTRAL, 3, ConditionStatistiques.MORE)
						);
		this.setCondition(condition);
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
