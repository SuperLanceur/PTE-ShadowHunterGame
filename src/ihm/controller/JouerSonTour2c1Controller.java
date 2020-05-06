package ihm.controller;

public class JouerSonTour2c1Controller extends ChoisirBoolean{
	public void initButtons () {
		super.getOuiButton().setText("Attaquer !");
		super.getNonButton().setText("se.soigner");
		super.getTitre().setText("attaquer.ou.soigner");
	}
}
