package ihm.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class PlayersController implements Initializable{
	@FXML
	private BorderPane rootPane;
	@FXML
	private TextField tf;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		tf.setEditable(false);
	}

	@FXML
	public void commencerJeux(MouseEvent mouseEvent) throws IOException{
		System.out.println("Lancement du jeu...");
        BorderPane pane = FXMLLoader.load(getClass().getResource("../ressources/Plateau.fxml"));
        rootPane.getChildren().setAll(pane);
	}
	@FXML
	public void ajoutJoueur(MouseEvent mouseEvent) throws IOException{
		tf.setEditable(true);
	}
	
}
