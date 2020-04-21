package personnage;

import condition.WinConditionShadow;
import main.Joueur;

public class LoupGarou extends CartePersonnage {
	//constructeur
	public LoupGarou(String nom, int hp, Joueur joueur) {
		super(nom, hp, joueur);

		this.setCondition(new WinConditionShadow());
	}
	
	//m�thodes
	public void contreAttaquer(Joueur j) {
		
	}
	
	@Override
	public void utiliser() {
		// TODO Auto-generated method stub
		
	}
}
