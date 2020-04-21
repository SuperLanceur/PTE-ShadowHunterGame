package personnage;

import condition.WinConditionShadow;
import main.Joueur;

public class LoupGarou extends CartePersonnage {
	
	public LoupGarou(String nom, String desc ,int hp, Joueur joueur) {
		super(nom,desc, hp, joueur);

		this.setCondition(new WinConditionShadow());
	}
		
	@Override
	public void utiliser() {
		// TODO Auto-generated method stub
		
	}
}
