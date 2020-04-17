package effet;

import carte.Joueur;

public class EffetSelf extends Effet{

	@Override
	public void utiliser(Joueur joueur) {

		this.getAction().affecte(joueur, joueur);
	}

}
