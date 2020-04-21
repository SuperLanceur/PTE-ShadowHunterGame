package personnage;

import condition.WinConditionHunter;
import main.Joueur;

public class Georges extends Unique{

	//constructeur
	public Georges(String nom, int hp, Joueur joueur) {
		super(nom, nom, hp, joueur);
		this.setCondition(new WinConditionHunter());
	}

	//m�thode
	public void deplacer() {
			
	}

}
