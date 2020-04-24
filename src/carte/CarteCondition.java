package carte;

import main.Joueur;
import condition.Condition;

public abstract class CarteCondition extends CarteEffet{

	public CarteCondition(String nom, String description) {
		super(nom, description);
		
	}

	private Condition condition;
	

	/*
	 * @param j le joueur utilisant son effet
	*/
	@Override
	public void utiliser(Joueur j) {
		if(this.condition != null) {
			
			if(this.condition.isTrue(j)) {
				super.utiliser(j);
			}
		}else {
			super.utiliser(j);
		}
	}
	
	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}
}
