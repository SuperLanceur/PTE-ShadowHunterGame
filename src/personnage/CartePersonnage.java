package personnage;

import carte.CarteCondition;
import condition.Condition;
import main.Joueur;

public class CartePersonnage extends CarteCondition {
	//attributs
		private String nom;
		private int pv;
		private Joueur joueur;
		private Condition condition;
		
	//constructeurs
		public CartePersonnage(String nom, int pv, Joueur joueur,Condition condition){
			this.nom=nom;
			this.setPv(pv);
			this.joueur=joueur;
			this.condition=condition;
		}
		
	//méthodes
		
		public void utiliser() {};
		
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
