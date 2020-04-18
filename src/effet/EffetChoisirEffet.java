package effet;

import main.Joueur;

public class EffetChoisirEffet extends Effet{

	private Effet[] effets;
	
	public EffetChoisirEffet(Effet ...effets) {
		super(null);
		this.effets = effets;
	}

	@Override
	public void utiliser(Joueur joueur) {

		Effet effet = joueur.choisir(effets);
		
		effet.utiliser(joueur);
	}

}
