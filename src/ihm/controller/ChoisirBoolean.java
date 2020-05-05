package ihm.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import main.GestionnaireJeu;

public class ChoisirBoolean implements Initializable {

	@FXML private Button ouiButton;
	@FXML private Button nonButton;

	private boolean result;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		ouiButton.setOnAction(x -> {
			
			this.result = true;
			GestionnaireJeu.notifyPlateau();
		});
		
		nonButton.setOnAction(x -> {
			this.result = false;
			GestionnaireJeu.notifyPlateau();
		});		
	}

	public boolean getResult() {
		return this.result;
	}
}
