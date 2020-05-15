package ihm.controller;

import java.net.URL;

import java.util.ResourceBundle;

import carte.CartePiochable;
import carte.CartePiochable.Type;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class PiocherCarte implements Initializable{
	@FXML private Button lumiere;
	@FXML private Button vision;
	@FXML private Button tenebre;
	
	private Type carte;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lumiere.setOnAction(e ->{
			carte = CartePiochable.Type.LUMIERE;
		});
		
		vision.setOnAction(e -> {
			carte = CartePiochable.Type.VISION;
		});
		
		tenebre.setOnAction(e -> {
			carte = CartePiochable.Type.TENEBRE;
		});
	}

	public Type getCarte() {
		return carte;
	}
}
