package carte;

import java.awt.Point;

import main.Joueur;
import main.Pioche;

public class CarteLieuType extends CarteLieu{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -497959392470353155L;
	private Pioche pioche;
	private CartePiochable.Type type;
	
	
	public CarteLieuType(CartePiochable.Type type,String name, String description ,Point coordinates,Pioche pioche) {
		super(name , description , coordinates);
		this.type = type;
		this.pioche = pioche;
	}
	/*
	 * 	@param j Appel la méthode utiliser de effet sur le joueur j
	 */
	public void utiliser(Joueur j) {
		
		CartePiochable carte = pioche.piocher();
		carte.utiliser(j);
	}
	

}
