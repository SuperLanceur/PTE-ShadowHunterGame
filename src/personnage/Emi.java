package personnage;

import condition.WinConditionHunter;
import main.Joueur;

public class Emi extends CartePersonnage{
	//constructeur
	public Emi(String nom, String desc ,int hp, Joueur joueur) {
		super(nom,desc, hp, joueur);
		
		this.setCondition(new WinConditionHunter());
	}
	
	//m�thode
	public void deplacer() {
			
	}
	
	@Override
	public void utiliser() {
		// TODO Auto-generated method stub
		
	}

}
