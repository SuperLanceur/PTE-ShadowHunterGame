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

public class JouerSonTour6Controller implements Initializable{
	@FXML private Pane rootPane;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	@FXML
	public void piocherVision(MouseEvent mouseEvent) throws IOException{

		final URL fxmlURL = getClass().getResource("../ressources/jouer_Son_Tour_piocher_vision.fxml");
		final ResourceBundle bundle = ResourceBundle.getBundle("domaine.properties.langue", Locale.FRANCE);
		final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL, bundle);
		Pane pane = fxmlLoader.load();
       rootPane.getChildren().setAll(pane);

    }
	@FXML
	public void piocherTenebre(MouseEvent mouseEvent) throws IOException{

		final URL fxmlURL = getClass().getResource("../ressources/jouer_Son_Tour_piocher_lum_et_ten.fxml");
		final ResourceBundle bundle = ResourceBundle.getBundle("domaine.properties.langue", Locale.FRANCE);
		final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL, bundle);
		Pane pane = fxmlLoader.load();
       rootPane.getChildren().setAll(pane);

    }
}
