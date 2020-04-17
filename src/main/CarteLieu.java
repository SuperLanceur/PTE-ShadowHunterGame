package main;
import java.util.List;

public class CarteLieu {
	private List<Integer> valeurs;
	private List<Joueur> joueurs;
	private String nom;
	private CarteLieu voisin;
	private Plateau plateau;
	// TODO connaitre carte voisine sur un autre territoire pour emi?

	
	public CarteLieu(String n, List<Integer> vals, CarteLieu vois, Plateau plat){
		nom = n;
		for(int i : vals) {
			//max 2 v par lieu normalement
			valeurs.add(i);
		}
		voisin = vois;
		plateau = plat;
	}
	
	//pour rajouter un joueur au lieu
	public void addJoueur(Joueur j) {
		joueurs.add(j);
	}

	public List<Joueur> getJoueursAdjacents() {
		return voisin.getJoueurs();
	}
	
	public void utiliser(Joueur j) {};

	public List<Joueur> getJoueurs() {
		return joueurs;
	}
	
	//pour enlever un joueur du lieu
	public void removeJoueur(Joueur j) {
		joueurs.remove(j); //pas sur que ca va marcher
	}
	
}
