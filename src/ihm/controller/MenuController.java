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
import javafx.stage.Stage;

public class MenuController implements Initializable{
	@FXML
	private Pane rootPane;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	@FXML
	public void commencerPartie(MouseEvent mouseEvent) throws IOException{
        System.out.println("Bonjouuuuur!");
        BorderPane pane = FXMLLoader.load(getClass().getResource("../ressources/Choix_joueur.fxml"));
        System.out.println(rootPane);
        rootPane.getChildren().setAll(pane);
    }
    
    public void afficherRegle(MouseEvent mouseEvent) {
    	System.out.println("blaaaa");
    }
}
