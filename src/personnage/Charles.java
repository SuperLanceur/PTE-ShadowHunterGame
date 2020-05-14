package personnage;

import condition.Condition;
import condition.ConditionStatistiques;
import effet.Effet;
import effet.EffetSelf;
import effet.action.Action;
import effet.action.ActionAltererStatistiquesJoueur;
import main.Contexte;
import main.Joueur;
import main.Plateau;

public class Charles extends CartePersonnage{
	
	public Charles(Joueur joueur) {
		super("Charles", "desc", 11, joueur);
		this.setEquipe(CartePersonnage.Equipe.NEUTRE);
		Action action = new ActionAltererStatistiquesJoueur("HP",-2,true);
		Effet effet = new EffetSelf(action);
		this.setEffet(effet);
		
		Condition winCondition = new ConditionStatistiques(ConditionStatistiques.PLATEAU, Plateau.WIN_CHARLES, 1, ConditionStatistiques.EQUAL);
		this.setCondition(winCondition);
		
	}

	public Charles() {
		super("Charles", "desc", 11, null);
		this.setEquipe(CartePersonnage.Equipe.NEUTRE);
		Action action = new ActionAltererStatistiquesJoueur("HP",-2,true);
		Effet effet = new EffetSelf(action);
		this.setEffet(effet);
		
		Condition winCondition = new ConditionStatistiques(ConditionStatistiques.PLATEAU, Plateau.WIN_CHARLES, 1, ConditionStatistiques.EQUAL);
		this.setCondition(winCondition);
	}

	@Override
	public void attaquer(Joueur j, int blessure) {
		
		Joueur joueur = this.getJoueur();
		super.attaquer(j, blessure);
		
		if(joueur.getStat(Joueur.PLAYER_HP) > 2 && joueur.getRevele() 
				&& joueur.choisir(Contexte.EFFET_CHARLES)){
			
			Plateau p = j.getPlateau();
			utiliser(joueur);
			p.attaquer(this.getJoueur(), j);
		}
		
		Plateau p = j.getPlateau();
		if(j.isDead() && (p.getStat(Plateau.NB_MORTS) >= 3)) {
			p.setStat(Plateau.WIN_CHARLES, 1);
		}
	}

	@Override
	public void utiliser() {
		
	}
}
