package ihm.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import main.Type;
import main.TypeLumiere;
import main.TypeTenebre;
import main.TypeVision;

public class PiocherCarte implements Initializable{
	@FXML private Button lumiere;
	@FXML private Button vision;
	@FXML private Button tenebre;
	
	private Type carte;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lumiere.setOnAction(e ->{
			carte = new TypeLumiere();
		});
		
		vision.setOnAction(e -> {
			carte = new TypeVision();
		});
		
		tenebre.setOnAction(e -> {
			carte = new TypeTenebre();
		});
	}

	public Type getCarte() {
		return carte;
	}
}
