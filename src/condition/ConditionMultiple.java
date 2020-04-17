package condition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import main.Joueur;

public class ConditionMultiple extends Condition {

	private List<Condition> conditions;
	
	public ConditionMultiple(Condition ...conditions) {
		
		this.conditions = new ArrayList<Condition>();
		this.conditions.addAll(Arrays.asList(conditions));
	}
	
	/**
	 * Vérifie si toutes les conditions sont vérifiées
	 * @param joueur Le joueur sur lequel on vérifie les conditions.
	 * @return boolean
	 */
	@Override
	public boolean isTrue(Joueur joueur)
	{
		for(Condition condition : conditions)
		{
			// Si une seule des conditions n'est pas vraie alors on renvoie false
			if(!condition.isTrue(joueur)) return false;
		}
		return true;
	}
	
	public List<Condition> getConditions() {
		return conditions;
	}

	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}
	
	
}
