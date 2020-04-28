package ihm.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import ihm.Musique;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class ParametreController implements Initializable  {
	@FXML private Pane rootPane;
	@FXML private CheckBox cmusique;
	@FXML private CheckBox clair;
	@FXML private ComboBox<String> langues;
	AudioInputStream musique;
	Clip clip;
	
	
	String filepath = "src//ihm//ressources//musique//The_Red_Fox_Tavern.wav"; // lien vers la musique :
	File files=new File("src//ihm//ressources//musique//The_Red_Fox_Tavern.wav");
	
	
	
	 
	
	File repertoire = new File("src//ihm//ressources");
	 
     String liste[] = repertoire.list();  
	// https://www.youtube.com/watch?v=LBpKUIyOHdo
	
	



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		langues.getItems().add("Anglais");
		langues.getItems().add("Allemand");
		langues.getItems().add("Espagnol");
		langues.getItems().add("Français");

		
		
	}
	
	@FXML
	public void enregistre(MouseEvent mouseEvent) throws IOException, Exception{
		if(files.exists()) {
			try {
				
				clip=AudioSystem.getClip();
				clip.open(AudioSystem.getAudioInputStream(files));
			
				
				if(cmusique.isSelected()==true) {

					
					
					clip.start();
					clip.loop(Clip.LOOP_CONTINUOUSLY);
				
					
					
					
				}
				else {
					AudioSystem.getAudioInputStream(files).close();
					clip.close();

					
				}
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		/*	if(clair.isSelected()) {
				Pane root = FXMLLoader.load(getClass().getResource("ressources/parametre.fxml"));
				root.setStyle("ressources/style/menuLight.css");
				  if (liste != null) {         
			            for (int i = 0; i < liste.length; i++) {
			                System.out.println(liste[i]);
			                Pane root1 = FXMLLoader.load(getClass().getResource(liste[i]));
							root1.setStyle("ressources/style/menuLight.css");
			            }
			} 
		
		
	} */

}
}
