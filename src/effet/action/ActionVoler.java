package effet.action;

import java.util.List;

import carte.CarteEquipement;
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
		
		List<CarteEquipement> equipements = j2.getEquipements();
		
		// J1 choisit quel équipement voler
		CarteEquipement equipement = j1.choisir(equipements);
		
		j1.voler(j2,equipement);
		
	}
}
