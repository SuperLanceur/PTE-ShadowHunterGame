package ihm.controller;

public class JouerSonTour3Controller extends ChoisirBoolean{
	public void initButtons () {
		super.getOuiButton().setText("Attaquer !");
		super.getNonButton().setText("Ne pas attaquer");
		super.getTitre().setText("Voulez-vous attaquer un joueur ?");
	}
}
