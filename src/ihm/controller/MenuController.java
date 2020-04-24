package ihm.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.Node;

public class MenuController implements Initializable{
	@FXML private AnchorPane rootPane;
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
		System.out.println("Passage à l'écran de choix des joueurs");
		final URL fxmlURL = getClass().getResource("../ressources/Choix_joueur.fxml");
		final ResourceBundle bundle = ResourceBundle.getBundle("domaine.properties.langue", Locale.FRANCE);
		final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL, bundle);
		AnchorPane pane = fxmlLoader.load();
        Scene scene = new Scene(pane);
        Stage appStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }
    
    public void afficherRegle(MouseEvent mouseEvent) {
    	System.out.println("blaaaa");
    
    }
}
