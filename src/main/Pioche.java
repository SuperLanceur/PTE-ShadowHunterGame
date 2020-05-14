package main;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

import carte.CartePiochable;

public class Pioche {
	
	private Stack<CartePiochable> cartesPiochables;
	
	public Pioche(List<CartePiochable> list1) {
		super();
		this.cartesPiochables = new Stack<CartePiochable>();
		this.cartesPiochables.addAll(list1);
		melanger();
	}

	public void melanger()
	{
		Collections.shuffle(cartesPiochables);
	}
	
	public CartePiochable piocher(Joueur j) {
		CartePiochable cp = cartesPiochables.pop();
		GestionnaireJeu gj = GestionnaireJeu.getGestionnaireJeu();
		gj.piocher(j,cp);
		return cp;
	}

	public Stack<CartePiochable> getStack() {
		return cartesPiochables;
	}
}
