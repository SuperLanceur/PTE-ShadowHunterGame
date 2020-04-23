package ihm.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class JouerSonTour1Controller implements Initializable{
	@FXML private Pane rootPane;
	@FXML private Label d6;
	@FXML private Label d4;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
	}
	
	@FXML 
	public void lancerDes(MouseEvent mouseEvent) throws IOException{
		Random d6 = new Random();
		int valeurD6 = d6.nextInt(6) + 1;
		Pane pane = FXMLLoader.load(getClass().getResource("../ressources/Jouer_tour(2)carte_lieux.fxml"));
        rootPane.getChildren().setAll(pane);
	}
}
