package carte;

import main.Joueur;

import java.io.Serializable;

import condition.Condition;

public abstract class CarteCondition extends CarteEffet implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 903022795821166067L;
	private Condition condition;
	
	public CarteCondition() {
		super("","");
		this.condition = new Condition();
	}
	
	
	public CarteCondition(String nom, String description) {
		super(nom, description);
	}

	


	

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
