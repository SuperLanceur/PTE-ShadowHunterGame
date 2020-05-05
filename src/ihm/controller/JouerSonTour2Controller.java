package ihm.controller;

public class JouerSonTour2Controller extends ChoisirBoolean{
	public void initButtons () {
		super.getOuiButton().setText("utiliser.capaciter.lieux");
		super.getNonButton().setText("sauter.etape");
		super.getTitre().setText("description.capacite.carte.lieux");
	}
}