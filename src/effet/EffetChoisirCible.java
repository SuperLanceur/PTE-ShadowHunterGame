package effet;

import effet.action.Action;
import main.Joueur;

public class EffetChoisirCible extends Effet{

	public EffetChoisirCible(Action action) {
		super(action);
	}

	@Override
	public void utiliser(Joueur joueur) {
		
		Joueur j2 = choisirCible(joueur);
		Action action = this.getAction();
		action.affecte(joueur, j2);
	}
	
	public Joueur choisirCible(Joueur joueur) {
		return joueur.choisiParmisTous();
	}

}
