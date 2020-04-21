package personnage;

import effet.Effet;
import effet.EffetSelf;
import effet.action.Action;
import effet.action.ActionAltererStatistiquesJoueur;
import main.Joueur;
import main.Plateau;

public class Charles extends CartePersonnage{
	
	public Charles(String nom, int hp, Joueur joueur) {
		super(nom, nom, hp, joueur);
		
		Action action = new ActionAltererStatistiquesJoueur("HP",-2,true);
		Effet effet = new EffetSelf(action);
		this.setEffet(effet);

	}

	public void attaquer(Joueur j, int blessure) {
		
		if(this.getJoueur().getRevele()){
		
			// TODO Choisir effet
			Plateau p = j.getPlateau();
			utiliser();
			p.attaquer(this.getJoueur(), j);	
		}	
	}

	@Override
	public void utiliser() {
		this.getEffet().utiliser(this.getJoueur());
	}
}
