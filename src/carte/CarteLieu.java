package carte;

import java.util.List;
import main.Joueur;
import main.Type;


public class CarteLieu extends CarteEffet{
	
	private Type field;
	
	// Liste des joueurs actuellement présentsur le lieu
	private List<Joueur> listeJoueur;
	
	
	public void utiliser(Joueur j) {
		super.utiliser(j);
	}
	
}
