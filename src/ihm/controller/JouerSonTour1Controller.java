package ihm.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class JouerSonTour1Controller implements Initializable{
	@FXML private Pane rootPane;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
	}
	@FXML 
	public void lancerDes(MouseEvent mouseEvent) throws IOException{
	
		Pane pane = FXMLLoader.load(getClass().getResource("../ressources/jouerSonTour2.fxml"));
        rootPane.getChildren().setAll(pane);
	}
}
