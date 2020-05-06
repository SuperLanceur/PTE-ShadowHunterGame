package carte;

import condition.Condition;
import effet.Effet;
import effet.action.ActionAltererStatistiquesJoueur;
import main.Joueur;

public class CarteEquipementStat extends CarteEquipement{
	
	public CarteEquipementStat(Type t, Effet effet) {
		super(t, effet);
	}



	public CarteEquipementStat(Type t, Effet effet, Condition condition) {
		super(t, effet);
		this.setCondition(condition);
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1602387056611454284L;

	
	
	@Override
	public void reverse(Joueur j) {
		ActionAltererStatistiquesJoueur action = ((ActionAltererStatistiquesJoueur) this.getEffet().getAction()).getReverseAction();
		action.affecte(j, j);
	}
}
