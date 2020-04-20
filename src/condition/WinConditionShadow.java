package condition;

import java.util.ArrayList;
import java.util.List;

import main.Joueur;
import main.Plateau;

public class WinConditionShadow extends Condition{

	@Override
	public boolean isTrue(Joueur j)
	{
		int nbHunter = j.getPlateau().getStat(Plateau.NB_HUNTERS);
		
		List<Condition> conditions = new ArrayList<Condition>();
		
		conditions.add(new ConditionStatistiques(ConditionStatistiques.PLATEAU,Plateau.NB_MORTS_NEUTRAL,3,ConditionStatistiques.MORE));
		conditions.add(new ConditionStatistiques(ConditionStatistiques.PLATEAU, Plateau.NB_MORTS_HUNTER, nbHunter, ConditionStatistiques.MORE));
		
		
		Condition winCondition = 
				new ConditionMultipleOR(conditions);
		return winCondition.isTrue(j);
	}
	
}
