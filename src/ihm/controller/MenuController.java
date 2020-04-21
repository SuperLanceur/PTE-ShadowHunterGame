package ihm.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class MenuController implements Initializable{
	@FXML private Pane rootPane;
	@FXML private ImageView titre;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		//Image image = new Image("../ressources/img/logo.png");
		//titre.setImage(image);
	}

	@FXML
	public void commencerPartie(MouseEvent mouseEvent) throws IOException{
		System.out.println("Passage à l'�cran de choix des joueurs");
        BorderPane pane = FXMLLoader.load(getClass().getResource("../ressources/Choix_joueur.fxml"));
        rootPane.getChildren().setAll(pane);
    }
    
    public void afficherRegle(MouseEvent mouseEvent) {
    	System.out.println("blaaaa");
    }
}
