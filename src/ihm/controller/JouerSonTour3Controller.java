package ihm.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class JouerSonTour3Controller implements Initializable{
	@FXML private Pane rootPane;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("nulle");
	}
	
	@FXML
	public void choixJoueur(MouseEvent mouseEvent) throws IOException{
		
        Pane pane = FXMLLoader.load(getClass().getResource("../ressources/jouerSonTour4.fxml"));
       rootPane.getChildren().setAll(pane);

    }
	@FXML
	public void equipementVole(MouseEvent mouseEvent) throws IOException{
		
        Pane pane = FXMLLoader.load(getClass().getResource("../ressources/jouerSonTour5.fxml"));
       rootPane.getChildren().setAll(pane);

    }
}
