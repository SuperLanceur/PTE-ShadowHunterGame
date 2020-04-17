package condition;

import main.Joueur;

public class ConditionMultipleOR extends ConditionMultiple{

	
	/**
	 * Vérifie si au moins une des conditions est vérifiée
	 * @param joueur Le joueur sur lequel on vérifie les conditions.
	 * @return boolean
	 */
	@Override
	public boolean isTrue(Joueur joueur)
	{
		for(Condition condition : this.getConditions())
		{
			// Si une seule des conditions est vraie alors on renvoie true
			if(condition.isTrue(joueur)) return true;
		}
		return false;
	}
	
	
}
