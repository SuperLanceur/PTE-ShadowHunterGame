package personnage;

import condition.WinConditionHunter;
import main.Joueur;
import main.Plateau;

public class Franklin extends Unique{

	public Franklin(Joueur joueur) {
		super("Franklin", "desc", 12, joueur);
		this.setCondition(new WinConditionHunter());
		this.setEquipe(CartePersonnage.Equipe.HUNTER);
	}
	
	public Franklin() {
		super("Franklin", "desc", 12, null);
		this.setCondition(new WinConditionHunter());
		this.setEquipe(CartePersonnage.Equipe.HUNTER);
	}

	@Override
	public void attaquer(Joueur j, int blessure) {
		// TODO Auto-generated method stub
		
	}
	
	public void utiliser() {
		Joueur joueur = this.getJoueur();
		
		if(!this.isCapaciteUsed() && joueur.getRevele()) {
			
			Plateau p = joueur.getPlateau();
			int roll = p.roll6(this.getJoueur());
			
			Joueur joueur2 = joueur.choisiParmisTous();
			super.attaquer(joueur2, roll);
		}
	}

}
