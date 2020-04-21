package carte;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import main.Joueur;


public class CarteLieu extends CarteEffet{
	
	private List<Joueur> listeJoueurs;
	private Point coordinates;
	private CarteLieu voisin;
	
	public CarteLieu(Point coordinates) {
		this.listeJoueurs = new ArrayList<Joueur>();
		this.coordinates = coordinates;
	}

	public void utiliser(Joueur j) {

		this.getEffet().utiliser(j);
	}
	
	public boolean coordinatesContains(int i)
	{
		return coordinates.x == i || coordinates.y == i;
	}

	public List<Joueur> getJoueurs() {
		return listeJoueurs;
	}

	public List<Joueur> getJoueursAdjacents() {
		return voisin.getJoueurs();
	}

	public void remove(Joueur joueur) {
		
		if(this.listeJoueurs.contains(joueur))
		{
			this.listeJoueurs.remove(joueur);
		}	
	}


	
}
