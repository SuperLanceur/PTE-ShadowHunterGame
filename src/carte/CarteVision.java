package carte;

import java.io.Serializable;

import condition.Condition;
import effet.EffetChoisirCible;
import effet.action.Action;
import main.GestionnaireJeu;
import main.Joueur;

public class CarteVision extends CartePiochable implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 903022795821166067L;

	public CarteVision(Action a, Condition c) {
		super(Type.VISION, "","");
		this.setEffet(new EffetChoisirCible(a));
		this.setCondition(c);
	}	

	/*
	 * @param j le joueur utilisant son effet
	*/
	@Override
	public void utiliser(Joueur j1) {
		
		GestionnaireJeu gj = GestionnaireJeu.getGestionnaireJeu();
		gj.piocher(j1,this);
	
		Joueur j2 = j1.choisiParmisTous();
		
		if(this.getCondition().isTrue(j2)) {
			this.getEffet().getAction().affecte(j1, j2);
		}
		
	}
}
