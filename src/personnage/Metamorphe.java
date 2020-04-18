package personnage;

import condition.Condition;
import condition.ConditionMultipleOR;
import condition.ConditionStatistiques;
import main.Joueur;
import main.Plateau;

public class Metamorphe extends CartePersonnage{

	public Metamorphe(String nom, int pv, Joueur joueur) {
		super(nom, pv, joueur);
		
		
		// WinCondition
		int nbHunter = joueur.getPlateau().getStat(Plateau.NB_HUNTERS);
		Condition condition =  new ConditionMultipleOR(
				new ConditionStatistiques(ConditionStatistiques.PLATEAU, Plateau.NB_MORTS_HUNTER, nbHunter, ConditionStatistiques.MORE)
				,
				new ConditionStatistiques(ConditionStatistiques.PLATEAU, Plateau.NB_MORTS_NEUTRAL, 3, ConditionStatistiques.MORE)
						);
		this.setCondition(condition);
	}

}
