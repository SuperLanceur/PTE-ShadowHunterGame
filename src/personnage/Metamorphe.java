package personnage;

import condition.WinConditionShadow;
import main.Joueur;

public class Metamorphe extends CartePersonnage{

	public Metamorphe(String nom, int pv, Joueur joueur) {
		super(nom, pv, joueur);
		this.setCondition(new WinConditionShadow());
	}

}
