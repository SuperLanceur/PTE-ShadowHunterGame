package carte;

import main.Joueur;
import condition.Condition;

public abstract class CarteCondition extends CarteEffet{

	public CarteCondition(String nom, String description) {
		super(nom, description);
		
	}

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
