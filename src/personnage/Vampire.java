package personnage;

import condition.WinConditionShadow;
import effet.Effet;
import effet.EffetSelf;
import effet.action.Action;
import effet.action.ActionAltererStatistiquesJoueur;
import main.Joueur;


public class Vampire extends CartePersonnage{
	
	public Vampire(Joueur joueur) {
		super("Vampire","desc", 13, joueur);
		
<<<<<<< HEAD
		//new EffetSelf( new ActionAltererStatistiquesJoueur("HP",2,true));
		//);
		//
	}

	//m�thode
	public void attaquer(Joueur j) {
=======
		Action action = new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,2,true);
		Effet effet = new EffetSelf(action);
		this.setEffet(effet);
		this.setCondition(new WinConditionShadow());
	}
	
	/**
	 * Lance l'action d'attaquer de Vampire 
	 * <br><br> Effet : Soin 2 PV
	 * @param j Le joueur qui subit l'attaque
	 * @return void
	 */
	public void attaquer(Joueur j, int blessure) {
>>>>>>> parent of 3e1637c... Ajout méthode utiliser campire
	
		super.attaquer(j, blessure);
		if(this.getJoueur().getRevele())
		{
			this.utiliser(this.getJoueur());
		}	
	}

	public void utiliser() {
	}

	@Override
	public void utiliser() {
		// TODO Auto-generated method stub
		
	}
}
