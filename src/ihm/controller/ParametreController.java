package ihm.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import ihm.EffetSonore;
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
	private CheckBox cbEffetSonore;
	@FXML
	private CheckBox clair;
	@FXML
	private ComboBox<String> langues;
	public static Locale LaLangue = Locale.FRANCE;
	public static boolean cbMusiqueCoche = false; // verifi si la checbox musical est coche
	public static boolean cbSonCoche = false;
	public static boolean cbClair = false;

	boolean MusiqueLancee = false; //verifi si la musique a déja été lancé une première fois
	
	String filepathMusique = "/ihm/ressources/musique/The_Red_Fox_Tavern.wav"; // lien vers la musique : https://www.youtube.com/watch?v=LBpKUIyOHdo
	InputStream fileMusique =  getClass().getResourceAsStream("/ihm/ressources/musique/The_Red_Fox_Tavern.wav");


	File repertoire = new File("src//ihm//ressources");
	File repertoire2;
	String liste[] = repertoire.list();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	cmusique.setSelected(cbMusiqueCoche);
	cbEffetSonore.setSelected(cbSonCoche);
	clair.setSelected(cbClair);



		langues.getItems().add("Anglais");
		langues.getItems().add("Allemand");
		langues.getItems().add("Espagnol");
		langues.getItems().add("Français");

	}

	@FXML
	public void enregistre(MouseEvent mouseEvent) throws IOException, Exception {
		
		InputStream fileSound1 =  getClass().getResourceAsStream("/ihm/ressources/musique/BEEP1.wav");

		if(langues.getValue()=="Anglais") {
			LaLangue=Locale.ENGLISH;
		}
		else if(langues.getValue()=="Français") {
			LaLangue=Locale.FRANCE;
		}
		//Pour la musique
		if (fileMusique!=null) {

			if (cmusique.isSelected() == true) {
				cbMusiqueCoche = true;
				if (Musique.clipTimePosition == 0 && MusiqueLancee == false && Musique.musiqueEnCours != true) { // si la musique n'a jamais été lancé
					Musique.playMusique(fileMusique);
					Musique.musiqueEnCours = true;
					MusiqueLancee = true;

				} else if (Musique.musiqueEnCours != true) {
					Musique.resumeMusique(Musique.clip); // si elle a deja été lancé mais mis en pause, reprend a partir du point d'arret
				}

			} else {
				if (cbMusiqueCoche == true) {
					cbMusiqueCoche = false;
					Musique.pauseMusique(Musique.clip); //met en pause la musique 
					Musique.musiqueEnCours = false;
				}

			}

		}
		
		//Pour les effets sonores
		if (cbEffetSonore.isSelected() == true) {
			EffetSonore.setSoundOK(true);
			cbSonCoche = true;
			
			System.out.println(EffetSonore.isSoundOK());
		}
		
		else {
			EffetSonore.setSoundOK(false);
			cbSonCoche = false;
			System.out.println(EffetSonore.isSoundOK());
		}
		
			
		

		// Pour la couleur du theme
		
				/*
				if (clair.isSelected()) {
					//Pane root = FXMLLoader.load(getClass().getResource("../ressources/parametre.fxml"));
					//root.setStyle("ressources/style/menuLight.css");

					if (liste != null) {
						for (int i = 0; i < liste.length; i++) {

							System.out.println(liste[i]);
							System.out.println(i);
							repertoire2 = new File("../ressources/" + liste[i]);

							if (repertoire.isDirectory() == false) {
								if (liste[i] == "Plateau.fxml") {
									Pane root1 = FXMLLoader.load(getClass().getResource("../ressources/" + liste[i]));
									root1.setStyle("../ressources/style/plateau.css");

								}
								Pane root1 = FXMLLoader.load(getClass().getResource("../ressources/" + liste[i]));
								root1.setStyle("../ressources/style/menuLight.css");
							}
						}

					}

				}*/

		EffetSonore.playSoundEffect(fileSound1); //emet un bruit sur le bouton si les effets sonores sont activés
		
		// Quitter les paramètres		
	    final URL fxmlURL = getClass().getResource("/ihm/ressources/Menu.fxml");
		final ResourceBundle bundle = ResourceBundle.getBundle("domaine.properties.langue", ParametreController.LaLangue);
		
		final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL, bundle);
		Pane pane = fxmlLoader.load();

        rootPane.getChildren().setAll(pane);
		
		

	}
	
	@FXML
	public void monterVolume(MouseEvent mouseEvent) throws IOException{
		Musique.volumeUp(5.f);
		System.out.println("on monte le son");
	}
	
	@FXML
	public void baisserVolume(MouseEvent mouseEvent) throws IOException{
		Musique.volumeDown(5.f);
		System.out.println("on baisse le son");
	}

}
