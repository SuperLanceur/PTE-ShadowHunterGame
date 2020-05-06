package ihm.controller;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class VisualiserCarteVision extends VisualiserCarte{
	@FXML 
	public void voirCarte(MouseEvent mouseEvent) {
		//super.getImageCarte().setImage(arg0);
		System.out.println("\tCarte vision");
	}
}
