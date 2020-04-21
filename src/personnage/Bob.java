package personnage;

import condition.Condition;
import condition.ConditionStatistiques;
import effet.EffetTarget;
import effet.action.ActionVoler;
import main.Joueur;

public class Bob extends CartePersonnage{
	
	public Bob(Joueur joueur){
		super("BOB","desc", 10, joueur);
		Condition condition = new ConditionStatistiques(ConditionStatistiques.JOUEUR, Joueur.PLAYER_NB_EQUIPEMENTS, 5, ConditionStatistiques.MORE);
		this.setCondition(condition);
		
		
		EffetTarget effet = new EffetTarget(new ActionVoler());
		this.setEffet(effet);
	}

	@Override
	public void attaquer(Joueur j, int blessure) {
		
		if(blessure >= 2 && j.getRevele()) {
			
			Joueur thisJoueur = this.getJoueur();
			
			if(thisJoueur.choisir()) {
				((EffetTarget)this.getEffet()).setTarget(j);
				utiliser();
			}else {
				super.attaquer(j, blessure);
			}
		}
	}

	@Override
	public void utiliser() {
		Joueur j = this.getJoueur();
		this.getEffet().utiliser(j);
	}	
}
