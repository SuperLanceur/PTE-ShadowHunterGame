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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ReglesControlleur implements Initializable {

	@FXML
	private AnchorPane rootPane;
	@FXML
	private ImageView imageRegles;

	private int index = 1;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		InputStream input = getClass().getResourceAsStream("/ihm/ressources/img/Regle1.png");
		Image image = new Image(input);
		imageRegles.setImage(image);

	}

	@FXML
	public void pageSuivante(MouseEvent mouseEvent) throws IOException {

		if (index < 4) {
			index++;
			InputStream fileSound1 = getClass().getResourceAsStream("/ihm/ressources/musique/BEEP1.wav");
			EffetSonore.playSoundEffect(fileSound1);
			System.out.println("Page suivante");
		} else {
			InputStream fileSound2 = getClass().getResourceAsStream("/ihm/ressources/musique/BeepError.wav");
			EffetSonore.playSoundEffect(fileSound2);
			System.out.println("C'est la dernière page!");
		}

		InputStream input = getClass().getResourceAsStream("/ihm/ressources/img/Regle" + index + ".png");
		Image image = new Image(input);
		imageRegles.setImage(image);

	}

	@FXML
	public void pagePrecedente(MouseEvent mouseEvent) throws IOException {

		if (index > 1) {
			index--;
			InputStream fileSound1 = getClass().getResourceAsStream("/ihm/ressources/musique/BEEP1.wav");
			EffetSonore.playSoundEffect(fileSound1);
			System.out.println("Page précédente");
		} else {
			InputStream fileSound2 = getClass().getResourceAsStream("/ihm/ressources/musique/BeepError.wav");
			EffetSonore.playSoundEffect(fileSound2);
			System.out.println("C'est la première page!");
		}

		InputStream input = getClass().getResourceAsStream("/ihm/ressources/img/Regle" + index + ".png");
		Image image = new Image(input);
		imageRegles.setImage(image);

	}

	@FXML
	public void retourMenu(MouseEvent mouseEvent) throws IOException {

		InputStream fileSound1 = getClass().getResourceAsStream("/ihm/ressources/musique/BEEP1.wav");

		EffetSonore.playSoundEffect(fileSound1);
		System.out.println("Retour au Menu");
		final URL fxmlURL = getClass().getResource("/ihm/ressources/Menu.fxml");
		final ResourceBundle bundle = ResourceBundle.getBundle("domaine.properties.langue", Locale.FRANCE);
		final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL, bundle);
		AnchorPane pane = fxmlLoader.load();
		Scene scene = new Scene(pane);
		Stage appStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
		appStage.setScene(scene);
		appStage.show();

	}

}
