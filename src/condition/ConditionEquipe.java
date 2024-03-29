package condition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import main.Joueur;
import personnage.CartePersonnage;
import personnage.CartePersonnage.Equipe;


public class ConditionEquipe extends Condition{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8261153600401164649L;
	private List<CartePersonnage.Equipe> equipes;
	
	public ConditionEquipe(Equipe e) {
		this.equipes = new ArrayList<CartePersonnage.Equipe>();
		this.equipes.add(e);
	}
	
	public ConditionEquipe(Equipe...equipes) {
		this.equipes = Arrays.asList(equipes);
	}
	
	public ConditionEquipe(List<CartePersonnage.Equipe> equipes){
		
		this.equipes = new ArrayList<CartePersonnage.Equipe>();
		this.equipes.addAll(equipes);
	}




	




	/**
	 * Vérifie qu'il existe au moins une classe qui correspond à l'équipe du Joueur.
	 * <br><br>
	 * exemple : 
	 * 
	 * classes = { NEUTRE,SHADOW,HUNTER }
	 * <br>
	 * Si l'équipe du joueur correspond à un des élements dans la liste des équipes alors on renvoie vrai.
	 * 
	 * @param joueur Le joueur sur lequel on vérifie les conditions.
	 * @return boolean
	 */
	@Override
	public boolean isTrue(Joueur joueur)
	{
		CartePersonnage.Equipe equipeJoueur = joueur.getEquipe();
		
		for(CartePersonnage.Equipe equipe : equipes) {
		
			if(equipeJoueur == equipe) return true;
		}
		return false;
	}
	
}
