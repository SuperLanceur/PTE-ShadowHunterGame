package ihm.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class FinDePartieControlleur implements Initializable {
	
	@FXML private Pane rootPane;	
	@FXML private Label labelWinner;

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		labelWinner.setText("ceci est un test d'affichage");
	}
}
