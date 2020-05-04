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

public class MenuJoueurController implements Initializable{
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//nomJoueur.setText(joueur.getNom());
	}
	
	@FXML
	public void changeZoneToScrollPaneJoueur(MouseEvent me) throws IOException {
		
		AnchorPane bp = FXMLLoader.load(getClass().getResource("/ihm/ressources/ScrollPaneJoueur.fxml"));
		ImageView iv = ((ImageView)me.getSource());	
		Parent p = iv.getParent().getParent();
		AnchorPane ap = (AnchorPane)p;
		ap.getChildren().setAll(bp);
		AnchorPane.setTopAnchor(bp, 0.0);
		AnchorPane.setBottomAnchor(bp, 0.0);
		AnchorPane.setLeftAnchor(bp, 0.0);
		AnchorPane.setRightAnchor(bp, 0.0);
	}

}
