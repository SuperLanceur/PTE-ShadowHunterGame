package carte;

import java.awt.Point;
import java.util.List;

import main.Joueur;
import main.Pioche;

public class CarteLieuMultiple extends CarteLieu{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -497959392470353155L;
	private List<Pioche> pioches;

	
	
	public CarteLieuMultiple(Point point) {
		super("","",point);
	}
	/*
	 * 	@param j Appel la méthode utiliser de effet sur le joueur j
	 */
	public void utiliser(Joueur j) {
		Pioche p = (Pioche) j.choisir(pioches, Pioche.class);
		System.out.println(pioches+ " "+p);
		System.out.println(p.getStack());
		Carte c = p.piocher(j);
		c.utiliser(j);
	}
	
	public void setPioches(List<Pioche> pioches) {
		this.pioches = pioches;
	}
}
