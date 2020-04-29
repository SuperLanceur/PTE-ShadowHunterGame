package ihm.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import ihm.Musique;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class ParametreController implements Initializable {
	@FXML
	private Pane rootPane;
	@FXML
	private CheckBox cmusique;
	@FXML
	private CheckBox clair;
	@FXML
	private ComboBox<String> langues;
	boolean coche = false; // verifi si la checbox musical est coche
	boolean MusiqueLancee = false; //verifi si la musique a déja été lancé une première fois

	String filepath = "src//ihm//ressources//musique//The_Red_Fox_Tavern.wav"; // lien vers la musique :
																				// https://www.youtube.com/watch?v=LBpKUIyOHdo
	File files = new File("src//ihm//ressources//musique//The_Red_Fox_Tavern.wav");

	File repertoire = new File("src//ihm//ressources");

	String liste[] = repertoire.list();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		langues.getItems().add("Anglais");
		langues.getItems().add("Allemand");
		langues.getItems().add("Espagnol");
		langues.getItems().add("Français");

	}

	@FXML
	public void enregistre(MouseEvent mouseEvent) throws IOException, Exception {

		if (files.exists()) {

			if (cmusique.isSelected() == true) {
				coche = true;
				if (Musique.clipTimePosition == 0 && MusiqueLancee == false) { // si la musique n'a jamais été lancé
					Musique.playMusique(filepath);
					MusiqueLancee = true;

				} else {
					Musique.resumeMusique(Musique.clip); // si elle a deja été lancé mais mis en pause, reprend a partir du point d'arret
				}

			} else {
				if (coche == true) {
					coche = false;
					Musique.pauseMusique(Musique.clip); //met en pause la musique 
				}

			}

		}
		

		/*
		 * if(clair.isSelected()) { Pane root =
		 * FXMLLoader.load(getClass().getResource("ressources/parametre.fxml"));
		 * root.setStyle("ressources/style/menuLight.css"); if (liste != null) { for
		 * (int i = 0; i < liste.length; i++) { System.out.println(liste[i]); Pane root1
		 * = FXMLLoader.load(getClass().getResource(liste[i]));
		 * root1.setStyle("ressources/style/menuLight.css"); } }
		 * 
		 * 
		 * }
		 */
		
		final URL fxmlURL = getClass().getResource("../ressources/Jouer_tour(3)attaquer.fxml");
		final ResourceBundle bundle = ResourceBundle.getBundle("domaine.properties.langue", Locale.ENGLISH);
		final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL, bundle);
		Pane pane = fxmlLoader.load();

        rootPane.getChildren().setAll(pane);

	}
}
