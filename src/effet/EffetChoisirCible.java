package effet;

import main.Joueur;

public class EffetChoisirCible extends Effet{

	public EffetChoisirCible(Action action) {
		super(action);
	}

	@Override
	public void utiliser(Joueur joueur) {
		
		Joueur j2 = joueur.choisirAdjacents();
		Action action = this.getAction();
		
		action.affecte(joueur, j2);

	}

}