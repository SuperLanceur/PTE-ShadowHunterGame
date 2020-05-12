package ihm.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import main.GestionnaireJeu;

public class Dialog implements Initializable {
	@FXML private Button button;
	@FXML private Label label;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		button.setOnAction(x -> {
			GestionnaireJeu.notifyPlateau();
		});
		
	}

	public void setText(String text) {
		this.label.setText(text);
	}
}
