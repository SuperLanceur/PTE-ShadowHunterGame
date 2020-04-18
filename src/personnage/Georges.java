package personnage;

import condition.Condition;
import condition.ConditionStatistiques;
import main.Joueur;
import main.Plateau;

public class Georges extends Unique{

	//constructeur
	public Georges(String nom, int hp, Joueur joueur) {
		super(nom, hp, joueur);
		
		int nbShadow = joueur.getPlateau().getStat(Plateau.NB_SHADOWS);
		Condition winCondition = new ConditionStatistiques(ConditionStatistiques.PLATEAU, Plateau.NB_MORTS_SHADOW, nbShadow, ConditionStatistiques.MORE);
		this.setCondition(winCondition);
		
	}

	//m�thode
	public void deplacer() {
			
	}

}
