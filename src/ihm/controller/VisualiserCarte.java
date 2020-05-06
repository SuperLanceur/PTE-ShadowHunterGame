package ihm.controller;

import java.net.URL;
import java.util.ResourceBundle;

import carte.Carte;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class VisualiserCarte implements Initializable{
	@FXML private Label typeCarte;
	@FXML private Label effetCarte;
	@FXML private ImageView imageCarte;
	
	private Carte carte;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		/*typeCarte.setText(carte.getNom());
		effetCarte.setText(carte.getDescription());*/
	}
	
	/**
	 * signe la fin du tour
	 * @param mouseEvent click n'importe ou sur la fenetre 
	 */
	@FXML
	private void fin (MouseEvent mouseEvent) {
		
	}

	public Label getTypeCarte() {
		return typeCarte;
	}

	public void setTypeCarte(Label typeCarte) {
		this.typeCarte = typeCarte;
	}

	public Label getEffetCarte() {
		return effetCarte;
	}

	public void setEffetCarte(Label effetCarte) {
		this.effetCarte = effetCarte;
	}

	public ImageView getImageCarte() {
		return imageCarte;
	}

	public void setImageCarte(ImageView imageCarte) {
		this.imageCarte = imageCarte;
	}

	public Carte getCarte() {
		return carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}
	
	
	
}
