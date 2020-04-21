package personnage;

import condition.WinConditionHunter;
import main.Joueur;

public class Franklin extends Unique{

	//constructeur
	public Franklin(String nom, int hp, Joueur joueur) {
		super(nom, nom, hp, joueur);
		this.setCondition(new WinConditionHunter());
	}

	//m�thode
	public void deplacer() {
			
	}

}
