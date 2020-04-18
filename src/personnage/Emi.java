package personnage;

import condition.WinConditionHunter;
import main.Joueur;

public class Emi extends CartePersonnage{
	//constructeur
	public Emi(String nom, int hp, Joueur joueur) {
		super(nom, hp, joueur);
		
		this.setCondition(new WinConditionHunter());
	}
	
	//m�thode
	public void deplacer() {
			
	}

}
