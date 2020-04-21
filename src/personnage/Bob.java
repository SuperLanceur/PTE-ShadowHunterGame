package personnage;

import condition.Condition;
import condition.ConditionStatistiques;
import main.Joueur;

public class Bob extends CartePersonnage{
	
	public Bob(String nom, String desc ,int hp, Joueur joueur) throws Exception {
		super(nom,desc, hp, joueur);
		Condition condition = new ConditionStatistiques(ConditionStatistiques.JOUEUR, Joueur.PLAYER_NB_EQUIPEMENTS, 5, ConditionStatistiques.MORE);
		this.setCondition(condition);
	}

	
	public void attaquer(Joueur j) {
		
	}

	@Override
	public void utiliser() {
		// TODO Auto-generated method stub
		
	}
}
