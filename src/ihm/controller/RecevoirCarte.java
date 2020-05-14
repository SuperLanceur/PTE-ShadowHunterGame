package ihm.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.util.Duration;
import main.GestionnaireJeu;

public class RecevoirCarte implements Initializable {
	@FXML
	private Button okButton;
	@FXML
	private Label label;
	@FXML
	private ImageView imageView;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		okButton.setOnAction(x -> {
			GestionnaireJeu.notifyPlateau();
		});

	}

	public void setText(String name) {
		this.label.setText(name);
	}

	public void setImageView(Image imageCarte) {
		AnchorPane ap = (AnchorPane) imageView.getParent();

		BackgroundImage myBI = new BackgroundImage(imageCarte, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, 1.0, true, true, false, false));
		ap.setBackground(new Background(myBI));
	}

	public void fireBtnIA() {
		okButton.setDisable(true);
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(2000), ae -> {
			okButton.setDisable(false);
			okButton.fire();
		}));
		timeline.play();
	}
}
