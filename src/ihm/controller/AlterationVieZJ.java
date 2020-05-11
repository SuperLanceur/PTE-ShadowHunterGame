package ihm.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class AlterationVieZJ implements Initializable {

	@FXML private Label label;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

	public void changeLabel(int valeur) {
		if(valeur > 0 ) {
			this.label.setText("Vous êtes soigné de "+valeur+"PV");
		}else {
			this.label.setText("Vous êtes blessé de "+valeur+"PV");
		}
	}
}
