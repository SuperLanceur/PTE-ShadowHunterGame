package personnage;

import condition.Condition;
import condition.ConditionStatistiques;
import effet.EffetTarget;
import effet.action.ActionVoler;
import main.Joueur;

public class Bob extends CartePersonnage{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5593891138436384632L;

	public Bob() {
		super("BOB","desc", 10, null);
		Condition condition = new ConditionStatistiques(ConditionStatistiques.JOUEUR, Joueur.PLAYER_NB_EQUIPEMENTS, 5, ConditionStatistiques.MORE);
		this.setCondition(condition);
		
		this.setEquipe(CartePersonnage.Equipe.NEUTRE);
		EffetTarget effet = new EffetTarget(new ActionVoler(ActionVoler.VOLER));
		this.setEffet(effet);
	}
	
	public Bob(Joueur joueur){
		super("BOB","desc", 10, joueur);
		Condition condition = new ConditionStatistiques(ConditionStatistiques.JOUEUR, Joueur.PLAYER_NB_EQUIPEMENTS, 5, ConditionStatistiques.MORE);
		this.setCondition(condition);
		
		this.setEquipe(CartePersonnage.Equipe.NEUTRE);
		EffetTarget effet = new EffetTarget(new ActionVoler(ActionVoler.VOLER));
		this.setEffet(effet);
	}

	@Override
	public void attaquer(Joueur j, int blessure) {
		
		if(blessure >= 2 && j.getRevele()) {
			
			Joueur thisJoueur = this.getJoueur();
			
			if(thisJoueur.choisir()) {
				((EffetTarget)this.getEffet()).setTarget(j);
				this.utiliser(thisJoueur);
			}else {
				super.attaquer(j, blessure);
			}
		}
	}

	@Override
	public void utiliser() {
		// TODO Auto-generated method stub
		
	}
}
