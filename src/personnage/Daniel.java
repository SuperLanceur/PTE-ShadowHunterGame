package personnage;

import condition.Condition;
import condition.ConditionMultiple;
import condition.ConditionMultipleOR;
import condition.ConditionStatistiques;
import condition.WinConditionHunter;
import main.Joueur;
import main.Plateau;

public class Daniel extends CartePersonnage{

	public Daniel(String nom, int pv, Joueur joueur) {
		super(nom, pv, joueur);
		
		int nbShadow = joueur.getPlateau().getStat(Plateau.NB_SHADOWS);
		
		Condition winCondition = new ConditionMultipleOR(
			
				// Mort en premier
				new ConditionMultiple(
						new ConditionStatistiques(ConditionStatistiques.JOUEUR, Joueur.PLAYER_HP, 0, ConditionStatistiques.LESS)
					   ,new ConditionStatistiques(ConditionStatistiques.PLATEAU, Plateau.NB_MORTS, 1, ConditionStatistiques.LESS)
						)
				// Shadows morts 
				,new WinConditionHunter()
		);
		this.setCondition(winCondition);
	}

}
