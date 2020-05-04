package ihm.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import ihm.EffetSonore;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MenuController  implements Initializable{
	@FXML private AnchorPane rootPane;
	@FXML private ImageView titre;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		InputStream input;
			input = getClass().getResourceAsStream("/ihm/ressources/img/logo.png");
			Image image = new Image(input);
			titre.setImage(image);
	}

	@FXML
	public void commencerPartie(MouseEvent mouseEvent) throws IOException{
		
		EffetSonore.playSoundEffect("src//ihm//ressources//musique//BEEP1.wav");
		
		System.out.println("Passage à l'écran de choix des joueurs");
		final URL fxmlURL = getClass().getResource("/ihm/ressources/Choix_joueur.fxml");
		final ResourceBundle bundle = ResourceBundle.getBundle("domaine.properties.langue", Locale.FRANCE);
		final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL, bundle);
        AnchorPane pane = fxmlLoader.load();
        Scene scene = new Scene(pane);
        Stage appStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
        
       
    }
    
    public void afficherRegle(MouseEvent mouseEvent) {
    	EffetSonore.playSoundEffect("src//ihm//ressources//musique//BEEP1.wav");
    	System.out.println("blaaaa");
    
    }
}
