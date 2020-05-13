package effet;

import java.util.Arrays;
import java.util.List;

import main.Joueur;

public class EffetChoisirEffet extends Effet{


	private static final long serialVersionUID = -1412748549517929474L;
	private List<Effet> effets;
	
	public EffetChoisirEffet(Effet ...effets) {
		super(null);
		this.effets = Arrays.asList(effets);
	}

	@Override
	public void utiliser(Joueur joueur) {

		Effet e = choisirEffet(joueur);
		e.utiliser(joueur);
	}
	
	public Effet choisirEffet(Joueur joueur) {
		return (Effet) joueur.choisir(effets,Effet.class);
	}

}
