package personnage;

import carte.CarteCondition;
import condition.Condition;
import main.Joueur;

public abstract class CartePersonnage extends CarteCondition {

		private int pv;
		private Joueur joueur;
		private Equipe equipe;
		
		public enum Equipe{
			NEUTRE,
			SHADOW,
			HUNTER
		}
		
		public CartePersonnage(String nom, String description, int pv, Joueur joueur) {
			super(nom, description);
			this.pv = pv;
			this.joueur = joueur;
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
			this.joueur=j;
		}
		
		public void deplacer() {
			
		}

		public int getPv() {
			return pv;
		}

		public Equipe getEquipe() {
			return this.equipe;
		}
		
		protected void setEquipe(Equipe equipe) {
			this.equipe = equipe;
			
		}

		

}
