package condition;

import java.util.ArrayList;
import java.util.List;

import main.Joueur;


public class ConditionType extends Condition{

	private List<Joueur.Equipe> equipes;
	
	public ConditionType(List<Joueur.Equipe> equipes){
		
		this.equipes = new ArrayList<Joueur.Equipe>();
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
		Joueur.Equipe equipeJoueur = joueur.getEquipe();
		
		for(Joueur.Equipe equipe : equipes) {
		
			if(equipeJoueur == equipe) return true;
		}
		return false;
	}
	
}
