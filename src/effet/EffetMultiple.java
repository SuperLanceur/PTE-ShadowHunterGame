package effet;

import java.util.Arrays;
import java.util.List;

import main.Joueur;

public class EffetMultiple extends Effet{

	
	private List<Effet> effets;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1936073174860639420L;

	public EffetMultiple(Effet...effets) {
		super(null);
		this.effets = Arrays.asList(effets);
	}

	@Override
	public void utiliser(Joueur joueur) {
		
		for(Effet e : effets) {
			e.utiliser(joueur);
		}
	}

}
