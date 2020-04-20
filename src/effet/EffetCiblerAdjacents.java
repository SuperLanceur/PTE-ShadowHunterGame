package effet;
import main.Joueur;
import java.util.List;

import effet.action.Action;

public class EffetCiblerAdjacents extends Effet{

	public EffetCiblerAdjacents(Action action) {
		super(action);
	}

	
	@Override
	public void utiliser(Joueur joueur)
	{
		List<Joueur> joueursAdjacents = joueur.getJoueursAdjacents();
		Action action = this.getAction();
		
		for(Joueur j : joueursAdjacents)
		{
			action.affecte(joueur, j);
		}
		
	}


	
}
