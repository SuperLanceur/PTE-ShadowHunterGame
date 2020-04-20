package condition;

import main.Joueur;
import main.Plateau;

public class WinConditionShadow extends Condition{

	@Override
	public boolean isTrue(Joueur j)
	{
		int nbHunter = j.getPlateau().getStat(Plateau.NB_HUNTERS);
		Condition winCondition = 
				new ConditionMultipleOR(
				new ConditionStatistiques(ConditionStatistiques.PLATEAU,Plateau.NB_MORTS_NEUTRAL,3,ConditionStatistiques.LESS),
				new ConditionStatistiques(ConditionStatistiques.PLATEAU, Plateau.NB_MORTS_HUNTER, nbHunter, ConditionStatistiques.LESS));
		return winCondition.isTrue(j);
	}
	
}
