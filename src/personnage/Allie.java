package personnage;

import java.util.ArrayList;
import java.util.List;

import condition.Condition;
import condition.ConditionMultiple;
import condition.ConditionStatistiques;
import effet.Effet;
import effet.EffetSelf;
import effet.action.Action;
import effet.action.ActionAltererStatistiquesJoueur;
import main.Joueur;
import main.Plateau;

public class Allie extends Unique{
	
	public Allie(Joueur joueur) {
		super("ALLIE","desc", 8, joueur);
		
		Action action = new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,this.getPv(),false);
		Effet effet = new EffetSelf(action);
		this.setEffet(effet);
	
		List<Condition> conditions = new ArrayList<Condition>();
		
		conditions.add(new ConditionStatistiques(ConditionStatistiques.PLATEAU, Plateau.PARTIE_FINIE, 1, ConditionStatistiques.EQUAL));
		conditions.add(new ConditionStatistiques(ConditionStatistiques.JOUEUR, Joueur.PLAYER_HP, 0, ConditionStatistiques.LESS));
		
		Condition winCondition = new ConditionMultiple(conditions);
		
		this.setCondition(winCondition);
	}

	/**
	 * Lance l'effet d'Allie
	 * <br> Effet : Soin total
	 * @param j 
	 * @return void
	 */
	public void utiliser() {
			
		if(this.getJoueur().getRevele() && !this.isCapaciteUsed()) {
			this.getEffet().utiliser(this.getJoueur());
			this.setCapaciteUsed(true);
		}
	}
}
