package effet;

import java.util.List;

import carte.Joueur;

public class EffetCiblerAdjacents extends EffetTarget{

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
