package personnage;

import carte.CarteCondition;
import condition.Condition;
import main.Joueur;

public abstract class CartePersonnage extends CarteCondition {
	//attributs
		private String nom;
		private int pv;
		private Joueur joueur;
		private Condition condition;
		
	//constructeurs
		public CartePersonnage(String nom, int pv, Joueur joueur){
			this.nom=nom;
			this.pv = pv;
			this.joueur=joueur;
		}
		
	//méthodes
		
		public abstract void utiliser();
		
		public void attaquer(Joueur j) {};
		
		public boolean victoire(){
				return false;
				}
		
		public Joueur getJoueur() {
			return joueur;
		};
		
		public void setJoueur(Joueur j) {
			joueur=j;
		};
		
		public void deplacer() {
			
		}

		public int getPv() {
			return pv;
		}

}
