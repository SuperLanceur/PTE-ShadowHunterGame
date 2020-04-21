package personnage;

import effet.Effet;
import effet.EffetSelf;
import effet.action.Action;
import effet.action.ActionAltererStatistiquesJoueur;
import main.Joueur;

public class Charles extends CartePersonnage{
	
	//constructeur

	public Charles(String nom, int hp, Joueur joueur) {
		super(nom, nom, hp, joueur);
		
		Action action = new ActionAltererStatistiquesJoueur("HP",2,true);
		Effet effet = new EffetSelf(action);
		this.setEffet(effet);

	}

	//m�thode
	public void attaquer(Joueur j) {
		super.attaquer(j);
		if(this.getJoueur().getRevele())
		{
			utiliser(this.getJoueur());
			super.attaquer(j);
		}	
	}

	@Override
	public void utiliser() {
		// TODO Auto-generated method stub
		this.getEffet().utiliser(this.getJoueur());
	}
}
