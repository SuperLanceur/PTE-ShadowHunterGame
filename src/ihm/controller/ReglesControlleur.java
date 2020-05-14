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
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sun.util.resources.Bundles;

public class ReglesControlleur implements Initializable {

	@FXML
	private AnchorPane rootPane;
	@FXML
	private ImageView imageRegles;
	@FXML
	private Button precedent;
	@FXML
	private Button suivant;

	private int index = 1;
	
	private ResourceBundle bundle = ResourceBundle.getBundle("domaine.properties.langue", ParametreController.LaLangue);

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		InputStream input = getClass().getResourceAsStream("/ihm/ressources/img/Regle1.PNG");
		Image image = new Image(input);
		imageRegles.setImage(image);
		suivant.setVisible(true);
		precedent.setVisible(false);

	}

	@FXML
	public void pageSuivante(MouseEvent mouseEvent) throws IOException {

		if (index < 4) {

			if (index == 3) {
				suivant.setVisible(false);
			} else {
				suivant.setVisible(true);
			}

			precedent.setVisible(true);
			index++;
			InputStream fileSound1 = getClass().getResourceAsStream("/ihm/ressources/musique/BEEP1.wav");
			EffetSonore.playSoundEffect(fileSound1);
			System.out.println(bundle.getString("page.suivante"));
		}

		InputStream input = getClass().getResourceAsStream("/ihm/ressources/img/Regle" + index + ".PNG");
		Image image = new Image(input);
		imageRegles.setImage(image);

	}

	@FXML
	public void pagePrecedente(MouseEvent mouseEvent) throws IOException {

		if (index > 1) {

			if (index == 2) {
				precedent.setVisible(false);
			} else {
				precedent.setVisible(true);
			}

			index--;
			suivant.setVisible(true);
			InputStream fileSound1 = getClass().getResourceAsStream("/ihm/ressources/musique/BEEP1.wav");
			EffetSonore.playSoundEffect(fileSound1);

			System.out.println(bundle.getString("page.precedente"));
		}

		InputStream input = getClass().getResourceAsStream("/ihm/ressources/img/Regle" + index + ".PNG");
		Image image = new Image(input);
		imageRegles.setImage(image);

	}

	@FXML
	public void retourMenu(MouseEvent mouseEvent) throws IOException {

		InputStream fileSound1 = getClass().getResourceAsStream("/ihm/ressources/musique/BEEP1.wav");

		EffetSonore.playSoundEffect(fileSound1);
		System.out.println(bundle.getString("retour.menu"));
		final URL fxmlURL = getClass().getResource("/ihm/ressources/Menu.fxml");
		final ResourceBundle bundle = ResourceBundle.getBundle("domaine.properties.langue", ParametreController.LaLangue);
		final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL, bundle);
		AnchorPane pane = fxmlLoader.load();
		Scene scene = new Scene(pane);
		Stage appStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
		appStage.setScene(scene);
		appStage.show();

	}

	@FXML
	public void retourEnJeu(MouseEvent me) throws IOException {

		InputStream fileSound1 = getClass().getResourceAsStream("/ihm/ressources/musique/BEEP1.wav");

		EffetSonore.playSoundEffect(fileSound1);
		System.out.println(bundle.getString("retour.jeu"));

		Stage appStage = (Stage) ((Node) me.getSource()).getScene().getWindow();
		appStage.close();

	}

}
