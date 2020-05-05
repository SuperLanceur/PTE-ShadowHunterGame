package carte;

import condition.Condition;
import effet.Effet;
import effet.action.ActionAltererStatistiquesJoueur;
import main.Joueur;
import main.Type;

public class CarteEquipementStat<T extends Type> extends CarteEquipement<Type>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1602387056611454284L;

	public CarteEquipementStat(String nom, String description) {
		super(nom, description);
	}
	
	public CarteEquipementStat(Effet effet, Condition condition) {
		super("","");
		this.setEffet(effet);
		this.setCondition(condition);
	}

	@Override
	public void reverse(Joueur j) {
		ActionAltererStatistiquesJoueur action = ((ActionAltererStatistiquesJoueur) this.getEffet().getAction()).getReverseAction();
		action.affecte(j, j);
	}
}
