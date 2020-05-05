package carte;

import java.io.Serializable;

import condition.Condition;
import effet.Effet;
import effet.EffetChoisirCible;
import effet.EffetSelf;
import main.Joueur;
import main.Type;

public class CartePiochable<T extends Type> extends CarteCondition implements Serializable{


	private static final long serialVersionUID = 2391013233873750967L;
	
	public CartePiochable(String nom, String description) {
		super(nom, description);
	}
	
	public CartePiochable(Effet e, Condition c) {
		super();
		this.setEffet(e);
		this.setCondition(c);
	}
	
	public CartePiochable(Effet effet) {
		super();
		this.setEffet(effet);
		this.setCondition(new Condition());
	}

	/*
	 * 	@param j Appel la méthode utiliser de effet sur le joueur j
	 */
	public void utiliser(Joueur j) {
		super.utiliser(j);
	}
	
}
