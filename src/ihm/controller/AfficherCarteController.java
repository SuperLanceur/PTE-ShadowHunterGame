package ihm.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class AfficherCarteController implements Initializable{
	
	@FXML private Label nom;
	@FXML private Label competence;
	@FXML private Pane root;
	
	private PlateauController plateau;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println(root.getUserData());
		//nom.setText((String) root.getUserData());
		competence.setText("dfghjk");
	}

}
