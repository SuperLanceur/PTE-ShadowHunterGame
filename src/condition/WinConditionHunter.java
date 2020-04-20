package condition;

import main.Joueur;
import main.Plateau;

public class WinConditionHunter extends Condition{

	@Override
	public boolean isTrue(Joueur j)
	{
		int nbShadow = j.getPlateau().getStat(Plateau.NB_SHADOWS);
		
		Condition winCondition = new ConditionStatistiques(
				ConditionStatistiques.PLATEAU, Plateau.NB_MORTS_SHADOW, nbShadow, ConditionStatistiques.LESS);
		return winCondition.isTrue(j);
	}
	
}
