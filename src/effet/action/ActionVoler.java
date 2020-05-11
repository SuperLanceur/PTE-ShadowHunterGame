package effet.action;

import java.util.List;

import carte.CarteEquipement;
import main.Joueur;

public class ActionVoler extends Action{

	
	public final static boolean DONNER = false;
	public final static boolean VOLER = true;
	
	private boolean choix;
	
	public ActionVoler(Boolean choix) {
		super();
		this.choix = choix;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3770148032992025640L;

	/**
	 * Lance l'action de voler une carte équipement.
	 * @param j1 Le joueur qui vol
	 * @param j2 Le joueur volé
	 * @return void
	 */
	@Override
	public void affecte(Joueur j1, Joueur j2) {
		
		if(this.choix) {

			List<CarteEquipement> equipements = j2.getEquipements();
			
			// J1 choisit quel équipement voler
			CarteEquipement equipement = (CarteEquipement) j1.choisir(equipements, CarteEquipement.class);
			j1.voler(j2,equipement);
		}else {
			
			List<CarteEquipement> equipements = j1.getEquipements();
			// J1 choisit quel équipement voler
			CarteEquipement equipement = (CarteEquipement) j1.choisir(equipements,CarteEquipement.class);
			j2.voler(j1,equipement);
			
		}
	}
}
