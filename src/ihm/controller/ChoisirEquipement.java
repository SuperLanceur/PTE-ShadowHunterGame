package ihm.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import carte.CarteEquipement;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import main.GestionnaireJeu;

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
			
			hbox.getChildren().add(iv);
			
			iv.fitHeightProperty().bind(hbox.heightProperty());
			//iv.fitWidthProperty().bind(scrollpane.widthProperty());
			iv.setPreserveRatio(true);
			iv.setOnMouseClicked(e -> {
				equipementSelected = ce;
				GestionnaireJeu.notifyPlateau();
			});
		}
	}
}
