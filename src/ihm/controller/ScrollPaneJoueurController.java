package ihm.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class ScrollPaneJoueurController implements Initializable{
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
	}
	
	@FXML
	public void changeZoneJoueurToMenuJoueur(MouseEvent me) throws IOException {
		
		BorderPane bp = FXMLLoader.load(getClass().getResource("/ihm/ressources/MenuJoueur.fxml"));
		ImageView iv = ((ImageView)me.getSource());	
		Parent p = iv.getParent().getParent().getParent().getParent();
		AnchorPane ap = (AnchorPane)p;
		
		System.out.println(bp.getRotate()+" "+ ap.getRotate());
		ap.getChildren().setAll(bp);
		
		AnchorPane.setTopAnchor(bp, 0.0);
		AnchorPane.setBottomAnchor(bp, 0.0);
		AnchorPane.setLeftAnchor(bp, 0.0);
		AnchorPane.setRightAnchor(bp, 0.0);
		
	}
}
