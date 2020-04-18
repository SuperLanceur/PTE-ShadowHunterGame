package personnage;

import condition.Condition;
import condition.ConditionStatistiques;
import main.Joueur;

public class Bob extends CartePersonnage{
	
	public Bob(String nom, int hp, Joueur joueur) {
		super(nom, hp, joueur);
		Condition condition = new ConditionStatistiques(ConditionStatistiques.JOUEUR, Joueur.PLAYER_NB_EQUIPEMENTS, 5, ConditionStatistiques.MORE);
		this.setCondition(condition);
	}

	@Override
	public void utiliser(Joueur j){
		
	}
	
	public void attaquer(Joueur j) {
		
	}
}
