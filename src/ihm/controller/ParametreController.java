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
import javafx.scene.control.Slider;
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
	private ComboBox<String> langues;

	@FXML
	private Slider sliderMusique;
	@FXML
	private Slider sliderEffets;

	public static Locale LaLangue = Locale.FRANCE;
	public static boolean cbMusiqueCoche = false; // verifi si la checbox musical est coche
	public static boolean cbSonCoche = false;
	
	public static double slideValue;
	public static double slideValueEffets;
	public static String langueChoisi;

	private String tabLangues[] = { "Anglais", "Italien", "Espagnol", "Français" };

	boolean MusiqueLancee = false; // verifi si la musique a déja été lancé une première fois

	String filepathMusique = "/ihm/ressources/musique/The_Red_Fox_Tavern.wav"; // lien vers la musique :
																				// https://www.youtube.com/watch?v=LBpKUIyOHdo
	InputStream fileMusique = getClass().getResourceAsStream("/ihm/ressources/musique/The_Red_Fox_Tavern.wav");

	File repertoire = new File("src//ihm//ressources");
	File repertoire2;
	String liste[] = repertoire.list();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		cmusique.setSelected(cbMusiqueCoche);
		cbEffetSonore.setSelected(cbSonCoche);
		
		sliderMusique.setValue(slideValue);
		sliderEffets.setValue(slideValueEffets);

		System.out.println("slidevalueeffet init = " + slideValueEffets);

		langues.getItems().add(tabLangues[0]);
		langues.getItems().add(tabLangues[1]);
		langues.getItems().add(tabLangues[2]);
		langues.getItems().add(tabLangues[3]);

		if (langueChoisi == null) {
			langues.setValue("Français");
		} else {
			langues.setValue(langueChoisi);
		}

	}

	@FXML
	public void enregistre(MouseEvent mouseEvent) throws IOException, Exception {

		InputStream fileSound1 = getClass().getResourceAsStream("/ihm/ressources/musique/BEEP1.wav");

		// Pour les langues
		if (langues.getValue() == "Anglais") {
			LaLangue = Locale.ENGLISH;
			langueChoisi = tabLangues[0];
		} else if (langues.getValue() == "Français") {
			LaLangue = Locale.FRANCE;
			langueChoisi = tabLangues[3];
		}
		else if (langues.getValue() == "Espagnol") {
			LaLangue = Locale.GERMAN;
			langueChoisi = tabLangues[2];
		}
		else if (langues.getValue() == "Italien") {
			LaLangue = Locale.ITALIAN;
			langueChoisi = tabLangues[1];
		}
		// Pour la musique
		if (fileMusique != null) {


			if (cmusique.isSelected() == true) {
				cbMusiqueCoche = true;

				// si la musique n'a jamais été lancé:
				if (Musique.clipTimePosition == 0 && MusiqueLancee == false && Musique.musiqueEnCours != true) {
					Musique.playMusique(fileMusique);
					Musique.musiqueEnCours = true;
					MusiqueLancee = true;
					Musique.setVolume(sliderMusique.getValue());

				} 
				// si elle a deja été lancé mais mis en pause, reprend a partir du point d'arret :
				else if (Musique.musiqueEnCours != true) {
					Musique.resumeMusique(Musique.clip); 															
					Musique.musiqueEnCours = true;
					Musique.setVolume(sliderMusique.getValue());
				}

			} else {
				if (cbMusiqueCoche == true) {
					cbMusiqueCoche = false;
					Musique.pauseMusique(Musique.clip); // met en pause la musique
					Musique.musiqueEnCours = false;
				}

			}

		}

		// Pour les effets sonores
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

		

		
		// Quitter les paramètres
		EffetSonore.playSoundEffect(fileSound1); // emet un bruit sur le bouton si les effets sonores sont activés
	
		final URL fxmlURL = getClass().getResource("/ihm/ressources/Menu.fxml");
		final ResourceBundle bundle = ResourceBundle.getBundle("domaine.properties.langue",
				ParametreController.LaLangue);

		final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL, bundle);
		Pane pane = fxmlLoader.load();

		rootPane.getChildren().setAll(pane);

	}

	@FXML
	public void slideVolumeMusique(MouseEvent mouseEvent) throws IOException {

		if (Musique.musiqueEnCours == true) {
			Musique.setVolume(sliderMusique.getValue());
			slideValue = sliderMusique.getValue();

		}
		else {
			slideValue = sliderMusique.getValue();
		}


	}

	public void slideVolumeEffet(MouseEvent mouseEvent) throws IOException {

		EffetSonore.setVolumeEffets(sliderEffets.getValue());
		slideValueEffets = sliderEffets.getValue();

	}

	/*
	 * 
	 * @FXML public void monterVolume(MouseEvent mouseEvent) throws IOException{
	 * Musique.volumeUp(5.f); System.out.println("on monte le son"); }
	 * 
	 * @FXML public void baisserVolume(MouseEvent mouseEvent) throws IOException{
	 * Musique.volumeDown(5.f); System.out.println("on baisse le son"); }
	 */

}
