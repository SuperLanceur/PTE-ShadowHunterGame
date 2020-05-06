package ihm.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import main.Joueur;

public class JouerSonTour4Controller extends LancerDes{
	@FXML private Label defenseur;
	
	private Joueur j;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		super.initialize(arg0, arg1);
		//defenseur.setText(j.getNom());
	}
}
