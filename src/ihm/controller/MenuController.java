package ihm.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class MenuController {
	@FXML
    private Label label;

    public void commencerPartie(MouseEvent mouseEvent) {
        System.out.println("Bonjouuuuur!");
    }
    
    public void afficherRegle(MouseEvent mouseEvent) {
    	System.out.println("clik");
    }
}
