package personnage;

import condition.WinConditionShadow;
import main.Joueur;

public class LoupGarou extends CartePersonnage {
	

	/**
	 * 
	 */
	public static final int HP = 14; 
	
	public LoupGarou() {
		super("LOUP-GAROU","desc", HP, null);
		this.setCondition(new WinConditionShadow());
		this.setEquipe(CartePersonnage.Equipe.SHADOW);
	}
	
	public LoupGarou(Joueur j) {
		super("LOUP-GAROU","desc", HP, j);
		this.setCondition(new WinConditionShadow());
		this.setEquipe(CartePersonnage.Equipe.SHADOW);
	}
	
	public LoupGarou(String nom, String desc ,int hp, Joueur joueur) {
		super(nom,desc, hp, joueur);

		this.setCondition(new WinConditionShadow());
	}

	public void utiliser() {
	}
		
}
