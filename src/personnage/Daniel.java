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

	/**
	 * 
	 */
	private static final long serialVersionUID = 6436431310604672660L;

	public static final int HP = 13;

	public Daniel() {
		super("Daniel","desc", HP, null);
		List<Condition> conditions = new ArrayList<Condition>();
		List<Condition> conditions2 = new ArrayList<Condition>();
		
		conditions.add(new WinConditionHunter());
		
		conditions2.add(new ConditionStatistiques(ConditionStatistiques.JOUEUR, Joueur.PLAYER_HP, 0, ConditionStatistiques.LESS));
		conditions2.add(new ConditionStatistiques(ConditionStatistiques.PLATEAU, Plateau.NB_MORTS, 1, ConditionStatistiques.LESS));
		
		conditions.add(new ConditionMultiple(conditions2));
		
		Condition winCondition = new ConditionMultipleOR(conditions);
		this.setEquipe(CartePersonnage.Equipe.NEUTRE);
		this.setCondition(winCondition);
	}
	
	public Daniel(Joueur j) {
		super("Daniel","desc", HP, j);
		List<Condition> conditions = new ArrayList<Condition>();
		List<Condition> conditions2 = new ArrayList<Condition>();
		
		conditions.add(new WinConditionHunter());
		
		conditions2.add(new ConditionStatistiques(ConditionStatistiques.JOUEUR, Joueur.PLAYER_HP, 0, ConditionStatistiques.LESS));
		conditions2.add(new ConditionStatistiques(ConditionStatistiques.PLATEAU, Plateau.NB_MORTS, 1, ConditionStatistiques.LESS));
		
		conditions.add(new ConditionMultiple(conditions2));
		
		Condition winCondition = new ConditionMultipleOR(conditions);
		this.setEquipe(CartePersonnage.Equipe.NEUTRE);
		this.setCondition(winCondition);
	}
	
	public Daniel(String nom, String desc , Joueur joueur) throws Exception {
		super(nom,desc,HP, joueur);
				
		List<Condition> conditions = new ArrayList<Condition>();
		List<Condition> conditions2 = new ArrayList<Condition>();
		
		conditions.add(new WinConditionHunter());
		
		conditions2.add(new ConditionStatistiques(ConditionStatistiques.JOUEUR, Joueur.PLAYER_HP, 0, ConditionStatistiques.LESS));
		conditions2.add(new ConditionStatistiques(ConditionStatistiques.PLATEAU, Plateau.NB_MORTS, 1, ConditionStatistiques.LESS));
		
		conditions.add(new ConditionMultiple(conditions2));
		
		Condition winCondition = new ConditionMultipleOR(conditions);
		
		this.setCondition(winCondition);
	}
	
	

	

	public void utiliser() {
		this.getJoueur().reveal();
	}
	
}
