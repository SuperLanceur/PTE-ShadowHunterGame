package carte;

import main.Joueur;
import condition.Condition;

public abstract class CarteCondition extends CarteEffet{

	private Condition condition;
	
	public void utiliser(Joueur j) {
		super.utiliser(j);
	}
	
	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}
	
	
}
