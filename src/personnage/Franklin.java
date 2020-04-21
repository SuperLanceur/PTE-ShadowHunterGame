package personnage;

import condition.WinConditionHunter;
import main.Joueur;
import main.Plateau;

public class Franklin extends Unique{

	//constructeur
	public Franklin(String nom, int hp, Joueur joueur) {
		super(nom, nom, hp, joueur);
		this.setCondition(new WinConditionHunter());
	}

	@Override
	public void attaquer(Joueur j, int blessure) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void utiliser() {
		Joueur joueur = this.getJoueur();
		
		if(this.isCapaciteUsed() && joueur.getRevele()) {
			
			Plateau p = joueur.getPlateau();
			int roll = p.roll6();
			
			Joueur joueur2 = joueur.choisirTous();
			joueur2.addToStat(Joueur.PLAYER_HP, -roll);	
		}
	}

}
