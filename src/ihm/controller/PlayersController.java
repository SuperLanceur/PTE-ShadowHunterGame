package ihm.controller;



import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class PlayersController implements Initializable{

	@FXML private BorderPane rootPane;
	@FXML private TextField tf;
	@FXML private VBox vb1;
	@FXML private VBox vb2;
	private HBox hb10;
	private HBox hb11;
    private HBox hb12;
    private HBox hb13;
    private TextField tf0;
    private Button btn;

	
	
	
	
	

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		for(int i=0;i<4;i++) {
			hb10=(HBox) vb1.getChildren().get(i);
			tf0=(TextField) hb10.getChildren().get(0);
			
			tf0.setEditable(false);
			
			}
		for(int i=0;i<4;i++) {
			hb10=(HBox) vb1.getChildren().get(i);
			tf0=(TextField) hb10.getChildren().get(0);
			btn=(Button) hb10.getChildren().get(1);
			btn.setOnAction((e) -> {
				tf0.setEditable(true);});
			
		}
		
	}
			//liaison.put( (Button)vb11.getChildren().get(i), maListe);
			

		
		
		
		//Partie2 pas prendre en compte pour le moment
	
		
	@FXML
	public void commencerJeux(MouseEvent mouseEvent) throws IOException{
		System.out.println("Lancement du jeu...");
        BorderPane pane = FXMLLoader.load(getClass().getResource("../ressources/Plateau.fxml"));
        rootPane.getChildren().setAll(pane);
	}
	@FXML
	public void ajoutJoueur(MouseEvent mouseEvent) throws IOException{
		tf.setEditable(true);
	}
	
}
