package effet;

import main.Equipement;
import main.Joueur;

public class ActionVoler extends Action{

	
	/**
	 * Lance l'action de voler une carte équipement.
	 * @param j1 Le joueur qui vol
	 * @param j2 Le joueur volé
	 * @return void
	 */
	@Override
	public void affecte(Joueur j1, Joueur j2) {
		
		Equipement[] equipements = j2.getEquipements();
		
		// J1 choisit quel équipement voler
		Equipement equipement = j1.choisir(equipements);
		
		j1.voler(j2,equipement);
		
	}
}
