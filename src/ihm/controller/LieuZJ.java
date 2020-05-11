package ihm.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.GestionnaireJeu;

public class LieuZJ implements Initializable {
	@FXML private Button okButton;
	@FXML private ImageView imageView;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		okButton.setOnAction(x -> {
			GestionnaireJeu.notifyPlateau();
		});
		
	}

	public void setImageView(Image imageCarte) {
		this.imageView.setImage(imageCarte);
	}
}
