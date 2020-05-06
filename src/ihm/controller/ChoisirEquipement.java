package ihm.controller;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import carte.CarteEquipement;

public class ChoisirEquipement implements Initializable{
	@FXML private GridPane grilleEquipement;
	
	private List<CarteEquipement> equipements = new ArrayList<CarteEquipement>();
	private CarteEquipement equipementSelected;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		for (int i=0; i<equipements.size(); i++) {
			ImageView carte = (ImageView) grilleEquipement.getChildren().get(i);
			
			/*InputStream input = getClass().getResourceAsStream("/ihm/ressources/img/" + "nomcarte" + ".png");
			Image image = new Image(input);
			carte.setImage(image);*/
			
			int numEquipement = i;
			carte.setOnMouseClicked(e -> {
				equipementSelected = equipements.get(numEquipement);
			});
		}
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

}
