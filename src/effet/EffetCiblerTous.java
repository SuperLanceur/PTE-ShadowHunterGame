package effet;

import java.util.List;

import effet.action.Action;
import main.Joueur;
import main.Plateau;

public class EffetCiblerTous extends Effet {

	public EffetCiblerTous(Action action) {
		super(action);
	}

	@Override
	public void utiliser(Joueur joueur) {
		Plateau p = joueur.getPlateau();
		List<Joueur> joueurs = p.getJoueurs();
		Action action = this.getAction();
		
		for(Joueur j : joueurs)
		{
			action.affecte(joueur, j);
		}
	}

}
