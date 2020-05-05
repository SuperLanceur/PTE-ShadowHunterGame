package effet.action;

import main.Joueur;
import main.Plateau;

public class ActionAltererStatistiquesJoueurRoll extends ActionAltererStatistiquesJoueur {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6614964982752647505L;
	private int valeurRoll;
	
	public ActionAltererStatistiquesJoueurRoll(String key, int valeurRoll, boolean ajouter) {
		super(key, 0, ajouter);
		this.valeurRoll = valeurRoll;
	}

	@Override
	public void affecte(Joueur j1, Joueur j2) {
		
		Plateau p = j1.getPlateau();
		int roll;
		
		if(this.valeurRoll == 6) {
			
			roll = p.roll6(j1);
		}else {
			roll = p.roll4(j1);
		}
		
		this.setValeur(roll);
		
		super.affecte(j1, j2);
	}
}
