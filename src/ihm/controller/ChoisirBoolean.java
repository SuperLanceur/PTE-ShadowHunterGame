package ihm.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;
import main.Contexte;
import main.ControleurIA;
import main.GestionnaireJeu;
import main.Joueur;
import main.JoueurVirtuel;
import sun.util.resources.Bundles;

public class ChoisirBoolean implements Initializable {
	@FXML
	private Button ouiButton;
	@FXML
	private Button nonButton;
	@FXML
	private Label titre;

	private boolean result;

	private ResourceBundle bundle1 = ResourceBundle.getBundle("domaine.properties.langue", ParametreController.LaLangue);
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		ouiButton.setOnAction(x -> {

			this.result = true;
			GestionnaireJeu.notifyPlateau();
		});

		nonButton.setOnAction(x -> {
			this.result = false;
			GestionnaireJeu.notifyPlateau();
		});
	}

	public boolean getResult() {
		return this.result;
	}

	public Button getOuiButton() {
		return ouiButton;
	}

	public void setOuiButton(Button ouiButton) {
		this.ouiButton = ouiButton;
	}

	public Button getNonButton() {
		return nonButton;
	}

	public void setNonButton(Button nonButton) {
		this.nonButton = nonButton;
	}

	public Label getTitre() {
		return titre;
	}

	public void setTitre(Contexte c) {
		switch(c) {
		case ATTAQUER: 
			titre.setText(bundle1.getString("souhaiter.vous.attaquer.qq"));
			break;
		case ACTIVER_EFFET_LIEU	:
			titre.setText(bundle1.getString("souhaiter.vous.activer.effet.lieu"));
			break;
		case CHOISIR_VISION	:
			titre.setText(bundle1.getString("souhaiter.vous.activer.carte.vision"));
			break;
		default:
		}
		
	}

	public void fireBtnIAEffetLieu() {
		ControleurIA cIA = new ControleurIA();
		ouiButton.setDisable(true);
		nonButton.setDisable(true);
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(2000), ae -> {
			if (cIA.choixUtiliserPouvoirLieu()) {
				ouiButton.setDisable(false);
				ouiButton.fire();
			} else {
				nonButton.setDisable(false);
				nonButton.fire();
			}
		}));
		timeline.play();
	}
	
	public void fireBtnIAVision() {
		ControleurIA cIA = new ControleurIA();
		ouiButton.setDisable(true);
		nonButton.setDisable(true);
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(2000), ae -> {
			if (cIA.mentirIAMetamorphe()) {
				ouiButton.setDisable(false);
				ouiButton.fire();
			} else {
				nonButton.setDisable(false);
				nonButton.fire();
			}
		}));
		timeline.play();
	}
	
	public void fireBtnIAattaquer(JoueurVirtuel jIA, List<Joueur> joueursLieu) {
		ControleurIA cIA = new ControleurIA();
		ouiButton.setDisable(true);
		nonButton.setDisable(true);
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(2000), ae -> {
			if (cIA.choixSiAttaquer(jIA, joueursLieu)) {
				ouiButton.setDisable(false);
				ouiButton.fire();
			} else {
				nonButton.setDisable(false);
				nonButton.fire();
			}
		}));
		timeline.play();
	}
}
