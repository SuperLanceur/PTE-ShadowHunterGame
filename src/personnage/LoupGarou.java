package personnage;

import condition.Condition;
import condition.ConditionMultipleOR;
import condition.ConditionStatistiques;
import main.Joueur;
import main.Plateau;

public class LoupGarou extends CartePersonnage {
	//constructeur
	public LoupGarou(String nom, int hp, Joueur joueur) {
		super(nom, hp, joueur);
		
		int nbHunter = joueur.getPlateau().getStat(Plateau.NB_HUNTERS);
		Condition winCondition =  new ConditionMultipleOR(
				new ConditionStatistiques(ConditionStatistiques.PLATEAU, Plateau.NB_MORTS_HUNTER, nbHunter, ConditionStatistiques.MORE)
				,
				new ConditionStatistiques(ConditionStatistiques.PLATEAU, Plateau.NB_MORTS_NEUTRAL, 3, ConditionStatistiques.MORE)
						);
		this.setCondition(winCondition);
	}
	
	//m�thodes
	public void contreAttaquer(Joueur j) {
		
	}
}
