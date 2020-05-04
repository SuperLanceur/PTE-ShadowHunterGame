package ihm.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import carte.CarteLieu;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class JouerSonTour2Controller implements Initializable{
	private CarteLieu lieu;
	
	@FXML private Pane rootPane;
	@FXML private Label descriptionLieu;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("\tDescrption du lieux");
		//descriptionLieu.setText(lieu.getDescription());
	}
	
	@FXML
	public void ignorerEtape(MouseEvent mouseEvent) throws IOException{
       Pane pane = FXMLLoader.load(getClass().getResource("/ihm/ressources/Jouer_tour(3)attaquer.fxml"));
       rootPane.getChildren().setAll(pane);
    }
	
	@FXML
	public void capaciteLieu(MouseEvent mouseEvent) throws IOException{
		/*//si le lieu fait attaquer ou se soigner
		if (lieu.getNom().compareTo("foret hantee")) {
			Pane pane = FXMLLoader.load(getClass().getResource("../ressources/Jouer_tour(2c)attaquer_soigner.fxml"));
	        rootPane.getChildren().setAll(pane);
	    //si le lieu fait voler une carte equipement
		}else if(lieu.getNom().compareTo("sanctuaire ancien")) {
			Pane pane = FXMLLoader.load(getClass().getResource("../ressources/Jouer_tour(2a)voler_equipement.fxml"));
	        rootPane.getChildren().setAll(pane);
	    //si le lieu fait piocher une carte
		}else {
			Pane pane = FXMLLoader.load(getClass().getResource("../ressources/Jouer_tour(2b)piocher_carte.fxml"));
	        rootPane.getChildren().setAll(pane);
		}*/
    }
	
}