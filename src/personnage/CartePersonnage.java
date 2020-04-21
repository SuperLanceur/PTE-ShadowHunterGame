package personnage;

import carte.CarteCondition;
import main.Joueur;

public abstract class CartePersonnage extends CarteCondition {

		private int pv;
		private Joueur joueur;
		
		public CartePersonnage(String nom, String description, int pv, Joueur joueur) {
			super(nom, description);
			this.pv = pv;
			this.joueur = joueur;
			joueur.setCartePersonnage(this);
		}
		
		public abstract void utiliser();
		
		public void attaquer(Joueur j, int blessure) {
			j.addToStat(Joueur.PLAYER_HP, -blessure);
		}
		
		public boolean victoire(){
			return this.getCondition().isTrue(this.joueur);
		}
		
		public Joueur getJoueur() {
			return joueur;
		}
		
		public void setJoueur(Joueur j) {
			joueur=j;
		}
		
		public void deplacer() {
			
		}

		public int getPv() {
			return pv;
		}

}
