package effet;
import main.Joueur;
import java.util.List;

public class EffetCiblerAdjacents extends EffetTarget{

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
