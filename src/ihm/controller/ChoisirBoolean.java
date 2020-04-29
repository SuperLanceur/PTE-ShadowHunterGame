package ihm.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ihm.PopUpBoolean;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ChoisirBoolean implements Initializable{
	@FXML private Pane rootPane;
	
	@FXML private Button ouiButton;
	@FXML private Button nonButton;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
	}
	
	@FXML 
	public void choixOui(MouseEvent mouseEvent) throws IOException{
		PopUpBoolean.result = true;
		final Node source = (Node) mouseEvent.getSource();
	    final Stage stage = (Stage) source.getScene().getWindow();
	    stage.close();
	}
	
	@FXML 
	public void choixNon(MouseEvent mouseEvent) throws IOException{
		
		PopUpBoolean.result = false;
		final Node source = (Node) mouseEvent.getSource();
	    final Stage stage = (Stage) source.getScene().getWindow();
	    stage.close();
	}
}
