package carte;

import java.io.Serializable;

import condition.Condition;
import effet.Effet;
import main.Joueur;

public class CartePiochable extends CarteCondition implements Serializable{


	private static final long serialVersionUID = 2391013233873750967L;
	private Type type;

	public enum Type{
		LUMIERE,
		TENEBRE,
		VISION
	}
	
	public CartePiochable(Type t, String nom, String description) {
		super(nom, description);
	}
	
	public CartePiochable(Type t, Effet e, Condition c) {
		super();
		this.setEffet(e);
		this.setCondition(c);
	}
	
	public CartePiochable(Type t, Effet effet) {
		super();
		this.type = t;
		this.setEffet(effet);
		this.setCondition(new Condition());
	}

	/*
	 * 	@param j Appel la méthode utiliser de effet sur le joueur j
	 */
	public void utiliser(Joueur j) {
		super.utiliser(j);
	}
	
	public Type getType() {
		return type;
	}
	
}
