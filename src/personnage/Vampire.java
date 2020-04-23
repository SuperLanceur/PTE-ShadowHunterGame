package personnage;

import condition.WinConditionShadow;
import effet.Effet;
import effet.EffetSelf;
import effet.action.Action;
import effet.action.ActionAltererStatistiquesJoueur;
import main.Joueur;


public class Vampire extends CartePersonnage{
	
	
	public Vampire() {
		super("Vampire","desc", 13,null);

		Action action = new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,2,true);
		Effet effet = new EffetSelf(action);
		this.setEffet(effet);
		this.setCondition(new WinConditionShadow());
		this.setEquipe(CartePersonnage.Equipe.SHADOW);
		
	}
	
	public Vampire(Joueur joueur) {
		super("Vampire","desc", 13, joueur);
		

		Action action = new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,2,true);
		Effet effet = new EffetSelf(action);
		this.setEffet(effet);
		this.setCondition(new WinConditionShadow());
		this.setEquipe(CartePersonnage.Equipe.SHADOW);
		this.setJoueur(joueur);
		joueur.setCartePersonnage(this);
	}
	
	
	
	
	/**
	 * Lance l'action d'attaquer de Vampire 
	 * <br><br> Effet : Soin 2 PV
	 * @param j Le joueur qui subit l'attaque
	 * @return void
	 */
	public void attaquer(Joueur j, int blessure) {
	
		super.attaquer(j, blessure);
		if(this.getJoueur().getRevele())
		{
			this.utiliser(this.getJoueur());
		}	
	}

	@Override
	public void utiliser() {
		// TODO Auto-generated method stub
		
	}

}
