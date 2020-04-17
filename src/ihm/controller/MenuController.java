package ihm.controller;

import ihm.FxmlLoader;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MenuController {
	private Stage window;

   public void commencerPartie(MouseEvent mouseEvent) {
        System.out.println("Bonjouuuuur!");
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("Choix_joueur");
        Scene scene = new Scene(view);
        window.setScene(scene);
    }
    
    public void afficherRegle(MouseEvent mouseEvent) {
    	System.out.println("blaaaa");
    }
}
