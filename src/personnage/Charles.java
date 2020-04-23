package personnage;

import effet.Effet;
import effet.EffetSelf;
import effet.action.Action;
import effet.action.ActionAltererStatistiquesJoueur;
import main.Joueur;
import main.Plateau;

public class Charles extends CartePersonnage{
	
	public Charles(Joueur joueur) {
		super("Charles", "desc", 11, joueur);
		
		Action action = new ActionAltererStatistiquesJoueur("HP",-2,true);
		Effet effet = new EffetSelf(action);
		this.setEffet(effet);

	}

	@Override
	public void attaquer(Joueur j, int blessure) {
		
		Joueur joueur = this.getJoueur();
		super.attaquer(j, blessure);
		
		if(joueur.getStat(Joueur.PLAYER_HP) > 2 && joueur.getRevele()){
			
			Plateau p = j.getPlateau();
			utiliser(joueur);
			p.attaquer(this.getJoueur(), j);
		}	
	}
	
	public void utiliser() {
	}
}
