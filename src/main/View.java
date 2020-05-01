package main;

import java.util.List;

import ihm.controller.PlateauController;

public class View{
	
	private PlateauController plateauController;
	
	public View() {
		
	}
	
	public void setPlateauController(PlateauController plateauController) {
		this.plateauController = plateauController;
	}
	
	public void afficherChoisir(Joueur j) throws Exception {
		if(this.plateauController != null) {
			//this.plateauController.afficherChoisir(j);
		}
	}

	public static void applyConfiguration(Configuration c) {
		
		GestionnaireJeu gj = GestionnaireJeu.getGestionnaireJeu();
		gj.setConfiguration(c);
	}
	
	public static List<Joueur> getJoueurs() {
		return null;
	}
}
