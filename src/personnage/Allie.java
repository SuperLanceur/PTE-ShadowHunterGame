package personnage;

import condition.Condition;
import condition.ConditionMultiple;
import condition.ConditionStatistiques;
import effet.Action;
import effet.ActionAltererStatistiquesJoueur;
import effet.Effet;
import effet.EffetSelf;
import main.Joueur;
import main.Plateau;

public class Allie extends Unique{
	
	public Allie(String nom, int hp, Joueur joueur,boolean capaciteUsed) {
		super(nom, hp, joueur, capaciteUsed);
		
		Action action = new ActionAltererStatistiquesJoueur("HP",this.getPv(),false);
		Effet effet = new EffetSelf(action);
		this.setEffet(effet);
	
		Condition winCondition = new ConditionMultiple(
				
				new ConditionStatistiques(ConditionStatistiques.PLATEAU, Plateau.PARTIE_FINIE, 1, ConditionStatistiques.EQUAL)
				, new ConditionStatistiques(ConditionStatistiques.JOUEUR, Joueur.PLAYER_HP, 0, ConditionStatistiques.MORE)
				);
		
		this.setCondition(winCondition);
	}

	/**
	 * Lance l'effet d'Allie
	 * <br> Effet : Soin total
	 * @param j 
	 * @return void
	 */
	public void utiliser(Joueur j) {
			
		if(!this.isCapaciteUsed()) {
			this.getEffet().utiliser(j);
		}
	}

}
