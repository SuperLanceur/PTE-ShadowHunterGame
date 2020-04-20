package personnage;

import java.util.ArrayList;
import java.util.List;

import condition.Condition;
import condition.ConditionMultiple;
import condition.ConditionStatistiques;
import effet.Action;
import effet.ActionAltererStatistiquesJoueur;
import effet.Effet;
import effet.EffetSelf;
import main.Joueur;
import main.Plateau;

public class Allie extends Unique{
	
	public Allie(String nom, int hp, Joueur joueur) throws Exception {
		super(nom, hp, joueur);
		
		Action action = new ActionAltererStatistiquesJoueur("HP",this.getPv(),false);
		Effet effet = new EffetSelf(action);
		this.setEffet(effet);
	
		List<Condition> conditions = new ArrayList<Condition>();
		
		conditions.add(new ConditionStatistiques(ConditionStatistiques.PLATEAU, Plateau.PARTIE_FINIE, 1, ConditionStatistiques.EQUAL));
		conditions.add(new ConditionStatistiques(ConditionStatistiques.JOUEUR, Joueur.PLAYER_HP, 0, ConditionStatistiques.MORE));
		
		Condition winCondition = new ConditionMultiple(conditions);
		
		this.setCondition(winCondition);
	}

	/**
	 * Lance l'effet d'Allie
	 * <br> Effet : Soin total
	 * @param j 
	 * @return void
	 */
	public void utiliser(Joueur j) {
			
		if(!this.isCapaciteUsed()) {
			this.getEffet().utiliser(j);
		}
	}

}
