package condition;

import main.Joueur;

public class ConditionReveal extends Condition {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7476657033160343165L;

	
	public boolean isTrue(Joueur joueur) {
		return joueur.getRevele();
	}
}
