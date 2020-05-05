package ihm.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class PiocherVisionController implements Initializable{
	@FXML private Pane rootPane;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	@FXML
	public void voirCarte(MouseEvent mouseEvent) throws IOException{
		
	   final URL fxmlURL = getClass().getResource("/ihm/ressources/jouer_Son_Tour_donner_vision.fxml");  
	   final ResourceBundle bundle = ResourceBundle.getBundle("domaine.properties.langue", Locale.FRANCE);
	   final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL, bundle);
       Pane pane = fxmlLoader.load();
      
       rootPane.getChildren().setAll(pane);

    }

}
