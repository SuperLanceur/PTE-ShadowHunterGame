package ihm.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import carte.CarteEquipement;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;
import main.Contexte;
import main.GestionnaireJeu;
import main.Joueur;
import main.JoueurVirtuel;

public class ChoisirEquipement implements Initializable{
	@FXML private GridPane grilleEquipement;
	@FXML private HBox hbox;
	
	private List<CarteEquipement> equipements = new ArrayList<CarteEquipement>();
	private CarteEquipement equipementSelected;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	public List<CarteEquipement> getEquipements() {
		return equipements;
	}

	public void setEquipements(List<CarteEquipement> equipements) {
		this.equipements = equipements;
	}

	public CarteEquipement getEquipementSelected() {
		return equipementSelected;
	}

	public void setEquipementSelected(CarteEquipement equipementSelected) {
		this.equipementSelected = equipementSelected;
	}

	public GridPane getGrilleEquipement() {
		return grilleEquipement;
	}

	public void setGrilleEquipement(GridPane grilleEquipement) {
		this.grilleEquipement = grilleEquipement;
	}
	
	public CarteEquipement getResult() {
		return equipementSelected;
	}

	public void setListCarteEquipements(List<CarteEquipement> lce) {
		this.equipements = lce;
	}
	
	public void initChoisirEquipement() {
		for (CarteEquipement ce : equipements) {
			
			ImageView iv = new ImageView(PlateauController.getImageCarte(ce));
			iv.setFitHeight(100);
			iv.setFitHeight(100);
			iv.setPreserveRatio(true);
			hbox.getChildren().add(iv);
			iv.setOnMouseClicked(e -> {
				equipementSelected = ce;
				GestionnaireJeu.notifyPlateau();
			});
		}
	}
	
	public void fireBtnIA(JoueurVirtuel jIA, Contexte c) {
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(2000), ae -> {
			equipementSelected = jIA.choisirEquipement(equipements);
			GestionnaireJeu.notifyPlateau();
		}));
		timeline.play();

	}
	
	
}
