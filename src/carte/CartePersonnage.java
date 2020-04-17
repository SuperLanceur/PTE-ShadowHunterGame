package carte;

public class CartePersonnage extends CarteCondition{

	private String NOM;
	private int HP;
	private Joueur joueur;
	
	public void  tour()	{
		
	}
	
	/*
	 * @param j
	 *			
	 */
	public void utiliser(Joueur j) {
		
	}
	
	/*
	 * @param j
	 *			Le joueur que l'on souhaite attaquer
	 */
	public void attaquer(Joueur j) {
		
	}
	
	public boolean victoire() {
		return true;
	}
	
	
	public Joueur getJoueur() {
		return joueur;
	}
	
	
	/*
	 * @param j
	 *
	 */
	public Joueur setJoueur(Joueur j) {
		this.joueur = j;
		return joueur;
	}
	
	public void deplacer() {
		
	}
	
}
