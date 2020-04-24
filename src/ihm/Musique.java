package ihm;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class Musique {
	
	public void  playMusique(String path) {
		
		try {
			
			File musicPath = new File(path);
			
			if( musicPath.exists()) {
				
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
				clip.loop(Clip.LOOP_CONTINUOUSLY);
				
			} else {
				System.out.println("le fichier audio n'est pas trouvé");
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
