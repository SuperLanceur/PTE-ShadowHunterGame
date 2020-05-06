package personnage;

import condition.WinConditionHunter;
import main.Joueur;
import main.Plateau;

public class Georges extends Unique{

	
	public Georges(Joueur joueur) {
		super("Franklin", "desc", 14, joueur);
		this.setCondition(new WinConditionHunter());
		this.setEquipe(CartePersonnage.Equipe.HUNTER);
	}
	
	public Georges(String nom, int hp, Joueur joueur) {
		super(nom, nom, hp, joueur);
		this.setCondition(new WinConditionHunter());
		this.setEquipe(CartePersonnage.Equipe.HUNTER);
	}

	public void utiliser() {
		Joueur joueur = this.getJoueur();
		
		if(!this.isCapaciteUsed() && joueur.getRevele()) {
			
			Plateau p = joueur.getPlateau();
			int roll = p.roll4(this.getJoueur());
			
			Joueur joueur2 = joueur.choisiParmisTous();
			super.attaquer(joueur2, roll);
		}
	}

}
