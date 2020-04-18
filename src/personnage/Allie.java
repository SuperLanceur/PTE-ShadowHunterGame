package personnage;

import condition.Condition;
import effet.Action;
import effet.ActionAltererStatistiquesJoueur;
import effet.Effet;
import effet.EffetSelf;
import main.Joueur;

public class Allie extends Unique{
	
	public Allie(String nom, int hp, Joueur joueur, Condition condition,boolean capaciteUsed) {
		super(nom, hp, joueur, condition, capaciteUsed);
		
		
		Action action = new ActionAltererStatistiquesJoueur("HP",this.getPv(),false);
		Effet effet = new EffetSelf(action);
		this.setEffet(effet);
	}

	
	public void utiliser(Joueur j) {
			
		if(!this.isCapaciteUsed()) {
			this.getEffet().utiliser(j);
		}
	}

}
