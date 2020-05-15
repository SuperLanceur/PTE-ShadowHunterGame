package ihm.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import sun.util.resources.Bundles;

public class AlterationVieZJ implements Initializable {

	@FXML private Label label;
	
	private ResourceBundle bundle1 = ResourceBundle.getBundle("domaine.properties.langue", ParametreController.LaLangue);
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

	public void changeLabel(int valeur) {
		if(valeur > 0 ) {
			this.label.setText(bundle1.getString("vous.etes.soigne.de")+valeur+"PV");
		}else {
			this.label.setText(bundle1.getString("vous.etes.blesser.de")+valeur+"PV");
		}
	}
}
