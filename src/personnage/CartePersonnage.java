package personnage;

import main.Joueur;

public class CartePersonnage {
	//attributs
		private String nom;
		private int hp;
		private Joueur joueur;
		
	//constructeurs
		public CartePersonnage(String nom, int hp, Joueur joueur){
			this.nom=nom;
			this.hp=hp;
			this.joueur=joueur;
		}
		
	//méthodes
		public void tour() {
			
		};
		
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

}
