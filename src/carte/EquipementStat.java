package carte;

import effet.action.ActionAltererStatistiquesJoueur;
import main.Joueur;

public class EquipementStat extends Equipement{
	
	public EquipementStat(String nom, String description) {
		super(nom, description);
	}
	
	@Override
	public void reverse(Joueur j) {
		ActionAltererStatistiquesJoueur action = ((ActionAltererStatistiquesJoueur) this.getEffet().getAction()).getReverseAction();
		action.affecte(j, j);
	}
}
