package ihm.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import ihm.EffetSonore;
import ihm.Musique;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class PauseController implements Initializable{
	@FXML private CheckBox cbMusique;
	@FXML private CheckBox cbEffet;
	
	String filepathMusique = "src//ihm//ressources//musique//The_Red_Fox_Tavern.wav";
	InputStream fileInput = getClass().getResourceAsStream("src//ihm//ressources//musique//The_Red_Fox_Tavern.wav");
	File fileMusique = new File("src//ihm//ressources//musique//The_Red_Fox_Tavern.wav");
	
	public EffetSonore soundEffects = new EffetSonore();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML 
	public void reprendre(MouseEvent me) {
		//Pour la musique
		boolean MusiqueLancee = false;
		if (fileMusique.exists()) {
			if (cbMusique.isSelected()) {
				System.out.println("\tLancement de la musique");
				if (Musique.clipTimePosition == 0 && MusiqueLancee == false) { // si la musique n'a jamais été lancé
					Musique.playMusique(fileInput);
					MusiqueLancee = true;
				} else Musique.resumeMusique(Musique.clip); // si elle a deja été lancé mais mis en pause, reprend a partir du point d'arret
			} else {
				Musique.pauseMusique(Musique.clip); //met en pause la musique 
				System.out.println("\tMise en pause de la musique");
			}
		}
				
		//Pour les effets sonores
		if (cbEffet.isSelected() == true) {
			System.out.println("\tEffets sonores activé");
			soundEffects.setSoundOK(true);
		}else {
			System.out.println("\tEffets sonores désactivé");
			soundEffects.setSoundOK(false);
		}
				
		soundEffects.playSoundEffect("src//ihm//ressources//musique//BEEP1.wav"); //met un bruit sur le bouton si les effets sonores sont activés
		
		System.out.println("Retour au jeu");
		Stage appStage = (Stage) ((Node) me.getSource()).getScene().getWindow();
		appStage.close();
	}
	
	
	@FXML 
	public void quitter(MouseEvent me) throws IOException {
		System.err.println("Fin de partie");
		Stage appStage = (Stage) ((Node) me.getSource()).getScene().getWindow();
		appStage.close();
		
		
	}
}
