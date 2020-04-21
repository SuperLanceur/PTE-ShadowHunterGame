package personnage;

import condition.WinConditionShadow;
import main.Joueur;

public class Metamorphe extends CartePersonnage{

	public Metamorphe(String nom, String desc ,int hp, Joueur joueur) {
		super(nom,desc, hp, joueur);
		this.setCondition(new WinConditionShadow());
	}
	
	@Override
	public void utiliser() {
		// TODO Auto-generated method stub
		
	}

}
