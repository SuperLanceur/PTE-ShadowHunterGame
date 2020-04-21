package carte;

import java.util.List;
import main.Joueur;
import main.Pioche;
import main.Type;
import main.TypeLumiere;


public class CarteLieu<T extends Type> extends CarteEffet{
	
	private Pioche<T> piocheLumiere;
	private List<Joueur> listeJoueur;
	
	
	public void utiliser(Joueur j) {
		
		CartePiochable<?> carte = piocheLumiere.piocher();
		carte.utiliser(j);
	}
	
}
