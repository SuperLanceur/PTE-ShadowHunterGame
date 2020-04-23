package ihm.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class MenuController implements Initializable{
	@FXML private Pane rootPane;
	@FXML private ImageView titre;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		FileInputStream input;
		try {
			input = new FileInputStream("src\\ihm\\ressources\\img\\logo.png");
			Image image = new Image(input);
			titre.setImage(image);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void commencerPartie(MouseEvent mouseEvent) throws IOException{
		System.out.println("Passage � l'�cran de choix des joueurs");
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../ressources/Choix_joueur.fxml"));
        rootPane.getChildren().setAll(pane);
       
    }
    
    public void afficherRegle(MouseEvent mouseEvent) {
    	System.out.println("blaaaa");
    
    }
}
