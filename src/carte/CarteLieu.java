package carte;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import main.Joueur;


public class CarteLieu extends CarteEffet{
	
	private List<Joueur> listeJoueurs;
	private Point coordinates;
	private CarteLieu voisin;
	
	public CarteLieu(String nom, String description, Point p) {
		super(nom, description);
		this.coordinates = p;
		this.listeJoueurs = new ArrayList<Joueur>();
	}
	
	/*
	 * 	@param j Appel la méthode utiliser de effet sur le joueur j
	 */
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
		
		if(this.listeJoueurs.contains(joueur)){
			this.listeJoueurs.remove(joueur);
		}	
	}

	public void setVoisin(CarteLieu cl) {
		this.voisin = cl;
	}

	public Point getCoordinates() {
		return this.coordinates;
	}

	public void ajouterJoueur(Joueur joueur) {
		this.listeJoueurs.add(joueur);
	}



	
}
