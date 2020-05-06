package personnage;

import condition.WinConditionHunter;
import main.Joueur;

public class Emi extends CartePersonnage{
	
	public static final int HP = 13;
	
	public Emi() {
		super("EMI","desc", HP, null);
		
		this.setCondition(new WinConditionHunter());
	}
	
	public Emi(Joueur j) {
		super("EMI","desc", HP, j);
		
		this.setCondition(new WinConditionHunter());
	}
	
	//constructeur
	public Emi(String nom, String desc ,int hp, Joueur joueur) {
		super(nom,desc, hp, joueur);
		
		this.setCondition(new WinConditionHunter());
	}
	
	
	


	

	public void deplacer() {
			
	}


	public void utiliser() {
	}
}
