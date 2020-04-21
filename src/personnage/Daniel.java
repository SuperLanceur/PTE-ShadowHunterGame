package personnage;

import java.util.ArrayList;
import java.util.List;

import condition.Condition;
import condition.ConditionMultiple;
import condition.ConditionMultipleOR;
import condition.ConditionStatistiques;
import condition.WinConditionHunter;
import main.Joueur;
import main.Plateau;

public class Daniel extends CartePersonnage{

	public Daniel(String nom, int pv, Joueur joueur) throws Exception {
		super(nom, pv, joueur);
		
		int nbShadow = joueur.getPlateau().getStat(Plateau.NB_SHADOWS);
		
		List<Condition> conditions = new ArrayList<Condition>();
		List<Condition> conditions2 = new ArrayList<Condition>();
		
		conditions.add(new WinConditionHunter());
		
		conditions2.add(new ConditionStatistiques(ConditionStatistiques.JOUEUR, Joueur.PLAYER_HP, 0, ConditionStatistiques.LESS));
		conditions2.add(new ConditionStatistiques(ConditionStatistiques.PLATEAU, Plateau.NB_MORTS, 1, ConditionStatistiques.LESS));
		
		conditions.add(new ConditionMultiple(conditions2));
		
		
		Condition winCondition = new ConditionMultipleOR(conditions);
		
		this.setCondition(winCondition);
	}

	@Override
	public void utiliser() {
		// TODO Auto-generated method stub
		
	}
}
