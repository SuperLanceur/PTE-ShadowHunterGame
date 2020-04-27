package ihm.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ihm.Musique;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class ParametreController implements Initializable{
	@FXML private Pane rootPane;
	@FXML private CheckBox cmusique;
	@FXML private CheckBox clair;
	@FXML private ComboBox<String> langues;



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		langues.getItems().add("Anglais");
		langues.getItems().add("Allemand");
		langues.getItems().add("Espagnol");
		langues.getItems().add("Français");



		
	}
	/*@FXML
	public void enregistre(MouseEvent mouseEvent) throws IOException{
		if(cmusique.isSelected()==true) {

			String filepath = "src//ihm//ressources//musique//The_Red_Fox_Tavern.wav"; // lien vers la musique :
																						// https://www.youtube.com/watch?v=LBpKUIyOHdo
			Musique musiqueObjet = new Musique();
			//musiqueObjet.playMusique(filepath);
			
			Pane root = FXMLLoader.load(getClass().getResource("ressources/parametre.fxml"));
			//root.setStyle("ressources/style/menuLight.css);
			
		}
		
	} */

}
