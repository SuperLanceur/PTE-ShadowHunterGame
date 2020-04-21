package personnage;

import condition.WinConditionShadow;
import effet.Effet;
import effet.EffetSelf;
import effet.action.Action;
import effet.action.ActionAltererStatistiquesJoueur;
import main.Joueur;


public class Vampire extends CartePersonnage{
	
	public Vampire(String nom, String desc ,int hp, Joueur joueur) {
		super(nom,desc, hp, joueur);
		
		Action action = new ActionAltererStatistiquesJoueur("HP",2,true);
		Effet effet = new EffetSelf(action);
		this.setEffet(effet);
		this.setCondition(new WinConditionShadow());
	}

	@Override
	public void utiliser()
	{
		this.getEffet().utiliser(this.getJoueur());
	}
	
	/**
	 * Lance l'action d'attaquer de Vampire 
	 * <br><br> Effet : Soin 2 PV
	 * @param j Le joueur qui subit l'attaque
	 * @return void
	 */
	public void attaquer(Joueur j, int blessure) {
	
		if(this.getJoueur().getRevele())
		{
			utiliser(this.getJoueur());
		}	
	}
	
	
}
