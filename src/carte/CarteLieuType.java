package carte;

import java.awt.Point;

import carte.CartePiochable.Type;
import main.Joueur;
import main.Pioche;

public class CarteLieuType extends CarteLieu{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -497959392470353155L;
	private Pioche pioche;
	private CartePiochable.Type type;
	
	
	public CarteLieuType(Type type, Point point) {
		super("","",point);
		this.setType(type);
	}
	
	public CarteLieuType(CartePiochable.Type type,String name, String description ,Point coordinates,Pioche pioche) {
		super(name , description , coordinates);
		this.setType(type);
		this.pioche = pioche;
	}
	
	/*
	 * 	@param j Appel la méthode utiliser de effet sur le joueur j
	 */
	public void utiliser(Joueur j) {
		CartePiochable carte = pioche.piocher();
		carte.utiliser(j);
	}
	
	public void setPioche(Pioche p) {
		this.pioche = p;
	}
	public CartePiochable.Type getType() {
		return type;
	}
	public void setType(CartePiochable.Type type) {
		this.type = type;
	}
	

}
